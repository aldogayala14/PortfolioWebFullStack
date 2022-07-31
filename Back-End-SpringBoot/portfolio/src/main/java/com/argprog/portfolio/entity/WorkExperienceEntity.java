package com.argprog.portfolio.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work_experiences")
@Getter
@Setter
@SQLDelete(sql = "UPDATE work_experiences SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
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

    private boolean deleted = Boolean.FALSE;
}

