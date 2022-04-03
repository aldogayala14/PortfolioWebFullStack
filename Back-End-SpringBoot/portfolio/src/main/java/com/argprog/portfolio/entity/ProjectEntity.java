package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class ProjectEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String image;
    private String projectStart;
    private String projectEnd;
    private String url;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private PersonEntity personProject;

    @OneToMany(mappedBy = "projectTechnology")
    private Set<TechnologyEntity> technologies = new HashSet<>();

    private void addTechnology(TechnologyEntity technology){
        this.technologies.add(technology);
    }

    private void removeTechnology(TechnologyEntity technology){
        this.technologies.remove(technology);
    }



}
