package main.java.com.airtribe.studentmanagement.entity;

import main.java.com.airtribe.studentmanagement.interfaces.Gradeable;

public class Enrollment implements Gradeable {
    private Student studentReference;  // Association
    private Course courseReference;    // Association
    private double marks;

    public Enrollment(Student student, Course course, double marks) {
        this.studentReference = student;
        this.courseReference = course;
        this.marks = marks;
    }

    public Enrollment(Student student, Course course) {
        this(student,course, 0);
    }

    public Enrollment(){

    }

    public Student getStudent() {
        return this.studentReference;
    }

    public void setStudent(Student student) {
        this.studentReference = student;
    }

    public Course getCourse() {
        return this.courseReference;
    }

    public void setCourse(Course course) {
        this.courseReference = course;
    }

    public double getMarks() {
        return this.marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        System.out.println("Marks for Student : " + this.studentReference.getStudentId()+ " for course "+ this.courseReference.courseName +" is now updated to "+marks);
    }

    public String toString() {
        return (
                "Enrollment : {" +
                " StudentId = " + this.studentReference.getStudentId() +
                ", StudentName = " + this.studentReference.getName() +
                ", CourseId = " + this.courseReference.getCourseCode() +
                ", Marks = '" + this.getMarks() + "' }"
        );
    }

    public int getGradePoint(){

        if (marks >= 91) return 10;
        else if (marks >= 81) return 9;
        else if(marks >= 71) return 8;
        else if (marks >= 61) return 7;
        else if (marks >= 51) return 6;
        else if (marks >= 41) return 5;
        else return 0;  // fail
    }


}
