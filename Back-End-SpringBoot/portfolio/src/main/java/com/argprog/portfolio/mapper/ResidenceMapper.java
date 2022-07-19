package com.argprog.portfolio.mapper;


import com.argprog.portfolio.dto.ResidenceDTO;
import com.argprog.portfolio.entity.ResidenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        return residenceDTO;
    }

    public List<ResidenceDTO> residenceEntity2DTOList(List<ResidenceEntity> entities){
        List<ResidenceDTO> dtos = new ArrayList<>();
        for(ResidenceEntity entity : entities){
            dtos.add(this.residenceEntity2DTO(entity));
        }
        return dtos;
    }

    public List<ResidenceEntity> residenceDTO2EntityList(List<ResidenceDTO> dtos){
        List<ResidenceEntity> entities = new ArrayList<>();
        for(ResidenceDTO dto : dtos){
            entities.add(this.residenceDTO2Entity(dto));
        }
        return entities;
    }
}
