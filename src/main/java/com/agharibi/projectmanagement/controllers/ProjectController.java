package com.agharibi.projectmanagement.controllers;

import com.agharibi.projectmanagement.entities.Employee;
import com.agharibi.projectmanagement.entities.Project;
import com.agharibi.projectmanagement.services.EmployeeService;
import com.agharibi.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project", new Project());

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {

        projectService.saveProject(project);
        // prevent duplicate submissions
        return "redirect:/projects";
    }

}
