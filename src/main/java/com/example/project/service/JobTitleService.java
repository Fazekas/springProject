package com.example.project.service;

import com.example.project.entity.JobTitleEntity;
import com.example.project.mapper.JobTitleMapper;
import com.example.project.model.JobTitle;
import com.example.project.repository.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleMapper jobTitleMapper;

    @Autowired
    private JobTitleRepository jobTitleRepository;

    public JobTitle save(JobTitle jobTitle) {
        JobTitleEntity jobTitleEntity = jobTitleMapper.modelToEntity(jobTitle);

        JobTitleEntity save = jobTitleRepository.save(jobTitleEntity);

        return jobTitleMapper.entityToModel(save);
    }

    public List<JobTitle> findAll() {
        ArrayList<JobTitle> jobTitles = new ArrayList<>();
        List<JobTitleEntity> all = jobTitleRepository.findAll();

        all.forEach(job -> jobTitles.add(jobTitleMapper.entityToModel(job)));

        return jobTitles;
    }
}
