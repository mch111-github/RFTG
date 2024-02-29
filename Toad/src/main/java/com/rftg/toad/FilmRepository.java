package com.rftg.toad;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FilmRepository extends CrudRepository<Film, Integer> {

    Film findByTitle(String title);

    // Méthode pour rechercher les films par catégorie
    @Query("SELECT f FROM Film f JOIN f.categories c WHERE c = :category")
    List<Film> findByCategories(@Param("category") Category category);


}

