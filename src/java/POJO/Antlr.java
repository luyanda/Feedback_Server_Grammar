/*package POJO;

import ava.Project;

import java.util.Objects;

public class Antlr extends Project {
    private String testcaseDirectory;
    private String directory;
    private String toolName;

    public String getTestcaseDirectory() {
        return testcaseDirectory;
    }

    public void setTestcaseDirectory(String testcaseDirectory) {
        this.testcaseDirectory = testcaseDirectory;
    }

    @Override
    public String getDirectory() {
        return directory;
    }

    @Override
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    @Override
    public String getToolName() {
        return toolName;
    }

    @Override
    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Antlr antlr = (Antlr) o;
        return Objects.equals(testcaseDirectory, antlr.testcaseDirectory) &&
                Objects.equals(directory, antlr.directory) &&
                Objects.equals(toolName, antlr.toolName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), testcaseDirectory, directory, toolName);
    }
}
*/