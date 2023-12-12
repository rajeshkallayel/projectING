package be.abis.projectING.test;

import be.abis.projectING.exception.CourseAlreadyExistsException;
import be.abis.projectING.model.Course;
import be.abis.projectING.repository.CoursesRegistrationsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CoursesRegistrationsRepositoryTest {
    private CoursesRegistrationsRepository coursesRegistrationsRepository;
    @BeforeEach
    void setUp() {
        coursesRegistrationsRepository = new CoursesRegistrationsRepository();
    }

    @Test
    public void testDuplicateCourseIdThrowsException(){
        Course c1 = new Course(2, "Java Fake Course", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 2));
        assertThrows(CourseAlreadyExistsException.class, () -> coursesRegistrationsRepository.addCourseToList(c1));
    }

    @Test
    public void testRegistrationsInCourseCount(){
        assertEquals(6, coursesRegistrationsRepository.getCourseById(1).getSessionRegistrations().size());
    }
}