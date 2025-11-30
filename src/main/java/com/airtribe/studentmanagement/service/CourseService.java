package main.java.com.airtribe.studentmanagement.service;

import main.java.com.airtribe.studentmanagement.entity.Course;
import main.java.com.airtribe.studentmanagement.entity.Student;
import main.java.com.airtribe.studentmanagement.exception.CourseNotFoundException;

import javax.xml.transform.Source;
import java.util.ArrayList;

public class CourseService {

    ArrayList<Course> courseArrayList = new ArrayList<>();

    public void addCourse(Course newCourse){
        courseArrayList.add(newCourse);
    }

    public void removeCourse(Course newCourse){
        courseArrayList.remove(newCourse);
    }

    public Course getCourseByCode(String courseCodeProvidedToSearch) throws CourseNotFoundException {
        for(Course availableCourse : courseArrayList){
            if (availableCourse.getCourseCode().equals(courseCodeProvidedToSearch) ){
                System.out.println("Course with Provided Course ID "+ courseCodeProvidedToSearch + " is available, returning Course.");
                return availableCourse;
            }
        }
        throw new CourseNotFoundException("Course with Provided Course ID "+ courseCodeProvidedToSearch + " is not available available!");
    }

    public ArrayList<Course> searchCourses(String courseSearchKeyword){
        //Create an ArrayList to store the result of search and then print this..
        int courseFoundCount = 0;
        ArrayList<Course> resultOfCourseSearch = new ArrayList<>();
        for (Course availableCourse : courseArrayList){
            if (availableCourse.search(courseSearchKeyword)){
//                System.out.println("Course(s) found based on your search keyword");
                courseFoundCount++;
                resultOfCourseSearch.add(availableCourse);
            }

        }
        if(courseFoundCount == 0){
            System.out.println("No Courses Found with this Keyword!");
        } else{
            System.out.println(courseFoundCount + " Courses found with searched keyword");
        }
        return resultOfCourseSearch;
    }
}




//addCourse(Course c), getCourseByCode(String code).