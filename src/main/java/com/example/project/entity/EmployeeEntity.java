package com.example.project.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity {

    @Column(length = 20)
    private String firstName;

    private Character middleInitial;

    @Column(length = 20)
    private String lastName;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    private Boolean isManager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitleEntity jobTitle;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "manager")
    private Set<EmployeeEntity> managedEmployees = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Character getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(Character middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsManager() {
        return isManager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    public Set<EmployeeEntity> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<EmployeeEntity> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public void setIsManager(Boolean manager) {
        isManager = manager;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public JobTitleEntity getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitleEntity jobTitle) {
        this.jobTitle = jobTitle;
    }
}