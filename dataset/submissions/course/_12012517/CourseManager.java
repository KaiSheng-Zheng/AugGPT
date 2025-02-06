import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class CourseManagerTest {

    private CourseManager courseManager;
    private Student student1;
    private Student student2;
    private Student student3;
    private Course course1;
    private Course course2;

    @BeforeEach
    void setUp() {
        courseManager = new CourseManager();
        courseManager.setIfOpen(true);

        student1 = new Student("s001", "student1@example.com", "Student One", 100);
        student2 = new Student("s002", "student2@example.com", "Student Two", 120);
        student3 = new Student("s003", "student3@example.com", "Student Three", 150);

        course1 = new Course("c001", "Course One", 2);
        course2 = new Course("c002", "Course Two", 3);

        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addStudent(student3);
        courseManager.addCourse(course1);
        courseManager.addCourse(course2);
    }

    @AfterEach
    void tearDown() {
        courseManager = null;
        student1 = null;
        student2 = null;
        student3 = null;
        course1 = null;
        course2 = null;
    }

    @Test

    void testCanBidOnFullCourse() {
        assertTrue(student1.enrollCourse("c001", 50));
        assertTrue(student2.enrollCourse("c001", 70));
        assertTrue(student3.enrollCourse("c001", 90)); // Student3 makes a higher bid despite the course being "full"

        // Should return true since it's within bidding period
        assertTrue(student1.modifyEnrollCredit("c001", 100)); // Student1 outbids Student3

        courseManager.finalizeEnrollments();

        // Verify that Student1 and Student3 are the ones enrolled after bidding
        assertTrue(course1.getSuccessStudents().contains(student1));
        assertFalse(course1.getSuccessStudents().contains(student2)); // Student2 should be outbid and thus removed
        assertTrue(course1.getSuccessStudents().contains(student3));
    }

    @Test

    void testCanDecreaseEnrolledCourseBidCredits() {
        assertTrue(student1.enrollCourse("c001", 50));
        assertTrue(student1.modifyEnrollCredit("c001", 30)); // Student1 decreases the bid

        // Verify new credits after decreasing the bid
        assertEquals(30, (int) course1.getCredits().get(course1.getEnrollStudent().indexOf(student1)));
    }

    @Test

    void testBiddingMoreCanChangeEnrollments() {
        assertTrue(student1.enrollCourse("c001", 40)); // Student One enrolls with 40 credits
        assertTrue(student2.enrollCourse("c001", 60)); // Student Two enrolls with 60 credits
        assertTrue(student3.enrollCourse("c001", 80)); // Now course "c001" is full, but bidding is still possible

        // Student1 increases bid, should be able to replace student2
        assertTrue(student1.modifyEnrollCredit("c001", 90));

        courseManager.finalizeEnrollments();

        assertTrue(course1.getSuccessStudents().contains(student1));
        assertFalse(course1.getSuccessStudents().contains(student2)); // Student2 should be kicked out because they have the lowest bid now
        assertTrue(course1.getSuccessStudents().contains(student3));
    }

    @Test

    void testOperationsAfterClose() {
        courseManager.finalizeEnrollments();

        assertFalse(courseManager.getIfOpen());
        assertFalse(student1.enrollCourse("c001", 50));
        assertFalse(student1.modifyEnrollCredit("c001", 60));
        assertFalse(student1.dropEnrollCourse("c001"));

        // The setups already ensure that no operations have actually affected the enrolments
    }

    @Test

    void testFinalEnrollmentListAndStudentCredits() {
        assertTrue(student1.enrollCourse("c001", 50));
        assertTrue(student2.enrollCourse("c001", 60));
        assertTrue(student3.enrollCourse("c001", 80));

        assertTrue(student1.modifyEnrollCredit("c001", 90));
        assertTrue(student2.modifyEnrollCredit("c001", 70));

        student3.dropEnrollCourse("c001"); // Student3 drops, should get a full refund
        assertEquals(150, student3.getCredits());

        courseManager.finalizeEnrollments();

        assertTrue(course1.getSuccessStudents().contains(student1));
        assertTrue(course1.getSuccessStudents().contains(student2));
        assertEquals(100 - 90, student1.getCredits());
        assertEquals(120 - 70, student2.getCredits());
    }

    @Test

    void testEnrollModifyCreditsAndDropCourses() {
        // Students enroll in courses
        assertTrue(student1.enrollCourse("c001", 50));
        assertTrue(student2.enrollCourse("c001", 70));
        assertTrue(student3.enrollCourse("c002", 100));
        assertEquals(50, student1.getCredits());
        assertEquals(50, student2.getCredits());
        assertEquals(50, student3.getCredits());

        // Students modify their credits for a course
        assertTrue(student1.modifyEnrollCredit("c001", 20));
        assertTrue(student2.modifyEnrollCredit("c001", 60));
        assertEquals(80, student1.getCredits());
        assertEquals(60, student2.getCredits());

        // Student 3 decides to drop course2
        assertTrue(student3.dropEnrollCourse("c002"));
        assertEquals(150, student3.getCredits()); // Student 3 should have all credits refunded

        assertTrue(student3.enrollCourse("c001", 100));
        // Finalize enrollments
        courseManager.finalizeEnrollments();

        // Check the success lists
        assertTrue(course1.getSuccessStudents().contains(student2));
        assertFalse(course1.getSuccessStudents().contains(student1)); // Student 1 has lower credits than Student 2
        assertTrue(course1.getSuccessStudents().size() <= course1.getMaxCapacity());

        // Student3 dropped the course so they should not appear in the success list
        assertFalse(course2.getSuccessStudents().contains(student3));
    }

    @Test

    void testFinalizingEnrollmentsWithCompetingCredits() {
        // Three students enroll into Course 1, which has a capacity of 2
        assertTrue(student1.enrollCourse("c001", 40)); // Student One enrolls with 40 credits
        assertTrue(student2.enrollCourse("c001", 30)); // Student Two enrolls with 30 credits
        assertTrue(student3.enrollCourse("c001", 60)); // Student Three enrolls with 60 credits

        courseManager.finalizeEnrollments();

        // Only Student Three and Student One should be successful due to their higher bids
        assertTrue(course1.getSuccessStudents().contains(student3));
        assertTrue(course1.getSuccessStudents().contains(student1));
        assertFalse(course1.getSuccessStudents().contains(student2));

        // The capacity should not be exceeded
        assertEquals(2, course1.getSuccessStudents().size());
    }

    @Test
