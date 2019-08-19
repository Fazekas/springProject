package com.example.project.controller;

import com.example.project.model.JobTitle;
import com.example.project.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "titles")
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping
    public List<JobTitle> findAll() {
        return jobTitleService.findAll();
    }

    @PostMapping
    public JobTitle save(@RequestBody JobTitle jobTitle) {
        return jobTitleService.save(jobTitle);
    }
}
