package be.abis.projectING.repository;

import be.abis.projectING.exception.CourseAlreadyExistsException;
import be.abis.projectING.model.Course;
import be.abis.projectING.model.Person;
import be.abis.projectING.model.SessionRegistration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CoursesRegistrationsRepository {
    private List<Course> courseList;
    public CoursesRegistrationsRepository(){
        courseList = new ArrayList<>();
        Person person1 = new Person();
        Course course1 = new Course(1, "Java Advanced", LocalDate.of(2023,10,1),LocalDate.of(2023,10,6));
        generateRegistrationsForCourse(course1, person1);
        try {
            this.addCourseToList(course1);
        } catch (CourseAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        Person person2 = new Person();
        Course course2 = new Course(2, ".NET Basic", LocalDate.of(2024,8,20),LocalDate.of(2024,8,24));
        generateRegistrationsForCourse(course2, person2);
        try {
            this.addCourseToList(course2);
        } catch (CourseAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        Course course3 = new Course(3, "Python", LocalDate.of(2023,8,8),LocalDate.of(2023,8,16));
        generateRegistrationsForCourse(course3, person1);
        try {
            this.addCourseToList(course3);
        } catch (CourseAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        Person person3 = new Person();
        Course course4 = new Course(4, "Javascript", LocalDate.of(2024,11,12),LocalDate.of(2024,11,14));
        generateRegistrationsForCourse(course4, person3);
        try {
            this.addCourseToList(course4);
        } catch (CourseAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    private void generateRegistrationsForCourse(Course c, Person p){
        for(int i = 0; i <= ChronoUnit.DAYS.between(c.getStartDate(), c.getEndDate()); i++){
            c.addRegistrationToCourse(new SessionRegistration(c, p, c.getStartDate().plusDays(i)));
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public Course getCourseById(int id){
        for(Course c:courseList){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getAllCoursesForYear(int year){
        return courseList.stream()
                .filter(c -> c.getStartDate().getYear() == year)
                .toList();
    }

    public List<SessionRegistration> getSessionRegistrationsForCourse(int id){
        return courseList.stream()
                .filter(c -> c.getId() == id)
                .toList()
                .stream().findFirst()
                .get().getSessionRegistrations();
    }

    public void addCourseToList(Course c) throws CourseAlreadyExistsException {
        for(Course entry:this.courseList){
            if (entry.getId() == c.getId()){
                throw new CourseAlreadyExistsException("Course with ID " + c.getId() + " already exists.");
            }
        }
        this.courseList.add(c);
    }
}
