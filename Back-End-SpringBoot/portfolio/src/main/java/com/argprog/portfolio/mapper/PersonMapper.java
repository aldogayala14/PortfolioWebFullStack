package com.argprog.portfolio.mapper;

import com.argprog.portfolio.dto.PersonDTO;
import com.argprog.portfolio.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonEntity personDTO2Entity(PersonDTO personDTO){
        PersonEntity entity = new PersonEntity();
        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAboutMe(personDTO.getAboutMe());
        entity.setBirthDate(personDTO.getBirthDate());
        entity.setEmail(personDTO.getEmail());
        entity.setNationality(personDTO.getNationality());
        entity.setOccupation(personDTO.getOccupation());
        entity.setImageBackgroundHeader(personDTO.getImageBackgroundHeader());
        entity.setImageProfile(personDTO.getImageProfile());
        //TODO : mapper Residence convert DTO2Entity
        //entity.setResidence(personDTO.getResidence());
        return entity;
    }

    public PersonDTO personEntity2DTO(PersonEntity entity){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(entity.getId());
        personDTO.setFirstName(entity.getFirstName());
        personDTO.setLastName(entity.getLastName());
        personDTO.setAboutMe(entity.getAboutMe());
        personDTO.setNationality(entity.getNationality());
        personDTO.setEmail(entity.getEmail());
        personDTO.setBirthDate(entity.getBirthDate());
        personDTO.setOccupation(entity.getOccupation());
        personDTO.setImageProfile(entity.getImageProfile());
        personDTO.setImageBackgroundHeader(entity.getImageBackgroundHeader());
        //personDTO.setResidence(entity.getResidence());
        return personDTO;
    }
}
