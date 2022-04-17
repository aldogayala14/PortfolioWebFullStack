package com.argprog.portfolio.mapper;


import com.argprog.portfolio.dto.TechnologyDTO;
import com.argprog.portfolio.entity.TechnologyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TechnologyMapper {

    @Autowired
    private PersonMapper personMapper;
    private ProjectMapper projectMapper;

    public TechnologyEntity technologyDTO2Entity(TechnologyDTO technologyDTO){
        TechnologyEntity entity = new TechnologyEntity();
        entity.setName(technologyDTO.getName());
        entity.setPercentageKnowledge(technologyDTO.getPercentageKnowledge());
        entity.setPersonTechnology(personMapper.personDTO2Entity(technologyDTO.getPersonTechnology()));
        entity.setProjectTechnology(projectMapper.projectDTO2Entity(technologyDTO.getProjectTechnology()));
        return entity;
    }

    public TechnologyDTO technologyEntity2DTO(TechnologyEntity entity){
        TechnologyDTO technologyDTO = new TechnologyDTO();
        technologyDTO.setId(entity.getId());
        technologyDTO.setName(entity.getName());
        technologyDTO.setPercentageKnowledge(entity.getPercentageKnowledge());
        technologyDTO.setProjectTechnology(projectMapper.projectEntity2DTO(entity.getProjectTechnology()));
        technologyDTO.setPersonTechnology(personMapper.personEntity2DTO(entity.getPersonTechnology()));
        return technologyDTO;
    }


    public Set<TechnologyEntity> technologyDTO2EntityList(Set<TechnologyDTO> technologyDTOS){
        Set<TechnologyEntity> technologyEntities = new HashSet<>();
        for(TechnologyDTO dto : technologyDTOS){
            technologyEntities.add(this.technologyDTO2Entity(dto));
        }

        return technologyEntities;
    }

    public Set<TechnologyDTO> technologyEntity2DTOList(Set<TechnologyEntity> technologyEntities){
        Set<TechnologyDTO> technologyDTOS = new HashSet<>();
        for(TechnologyEntity entity : technologyEntities){
            technologyDTOS.add(this.technologyEntity2DTO(entity));
        }

        return technologyDTOS;
    }
}
