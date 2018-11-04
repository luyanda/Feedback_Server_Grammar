/*//package POJO;

import java.util.Objects;

public class Submissions {
    private int id;
    private String studentNo;
    private String projectName;
    private String date;
    private String results;
    private String feedback;

    public Submissions() {
    }

    public Submissions(int id, String studentNo, String projectName, String date, String results, String feedback) {
        this.id = id;
        this.studentNo = studentNo;
        this.projectName = projectName;
        this.date = date;
        this.results = results;
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submissions that = (Submissions) o;
        return id == that.id &&
                Objects.equals(studentNo, that.studentNo) &&
                Objects.equals(projectName, that.projectName) &&
                Objects.equals(date, that.date) &&
                Objects.equals(results, that.results) &&
                Objects.equals(feedback, that.feedback);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, studentNo, projectName, date, results, feedback);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
*/