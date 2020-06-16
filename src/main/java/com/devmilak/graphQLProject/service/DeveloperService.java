package com.devmilak.graphQLProject.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.devmilak.graphQLProject.model.Developer;
import com.devmilak.graphQLProject.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperService implements GraphQLQueryResolver {

    @Autowired
    private DeveloperRepository developerRepository;

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public List<Developer> getDevelopersOnLevel(final String level) {
        return developerRepository.findAll().stream()
                                            .filter(it -> level.equals(it.getLevel()))
                                            .collect(Collectors.toList());
    }
}
