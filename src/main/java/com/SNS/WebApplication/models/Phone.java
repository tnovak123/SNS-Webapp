package com.SNS.WebApplication.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Phone {

    @Id
    @GeneratedValue
    private Integer id;

    private String phoneNum;

    private String extension;

    private String phoneType;

    @ManyToOne
    private Person person;

    public Integer getId() {
        return id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
