package com.argprog.portfolio.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class LanguageDTO {
    private Long id;
    private String name;
    private String level;
    private List<PersonDTO> persons;
}
