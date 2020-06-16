package com.devmilak.graphQLProject.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.devmilak.graphQLProject.model.Developer;
import com.devmilak.graphQLProject.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperService implements GraphQLQueryResolver, GraphQLMutationResolver {

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

    @Transactional
    public Developer updateLevel(final Long id, final String level) {
         var developer = developerRepository.findById(id).get();
         developer.setLevel(level);
         developerRepository.save(developer);

         return developer;
    }
}
