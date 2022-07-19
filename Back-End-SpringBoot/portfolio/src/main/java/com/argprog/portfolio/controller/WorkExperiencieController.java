package com.argprog.portfolio.controller;

import com.argprog.portfolio.dto.WorkExperiencieDTO;
import com.argprog.portfolio.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("api/workexperiencie")
public class WorkExperiencieController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @GetMapping
    public ResponseEntity<List<WorkExperiencieDTO>> getAll(){
        List<WorkExperiencieDTO> dtos = workExperienceService.getAllExperiencies();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<WorkExperiencieDTO> save(@RequestBody WorkExperiencieDTO workExperiencieDTO){
        WorkExperiencieDTO experienceSaved = workExperienceService.save(workExperiencieDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(experienceSaved);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        workExperienceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<WorkExperiencieDTO> update(@PathVariable Long id, @RequestBody WorkExperiencieDTO workExperiencieDTO){
        WorkExperiencieDTO result = workExperienceService.update(id,workExperiencieDTO);
        return ResponseEntity.ok().body(result);
    }
}
