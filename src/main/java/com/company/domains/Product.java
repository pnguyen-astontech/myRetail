package com.company.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.*;
/**
 * Created by petenguy1 on 12/22/2016.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Id
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne
    private CurrentPrice current_price;

    public Product() {
    }

    public Product(Long id, String name, CurrentPrice currentPrice) {
        this.id = id;
        this.name = name;
        this.current_price = currentPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentPrice getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(CurrentPrice current_price) {
        this.current_price = current_price;
    }
}
