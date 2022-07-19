package com.argprog.portfolio.dto;



import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResidenceDTO {
    private Long id;

    private String street;
    private String streetNumbering;
    private String district;
    private String state;
    private String country;
}
