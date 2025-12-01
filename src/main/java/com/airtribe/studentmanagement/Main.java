package main.java.com.airtribe.studentmanagement;

import main.java.com.airtribe.studentmanagement.entity.Course;
import main.java.com.airtribe.studentmanagement.entity.Enrollment;
import main.java.com.airtribe.studentmanagement.entity.GraduateStudent;
import main.java.com.airtribe.studentmanagement.entity.Student;
import main.java.com.airtribe.studentmanagement.service.CourseService;
import main.java.com.airtribe.studentmanagement.service.EnrollmentService;
import main.java.com.airtribe.studentmanagement.service.StudentService;
import main.java.com.airtribe.studentmanagement.util.InputValidator;
import main.java.com.airtribe.studentmanagement.exception.InvalidDataException;


public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
//        EnrollmentService enrollmentService = new EnrollmentService();

        System.out.println("_____________________________________________________________");
        System.out.println("Hey There!!, Welcome to WindTribe's Student Management System");
        System.out.println("_____________________________________________________________");

        try{
            InputValidator.validateStudentId("ATB007");
            InputValidator.validateDobFormat("27-06-2000");

            Student zee = new GraduateStudent("Zeeshan","27-06-2000","ATB007"
                                                ,"M.Sc Applied Mathematics"
                                                , "Parameter Estimation of Covid 19 SEIR Model",0);

        studentService.addStudent(zee);

        Course ode = new Course("Ordinary Differential Eq-1", "AM576", 4);
        Course advOde = new Course("Ordinary Differential Eq-2", "AM577", 3);
        Course realAnalysis = new Course("Real Analysis", "AM110", 5);
        Course complexAnalysis = new Course("Complex Analysis", "AM121", 3);
        Course pde = new Course("Partial Differential Eq", "AM621", 4);
        Course statsDs = new Course("Statistics for Data Science", "ST184", 3);

        courseService.addCourse(ode);
        courseService.addCourse(advOde);
        courseService.addCourse(realAnalysis);
        courseService.addCourse(complexAnalysis);
        courseService.addCourse(pde);
        courseService.addCourse(statsDs);

//            EnrollmentService.enrollStudent(zee, pde); // Any of them can be used...this is a static method to....no need to create ojbect


        Enrollment enrollment1 =  EnrollmentService.enrollStudent(zee,pde);
        Enrollment enrollment2 =  EnrollmentService.enrollStudent(zee,realAnalysis, 83);
        Enrollment enrollment3 =  EnrollmentService.enrollStudent(zee,statsDs, 78);

//        System.out.println(enrollment1);
//        EnrollmentService.setMarks(enrollment1, 92);
            enrollment1.setMarks(92);

            System.out.println("_____________________________________________________________");
            System.out.println("CGPA of "+ zee.getName() + " is : "+ studentService.calculateCGPA(zee));



        System.out.println(courseService.searchCourses("Diffe"));




        }
        catch (InvalidDataException exception){
            System.out.println("Error : "+exception.getMessage());
        }







//        ----------------------------------------------------------------------------------------------

//        Student zee = new Student("Zeeshan", "27-06-2000", "ATB456", "M.Sc Appl.Maths");
//
//        Course ode = new Course("Ordinary Differential Eq-1", "AM576", 4);
//        Course advOde = new Course("Ordinary Differential Eq-2", "AM577", 3);
//        Course realAnalysis = new Course("Real Analysis", "AM110", 5);
//        Course complexAnalysis = new Course("Complex Analysis", "AM121", 3);
//        Course pde = new Course("Partial Differential Eq", "AM621", 4);
//        Course statsDs = new Course("Statistics for Data Science", "ST184", 3);
//
//        Enrollment Zee_ode = new Enrollment(zee, ode, 82);
//        Enrollment Zee_pde = new Enrollment(zee, pde, 91);
//
//        zee.addEnrollement(Zee_ode);
//        zee.addEnrollement(Zee_pde);
//        System.out.println(Zee_ode.toString());
//        System.out.println(Zee_pde.toString());
//        System.out.println(zee.getEnrollements());

//        ----------------------------------------------------------------------------------------------

    }
}
