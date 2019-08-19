package com.example.project.mapper;

import com.example.project.entity.EmployeeEntity;
import com.example.project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements EntityModelMapper<EmployeeEntity, Employee> {

    @Autowired
    private JobTitleMapper jobTitleMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Employee entityToModel(EmployeeEntity entity) {
        Employee employee = new Employee();

        employee.setId(entity.getId());
        employee.setActive(entity.getActive());
        employee.setFirstName(entity.getFirstName());
        employee.setMiddleInitial(entity.getMiddleInitial());
        employee.setLastName(entity.getLastName());
        employee.setEmail(entity.getEmail());

        if (entity.getManager() != null) {
            employee.setManager(entityToModel(entity.getManager()));
        }

        if (entity.getJobTitle() != null) {
            employee.setJobTitle(jobTitleMapper.entityToModel(entity.getJobTitle()));
        }

        if (entity.getDepartment() != null) {
            employee.setDepartment(departmentMapper.entityToModel(entity.getDepartment()));
        }

        return employee;
    }

    @Override
    public EmployeeEntity modelToEntity(Employee model) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId(model.getId());
//        employeeEntity.setActive(model.isActive());
        employeeEntity.setFirstName(model.getFirstName());
        employeeEntity.setMiddleInitial(model.getMiddleInitial());
        employeeEntity.setLastName(model.getLastName());
        employeeEntity.setEmail(model.getEmail());

        if (model.getManager() != null) {
            employeeEntity.setManager(modelToEntity(model.getManager()));
        }

        if (model.getJobTitle() != null) {
            employeeEntity.setJobTitle(jobTitleMapper.modelToEntity(model.getJobTitle()));
        }

        if (model.getDepartment() != null) {
            employeeEntity.setDepartment(departmentMapper.modelToEntity(model.getDepartment()));
        }

        return employeeEntity;
    }
}
