package ava;

import java.util.Objects;

public class ANTLR extends Project {
    private String directory;
    private String toolName;

    public ANTLR() {
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ANTLR antlr = (ANTLR) o;
        return Objects.equals(directory, antlr.directory) &&
                Objects.equals(toolName, antlr.toolName);
    }

    public int hashCode() {

        return Objects.hash(super.hashCode(), directory, toolName);
    }
}
