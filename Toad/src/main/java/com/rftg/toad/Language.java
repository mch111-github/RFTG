package com.rftg.toad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Language {

    @Id
    @GeneratedValue

    

String language_id;
String name;
String last_update;

@ManyToMany(mappedBy = "languages")
    private List<Film> films;

public String getLanguage_id() {
    return language_id;
}
public void setLanguage_id(String language_id) {
    this.language_id = language_id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getLast_update() {
    return last_update;
}
public void setLast_update(String last_update) {
    this.last_update = last_update;
}
public Language orElse(Object object) {
    return null;
}




 
}
