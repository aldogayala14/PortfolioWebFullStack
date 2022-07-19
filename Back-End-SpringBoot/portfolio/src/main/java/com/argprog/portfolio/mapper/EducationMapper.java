package com.argprog.portfolio.mapper;

import com.argprog.portfolio.dto.EducationDTO;
import com.argprog.portfolio.entity.EducationEntity;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Component
public class EducationMapper {

    @Autowired
    private  PersonMapper personMapper;

 public EducationEntity educationDTO2Entity(EducationDTO educationDTO, boolean loadPersons){
     EducationEntity entity = new EducationEntity();
     entity.setCareer(educationDTO.getCareer());
     entity.setCareerStart(educationDTO.getCareerStart());
     entity.setCareerEnd(educationDTO.getCareerEnd());
     entity.setCollege(educationDTO.getCollege());
     entity.setImage(educationDTO.getImage());
     entity.setQualification(educationDTO.getQualification());
     entity.setStatus(educationDTO.getStatus());
     entity.setTitle(educationDTO.getTitle());
     if(loadPersons)
     {
         entity.setPersons(personMapper.personDTO2EntityList(educationDTO.getPersonEducation(), false));
     }
     return entity;
 }

 public EducationDTO educationEntity2DTO(EducationEntity entity, boolean loadPersons){
     EducationDTO educationDTO = new EducationDTO();
     educationDTO.setId(entity.getId());
     educationDTO.setCareer(entity.getCareer());
     educationDTO.setCareerStart(entity.getCareerStart());
     educationDTO.setCareerEnd(entity.getCareerEnd());
     educationDTO.setCollege(entity.getCollege());
     educationDTO.setTitle(entity.getTitle());
     educationDTO.setImage(entity.getImage());
     educationDTO.setStatus(entity.getStatus());
     educationDTO.setQualification(entity.getQualification());
     if(loadPersons){
         educationDTO.setPersonEducation(personMapper.personEntity2DTOList(entity.getPersons(),false));
     }
     return educationDTO;
 }


 public List<EducationDTO> educationEntity2DTOList(List<EducationEntity> entities, boolean loadPersons){
     List<EducationDTO> dtos = new ArrayList<>();
     for(EducationEntity entity : entities){
         dtos.add(this.educationEntity2DTO(entity, loadPersons));
     }

     return dtos;
 }

 public List<EducationEntity> educationDTO2EntityList(List<EducationDTO> dtos, boolean loadPersons){
     List<EducationEntity> entities = new ArrayList<>();
     for(EducationDTO dto : dtos){
         entities.add(this.educationDTO2Entity(dto, loadPersons));
     }
     return entities;
 }
}
