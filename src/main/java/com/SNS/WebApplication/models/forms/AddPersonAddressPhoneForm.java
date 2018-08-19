package com.SNS.WebApplication.models.forms;

import com.SNS.WebApplication.models.Person;
import com.SNS.WebApplication.models.PersonType;
import com.SNS.WebApplication.models.Address;
import com.SNS.WebApplication.models.Phone;

import javax.validation.constraints.NotNull;


public class AddPersonAddressPhoneForm {

    @NotNull
    private Integer personId;

    @NotNull
    private Integer personTypeId;

    @NotNull
    private Integer addressId;

    @NotNull
    private Integer phoneId;

    private Person person;

    private Iterable<PersonType> personTypes;

    private Address address;

    private Phone phone;

    public AddPersonAddressPhoneForm(){}

    public AddPersonAddressPhoneForm(Person person, Address address) {
        this.person = person;
        this.address = address;
    }

    public AddPersonAddressPhoneForm(Person person, Phone phone) {
        this.person = person;
        this.phone = phone;
    }

    public AddPersonAddressPhoneForm(Iterable<PersonType> personTypes) {
        this.personTypes = personTypes;
    }

    public AddPersonAddressPhoneForm(Person person, Address address, Phone phone) {
        this.person = person;
        this.address = address;
        this.phone = phone;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(Integer personTypeId) {
        this.personTypeId = personTypeId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Person getPerson() {
        return person;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }
}
