package com.rftg.toad;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Integer> {
    @Query("SELECT s FROM State s WHERE s.valeurs = :valeurs")
    Optional<State> findByValeurs(@Param("valeurs") int valeurs);
}
