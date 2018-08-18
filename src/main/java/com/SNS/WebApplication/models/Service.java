package com.SNS.WebApplication.models;

import javax.persistence.*;
import java.util.Currency;
import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    //private List<RewardsValue> rewardsValues = new ArrayList<>();

    private Currency price;

    public Integer getId() {
        return id;
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

//    public List<RewardsValue> getRewardsValue() {
//        return rewardsValues;
//    }

    public Currency getPrice() {
        return price;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }
}
