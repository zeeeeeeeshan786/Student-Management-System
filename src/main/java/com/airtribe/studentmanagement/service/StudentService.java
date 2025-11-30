package main.java.com.airtribe.studentmanagement.service;

import main.java.com.airtribe.studentmanagement.entity.Course;
import main.java.com.airtribe.studentmanagement.entity.GraduateStudent;
import main.java.com.airtribe.studentmanagement.entity.Student;
import main.java.com.airtribe.studentmanagement.entity.Enrollment;
import java.util.ArrayList;
import main.java.com.airtribe.studentmanagement.exception.StudentNotFoundException;

public class StudentService {
    static ArrayList<Student> studentArrayList = new ArrayList<>();

    public void addStudent(Student student){
        studentArrayList.add(student);
    }

    public void removeStudent(Student student){
        studentArrayList.remove(student);
    }

    public static Student getStudentById(String studentIdProvidedToSearch) throws StudentNotFoundException {
        for(Student availableStudent : studentArrayList){
            if(availableStudent.getStudentId().equals(studentIdProvidedToSearch)){
                System.out.println("Student with ID "+ studentIdProvidedToSearch + " is available, returning Student");
                return availableStudent;
            }
        }
        throw new StudentNotFoundException("Student with ID "+ studentIdProvidedToSearch + " not found");
    }

    public ArrayList<Student> searchStudents(String studentSearchKeyword){
        ArrayList<Student> resultOfStudentSearch = new ArrayList<>();
        for (Student availableStudent : studentArrayList){
            if(availableStudent.search(studentSearchKeyword)){
                System.out.println("Student(s) found based on your search keyword");
                resultOfStudentSearch.add(availableStudent);
            }
        }
        return resultOfStudentSearch;
    }

    public double calculateCGPA(Student std){

        double cgpa;
        double sumOfWeightedGradePoints = 0; // Sum(Credits * gpa) for each course is Numerator
        int sumOfCredits = 0; // Sum(credits) is Denominator used to calculate CGPA
        for (Enrollment enrl : std.getEnrollements()){
            Course course = enrl.getCourse();
            int courseCredits = course.getCourseCredits();
            int gpa = enrl.getGradePoint();

            sumOfWeightedGradePoints += courseCredits*gpa;
            sumOfCredits += courseCredits;

        }
        if (sumOfCredits == 0) {
            return 0d;
        }
//        System.out.println(sumOfWeightedGradePoints);
        cgpa = (sumOfWeightedGradePoints/sumOfCredits);

        if (std instanceof GraduateStudent gradStd){         // if this is a GraduateStudent, update its cgpa field
            gradStd.setCgpa(cgpa);
        }


        return cgpa;
    }
}
