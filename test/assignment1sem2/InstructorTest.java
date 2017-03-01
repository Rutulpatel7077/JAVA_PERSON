/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1sem2;

/**
 *
 * @author Rutul
 */
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
public class InstructorTest {
    Instructor validInstructor;
    
    public InstructorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validInstructor = new Instructor("Alga", "Rithem","14 Knowledge Ave", "Utopia", "ON", "Y6Y3D3", 
                                LocalDate.of(1974, Month.DECEMBER, 31), 2000123, LocalDate.of(2015, Month.JANUARY, 1));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setHireDate method, of class Instructor.
     */
    @Test
    public void testSetHireDateValid() {
        LocalDate dateHired = LocalDate.of(2014, Month.JANUARY, 1);
        validInstructor.setHireDate(dateHired);
        assertEquals(validInstructor.getHireDate(),  LocalDate.of(2014, Month.JANUARY, 1));
    }

    /**
     * Test of setHireDate method, of class Instructor.
     */
    @Test
    public void testSetHireDateInvalid() {
        LocalDate dateHired = LocalDate.of(2018, Month.JANUARY, 1);
        try
        {
            validInstructor.setHireDate(dateHired);
            fail("The hire date is in the future and should have triggered an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Hire date in the future, exception = \"%s\"%n", e.getMessage());
        }
    }

    
    /**
     * Test of setHireDate method, of class Instructor.
     */
    @Test
    public void testSetHireDateInvalid2() {
         LocalDate dateHired = LocalDate.of(1900, Month.JANUARY, 1);
        try
        {
            validInstructor.setHireDate(dateHired);
            fail("The hire date was more than 80 years ago, it should throw an exception.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Hire date in the future, exception = \"%s\"%n", e.getMessage());
        }
    }

    
    /**
     * Test of addTeachableCourse method, of class Instructor.
     */
    @Test
    public void testAddTeachableCourse() {
        String courseCode = "COMP1008";
        validInstructor.addTeachableCourse(courseCode);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("COMP1008");
        assertEquals(validInstructor.getTeachableCourses(), expResult);
    }

    /**
     * Test of getYearsAtCollege method, of class Instructor.
     */
    @Test
    public void testGetYearsAtCollegeAfterAnniversary() {
        int expResult = 2;
        int result = validInstructor.getYearsAtCollege();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYearsAtCollege method, of class Instructor.
     */
    @Test
    public void testGetYearsAtCollegeBeforeAnniversary() {
        int expResult = 16;
        validInstructor.setHireDate(LocalDate.of(2000, Month.DECEMBER, 31));
        int result = validInstructor.getYearsAtCollege();
        assertEquals(expResult, result);
    }


    /**
     * Test of canTeach method, of class Instructor.
     */
    @Test
    public void testCanTeachFalse() {
        String courseCode = "COMP1008";
        boolean expResult = false;
        boolean result = validInstructor.canTeach(courseCode);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of canTeach method, of class Instructor.
     */
    @Test
    public void testCanTeachTrue() {
        String courseCode = "comp1008";
        boolean expResult = true;
        validInstructor.addTeachableCourse(courseCode);
        boolean result = validInstructor.canTeach(courseCode);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of listOfSubjectsCertifiedToTeach method, of class Instructor.
     */
    @Test
    public void testListOfSubjectsCertifiedToTeach() {
        String expResult = "COMP1008, COMP2003";
        validInstructor.addTeachableCourse("COMP1008");
        validInstructor.addTeachableCourse("COMP2003");
        String result = validInstructor.listOfSubjectsCertifiedToTeach();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of the constructor with an invalid employee number
     */
    @Test
    public void testInstructorSetupInvalidEmployeeNumber() {
        
        try
        {
            Instructor invalidInstructor = new Instructor("Alga", "Rithem","14 Knowledge Ave", "Utopia", "ON", "Y6Y3DR", 
                                LocalDate.of(1974, Month.DECEMBER, 31), 0, LocalDate.of(2015, Month.JANUARY, 1));        
            fail("The employee number is not valid");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Instructor constructor with invalid employee number exception = \"%s\"%n", e.getMessage());
        }
    }

    /**
     * Test of canTeach method, of class Instructor.
     */
    @Test
    public void testCanTeach() {
        String courseCode = "COMP1007";
        boolean expResult = false;
        boolean result = validInstructor.canTeach(courseCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of canTeach method, of class Instructor.
     */
    @Test
    public void testCanTeach2() {
        String courseCode = "COMP1008";
        validInstructor.addTeachableCourse(courseCode);
        boolean expResult = true;
        boolean result = validInstructor.canTeach(courseCode);
        assertEquals(expResult, result);
    }


    /**
     * Test of getHireDate method, of class Instructor.
     */
    @Test
    public void testGetHireDate() {
        LocalDate expResult = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate result = validInstructor.getHireDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeeNum method, of class Instructor.
     */
    @Test
    public void testGetEmployeeNum() {
        int expResult = 2000123;
        int result = validInstructor.getEmployeeNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTeachableCourses method, of class Instructor.
     */
    @Test
    public void testGetTeachableCourses() {
        validInstructor.addTeachableCourse("comp1008");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("COMP1008");
        ArrayList<String> result = validInstructor.getTeachableCourses();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYearsAtCollege method, of class Instructor.
     */
    @Test
    public void testGetYearsAtCollege() {
        int expResult = 2;
        int result = validInstructor.getYearsAtCollege();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBirthday method, of class Instructor.
     */
    @Test
    public void testSetBirthdayOver100() {
        LocalDate birthday = LocalDate.of(1900, Month.MARCH, 1);
        try
        {
            validInstructor.setBirthday(birthday);    
        }
        catch (IllegalArgumentException e)
        {
             System.out.printf("Test set birthday over 100 exception = \"%s\"%n", e.getMessage());
        }
    }
        
    /**
     * Test of setBirthday method, of class Instructor.
     */
    @Test
    public void testSetBirthdayUnder18() {
        LocalDate birthday = LocalDate.of(2014, Month.MARCH, 1);
        try
        {
            validInstructor.setBirthday(birthday);    
            fail("The setBirthday method should have found the Instructor to be too young");
        }
        catch (IllegalArgumentException e)
        {
             System.out.printf("Test set birthday under 18, exception = \"%s\"%n", e.getMessage());
        }
        
        
    }

    
}