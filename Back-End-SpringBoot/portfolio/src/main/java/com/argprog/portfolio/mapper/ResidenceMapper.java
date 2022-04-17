package com.argprog.portfolio.mapper;


import com.argprog.portfolio.dto.ResidenceDTO;
import com.argprog.portfolio.entity.ResidenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResidenceMapper {


    @Autowired
    private PersonMapper personMapper;

    public ResidenceEntity residenceDTO2Entity(ResidenceDTO residenceDTO){
        ResidenceEntity entity = new ResidenceEntity();
        entity.setStreet(residenceDTO.getStreet());
        entity.setState(residenceDTO.getState());
        entity.setCountry(residenceDTO.getCountry());
        entity.setDistrict(residenceDTO.getDistrict());
        entity.setStreetNumbering(residenceDTO.getStreetNumbering());
        entity.setPerson(personMapper.personDTO2Entity(residenceDTO.getPerson()));
        return entity;
    }

    public ResidenceDTO residenceEntity2DTO(ResidenceEntity entity){
        ResidenceDTO residenceDTO = new ResidenceDTO();
        residenceDTO.setId(entity.getId());
        residenceDTO.setStreet(entity.getStreet());
        residenceDTO.setStreetNumbering(entity.getStreetNumbering());
        residenceDTO.setState(entity.getState());
        residenceDTO.setCountry(entity.getCountry());
        residenceDTO.setDistrict(entity.getDistrict());
        residenceDTO.setPerson(personMapper.personEntity2DTO(entity.getPerson()));
        return residenceDTO;
    }
}
