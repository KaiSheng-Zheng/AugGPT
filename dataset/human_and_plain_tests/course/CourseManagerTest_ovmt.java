import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class CourseManagerTest_ovmt {
    private CourseManager courseManager;
    private Course course;
    private Student student;

    @BeforeEach
    void setUp() {
        courseManager = new CourseManager();
        course = new Course("CS101", "Computer Science Basics", 30);
        student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addCourse(course);
        courseManager.addStudent(student);
    }

    @Test
    void testEnrollStudentInCourse_Success() {
        assertTrue(student.enrollCourse("CS101", 3));
        assertEquals(7, student.getCredits());
        assertEquals(1, course.getEnrollStudent().size());
        assertEquals(1, course.getCredits().size());
        assertEquals(3, course.getCredits().get(0));
    }

    @Test
    void testEnrollStudentInCourse_Failure_CourseNotOpen() {
        courseManager.setIfOpen(false);
        assertFalse(student.enrollCourse("CS101", 3));
    }

    @Test
    void testEnrollStudentInCourse_Failure_CourseNotExists() {
        assertFalse(student.enrollCourse("MATH101", 3));
    }

    @Test
    void testEnrollStudentInCourse_Failure_InsufficientCredits() {
        assertFalse(student.enrollCourse("CS101", 11));
    }

    @Test
    void testModifyStudentEnrollmentCredits_Success() {
        student.enrollCourse("CS101", 3);
        assertTrue(student.modifyEnrollCredit("CS101", 2));
        assertEquals(8, student.getCredits());
        assertEquals(2, course.getCredits().get(0));
    }

    @Test
    void testModifyStudentEnrollmentCredits_Failure_CourseNotExists() {
        assertFalse(student.modifyEnrollCredit("MATH101", 2));
    }

    //@Test
    void testModifyStudentEnrollmentCredits_Failure_InsufficientCredits() {
        student.enrollCourse("CS101", 3);
        
        assertFalse(student.modifyEnrollCredit("CS101", 5));
    }

    @Test
    void testDropStudentEnrollmentCourse_Success() {
        student.enrollCourse("CS101", 3);
        assertTrue(student.dropEnrollCourse("CS101"));
        assertEquals(10, student.getCredits());
        assertTrue(course.getEnrollStudent().isEmpty());
    }

    @Test
    void testDropStudentEnrollmentCourse_Failure_CourseNotExists() {
        assertFalse(student.dropEnrollCourse("MATH101"));
    }

    @Test
    void testGetEnrolledCoursesWithCredits() {
        student.enrollCourse("CS101", 3);
        ArrayList<String> coursesWithCredits = student.getCoursesWithScores();
        assertEquals(1, coursesWithCredits.size());
        assertEquals("CS101: 3", coursesWithCredits.get(0));
    }

    @Test
    void testFinalizeEnrollments_Success() {
        course.setMaxCapacity(1); // Set max capacity to 1 for testing
        student.enrollCourse("CS101", 3);
        courseManager.finalizeEnrollments();
        assertEquals(1, course.getSuccessStudents().size());
        assertEquals(student, course.getSuccessStudents().get(0));
    }

    //@Test
    void testFinalizeEnrollments_NoSuccessStudents() {
        course.setMaxCapacity(1); // Set max capacity to 1 for testing
        student.enrollCourse("CS101", 2); // Enroll with insufficient credits
        courseManager.finalizeEnrollments();
        assertTrue(course.getSuccessStudents().isEmpty());
    }
}
