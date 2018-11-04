/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebOperation;
//package ava;

import ava.ANTLR;
import ava.DbAccess;
import ava.InstructorInteraction;
import static ava.Operations.Logger;
import ava.Student;
import ava.Submissions;
import ava.Testcase;
import ava.User;
import ava.UserInteraction;
import ava.UserInterface;
import ava.simplLexer;
import ava.simplParser;
import org.antlr.v4.runtime.*;

import java.nio.file.*;

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author epsilon
 */
@WebServlet(name = "Operation", urlPatterns = {"/Operation"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class Operation extends HttpServlet {
    private static final String SAVE_DIR = "uploadFiles";
    static String tracer;

    private static ArrayList<File> pFiles;
    private static ArrayList<File> nFiles;
    private static ArrayList<File> failedFiles;
    private static ArrayList<String> positiveFailed;


    static ArrayList<String> missmatch;
    static ArrayList<String> missLetter;
    static ArrayList<String> noVaiable;
    static ArrayList<String> extraneous;

    private static int positive;
    private static int negative;
    private static int npositive;
    private static int nnegative;
    private static int wrongcount;
    private static int negcount;
    private static int poscount;
    private static int Tcount;
    private static int negTcount;
    private static int posTcount;
	
    static String fileName;
    static String clueFile;
    static String errorMessage;
    static BufferedWriter bufferedClueWriter = null;
    static FileWriter clueWriter = null;
    static UserInterface access;

    static Testcase tObj = new Testcase();
    static Student sObj = new Student();
    static ANTLR pObj = new ANTLR();
    static Submissions subObj = new Submissions();

    static String mark;

    static{ pFiles = new ArrayList<>();nFiles = new ArrayList<>(); failedFiles = new ArrayList<>(); positiveFailed = new ArrayList<>();
        positive = 0;negative = 0;npositive = 0; missmatch = new ArrayList();
        nnegative =0;wrongcount = 0;negcount = 0; missLetter = new ArrayList();
        poscount = 0;Tcount = 0;negTcount=0;noVaiable = new ArrayList();extraneous = new ArrayList();
        posTcount=0;fileName = "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/src/ava/TestCasesFile.txt";
        clueFile = "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/src/ava/TestCaseCluesFile.txt";
        mark = "";
        errorMessage = "";
        try {
            access = new DbAccess();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    };

    public Operation() throws Exception {
    }
    
        private static ArrayList<File> Recursive(File[] arr, ArrayList<File> files){
        for(File f:arr)
        {
            if(f.isFile()) {
                files.add(f);
            }
            else if(f.isDirectory() && f.list().length>0){
                Recursive(f.listFiles(), files);
            }
        }
        return files;
    }

    final private static void FeedBackProcessing(ArrayList<File> pFiles, ArrayList<File> nFiles, double tcount,double pcount, double ncount,double negative,double negpositive,double wrongfiles)throws ClassNotFoundException,Exception, IOException{
	if(nFiles.size()>0 || pFiles.size()>0)
            subObj.setResults("Unfortunately You Fail!");
        else
            subObj.setResults("Congratulations you Passed");

	if (pFiles.size()>0 && pFiles.get(0).getParent().contains("positive")){
            System.out.print("\nFailed Positive test cases >:");
            mark=mark+"Positive Passed: ";
            ResultsStats(negative,pcount);
            for(File negFile : pFiles){
	    }
        }

        if (nFiles.size()>0 && nFiles.get(0).getParent().contains("negative")) {

            System.out.print("\nFailed Negative test cases >:");
            mark =mark+" Negative Passed:";
            ResultsStats(negpositive,ncount);
            for (File posfiles : nFiles){
            }
        }
        tObj.setOutcomes("Failed Testcases");
        subObj.setFeedback(mark);

        System.out.println("Please wait while we process your results !");
        DbAccess acc = new DbAccess();
        String trace="";
try{
    
    trace = acc.RecordSubmission(sObj,pObj,subObj,tObj,failedFiles);
    tracer = trace;
    //System.out.println("\n\n\n\tSubmission ID :"+trace);
    System.out.println("\n\n\n\ttrace :"+trace);
    System.out.println("\n\n\n\tProject ID :"+pObj.getId());
    if(failedFiles.size()>0)
         System.out.println("\n\n\n\tWe have Failed Testcases :");
//    for()
acc.RecordPositiveMessages(pObj,failedFiles,trace);
    //subObj = acc.GetSubmissionId(sObj, pObj, trace);
}catch (Exception ex) {
            java.util.logging.Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
try{
    //String trace = acc.RecordSubmission(sObj,pObj,subObj,tObj,failedFiles);
    System.out.println("\n\n\n\tStudent number :"+sObj.getUserId());
    System.out.println("\n\n\n\tProject ID: "+pObj.getId());
    System.out.println("\n\n\n\ttrace :"+trace);
    //subObj = acc.GetSubmissionId(sObj, pObj, trace);
    
}catch (Exception ex) {
            java.util.logging.Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
  //      File file = new File(fileName);
    }

    final private static void ResultsStats(double count, double ccount){
        double average = 0.0;
        double results = 0.0;
        average = (count/ccount)*100;
        results = (double) Math.round(average*100.0)/100.0;
        mark = mark+results;//+"%";

        System.out.println(results+" % out of "+ccount+" Files\n");
    }

    final private static boolean TestcasePathValidation(File userInput){
       try{
	    userInput.exists();
	    userInput.isDirectory();
        }catch(Exception e){
        return false;
        }
        return true;
    }

    final private static void TestCasesCountFiles(File filePath,int errorCounter){


        if(filePath.getParent().contains("positive")){
            pFiles.add(filePath);
            poscount++;
            if (errorCounter == 0) {
                positive++;
            }else {
                failedFiles.add(filePath);
                negative++;
            }
        }
        else if (filePath.getParent().contains("negative")){
            nFiles.add(filePath);
            negcount++;
            if (errorCounter == 0) {
                failedFiles.add(filePath);
                npositive++;
            }else {
                nnegative++;
            }
        }
    }

    final private static ArrayList<String> methodOne(ArrayList<String> arrayList, ArrayList<String> list){
        //ArrayList<String> list = new ArrayList();
        if(list.isEmpty()){
            list.add(arrayList.get(0));
            arrayList.remove(0);
            //System.out.println(list.size()+" & "+arrayList.size());
        }
        if(arrayList.size()>0){
            String[] finder = list.get(list.size()-1).split("\n");
            //System.out.println(finder[0]);
            for (String str : arrayList){
                String[] word = str.split("\n");
                if(word[0].endsWith(finder[0])){
                    arrayList.remove(str);
                    return methodOne(arrayList,list);
                }
                else{
                    list.add(arrayList.get(0));
                    return methodOne(arrayList,list);
                }
            }
        }
        else {
            return list;
        }
        return list;
    }

    final private static ArrayList<String> ErrorMessageProcessing(ArrayList<String> arrayList){

        if(arrayList.size()>0){
            Collections.sort(arrayList);

            int max = arrayList.size();
            for (int i=0;i<max;i++) {
                String[] retval = arrayList.get(i).split("\n");
                if (i+1==max) {
                        return arrayList;
                    }
                    else{
                        if (arrayList.get(i + 1).endsWith(retval[1])) {
                            arrayList.remove(i + 1);
                        }
                    }
                }
            }
        return arrayList;
    }

    final private static class VerboseListenerForPositive extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            errorMessage = "";

            errorMessage =msg+"\n";

            underlineError(recognizer,(Token)offendingSymbol,line,charPositionInLine);
            positiveFailed.add(errorMessage);

            if (msg.toLowerCase().contains("mismatched input".toLowerCase())){
                missmatch.add(errorMessage);
            }
            else if(msg.toLowerCase().contains("no viable alternative at input".toLowerCase())){
                noVaiable.add(errorMessage);
            }
            else if(msg.toLowerCase().contains("extraneous input".toLowerCase())){
                extraneous.add(errorMessage);
            }
            else if(msg.toLowerCase().contains("missing LETTER".toLowerCase())){
                missLetter.add(errorMessage);
            }
        }
        protected void underlineError(Recognizer recognizer,Token offendingToken, int line, int charPositionInLine){
            CommonTokenStream tokens = (CommonTokenStream)recognizer.getInputStream();

            String input = tokens.getTokenSource().getInputStream().toString();
            String[] lines = input.split("\n");
            String errorLine = lines[line - 1];

            errorMessage +=errorLine+"\n";

            for(int i = 0; i<charPositionInLine; i++) errorMessage+="_";

            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();

            if(start>=0 && stop>=0){
                for(int i = start; i<=stop;i++) errorMessage+="^";
            }
        }
    }

    final private static class VerboseListenerForNegative extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        }
    }

    private static String TestcaseMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTo view Test cases Randomly enter(R/r)" +
                "\nTo view Positive test cases only enter(P/p)" +
                "\nTo view Negative Test cases only enter(N/n)" +
                "\nTo exit enter(exit)" +
                "\n>>>>>: ");
        String answer = scanner.next();

        return answer;
    }

    private static String subMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTo view next Test case enter(next)" +
                "\nTo opt out to Test case menu, enter(out)" +
                "\nTo exit enter(exit)" +
                "\n>>>>>: ");
        String answer = scanner.next();

        return answer;
    }

    private static void display(String errorMessages){
        System.out.println("\n+Detailed_Positive==========================================================");
        System.out.print(errorMessages);
        System.out.println("\n============================================================================");

    }

    private static String subSubMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTo view next false Positive Test case enter(next)" +
                "\nTo opt out to Test case menu, enter(d)" +
                "\nTo exit enter(exit)" +
                "\n>>>>>: ");
        String answer = scanner.next();

        return answer;
    }

    final private static void TestingParserForPositiveFiles(File f)throws Exception{
        String exten = f.getName();
        String path = f.getParent();
        if(exten.contains(".simpl")){
            FileInputStream fis = new FileInputStream(f);
            //ANTLRInputStream input = new ANTLRInputStream(fis);
            CharStream input = CharStreams.fromStream(fis);
            simplLexer lexer = new simplLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new VerboseListenerForPositive());
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            simplParser parser = new simplParser(tokens);
            parser.removeErrorListeners();//removes console error listener
            parser.addErrorListener(new VerboseListenerForPositive());//add my listener
            parser.program();
            //parser.getNumberOfSyntaxErrors();
            //ParseTree tree = parser.program();//if simpl changes this has to change.
            int errorCounter = parser.getNumberOfSyntaxErrors();
            Tcount++;
            TestCasesCountFiles(f,errorCounter);
        }
        else{
            wrongcount++;
        }
    }

    final private static void TestingParserForNegativeFiles(File f)throws Exception{
        String exten = f.getName();
        String path = f.getParent();
        if(exten.contains(".simpl")){
            FileInputStream fis = new FileInputStream(f);
            //ANTLRInputStream input = new ANTLRInputStream(fis);
            CharStream input = CharStreams.fromStream(fis);
            simplLexer lexer = new simplLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new VerboseListenerForNegative());
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            simplParser parser = new simplParser(tokens);
            parser.removeErrorListeners();//removes console error listener
            parser.addErrorListener(new VerboseListenerForNegative());//add my listener
            parser.program();
            //parser.getNumberOfSyntaxErrors();
            //ParseTree tree = parser.program();//if simpl changes this has to change.
            int errorCounter = parser.getNumberOfSyntaxErrors();
            Tcount++;
            TestCasesCountFiles(f,errorCounter);
        }
        else{
            wrongcount++;
        }
    }

    final private  static void FirstMethod()throws Exception, IOException{
        ArrayList<File> filesList;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // System.out.print("Enter Test cases directory:\t");
        String inputt = "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/"
                + "Year Project/Simple Test cases/simpl-tests/positive/cdrc";//"/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/test-cases";//"/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/simpl-tests"; // "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/test-cases";//br.readLine();
        //"/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/simpl-tests/positive/derivation";//
        fileName = inputt;
        System.out.print("\nPlease wait wile we process your Grammar!\t\n");

        String userInput = new String(inputt);
        File directory = new File(userInput);//creating a processable directory file
        DbAccess accesssor = new DbAccess();
        if(TestcasePathValidation(directory)){//validating file directory
            filesList = new ArrayList<>();
            ArrayList<Testcase> testFiles = new ArrayList<>();

            testFiles = accesssor.TestCaseList();
            File arr[] = directory.listFiles();
            filesList = Recursive(arr, new ArrayList<File>());

//            clueWriter = new FileWriter(clueFile);
//            bufferedClueWriter = new BufferedWriter(clueWriter);
            if (!filesList.isEmpty()){
                for(File f : filesList){
                    if(f.getParent().contains("positive"))
                        TestingParserForPositiveFiles(f);
                    else
                        TestingParserForNegativeFiles(f);
                }
                FeedBackProcessing(pFiles,nFiles,Tcount,poscount,negcount,negative,npositive,wrongcount);
            }
        }
        else{
            System.out.println("Input is not a directory!");
     //       System.exit(0);
        }
    }

    private static void UserCalls(User user,ANTLR antlr)throws Exception,IOException{
//        UserInteraction userInteraction = new UserInteraction();
//        userInteraction.display();
//updating student object
        sObj.setId(user.getId());
        sObj.setUserId(user.getUserId());
        sObj.setName(user.getName());
        sObj.setType(user.getType());
//updating student's project.
        pObj = antlr;
        System.out.println("project number "+pObj.getId());
        if(antlr==null){
            System.out.println("no projects registered under the user");
      //      System.exit(0);
        }
        processor();
//        userInteraction.upLoadFile();
        try{
        FirstMethod(); }catch (Exception ex) {
            java.util.logging.Logger.getLogger(Operation.class.getName()).log(Level.FINE, null, ex);
        }
//        if(pFiles.size() >= 0 || nFiles.size() >= 0)
//            TestCaseViewInteractionWithUser();
    }

    private static void AdminMenu(int value) throws Exception{
        InstructorInteraction inst = new InstructorInteraction();
        Scanner scanner = new Scanner(System.in);

        if(value == 1){
            System.out.println("\n\nTo view students, enter(1)");
            System.out.println("To add student, enter(2)");
            System.out.println("To assign Project, enter(3)");
            System.out.println("to log out, enter(0)");
            int num = scanner.nextInt();
            if(num==1)
                inst.StudentViewList();
            else if(num == 2)
                inst.addStudent();
            else if(num ==3)
                inst.AssignProject();
            else if(num ==0){
                Logout();
            }else
                System.out.println("Wrong input");


        }else if(value == 2){
            System.out.println("\n\nTo view Projects, enter(1)");
            System.out.println("To add Project, enter(2)");
            System.out.println("To edit project, enter(3)");
            System.out.println("to log out, enter(0)");
            int num = scanner.nextInt();
            if(num == 1)
                inst.ProjecttViewList();
            else if(num ==2)
                inst.addProject();
            else if(num ==3)
                inst.EditProject();
            else if(num ==0){
                Logout();
            }
            else
                System.out.println("Wrong input");
        }else if(value == 3){
            System.out.println("\n\nTo view Submissions list, enter(1)");
            System.out.println("to log out, enter(0)");
            int num = scanner.nextInt();
            if(num == 1)
                inst.SubmissionsView();
            else if(num ==0){
                Logout();
            }
            else
                System.out.println("Wrong input!");
        }else if(value ==4){
            System.out.println("\n\nTo view Test case list, enter(1)");
            System.out.println("to log out, enter(0)");
            int num = scanner.nextInt();
            if (num==1)
                inst.TestCaseList();
            else if(num==0){
                Logout();
            }
            else
                System.out.println("Wrong input!");
        }
        else
            System.out.println("No Selection made!");


        InstructorCalls();
    }

    private static void Logout(){
        System.out.println("\tCome back again.\n\tHave a nice day.");
        System.exit(0);
    }

        private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    
    public static void InstructorCalls() throws Exception {


        Scanner scanner = new Scanner(System.in);
        int value;

        System.out.println("\n\nTo go to students, enter(1):");
        System.out.println("To go to projects, enter(2):");
        System.out.println("To go to Submissions, enter(3):");
        System.out.println("To go to Test Cases, enter(4)");
        System.out.println("to log out, enter(0)");
        do {
            System.out.print("Enter your Option >>>>:");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println("NOT VALID INPUT! try again");
                System.out.print("Enter your Option >>>>:");
            }
            value = scanner.nextInt();
        } while (value < 0 || value>4);

        AdminMenu(value);



    }
    
    public static void Logger()throws Exception{
        User user = new User();
        User logedUser = new User();
        InstructorInteraction inst = new InstructorInteraction();
        access = new DbAccess();
        Scanner scanner = new Scanner(System.in);
        int userNo;
        String password = "";

        System.out.println("Welcome to FeedBack Grammar System\n\n");
        System.out.println("Login page!\n");

        do {
            System.out.print("Enter User number >>>>:");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.println("NOT VALID USER NUMBER! try again");
                System.out.print("Enter User number:");
            }
            userNo = scanner.nextInt();
        } while (userNo < 0);

        System.out.print("Enter User password >>>>:");

        password = scanner.next();
        user.setUserId(userNo);
        user.setPassword(password);
        try{
            logedUser = access.UserLogin(user);
        }
        catch (NullPointerException e){
            System.out.println("Wrong Credentials! ");
            System.exit(0);
        }

        System.out.println("User logged!\n\n");
        if(logedUser.getType().equalsIgnoreCase("student")){
           // UserCalls(logedUser);
        }
        else if(logedUser.getType().equalsIgnoreCase("instructor")){
            inst.Welcome();
            InstructorCalls();
        }
    }

    private static void processor() throws IOException, InterruptedException {
        //String files_generation = destination + "webgenerate.sh";
        //String gen_executable = "chmod +x " + destination + "webgenerate.sh";
        //String comp_executable = "chmod +x " + destination + "webcompile.sh";
        String executor = "/home/epsilon/Documents/Varsity/Project/src/java/ava/./executor.sh";

        Runtime.getRuntime().exec(executor);
        //Runtime.getRuntime().exec(comp_executable);
        //Runtime.getRuntime().exec(files_generation);

        System.out.println("\n\n\tGenerating & Compiling files complete! ");
    }
    
    private static void transfere() throws IOException {
        //Copying generations script;compile script and antlr tool to the uploaded file for processing
        File gen_shell = new File("/home/epsilon/Documents/Varsity/Project/src/java/ava/webgenerate.sh");
        File comp_shell = new File("/home/epsilon/Documents/Varsity/Project/src/java/ava/webcompile.sh");
        //File tool = new File("/home/epsilon/Documents/Varsity/Project/src/java/ava/antlr-4.7.1-complete.jar");
        //file destination
        File dest = new File("/home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/");
        //making scripts executable

        Runtime.getRuntime().exec("chmod +x /home/epsilon/Documents/Varsity/Project/src/java/ava/webgenerate.sh");
        Runtime.getRuntime().exec("chmod +x /home/epsilon/Documents/Varsity/Project/src/java/ava/webcompile.sh");

        FileUtils.copyFileToDirectory(gen_shell, dest);
        FileUtils.copyFileToDirectory(comp_shell, dest);
        //FileUtils.copyFileToDirectory(tool, dest);

        System.out.println("File transfere completed");
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        Submissions submission = new Submissions();
        DbAccess acc = new DbAccess();
        // User userlogged = (User)session.getAttribute("LoggedIn");
        try {
            HttpSession session = request.getSession();
            User userlogged = (User) session.getAttribute("LoggedIn");
            ANTLR antlr = (ANTLR) session.getAttribute("project");

            System.out.println("Student number " + userlogged.getUserId());
            System.out.println("project number " + antlr.getId());
            String appPath = request.getServletContext().getRealPath("");// gets absolute path of the web application
            String savePath = appPath + File.separator + SAVE_DIR;// constructs path of the directory to save uploaded file
            // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                // refines the fileName in case it is an absolute path
                fileName = new File(fileName).getName();
                part.write(savePath + File.separator + "simpl.g4");
                System.out.println("File uploaded then renamed to simpl.g4");
            }
            try {
                transfere();
                request.setAttribute("LoggedIn", userlogged);
                request.setAttribute("project", antlr);
                UserCalls(userlogged, antlr);
            } finally {
                if(failedFiles.size()>0){
                    request.setAttribute("failedFiles",failedFiles);
                }
                if(missmatch.size()>0)
                    request.setAttribute("missmatch", missmatch);
                
                if(missLetter.size()>0)
                    request.setAttribute("missLetter", missLetter);
                
                if(extraneous.size()>0)
                    request.setAttribute("extraneous", extraneous);
                
                if(noVaiable.size()>0)
                    request.setAttribute("noVaiable", noVaiable);
                
                if(subObj != null)
                    request.setAttribute("subObj",subObj);
                
                request.setAttribute("tracer", tracer);
                System.out.println("Done!");
            }
        } catch (Exception ex) {

        } finally {
            Runtime.getRuntime().exec("/home/epsilon/Documents/Varsity/Project/src/java/WebOperation/./removeFiles.sh");
        }
        rd = request.getRequestDispatcher("Submission.jsp");
        rd.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
