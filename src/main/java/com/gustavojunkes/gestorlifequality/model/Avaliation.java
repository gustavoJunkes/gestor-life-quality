package com.gustavojunkes.gestorlifequality.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Avaliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    * Entender o que isso vira no banco e como reage com as consultas especificas
    * */
    @ManyToOne
    private User user;

    private Double score;

    @ManyToMany
    private List<AvaliationTheme> avaliationThemes;

    public Avaliation(Double score, User user){
        this.score = score;
        this.user = user;
    }

    public Avaliation(Double score, User user, List<AvaliationTheme>avaliationThemes){
        this.score = score;
        this.user = user;
        this.avaliationThemes = avaliationThemes;
    }

    public Avaliation(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getScore(){
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<AvaliationTheme> getAvaliationThemes() {
        return avaliationThemes;
    }

    public void setAvaliationThemes(List<AvaliationTheme> avaliationThemes) {
        this.avaliationThemes = avaliationThemes;
    }
}
