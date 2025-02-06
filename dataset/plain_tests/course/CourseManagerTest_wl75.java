import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class CourseManagerTest_wl75 {
    private CourseManager courseManager;
    private Course course;
    private Student student;

    @BeforeEach
    void setUp() {
        courseManager = new CourseManager();
        course = new Course("CS101", "Introduction to Computer Science", 2);
        student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addCourse(course);
        courseManager.addStudent(student);
    }

    @Test
    void testEnrollStudentInCourse_Success() {
        assertTrue(student.enrollCourse("CS101", 3));
        assertEquals(7, student.getCredits());
        assertEquals(1, course.getEnrollStudent().size());
        assertEquals(3, course.getCredits().get(0));
    }

    @Test
    void testEnrollStudentInCourse_Failure_ExceedingCapacity() {
        Student student2 = new Student("S002", "student2@example.com", "Jane Doe", 10);
        courseManager.addStudent(student2);
        student.enrollCourse("CS101", 3);
        student2.enrollCourse("CS101", 3);
        assertFalse(student2.enrollCourse("CS101", 3)); // Should fail due to capacity
    }

    @Test
    void testEnrollStudentInCourse_Failure_InsufficientCredits() {
        assertFalse(student.enrollCourse("CS101", 11)); // Not enough credits
    }

    @Test
    void testModifyStudentEnrollmentCredits_Success() {
        student.enrollCourse("CS101", 3);
        assertTrue(student.modifyEnrollCredit("CS101", 2));
        assertEquals(8, student.getCredits());
        assertEquals(2, course.getCredits().get(0));
    }

    @Test
    void testModifyStudentEnrollmentCredits_Failure_NonExistentCourse() {
        assertFalse(student.modifyEnrollCredit("CS999", 2)); // Course does not exist
    }

    //@Test
    void testModifyStudentEnrollmentCredits_Failure_InsufficientCredits() {
        student.enrollCourse("CS101", 3);
        
        assertFalse(student.modifyEnrollCredit("CS101", 4)); // Not enough credits after modification
    }

    @Test
    void testDropStudentEnrollmentCourse_Success() {
        student.enrollCourse("CS101", 3);
        assertTrue(student.dropEnrollCourse("CS101"));
        assertEquals(10, student.getCredits()); // Credits should be back to original
        assertEquals(0, course.getEnrollStudent().size()); // No students enrolled
    }

    @Test
    void testDropStudentEnrollmentCourse_Failure_NonExistentCourse() {
        assertFalse(student.dropEnrollCourse("CS999")); // Course does not exist
    }

    @Test
    void testFinalizeEnrollments_Success() {
        student.enrollCourse("CS101", 3);
        courseManager.finalizeEnrollments();
        assertEquals(1, course.getSuccessStudents().size());
        assertEquals(student, course.getSuccessStudents().get(0));
    }

    @Test
    void testGetEnrolledCoursesWithCredits() {
        student.enrollCourse("CS101", 3);
        ArrayList<String> coursesWithCredits = student.getCoursesWithScores();
        assertEquals(1, coursesWithCredits.size());
        assertEquals("CS101: 3", coursesWithCredits.get(0));
    }
}
