package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private PersonEntity personLanguage;

}
