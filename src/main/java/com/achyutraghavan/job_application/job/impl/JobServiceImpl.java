package com.achyutraghavan.job_application.job.impl;

import com.achyutraghavan.job_application.job.Job;
import com.achyutraghavan.job_application.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public boolean deleteJobById(Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findJobById(Long id) {
        for (Job j: jobs) {
            if (j.getId().equals(id)) {
                return j;
            }
        }
        return null;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for (Job j: jobs) {
            if (j.getId().equals(id)) {
                j.setId(updatedJob.getId());
                j.setDescription(updatedJob.getDescription());
                j.setLocation(updatedJob.getLocation());
                j.setTitle(updatedJob.getTitle());
                j.setMinSalary(updatedJob.getMinSalary());
                j.setMaxSalary(updatedJob.getMaxSalary());
                return true;
            }
        }
        return false;
    }
}
