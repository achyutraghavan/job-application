package com.achyutraghavan.job_application.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
    }

    @GetMapping("jobs/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id) {
        Job resJob = jobService.findJobById(id);
        if (resJob!=null)
            return new ResponseEntity<>(jobService.findJobById(id), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if (isDeleted)
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean isUpdated = jobService.updateJob(id, updatedJob);
        if (isUpdated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
