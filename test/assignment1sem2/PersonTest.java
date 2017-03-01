
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1sem2;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JWright
 */
public class PersonTest {
    
    Person validPerson;
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validPerson = new Person("Anita", "Job", "31 Employment Ave", "Happivale", 
                                "ON","T3T2B2", LocalDate.of(2000, Month.MAY, 10));
    }
    
    @After
    public void tearDown() {
    }

    
  
    /**
     * Test of getYearBorn method, of class Person.
     */
    @Test
    public void testInvalidPerson() {
        try
        {
            Person invalidPerson = new Person("Anita", "Job", "31 Employment Ave", "Happivale", "ON","T32B2", LocalDate.of(2000, Month.MAY, 10));    
            fail("the invalid postal code should have thrown an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Constructor with an invalid postal code threw the exception \"%s\"", e.getMessage());
        }
    }
  
    /**
     * Test of getYearBorn method, of class Person.
     */
    @Test
    public void testGetYearBorn() {
        int expResult = 2000;
        int result = validPerson.getYearBorn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class Person.
     */
    @Test
    public void testGetAge() {
        int expResult = 16;
        int result = validPerson.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPostalCode method, of class Person.
     */
    @Test
    public void testSetPostalCodeValid() {
        String postal = "B3B7H7";
        validPerson.setPostalCode(postal);
        assertEquals(postal, validPerson.getPostalCode());
    }

    /**
     * Test of setPostalCode method, of class Person.
     */
    @Test
    public void testSetPostalCodeInvalidPattern() {
        String postal = "B337H7";
        try
        {
            validPerson.setPostalCode(postal);
            fail("BONUS-Set postal code with B337H7 should have triggered an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("BONUS-Person with postalcode and an invalid pattern exception = \"%s\"%n", e.getMessage());
        }
    }


    
/**
     * Test of setPostalCode method, of class Person with invalid inputs.
     */
    @Test
    public void testSetPostalCodeInvalid() {
        String postal = "B3B7H";
        try
        {
            validPerson.setPostalCode(postal);
            fail("setPostalCode should have thrown an exception");
        }
        catch (IllegalArgumentException e)
        {
           System.out.printf("Person trying to set an invalid postalcode exception = \"%s\"%n", e.getMessage());  
        }
    }
    

    /**
     * Test of changeAddress method, of class Person.
     */
    @Test
    public void testChangeAddress() {
        String street = "86 Kingsman Way";
        String city = "Edenvale";
        String province = "ON";
        String postalCode = "K9L2S3";
        validPerson.changeAddress(street, city, province, postalCode);
        assertEquals(validPerson.getFullAddress(), "86 Kingsman Way, Edenvale, ON, K9L2S3");
    }

    /**
     * Test of changeAddress method, of class Person.
     */
    @Test
    public void testChangeAddressInvalidPostalCode() {
        String street = "86 Kingsman Way";
        String city = "Edenvale";
        String province = "ON";
        String postalCode = "K92S3";
        try
        {
            validPerson.changeAddress(street, city, province, postalCode);
            fail("change address should have triggered an exception due to invalid postal code");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("The change address command with invalid postal code, the exception = \"%s\"%n",e.getMessage());
        }
    }
    
    
    /**
     * Test of getFirstName method, of class Person.
     */
    @Test
    public void testGetFirstName() {
        String expResult = "Anita";
        String result = validPerson.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Person.
     */
    @Test
    public void testGetLastName() {
        String expResult = "Job";
        String result = validPerson.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStreetAddress method, of class Person.
     */
    @Test
    public void testGetStreetAddress() {
        String expResult = "31 Employment Ave";
        String result = validPerson.getStreetAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class Person.
     */
    @Test
    public void testGetCity() {
        String expResult = "Happivale";
        String result = validPerson.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProvince method, of class Person.
     */
    @Test
    public void testGetProvince() {
        String expResult = "ON";
        String result = validPerson.getProvince();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getPostalCode method, of class Person.
     */
    @Test
    public void testGetPostalCode() {
        String expResult = "T3T2B2";
        String result = validPerson.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBirthday method, of class Person.
     */
    @Test
    public void testGetBirthday() {
        LocalDate expResult = LocalDate.of(2000, Month.MAY, 10);
        LocalDate result = validPerson.getBirthday();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of the toString() method
     */
    @Test
    public void testToString()
    {
        String expResult = "Anita Job";
        String result = validPerson.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Person.
     */
    @Test
    public void testSetFirstName() {
        String firstName = "Hilda";
        validPerson.setFirstName(firstName);
        assertEquals(firstName, validPerson.getFirstName());
    }

    /**
     * Test of setLastName method, of class Person.
     */
    @Test
    public void testSetLastName() {
        String lastName = "Gilbourne";
        validPerson.setLastName(lastName);
        assertEquals(lastName, validPerson.getLastName());
    }

    /**
     * Test of setStreetAddress method, of class Person.
     */
    @Test
    public void testSetStreetAddress() {
        String streetAddress = "45 Wahoo Lane";
        validPerson.setStreetAddress(streetAddress);
        assertEquals(streetAddress, validPerson.getStreetAddress());
    }

    /**
     * Test of setCity method, of class Person.
     */
    @Test
    public void testSetCity() {
        String city = "Eden";
        validPerson.setCity(city);
        assertEquals(city, validPerson.getCity());
    }

    /**
     * Test of setProvince method, of class Person.
     */
    @Test
    public void testSetProvince() {
        String province = "BC";
        validPerson.setProvince(province);
        assertEquals(province, validPerson.getProvince());
    }

    /**
     * Test of setBirthday method, of class Person.
     */
    @Test
    public void testSetBirthday() {
        LocalDate birthday = LocalDate.of(2010, Month.MARCH, 13);
        validPerson.setBirthday(birthday);
        assertEquals(birthday, validPerson.getBirthday());
    }

    /**
     * Test of setPostalCode method, of class Person.
     */
    @Test
    public void testSetPostalCode() {
        String postal = "L4N8T3";
        validPerson.setPostalCode(postal);
        assertEquals(postal, validPerson.getPostalCode());
    }
    
    /**
     * Test of setPostalCode method, of class Person.
     * This test ensures that the postal code was stored in UPPER case
     */
    @Test
    public void testSetPostalCodeLowerCase() {
        String postal = "l4n8t3";
        validPerson.setPostalCode(postal);
        assertEquals("L4N8T3", validPerson.getPostalCode());
    }
    

    /**
     * Test of getFullAddress method, of class Person.
     */
    @Test
    public void testGetFullAddress() {
        String expResult = "31 Employment Ave, Happivale, ON, T3T2B2";
        String result = validPerson.getFullAddress();
        assertEquals(expResult, result);
    }
}