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
   private int yearBorn, age;
   private String postalCode, address, firstName, lastName, streetAddress, city, province;
   private LocalDate birthdate;
    
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
    }  // end of constructor 
    
    /*
         get method for year
    */
    public int getYearBorn() {
        return yearBorn;
    }
    
    /*
      set method for yearBorn    
    */
    
    public void setYearBorn() {
        this.yearBorn = birthdate.getYear();
    }

    public int getAge() {
        return age;
    }
    /**
     * these all setter and getter methods for all variable
     */
    public void setAge() {
        Calendar now = Calendar.getInstance();  
        int year = now.get(Calendar.YEAR);      
        this.age = year - getYearBorn() - 1;
    }
    /**
     * this is get method for postal code
     * @return 
     */
    public String getPostalCode() {
        return postalCode.toUpperCase();
    }
    /**
     * this is set method for postal code
     * @param postalCode 
     */
    public void setPostalCode(String postalCode) {
        if ((postalCode.length() == 6) && setPostalCodeInvalidPattern(postalCode) )
            this.postalCode = postalCode;
        else 
            throw new IllegalArgumentException("the invalid postal code should have thrown an exception");
    }
    /**
     * this is get method for address
     * @return 
     */
    public String getAddress() {
        return address;
    }
    /**
     * this is set method for address
     * @param address 
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * this is get method for firstName
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * this is set method for first name
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * this is get method for lastName
     * @return 
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * this is set method for LastName
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * this is get method for the street Address
     * @return 
     */
    public String getStreetAddress() {
        return streetAddress;
    }
    /**
     * this is set method for the street Address
     * @param streetAddress 
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    /**
     * this is get method for the city name
     * @return 
     */
    public String getCity() {
        return city;
    }
    /**
     * this is set method for the city
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * this is get  method for the province name
     * @return 
     */
    public String getProvince() {
        return province;
    }
    /**
     * this is set method for the province name
     * @param province 
     */
    public void setProvince(String province) {
        this.province = province;
    }
    /**
     * this is get method for the birthday
     * @return 
     */
    public LocalDate getBirthday() {
        return birthdate;
    }
    /**
     * this is set method for the BirthDate
     * @param birthdate 
     */
    public void setBirthday(LocalDate birthdate) {
        this.birthdate = birthdate;
    }    
    /*
    this testInvalidPerson method for person  
    */
    public void testInvalidPerson() {
        if (postalCode.length() == 6)
            this.postalCode = postalCode;
        else 
            throw new IllegalArgumentException("the invalid postal code should have thrown an exception");
    }
    /*
     this method change and set the method for address
    */
    public void changeAddress(String street, String city, String province, String postalCode) {
        setStreetAddress(street);
        setCity(city);
        setProvince(province);
        setPostalCode(postalCode);
    }
    /*
       this is get method for the address
    */
    public String getFullAddress() {
        address = getStreetAddress() + ", " + getCity() + ", " + getProvince() + ", " + getPostalCode();
        return address;
    }
    
    
    public String toString()
    {
        return firstName+" "+ lastName;
    }
    /**
     * This method will validate Postal code with each and every character
     * @param postCode
     * @return 
     */
    public boolean setPostalCodeInvalidPattern(String postCode) {
        if ((postCode.length()== 0)
                || (!Character.isLetter(postCode.charAt(0)))
                || (!Character.isDigit(postCode.charAt(1)))
                || (!Character.isLetter(postCode.charAt(2)))
                || (!Character.isDigit(postCode.charAt(3)))
                || (!Character.isLetter(postCode.charAt(4))) 
                || (!Character.isDigit(postCode.charAt(5)))
            )    {
            return false;
            
        }
                else
          {
             return true;
          }    
    }
}  // end of class
