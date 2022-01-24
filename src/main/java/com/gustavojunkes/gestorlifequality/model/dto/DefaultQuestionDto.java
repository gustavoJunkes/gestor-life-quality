package com.gustavojunkes.gestorlifequality.model.dto;

import com.gustavojunkes.gestorlifequality.model.Answer;
import com.gustavojunkes.gestorlifequality.model.User;

public class DefaultQuestionDto {

    public Long id;
    public Double score;
    public String tittle;
    public String description;
    public Answer answer;

    public DefaultQuestionDto(Long id, String tittle, String description, Answer answer, Double score){
        this.score = score;
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.answer = answer;
    }
}
