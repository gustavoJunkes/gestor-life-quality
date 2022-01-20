package com.gustavojunkes.gestorlifequality.model.dto;

import com.gustavojunkes.gestorlifequality.model.User;

public class DefaultQuestionDto {

    public Long id;
    public Double score;
    public String tittle;

    public DefaultQuestionDto(Long id, String tittle, Double score){
        this.score = score;
        this.id = id;
        this.tittle = tittle;
    }
}
