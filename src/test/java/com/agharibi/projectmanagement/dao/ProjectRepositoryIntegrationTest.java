package com.agharibi.projectmanagement.dao;


import com.agharibi.projectmanagement.ProjectManagementApplication;
import com.agharibi.projectmanagement.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProjectManagementApplication.class})
@SqlGroup(
    {
        @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
        @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:drop.sql"})
    })
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void ifNewSaved_thenSuccess() {
        Project project = new Project("test project", "COMPLETED", "test description");
        projectRepository.save(project);
        assertThat(projectRepository.findAll().size(), is(5));
    }
}
