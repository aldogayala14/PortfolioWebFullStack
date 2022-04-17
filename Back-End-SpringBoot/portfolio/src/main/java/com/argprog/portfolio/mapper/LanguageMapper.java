package com.argprog.portfolio.mapper;


import com.argprog.portfolio.dto.LanguageDTO;
import com.argprog.portfolio.entity.LanguageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper {

    @Autowired
    private PersonMapper personMapper;

    public LanguageEntity languageDTO2Entity(LanguageDTO languageDTO){
        LanguageEntity language = new LanguageEntity();
        language.setName(languageDTO.getName());
        language.setLevel(languageDTO.getLevel());
        language.setPersonLanguage(personMapper.personDTO2Entity(languageDTO.getPersonLanguage()));
        return language;
    }

    public LanguageDTO languageEntity2DTO(LanguageEntity entity){
        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setId(entity.getId());
        languageDTO.setName(entity.getName());
        languageDTO.setLevel(entity.getLevel());
        languageDTO.setPersonLanguage(personMapper.personEntity2DTO(entity.getPersonLanguage()));
        return languageDTO;
    }
}
