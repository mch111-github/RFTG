package com.rftg.toad;

import org.springframework.data.jpa.domain.Specification;

public class InventorySpecifications {

    public static Specification<Inventory> HasStoreIdLike(Integer store_id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.<Integer>get("store_id"), store_id);
    }

    public static Specification<Inventory> HasFilmIdAndState(Integer film_id, Integer state_id) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.and(
                criteriaBuilder.equal(root.<Integer>get("film_id"), film_id),
                criteriaBuilder.equal(root.<Integer>get("state_id"), state_id)
            );
    }
    
}
