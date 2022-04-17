package com.argprog.portfolio.mapper;

import com.argprog.portfolio.dto.ProjectDTO;
import com.argprog.portfolio.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    @Autowired
    private PersonMapper personMapper;
    private TechnologyMapper technologyMapper;

    public ProjectEntity projectDTO2Entity(ProjectDTO projectDTO){
        ProjectEntity entity = new ProjectEntity();
        entity.setName(projectDTO.getName());
        entity.setImage(projectDTO.getImage());
        entity.setProjectStart(projectDTO.getProjectStart());
        entity.setProjectEnd(projectDTO.getProjectEnd());
        entity.setUrl(projectDTO.getUrl());
        entity.setPersonProject(personMapper.personDTO2Entity(projectDTO.getPersonProject()));
        entity.setTechnologies(technologyMapper.technologyDTO2EntityList(projectDTO.getTechnologies()));
        return entity;
    }


    public ProjectDTO projectEntity2DTO(ProjectEntity entity){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(entity.getId());
        projectDTO.setName(entity.getName());
        projectDTO.setImage(entity.getImage());
        projectDTO.setProjectStart(entity.getProjectStart());
        projectDTO.setProjectEnd(entity.getProjectEnd());
        projectDTO.setUrl(entity.getUrl());
        projectDTO.setPersonProject(personMapper.personEntity2DTO(entity.getPersonProject()));
        projectDTO.setTechnologies(technologyMapper.technologyEntity2DTOList(entity.getTechnologies()));
        return projectDTO;
    }
}
