package ava;

import org.antlr.v4.runtime.*;

import java.nio.file.*;

import java.io.*;
import java.util.*;

public class Operations{
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
    };

    public Operations() throws Exception {
    }
/* collecting file names from the directories */
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
	    //FileWriter fileWriter = new FileWriter(fileName);
	    //bufferedWriter = new BufferedWriter(fileWriter);

        if(nFiles.size()>0 || pFiles.size()>0)
            subObj.setResults("Unfortunately You Fail!");
        else
            subObj.setResults("Congratulations you Passed");

	    //System.out.println("\n\nNumber of wrong files found in Root Directory :"+wrongfiles+"\n\n");
        if (pFiles.size()>0 && pFiles.get(0).getParent().contains("positive")){
            //System.out.println("Failed From this Directory: "+pFiles.get(0).getParent());
            System.out.print("\nFailed Positive test cases >:");
            mark=mark+"Positive Passed: ";
            ResultsStats(negative,pcount);
            for(File negFile : pFiles){
		    //    bufferedWriter.write(negFile.getName());
		    //    bufferedWriter.newLine();
		    }
        }

        if (nFiles.size()>0 && nFiles.get(0).getParent().contains("negative")) {

            //System.out.println("\n\nFailed from this Directory>>"+nFiles.get(0).getParent());
            System.out.print("\nFailed Negative test cases >:");
            mark =mark+" Negative Passed:";
            ResultsStats(negpositive,ncount);
            for (File posfiles : nFiles){
            //    bufferedWriter.write(posfiles.getName());
		    //    bufferedWriter.newLine();
		    }
        }
        //bufferedClueWriter.close();clueWriter.close();
        //bufferedWriter.close(); fileWriter.close();
        //sObj.setStudent_no(studentNumber);
        //pObj.setName(projectName);
        tObj.setOutcomes("Failed Testcases");
        subObj.setFeedback(mark);

        System.out.println("Please wait while we process your results !");

      //  subObj = access.RecordSubmission(sObj,pObj,subObj,tObj,failedFiles);

        File file = new File(fileName);
    }

    final private static void ResultsStats(double count, double ccount){
        double average = 0.0;
        double results = 0.0;
        average = (count/ccount)*100;
        results = (double) Math.round(average*100.0)/100.0;
        mark = mark+results+"%";

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

    public static ArrayList<String> methodOne(ArrayList<String> arrayList, ArrayList<String> list){
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

            for(int i = 0; i<charPositionInLine; i++) errorMessage+=" ";

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

    final private static void TestCaseViewInteractionWithUser()throws Exception {
        ArrayList<File> NegFailedFiles = new ArrayList<>();
        ArrayList<File> PosFailedFiles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWould you like to view failed test cases?" +
                "\nTo exit enter(exit)");
        String answer = scanner.next();
        if(answer.equalsIgnoreCase("exit")){
            System.exit(0);
        }
        if(answer.equalsIgnoreCase("yes")){
            Random random = new Random();
            System.out.println("VIEWING TEST CASES!");// menu heading
            answer = TestcaseMenu();

            while(!answer.equalsIgnoreCase("exit")){

                while(answer.equalsIgnoreCase("r") || answer.equalsIgnoreCase("next")){

                    int n = random.nextInt(failedFiles.size());
                    File file = failedFiles.get(n);
                    tObj.setName(file.getName());
                    access.UpdateViewedTestCase(subObj,pObj,tObj);

                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String currentLine;

                    String path = "";
                    if(file.getParent().contains("negative")){
                        path = "FAIL";
                    }
                    else if(file.getParent().contains("positive")){
                        path = "PASS";
                    }

                    while((currentLine = bufferedReader.readLine()) != null){
                        System.out.println("+-------------------------------------------------------------");
                        System.out.println("| Test Case:\t"+currentLine);
                        System.out.println("+-------------------------------------------------------------");
                    }

                    System.out.print("\nTo get more info about test case, enter(more)" +
                            "\nOr enter(c) to continue" +
                            "\n>>>>>:");
                    answer = scanner.next();
                    if (answer.equalsIgnoreCase("more")){
                        System.out.println("=+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=");
                        System.out.println("| Test case Info: The test case is suppose to "+path+".  |");
                        System.out.println("=+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=");
                    }

                    failedFiles.remove(n);

                    answer = subMenu();
                    if (answer.equalsIgnoreCase("out"))
                        continue;
                    else if (answer.equalsIgnoreCase("exit"))
                        System.exit(0);
                }

                for(File file : failedFiles){
                    if(file.getParent().contains("negative"))
                        NegFailedFiles.add(file);
                    else if(file.getParent().contains("positive"))
                        PosFailedFiles.add(file);
                }

                while(answer.equalsIgnoreCase("p") || answer.equalsIgnoreCase("next")){

                    //System.out.println("Submision id: "+subObj.getId());
                    System.out.println("\nto view false positive test cases enter(1)" +
                            "\nto View DETAILED false positive Error Messages enter(2)");
                    answer = scanner.next();
                    while(answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("next")){
                        if(PosFailedFiles.size()==0) {
                            System.out.println("Ran out of False Positive test cases");
                            answer = "out";
                            continue;
                        }
                        int n = random.nextInt(PosFailedFiles.size());
                        File file = PosFailedFiles.get(n);
                        tObj.setName(file.getName());
                        access.UpdateViewedTestCase(subObj,pObj,tObj);
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        String currentline;

                        while ((currentline = bufferedReader.readLine()) != null){
                            System.out.println("+Positive----------------------------------------------------");
                            System.out.println("| Test Case: \t"+currentline);
                            System.out.println("+------------------------------------------------------------");
                        }

                        failedFiles.remove(PosFailedFiles.get(n));
                        PosFailedFiles.remove(n);

                        if (PosFailedFiles.size()>0)
                            answer = subMenu();
                        else
                            answer = "out";
                        if (answer.equalsIgnoreCase("out"))
                            continue;
                        else if (answer.equalsIgnoreCase("exit"))
                            System.exit(0);
                    }
                    Collections.sort(missmatch);
                    Collections.sort(missLetter);
                    Collections.sort(noVaiable);
                    Collections.sort(extraneous);
                    /*  adding false positive errors to the data base*/
                    if(missmatch.size()>0){
                        access.insertBulkErrorMessages(subObj, missmatch, "Missmatched Input");
                        missmatch = methodOne(missmatch, new ArrayList<String>());
                    }
                    if(missLetter.size()>0){
                        access.insertBulkErrorMessages(subObj, missLetter, "Missing a Letter");
                        missLetter = methodOne(missLetter, new ArrayList<String>());
                    }
                    if(extraneous.size()>0){
                        access.insertBulkErrorMessages(subObj, extraneous, "Extraneous Input");
                        noVaiable = methodOne(noVaiable, new ArrayList<String>());
                    }
                    if(noVaiable.size()>0){
                        access.insertBulkErrorMessages(subObj, noVaiable, "No Viable Alternative");
                        extraneous = methodOne(extraneous, new ArrayList<String>());
                    }


                    while(answer.equalsIgnoreCase("2" )){

                        String errorMessages = "";
                        answer  = "next";
                            while(missmatch.size()>0 && answer.equalsIgnoreCase("next")){
                                errorMessages = missmatch.get(missmatch.size()-1);
                                access.updateErrorMessages(subObj,errorMessages,"Missmatched");
                                display(errorMessages);
                                missmatch.remove(missmatch.size()-1);

                                answer = subSubMenu();
                                if(answer.equalsIgnoreCase("d") || missmatch.size()==0)
                                    continue;
                                else if(answer.equalsIgnoreCase("exit"))
                                    System.exit(0);
                                }
                        answer  = "next";
                            while(noVaiable.size()>0 && answer.equalsIgnoreCase("next")) {
                                errorMessages = noVaiable.get(noVaiable.size()-1);
                                access.updateErrorMessages(subObj,errorMessages,"No Viable Alternative");
                                display(errorMessages);
                                noVaiable.remove(noVaiable.size()-1);

                                answer = subSubMenu();
                                if(noVaiable.size()==0 || answer.equalsIgnoreCase("d"))
                                    continue;
                                else if(answer.equalsIgnoreCase("exit"))
                                        System.exit(0);
                            }
                        answer  = "next";
                            while(extraneous.size()>0 && answer.equalsIgnoreCase("next")) {
                                errorMessages = extraneous.get(extraneous.size()-1);
                                access.updateErrorMessages(subObj,errorMessages,"Extraneous Input");
                                display(errorMessages);
                                extraneous.remove(extraneous.size()-1);

                                answer = subSubMenu();
                                if(extraneous.size()==0 || answer.equalsIgnoreCase("d"))
                                    continue;
                                else if(answer.equalsIgnoreCase("exit"))
                                    System.exit(0);
                            }
                        answer  = "next";
                            while(missLetter.size()>0 && answer.equalsIgnoreCase("next")){
                                errorMessages = missLetter.get(missLetter.size()-1);
                                access.updateErrorMessages(subObj,errorMessages,"Missing a Letter");
                                display(errorMessages);
                                missLetter.remove(missLetter.size()-1);

                                answer = subSubMenu();
                                if(missLetter.size()==0 || answer.equalsIgnoreCase("d"))
                                    continue;
                                else if(answer.equalsIgnoreCase("exit"))
                                    System.exit(0);
                            }
                            if(missmatch.size()==0 && extraneous.size()==0 && noVaiable.size()==0 && missLetter.size()==0){
                                System.out.println("You have seen all false positive Error Messages.");
                            }
                        }
                }
                while(answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("next")){
                    if(NegFailedFiles.size()==0) {
                        System.out.println("Ran out of False Negative test cases");
                        answer = "out";
                        continue;
                    }
                    int n = random.nextInt(NegFailedFiles.size());
                    File file = NegFailedFiles.get(n);
                    tObj.setName(file.getName());
                    access.UpdateViewedTestCase(subObj,pObj,tObj);
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    String currentline;
                    while ((currentline = bufferedReader.readLine()) != null){
                        System.out.println("+Negative------------------------------------------------------+");
                        System.out.println("| Test Case: \t"+currentline);
                        System.out.println("+--------------------------------------------------------------+");
                    }

                    failedFiles.remove(NegFailedFiles.get(n));
                    NegFailedFiles.remove(n);

                    System.out.print("\nPrinting Negative Test case");

                    if(NegFailedFiles.size()>0)
                        answer = subMenu();
                    else
                        answer = "out";
                    if (answer.equalsIgnoreCase("out"))
                        continue;
                    else if (answer.equalsIgnoreCase("exit"))
                        System.exit(0);
                }

                answer = TestcaseMenu();
                if (answer.equalsIgnoreCase("exit"))
                    System.exit(0);
            }

        }
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
        ArrayList<File> filesList = null;
        access = new DbAccess();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // System.out.print("Enter Test cases directory:\t");
        String inputt = "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/simpl-tests/positive";//"/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/test-cases";//"/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/simpl-tests"; // "/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/test-cases";//br.readLine();
        //"/home/epsilon/Documents/Varsity/Stellenbosch Univesity/Year Project/Simple Test cases/simpl-tests/positive/derivation";//
        fileName = inputt;
        System.out.print("\nPlease wait wile we process your Grammar!\t\n");

        String userInput = new String(inputt);
        File directory = new File(userInput);//creating a processable directory file

        if(TestcasePathValidation(directory)){//validating file directory
            filesList = new ArrayList<>();
            ArrayList<Testcase> testFiles = new ArrayList<>();

            testFiles = access.TestCaseList();
            File arr[] = directory.listFiles();
            filesList = Recursive(arr, new ArrayList<File>());

            clueWriter = new FileWriter(clueFile);
            bufferedClueWriter = new BufferedWriter(clueWriter);
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
            System.exit(0);
        }
    }

    private static void UserCalls(User user)throws Exception,IOException{
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.display();

        sObj.setId(user.getId());
        sObj.setUserId(user.getUserId());
        sObj.setName(user.getName());
        sObj.setType(user.getType());

        pObj = userInteraction.chooseProject(sObj);
        if(pObj==null){
            System.out.println("no projects registered under the user");
            System.exit(0);
        }
        userInteraction.upLoadFile();
        FirstMethod();
        if(pFiles.size() >= 0 || nFiles.size() >= 0)
            TestCaseViewInteractionWithUser();
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
            UserCalls(logedUser);
        }
        else if(logedUser.getType().equalsIgnoreCase("instructor")){
            inst.Welcome();
            InstructorCalls();
        }
    }
    public static void main(String []args)throws Exception, IOException{

        Logger();
    }
}
