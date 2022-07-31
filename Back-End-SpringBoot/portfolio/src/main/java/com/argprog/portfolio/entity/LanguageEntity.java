package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
@Getter
@Setter
@SQLDelete(sql = "UPDATE languages SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class LanguageEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String level;

    @ManyToMany(mappedBy = "languages")
    private List<PersonEntity> persons = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;




}
