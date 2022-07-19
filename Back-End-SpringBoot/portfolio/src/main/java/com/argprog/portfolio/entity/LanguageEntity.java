package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
@Getter
@Setter
public class LanguageEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String level;

    @ManyToMany(mappedBy = "languages")
    private List<PersonEntity> persons = new ArrayList<>();



}
