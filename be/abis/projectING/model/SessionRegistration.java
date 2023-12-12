package be.abis.projectING.model;

import java.time.LocalDate;

public class SessionRegistration {
    private Course course;
    private Person instructor;
    private LocalDate sessionRegistrationDate;
    private Order order;

    public SessionRegistration(Course course, Person instructor, LocalDate sessionRegistrationDate) {
        this.course = course;
        this.instructor = instructor;
        this.sessionRegistrationDate = sessionRegistrationDate;
        this.order = new Order();
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
