package com.rftg.toad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface InventoryRepository extends CrudRepository<Inventory, Integer>,  JpaRepository<Inventory, Integer>,
        JpaSpecificationExecutor<Inventory> {
    }


