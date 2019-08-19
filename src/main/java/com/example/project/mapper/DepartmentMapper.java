package com.example.project.mapper;

import com.example.project.entity.DepartmentEntity;
import com.example.project.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper implements EntityModelMapper<DepartmentEntity, Department>{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Department entityToModel(DepartmentEntity entity) {
        Department department = new Department();

        department.setId(entity.getId());
        department.setActive(entity.getActive());
        department.setName(entity.getName());
        if (entity.getManager() != null) {
            department.setManager(employeeMapper.entityToModel(entity.getManager()));
        }

        if (entity.getParentDepartment() != null) {
            department.setParentDepartment(entityToModel(entity.getParentDepartment()));
        }

        return department;
    }

    @Override
    public DepartmentEntity modelToEntity(Department model) {
        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setId(model.getId());
//        departmentEntity.setActive(model.isActive());
        departmentEntity.setName(model.getName());
        if (model.getManager() != null) {
            departmentEntity.setManager(employeeMapper.modelToEntity(model.getManager()));
        }

        if (model.getParentDepartment() != null) {
            departmentEntity.setParentDepartment(modelToEntity(model.getParentDepartment()));
        }

        return departmentEntity;
    }
}
