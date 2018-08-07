package com.SNS.WebApplication.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<PersonType> types;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Phone> phoneList;

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

    public List<PersonType> getTypes() {
        return types;
    }

    public void setTypes(List<PersonType> types) {
        this.types = types;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
