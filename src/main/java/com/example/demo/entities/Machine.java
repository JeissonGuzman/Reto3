package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="machine")
public class Machine implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private Integer id;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String brand;
    @Column(length = 250)
    private String description;
    private Integer año;
    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("machines")
    private Category category;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }
}
