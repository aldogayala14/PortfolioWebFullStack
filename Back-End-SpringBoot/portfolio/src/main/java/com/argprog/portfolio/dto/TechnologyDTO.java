package com.argprog.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnologyDTO {
    private Long id;

    private String name;
    private int percentageKnowledge;
    private PersonDTO personTechnology;
    private ProjectDTO projectTechnology;
}
