package com.achyutraghavan.job_application.job.impl;

import com.achyutraghavan.job_application.job.Job;
import com.achyutraghavan.job_application.job.JobRepo;
import com.achyutraghavan.job_application.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepo.findById(id).orElse(null);
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepo.findById(id);
            if (jobOptional.isPresent()) {
                Job j = jobOptional.get();
                j.setDescription(updatedJob.getDescription());
                j.setLocation(updatedJob.getLocation());
                j.setTitle(updatedJob.getTitle());
                j.setMinSalary(updatedJob.getMinSalary());
                j.setMaxSalary(updatedJob.getMaxSalary());
                jobRepo.save(j);
                return true;
            }
        return false;
    }
}
