package com.argprog.portfolio.controller;

import com.argprog.portfolio.dto.TechnologyDTO;
import com.argprog.portfolio.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @GetMapping
    public ResponseEntity<List<TechnologyDTO>> getAll(){
        List<TechnologyDTO> dtos = technologyService.getAllTechnologies();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<TechnologyDTO> save(@RequestBody TechnologyDTO technologyDTO){
        TechnologyDTO technologySaved = technologyService.save(technologyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(technologySaved);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        technologyService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyDTO> update(@PathVariable Long id, @RequestBody TechnologyDTO technologyDTO){
        TechnologyDTO result = technologyService.update(id,technologyDTO);
        return ResponseEntity.ok().body(result);
    }

}
