package com.example.question2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.question2.model.Job;
import com.example.question2.repository.JobRepo;

@Service
public class JobService {
     private JobRepo jobRepo;
    public JobService(JobRepo jobRepo){
        this.jobRepo = jobRepo;
    }

    public Job saveJobDetails(Job job){
        return jobRepo.save(job);
    }

    public List<Job> getListOfJobs(){
        return jobRepo.findAll();
    } 

    public Job getJobbyid(int id){
        return jobRepo.findById(id).orElse(null);
    }
}
