package model;

public class Person {
    private String name;
    private String role;
    private Course course;

    // Use the constructor for the Persontest without the course
    public Person(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Person(String name, String role, Course course) {
        this.name = name;
        this.role = role;
        this.course = course;
    }


    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Course getCourse() {
        return course;
    }
}

