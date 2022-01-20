package com.gustavojunkes.gestorlifequality.model.dto;

import com.gustavojunkes.gestorlifequality.model.Avaliation;
import com.gustavojunkes.gestorlifequality.model.AvaliationTheme;
import com.gustavojunkes.gestorlifequality.model.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DefaultAvaliationDto {
    public Long id;
    public Double score;
    public User user;
    public String tittle;
    public LocalDate date;
    public List<AvaliationTheme> avaliationThemes;

    public DefaultAvaliationDto(Long id, Double score, String tittle, User user, LocalDate date, List<AvaliationTheme> avaliationThemes){
        this.tittle = tittle;
        this.id = id;
        this.score = score;
        this.date = date;
        this.user = user;
        this.avaliationThemes = avaliationThemes;
    }
}
