package com.example.project.service;

import com.example.project.entity.DepartmentEntity;
import com.example.project.mapper.DepartmentMapper;
import com.example.project.model.Department;
import com.example.project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        DepartmentEntity departmentEntity = departmentMapper.modelToEntity(department);

        DepartmentEntity save = departmentRepository.save(departmentEntity);

        return departmentMapper.entityToModel(save);
    }

    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        List<DepartmentEntity> all = departmentRepository.findAll();

        all.forEach(dept -> departments.add(departmentMapper.entityToModel(dept)));

        return departments;
    }
}
