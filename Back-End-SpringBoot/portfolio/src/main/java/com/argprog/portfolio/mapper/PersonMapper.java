package com.argprog.portfolio.mapper;

import com.argprog.portfolio.dto.PersonDTO;
import com.argprog.portfolio.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonMapper {

    @Autowired
    private ResidenceMapper residenceMapper;

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
        entity.setResidence(residenceMapper.residenceDTO2Entity(personDTO.getResidence()));
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
        personDTO.setResidence(residenceMapper.residenceEntity2DTO(entity.getResidence()));
        return personDTO;
    }

    public List<PersonDTO> personEntity2DTOList(List<PersonEntity> entities){
        List<PersonDTO> personDTOS = new ArrayList<>();
        for(PersonEntity entity : entities){
            personDTOS.add(this.personEntity2DTO(entity));
        }
        return personDTOS;
    }

    public List<PersonEntity> personDTO2EntityList(List<PersonDTO> dtos){
        List<PersonEntity> entities = new ArrayList<>();
        for(PersonDTO dto : dtos){
            entities.add(this.personDTO2Entity(dto);
        }
        return entities;
    }
}
