package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.ResidenceDTO;

import java.util.List;

public interface ResidenceService {
    List<ResidenceDTO> getAllResidences();

    ResidenceDTO save(ResidenceDTO residenceDto);

    void delete(Long id);

    ResidenceDTO update(Long id, ResidenceDTO residenceDTO);
}
