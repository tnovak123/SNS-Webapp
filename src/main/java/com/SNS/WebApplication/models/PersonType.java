package com.SNS.WebApplication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PersonType {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String Type;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
