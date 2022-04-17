package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.PersonDTO;
import com.argprog.portfolio.entity.PersonEntity;
import com.argprog.portfolio.mapper.PersonMapper;
import com.argprog.portfolio.repository.PersonRepository;
import com.argprog.portfolio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonDTO> getAllPersons() {
        List<PersonEntity> entities = personRepository.findAll();
        List<PersonDTO> result = personMapper.personEntity2DTOList(entities);
        return  result;
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity entity = personMapper.personDTO2Entity(personDTO);
        PersonEntity personSaved = personRepository.save(entity);
        PersonDTO result = personMapper.personEntity2DTO(personSaved);
        return result;
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonDTO update(Long id, PersonDTO personDTO) {
       PersonEntity entity = personRepository.findById(id).orElse(null);
       entity.setFirstName(personDTO.getFirstName());
       entity.setLastName(personDTO.getLastName());
       // TODO: Set elements de person Entity
       PersonEntity personSaved = personRepository.save(entity);
       PersonDTO result = personMapper.personEntity2DTO(personSaved);
       return result;
    }
}
