package com.argprog.portfolio.controller;


import com.argprog.portfolio.dto.ResidenceDTO;
import com.argprog.portfolio.service.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/residence")
public class ResidenceController {

    @Autowired
    private ResidenceService residenceService;

    @GetMapping
    public ResponseEntity<List<ResidenceDTO>> getAll(){
        List<ResidenceDTO> dtos = residenceService.getAllResidences();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ResidenceDTO> save(@RequestBody ResidenceDTO residenceDto){
        ResidenceDTO residenceSave = residenceService.save(residenceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(residenceSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        residenceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResidenceDTO> update(@PathVariable Long id,@RequestBody ResidenceDTO residenceDTO){
        ResidenceDTO result = residenceService.update(id,residenceDTO);
        return ResponseEntity.ok().body(result);
    }
}
