package com.argprog.portfolio.mapper;

import com.argprog.portfolio.dto.EducationDTO;
import com.argprog.portfolio.dto.PersonDTO;
import com.argprog.portfolio.entity.LanguageEntity;
import com.argprog.portfolio.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonMapper {



    private LanguageMapper languageMapper;
    private WorkExperiencieMapper workExperiencieMapper;
    private EducationMapper educationMapper;
    private TechnologyMapper technologyMapper;
    private ProjectMapper projectMapper;

    @Autowired
    public PersonMapper(@Lazy LanguageMapper languageMapper,
                        @Lazy WorkExperiencieMapper workExperiencieMapper,
                        @Lazy EducationMapper educationMapper,
                        @Lazy TechnologyMapper technologyMapper,
                        @Lazy ProjectMapper projectMapper){

        this.languageMapper = languageMapper;
        this.workExperiencieMapper = workExperiencieMapper;
        this.educationMapper = educationMapper;
        this.technologyMapper = technologyMapper;
        this.projectMapper = projectMapper;
    }

    public PersonEntity personDTO2Entity(PersonDTO personDTO, boolean loadData){
        PersonEntity entity = new PersonEntity();
        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAboutMe(personDTO.getAboutMe());
        entity.setBirthDate(personDTO.getBirthDate());
        entity.setEmail(personDTO.getEmail());
        entity.setNationality(personDTO.getNationality());
        entity.setOccupation(personDTO.getOccupation());
        entity.setImageBackgroundHeader(personDTO.getImageBackgroundHeader());
        entity.setImageProfile(personDTO.getImageProfile());
        entity.setResidenceId(personDTO.getResidenceId());
        if(loadData){
            entity.setLanguages(this.languageMapper.languageDTO2EntityList(personDTO.getLanguages(), false));
            entity.setWorkExperiences(this.workExperiencieMapper.workExperiencieDTO2EntityList(personDTO.getExperiencies(), false));
            entity.setEducations(this.educationMapper.educationDTO2EntityList(personDTO.getEducations(), false));
            entity.setProjects(this.projectMapper.projectDTO2EntityList(personDTO.getProjects(), false));
            entity.setTechnologies(this.technologyMapper.technologyDTO2EntityList(personDTO.getTechnologies(), false));
        }
        return entity;
    }

    public PersonDTO personEntity2DTO(PersonEntity entity, boolean loadData){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(entity.getId());
        personDTO.setFirstName(entity.getFirstName());
        personDTO.setLastName(entity.getLastName());
        personDTO.setAboutMe(entity.getAboutMe());
        personDTO.setNationality(entity.getNationality());
        personDTO.setEmail(entity.getEmail());
        personDTO.setBirthDate(entity.getBirthDate());
        personDTO.setOccupation(entity.getOccupation());
        personDTO.setImageProfile(entity.getImageProfile());
        personDTO.setImageBackgroundHeader(entity.getImageBackgroundHeader());
        personDTO.setResidenceId(entity.getResidenceId());
        if(loadData){
            personDTO.setLanguages(this.languageMapper.languageEntity2DTOList(entity.getLanguages(),false));
            personDTO.setExperiencies(this.workExperiencieMapper.workExperiencieEntity2DTOList(entity.getWorkExperiences(), false));
            personDTO.setEducations(this.educationMapper.educationEntity2DTOList(entity.getEducations(), false));
            personDTO.setProjects(this.projectMapper.projectEntity2DTOList(entity.getProjects(),false));
            personDTO.setTechnologies(this.technologyMapper.technologyEntity2DTOList(entity.getTechnologies(), false));
        }
        return personDTO;

    }

    public List<PersonDTO> personEntity2DTOList(List<PersonEntity> entities,boolean loadData){
        List<PersonDTO> personDTOS = new ArrayList<>();
        for(PersonEntity entity : entities){
            personDTOS.add(this.personEntity2DTO(entity, loadData));
        }
        return personDTOS;
    }

    public List<PersonEntity> personDTO2EntityList(List<PersonDTO> dtos, boolean loadData){
        List<PersonEntity> entities = new ArrayList<>();
        for(PersonDTO dto : dtos){
            entities.add(this.personDTO2Entity(dto, loadData));
        }
        return entities;
    }
}
