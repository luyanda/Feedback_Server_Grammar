
/*/import ava.User;

import ava.User;

import java.util.Objects;

public class Student extends User {
    private String surname;
    private String classYear;

    public Student() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClassYear() {
        return classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(surname, student.surname) &&
                Objects.equals(classYear, student.classYear);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), surname, classYear);
    }
}*/