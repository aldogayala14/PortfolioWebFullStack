package com.argprog.portfolio.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "residences")
@Getter
@Setter
@SQLDelete(sql = "UPDATE residences SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
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


    private boolean deleted = Boolean.FALSE;
}
