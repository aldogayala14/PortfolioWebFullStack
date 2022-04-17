package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.EducationDTO;

import java.util.List;

public interface EducationService {
    List<EducationDTO> getAll();

    EducationDTO save(EducationDTO educationDTO);

    void delete(Long id);

    EducationDTO update(Long id, EducationDTO educationDTO);
}
