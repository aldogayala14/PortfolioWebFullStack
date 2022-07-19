package com.argprog.portfolio.controller;


import com.argprog.portfolio.dto.PersonDTO;
import com.argprog.portfolio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAll(){
        List<PersonDTO> dtos = personService.getAllPersons();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO personDTO){
        PersonDTO personSaved = personService.save(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody PersonDTO personDTO){
        PersonDTO result = personService.update(id,personDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("{id}/education/{idEducation}")
    public ResponseEntity<Void> addEducation(@PathVariable Long id, @PathVariable Long idEducation){
        this.personService.addEducation(id, idEducation);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}/education/{idEducation}")
    public ResponseEntity<Void> removeEducation(@PathVariable Long id, @PathVariable Long idEducation){
        this.personService.removeEducation(id, idEducation);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("{id}/project/{idProject}")
    public ResponseEntity<Void> addProject(@PathVariable Long id, @PathVariable Long idProject){
        this.personService.addProject(id, idProject);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}/project/{idProject}")
    public ResponseEntity<Void> removeProject(@PathVariable Long id, @PathVariable Long idProject){
        this.personService.removeProject(id, idProject);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("{id}/language/{idLanguage}")
    public ResponseEntity<Void> addLanguage(@PathVariable Long id, @PathVariable Long idLanguage){
        this.personService.addLanguage(id, idLanguage);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}/language/{idLanguage}")
    public ResponseEntity<Void> removeLanguage(@PathVariable Long id, @PathVariable Long idLanguage){
        this.personService.removeLanguage(id, idLanguage);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("{id}/technology/{idTechnology}")
    public ResponseEntity<Void> addTechnology(@PathVariable Long id, @PathVariable Long idTechnology){
        this.personService.addTechnology(id, idTechnology);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}/technology/{idTechnology}")
    public ResponseEntity<Void> removeTechnology(@PathVariable Long id, @PathVariable Long idTechnology){
        this.personService.removeTechnology(id, idTechnology);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("{id}/experiencie/{idExperiencie}")
    public ResponseEntity<Void> addExperiencie(@PathVariable Long id, @PathVariable Long idExperiencie){
        this.personService.addExperiencie(id, idExperiencie);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}/experiencie/{idExperiencie}")
    public ResponseEntity<Void> removeExperiencie(@PathVariable Long id, @PathVariable Long idExperiencie){
        this.personService.removeExperiencie(id, idExperiencie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
