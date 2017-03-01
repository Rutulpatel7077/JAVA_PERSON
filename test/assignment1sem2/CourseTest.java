/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1sem2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class CourseTest {
    private Instructor instructor;
    private Student student1, student2, student3, student4, studentBadStanding;
    private Course validCourse;
    
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws InvalidStudentException {
        student1 = new Student( "Fred","Flintstone","13 Cobble Way","Bedrock",
                                "Dendi","A2A0T3",LocalDate.of(1956, Month.SEPTEMBER, 3), 
                                "COPA",1234, LocalDate.of(2016, Month.MARCH, 10));
        
        student2 = new Student( "Barney","Rubble","15 Cobble Way","Bedrock",
                                "Dendi","A2A0T3",LocalDate.of(1957, Month.MAY, 13), 
                                "COPR",1235, LocalDate.of(2015, Month.SEPTEMBER, 1));
        
        student3 = new Student( "Bam Bam","Rubble","15 Cobble Way","Bedrock",
                                "Dendi","A2A0T3",LocalDate.of(1977, Month.APRIL, 12), 
                                "COPR",1236, LocalDate.of(2014, Month.SEPTEMBER, 1));

        student4 = new Student( "Wilma","Flintstone","13 Cobble Way","Bedrock",
                                "Dendi","A2A0T3",LocalDate.of(1962, Month.FEBRUARY, 10), 
                                "COPR",1237, LocalDate.of(2014, Month.SEPTEMBER, 1));
        
        studentBadStanding = new Student( "Barb","Dwyer","16 Ouch Cres","Sadville",
                                        "BC","A2A0T3",LocalDate.of(1975, Month.FEBRUARY, 14), 
                                        "COPA",1238, LocalDate.of(2012, Month.SEPTEMBER, 1));
        studentBadStanding.suspendStudent();

        instructor = new Instructor("Alga", "Rithem","14 Knowledge Ave", "Utopia", "ON", "Y6Y3D3", 
                                    LocalDate.of(1974, Month.DECEMBER, 31), 2000123, 
                                    LocalDate.of(2015, Month.JANUARY, 1));
        instructor.addTeachableCourse("COMP1008");
        
        validCourse = new Course("COMP1008", "Intro to Objects", "Course about creating classes", "E208", 
                  instructor, DayOfWeek.THURSDAY, LocalTime.of(8, 0), 3, 10);
        validCourse.addStudent(student1);
        validCourse.addStudent(student2);
        validCourse.addStudent(student3);
        validCourse.addStudent(student4);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setStartTime method, of class Course.
     */
    @Test
    public void testSetStartTimeBefore8() {
        LocalTime startTime = LocalTime.of(7, 0);
        try
        {
            validCourse.setStartTime(startTime);
            fail("Course start time must be no earlier than 8 am");
        }
        catch (IllegalArgumentException e){
        System.out.printf("When setting the start time before 8, the exception = \"%s\"%n", e.getMessage());
        }
    }
    
    /**
     * Test of setStartTime method, of class Course.
     */
    @Test
    public void testSetStartTimeAfter18() {
        LocalTime startTime = LocalTime.of(19, 0);
        try
        {
            validCourse.setStartTime(startTime);
            fail("Course start time must be no later than 6 pm");
        }
        catch (IllegalArgumentException e){
            System.out.printf("When setting the start time after 6 pm, the exception = \"%s\"%n", e.getMessage());
        };
    }

    /**
     * Test of setStartTime method, of class Course.
     */
    @Test
    public void testSetStartTime8AM() {
        LocalTime startTime = LocalTime.of(8, 0);
        try
        {
            validCourse.setStartTime(startTime);
            assertEquals(startTime, validCourse.getStartTime());
        }
        catch (IllegalArgumentException e)
        {
            fail("8 am should be a valid start time");
        }
    }
    

    /**
     * Test of setStartTime method, of class Course.
     */
    @Test
    public void testSetStartTime6PM() {
        LocalTime startTime = LocalTime.of(18, 0);
        try
        {
            validCourse.setStartTime(startTime);
            assertEquals(startTime, validCourse.getStartTime());
        }
        catch (IllegalArgumentException e)
        {
            fail("6 pm should be a valid start time");
        }
    }
    

    /**
     * Test of setDayOfClass method, of class Course.
     */
    @Test
    public void testSetDayOfClassMonday() {
        DayOfWeek dayOfClass = DayOfWeek.MONDAY;
        try
        {
            validCourse.setDayOfClass(dayOfClass);
            assertEquals(dayOfClass, validCourse.getDayOfClass());
        }
        catch (IllegalArgumentException e)
        {
            fail("Monday is a valid day to hold a course");
        }
    }
    
        /**
     * Test of setDayOfClass method, of class Course.
     */
    @Test
    public void testSetDayOfClassTuesday() {
        DayOfWeek dayOfClass = DayOfWeek.TUESDAY;
        try
        {
            validCourse.setDayOfClass(dayOfClass);
            assertEquals(dayOfClass, validCourse.getDayOfClass());
        }
        catch (IllegalArgumentException e)
        {
            fail("Tuesday is a valid day to hold a course");
        }
    }

        /**
     * Test of setDayOfClass method, of class Course.
     */
    @Test
    public void testSetDayOfClassWednesday() {
        DayOfWeek dayOfClass = DayOfWeek.WEDNESDAY;
        try
        {
            validCourse.setDayOfClass(dayOfClass);
            assertEquals(dayOfClass, validCourse.getDayOfClass());
        }
        catch (IllegalArgumentException e)
        {
            fail("Wednesday is a valid day to hold a course");
        }
    }

   /**
     * Test of setDayOfClass method, of class Course.
     */
    @Test
    public void testSetDayOfClassThursday() {
        DayOfWeek dayOfClass = DayOfWeek.THURSDAY;
        try
        {
            validCourse.setDayOfClass(dayOfClass);
            assertEquals(dayOfClass, validCourse.getDayOfClass());
        }
        catch (IllegalArgumentException e)
        {
            fail("Thursday is a valid day to hold a course");
        }
    }

    /**
     * Test of setDayOfClass method, of class Course.
     */
    @Test
    public void testSetDayOfClassFriday() {
        DayOfWeek dayOfClass = DayOfWeek.FRIDAY;
        try
        {
            validCourse.setDayOfClass(dayOfClass);
            assertEquals(dayOfClass, validCourse.getDayOfClass());
        }
        catch (IllegalArgumentException e)
        {
            fail("Friday is a valid day to hold a course");
        }
    }
    
    
    /**
     * Test of setDayOfClass method, of class Course.
     */
    @Test
    public void testSetDayOfClassSaturday() {
        DayOfWeek dayOfClass = DayOfWeek.SATURDAY;
        try
        {
            validCourse.setDayOfClass(dayOfClass);
            fail("Saturday is not a valid day to hold a course");
        }
        catch (IllegalArgumentException e)
        {            
        }
    }
    
    /**
     * Test of setDayOfClass method, of class Course.
     */
    @Test
    public void testSetDayOfClassSunday() {
        DayOfWeek dayOfClass = DayOfWeek.SUNDAY;
        try
        {
            validCourse.setDayOfClass(dayOfClass);
            fail("Saturday is not a valid day to hold a course");
        }
        catch (IllegalArgumentException e)
        {            
        }
    }
    

    /**
     * Test of setProf method, of class Course.
     */
    @Test
    public void testSetProfValidProf() {
        Instructor validProf = new Instructor("Candy", "Cane","14 Knowledge Ave", "Stayner", "ON", "Y6Y3D1", 
                                    LocalDate.of(1972, Month.JULY, 15),
                                    2000123, LocalDate.of(2015, Month.JANUARY, 1));
        validProf.addTeachableCourse("COMP1008");
        
        try
        {
            validCourse.setProf(validProf);
            assertEquals(validProf, validCourse.getProf());
        }
        catch (IllegalArgumentException e)
        {
            fail("This is a valid prof, it should not thrown an exception");
        }
    }
    

    /**
     * Test of setProf method, of class Course.
     */
    @Test
    public void testSetProfInValidProf() {
        Instructor invalidProf = new Instructor("Candy", "Cane", "14 Knowledge Ave", "Stayner", "ON", "Y6Y3D2", 
                                    LocalDate.of(1972, Month.JULY, 15),
                                    2000123, LocalDate.of(2015, Month.JANUARY, 1));        
        try
        {
            validCourse.setProf(invalidProf);
            fail("This prof is not certified to teach the course, it should throw an exception");
        }
        catch (IllegalArgumentException e){}
    }
    

    /**
     * Test of getCourseCode method, of class Course.
     */
    @Test
    public void testGetCourseCode() {
        String expResult = "COMP1008";
        String result = validCourse.getCourseCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourseName method, of class Course.
     */
    @Test
    public void testGetCourseName() {
        String expResult = "Intro to Objects";
        String result = validCourse.getCourseName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Course.
     */
    @Test
    public void testGetDescription() {
        String expResult = "Course about creating classes";
        String result = validCourse.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoom method, of class Course.
     */
    @Test
    public void testGetRoom() {
        String expResult = "E208";
        String result = validCourse.getRoom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProf method, of class Course.
     */
    @Test
    public void testGetProf() {
        Instructor expResult = this.instructor;
        Instructor result = validCourse.getProf();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudents method, of class Course.
     */
    @Test
    public void testGetStudents() {
        ArrayList<Student> expResult = new ArrayList<>();
        expResult.add(student1);
        expResult.add(student2);
        expResult.add(student3);
        expResult.add(student4);
        ArrayList<Student> result = validCourse.getStudents();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDayOfClass method, of class Course.
     */
    @Test
    public void testGetDayOfClass() {
        DayOfWeek expResult = DayOfWeek.THURSDAY;
        DayOfWeek result = validCourse.getDayOfClass();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartTime method, of class Course.
     */
    @Test
    public void testGetStartTime() {
        LocalTime expResult = LocalTime.of(8, 0);
        LocalTime result = validCourse.getStartTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDuration method, of class Course.
     */
    @Test
    public void testGetDuration() {
        int expResult = 3;
        int result = validCourse.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxNumberOfStudents method, of class Course.
     */
    @Test
    public void testSetMaxNumberOfStudents0() {
        int maxStudents = 0;
        try{
            validCourse.setMaxNumberOfStudents(maxStudents);
            fail("The test case is a prototype.");
        }
        catch(IllegalArgumentException e){}
    }
    
    /**
     * Test of setMaxNumberOfStudents method, of class Course.
     */
    @Test
    public void testSetMaxNumberOfStudents51() {        
        int maxStudents = 51;
        try{
            validCourse.setMaxNumberOfStudents(maxStudents);
            fail("The test case is a prototype.");
        }
        catch(IllegalArgumentException e){}
    }
    
    /**
     * Test of setMaxNumberOfStudents method, of class Course.
     */
    @Test
    public void testSetMaxNumberOfStudents50() {
        int maxStudents = 50;
        validCourse.setMaxNumberOfStudents(maxStudents);
        assertEquals(maxStudents, validCourse.getMaxNumberOfStudents());        
    }

    
    
    /**
     * Test of setMaxNumberOfStudents method, of class Course.
     */
    @Test
    public void testSetMaxNumberOfStudents10() {
        int maxStudents = 10;
        validCourse.setMaxNumberOfStudents(maxStudents);
        assertEquals(maxStudents, validCourse.getMaxNumberOfStudents());        
    }

    /**
     * Test of addStudent method, of class Course.
     */
    @Test
    public void testAddStudentValid() throws Exception {
        int classSize = validCourse.getNumberOfStudentsEnrolled()+1;
        validCourse.addStudent(this.student1);
        assertEquals(classSize, validCourse.getNumberOfStudentsEnrolled());        
    }
    
    /**
     * Test of addStudent method, of class Course.
     */
    @Test
    public void testAddStudentInvalid() throws Exception {
        try
        {
            validCourse.addStudent(this.studentBadStanding);
            fail("The test case is a prototype.");
        }
        catch (Exception e)
        {
            System.out.printf("Testing to add a student in bad standing the exception thrown is \"%s\"%n",e.getMessage());
        }
    }

    /**
     * Test of addStudent method, of class Course.
     */
    @Test
    public void testAddStudentInvalid2() throws Exception {
        validCourse.addStudent(student1);   //student 5
        validCourse.addStudent(student1);   //student 6
        validCourse.addStudent(student1);   //student 7
        validCourse.addStudent(student1);   //student 8
        validCourse.addStudent(student1);   //student 9
        validCourse.addStudent(student1);   //student 10
        try
        {
            validCourse.addStudent(student1);  // this should be too many students
            fail("Too many students...should have generated an exception");
        }
        catch (Exception e)
        {
            System.out.printf("Testing for too many students throws the exception \"%s\"%n",e.getMessage());
        }
    }


    
    /**
     * Test of showClassList method, of class Course.
     */
    @Test
    public void testShowClassList() {
        String expResult = String.format("Fred Flintstone, student number is 1234%n" +
                           "Barney Rubble, student number is 1235%n" +
                           "Bam Bam Rubble, student number is 1236%n" +
                           "Wilma Flintstone, student number is 1237%n");
        String result = validCourse.showClassList();
        assertEquals(expResult, result);        
    }
 
    /**
     * Test of averageStudentTimeAtCollege method, of class Course.
     */
    @Test
    public void testAverageStudentTimeAtCollege() {
        double expResult = 1.25;
        double result = validCourse.averageStudentTimeAtCollege();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of averageStudentTimeAtCollege method, of class Course.
     */
    @Test
    public void testAverageStudentTimeAtCollege2() {
        
        //setup an Instructor and a Course
        Instructor tempInstructor = new Instructor("Alga", "Rithem","14 Knowledge Ave", "Utopia", "ON", "Y6Y3D2", 
                                    LocalDate.of(1974, Month.DECEMBER, 31), 2000123, 
                                    LocalDate.of(2015, Month.JANUARY, 1));
        tempInstructor.addTeachableCourse("COMP1008");
        
        Course tempCourse = new Course("COMP1008", "Intro to Objects", "Course about creating classes", "E208", 
                  instructor, DayOfWeek.THURSDAY, LocalTime.of(8, 0), 3, 10);
        
        double expResult = 0;        
        double result = tempCourse.averageStudentTimeAtCollege();        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Course.
     */
    @Test
    public void testToString() {
        String expResult = "Intro to Objects COMP1008";
        String result = validCourse.toString();
        assertEquals(expResult, result);
    }
    
}