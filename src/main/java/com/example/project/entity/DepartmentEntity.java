package com.example.project.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "parent_department_id")
    private DepartmentEntity parentDepartment;

    @OneToMany(mappedBy = "parentDepartment")
    private Set<DepartmentEntity> departments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "department")
    private Set<EmployeeEntity> employees = new HashSet<>();

    private String name;

    public DepartmentEntity getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(DepartmentEntity parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public Set<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<DepartmentEntity> departments) {
        this.departments = departments;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
