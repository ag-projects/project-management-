package com.agharibi.projectmanagement.services;

import com.agharibi.projectmanagement.dao.ProjectRepository;
import com.agharibi.projectmanagement.dto.ChartData;
import com.agharibi.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    public List<ChartData> getProjectStatus() {
        return projectRepository.getProjectStatus();
    }
}
