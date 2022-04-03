package com.argprog.portfolio.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "residences")
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
