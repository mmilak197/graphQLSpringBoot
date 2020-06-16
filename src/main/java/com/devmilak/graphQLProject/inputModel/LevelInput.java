package com.devmilak.graphQLProject.inputModel;

import graphql.schema.GraphQLInputType;
import lombok.Data;

@Data
public class LevelInput implements GraphQLInputType {

    @Override
    public String getName() {
        return "levelUpdate";
    }

    private Long developerId;
    private String level;
}
