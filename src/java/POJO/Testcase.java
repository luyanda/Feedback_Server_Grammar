/*/package POJO;

import java.util.Objects;

public class Testcase {
    private int id;
    private String name;
    private String outcomes;
    private String projectName;

    public Testcase() {
    }

    public Testcase(int id, String name, String outcomes, String projectName) {
        this.id = id;
        this.name = name;
        this.outcomes = outcomes;
        this.projectName = projectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Testcase testcase = (Testcase) o;
        return id == testcase.id &&
                Objects.equals(name, testcase.name) &&
                Objects.equals(outcomes, testcase.outcomes) &&
                Objects.equals(projectName, testcase.projectName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, outcomes, projectName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(String outcomes) {
        this.outcomes = outcomes;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
*/