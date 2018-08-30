package com.SNS.WebApplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RewardValue {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer value;

    @NotNull
    private Integer cost;

    @OneToMany
    @JoinColumn(name = "reward_value_id")
    private List<Service> services = new ArrayList<>();

    public RewardValue() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
