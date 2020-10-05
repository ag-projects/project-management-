package com.agharibi.projectmanagement.controllers;

import com.agharibi.projectmanagement.dto.ChartData;
import com.agharibi.projectmanagement.dto.EmployeeProject;
import com.agharibi.projectmanagement.entities.Project;
import com.agharibi.projectmanagement.services.EmployeeService;
import com.agharibi.projectmanagement.services.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String displayHome(Model model) throws Exception {

        Map<String, Object> map = new HashMap<>();

        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);

        List<ChartData> chartData = projectService.getProjectStatus();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(chartData);
        model.addAttribute("projectStatusCount", jsonString);

        List<EmployeeProject> employeeProjects = employeeService.employeeProjects();
        model.addAttribute("employeeProjects", employeeProjects);

        return "main/home";
    }
}
