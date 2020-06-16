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
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long projectId;
    private String name;
    private String surname;
    private String level;
}
