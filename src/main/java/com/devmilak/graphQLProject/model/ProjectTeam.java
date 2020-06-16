package com.devmilak.graphQLProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String projectName;
    private String country;
}
