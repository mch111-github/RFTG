package com.rftg.toad;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    // Méthodes get et set pour les autres attributs (INT et String)

    private String category_id;
    private String name;

    public String getCategory_id() {
        return category_id;
      }
    
      public void setCategory_id(String category_id) {
        this.category_id = category_id;
      }

    public String getName() {
        return name;
      }
    
      public void setName(String name) {
        this.name = name;
      }

  

    @ManyToMany(mappedBy = "categories")
    private List<Film> films;
}
