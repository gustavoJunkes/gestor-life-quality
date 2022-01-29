package com.gustavojunkes.gestorlifequality.model.dto;

public class DefaultAnswerDto {

    public Long id;
    public String description;
    public Boolean isRight;

    public DefaultAnswerDto(Long id, String description, Boolean isRight){
        this.description = description;
        this.isRight = isRight;
        this.id = id;
    };
}