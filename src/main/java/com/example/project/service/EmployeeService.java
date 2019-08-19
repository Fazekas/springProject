package com.example.project.service;

import com.example.project.entity.EmployeeEntity;
import com.example.project.mapper.EmployeeMapper;
import com.example.project.model.Employee;
import com.example.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee save(Employee employee) {
        EmployeeEntity employeeEntity = employeeMapper.modelToEntity(employee);

        EmployeeEntity save = employeeRepository.save(employeeEntity);

        Employee employee1 = employeeMapper.entityToModel(save);

        return employee1;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeEntity> all = employeeRepository.findAll();

        all.forEach(emp -> employees.add(employeeMapper.entityToModel(emp)));

        return employees;
    }
}
