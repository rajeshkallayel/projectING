package test;

import model.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    @Test
    public void testCourseNames() {
        // Check if the course names are correctly defined
        assertEquals("Java Beginner", Course.JAVA_BEGINNER.getName());
        assertEquals("Java Intermediate", Course.JAVA_INTERMEDIATE.getName());
        assertEquals("Java Advanced", Course.JAVA_ADVANCED.getName());
        assertEquals("Python", Course.PYTHON.getName());
        assertEquals("UML", Course.UML.getName());
    }

    @Test
    public void testCourseEquality() {
        // Check if the course objects are correctly equal to the predefined ones
        assertEquals(Course.JAVA_BEGINNER, new Course("Java Beginner"));
        assertEquals(Course.JAVA_INTERMEDIATE, new Course("Java Intermediate"));
        assertEquals(Course.JAVA_ADVANCED, new Course("Java Advanced"));
        assertEquals(Course.PYTHON, new Course("Python"));
        assertEquals(Course.UML, new Course("UML"));
    }
}
