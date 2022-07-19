package com.argprog.portfolio.auth.service;

import com.argprog.portfolio.auth.dto.UserDTO;
import com.argprog.portfolio.auth.entity.UserEntity;
import com.argprog.portfolio.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(userName);
        if(userEntity == null){
            throw  new UsernameNotFoundException("Username o password not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }


    public boolean save(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepository.save(userEntity);

        return userEntity != null;
    }
}
