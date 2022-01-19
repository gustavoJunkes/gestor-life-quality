package com.gustavojunkes.gestorlifequality.model.dto;

public class DefaultUserDto {
    public Long id;
    public String name;
    public String email;

    public DefaultUserDto(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
