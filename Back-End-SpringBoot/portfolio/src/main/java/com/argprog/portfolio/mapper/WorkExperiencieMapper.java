package com.argprog.portfolio.mapper;


import com.argprog.portfolio.dto.WorkExperiencieDTO;
import com.argprog.portfolio.entity.WorkExperienceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkExperiencieMapper {

    @Autowired
    private PersonMapper personMapper;

    public WorkExperienceEntity workExperienceDTO2Entity(WorkExperiencieDTO workExperiencieDTO, boolean loadPerson){
        WorkExperienceEntity entity = new WorkExperienceEntity();
        entity.setCompany(workExperiencieDTO.getCompany());
        entity.setImage(workExperiencieDTO.getImage());
        entity.setObservations(workExperiencieDTO.getObservations());
        entity.setOccupation(workExperiencieDTO.getOccupation());
        entity.setOccupationStart(workExperiencieDTO.getOccupationStart());
        entity.setOccupationEnd(workExperiencieDTO.getOccupationEnd());
        if(loadPerson){
            entity.setPersons(this.personMapper.personDTO2EntityList(workExperiencieDTO.getPersonExperiences(), false));
        }
        return entity;
    }

    public WorkExperiencieDTO workExperiencieEntity2DTO(WorkExperienceEntity entity, boolean loadData){
        WorkExperiencieDTO workExperiencieDTO = new WorkExperiencieDTO();
        workExperiencieDTO.setId(entity.getId());
        workExperiencieDTO.setCompany(entity.getCompany());
        workExperiencieDTO.setImage(entity.getImage());
        workExperiencieDTO.setOccupation(entity.getOccupation());
        workExperiencieDTO.setOccupationStart(entity.getOccupationStart());
        workExperiencieDTO.setOccupationEnd(entity.getOccupationEnd());
        workExperiencieDTO.setObservations(entity.getObservations());
        if(loadData){
            workExperiencieDTO.setPersonExperiences(personMapper.personEntity2DTOList(entity.getPersons(), false));
        }
        return workExperiencieDTO;
    }

    public List<WorkExperiencieDTO> workExperiencieEntity2DTOList(List<WorkExperienceEntity> entities, boolean loadPerson){
        List<WorkExperiencieDTO> dtos = new ArrayList<>();
        for(WorkExperienceEntity entity : entities){
            dtos.add(this.workExperiencieEntity2DTO(entity, loadPerson));
        }

        return dtos;
    }

    public List<WorkExperienceEntity> workExperiencieDTO2EntityList(List<WorkExperiencieDTO> dtos, boolean loadPerson){
        List<WorkExperienceEntity> entities = new ArrayList<>();
        for(WorkExperiencieDTO dto : dtos){
            entities.add(this.workExperienceDTO2Entity(dto, loadPerson));
        }
        return entities;
    }
}
