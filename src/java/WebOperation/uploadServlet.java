/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebOperation;

import ava.ANTLR;
import ava.DbAccess;
import ava.Student;
import ava.Submissions;
import ava.Testcase;
import ava.UserInterface;
import ava.simplLexer;
import ava.simplParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.apache.commons.io.FileUtils;
import ava.*;
import java.util.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/uploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class uploadServlet extends HttpServlet {

    private static Student student;
    private static Submissions submission;
    private static ANTLR antlr;
    private static User user = new User();
    private static Testcase testcase;

    private static String destination;
    private static String location;
    private static String dispatch;
    private static String mark = "";

    private static ArrayList<File> pFiles;
    private static ArrayList<File> nFiles;
    private static ArrayList<File> failedFiles;
    private static ArrayList<String> positiveFailed;

    static ArrayList<String> missmatch;
    static ArrayList<String> missLetter;
    static ArrayList<String> noVaiable;
    static ArrayList<String> extraneous;
    static String errorMessage;

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

    private static String testcaseLocation;

    static {
        student = new Student();
        submission = new Submissions();
        testcase = new Testcase();
        pFiles = new ArrayList<>();
        nFiles = new ArrayList<>();
        failedFiles = new ArrayList<>();
        positiveFailed = new ArrayList<>();
        positive = 0;
        negative = 0;
        npositive = 0;
        missmatch = new ArrayList();
        nnegative = 0;
        wrongcount = 0;
        negcount = 0;
        missLetter = new ArrayList();
        poscount = 0;
        Tcount = 0;
        negTcount = 0;
        noVaiable = new ArrayList();
        extraneous = new ArrayList();
        posTcount = 0;
        errorMessage = "";

        location = "/";
        destination = "/home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/";
        dispatch = "chooseProject.jsp";

        testcaseLocation = "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/simpl-tests/positive";//"/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/simpl-tests/positive";
    }
    /**
     * Name of the directory where uploaded files will be saved, relative to the
     * web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";
    ArrayList<String> errorList = new ArrayList<String>();
    static UserInterface access;

    public uploadServlet() throws Exception {
        this.access = new DbAccess();
    }

    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Message = "File Processing FAILED!";
        //String destination = "/home/epsilon/Documents/Varsity/Project/build/web/uploadFiles/";
        //ANTLR antlr = new ANTLR();
        HttpSession session = request.getSession();
        RequestDispatcher rd;

        antlr = (ANTLR) session.getAttribute("project");
        user = (User) session.getAttribute("LoggedIn");
        session.setAttribute("user", user);
        session.setAttribute("project", antlr);
        //session.setAttribute("checker",student);

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

        String file = destination + "simpl.g4";
        String parser_class = destination + "simplParser.class";
        String lexer_class = destination + "simplLexer.class";

        //validateFile(file);
        transfere();//transfere necessary files for file generation
            try {

                processor();//manage file generation
                UserCalls(user);
                request.setAttribute("student", student);
                request.getSession().setAttribute("student", student);
                this.getServletConfig().getServletContext().setAttribute("student", student);
                request.setAttribute("submission", submission);
                request.getSession().setAttribute("submission", submission);
                this.getServletConfig().getServletContext().setAttribute("submission", submission);
                
                Runtime.getRuntime().exec("chmod +x /home/epsilon/Documents/Varsity/Project/src/java/WebOperation/removeFiles.sh");
                Runtime.getRuntime().exec("/home/epsilon/Documents/Varsity/Project/src/java/WebOperation/./removeFiles.sh");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getStackTrace());
            }
        
        

        System.out.println("\t\t\tFiles processed succesfully!");
        Message = "Upload has been done successfully! You will be redirected to results Page please wait!";
        
        dispatch = "/Submission.jsp";
        request.setAttribute("message", Message);
        //response.sendRedirect(dispatch);
        //getServletContext().getRequestDispatcher(dispatch).forward(request, response);
        rd = request.getRequestDispatcher(dispatch);
        rd.forward(request, response);
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private static void progressStatus() {
        System.out.println("File was successfully uploaded\n"
                + "Lexer and Parser generation completeted successfully\n"
                + "Java files Compiled successfully");
    }

    private static boolean validateFile(String file) {
        boolean valid;
        File newFile = new File("cookbook.txt");

        if (newFile.length() < 15) {
            valid = false;
            System.out.println("Sothing went wrong with the file, It may be empty or doesn't meet the file requirements ... Try again");
        } else {
            valid = true;
            System.out.println("Uploaded file is not empty ...");
        }
        return valid;
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

    private static void processor() throws IOException, InterruptedException {
        String files_generation = destination + "webgenerate.sh";
        String gen_executable = "chmod +x " + destination + "webgenerate.sh";
        String comp_executable = "chmod +x " + destination + "webcompile.sh";

        Runtime.getRuntime().exec(gen_executable);
        Runtime.getRuntime().exec(comp_executable);
        Runtime.getRuntime().exec(files_generation);

        System.out.println("Generating file complete! ");
    }

    private static void UserCalls(User user) throws Exception {

        student.setId(user.getId());
        student.setUserId(user.getUserId());
        student.setName(user.getName());
        student.setType(user.getType());

        System.out.println("\n\n\t\tInside the user call methods\n\n");
        ArrayList<File> filesList = null;
        ArrayList<Testcase> testFiles = new ArrayList<>();
        String inputLocation = new String(testcaseLocation);
        File directory = new File(inputLocation);

        if (TestcasePathValidation(directory)) {//validating file directory
            filesList = new ArrayList<>();
            testFiles = access.TestCaseList();
            File arr[] = directory.listFiles();
            filesList = Recursive(arr, new ArrayList<File>());

            if (!filesList.isEmpty()) {
                for (File f : filesList) {
                    if (f.getParent().contains("positive")) {
                        TestingParserForPositiveFiles(f);
                    } else {
                        TestingParserForNegativeFiles(f);
                    }
                }
                FeedBackProcessing(pFiles, nFiles, Tcount, poscount, negcount, negative, npositive, wrongcount);
                System.out.println("After Submission");
            }
        } else {
            System.out.println("Test case Directory Not valid. change the directory.");
            //System.exit(0);
        }
    }

    final private static boolean TestcasePathValidation(File userInput) {
        try {
            userInput.exists();
            userInput.isDirectory();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static ArrayList<File> Recursive(File[] arr, ArrayList<File> files) {
        for (File f : arr) {
            if (f.isFile()) {
                files.add(f);
            } else if (f.isDirectory() && f.list().length > 0) {
                Recursive(f.listFiles(), files);
            }
        }
        return files;
    }

    final private static void TestingParserForPositiveFiles(File f) throws Exception {
        String exten = f.getName();
        String path = f.getParent();
        if (exten.contains(".simpl")) {
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
            TestCasesCountFiles(f, errorCounter);
        } else {
            wrongcount++;
        }
    }

    final protected static void TestingParserForNegativeFiles(File f) throws Exception {
        String exten = f.getName();
        String path = f.getParent();
        if (exten.contains(".simpl")) {
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
            TestCasesCountFiles(f, errorCounter);
        } else {
            wrongcount++;
        }
    }

    final private static class VerboseListenerForPositive extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            errorMessage = "";

            errorMessage = msg + "\n";

            underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine);
            positiveFailed.add(errorMessage);

            if (msg.toLowerCase().contains("mismatched input".toLowerCase())) {
                missmatch.add(errorMessage);
            } else if (msg.toLowerCase().contains("no viable alternative at input".toLowerCase())) {
                noVaiable.add(errorMessage);
            } else if (msg.toLowerCase().contains("extraneous input".toLowerCase())) {
                extraneous.add(errorMessage);
            } else if (msg.toLowerCase().contains("missing LETTER".toLowerCase())) {
                missLetter.add(errorMessage);
            }
        }

        protected void underlineError(Recognizer recognizer, Token offendingToken, int line, int charPositionInLine) {
            CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();

            String input = tokens.getTokenSource().getInputStream().toString();
            String[] lines = input.split("\n");
            String errorLine = lines[line - 1];

            errorMessage += errorLine + "\n";

            for (int i = 0; i < charPositionInLine; i++) {
                errorMessage += " ";
            }

            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();

            if (start >= 0 && stop >= 0) {
                for (int i = start; i <= stop; i++) {
                    errorMessage += "^";
                }
            }
        }
    }

    final private static class VerboseListenerForNegative extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        }
    }

    private static void FeedBackProcessing(ArrayList<File> pFiles, ArrayList<File> nFiles, double tcount, double pcount, double ncount, double negative, double negpositive, double wrongfiles) throws Exception {

        if (nFiles.size() > 0 || pFiles.size() > 0) {
            submission.setResults("Unfortunately You Fail!");
        } else {
            submission.setResults("Congratulations you Passed");
        }

        if (pFiles.size() > 0 && pFiles.get(0).getParent().contains("positive")) {
            //System.out.println("Failed From this Directory: "+pFiles.get(0).getParent());
            System.out.print("\nFailed Positive test cases >:");
            mark = mark + "Positive Passed: ";
            ResultsStats(negative, pcount);
            for (File negFile : pFiles) {
            }
        }

        if (nFiles.size() > 0 && nFiles.get(0).getParent().contains("negative")) {

            System.out.print("\nFailed Negative test cases >:");
            mark = mark + " Negative Passed:";
            ResultsStats(negpositive, ncount);
            for (File posfiles : nFiles) {
            }
        }
        testcase.setOutcomes("Failed Testcases");
        submission.setFeedback(mark);

        System.out.println("Please wait while we process your results !");

        //submission = access.RecordSubmission(student, antlr, submission, testcase, failedFiles);

    }

    final private static void ResultsStats(double count, double ccount) {
        double average = 0.0;
        double results = 0.0;
        average = (count / ccount) * 100;
        results = (double) Math.round(average * 100.0) / 100.0;
        mark = mark + results + "%";

        System.out.println(results + " % out of " + ccount + " Files\n");
    }

    final private static void TestCasesCountFiles(File filePath, int errorCounter) {

        if (filePath.getParent().contains("positive")) {
            pFiles.add(filePath);
            poscount++;
            if (errorCounter == 0) {
                positive++;
            } else {
                failedFiles.add(filePath);
                negative++;
            }
        } else if (filePath.getParent().contains("negative")) {
            nFiles.add(filePath);
            negcount++;
            if (errorCounter == 0) {
                failedFiles.add(filePath);
                npositive++;
            } else {
                nnegative++;
            }
        }
    }

    final private static ArrayList<String> methodOne(ArrayList<String> arrayList, ArrayList<String> list) {
        //ArrayList<String> list = new ArrayList();
        if (list.isEmpty()) {
            list.add(arrayList.get(0));
            arrayList.remove(0);
            //System.out.println(list.size()+" & "+arrayList.size());
        }
        if (arrayList.size() > 0) {
            String[] finder = list.get(list.size() - 1).split("\n");
            //System.out.println(finder[0]);
            for (String str : arrayList) {
                String[] word = str.split("\n");
                if (word[0].endsWith(finder[0])) {
                    arrayList.remove(str);
                    return methodOne(arrayList, list);
                } else {
                    list.add(arrayList.get(0));
                    return methodOne(arrayList, list);
                }
            }
        } else {
            return list;
        }
        return list;
    }
}
