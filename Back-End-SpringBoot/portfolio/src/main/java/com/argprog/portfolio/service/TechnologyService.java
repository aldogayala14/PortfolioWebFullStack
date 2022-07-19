package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.TechnologyDTO;
import com.argprog.portfolio.entity.TechnologyEntity;

import java.util.List;

public interface TechnologyService {
    List<TechnologyDTO> getAllTechnologies();

    TechnologyDTO save(TechnologyDTO technologyDTO);

    void delete(Long id);

    TechnologyDTO update(Long id, TechnologyDTO technologyDTO);

    TechnologyEntity getEntityById(Long idTechnology);
}
