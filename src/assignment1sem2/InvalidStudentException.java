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
class InvalidStudentException extends Exception
{
    //Parameterless Constructor
    public InvalidStudentException() {
        super();
    }

    //Constructor that accepts a message
    public InvalidStudentException(String message) {
          super(message);
    }
 }
