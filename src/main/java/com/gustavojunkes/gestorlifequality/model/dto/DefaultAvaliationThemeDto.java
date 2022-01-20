package com.gustavojunkes.gestorlifequality.model.dto;

import com.gustavojunkes.gestorlifequality.model.Question;

import java.util.List;

public class DefaultAvaliationThemeDto {
    public Long id;
    public String themeTittle;
    public Double score;
    public List<Question> questions;
    public String description;

    public DefaultAvaliationThemeDto(Long id, String themeTittle,String description, Double score, List<Question> questions){
        this.id = id;
        this.score = score;
        this.themeTittle = themeTittle;
        this.questions = questions;
        this.description = description;
    }

}
