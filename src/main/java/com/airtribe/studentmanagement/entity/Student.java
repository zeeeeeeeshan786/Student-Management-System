package main.java.com.airtribe.studentmanagement.entity;

import main.java.com.airtribe.studentmanagement.interfaces.Searchable;

import java.util.ArrayList;

public class Student extends Person implements Searchable {
    private String studentId; //ATB001 - Id format
    private String stream; // M.Sc Applied Maths, B.Tech Computer Sci, ... etc etc
    private ArrayList<Enrollment> enrollments ;  //Contains refrences of enrollements which will have data of std id, course id and corr marks...
    // Now created empty....will be inserted post std enrolled in each course.

    public Student(String nm,String dateOfBirth,String stdId,String stream  ){
        super(nm,dateOfBirth);  // constructor chaining
        this.studentId = stdId;
        this.stream = stream;
        this.enrollments = new ArrayList<Enrollment>();  // Created an empty ArrayList

    }
    // No arg const
    public Student(){

    }
    //Getters
    public String getStudentId(){
        return this.studentId;
    }

    public String getStream(){
        return this.stream;
    }
    public ArrayList<Enrollment> getEnrollements(){
        return this.enrollments;
    }

    //Setters
    public void setStudentId(String stdId){
        this.studentId = stdId;
    }

    public void setStream(String stream){
        this.stream = stream;
    }

    //Only possible to add enrollement Details one by one (or add one more to the existing list)
    public void addEnrollement(Enrollment enrollment){   // Association
        enrollments.add(enrollment);
    }

    // Drop Enrollement
    public void removeEnrollement(Enrollment enrollment){  // Association
        this.enrollments.remove(enrollment);
    }



    @Override // Searchable Interface Method Overridden
    public boolean search(String searchPhraseKeyword){
        if (searchPhraseKeyword == null){
            return false;
        }
        String searchedPhraseInLowerCase = searchPhraseKeyword.toLowerCase();
        boolean searchResult;

        searchResult = studentId.toLowerCase().contains(searchedPhraseInLowerCase) ||
                        stream.toLowerCase().contains(searchedPhraseInLowerCase) ||
                        this.getName().contains(searchedPhraseInLowerCase);
        return searchResult;
    }
}
