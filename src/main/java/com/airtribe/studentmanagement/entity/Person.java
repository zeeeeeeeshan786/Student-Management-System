package main.java.com.airtribe.studentmanagement.entity;

import java.util.Date;

public class Person {
    // This is a base class -- Student and GraduateStudent will be extending Person Class
    private  String name;
    private String dateOfBirth; // dd-mm-yyyy format

    public Person(String personName,String dob){
        this.name = personName;
        this.dateOfBirth = dob;
    }

    public Person(){}

    public String getName(){
        return this.name;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public void setName(String nm){
        this.name = nm;
    }

    public void setDateOfBirth(String birthDate){
        this.dateOfBirth = birthDate;
    }

}
