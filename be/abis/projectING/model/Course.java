package model;
import java.util.Objects;

public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static final Course JAVA_BEGINNER = new Course("Java Beginner");
    public static final Course JAVA_INTERMEDIATE = new Course("Java Intermediate");
    public static final Course JAVA_ADVANCED = new Course("Java Advanced");
    public static final Course PYTHON = new Course("Python");
    public static final Course UML = new Course("UML");


}
