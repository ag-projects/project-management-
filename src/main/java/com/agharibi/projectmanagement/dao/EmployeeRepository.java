package com.agharibi.projectmanagement.dao;

import com.agharibi.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();
}
