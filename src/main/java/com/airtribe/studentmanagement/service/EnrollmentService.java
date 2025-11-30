package main.java.com.airtribe.studentmanagement.service;

import main.java.com.airtribe.studentmanagement.entity.Course;
import main.java.com.airtribe.studentmanagement.entity.Enrollment;
import main.java.com.airtribe.studentmanagement.entity.Student;

public class EnrollmentService {
//    ArrayList<Enrollment> student_subject_mapping_Enrlt = new ArrayList<>();

    public static Enrollment enrollStudent(Student std, Course C){
        Enrollment enrlmnt = new Enrollment(std, C);
        std.addEnrollement(enrlmnt);
        System.out.println("Congratulations, Student "+ std.getStudentId() +" Enrolled Successfully for "+ C.courseName +" and Marks are stored as Zero!");

        return enrlmnt;
    }

    public static Enrollment enrollStudent(Student std, Course C, double marksObtained){
        Enrollment enrlmnt = new Enrollment(std, C, marksObtained);
        std.addEnrollement(enrlmnt);
        System.out.println("Congratulations, Student "+ std.getStudentId() +" Enrolled Successfully for "+ C.courseName + " and Marks are stored too!");

        return enrlmnt;
    }

    public static  void setMarks(Enrollment enrollment,double marksObtained){   // Can be used when enrollement is done without marks
        enrollment.setMarks(marksObtained);
        System.out.println("Marks Updated Successfully! Here is the gradePoint obtained");
        System.out.println("Grade Point corresponding to Marks Obtained is : "+ enrollment.getGradePoint());
    }
}

