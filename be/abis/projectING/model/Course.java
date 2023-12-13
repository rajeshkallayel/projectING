package be.abis.projectING.model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    // Each course has a list of session registrations (1 per day of the course)
    private List<SessionRegistration> sessionRegistrations;

    // Default constructor initializes session registrations list but does not yet populate it
    // They should be populated elsewhere since the instructor can vary between session registrations
    public Course(int id, String name, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sessionRegistrations = new ArrayList<>();
    }

    public List<SessionRegistration> getSessionRegistrations() {
        return sessionRegistrations;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Method to add a session registration to the course. Could contain logic to verify no duplicates in a further version
    public void addRegistrationToCourse(SessionRegistration registration){
        this.sessionRegistrations.add(registration);
    }

    @Override
    public String toString() {
        return String.format("Course title: %s has %d session registrations. The first day is %s%n", this.name, this.getSessionRegistrations().size(), this.startDate);
    }

    // Method to generate the total sum of the prices for sandwich orders of each individual session registration
    public double getTotalPriceForCourse(){
        return this.sessionRegistrations.stream()
                .map(SessionRegistration::getOrder)
                .mapToDouble(Order::calculateOrderPrice)
                .sum();
    }
}
