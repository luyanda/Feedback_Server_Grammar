package ava;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInteraction {
     BufferedReader bufferedReader;
     FileReader fileReader;
     ArrayList<ANTLR> projectList;
     UserInterface access = new DbAccess();

    public UserInteraction() throws Exception {

    }

    public Student Login() throws Exception{
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Number: ");
        int studentNo = scanner.nextInt();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        student.setUserId(studentNo);
        student.setPassword(password);
        return student;
    }

    public ANTLR chooseProject(Student student) throws Exception {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        projectList = new ArrayList<>();
        ANTLR project = new ANTLR();
        String word = null;
        //fileReader = new FileReader()
        int count =1;

        projectList = access.ProjectList(student);
        if (projectList.size()>0){
            System.out.println("***************\tChoose Project by Index number\t*************");
            System.out.println("#.\tName\t\t\t\tDue Date\t Tool");

            for (ANTLR p: projectList) {
                System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getClose()+"\t"+p.getToolName());count++;
            }
            System.out.print("\nEnter Project #:");
            int index = scan.nextInt();

            int c = 1;
            for (ANTLR p: projectList) {
                if (p.getId() == index)
                    return p;
                c++;
            }
        }
        else
        {System.out.println("No Project Selected");
            //break;
            }
            return project;
    }

    public static boolean checkFleExistence(String name){
        String directory = "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/src/ava/Files/Source";
        boolean check = new File(directory,name).exists();

        return check;
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is= new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
                System.out.print("File transferred!\n");
            }
        } finally {
            is.close();
            os.close();
        }
    }

    private static void processing() throws IOException, InterruptedException {
        String script = "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/src/ava/compile.sh";
        ProcessBuilder processBuilder = new ProcessBuilder(script);
        Process process = processBuilder.start();
        process.waitFor(5,TimeUnit.SECONDS);
        System.out.println("Processing file complete! ");
    }

    public void upLoadFile() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************\t upload file \t**************\n\n");
        System.out.println("Locate your file in this directory: /home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/src/ava/Files/Source\n");
        System.out.print("Enter file name, e.g(simpl.g4):");
        String filename = scanner.next();

        System.out.print("Checking file existence in directory :");
        if(checkFleExistence(filename)) {
            System.out.println(" File Exists ");
            File source = new File("/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/src/ava/Files/Source/"+filename);
            File des = new File("/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/src/ava/"+source.getName());
            System.out.println(source.getName());
            copyFileUsingStream(source,des);
            System.out.println("initiating file Processing!");
            processing();
        }
        else {
            System.out.print(" File doesn't exists");
        }
    }

    public String chooseStudent() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String user;

        System.out.print("Enter your student number:\t");
        user = bufferedReader.readLine();

        return user;
    }

    public void display(){
        System.out.println("+--------------------------------------------------+");
        System.out.println("\n \t You are Welcomed ");
    }

    public static void main(String []args) throws Exception {
        UserInteraction u = new UserInteraction();
        Student student = new Student();
        ANTLR p = new ANTLR();
        p = u.chooseProject(student);

        System.out.println(p.getId()+" "+p.getName());
    }
}
