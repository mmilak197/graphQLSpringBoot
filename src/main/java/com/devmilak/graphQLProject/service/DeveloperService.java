package com.devmilak.graphQLProject.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.devmilak.graphQLProject.inputModel.LevelInput;
import com.devmilak.graphQLProject.model.Developer;
import com.devmilak.graphQLProject.repository.DeveloperRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class DeveloperService implements GraphQLQueryResolver, GraphQLMutationResolver, GraphQLSubscriptionResolver {

    @Autowired
    private DeveloperRepository developerRepository;

    private ConcurrentHashMap<Long, FluxSink<Developer>> subscribers = new ConcurrentHashMap<>();

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

        if(subscribers.get(id) != null) {
            subscribers.get(id).next(developer);
        }

         return developer;
    }

    @Transactional
    public Developer updateLevelByInputObject(final LevelInput levelInput) {
        var developer = developerRepository.findById(levelInput.getDeveloperId()).get();
        developer.setLevel(levelInput.getLevel());
        developerRepository.save(developer);


        if(subscribers.get(levelInput.getDeveloperId()) != null) {
            subscribers.get(levelInput.getDeveloperId()).next(developer);
        }

        return developer;
    }

    public Publisher<Developer> onDeveloperUpdate(Long developerId) {
        return Flux.create(subscriber -> subscribers.put(developerId, subscriber.onDispose(() -> subscribers.remove(developerId, subscriber))), FluxSink.OverflowStrategy.LATEST);
    }

}
