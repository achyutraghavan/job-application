package com.achyutraghavan.job_application.job;

import java.util.List;

public interface JobService {
    boolean deleteJobById(Long id);
    List<Job> findAll();
    void createJob(Job job);
    Job findJobById(Long id);
    boolean updateJob(Long id, Job updatedJob);
}
