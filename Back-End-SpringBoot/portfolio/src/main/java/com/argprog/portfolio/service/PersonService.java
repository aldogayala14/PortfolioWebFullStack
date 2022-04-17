package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    
    List<PersonDTO> getAllPersons();

    PersonDTO save(PersonDTO personDTO);

    void delete(Long id);

    PersonDTO update(Long id, PersonDTO personDTO);
}
