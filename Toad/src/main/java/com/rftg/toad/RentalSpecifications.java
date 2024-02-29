package com.rftg.toad;
import org.springframework.data.jpa.domain.Specification;

public class RentalSpecifications {
    public static Specification<Rental> hasState(String state) {
        return (root, query, cb) ->
        cb.equal(root.<String>get("state"), state);
  }

    }
