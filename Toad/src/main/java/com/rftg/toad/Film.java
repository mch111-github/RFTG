package com.rftg.toad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Film {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    // Méthodes get et set pour les autres attributs (INT et String)

    private Integer film_id;
    private String title;
    private String description;
    private String release_year;
    private String language_id;
    private String original_language_id;
    private String rental_duration;
    private String rental_rate;
    private String length;
    private String replacement_cost;
    private String rating;
    private String special_features;
    private String last_update;


    @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "film_director", 
          joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"), 
          inverseJoinColumns = @JoinColumn(name = "director_id", 
          referencedColumnName = "director_id"))
        private List<Director> directors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",
      joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "actor_id",
      referencedColumnName = "actor_id"))
    private List<Actor> actors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_category", 
      joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"), 
      inverseJoinColumns = @JoinColumn(name = "category_id", 
      referencedColumnName = "category_id"))
    private List<Category> categories;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_language",
      joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "language_id"))
    private List<Language> languages;
  
    public Integer getFilm_id() {
      return film_id;
    }
  
    public void setFilm_id(Integer film_id) {
      this.film_id = film_id;
    }
  
    public String getTitle() {
      return title;
    }
  
    public void setTitle(String title) {
      this.title = title;
    }
  
    public String getDescription() {
      return description;
    }
  
    public void setDescription(String description) {
      this.description = description;
    }

    public String getRelease_year() {
      return release_year;
    }
  
    public void setRelease_year(String release_year) {
      this.release_year = release_year;
    }


    public String getLanguage_id() {
      return language_id;
    }
  
    public void setLanguage_id(String language_id) {
      this.language_id = language_id;
    }


    public String getOriginal_language_id() {
      return original_language_id;
    }
  
    public void setOriginal_language_id(String original_language_id) {
      this.original_language_id = original_language_id;
    }


    public String getRental_duration() {
      return rental_duration;
    }
  
    public void setRental_duration(String rental_duration) {
      this.rental_duration = rental_duration;
    }


    public String getRental_rate() {
      return rental_rate;
    }
  
    public void setRental_rate(String rental_rate) {
      this.rental_rate = rental_rate;
    }


    public String getLength() {
      return length;
    }
  
    public void setLength(String length) {
      this.length = length;
    }



    public String getReplacement_cost() {
      return replacement_cost;
    }
  
    public void setReplacement_cost(String replacement_cost) {
      this.replacement_cost = replacement_cost;
    }


    public String getRating() {
      return rating;
    }
  
    public void setRating(String rating) {
      this.rating = rating;
    }


    public String getSpecial_features() {
      return special_features;
    }
  
    public void setSpecial_features(String special_features) {
      this.special_features = special_features;
    }


    public String getLast_update() {
      return last_update;
    }
  
    public void setLast_update(String last_update) {
      this.last_update = last_update;
    }

    public List<Director> getDirectors() {
      return directors;
  }
 
    public void setDirectors(List<Director> directors) {
      this.directors = directors;
  }

  public List<Actor> getActors() {
    return actors;
}

public void setActors(List<Actor> actors) {
    this.actors = actors;
}

public List<Category> getCategories() {
  return categories;
}

public void setCategories(List<Category> categories) {
  this.categories = categories;
}

public List<Language> getLanguages() {
      return languages;
    }
 
    public void setLanguages(List<Language> languages) {
      this.languages = languages;
    }

 }

