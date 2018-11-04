package ava;//package ava;

import java.util.*;

import java.util.Scanner;


public class InstructorInteraction {
    static instructorInterface instr;
    static Operations operations;// = new Operations();

    public InstructorInteraction(){}
    //add project`
    public ANTLR addProject(){
        Scanner scanner = new Scanner(System.in);
        ANTLR project = new ANTLR();
        System.out.println("++++++++++++\t Adding Project\t +++++++++++++\n");

        System.out.print("Enter Project Name e.g Use this format (cs144 Project_010): ");
        String name = scanner.next();//handle errors
        project.setName(name);
        System.out.print("\nEnter Open Date e.g Use this format (12-01-2018):");
        String open = scanner.next();
        project.setOpen(open);
        System.out.print("\nEnter Close Date e.g Use this format (12-12-2018)");
        String close = scanner.next();
        project.setClose(close);
        System.out.print("\nEnter File Name e.g Use this format ()");
        String tool = scanner.next();
        project.setToolName(tool);

        return project;
    }
    //add student to project
    public void addStudent()throws Exception{

        Scanner scanner = new Scanner(System.in);
        instr = new DbAccess();
        System.out.println("\tADD STUDENT INTERFACE\n");
        int userNo;
        String password;
        do {
            System.out.print("Enter Student ID:");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println("NOT VALID Student ID! try again");
                System.out.print("Try again, Enter User number:");
            }
            userNo = scanner.nextInt();
        } while (userNo < 0);

        do {
            System.out.print("Assign Student \"" + userNo + "\" a  NEW PASSWORD:");
            while(!scanner.hasNext()){
                String input = scanner.next();
                System.out.println("NOT VALID PASSWORD! try again");
                System.out.println("length must be longer than 2");
                System.out.print("try again, Enter password");
            }
            password = scanner.next();
        }while(password.length()<3);

        if(userNo>0 && password.length()>0){
            Student student = new Student();
            ((Student) student).setUserId(userNo);
            ((Student) student).setPassword(password);
            ((instructorInterface) instr).addStudent(student);

            System.out.println("Student added!");
        }
        else {
            System.out.println("Student not added, an error happen. try again");
        }
    }

    public static void StudentViewList()throws Exception{
        ArrayList<Student> list = new ArrayList();
        instr = new DbAccess();
        list = ((DbAccess) instr).studentList();
        System.out.println("\tList of Student Subscribed\n");
        System.out.println(" ID |\tStudent No |");
        for(Student student : list){
            System.out.println("| "+student.getId()+" |\t"+student.getUserId());
        }
    }

    public static void SubmissionsView()throws Exception{
        ArrayList<Submissions> list = new ArrayList<>();
        instr = new DbAccess();
        list = instr.submisionsList();

        for(Submissions submissions : list){
            System.out.println("| "+submissions.getId()+" | "+submissions.getStudentNo()+" | "+submissions.getProjectName()+" | "+submissions.getFeedback()+" | "+submissions.getResults()+" | "+submissions.getDate()+" |");
        }
    }

    public void AssignProject() throws Exception {
        int userNo;
        int projectId;
        instr = new DbAccess();
        Student student = new Student();
        ANTLR antlr = new ANTLR();
        Scanner scanner = new Scanner(System.in);

        ProjecttViewList();
        System.out.println();
        StudentViewList();
        System.out.println("\t Assign Project to Student\n");
        System.out.println();
        do {
            System.out.print("Enter Student Number:");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println("NOT VALID Student Number! try again");
                System.out.print("Try again, Enter Student number:");
            }
            userNo = scanner.nextInt();
        } while (userNo < 0);

        do {
            System.out.print("Enter Project ID:");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println("NOT VALID Project ID! try again");
                System.out.print("Try again, Enter Project ID:");
            }
            projectId = scanner.nextInt();
        } while (projectId < 0);

        student.setUserId(userNo);
        antlr.setId(projectId);
        boolean results = false;
        try {
            results = instr.assignProject(student, antlr);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(results)
            System.out.println("Project assigned to Student!");
        else
            System.out.println("Failed, Project Not Assigned to Student. try agin");
    }

    public static void ProjecttViewList()throws Exception{
        ArrayList<ANTLR> list = new ArrayList();
        instr = new DbAccess();
        list =  instr.ProjectsList();
        System.out.println("\tList of Projects\n");
        System.out.println(" ID |\tName |\t Open date|\tClose Date|\t Tool Name|\t");
        for(ANTLR project : list){
            System.out.println("| "+project.getId()+" |\t"+project.getName()+"|\t"+project.getOpen()+" |\t"+project.getClose()+" |"+" |\t"+project.getToolName());
        }
    }

    public static void AddProject()throws Exception{
        Scanner scanner = new Scanner(System.in);
        ANTLR antlr = new ANTLR();
        instr = new DbAccess();
        String name,open,close,tool;
        System.out.println("\n\t Adding a Project\n");
        System.out.print("Enter Project Name: ");
        name = scanner.next();
        System.out.print("Enter Open Date: ");
        open = scanner.next();
        System.out.print("Enter Close Date: ");
        close = scanner.next();
        System.out.print("Enter Tool Name");
        tool = scanner.next();

        antlr.setName(name);
        antlr.setOpen(open);
        antlr.setClose(close);
        antlr.setToolName(tool);

        boolean results = false;
        try{
            results = instr.insertProject(antlr);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(results)
            System.out.println("Project Added!");
        else
            System.out.println("Failed!, Project Not Added, try again");

    }

    public static void EditProject()throws Exception{
        Scanner scanner = new Scanner(System.in);
        ANTLR antlr = new ANTLR();
        instr = new DbAccess();
        ProjecttViewList();
        System.out.println("\t Edit Project \n");
        System.out.print("Enter Project's ID to be edited:");
        int id = scanner.nextInt();
        System.out.print("Change Name to: ");
        String name = scanner.next();
        System.out.print("Change Open date to:");
        String open = scanner.next();
        System.out.print("Change Close date to:");
        String close = scanner.next();
        System.out.print("Change Tool Name to:");
        String tool = scanner.next();

        antlr.setId(id);
        antlr.setName(name);
        antlr.setOpen(open);
        antlr.setClose(close);
        antlr.setToolName(tool);
        boolean results = false;
        try{
            results = instr.editProject(antlr);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(results)
            System.out.println("Project Updated!");
        else
            System.out.println("Failed, Project Not Updated");
        operations = new Operations();
        operations.InstructorCalls();
    }

    public static void TestCaseList()throws Exception{
        instr = new DbAccess();
        ArrayList<Testcase> list = new ArrayList<>();
        System.out.println("\t Test Case List\n");
        System.out.println("| id \tName\t Outcome");
        list = instr.getTestCases();
        int i = 0;
        for (Testcase testcase : list){
            System.out.println(testcase.getId()+"\t"+testcase.getName()+"\t"+testcase.getOutcomes());i++;
        }
        System.out.println("Total Number:"+i);

    }

    public void Welcome(){
        System.out.println("\t WELCOME TO ADMINISTRATOR PAGE!\n\n");

    }
    //public
    //check submitted students
    //check submitted students with viewed test casess
    //
}
