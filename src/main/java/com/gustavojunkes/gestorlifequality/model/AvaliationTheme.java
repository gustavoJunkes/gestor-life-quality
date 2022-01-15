package com.gustavojunkes.gestorlifequality.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class AvaliationTheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float score;

    @NotNull
    private String themeName;

    @ManyToMany
    private List<Question> questions;

    public AvaliationTheme(String themeName){
        this.themeName = themeName;
    }

    public AvaliationTheme(String themeName, Float score){
        this.themeName = themeName;
        this.score = score;
    }

    public AvaliationTheme(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
