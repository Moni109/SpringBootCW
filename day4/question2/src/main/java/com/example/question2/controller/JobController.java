package com.example.question2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question2.model.Job;
import com.example.question2.service.JobService;

@RestController
@RequestMapping("/api/job")

public class JobController {
     private JobService jobService;
    public JobController(JobService jobService){
        this.jobService=jobService;
    }
     @PostMapping
     public ResponseEntity<Job> postJobDetails(@RequestBody Job job){
        Job jobsave =jobService.saveJobDetails(job);
        if(jobsave==null){
            return new ResponseEntity<>(jobsave,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(jobsave,HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Job>> displayJobs(){
        List<Job> jobs = jobService.getListOfJobs();
        if(jobs==null){
            return new ResponseEntity<>(jobs,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobs,HttpStatus.OK);
    }
    
    @GetMapping("/{jobId}")
    public ResponseEntity<Job> displaybyId(@PathVariable int jobId){
        Job jobs = jobService.getJobbyid(jobId);
        if(jobs==null){
            return new ResponseEntity<>(jobs,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobs,HttpStatus.OK);  
     }
}

