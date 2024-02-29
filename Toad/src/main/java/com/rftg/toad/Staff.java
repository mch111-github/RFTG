package com.rftg.toad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class Staff {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    // Méthodes get et set pour les autres attributs (INT et String)

    private String staff_id;
    private String first_name;
    private String last_name;
    private String address_id;
    private String picture; 
    private String email;
    private String store_id;
    private String active;
    private String username;
    private String password;
    private String last_update;
    private String role_id;
    
    public String getStaff_id() {
        return staff_id;
    }
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getAddress_id() {
        return address_id;
    }
    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStore_id() {
        return store_id;
    }
    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }
    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
    public String getRole_id() {
        return role_id;
    }
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    

}