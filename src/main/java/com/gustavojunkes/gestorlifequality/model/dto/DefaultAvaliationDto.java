package com.gustavojunkes.gestorlifequality.model.dto;

import com.gustavojunkes.gestorlifequality.model.Avaliation;
import com.gustavojunkes.gestorlifequality.model.User;

public class DefaultAvaliationDto {
    public Double score;
    public User user;

    public DefaultAvaliationDto(Double score, User user){
        this.score = score;
        this.user = user;
    }
}
