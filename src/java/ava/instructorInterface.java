package ava;


import java.util.ArrayList;

public interface instructorInterface {
    public boolean addStudent(Student student)throws Exception;
    public boolean assignProject(Student student, ANTLR ant4r)throws Exception;
    public boolean insertProject(ANTLR antlr)throws Exception;
    public boolean editProject(ANTLR antlr)throws Exception;
    public ArrayList<Student> studentList()throws Exception;
    public ArrayList<ANTLR> ProjectsList()throws Exception;
    public ArrayList<Submissions> submisionsList()throws Exception;
    public ArrayList<Testcase> getTestCases()throws Exception;



    //Login
    //add project
    //add student to project
    //view project
    //view projects and students
    //view submissions
    //view submissions with test case stats
    //view
}
