/*/package ava;

import java.util.Date;
import java.util.Objects;

public abstract class Project {
    private int id;
    private String name;
    private String open;
    private String close;

    public Project() {
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

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                Objects.equals(name, project.name) &&
                Objects.equals(open, project.open) &&
                Objects.equals(close, project.close);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, open, close);
    }
}
*/