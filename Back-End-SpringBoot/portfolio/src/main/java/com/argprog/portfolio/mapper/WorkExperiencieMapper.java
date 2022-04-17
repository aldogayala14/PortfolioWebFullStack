package com.argprog.portfolio.mapper;


import com.argprog.portfolio.dto.WorkExperiencieDTO;
import com.argprog.portfolio.entity.WorkExperienceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

@Component
public class WorkExperiencieMapper {

    @Autowired
    private PersonMapper personMapper;

    public WorkExperienceEntity workExperienceDTO2Entity(WorkExperiencieDTO workExperiencieDTO){
        WorkExperienceEntity entity = new WorkExperienceEntity();
        entity.setCompany(workExperiencieDTO.getCompany());
        entity.setImage(workExperiencieDTO.getImage());
        entity.setObservations(workExperiencieDTO.getObservations());
        entity.setOccupation(workExperiencieDTO.getOccupation());
        entity.setOccupationStart(workExperiencieDTO.getOccupationStart());
        entity.setOccupationEnd(workExperiencieDTO.getOccupationEnd());
        entity.setPersonExperience(personMapper.personDTO2Entity(workExperiencieDTO.getPersonExperience()));
        return entity;
    }

    public WorkExperiencieDTO workExperiencieEntity2DTO(WorkExperienceEntity entity){
        WorkExperiencieDTO workExperiencieDTO = new WorkExperiencieDTO();
        workExperiencieDTO.setId(entity.getId());
        workExperiencieDTO.setCompany(entity.getCompany());
        workExperiencieDTO.setImage(entity.getImage());
        workExperiencieDTO.setOccupation(entity.getOccupation());
        workExperiencieDTO.setOccupationStart(entity.getOccupationStart());
        workExperiencieDTO.setOccupationEnd(entity.getOccupationEnd());
        workExperiencieDTO.setObservations(entity.getObservations());
        workExperiencieDTO.setPersonExperience(personMapper.personEntity2DTO(entity.getPersonExperience()));
        return workExperiencieDTO;
    }
}
