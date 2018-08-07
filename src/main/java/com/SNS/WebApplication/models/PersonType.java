package com.SNS.WebApplication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class PersonType {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String Type;

    @ManyToMany(mappedBy = "types")
    private List<Person> people;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
