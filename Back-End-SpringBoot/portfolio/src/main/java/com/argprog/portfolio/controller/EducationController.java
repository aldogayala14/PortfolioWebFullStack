package com.argprog.portfolio.controller;


import com.argprog.portfolio.dto.EducationDTO;
import com.argprog.portfolio.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("education")
public class EducationController {

     @Autowired
     private EducationService educationService;

    @GetMapping
    public ResponseEntity<List<EducationDTO>> getAll(){
        List<EducationDTO> dtos = educationService.getAll();
        return  ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<EducationDTO> save(@RequestBody EducationDTO educationDTO){
        EducationDTO educationSaved = educationService.save(educationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(educationSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        educationService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationDTO> update(@PathVariable Long id, @RequestBody EducationDTO educationDTO){
        EducationDTO result = educationService.update(id,educationDTO);
        return ResponseEntity.ok().body(result);
    }
}
