package ava;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javafx.scene.SubScene;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import static javafx.scene.input.KeyCode.T;

public class DbAccess implements UserInterface, instructorInterface {

    private DataSource getDataSource() throws Exception {
        InitialContext cont = new InitialContext();
        if (cont == null) {
            throw new Exception("Bhuti your DataSource is on subscriber....");
        }
        DataSource source = (DataSource) cont.lookup("java:/comp/env/jdbc/careerappBC");
        if (source == null) {
            throw new Exception("your source not available");
        }
        return source;
    }

    private DataSource getDataSourceFirst() throws Exception {
        InitialContext cont = new InitialContext();
        if (cont == null) {
            throw new Exception("DataSource is not available");
        }
        Properties properties = new Properties();
        FileInputStream fis = null;
        MysqlDataSource ds = null;
        fis = new FileInputStream("db.properties");
        properties.load(fis);

        ds = new MysqlConnectionPoolDataSource();
        ds.setURL(properties.getProperty("mysql.url"));
        ds.setUser(properties.getProperty("mysql.username"));
        ds.setPassword(properties.getProperty("mysql.password"));

        return ds;
    }

    private Connection getConnection() throws SQLException, Exception {
        Connection conn = getDataSource().getConnection();
        return conn;
    }

    public DbAccess() {
    }

    private void closeDBResources(ResultSet rs, PreparedStatement st, Connection con, CallableStatement cs) throws SQLException {
        if (rs != null) {
            rs.close();
            rs = null;
        }
        if (st != null) {
            st.close();
            st = null;
        }
        if (con != null) {
            con.close();
            con = null;
        }
        if (cs != null) {
            cs.close();
            cs = null;
        }
    }

    @Override
    public ArrayList<Testcase> getTestCases() throws Exception {
        ArrayList<Testcase> list = new ArrayList<>();
        Testcase testcase = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String query = "{call getTestCases()}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next()) {
                testcase = new Testcase();

                testcase.setId(rs.getInt(1));
                testcase.setName(rs.getString(2));
                testcase.setOutcomes(rs.getString(3));

                list.add(testcase);
            }
        } finally {
            closeDBResources(rs, null, conn, cs);
        }
        return list;
    }

    @Override
    public ArrayList<Student> studentList() throws Exception {
        ArrayList<Student> list = new ArrayList();
        Student student = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String query = "{call studentList()}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt(1));
                student.setUserId(rs.getInt(2));
                student.setName(rs.getString(3));
                student.setSurname(rs.getString(4));
                student.setType(rs.getString(5));
                list.add(student);
            }
        } finally {
            closeDBResources(rs, null, conn, cs);
        }
        return list;
    }

    @Override
    public ArrayList<ANTLR> ProjectsList() throws Exception {
        ArrayList<ANTLR> list = new ArrayList();
        ANTLR project = null;
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String query = "{call ProjectsList()}";
        try {
            con = getConnection();
            cs = con.prepareCall(query);

            cs.executeQuery();

            rs = cs.getResultSet();
            while (rs.next()) {
                project = new ANTLR();

                project.setId(rs.getInt(1));
                project.setName(rs.getString(2));
                project.setOpen(rs.getString(3));
                project.setClose(rs.getString(4));
                project.setToolName(rs.getString(5));

                list.add(project);
            }
        } finally {
            closeDBResources(rs, null, con, cs);
        }
        return list;
    }

    @Override
    public ArrayList<Submissions> submisionsList() throws Exception {
        ArrayList<Submissions> list = new ArrayList();
        Submissions submissions = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String query = "{call SubmissionsList()}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.executeQuery();

            rs = cs.getResultSet();
            while (rs.next()) {
                submissions = new Submissions();

                submissions.setId(rs.getInt(1));
                submissions.setStudentNo(rs.getInt(2));
                submissions.setProjectName(rs.getString(3));
                submissions.setFeedback(rs.getString(4));
                submissions.setResults(rs.getString(5));
                submissions.setDate(rs.getString(6));

                list.add(submissions);
            }
        } finally {
            closeDBResources(rs, null, conn, cs);
        }
        return list;
    }

    @Override
    public boolean insertBulkErrorMessages(Submissions submissions, ArrayList<String> arrayList, String type) throws Exception {
        boolean results = false;
        Connection conn = null;
        CallableStatement cs = null;
        String query = "{call insertBulkErrorMessages(?,?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            for (String message : arrayList) {
                cs.setInt(1, submissions.getId());
                cs.setString(2, message);
                cs.setString(3, type);
                int status = cs.executeUpdate();
                if (status > 0) {
                    results = true;
                }
            }
        } finally {
            closeDBResources(null, null, conn, cs);
        }
        return results;
    }

    @Override
    public boolean updateErrorMessages(Submissions submissions, String message, String type) throws Exception {
        boolean results = false;
        Connection conn = null;
        CallableStatement cs = null;
        String query = "{call updatePositive_ErrorMessages(?,?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setInt(1, submissions.getId());
            cs.setString(2, message);
            cs.setString(3, type);
            int status = cs.executeUpdate();
            if (status > 0) {
                results = true;
            }
        } finally {
            closeDBResources(null, null, conn, cs);
        }
        return results;
    }

    @Override
    public boolean editProject(ANTLR antlr) throws Exception {
        boolean results = false;
        Connection conn = null;
        CallableStatement cs = null;
        String query = "{call editProject(?,?,?,?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setInt(1, antlr.getId());
            cs.setString(2, antlr.getName());
            cs.setString(3, antlr.getOpen());
            cs.setString(4, antlr.getClose());
            cs.setString(5, antlr.getToolName());

            int status = cs.executeUpdate();
            if (status > 0) {
                results = true;
            }
        } finally {
            closeDBResources(null, null, conn, cs);
        }
        return results;
    }

    @Override
    public boolean insertProject(ANTLR antlr) throws Exception {
        boolean results = false;
        CallableStatement cs = null;
        Connection conn = null;
        String query = "{call insertProject(?,?,?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setString(1, antlr.getName());
            cs.setString(2, antlr.getOpen());
            cs.setString(3, antlr.getClose());
            cs.setString(4, antlr.getToolName());

            int status = cs.executeUpdate();
            if (status > 0) {
                results = true;
            }
        } finally {
            closeDBResources(null, null, conn, cs);
        }
        return results;
    }

    @Override
    public boolean addStudent(Student student) throws Exception {
        boolean results = false;
        Connection conn = null;
        CallableStatement cs = null;
        String query = "{call addStudent(?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setInt(1, student.getUserId());
            cs.setString(2, student.getPassword());

            int status = cs.executeUpdate();
            if (status > 0) {
                results = true;
            }
        } finally {
            closeDBResources(null, null, conn, cs);
        }
        return results;
    }

    @Override
    public boolean assignProject(Student student, ANTLR antlr) throws Exception {
        boolean results = false;
        Connection conn = null;
        CallableStatement cs = null;
        String query = "{call assignProject(?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setInt(1, student.getUserId());
            cs.setInt(2, antlr.getId());
            //cs.executeUpdate();
            int status = cs.executeUpdate();
            if (status > 0) {
                results = true;
            }
        } finally {
            closeDBResources(null, null, conn, cs);
        }
        return results;
    }

    public Submissions GetSubmissionId(User student, ANTLR antlr, String trace) throws Exception {
        Submissions submissions = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call mydb.GetSubmissionId(?,?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(sql);

            cs.setInt(1, student.getUserId());
            cs.setInt(2, antlr.getId());
            cs.setString(3, trace);

            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next()) {
                submissions = new Submissions();
                submissions.setId(rs.getInt(1));
            }
        } finally {
            closeDBResources(rs, null, conn, cs);
        }
        return submissions;
    }

    public ANTLR ProjectListByName(String word) throws SQLException, Exception {
        ANTLR antlrList = new ANTLR();
        ANTLR antlr = null;//ew Project();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        String query = "{call ProjectListByWord(?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setString(1, word);

            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next()) {
                antlr = new ANTLR();
                antlr.setId(1);
            }
        } catch (SQLException sql) {
            System.out.println(sql.getStackTrace());
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return antlrList;
    }

    @Override
    public boolean UpdateViewedTestCase(Submissions submissions, ANTLR antlr, Testcase testcase) throws Exception {
        boolean result = false;
        Connection conn = null;
        CallableStatement cs = null;

        String query = "{call UpdateViewedTestCases(?,?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setString(1, testcase.getName());
            cs.setInt(2, submissions.getId());
            cs.setInt(3, antlr.getId());

            int status = cs.executeUpdate();
            if (status > 0) {
                result = true;
            }
        } finally {
            closeDBResources(null, null, conn, cs);
        }
        return result;
    }

    @Override
    public User UserLogin(User user_) throws Exception {//public <T> T studentLogin(<>)
        User user = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        String query = "{call Login(?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setInt(1, user_.getUserId());
            cs.setString(2, user_.getPassword());

            cs.executeQuery();
            rs = cs.getResultSet();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setUserId(rs.getInt(2));
                user.setName(rs.getString(3));
                user.setType(rs.getString(4));
            }
        } catch (SQLException sql) {
            System.out.println(sql.getStackTrace());
        } finally {
            closeDBResources(rs, null, conn, cs);
        }
        return user;
    }//*/

    @Override
    public ArrayList<ANTLR> ProjectList(Student student) throws Exception {//public <T> T studentLogin(<>)
        ArrayList<ANTLR> antlrList = new ArrayList<>();
        ANTLR antlr = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        String query = "{call GetProjectList(?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setInt(1, student.getUserId());
            //cs.setString(2, student.getPassword());

            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next()) {
                antlr = new ANTLR();
                antlr.setId(rs.getInt(1));
                antlr.setName(rs.getString(2));
                antlr.setClose(rs.getString(3));
                antlr.setToolName(rs.getString(4));

                antlrList.add(antlr);
            }
        } catch (SQLException sql) {
            System.out.println(sql.getStackTrace());
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return antlrList;
    }

    @Override
    public ArrayList<Testcase> TestCaseList() throws Exception {
        ArrayList<Testcase> arrayList = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Testcase testcase = null;

        String query = "{call GetTestNames()}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next()) {
                testcase = new Testcase();

                testcase.setName(rs.getString(3));

                arrayList.add(testcase);
            }
        } finally {
            closeDBResources(rs, null, conn, cs);
        }
        return arrayList;
    }

    public String RecordFileRead(Project project, Student student, String file) throws Exception {
        return null;
    }

    public String ClueFileRead(Project project, Student student, String file) throws Exception {
        return null;
    }

    public boolean RecordProject(Project project) throws Exception {
        return false;
    }

    public Testcase GetFailedTestcase(Submissions submissions, ANTLR antlr) throws Exception {
        Testcase testcase = null;
        CallableStatement cs = null;
        Connection conn = null;
        ResultSet rs = null;
        String query = "{call GetFailedTetcases(?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setInt(1, submissions.getId());
            cs.setInt(2, antlr.getId());

            cs.executeQuery();
            rs = cs.getResultSet();
            while (rs.next()) {
                testcase = new Testcase();
                testcase.setName(rs.getString(1));
            }
        } finally {
            closeDBResources(null, null, conn, cs);
        }
        return testcase;
    }

    public boolean RecordProject(ANTLR antlr) throws Exception {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into Project(name,open,close,directory,toolName) values(?,?,?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, antlr.getName());
            ps.setString(2, antlr.getOpen());
            ps.setString(3, antlr.getClose());
            ps.setString(4, antlr.getDirectory());
            ps.setString(5, antlr.getToolName());

            int status = ps.executeUpdate();
            if (status > 0) {
                result = true;
            } else {
                result = false;
            }
        } finally {
            closeDBResources(null, ps, conn, null);
        }
        return result;
    }//*/

    private static String RandomString() {
        String rand = "";

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 13;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        //	System.out.println(generatedString);
        rand = generatedString;
        return rand;
    }

    public boolean RecordPositiveMessages(ANTLR antlr, ArrayList<File> faileFiles, String trace) throws Exception {
        boolean result=true;
        Connection conn = null;
        //PreparedStatement ps = null;
        CallableStatement css = null;
        //PreparedStatement st = null;

        String query_p = "{call FailedTestcases(?,?,?)}";
        try {
            //conn.setAutoCommit(false);
            conn = getConnection();
            css = conn.prepareCall(query_p);

            if (faileFiles.size() == 0) {
                System.out.println("No test cases to record");
            }
            for (File f : faileFiles) {
                //css = conn.prepareCall(query_p);

                css.setInt(1, antlr.getId());
                css.setString(2, f.getName());
                css.setString(3, trace);

                css.executeUpdate();
                
                //		conn.commit();
            }
            //submissions1 = GetSubmissionId(student,antlr,trace);
        } finally {
            closeDBResources(null, null, conn, css);
        }
        return result;
    }

    @Override
    public String RecordSubmission(Student student, ANTLR antlr, Submissions submissions, Testcase testcase, ArrayList<File> faileFiles) throws Exception {
        Submissions submissions1 = new Submissions();
        boolean result;
        Connection conn = null;
        //PreparedStatement ps = null;
        CallableStatement cs = null;
        //PreparedStatement st = null;

        String trace = RandomString();

        String query_c = "{call Submissions(?,?,?,?,?)}";
        //String query_p = "{call FailedTestcases(?,?,?)}";
        try {
            //conn.setAutoCommit(false);
            conn = getConnection();
            cs = conn.prepareCall(query_c);
  //          css = conn.prepareCall(query_p);

            cs.setInt(1, student.getUserId());
            cs.setInt(2, antlr.getId());
            cs.setString(3, submissions.getFeedback());
            cs.setString(4, submissions.getResults());
            cs.setString(5, trace);

            int status = cs.executeUpdate();

            result = status > 0;
//            if (result) {
//                //css = conn.prepareCall(query_p);
//
//                if (faileFiles.size() == 0) {
//                    System.out.println("No test cases to record");
//                }
//
//                for (File f : faileFiles) {
//                    //css = conn.prepareCall(query_p);
//
//                    css.setInt(1, antlr.getId());
//                    css.setString(2, f.getName());
//                    css.setString(3, trace);
//
//                    css.executeUpdate();
//                    //		conn.commit();
//                }
//
//                result = true;
//            } else {
//                result = false;
//            }
            //submissions1 = GetSubmissionId(student,antlr,trace);
        } finally {
            closeDBResources(null, null, conn, cs);
            //closeDBResources(null, null, conn, css);
            //conn.setAutoCommit(true);
        }
        return trace;
    }

    public String RecordFileRead(ANTLR antlr, Student student, String file) throws Exception {
        int BUFFER_SIZE = 4096;
        String fileName = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String query = "{call TestcaseCall(?,?)}";
        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setString(1, antlr.getName());
            cs.setInt(2, student.getUserId());

            cs.executeQuery();
            rs = cs.getResultSet();

            if (rs.next()) {
                Blob blob = rs.getBlob(1);
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(file);

                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return file;
    }

    public boolean FileRecordd(int id, String name, String file) throws Exception {
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "insert into testtable(id,name,file) values(?,?,?)";
        try {
            con = getConnection();
            ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            InputStream inputStream = new FileInputStream(new File(file));
            ps.setBlob(3, inputStream);

            int status = ps.executeUpdate();
            if (status > 0) {
                result = true;
                System.out.println("Recorded YEPi!");
            }
        } finally {
            con.close();
            con = null;
            ps.close();
            ps = null;
        }
        return result;
    }

    public boolean RecordUser(Student student) throws Exception {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into Users(student_no,name,last_name) values(?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, student.getUserId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSurname());

            int status = ps.executeUpdate();
            if (status > 0) {
                result = true;
            } else {
                result = false;
            }
        } finally {
            closeDBResources(null, ps, conn, null);
        }
        return result;
    }

    public boolean InsertFileNames(String filename, String outcome, String project) throws SQLException, Exception {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;
        CallableStatement cs = null;
        PreparedStatement st = null;

        String query = "{call InsertTestFileName(?,?,?)}";

        try {
            conn = getConnection();
            cs = conn.prepareCall(query);

            cs.setString(1, filename);
            cs.setString(2, outcome);
            cs.setString(3, project);

            int status = cs.executeUpdate();
            result = status > 0;
        } finally {
            closeDBResources(null, ps, conn, cs);
        }
        return result;
    }

  /*  public static void main(String[] args) throws ClassNotFoundException, Exception {
        //creating O// bjects
        DbAccess d = new DbAccess();
        Student student = new Student();//"212121","Max","Doug");
        ANTLR antlr = new ANTLR();
        Submissions submissions = new Submissions();
        Testcase testcase = new Testcase();
        User user = new User();
        User newUser = new User();
        ArrayList<Testcase> arrayList = new ArrayList();

        //
        student.setUserId(313131);
        student.setPassword("one");

        user.setUserId(131313);
        user.setPassword("one");

        testcase.setOutcomes("Failed Test cases");
        testcase.setId(1067159);
        testcase.setName("test_106013.simpl");

        antlr.setId(5);
        antlr.setName("cs144 Project_005");
        antlr.setOpen("01/01/2019");
        antlr.setClose("09/01/2020");
        antlr.setToolName("Antlr v4");

        //boolean results = d.editProject(antlr);
        //newUser = d.UserLogin(user);
        submissions.setDate("20/12/2018");
        submissions.setResults("Pass!");
        submissions.setFeedback("Viewing failed Test is under process");
        submissions.setId(39);

        ArrayList<Student> arrayList1 = new ArrayList<>();
        ArrayList<ANTLR> arrayList2 = new ArrayList<>();
        ArrayList<Submissions> arrayList3 = new ArrayList<>();

        arrayList1 = d.studentList();
        arrayList2 = d.ProjectsList();
        arrayList3 = d.submisionsList();

        System.out.println("");
        //for (Student student1 : arrayList1){
        //   System.out.println("id:"+student1.getId()+"\tStudent No:"+student1.getUserId()+"\t");
        //}
        for (Project project : arrayList2) {
            System.out.println("id:" + project.getName() + "\tClose Date: " + project.getClose() + "\t");
        }

        for (Submissions submissions1 : arrayList3) {
            System.out.println("id:" + submissions1.getFeedback() + "\t");
        }
        //boolean results = d.insertErrorMessages(submissions, "Error message Test","missmatched","Randomly");

        //boolean r = d.RecordSubmission(student, project, submissions,testcase,"/home/epsilon/Documents/import java1.");
        //boolean r = d.RecordProject(project);
        //boolean r = d.FileRecordd(2, "sisi", "/home/epsilon/Documents/import java.");
        //boolean r = d.RecordFileRead( project,student,"/home/epsilon/Documents/import java2.");
        //String ra = d.RandomString();
        //System.out.println("recorded :"+r);
        //arrayList = d.TestCaseList();
        //boolean r = d.UpdateViewedTestCase(submissions,project,testcase);
        //testcase = d.GetFailedTestcase(submissions, antlr);
        //for (Testcase testcase1 : arrayList){
        //	System.out.println(testcase1.getName());
        //}
        //System.out.println("User id:"+newUser.getId()+" user Number: "+newUser.getUserId()+" type: "+newUser.getType());
        //System.out.println("Student added: ? "+results);
        System.out.println("Done!");

    }//*/
}
