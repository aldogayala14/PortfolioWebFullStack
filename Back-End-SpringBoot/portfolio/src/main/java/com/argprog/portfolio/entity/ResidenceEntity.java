package com.argprog.portfolio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "residences")
@Getter
@Setter
public class ResidenceEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String street;
    private String streetNumbering;
    private String district;
    private String state;
    private String country;

    @OneToOne(mappedBy = "residence")
    private PersonEntity person;

}
