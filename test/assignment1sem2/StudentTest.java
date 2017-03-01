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
public class StudentTest {
    
    Student validStudent1;
    
    public StudentTest() {        
    }
    
    @BeforeClass
    public static void setUpClass() {    
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         validStudent1 = new Student("Fred","Flintstone","13 Cobble Way","Bedrock","Dendi","A2A0T3",
                                    LocalDate.of(2000, Month.SEPTEMBER, 3),"COPA", 1234,
                                    LocalDate.of(2016, Month.JANUARY, 10));         
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setBirthday method, of class Student.
     */
    @Test
    public void testSetBirthdayValidInput() {
        LocalDate expResult = LocalDate.of(2000, Month.DECEMBER, 10);
        validStudent1.setBirthday(expResult);
        LocalDate result = validStudent1.getBirthday();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of setBirthday method, of class Student.
     */
    @Test
    public void testSetBirthdayInvalidInput() {
        LocalDate invalidBirthday = LocalDate.of(1000, Month.DECEMBER, 10);
        try{
            validStudent1.setBirthday(invalidBirthday);
             fail("The invalid date did not throw an exception");
        }
        catch (IllegalArgumentException e)
        {
            LocalDate expResult = LocalDate.of(2000, Month.SEPTEMBER, 03);
            LocalDate result = validStudent1.getBirthday();
            assertEquals(expResult, result);
        }
    }

    
    /**
     * Test of getYearEnrolled method, of class Student.
     */
    @Test
    public void testGetYearEnrolled() {
        int expResult = 2016;
        int result = validStudent1.getYearEnrolled();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of inGoodStanding method, of class Student.
     */
    @Test
    public void testInGoodStanding() {
        boolean expResult = true;
        boolean result = validStudent1.inGoodStanding();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of suspendStudent method, of class Student.
     */
    @Test
    public void testSuspendStudent() {
        validStudent1.suspendStudent();
        boolean expResult = false;
        boolean result = validStudent1.inGoodStanding();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of reinstateStudent method, of class Student.
     */
    @Test
    public void testReinstateStudent() {
        validStudent1.suspendStudent();
        validStudent1.reinstateStudent();
        boolean expResult = true;
        boolean result = validStudent1.inGoodStanding();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeAddress method, of class Student.
     */
    @Test
    public void testChangeAddress() {
        String street = "55 Granite Ridge Road";
        String city = "Bedrock";
        String province = "Dendi";
        String postalCode = "B3B2T2";
        validStudent1.changeAddress(street, city, province, postalCode);
        String expResult = "55 Granite Ridge Road, Bedrock, Dendi, B3B2T2";
        String result = validStudent1.getFullAddress();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of changeAddress method, of class Student.
     */
    @Test
    public void testChangeAddressInvalidPostalCode() {
        String street = "55 Granite Ridge Road";
        String city = "Bedrock";
        String province = "Dendi";
        String postalCode = "b3b2t2";
        validStudent1.changeAddress(street, city, province, postalCode);
        String expResult = "55 Granite Ridge Road, Bedrock, Dendi, B3B2T2";
        String result = validStudent1.getFullAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class Student.
     */
    @Test
    public void testGetAddress() {
        String expResult = "13 Cobble Way, Bedrock, Dendi, A2A0T3";
        String result = validStudent1.getFullAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        String expResult = "Fred Flintstone, student number is 1234";
        String result = validStudent1.toString();
        assertEquals(expResult, result);
    }    

    /**
     * Test of getYearsAtCollege method, of class Student.
     */
    @Test
    public void testGetYearsAtCollege() {
        int expResult = 1;
        int result = validStudent1.getYearsAtCollege();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBirthday method, of class Student.
     */
    @Test
    public void testSetBirthdayValid() {
        LocalDate newBirthday = LocalDate.of(2000, Month.APRIL, 1);
        validStudent1.setBirthday(newBirthday);
        assertEquals(newBirthday, validStudent1.getBirthday());
    }
    
    
    /**
     * Test of setBirthday method, of class Student.
     */
    @Test
    public void testSetBirthdayInvalid() {
        LocalDate newBirthday = LocalDate.of(2016, Month.APRIL, 1);
        try
        {
            validStudent1.setBirthday(newBirthday);
            fail("The setBirthday method should have ensured that the student is at least 14");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("The setBirthday with too young of an input, exception = \"%s\"%n", e.getMessage());
        }
        
    }
    
    
    /**
     * Test of setBirthday method, of class Student.
     */
    @Test
    public void testSetBirthdayInvalid2() {
        LocalDate newBirthday = LocalDate.of(1897, Month.APRIL, 1);
        try
        {
            validStudent1.setBirthday(newBirthday);
            fail("The setBirthday method should have ensured that the student is older than 90");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("The setBirthday with a birthday too old, exception = \"%s\"%n", e.getMessage());
        }        
    }
    

    /**
     * Test of creating a Student that is not a valid age (too old)
     */
    @Test
    public void testSetBirthdayInvalid3() {

        try
        {
            Student invalidStudent = new Student("Fred","Flintstone","13 Cobble Way","Bedrock","Dendi","A2A0T3",
                                        LocalDate.of(1900, Month.SEPTEMBER, 3),"COPA", 1234,
                                        LocalDate.of(2016, Month.MARCH, 10));                     
            fail("The student constructor should have failed because this one is older than 90");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("The constructor caught that the student was too old, exception = \"%s\"%n", e.getMessage());
        }        
    }
    
    /**
     * Test of creating a Student that is not a valid age (too young)
     */
    @Test
    public void testSetBirthdayInvalid4() {

        try
        {
            Student invalidStudent = new Student("Fred","Flintstone","13 Cobble Way","Bedrock","Dendi","A2A0T3",
                                        LocalDate.of(2014, Month.SEPTEMBER, 3),"COPA", 1234,
                                        LocalDate.of(2016, Month.MARCH, 10));                     
            fail("The student constructor should have failed because this one is too young");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("The constructor caught that the student was too young, exception = \"%s\"%n", e.getMessage());
        }        
    }

    /**
     * Test of creating a Student with an invalid student number
     */
    @Test
    public void testSetBirthdayInvalid5() {

        try
        {
            Student invalidStudent = new Student("Fred","Flintstone","13 Cobble Way","Bedrock","Dendi","A2A0T3",
                                        LocalDate.of(2000, Month.SEPTEMBER, 3),"COPA", 0,
                                        LocalDate.of(2016, Month.MARCH, 10));                     
            fail("The student constructor should have failed because of an invalid student number");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("The constructor caught that the student had an invalid student number, exception = \"%s\"%n", e.getMessage());
        }        
    }

    
}