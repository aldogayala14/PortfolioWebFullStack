package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.EducationDTO;
import com.argprog.portfolio.entity.EducationEntity;
import com.argprog.portfolio.exception.ParamNotFound;
import com.argprog.portfolio.mapper.EducationMapper;
import com.argprog.portfolio.repository.EducationRepository;
import com.argprog.portfolio.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    //Mapper
    private EducationMapper educationMapper;
    //Repo
    private EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl (EducationRepository educationRepository,
                                 EducationMapper educationMapper){
        this.educationRepository = educationRepository;
        this.educationMapper = educationMapper;
    }


    @Override
    public List<EducationDTO> getAll() {
        List<EducationEntity> entities = educationRepository.findAll();
        if(entities.isEmpty()){
            throw new ParamNotFound("Education list is empty");
        }
        List<EducationDTO> result = educationMapper.educationEntity2DTOList(entities, true);
        return result;
    }

    @Override
    public EducationDTO save(EducationDTO educationDTO) {
        EducationEntity entity = educationMapper.educationDTO2Entity(educationDTO, false);
        EducationEntity educationSaved = educationRepository.save(entity);
        EducationDTO result = educationMapper.educationEntity2DTO(educationSaved, false);
        return result;
    }

    @Override
    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public EducationDTO update(Long id, EducationDTO educationDTO) {
        EducationEntity entity = educationRepository.findById(id).orElse(null);
        if(Objects.isNull(entity)){
            throw new ParamNotFound("Education id is not valid");
        }
        entity.setTitle(educationDTO.getTitle());
        entity.setImage(educationDTO.getImage());
        EducationEntity educationSaved = educationRepository.save(entity);
        EducationDTO result = educationMapper.educationEntity2DTO(educationSaved, true);
        return result;
    }

    @Override
    public EducationEntity getEntityById(Long idEducation) {
        EducationEntity entity = this.educationRepository.getById(idEducation);
        if(Objects.isNull(entity)){
            throw new ParamNotFound("Education id is not valid");
        }
        return entity;
    }
}