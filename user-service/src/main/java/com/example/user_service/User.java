package com.example.user_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.*;

import com.example.user_service.orders.OrderDTO;


@Entity // This annotation marks the class as a JPA entity, which means it will be mapped to a database table
@Table(name="users") //user is a reserved keyword; this is why we need to specify the table name explicitly
public class User {

    @Id // This annotation marks the field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation specifies that the primary key will be generated automatically by the database
    private Long id;
    private String name;

    @Transient 
    private List<OrderDTO> orders;

    // Getters and setters
    public Long getId() {  
        return id;    
    }

    public String getName() {  
        return name;   
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }


  
   
}
