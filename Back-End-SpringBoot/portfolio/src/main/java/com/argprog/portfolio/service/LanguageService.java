package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.LanguageDTO;
import com.argprog.portfolio.entity.LanguageEntity;

import java.util.List;

public interface LanguageService {
    List<LanguageDTO> getAllLanguages();

    LanguageDTO save(LanguageDTO languageDTO);

    void delete(Long id);

    LanguageDTO update(Long id, LanguageDTO languageDTO);

    LanguageEntity getEntityById(Long idLanguage);
}
