package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.PersonDTO;
import com.argprog.portfolio.entity.*;
import com.argprog.portfolio.exception.ParamNotFound;
import com.argprog.portfolio.mapper.LanguageMapper;
import com.argprog.portfolio.mapper.PersonMapper;
import com.argprog.portfolio.mapper.ResidenceMapper;
import com.argprog.portfolio.repository.PersonRepository;
import com.argprog.portfolio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class PersonServiceImpl implements PersonService {

   //Mappers
    private PersonMapper personMapper;
    private ResidenceMapper residenceMapper;
    private LanguageMapper languageMapper;
    //Repo
    private PersonRepository personRepository;
    //Service
    private EducationService educationService;
    private ProjectService projectService;
    private LanguageService languageService;
    private TechnologyService technologyService;
    private WorkExperienceService workExperienceService;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository,
                             PersonMapper personMapper,
                             ResidenceMapper residenceMapper,
                             LanguageMapper languageMapper,
                             EducationService educationService,
                             ProjectService projectService,
                             LanguageService languageService,
                             TechnologyService technologyService){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.residenceMapper = residenceMapper;
        this.languageMapper = languageMapper;
        this.educationService = educationService;
        this.projectService = projectService;
        this.languageService = languageService;
        this.technologyService = technologyService;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        List<PersonEntity> entities = personRepository.findAll();
        if(entities.isEmpty()){
            throw new ParamNotFound("Person list is empty");
        }
        List<PersonDTO> result = personMapper.personEntity2DTOList(entities,true);
        return  result;
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity entity = this.personMapper.personDTO2Entity(personDTO,true);
        PersonEntity personSaved = this.personRepository.save(entity);
        PersonDTO result = this.personMapper.personEntity2DTO(personSaved, true);
        return result;
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonDTO update(Long id, PersonDTO personDTO) {
       PersonEntity entity = personRepository.findById(id).orElse(null);
       if(Objects.isNull(entity)){
           throw new ParamNotFound("Person id is not valid");
       }
       entity.setFirstName(personDTO.getFirstName());
       entity.setLastName(personDTO.getLastName());
       entity.setOccupation(personDTO.getOccupation());
       entity.setImageProfile(personDTO.getImageProfile());
       entity.setNationality(personDTO.getNationality());
       entity.setEmail(personDTO.getEmail());
       entity.setAboutMe(personDTO.getAboutMe());
       entity.setBirthDate(personDTO.getBirthDate());
       entity.setImageBackgroundHeader(personDTO.getImageBackgroundHeader());
       PersonEntity personSaved = personRepository.save(entity);
       PersonDTO result = personMapper.personEntity2DTO(personSaved, true);
       return result;
    }

    @Override
    public void addEducation(Long id, Long idEducation) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getEducations().size();
        EducationEntity education = this.educationService.getEntityById(idEducation);
        entity.addEducation(education);
        this.personRepository.save(entity);
    }

    @Override
    public void removeEducation(Long id, Long idEducation) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getEducations().size();
        EducationEntity education = this.educationService.getEntityById(idEducation);
        entity.removeEducation(education);
        this.personRepository.save(entity);

    }

    @Override
    public void addProject(Long id, Long idProject) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getProjects().size();
        ProjectEntity project = this.projectService.getEntityById(idProject);
        entity.addProject(project);
        this.personRepository.save(entity);
    }

    @Override
    public void removeProject(Long id, Long idProject) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getProjects().size();
        ProjectEntity project = this.projectService.getEntityById(idProject);
        entity.removeProject(project);
        this.personRepository.save(entity);
    }

    @Override
    public void addLanguage(Long id, Long idLanguage) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getLanguages().size();
        LanguageEntity language = this.languageService.getEntityById(idLanguage);
        entity.addLanguage(language);
        this.personRepository.save(entity);
    }

    @Override
    public void removeLanguage(Long id, Long idLanguage) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getLanguages().size();
        LanguageEntity language = this.languageService.getEntityById(idLanguage);
        entity.removeLanguage(language);
        this.personRepository.save(entity);
    }

    @Override
    public void addTechnology(Long id, Long idTechnology) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getTechnologies().size();
        TechnologyEntity technology = this.technologyService.getEntityById(idTechnology);
        entity.addTechnology(technology);
        this.personRepository.save(entity);
    }

    @Override
    public void removeTechnology(Long id, Long idTechnology) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getTechnologies().size();
        TechnologyEntity technology = this.technologyService.getEntityById(idTechnology);
        entity.removeTechnology(technology);
        this.personRepository.save(entity);
    }

    @Override
    public void addExperiencie(Long id, Long idExperiencie) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getTechnologies().size();
        WorkExperienceEntity experience = this.workExperienceService.getEntityById(idExperiencie);
        entity.addWorkExperiencie(experience);
        this.personRepository.save(entity);
    }

    @Override
    public void removeExperiencie(Long id, Long idExperiencie) {
        PersonEntity entity = this.personRepository.getById(id);
        entity.getTechnologies().size();
        WorkExperienceEntity experience = this.workExperienceService.getEntityById(idExperiencie);
        entity.removeWorkExperience(experience);
        this.personRepository.save(entity);
    }
}
