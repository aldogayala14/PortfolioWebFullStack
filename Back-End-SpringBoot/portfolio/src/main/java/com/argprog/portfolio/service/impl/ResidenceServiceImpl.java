package com.argprog.portfolio.service.impl;

import com.argprog.portfolio.dto.ResidenceDTO;
import com.argprog.portfolio.entity.ResidenceEntity;
import com.argprog.portfolio.exception.ParamNotFound;
import com.argprog.portfolio.mapper.PersonMapper;
import com.argprog.portfolio.mapper.ResidenceMapper;
import com.argprog.portfolio.repository.ResidenceRepositoy;
import com.argprog.portfolio.service.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ResidenceServiceImpl implements ResidenceService {

    //Mappers
    private ResidenceMapper residenceMapper;
    private PersonMapper personMapper;
    //Repo
    private ResidenceRepositoy residenceRepositoy;

    @Autowired
    public ResidenceServiceImpl(ResidenceRepositoy residenceRepositoy,
                                ResidenceMapper residenceMapper,
                                PersonMapper personMapper){
        this.residenceRepositoy = residenceRepositoy;
        this.residenceMapper = residenceMapper;
        this.personMapper = personMapper;
    }

    @Override
    public List<ResidenceDTO> getAllResidences() {
        List<ResidenceEntity> entities = residenceRepositoy.findAll();
        if(entities.isEmpty()){
            throw new ParamNotFound("Residence list is empty");
        }
        List<ResidenceDTO> result = residenceMapper.residenceEntity2DTOList(entities);
        return result;
    }

    @Override
    public ResidenceDTO save(ResidenceDTO residenceDto) {
       ResidenceEntity entity = residenceMapper.residenceDTO2Entity(residenceDto);
       ResidenceEntity residenceSaved = residenceRepositoy.save(entity);
       ResidenceDTO result = residenceMapper.residenceEntity2DTO(residenceSaved);
       return result;
    }

    @Override
    public void delete(Long id) {
        residenceRepositoy.deleteById(id);

    }

    @Override
    public ResidenceDTO update(Long id, ResidenceDTO residenceDTO) {
        ResidenceEntity entity = residenceRepositoy.findById(id).orElse(null);
        if(Objects.isNull(entity)){
            throw new ParamNotFound("Residence id is not valid");
        }
        entity.setState(residenceDTO.getState());
        entity.setCountry(residenceDTO.getCountry());
        entity.setStreet(residenceDTO.getStreet());
        entity.setStreetNumbering(residenceDTO.getStreetNumbering());
        entity.setDistrict(residenceDTO.getDistrict());
        ResidenceEntity residenceSaved = residenceRepositoy.save(entity);
        ResidenceDTO result = residenceMapper.residenceEntity2DTO(residenceSaved);
        return result;
    }
}
