package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    
    List<PersonDTO> getAllPersons();

    PersonDTO save(PersonDTO personDTO);

    void delete(Long id);

    PersonDTO update(Long id, PersonDTO personDTO);

    void addEducation(Long id, Long idEducation);

    void removeEducation(Long id, Long idEducation);

    void addProject(Long id, Long idProject);

    void removeProject(Long id, Long idProject);

    void addLanguage(Long id, Long idLanguage);

    void removeLanguage(Long id, Long idLanguage);

    void addTechnology(Long id, Long idTechnology);

    void removeTechnology(Long id, Long idTechnology);

    void addExperiencie(Long id, Long idExperiencie);

    void removeExperiencie(Long id, Long idExperiencie);
}
