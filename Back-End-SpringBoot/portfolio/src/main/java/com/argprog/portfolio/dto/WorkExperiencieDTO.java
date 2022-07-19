package com.argprog.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkExperiencieDTO {
    private Long id;
    private String occupation;
    private String observations;
    private String image;
    private String occupationStart;
    private String occupationEnd;
    private String company;
    private List<PersonDTO> personExperiences;
}
