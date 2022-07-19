package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.ProjectDTO;
import com.argprog.portfolio.entity.ProjectEntity;
import com.argprog.portfolio.exception.ParamNotFound;
import com.argprog.portfolio.mapper.PersonMapper;
import com.argprog.portfolio.mapper.ProjectMapper;
import com.argprog.portfolio.mapper.TechnologyMapper;
import com.argprog.portfolio.repository.ProjectRepository;
import com.argprog.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private TechnologyMapper technologyMapper;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectDTO> getAllPorjects() {
        List<ProjectEntity> entities = projectRepository.findAll();
        if(entities.isEmpty()){
            throw new ParamNotFound("Project list is empty");
        }
        List<ProjectDTO> result = projectMapper.projectEntity2DTOList(entities, true);
        return result;
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        ProjectEntity entity = projectMapper.projectDTO2Entity(projectDTO, false);
        ProjectEntity projectSaved = projectRepository.save(entity);
        ProjectDTO result = projectMapper.projectEntity2DTO(projectSaved, false);
        return result;
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDTO update(Long id, ProjectDTO projectDTO) {
        ProjectEntity entity = projectRepository.findById(id).orElse(null);
        if(Objects.isNull(entity)){
            throw new ParamNotFound("Project id is not valid");
        }
        entity.setImage(projectDTO.getImage());
        entity.setName(projectDTO.getName());
        entity.setProjectStart(projectDTO.getProjectStart());
        entity.setProjectEnd(projectDTO.getProjectEnd());
        entity.setUrl(projectDTO.getUrl());
        ProjectEntity projectSaved = projectRepository.save(entity);
        ProjectDTO result = projectMapper.projectEntity2DTO(projectSaved, true);
        return result;
    }

    @Override
    public ProjectEntity getEntityById(Long idProject) {
        ProjectEntity project = this.projectRepository.getById(idProject);
        return project;
    }
}
