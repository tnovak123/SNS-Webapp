package com.SNS.WebApplication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Currency;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    private Integer rewardsEarn;

    private Integer rewardsCost;

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

    public Integer getRewardsEarn() {
        return rewardsEarn;
    }

    public void setRewardsEarn(Integer rewardsEarn) {
        this.rewardsEarn = rewardsEarn;
    }

    public Integer getRewardsCost() {
        return rewardsCost;
    }

    public void setRewardsCost(Integer rewardsCost) {
        this.rewardsCost = rewardsCost;
    }

    public Currency getPrice() {
        return price;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }
}
