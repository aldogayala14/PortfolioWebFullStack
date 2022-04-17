package com.argprog.portfolio.controller;


import com.argprog.portfolio.dto.PersonDTO;
import com.argprog.portfolio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("person")
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


}
