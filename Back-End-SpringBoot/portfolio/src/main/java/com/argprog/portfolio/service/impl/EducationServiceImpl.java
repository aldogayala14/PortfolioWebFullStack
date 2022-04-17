package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.EducationDTO;
import com.argprog.portfolio.entity.EducationEntity;
import com.argprog.portfolio.mapper.EducationMapper;
import com.argprog.portfolio.repository.EducationRepository;
import com.argprog.portfolio.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationMapper educationMapper;
    @Autowired
    private EducationRepository educationRepository;


    @Override
    public List<EducationDTO> getAll() {
        List<EducationEntity> entities = educationRepository.findAll();
        List<EducationDTO> result = educationMapper.educationEntity2DTOList(entities);
        return result;
    }

    @Override
    public EducationDTO save(EducationDTO educationDTO) {
        EducationEntity entity = educationMapper.educationDTO2Entity(educationDTO);
        EducationEntity educationSaved = educationRepository.save(entity);
        EducationDTO result = educationMapper.educationEntity2DTO(educationSaved);
        return result;
    }

    @Override
    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public EducationDTO update(Long id, EducationDTO educationDTO) {
        EducationEntity entity = educationRepository.findById(id).orElse(null);
        entity.setTitle(educationDTO.getTitle());
        entity.setImage(educationDTO.getImage());
        //TODO : Set elements de EducationEntity
        EducationEntity educationSaved = educationRepository.save(entity);
        EducationDTO result = educationMapper.educationEntity2DTO(educationSaved);
        return result;
    }
}