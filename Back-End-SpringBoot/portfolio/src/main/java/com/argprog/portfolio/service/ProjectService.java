package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.ProjectDTO;
import com.argprog.portfolio.entity.ProjectEntity;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getAllPorjects();

    ProjectDTO save(ProjectDTO projectDTO);

    void delete(Long id);

    ProjectDTO update(Long id, ProjectDTO projectDTO);

    ProjectEntity getEntityById(Long idProject);
}
