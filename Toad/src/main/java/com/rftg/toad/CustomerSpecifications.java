package com.rftg.toad;

import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecifications {

    public CustomerSpecifications() {}
    
    public static Specification<Customer> hasFirstNameLike(String firstName) {
        return (root, query, criteriaBuilder) ->
          criteriaBuilder.like(root.<String>get("first_name"), "%" + firstName + "%");
    }

    public static Specification<Customer> hasLastName(String lastName) {
        return (root, query, cb) ->
          cb.equal(root.<String>get("last_name"), lastName);
    }

    public static Specification<Customer> HasCustomerEmailAndPassword(String email, String password) {
      return (root, query, criteriaBuilder) -> 
          criteriaBuilder.and(
              criteriaBuilder.equal(root.<String>get("email"), email),
              criteriaBuilder.equal(root.<String>get("password"), password)
          );
  }
}