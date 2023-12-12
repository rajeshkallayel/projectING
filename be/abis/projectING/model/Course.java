package be.abis.projectING.model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<SessionRegistration> sessionRegistrations;
    private int id;

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

    public void addRegistrationToCourse(SessionRegistration registration){
        this.sessionRegistrations.add(registration);
    }

    @Override
    public String toString() {
        return String.format("Course title: %s has %d session registrations. The first day is %s%n", this.name, this.getSessionRegistrations().size(), this.startDate);
    }

    public double getTotalPriceForCourse(){
        return this.sessionRegistrations.stream()
                .map(SessionRegistration::getOrder)
                .mapToDouble(Order::calculateOrderPrice)
                .sum();
    }
}
