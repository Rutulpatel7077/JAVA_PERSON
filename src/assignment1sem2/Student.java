/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1sem2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

/**
 *
 * @author Rutul
 */
public class Student extends Person {
    /**
     * instance variables
     */
   private LocalDate enrollDate;
   private int studentNumber;
   private String major;
   private boolean isGood;
   
   /**
    * constructor of student class. 
    * @param firstName
    * @param lastName
    * @param streetAddress
    * @param city
    * @param province
    * @param postalCode
    * @param birthdate
    * @param major
    * @param studentNumber
    * @param enrollDate 
    */
   
    public Student(String firstName, String lastName, String streetAddress, String city, String province, String postalCode, LocalDate birthdate, String major, int studentNumber, LocalDate enrollDate) {
        super(firstName, lastName, streetAddress, city, province, postalCode, birthdate);
        this.setBirthday(birthdate);
        reinstateStudent();
        this.studentNumber = studentNumber;
        setYearEnrolled(enrollDate);
        setStudentNumber(studentNumber);
    }
    
    /**
     * get method of yearEnrolled 
     * this will return enroll date year
     * @return 
     */
    public int getYearEnrolled() {
        return this.enrollDate.getYear();
    }
    
    /**
     * get method of yearsAtCollege 
     * this will return total years at college
     * @return 
     */
    public int getYearsAtCollege() {
        return Period.between(enrollDate, LocalDate.now()).getYears();
    }
    
    /**
     * boolean method of inGoodStanding
     * this will return student is  good or not
     * @return 
     */
    public boolean inGoodStanding() {
        return this.isGood; 
    }
    
    /**
     * this method will return student is reinstate or not
     */
    public void reinstateStudent() {
        this.isGood = true;
    } 
    
    /**
     * setBirthday method`
     * this method will validate and return birth date of student.
     * @param birthdate 
     * 
     */
    public void setBirthday(LocalDate birthdate) {
        
        if((LocalDate.now().getYear()-birthdate.getYear()) >= 14 && (LocalDate.now().getYear()-birthdate.getYear() <= 90)) 
            super.setBirthday(birthdate);
        else 
            throw new IllegalArgumentException("The student should at least 14");
    }
    
    /**
     * this method will validate and return studentNumber 
     * @param studentNumber 
     */
    public void setStudentNumber(int studentNumber) {
      
            if(this.studentNumber <= 0)
            throw new IllegalArgumentException("This student number is invalid");
        else
            this.studentNumber = studentNumber;
    }
    
    /**
     * this method will set birth date to the instance variable from the  constructor.
     * @param date 
     */
    public void setYearEnrolled(LocalDate date)
    {
        this.enrollDate = date;
    }
    
    /**
     * this method will set the value of  suspendedStudent.
     */
    public void suspendStudent() {
        this.isGood = false;
    } 
   
    
    /**
     * toSting of Student class
     * @return 
     */
    public String toString() {     
        return  String.format(this.getFirstName()+" "+this.getLastName()+","+" student number is "+studentNumber);     
    }
    
    
} // end of class
