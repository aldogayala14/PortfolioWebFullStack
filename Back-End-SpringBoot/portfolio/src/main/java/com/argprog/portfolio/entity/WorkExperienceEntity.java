package com.argprog.portfolio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work_experiences")
@Getter
@Setter
public class WorkExperienceEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String occupation;
    private String observations;
    private String image;
    private String occupationStart;
    private String occupationEnd;
    private String company;

    @ManyToMany(mappedBy = "workExperiences")
    private List<PersonEntity> persons = new ArrayList<>();
}

