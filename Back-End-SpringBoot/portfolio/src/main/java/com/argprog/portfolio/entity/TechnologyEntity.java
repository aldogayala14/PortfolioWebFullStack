package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "technologies")
@Getter
@Setter
@SQLDelete(sql = "UPDATE technologies SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class TechnologyEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private int percentageKnowledge;

    @ManyToMany(mappedBy = "technologies")
    private List<PersonEntity> persons = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;

}
