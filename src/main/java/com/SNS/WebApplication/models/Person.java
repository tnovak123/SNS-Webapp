package com.SNS.WebApplication.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

 //   @NotNull
    @Size(min=3, max=50, message = "Must be between 3 and 20 characters.")
    private String fName;

 //   @NotNull
    @Size(min = 3, max = 50, message = "Must be between 3 and 50 characters.")
    private String lName;

    @ManyToOne
    private PersonType type;

    @ManyToOne
    private Address address;

    public Integer getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
