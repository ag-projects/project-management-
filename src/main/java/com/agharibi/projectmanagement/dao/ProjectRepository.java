package com.agharibi.projectmanagement.dao;

import com.agharibi.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();
}
