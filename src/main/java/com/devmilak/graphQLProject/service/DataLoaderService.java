package com.devmilak.graphQLProject.service;

import com.devmilak.graphQLProject.model.Developer;
import com.devmilak.graphQLProject.model.ProjectTeam;
import com.devmilak.graphQLProject.repository.DeveloperRepository;
import com.devmilak.graphQLProject.repository.ProjectTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class DataLoaderService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private ProjectTeamRepository projectTeamRepository;

    @PostConstruct
    public void loadData() {
        prepareDevelopers();
        prepareProjectTeams();
    }

    private void prepareDevelopers() {
        developerRepository.save(Developer.builder().projectId(9L).name("dev1").surname("loper1").level("L3").build());
        developerRepository.save(Developer.builder().projectId(9L).name("dev2").surname("loper2").level("L4").build());
        developerRepository.save(Developer.builder().projectId(9L).name("dev3").surname("loper3").level("L6").build());
        developerRepository.save(Developer.builder().projectId(10L).name("dev4").surname("loper4").level("L4").build());
        developerRepository.save(Developer.builder().projectId(10L).name("dev5").surname("loper5").level("L4").build());
        developerRepository.save(Developer.builder().projectId(10L).name("dev6").surname("loper6").level("L3").build());
        developerRepository.save(Developer.builder().projectId(11L).name("dev7").surname("loper7").level("L2").build());
        developerRepository.save(Developer.builder().projectId(11L).name("dev8").surname("loper8").level("L4").build());
    }

    private void prepareProjectTeams() {
        projectTeamRepository.save(ProjectTeam.builder().projectName("Project1").country("UK").build());
        projectTeamRepository.save(ProjectTeam.builder().projectName("Project2").country("Asia").build());
        projectTeamRepository.save(ProjectTeam.builder().projectName("Project3").country("UK").build());
    }

}
