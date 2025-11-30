package main.java.com.airtribe.studentmanagement.entity;

import main.java.com.airtribe.studentmanagement.interfaces.Searchable;

public class Course implements Searchable {
    public String courseName; // Association
    public String courseCode; // Association
    public int courseCredits;

    public Course(String courseName, String courseCode, int courseCredits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredits = courseCredits;
    }

    public Course(){

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public String toString(){
        return courseCode + "- '" + courseName + "' ( Credits : " + courseCredits + " )";
    }

    @Override
    public boolean search(String searchPhraseKeyword){
        if (searchPhraseKeyword == null){
            return false;
        }
        String searchedPhraseInLowerCase = searchPhraseKeyword.toLowerCase();
        boolean searchResults;
        searchResults = this.courseName.toLowerCase().contains(searchedPhraseInLowerCase) ||
                this.courseCode.toLowerCase().contains(searchedPhraseInLowerCase) ;

        return searchResults;
    }

}
