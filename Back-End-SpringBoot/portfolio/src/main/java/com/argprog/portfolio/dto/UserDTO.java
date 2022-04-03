package com.argprog.portfolio.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {
    private Long id;
    private String userName;
    private String password;
    private PersonDTO person;
}
