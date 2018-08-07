package com.SNS.WebApplication.models;

import com.SNS.WebApplication.models.Person;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

//    @NotNull
    private String addLine1;

    private String addLine2;

    private String addLine3;

//    @NotNull
    private String city;

//    @NotNull
    private String state;

//    @NotNull
    private String zipCode;

    private String postalCode;

    @ManyToMany(mappedBy = "addresses")
    private List<Person> personList;

    public Integer getId() {
        return id;
    }

    public String getAddLine1() {
        return addLine1;
    }

    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
    }

    public String getAddLine2() {
        return addLine2;
    }

    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
    }

    public String getAddLine3() {
        return addLine3;
    }

    public void setAddLine3(String addLine3) {
        this.addLine3 = addLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
