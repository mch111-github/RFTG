package com.rftg.toad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class State {
    @Id
    private Integer id;
    private Integer valeurs;
    private String libelle;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getValeurs() {
        return valeurs;
    }
    public void setValeurs(Integer valeurs) {
        this.valeurs = valeurs;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
