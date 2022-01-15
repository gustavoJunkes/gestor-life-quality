package com.gustavojunkes.gestorlifequality.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    @OneToMany
    private List<Avaliation> avaliations;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public User(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Avaliation> getAvaliations() {
        return avaliations;
    }

    public void setAvaliations(List<Avaliation> avaliations) {
        this.avaliations = avaliations;
    }
}
