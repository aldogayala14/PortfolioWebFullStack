package com.argprog.portfolio.mapper;


import com.argprog.portfolio.dto.TechnologyDTO;
import com.argprog.portfolio.entity.TechnologyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TechnologyMapper {

    @Autowired
    private PersonMapper personMapper;
    private ProjectMapper projectMapper;

    public TechnologyEntity technologyDTO2Entity(TechnologyDTO technologyDTO, boolean loadPersons){
        TechnologyEntity entity = new TechnologyEntity();
        entity.setName(technologyDTO.getName());
        entity.setPercentageKnowledge(technologyDTO.getPercentageKnowledge());
        if(loadPersons){
            entity.setPersons(personMapper.personDTO2EntityList(technologyDTO.getPersons(), false));
        }

        return entity;
    }

    public TechnologyDTO technologyEntity2DTO(TechnologyEntity entity, boolean loadPersons){
        TechnologyDTO technologyDTO = new TechnologyDTO();
        technologyDTO.setId(entity.getId());
        technologyDTO.setName(entity.getName());
        technologyDTO.setPercentageKnowledge(entity.getPercentageKnowledge());
       if(loadPersons){
           technologyDTO.setPersons(personMapper.personEntity2DTOList(entity.getPersons(), false));
       }
        return technologyDTO;
    }


    public List<TechnologyEntity> technologyDTO2EntityList(List<TechnologyDTO> technologyDTOS, boolean loadPersons){
        List<TechnologyEntity> technologyEntities = new ArrayList<>();
        for(TechnologyDTO dto : technologyDTOS){
            technologyEntities.add(this.technologyDTO2Entity(dto, loadPersons));
        }

        return technologyEntities;
    }

    public List<TechnologyDTO> technologyEntity2DTOList(List<TechnologyEntity> technologyEntities, boolean loadPersons){
        List<TechnologyDTO> technologyDTOS = new ArrayList<>();
        for(TechnologyEntity entity : technologyEntities){
            technologyDTOS.add(this.technologyEntity2DTO(entity, loadPersons));
        }

        return technologyDTOS;
    }
}
