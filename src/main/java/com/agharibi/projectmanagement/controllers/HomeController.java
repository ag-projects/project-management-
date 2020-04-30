package com.agharibi.projectmanagement.controllers;

import com.agharibi.projectmanagement.dao.EmployeeRepository;
import com.agharibi.projectmanagement.dao.ProjectRepository;
import com.agharibi.projectmanagement.entities.Employee;
import com.agharibi.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);

        return "main/home";
    }
}
