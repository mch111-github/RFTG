package com.rftg.toad;

import java.sql.Timestamp;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Actor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "actor_id")

    // Méthodes get et set pour les autres attributs (INT et String)

    private Integer actor_id;
    private String first_name;
    private String last_name;
    private Timestamp last_update;

 @ManyToMany(mappedBy = "actors")
    private List<Film> films;

    public Integer getActor_id() {
        return actor_id;
    }
    public void setActor_id(Integer actor_id) {
        this.actor_id = actor_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public Timestamp getLast_update() {
        return last_update;
    }
    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

}