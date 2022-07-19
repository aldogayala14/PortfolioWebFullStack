package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @ManyToMany(mappedBy = "projects")
    private List<PersonEntity> persons = new ArrayList<>();


}
