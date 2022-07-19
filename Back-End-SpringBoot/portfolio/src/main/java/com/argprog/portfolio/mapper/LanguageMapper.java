package com.argprog.portfolio.mapper;


import com.argprog.portfolio.dto.LanguageDTO;
import com.argprog.portfolio.entity.LanguageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LanguageMapper {

    @Autowired
    private PersonMapper personMapper;

    public LanguageEntity languageDTO2Entity(LanguageDTO languageDTO, boolean loadPersons){
        LanguageEntity language = new LanguageEntity();
        language.setName(languageDTO.getName());
        language.setLevel(languageDTO.getLevel());
        if(loadPersons){
            language.setPersons(this.personMapper.personDTO2EntityList(languageDTO.getPersons(), false));
        }

        return language;
    }

    public LanguageDTO languageEntity2DTO(LanguageEntity entity, boolean loadPersons){
        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setId(entity.getId());
        languageDTO.setName(entity.getName());
        languageDTO.setLevel(entity.getLevel());
        if(loadPersons){
            languageDTO.setPersons(this.personMapper.personEntity2DTOList(entity.getPersons(),false));
        }
        return languageDTO;
    }

    public List<LanguageDTO> languageEntity2DTOList(List<LanguageEntity> entities, boolean loadPerson){
        List<LanguageDTO> dtos = new ArrayList<>();
        for(LanguageEntity entity: entities){
            dtos.add(this.languageEntity2DTO(entity,loadPerson));
        }
        return dtos;
    }

    public List<LanguageEntity> languageDTO2EntityList(List<LanguageDTO> dtos, boolean loadPersons){
       List<LanguageEntity> entities = new ArrayList<>();
        for(LanguageDTO dto:dtos){
            entities.add(this.languageDTO2Entity(dto, loadPersons));
        }
        return entities;
    }
}
