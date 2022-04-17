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

 public EducationEntity educationDTO2Entity(EducationDTO educationDTO){
     EducationEntity entity = new EducationEntity();
     entity.setCareer(educationDTO.getCareer());
     entity.setCareerStart(educationDTO.getCareerStart());
     entity.setCareerEnd(educationDTO.getCareerEnd());
     entity.setCollege(educationDTO.getCollege());
     entity.setImage(educationDTO.getImage());
     entity.setQualification(educationDTO.getQualification());
     entity.setStatus(educationDTO.getStatus());
     entity.setTitle(educationDTO.getTitle());
     entity.setPersonEducation(personMapper.personDTO2Entity(educationDTO.getPersonEducation()));
     return entity;
 }

 public EducationDTO educationEntity2DTO(EducationEntity entity){
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
     educationDTO.setPersonEducation(personMapper.personEntity2DTO(entity.getPersonEducation()));
     return educationDTO;
 }


 public List<EducationDTO> educationEntity2DTOList(List<EducationEntity> entities){
     List<EducationDTO> dtos = new ArrayList<>();
     for(EducationEntity entity : entities){
         dtos.add(this.educationEntity2DTO(entity));
     }

     return dtos;
 }

 public List<EducationEntity> educationDTO2EntityList(List<EducationDTO> dtos){
     List<EducationEntity> entities = new ArrayList<>();
     for(EducationDTO dto : dtos){
         entities.add(this.educationDTO2Entity(dto));
     }
     return entities;
 }
}
