package com.gustavojunkes.gestorlifequality.model.dto;

public class DefaultAnswerDto {

    public Long id;
    public String description;
    public boolean isRight;

    public DefaultAnswerDto(Long id, String description, boolean isRight){
        this.description = description;
        this.isRight = isRight;
        this.id = id;
    };
}