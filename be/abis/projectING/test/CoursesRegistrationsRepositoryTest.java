package be.abis.projectING.test;

import be.abis.projectING.exception.CourseAlreadyExistsException;
import be.abis.projectING.model.Course;
import be.abis.projectING.model.Person;
import be.abis.projectING.repository.CoursesRegistrationsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// Tests for the Course & Session Registration repository. Still limited at this point in time.
class CoursesRegistrationsRepositoryTest {
    private CoursesRegistrationsRepository coursesRegistrationsRepository;
    @BeforeEach
    void setUp() {
        coursesRegistrationsRepository = new CoursesRegistrationsRepository();
    }

    // Verify that adding a course with duplicate ID throws custom exception
    @Test
    public void testDuplicateCourseIdThrowsException() throws CourseAlreadyExistsException {
        Course c1 = new Course(6, ".Net Fake Course", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        Course c2 = new Course(6, "Java Fake Course", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 2, 3));
        coursesRegistrationsRepository.addCourseToList(c1);
        assertThrows(CourseAlreadyExistsException.class, () -> coursesRegistrationsRepository.addCourseToList(c2));
    }

    // Test that the automatic course registration creation system generated the right amount of registrations
    @Test
    public void testRegistrationsInCourseCount() throws CourseAlreadyExistsException {
        Course c1 = new Course(6, ".Net Fake Course", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        coursesRegistrationsRepository.addCourseToList(c1);
        Person p1 = new Person();
        coursesRegistrationsRepository.generateRegistrationsForCourse(coursesRegistrationsRepository.getCourseById(6), p1);
        assertEquals(3, coursesRegistrationsRepository.getCourseById(6).getSessionRegistrations().size());
    }
}