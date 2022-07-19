package com.argprog.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TechnologyDTO {
    private Long id;

    private String name;
    private int percentageKnowledge;
    private List<PersonDTO> persons;
}
