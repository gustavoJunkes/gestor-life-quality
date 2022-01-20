package com.gustavojunkes.gestorlifequality.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class AvaliationTheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double score;

    @NotNull
    private String themeName;

    private String description;

    @ManyToMany
    private List<Avaliation> avaliations;

    @ManyToMany
    private List<Question> questions;

    public AvaliationTheme(String themeName){
        this.themeName = themeName;
    }

    public AvaliationTheme(Long id, String themeName, String description, Double score, List<Question>questions){
        this.id = id;
        this.themeName = themeName;
        this.score = score;
        this.questions = questions;
        this.description = description;
    }

    public AvaliationTheme(){}


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
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
