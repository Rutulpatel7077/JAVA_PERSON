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
            throw new IllegalArgumentException();
        
        setMaxNumberOfStudents(numberOfStudents);
        setStartTime(startTime);
        
    }   

    public String getCourseName() {
        return this.courseName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getRoom() {
        return room;
    }
    
    public ArrayList<Student> getStudents() {
        return this.listOfStudents;
    }
    
    public Instructor getProf() {
        return this.instructor;
    }
    
    public int getDuration() {
        return duration;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    
    public int getNumberOfStudentsEnrolled() {
        return listOfStudents.size();
    }
    
    public int getMaxNumberOfStudents() {
        return numberOfStudents;
    }
            
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setMaxNumberOfStudents(int numberOfStudents) {
        if (numberOfStudents>=10 && numberOfStudents <=50 && numberOfStudents!=0) {
            this.numberOfStudents = numberOfStudents;
        } else
            throw new IllegalArgumentException();
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStartTime(LocalTime startTime) {
        if (startTime.isBefore(LocalTime.of(8,0)) || startTime.isAfter(LocalTime.of(18,0))) 
            throw new IllegalArgumentException();
        else
            this.startTime=startTime;
    }
   
    public void setDayOfClass(DayOfWeek dayOfWeek) {
        if (dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            throw new IllegalArgumentException();
        }
        else
            this.dayOfWeek = dayOfWeek;
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public void setProf(Instructor instructor) {
        if (instructor.canTeach(this.courseCode))
            this.instructor = instructor;
        else
            throw new IllegalArgumentException();
    }
    
    public String toString() {
        return courseName+" "+courseCode;
    }
    
    public void addStudent(Student student) throws InvalidStudentException {
        if (student.inGoodStanding() && listOfStudents.size()<this.numberOfStudents) {
            listOfStudents.add(student);
        } 
        else
            throw new InvalidStudentException();

    }
    
    public DayOfWeek getDayOfClass() {
        return this.dayOfWeek;
    }
    
    public double averageStudentTimeAtCollege() {
        double avg = 0.0;
        for (int i = 0; i < listOfStudents.size(); i++)
            avg += listOfStudents.get(i).getYearsAtCollege();
        if (avg == 0.0)
            return avg;
        return avg / listOfStudents.size();
    }
    
    public String showClassList () {
        String list="";
        for (int i = 0; i < this.listOfStudents.size(); i++) {
            list += (this.listOfStudents.get(i).toString() + "%n");
        }
        return String.format(list);
    }
}
