package com.dev.backend.dto;

import org.springframework.beans.BeanUtils;

import com.dev.backend.entity.User;

import lombok.Data;

@Data
public class UserClientRequestDTO {
    
    private String name;
    private String cpf;
    private String email;
    private String address;
    private String cep;
    private String city;

    public User converter(UserClientRequestDTO userClientRequestDTO) {
        User user = new User();
        BeanUtils.copyProperties(userClientRequestDTO, user);
        return user;
    }
}
