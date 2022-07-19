package com.argprog.portfolio.mapper;

import com.argprog.portfolio.dto.ProjectDTO;
import com.argprog.portfolio.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper {

    @Autowired
    private PersonMapper personMapper;
    private TechnologyMapper technologyMapper;

    public ProjectEntity projectDTO2Entity(ProjectDTO projectDTO, boolean loadPersons){
        ProjectEntity entity = new ProjectEntity();
        entity.setName(projectDTO.getName());
        entity.setImage(projectDTO.getImage());
        entity.setProjectStart(projectDTO.getProjectStart());
        entity.setProjectEnd(projectDTO.getProjectEnd());
        entity.setUrl(projectDTO.getUrl());
        if(loadPersons){
            entity.setPersons(personMapper.personDTO2EntityList(projectDTO.getPersons(), false));
        }
        return entity;
    }


    public ProjectDTO projectEntity2DTO(ProjectEntity entity, boolean loadPersons){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(entity.getId());
        projectDTO.setName(entity.getName());
        projectDTO.setImage(entity.getImage());
        projectDTO.setProjectStart(entity.getProjectStart());
        projectDTO.setProjectEnd(entity.getProjectEnd());
        projectDTO.setUrl(entity.getUrl());
        if(loadPersons){
            projectDTO.setPersons(personMapper.personEntity2DTOList(entity.getPersons(), false));
        }
        return projectDTO;
    }

    public List<ProjectEntity> projectDTO2EntityList(List<ProjectDTO> dtos, boolean loadPersons){
        List<ProjectEntity> entities = new ArrayList<>();
        for(ProjectDTO dto : dtos){
            entities.add(this.projectDTO2Entity(dto, loadPersons));
        }
        return entities;
    }

    public List<ProjectDTO> projectEntity2DTOList(List<ProjectEntity> entities, boolean loadPersons){
        List<ProjectDTO> dtos = new ArrayList<>();
        for(ProjectEntity entity:entities){
            dtos.add(this.projectEntity2DTO(entity, loadPersons));
        }
        return dtos;
    }
}
