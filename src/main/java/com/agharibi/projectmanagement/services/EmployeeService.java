package com.agharibi.projectmanagement.services;

import com.agharibi.projectmanagement.dao.EmployeeRepository;
import com.agharibi.projectmanagement.dto.EmployeeProject;
import com.agharibi.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<EmployeeProject> employeeProjects() {
        return employeeRepository.employeeProjects();
    }
}
