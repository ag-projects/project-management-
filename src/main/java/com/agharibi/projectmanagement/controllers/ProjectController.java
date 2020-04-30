package com.agharibi.projectmanagement.controllers;

import com.agharibi.projectmanagement.dao.ProjectRepository;
import com.agharibi.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "/projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project);

        // prevent duplicate submissions
        return "redirect:/projects/new";
    }

}
