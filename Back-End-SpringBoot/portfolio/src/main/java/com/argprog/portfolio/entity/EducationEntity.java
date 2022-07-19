package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "educations")
@Getter
@Setter
public class EducationEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String college;
    private String title;
    private String image;
    private String career;
    private String status;
    private double qualification;
    private String careerStart;
    private String careerEnd;

    @ManyToMany(mappedBy = "educations")
    private List<PersonEntity> persons = new ArrayList<>();
}
