package com.gustavojunkes.gestorlifequality.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;

//    reason for the answer be right
    private String description;

    private Boolean isRight;

    public Answer(Long id, String description, Boolean isRight){
        this.id = id;
        this.description = description;
        this.isRight = isRight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsRight() {
        return isRight;
    }

    public void setIsRight(Boolean isRight) {
        this.isRight = isRight;
    }
}
