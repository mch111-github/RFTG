package com.rftg.toad;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Director {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "director_id")

    private Integer director_id;
    private String firstname;
    private String lastname;
    private String nationality;

    @ManyToMany(mappedBy = "directors")
    private List<Film> films;
    
    public Integer getDirector_id() {
        return director_id;
    }
    public void setDirector_id(Integer director_id) {
        this.director_id = director_id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}

