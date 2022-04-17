package com.argprog.portfolio.mapper;

import com.argprog.portfolio.dto.UserDTO;
import com.argprog.portfolio.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    @Autowired
    private PersonMapper personMapper;

    public UserEntity userDTO2Entity(UserDTO userDTO){
        UserEntity entity = new UserEntity();
        entity.setUserName(userDTO.getUserName());
        entity.setPassword(userDTO.getPassword());
        entity.setPerson(personMapper.personDTO2Entity(userDTO.getPerson()));
        return  entity;
    }

    public  UserDTO userEntity2DTO(UserEntity entity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setUserName(entity.getUserName());
        userDTO.setPassword(entity.getPassword());
        userDTO.setPerson(personMapper.personEntity2DTO(entity.getPerson()));
        return userDTO;
    }
}
