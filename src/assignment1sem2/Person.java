/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1sem2;

import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Calendar;

/**
 *
 * @author Rutul
 */
public class Person {
int yearBorn, age;
    String postalCode, address, firstName, lastName, streetAddress, city, province;
    LocalDate birthdate;
    
    public Person(String firstName, String lastName, String streetAddress, String city, String province, String postalCode, LocalDate birthdate) {
        this.postalCode = postalCode;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.birthdate = birthdate;
        setYearBorn();
        setAge();
        testInvalidPerson();
    }
    

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn() {
        this.yearBorn = birthdate.getYear();
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        Calendar now = Calendar.getInstance();  
        int year = now.get(Calendar.YEAR);      
        this.age = year - getYearBorn() - 1;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        if (postalCode.length() == 6)
            this.postalCode = postalCode;
        else 
            throw new IllegalArgumentException("the invalid postal code should have thrown an exception");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }    
    
    public void testInvalidPerson() {
        if (postalCode.length() == 6)
            this.postalCode = postalCode;
        else 
            throw new IllegalArgumentException("the invalid postal code should have thrown an exception");
    }
    
    public void changeAddress(String street, String city, String province, String postalCode) {
        setStreetAddress(street);
        setCity(city);
        setProvince(province);
        setPostalCode(postalCode);
    }
    
    public String getFullAddress() {
        address = getStreetAddress() + ", " + getCity() + ", " + getProvince() + ", " + getPostalCode();
        return address;
    }
}
