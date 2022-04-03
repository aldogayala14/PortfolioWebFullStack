package com.argprog.portfolio.mapper;

import com.argprog.portfolio.dto.EducationDTO;
import com.argprog.portfolio.entity.EducationEntity;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public class EducationMapper {

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
     //TODO : mapper Education convert DTO2Entity
     //entity.setPersonEducation(educationDTO.getPersonEducation());
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
     // TODO: Ver conversion
     //educationDTO.setPersonEducation(entity.getPersonEducation());
     return educationDTO;
 }
}
