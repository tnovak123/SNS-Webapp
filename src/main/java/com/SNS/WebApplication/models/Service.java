package com.SNS.WebApplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters long.")
    private String name;

    @NotNull
    private String description;

    @ManyToOne
    private RewardValue rewardValue;

    @NotNull
    private Double price;

    public Service() {
    }

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

    public RewardValue getRewardValue() {
        return rewardValue;
    }

    public void setRewardValue(RewardValue rewardValue) {
        this.rewardValue = rewardValue;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
