package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.WorkExperiencieDTO;
import com.argprog.portfolio.entity.WorkExperienceEntity;

import java.util.List;

public interface WorkExperienceService {
    List<WorkExperiencieDTO> getAllExperiencies();

    WorkExperiencieDTO save(WorkExperiencieDTO workExperiencieDTO);

    void delete(Long id);

    WorkExperiencieDTO update(Long id, WorkExperiencieDTO workExperiencieDTO);

    WorkExperienceEntity getEntityById(Long idExperiencie);
}
