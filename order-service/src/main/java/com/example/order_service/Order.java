package com.example.order_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity // This annotation marks the class as a JPA entity, which means it will be mapped to a database table
@Table(name="orders")
public class Order {
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String item;

    //Getters
    public Long getId() {  return id;   }
    public Long getUserId() {  return userId;   }
    public String getItem() {  return item;   }
}
