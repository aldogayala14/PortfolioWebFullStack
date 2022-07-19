package com.argprog.portfolio.controller;

import com.argprog.portfolio.dto.LanguageDTO;
import com.argprog.portfolio.dto.PersonDTO;
import com.argprog.portfolio.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> getAll(){
        List<LanguageDTO> dtos = languageService.getAllLanguages();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<LanguageDTO> save(@RequestBody LanguageDTO languageDTO){
        LanguageDTO languageSaved = languageService.save(languageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(languageSaved);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        languageService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageDTO> update(@PathVariable Long id, @RequestBody LanguageDTO languageDTO){
        LanguageDTO result = languageService.update(id,languageDTO);
        return ResponseEntity.ok().body(result);
    }
}
