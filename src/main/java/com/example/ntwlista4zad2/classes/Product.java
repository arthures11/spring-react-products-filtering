package com.example.ntwlista4zad2.classes;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")Long id;


    public String category;
    public String producer;
    public String name;
    public String description;
    public int price;
    public String image;

    public boolean promocja;

    public Product() {
    }


    public Product(String category, String producer, String name, String description, int price, String image, boolean promocja) {
        this.category = category;
        this.producer = producer;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.promocja= promocja;
    }

    public boolean isPromocja() {
        return promocja;
    }

    public void setPromocja(boolean promocja) {
        this.promocja = promocja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
