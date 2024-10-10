package com.achyutraghavan.job_application.job;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {
    List<Job> jobs;
    public List<Job> findAll() {
        return jobs;
    }
}
