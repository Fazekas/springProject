package com.example.project.service;

import com.example.project.entity.EmployeeEntity;
import com.example.project.mapper.EmployeeMapper;
import com.example.project.model.Employee;
import com.example.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee save(Employee employee) {
        Assert.hasText(employee.getFirstName(), "first name cannot be null");
        Assert.hasText(employee.getLastName(), "last name cannot be null");
        EmployeeEntity employeeEntity = employeeMapper.modelToEntity(employee);

        EmployeeEntity save = employeeRepository.save(employeeEntity);

        return employeeMapper.entityToModel(save);
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeEntity> all = employeeRepository.findAll();

        all.forEach(emp -> employees.add(employeeMapper.entityToModel(emp)));

        return employees;
    }

    public Employee findById(int id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);

        if (optionalEmployeeEntity.isPresent()) {
            Employee employee = employeeMapper.entityToModel(optionalEmployeeEntity.get());
            return employee;
        } else {
            throw new EntityNotFoundException();
        }
    }
}
