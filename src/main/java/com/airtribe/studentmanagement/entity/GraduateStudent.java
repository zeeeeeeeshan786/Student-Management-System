package main.java.com.airtribe.studentmanagement.entity;

public class GraduateStudent extends Student{
    private String thesisTopic;
    private double cgpa;

    public GraduateStudent(){

    }

    public GraduateStudent(String nm,String dateOfBirth,String stdId,String stream,String topicOfReseach, float cgpa){
        super( nm, dateOfBirth, stdId, stream ); //Cons Chaining for 2 classes...  Student-->Person
        this.thesisTopic = topicOfReseach;
        this.cgpa = cgpa;
    }

    public String getThesisTopic(){
        return this.thesisTopic;
    }

    public double getCgpa(){
        return this.cgpa;
    }

    public void setThesisTopic(String thesisTopic){
        this.thesisTopic = thesisTopic;
    }

    public void setCgpa(double cgpa){
        this.cgpa = cgpa;
    }
}
