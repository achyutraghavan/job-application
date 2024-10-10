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


}
