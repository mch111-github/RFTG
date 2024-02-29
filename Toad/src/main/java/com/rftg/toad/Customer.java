package com.rftg.toad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class Customer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    // Méthodes get et set pour les autres attributs (INT et String)

    private String customer_id;
    private String first_name;
    private String last_name;
    private String email;
    private String address_id;
    private String active;
    private String create_date;
    private String last_update;
    private String birthdate;
    private String role_id;
    private String password;

    public String getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress_id() {
        return address_id;
    }
    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }
    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }
    public String getCreate_date() {
        return create_date;
    }
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getRole_id() {
        return role_id;
    }
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
  
   