package learning.tree.libraryApp.domain;

public class Student {
    String name;
    Long   id;
    String major;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "Name = " + name + " Id = " + Long.toString(id) + " Major = " + major;
    }
}
