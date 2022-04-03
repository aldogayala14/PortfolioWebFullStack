package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private PersonEntity personEducation;
}
