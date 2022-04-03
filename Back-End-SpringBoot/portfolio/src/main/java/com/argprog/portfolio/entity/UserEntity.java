package com.argprog.portfolio.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String userName;
    private String password;

    @OneToOne(mappedBy = "user")
    private PersonEntity person;

}
