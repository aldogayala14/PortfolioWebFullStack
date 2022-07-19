package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.LanguageDTO;
import com.argprog.portfolio.entity.LanguageEntity;
import com.argprog.portfolio.exception.ParamNotFound;
import com.argprog.portfolio.mapper.LanguageMapper;
import com.argprog.portfolio.mapper.PersonMapper;
import com.argprog.portfolio.repository.LanguageRepository;
import com.argprog.portfolio.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageMapper languageMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private LanguageRepository languageRepository;


    @Override
    public List<LanguageDTO> getAllLanguages() {
        List<LanguageEntity> entities = languageRepository.findAll();
        if(entities.isEmpty()){
            throw new ParamNotFound("Language list is empty");
        }
        List<LanguageDTO> result = languageMapper.languageEntity2DTOList(entities,true);
        return result;
    }

    @Override
    public LanguageDTO save(LanguageDTO languageDTO) {
        LanguageEntity entity = languageMapper.languageDTO2Entity(languageDTO, false);
        LanguageEntity languageSaved = languageRepository.save(entity);
        LanguageDTO result = languageMapper.languageEntity2DTO(languageSaved, false);
        return result;
    }

    @Override
    public void delete(Long id) {
        languageRepository.deleteById(id);

    }

    @Override
    public LanguageDTO update(Long id, LanguageDTO languageDTO) {
        LanguageEntity entity = languageRepository.findById(id).orElse(null);
        if(Objects.isNull(entity)){
            throw new ParamNotFound("Language id is not valid");
        }
        entity.setName(languageDTO.getName());
        entity.setLevel(languageDTO.getLevel());
        LanguageEntity languageSaved = languageRepository.save(entity);
        LanguageDTO result = languageMapper.languageEntity2DTO(languageSaved,true);
        return result;
    }

    @Override
    public LanguageEntity getEntityById(Long idLanguage) {
        LanguageEntity language = this.languageRepository.getById(idLanguage);
        return language;
    }
}
