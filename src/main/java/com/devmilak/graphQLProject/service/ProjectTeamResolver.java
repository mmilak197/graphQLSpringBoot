package com.devmilak.graphQLProject.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.devmilak.graphQLProject.model.Developer;
import com.devmilak.graphQLProject.model.ProjectTeam;
import com.devmilak.graphQLProject.repository.ProjectTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProjectTeamResolver implements GraphQLResolver<Developer> {

    @Autowired
    private ProjectTeamRepository projectTeamRepository;

    @Transactional
    public ProjectTeam getProjectTeam(Developer developer) {
        return projectTeamRepository.findById(developer.getProjectId()).get();
    }

}
