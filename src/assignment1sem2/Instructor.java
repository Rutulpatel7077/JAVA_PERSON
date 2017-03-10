/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1sem2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * this Instructor class extends from the person class
 * @author Rutul
 */


public class Instructor extends Person {
    /**
     * Instance variable of Instructor class
     */
    
    private int employeeNumber;
    private LocalDate hireDate;
    private ArrayList<String> courseCode = new ArrayList<>();
    
    /**
     * constructor of the Instructor Class
     * @param firstName
     * @param lastName
     * @param streetAddress
     * @param city
     * @param province
     * @param postalCode
     * @param birthdate
     * @param employeeNumber
     * @param hireDate 
     */
    public Instructor(String firstName, String lastName, String streetAddress, String city, String province, String postalCode, LocalDate birthdate,int employeeNumber,LocalDate hireDate) {
        super(firstName, lastName, streetAddress, city, province, postalCode, birthdate);
        if(employeeNumber == 0)
            throw new IllegalArgumentException("employee number should not be a zero");
        else
            this.employeeNumber = employeeNumber;
        setHireDate(hireDate);
    } // end of constructor
    
    /**
     * This method will return the employee number
     * @return 
     */
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    
    /**
     * This method will return Hired Date of the instructor
     * @return 
     */
    public LocalDate getHireDate() {
        return this.hireDate;
    }
    
    /**
     * This is method of ArrayList and return the course code of the teachable courses
     * @return 
     */
    public ArrayList<String> getTeachableCourses() {
        return courseCode;
    }
    
    /**
     * This is a set method of the employee number
     * @param employeeNumber 
     */
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    
    /**
     * This method will set and validate the Hire Date and if instructor hired mor than 80 year or Hire date is of future
     * then it will thrown exception
     * @param hireDate 
     */
    public  void setHireDate(LocalDate hireDate) {
        if (((LocalDate.now().getYear() - hireDate.getYear()) < 80) && LocalDate.now().isAfter(hireDate))
            this.hireDate = hireDate;                
        else
            throw new IllegalArgumentException("The hire date was more than 80 years ago");
    }
    
    /**
     * This method will set the teachable courses into array list
     * @param teachableCourses 
     */
    public void setTeachableCourses(ArrayList<String> teachableCourses) {
        this.courseCode = teachableCourses;
    }
    
    /**
     * this method will add the courses into the array list of courseCode 
     * @param courseCode 
     */
    public void addTeachableCourse(String courseCode) {
        this.courseCode.add(courseCode.toUpperCase());
    }
    
    /**
     * this method will validate the course is in the array list of course code
     * @param courseCode
     * @return 
     */
    public boolean canTeach(String courseCode) {
        if(this.courseCode.contains(courseCode.toUpperCase()))
           return true;
        else 
            return false;   
    }
    
    /**
     * This method will give the Total years at college from the hired date to now
     * @return 
     */
    public int getYearsAtCollege() {
        LocalDate today=LocalDate.now();        
        int collegeYear = Period.between(hireDate,today).getYears();
        return collegeYear;
    }
    
    /**
     * this method will return the employee number
     * @return 
     */
    public int getEmployeeNum() {
        return this.employeeNumber;
    }
    
    /**
     * This method will return the the list of subjects certified to teach
     * @return 
     */
    public String listOfSubjectsCertifiedToTeach () {
        String list = "";
        for (int i = 0; i < courseCode.size()-1; i++) 
            list = list + courseCode.get(i) + ", ";
        return list + courseCode.get(courseCode.size()-1);
    }
    
    /**
     * this method will add course in the array list of the course code 
     * @param courseCode 
     */
    public void addCourseToAbilities(String courseCode) {
       this.courseCode.add(courseCode.toUpperCase());
    }
    
    /**
     * This method will validate and check the Instructor age is more than 18 and less than 100
     * @param birthdate 
     */
    public void setBirthday(LocalDate birthdate) {
        
        if((LocalDate.now().getYear()-birthdate.getYear()) >= 18 && (LocalDate.now().getYear()-birthdate.getYear() <= 100)) 
            this.setBirthday(birthdate); 
        else 
            throw new IllegalArgumentException("The Instructor to be too young");
    
    }
    
}  // end of class
