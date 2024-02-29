package com.rftg.toad;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Inventory {
        @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "inventory_id")
    private Integer inventory_id;
    private Integer film_id;
    private Integer store_id;
    private Timestamp last_update;
    private Integer state_id;

    public Integer getInventory_id() {
        return inventory_id;
    }
    public void setInventory_id(Integer inventory_id) {
        this.inventory_id = inventory_id;
    }
    public Integer getFilm_id() {
        return film_id;
    }
    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }
    public Integer getStore_id() {
        return store_id;
    }
    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }
    public Timestamp getLast_update() {
        return last_update;
    }
    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public Integer getState_id() {
        return state_id;
    }
    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

}


