package com.SNS.WebApplication.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class PersonType {

    @Id
    @GeneratedValue
    private Integer id;

    //@NotNull
    private String type;

    @OneToMany
    @JoinColumn(name = "personType_id")
    private List<Person> persons;

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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
