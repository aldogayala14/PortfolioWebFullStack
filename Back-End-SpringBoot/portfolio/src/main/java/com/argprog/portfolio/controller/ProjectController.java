package com.argprog.portfolio.controller;

import com.argprog.portfolio.dto.ProjectDTO;
import com.argprog.portfolio.entity.ProjectEntity;
import com.argprog.portfolio.service.ProjectService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAll(){
        List<ProjectDTO> dtos = projectService.getAllPorjects();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> save(@RequestBody ProjectDTO projectDTO){
        ProjectDTO projectSaved = projectService.save(projectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(projectSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        projectService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@PathVariable Long id, @RequestBody ProjectDTO projectDTO){
        ProjectDTO result =projectService.update(id,projectDTO);
        return ResponseEntity.ok().body(result);
    }
}
