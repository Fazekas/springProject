package com.example.project.mapper;

import com.example.project.entity.JobTitleEntity;
import com.example.project.model.JobTitle;
import org.springframework.stereotype.Component;

@Component
public class JobTitleMapper implements EntityModelMapper<JobTitleEntity, JobTitle> {

    @Override
    public JobTitle entityToModel(JobTitleEntity entity) {
        JobTitle jobTitle = new JobTitle();

        jobTitle.setId(entity.getId());
        jobTitle.setActive(entity.getActive());
        jobTitle.setName(entity.getName());

        return jobTitle;
    }

    @Override
    public JobTitleEntity modelToEntity(JobTitle model) {
        JobTitleEntity jobTitleEntity = new JobTitleEntity();

        jobTitleEntity.setId(model.getId());
//        jobTitleEntity.setActive(model.isActive());
        jobTitleEntity.setName(model.getName());

        return jobTitleEntity;
    }
}
