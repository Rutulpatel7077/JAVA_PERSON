/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1sem2;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Rutul
 */

public class Course {
    
    
    private String courseName,description,courseCode,room;
    private  int numberOfStudents,duration;
    private LocalTime startTime;
    private  DayOfWeek dayOfWeek;
    private ArrayList<Student> listOfStudents = new ArrayList<>();
    private Instructor instructor;
   
  /**
   * This is constructor of Course class
   * @param courseCode
   * @param courseName
   * @param description
   * @param room
   * @param instructor
   * @param dayOfWeek
   * @param startTime
   * @param duration
   * @param numberOfStudents 
   */
    public Course(String courseCode, String courseName, String description , String room,Instructor instructor,DayOfWeek dayOfWeek,LocalTime startTime, int duration,int numberOfStudents) {
        this.courseName = courseName;
        this.description = description;
        this.courseCode = courseCode;
        this.room = room;
        this.duration = duration;
        this.dayOfWeek = dayOfWeek;
        this.listOfStudents = listOfStudents;
        
        if(instructor.canTeach(courseCode)) 
             this.instructor = instructor;
        else 
            throw new IllegalArgumentException("Instructor can not teach this course");
        
        setMaxNumberOfStudents(numberOfStudents);
        setStartTime(startTime);
        
    }   
    /**
     * This method will return CourseName 
     * @return 
     */
    public String getCourseName() {
        return this.courseName;
    }
    
    /**
     * This Method will Return Description into the instance variable
     * @return 
     */
    
    
    public String getDescription() {
        return this.description;
    }

    /**
     * This method will return CourseCode
     * @return 
     */
    public String getCourseCode() {
        return this.courseCode;
    }
    
    /**
     * This method will return Room Number
     * @return 
     */
    public String getRoom() {
        return room;
    }
    
    /**
     * This method will return List of Student
     * @return 
     */
    public ArrayList<Student> getStudents() {
        return this.listOfStudents;
    }
    
    /**
     * This Method will return Professor name 
     * @return 
     */
    public Instructor getProf() {
        return this.instructor;
    }
    
    /**
     * This method will return Class Duration 
     * @return 
     */
    public int getDuration() {
        return duration;
    }
    
    /**
     * This Method Will return Start Time
     * @return 
     */
    public LocalTime getStartTime() {
        return startTime;
    }
    
    /**
     * This Method will return Number of Students from the Array List
     * @return 
     */
    public int getNumberOfStudentsEnrolled() {
        return listOfStudents.size();
    }
    
    /**
     * This Method will return maximum number of Students 
     * @return 
     */
    public int getMaxNumberOfStudents() {
        return numberOfStudents;
    }
    
    /**
     * This method will return day of week 
     * @return 
     */
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    
    /**
     * This Method will return List Of Students
     * @return 
     */
    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }
    
    /**
     * This is an Object of Instructor will return instructor name
     * @return 
     */
    public Instructor getInstructor() {
        return instructor;
    }
    
    /**
     * This Method will accept String as an argument  and return courseName
     * @param courseName 
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    /**
     * This Method will set Description
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * This method will set CourseCode
     * @param courseCode 
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    /**
     * This Method will set the room number 
     * @param room 
     */
    public void setRoom(String room) {
        this.room = room;
    }
    
    /**
     * This Method will accept integer and validate the number of Students and throw exception 
     * @param numberOfStudents 
     */
    public void setMaxNumberOfStudents(int numberOfStudents) {
        if (numberOfStudents>=10 && numberOfStudents <=50 && numberOfStudents!=0) {
            this.numberOfStudents = numberOfStudents;
        } else
            throw new IllegalArgumentException("Invalid number of student for the class");
    }
    
    /**
     * This Method will set duration in the instance  variable
     * @param duration 
     */
    
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    /**
     * This method will validate and return value into the instance variable
     * @param startTime 
     */
    public void setStartTime(LocalTime startTime) {
        if (startTime.isBefore(LocalTime.of(8,0)) || startTime.isAfter(LocalTime.of(18,0))) 
            throw new IllegalArgumentException("This is not valid start time for class");
        else
            this.startTime=startTime;
    }
    
    /**]
     * This method will Validate and check if day is Sunday or Saturday it will return exception
     * @param dayOfWeek 
     */
    public void setDayOfClass(DayOfWeek dayOfWeek) {
        if (dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            throw new IllegalArgumentException(" Class day should not be a sunday or saturday");
        }
        else
            this.dayOfWeek = dayOfWeek;
    }
    
    /*
     * This method will set listOfStudents into the instance variable
     * @param listOfStudents 
     */
    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }
    
    /**
     * This is Method will validate instructor is able to teach that course or  not
     * @param instructor 
     */
    public void setProf(Instructor instructor) {
        if (instructor.canTeach(this.courseCode))
            this.instructor = instructor;
        else
            throw new IllegalArgumentException("Instructor can't teach this course");
    }
    
    /**
     * ToString Method of Course Class
     * @return 
     */
    public String toString() {
        return courseName+" "+courseCode;
    }
    
    /**
     * This Method will add student into array list 
     * @param student
     * @throws InvalidStudentException 
     */
    public void addStudent(Student student) throws InvalidStudentException {
        if (student.inGoodStanding() && listOfStudents.size()<this.numberOfStudents) {
            listOfStudents.add(student);
        } 
        else
            throw new InvalidStudentException();

    }
    
    /**
     * This Method will return day of week
     * @return 
     */
    public DayOfWeek getDayOfClass() {
        return this.dayOfWeek;
    }
    
    /**
     * This method will Calculate the average of years student enrolled into the college
     * @return 
     */
    public double averageStudentTimeAtCollege() {
        double avg = 0.0;
        for (int i = 0; i < listOfStudents.size(); i++)
            avg += listOfStudents.get(i).getYearsAtCollege();
        if (avg == 0.0)
            return avg;
        return avg / listOfStudents.size();
    }
    
    /**
     * This Method will return list of student form class
     * @return 
     */
    public String showClassList () {
        String list="";
        for (int i = 0; i < this.listOfStudents.size(); i++) {
            list += (this.listOfStudents.get(i).toString() + "%n");
        }
        return String.format(list);
    }
} // end of class
