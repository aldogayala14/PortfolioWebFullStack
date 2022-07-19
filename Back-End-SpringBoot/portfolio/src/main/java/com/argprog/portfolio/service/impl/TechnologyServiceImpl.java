package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.TechnologyDTO;
import com.argprog.portfolio.entity.TechnologyEntity;
import com.argprog.portfolio.exception.ParamNotFound;
import com.argprog.portfolio.mapper.PersonMapper;
import com.argprog.portfolio.mapper.ProjectMapper;
import com.argprog.portfolio.mapper.TechnologyMapper;
import com.argprog.portfolio.repository.TechnologyRepository;
import com.argprog.portfolio.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyMapper technologyMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public List<TechnologyDTO> getAllTechnologies() {
        List<TechnologyEntity> entities = technologyRepository.findAll();
        if(entities.isEmpty()){
            throw new ParamNotFound("Technology list is empty");
        }
        List<TechnologyDTO> result = technologyMapper.technologyEntity2DTOList(entities, true);
        return result;
    }

    @Override
    public TechnologyDTO save(TechnologyDTO technologyDTO) {
        TechnologyEntity entity = technologyMapper.technologyDTO2Entity(technologyDTO, false);
        TechnologyEntity technologySaved = technologyRepository.save(entity);
        TechnologyDTO result = technologyMapper.technologyEntity2DTO(technologySaved, false);
        return result;
    }

    @Override
    public void delete(Long id) {
        technologyRepository.deleteById(id);
    }

    @Override
    public TechnologyDTO update(Long id, TechnologyDTO technologyDTO) {
        TechnologyEntity entity = technologyRepository.findById(id).orElse(null);
        if(Objects.isNull(entity)){
            throw new ParamNotFound("Technology id is not valid");
        }
        entity.setName(technologyDTO.getName());
        entity.setPercentageKnowledge(technologyDTO.getPercentageKnowledge());
        TechnologyEntity technologySaved = technologyRepository.save(entity);
        TechnologyDTO result = technologyMapper.technologyEntity2DTO(technologySaved, true);
        return result;
    }

    @Override
    public TechnologyEntity getEntityById(Long idTechnology) {
        TechnologyEntity entity = this.technologyRepository.getById(idTechnology);
        return  entity;
    }
}
