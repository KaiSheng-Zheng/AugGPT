import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class CourseManagerTest_pa6u {
    private CourseManager courseManager;
    private Course course;
    private Student student;

    @BeforeEach
    public void setUp() {
        courseManager = new CourseManager();
        course = new Course("CS101", "Introduction to Computer Science", 30);
        student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addCourse(course);
        courseManager.addStudent(student);
    }

    @Test
    public void testEnrollStudentInCourse_Success() {
        assertTrue(student.enrollCourse("CS101", 3));
        assertEquals(7, student.getCredits());
        assertEquals(1, course.getEnrollStudent().size());
        assertEquals(3, course.getCredits().get(0));
    }

    @Test
    public void testEnrollStudentInCourse_Failure_CourseNotOpen() {
        courseManager.setIfOpen(false);
        assertFalse(student.enrollCourse("CS101", 3));
    }

    @Test
    public void testEnrollStudentInCourse_Failure_InsufficientCredits() {
        assertFalse(student.enrollCourse("CS101", 11)); // Not enough credits
    }

    @Test
    public void testEnrollStudentInCourse_Failure_CourseDoesNotExist() {
        assertFalse(student.enrollCourse("CS102", 3)); // Course does not exist
    }

    @Test
    public void testEnrollStudentInCourse_Failure_AlreadyEnrolled() {
        student.enrollCourse("CS101", 3);
        assertFalse(student.enrollCourse("CS101", 3)); // Already enrolled in the course
    }

    @Test
    public void testModifyStudentEnrollmentCredits_Success() {
        student.enrollCourse("CS101", 3);
        assertTrue(student.modifyEnrollCredit("CS101", 2));
        assertEquals(8, student.getCredits());
        assertEquals(2, course.getCredits().get(0));
    }

    @Test
    public void testModifyStudentEnrollmentCredits_Failure_CourseNotOpen() {
        student.enrollCourse("CS101", 3);
        courseManager.setIfOpen(false);
        assertFalse(student.modifyEnrollCredit("CS101", 2));
    }

    @Test
    public void testModifyStudentEnrollmentCredits_Failure_CourseDoesNotExist() {
        assertFalse(student.modifyEnrollCredit("CS102", 2)); // Course does not exist
    }

    @Test
    public void testModifyStudentEnrollmentCredits_Failure_NotEnrolled() {
        assertFalse(student.modifyEnrollCredit("CS101", 2)); // Not enrolled in the course
    }

    @Test
    public void testDropStudentEnrollmentCourse_Success() {
        student.enrollCourse("CS101", 3);
        assertTrue(student.dropEnrollCourse("CS101"));
        assertEquals(10, student.getCredits()); // Should regain credits
        assertEquals(0, course.getEnrollStudent().size()); // No students enrolled
    }

    @Test
    public void testDropStudentEnrollmentCourse_Failure_CourseNotOpen() {
        student.enrollCourse("CS101", 3);
        courseManager.setIfOpen(false);
        assertFalse(student.dropEnrollCourse("CS101"));
    }

    @Test
    public void testDropStudentEnrollmentCourse_Failure_CourseDoesNotExist() {
        assertFalse(student.dropEnrollCourse("CS102")); // Course does not exist
    }

    @Test
    public void testDropStudentEnrollmentCourse_Failure_NotEnrolled() {
        assertFalse(student.dropEnrollCourse("CS101")); // Not enrolled in the course
    }

    @Test
    public void testGetEnrolledCoursesWithCredits() {
        student.enrollCourse("CS101", 3);
        ArrayList<String> coursesWithCredits = student.getCoursesWithScores();
        assertEquals(1, coursesWithCredits.size());
        assertEquals("CS101: 3", coursesWithCredits.get(0));
    }

    //@Test
    public void testFinalizeEnrollments() {
        Student student2 = new Student("S002", "student2@example.com", "Jane Doe", 10);
        courseManager.addStudent(student2);
        student.enrollCourse("CS101", 3);
        student2.enrollCourse("CS101", 4);
        courseManager.finalizeEnrollments();
        
        assertEquals(1, course.getSuccessStudents().size()); // Assuming min credit is 4 for success
        assertTrue(course.getSuccessStudents().contains(student2)); // Jane should succeed
        assertFalse(course.getSuccessStudents().contains(student)); // John should not succeed
    }
}
