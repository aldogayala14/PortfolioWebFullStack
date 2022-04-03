package com.argprog.portfolio.entity;


import javax.persistence.*;

@Entity
@Table(name = "technologies")
public class TechnologyEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private int percentageKnowledge;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private PersonEntity personTechnology;

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private ProjectEntity projectTechnology;
}
