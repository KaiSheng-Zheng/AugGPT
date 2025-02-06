import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class CourseManagerTest_23kx {
    private CourseManager courseManager;
    private Student student;
    private Course course;

    @BeforeEach
    public void setUp() {
        courseManager = new CourseManager();
        student = new Student("S001", "student@example.com", "John Doe", 10);
        course = new Course("C001", "Computer Science", 30);
        courseManager.addStudent(student);
        courseManager.addCourse(course);
    }

    //@Test
    public void testEnrollStudentInCourse_Success() {
        boolean result = course.enrollStudent(student, 5);
        assertTrue(result);
        assertEquals(5, student.getCredits());
        assertTrue(course.getEnrollStudent().contains(student));
        assertTrue(student.getEnrollCourses().contains(course));
    }

    @Test
    public void testEnrollStudentInCourse_InsufficientCredits() {
        
        student.setCredits(0);
        boolean result = course.enrollStudent(student, 5);
        assertFalse(result);
    }

    @Test
    public void testEnrollStudentInCourse_CourseNotOpen() {
        
        courseManager.setIfOpen(false);
        boolean result = course.enrollStudent(student, 5);
        assertFalse(result);
    }

    @Test
    public void testEnrollStudentInCourse_CourseDoesNotExist() {
        boolean result = courseManager.enrollStudentInCourse(student, "C002", 5);
        assertFalse(result);
    }

    //@Test
    public void testModifyStudentEnrollmentCredits_Success() {
        course.enrollStudent(student, 5);
        boolean result = courseManager.modifyStudentEnrollmentCredits(student, "C001", 3);
        assertTrue(result);
        assertEquals(8, student.getCredits());
    }

    @Test
    public void testModifyStudentEnrollmentCredits_CourseNotFound() {
        boolean result = courseManager.modifyStudentEnrollmentCredits(student, "C002", 3);
        assertFalse(result);
    }

    //@Test
    public void testDropStudentEnrollmentCourse_Success() {
        course.enrollStudent(student, 5);
        boolean result = courseManager.dropStudentEnrollmentCourse(student, "C001");
        assertTrue(result);
        assertEquals(10, student.getCredits());
        assertFalse(course.getEnrollStudent().contains(student));
    }

    @Test
    public void testDropStudentEnrollmentCourse_CourseNotFound() {
        boolean result = courseManager.dropStudentEnrollmentCourse(student, "C002");
        assertFalse(result);
    }

    //@Test
    public void testFinalizeEnrollments_Success() {
        course.enrollStudent(student, 5);
        courseManager.finalizeEnrollments();
        assertTrue(course.getSuccessStudents().contains(student));
        assertTrue(student.getSuccessCourses().contains(course));
    }

    //@Test
    public void testGetEnrolledCoursesWithCredits_Success() {
        course.enrollStudent(student, 5);
        ArrayList<String> results = courseManager.getEnrolledCoursesWithCredits(student);
        assertEquals(1, results.size());
        assertEquals("C001: 5", results.get(0));
    }

    @Test
    public void testGetEnrolledCoursesWithCredits_CourseNotOpen() {
        courseManager.setIfOpen(false);
        ArrayList<String> results = courseManager.getEnrolledCoursesWithCredits(student);
        assertNull(results);
    }
}
