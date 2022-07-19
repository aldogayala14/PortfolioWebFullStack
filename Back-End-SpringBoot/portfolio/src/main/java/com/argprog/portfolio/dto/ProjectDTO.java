package com.argprog.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String name;
    private String image;
    private String projectStart;
    private String projectEnd;
    private String url;
    private List<PersonDTO> persons;
}
