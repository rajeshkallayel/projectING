package be.abis.projectING.model;

import java.time.LocalDate;

public class SessionRegistration {
    private Course course;
    private Person instructor;
    private LocalDate sessionRegistrationDate;
    //Each session registration has 1 order which is not filled by default. It can/must be set when sandwich orders are created
    private Order order;

    public SessionRegistration(Course course, Person instructor, LocalDate sessionRegistrationDate) {
        this.course = course;
        this.instructor = instructor;
        this.sessionRegistrationDate = sessionRegistrationDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Person getInstructor() {
        return instructor;
    }

    public void setInstructor(Person instructor) {
        this.instructor = instructor;
    }

    public LocalDate getSessionRegistrationDate() {
        return sessionRegistrationDate;
    }

    public void setSessionRegistrationDate(LocalDate sessionRegistrationDate) {
        this.sessionRegistrationDate = sessionRegistrationDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
