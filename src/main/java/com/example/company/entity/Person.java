package com.example.company.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long personId;
    private String firstName;
    private String lastName;
    private String address;
    private String cellPhone;
    private String cityName;

    protected Person() {}

    /**
     * Constructor for example purposes.
     * @param firstName
     */
    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, String lastName, String address, String cellPhone, String cityName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cellPhone = cellPhone;
        this.cityName = cityName;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getCityName() {
        return cityName;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return String.format("Person[id=%d, firstName='%s', lastName='%s', address='%s', " +
                        "cellPhone='%s', cityName='%s']", personId, firstName, lastName,
                address, cellPhone, cityName);
    }
}
