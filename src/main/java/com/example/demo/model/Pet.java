package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int energy;
    private int health;
    private int happiness;
    private int designId;
    private Long ownerId;

    // Getters + setters
}
