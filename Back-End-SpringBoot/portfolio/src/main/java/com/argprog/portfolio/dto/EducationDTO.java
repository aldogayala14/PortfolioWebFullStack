package com.argprog.portfolio.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EducationDTO {
    private Long id;
    private String college;
    private String title;
    private String image;
    private String career;
    private String status;
    private double qualification;
    private String careerStart;
    private String careerEnd;
    private List<PersonDTO> personEducation;
}
