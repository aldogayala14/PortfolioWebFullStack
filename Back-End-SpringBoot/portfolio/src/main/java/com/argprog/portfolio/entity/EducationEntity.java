package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "educations")
@Getter
@Setter
@SQLDelete(sql = "UPDATE educations SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
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

    private boolean deleted = Boolean.FALSE;
}
