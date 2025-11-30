package main.java.com.airtribe.studentmanagement.exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String errorMessage){
        super(errorMessage);
    }

}
