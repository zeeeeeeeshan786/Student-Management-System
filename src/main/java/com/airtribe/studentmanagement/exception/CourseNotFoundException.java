package main.java.com.airtribe.studentmanagement.exception;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
