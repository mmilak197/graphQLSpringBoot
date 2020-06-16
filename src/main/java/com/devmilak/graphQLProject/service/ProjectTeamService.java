package com.devmilak.graphQLProject.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.devmilak.graphQLProject.model.ProjectTeam;
import com.devmilak.graphQLProject.repository.ProjectTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTeamService implements GraphQLQueryResolver {

    @Autowired
    private ProjectTeamRepository projectTeamRepository;

    public List<ProjectTeam> getAllProjectTeams() {
        return projectTeamRepository.findAll();
    }
}
