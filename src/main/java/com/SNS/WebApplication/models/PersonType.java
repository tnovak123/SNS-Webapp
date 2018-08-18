package com.SNS.WebApplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class PersonType {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String mytype;

    @OneToMany
    @JoinColumn(name = "persontype_id")
    private List<Person> people;

    public Integer getId() {
        return id;
    }

    public String getMytype() {
        return mytype;
    }

    public void setMytype(String mytype) {
        this.mytype = mytype;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
