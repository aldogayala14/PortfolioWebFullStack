package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.WorkExperiencieDTO;
import com.argprog.portfolio.entity.WorkExperienceEntity;
import com.argprog.portfolio.exception.ParamNotFound;
import com.argprog.portfolio.mapper.PersonMapper;
import com.argprog.portfolio.mapper.WorkExperiencieMapper;
import com.argprog.portfolio.repository.WorkExperiencieRepository;
import com.argprog.portfolio.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {


    @Autowired
    private WorkExperiencieMapper workExperiencieMapper;
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private WorkExperiencieRepository workExperiencieRepository;


    @Override
    public List<WorkExperiencieDTO> getAllExperiencies() {
        List<WorkExperienceEntity> entities = workExperiencieRepository.findAll();
        if(entities.isEmpty()){
            throw new ParamNotFound("WorkExperience list is empty");
        }
        List<WorkExperiencieDTO> result = workExperiencieMapper.workExperiencieEntity2DTOList(entities, true);
        return result;
    }

    @Override
    public WorkExperiencieDTO save(WorkExperiencieDTO workExperiencieDTO) {
        WorkExperienceEntity entity = workExperiencieMapper.workExperienceDTO2Entity(workExperiencieDTO , false);
        WorkExperienceEntity experienceSaved = workExperiencieRepository.save(entity);
        WorkExperiencieDTO result = workExperiencieMapper.workExperiencieEntity2DTO(experienceSaved, false);
        return  result;
    }

    @Override
    public void delete(Long id) {
        workExperiencieRepository.deleteById(id);

    }

    @Override
    public WorkExperiencieDTO update(Long id, WorkExperiencieDTO workExperiencieDTO) {
        WorkExperienceEntity entity = workExperiencieRepository.findById(id).orElse(null);
        if(Objects.isNull(entity)){
            throw new ParamNotFound("WorkExperiencie id is not valid");
        }
        entity.setImage(workExperiencieDTO.getImage());
        entity.setOccupation(workExperiencieDTO.getOccupation());
        entity.setObservations(workExperiencieDTO.getObservations());
        entity.setOccupationStart(workExperiencieDTO.getOccupationStart());
        entity.setOccupationEnd(workExperiencieDTO.getOccupationEnd());
        entity.setCompany(workExperiencieDTO.getCompany());
        WorkExperienceEntity experienceSaved = workExperiencieRepository.save(entity);
        WorkExperiencieDTO result = workExperiencieMapper.workExperiencieEntity2DTO(experienceSaved, true);
        return result;
    }

    @Override
    public WorkExperienceEntity getEntityById(Long idExperiencie) {
        WorkExperienceEntity entity = this.workExperiencieRepository.getById(idExperiencie);
        return entity;
    }
}
