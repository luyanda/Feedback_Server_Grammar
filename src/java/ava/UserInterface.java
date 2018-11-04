package ava;

import java.io.File;
import java.util.ArrayList;
public interface UserInterface{
	public User UserLogin(User user_)throws Exception;
	public ArrayList<ANTLR> ProjectList(Student student)throws Exception;
	public String RecordSubmission(Student student, ANTLR antlr, Submissions submissions, Testcase testcase, ArrayList<File> faileFiles) throws Exception;//recordsubmission
	public boolean UpdateViewedTestCase(Submissions submissions, ANTLR antlr, Testcase testcase) throws Exception;//record false test cases
	public boolean insertBulkErrorMessages(Submissions submissions, ArrayList<String> arrayList, String type)throws Exception;
	public boolean updateErrorMessages(Submissions submissions, String message, String type)throws Exception;
	public ArrayList<Testcase> TestCaseList()throws  Exception;
}
