package com.SNS.WebApplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class PersonType {

    @Id
    @GeneratedValue
    private Integer id;

    //@NotNull
    private String type;

    @OneToMany
    @JoinColumn(name = "persontype_id")
    private List<Person> people;

    public PersonType(){}

    public PersonType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
