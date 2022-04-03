package com.argprog.portfolio.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LanguageDTO {
    private Long id;
    private String name;
    private String level;
    private PersonDTO personLanguage;
}
