package com.agharibi.projectmanagement.dao;

import com.agharibi.projectmanagement.dto.EmployeeProject;
import com.agharibi.projectmanagement.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true,
        value = "SELECT e.first_name as firstName, e.last_name as lastName, count(pe.employee_id) as projectCount" +
            " FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id " +
            " LEFT JOIN project p on p.project_id = pe.project_id " +
            " GROUP BY e.first_name, e.last_name" +
            " ORDER BY 3 DESC")
    List<EmployeeProject> employeeProjects();
}
