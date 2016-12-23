package com.company.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double value;
    private String currency_code;

    public CurrentPrice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }
}
