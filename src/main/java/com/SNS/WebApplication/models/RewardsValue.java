package com.SNS.WebApplication.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RewardsValue {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer value;

    private Integer cost;

    //@OneToMany
    //@JoinColumn(name = "rewardsvalue_id")
    //private List<Service> services = new ArrayList<>();

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

//    public List<Service> getServices() {
//        return services;
//    }
}
