package com.gustavojunkes.gestorlifequality.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
public class Avaliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    * Entender o que isso vira no banco e como reage com as consultas especificas
    * */

    private String tittle;

    private String description;

    private LocalDate date;

    @ManyToOne
    private User user;

    private Double score;

    @ManyToMany
    private List<AvaliationTheme> avaliationThemes;

//    Se refere a um numero de controle de avaliações. Se duas avaliações possuem o mesmo controlNumber, então se referem a mesma avaliação porém feita em momentos diferentes
    private Long controlNumber;

    public Avaliation(Double score, User user){
        this.score = score;
        this.user = user;
    }

    public Avaliation(Double score, String tittle, String description, User user, LocalDate date, List<AvaliationTheme>avaliationThemes, Long controlNumber){

        this.tittle = tittle;
        this.date = date;
        this.score = score;
        this.user = user;
        this.avaliationThemes = avaliationThemes;
        this.description = description;
        this.controlNumber = controlNumber;
        /*
        * Caso o numero de controle não seja informado na criação da entidade, assume-se que é uma nova criada do zero, não a partir de outra
        * */
        if(controlNumber == null){
            Random random = new Random();
            this.controlNumber = Long.valueOf(random.nextInt(1000000));
        }
    }

    public Avaliation(){}

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

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Long controlNumber) {
        this.controlNumber = controlNumber;
    }
}
