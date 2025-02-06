
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CourseManagerTest {

    private CourseManager manager;
    private Student[] students;
    private Course[] courses;

    @BeforeEach
    void setUp() {
        this.students = new Student[10];
        this.courses = new Course[5];
        manager = new CourseManager();
        manager.setIfOpen(true);

        for (int i = 0; i < courses.length; i++) {
            this.courses[i] = new Course("CS" + (i + 1), "Course " + (i + 1), 2);
            manager.addCourse(courses[i]);
        }

        for (int i = 0; i < students.length; i++) {
            this.students[i] = new Student("ID" + (i + 1), "student" + (i + 1) + "@example.com", "Student " + (i + 1), 50);
            manager.addStudent(students[i]);


        }

    }

    @AfterEach
    void tearDown() {
        // If the objects should be explicitly set to null for the garbage collector
        if (courses != null) {
            Arrays.fill(courses, null);
        }

        if (students != null) {
            Arrays.fill(students, null);
        }
        manager = null;
    }

    @Test
    void test01() {
        // All students attempt to enroll in the same first course with increasing bid credits
        for (int i = 0; i < students.length; i++) {
            students[i].enrollCourse("CS1", i + 1); // Bid credits increment by student index
        }

        // Finalize enrollments
        manager.finalizeEnrollments();
        // System should be closed after finalization
        assertFalse(manager.getIfOpen());

        // Post-finalization, tests should confirm that no changes can be made and correct students are enrolled
        assertFalse(students[0].enrollCourse("CS1", 10));         // Should fail as system is closed
        assertFalse(students[1].modifyEnrollCredit("CS1", 30));    // Should fail as system is closed
        assertFalse(students[0].dropEnrollCourse("CS1"));         // Should fail as system is closed

        // Tests to ensure the students with the highest bids were selected
        assertTrue(courses[0].getSuccessStudents().contains(students[9])); // Highest bidder
        assertTrue(courses[0].getSuccessStudents().contains(students[8])); // Second highest bidder

        // The first course should have only 2 students enrolled
        assertEquals(2, courses[0].getSuccessStudents().size());
    }

    @Test
    void test02() {
        // Students bid on courses with incremental credits based on the course number
        for (int i = 0; i < students.length; i++) {
            int totalCreditsUsed = 0; // Track the total credits the student has bid.
            for (int j = 0; j < courses.length; j++) {
                int bidCredits = 5 + (j * 5) + i; // Increase by 5 for each subsequent course.
                totalCreditsUsed += bidCredits;
                // If a student does not have enough credits left, they don't bid on this course.
                if (totalCreditsUsed > 50) {
                    break;
                }
                // Student attempts to enroll in the course with their bid.
                boolean success = students[i].enrollCourse(courses[j].getCourseID(), bidCredits);
                // Check if the enrollment was successful given the conditions.
                assertTrue(success);
                // Check if credits are correctly deducted after a successful bid.
                assertEquals(50 - totalCreditsUsed, students[i].getCredits());
            }
        }

        // Students modify their bids
        students[5].modifyEnrollCredit(courses[0].getCourseID(), 3); // Student 6 decreases their bid by 2 for CS1
        assertEquals(12, students[5].getCredits()); // Check if credits are updated correctly

        // Students drop a course
        students[3].dropEnrollCourse(courses[2].getCourseID()); // Student 4 drops CS3
        assertEquals(29, students[3].getCredits()); // Check if credits are returned correctly

        // Students drop a course
        students[9].dropEnrollCourse(courses[0].getCourseID());
        assertEquals(31, students[9].getCredits());

        // Finalize enrollments
        manager.finalizeEnrollments();
        assertFalse(manager.getIfOpen()); // System should be closed after the finalization

        // Check the number of students enrolled in each course is within the capacity limit
        for (Course course : courses) {
            assertTrue(course.getSuccessStudents().size() <= 2);
        }

        // Assert specific students are enrolled in a given course
        // This depends on the bid logic and the order of bids
        // Assuming we have a sorted list of successful students for each course.
        // For simplification, let's assert for one course (CS1).
        // Let's expect students[9] (Student 10) and students[8] (Student 9) to have the highest bids.
        assertTrue(courses[0].getSuccessStudents().contains(students[8]));
        assertTrue(courses[0].getSuccessStudents().contains(students[7]));
    }

    @Test
    void test03() {
        // Enroll a single student in multiple courses
        assertTrue(students[6].enrollCourse(courses[2].getCourseID(), 15));
        assertTrue(students[6].enrollCourse(courses[3].getCourseID(), 15));

        // Modify credits in one course
        assertTrue(students[6].modifyEnrollCredit(courses[2].getCourseID(), 18));

        // Drop another course
        assertTrue(students[6].dropEnrollCourse(courses[3].getCourseID()));

        // Assert changes have taken place correctly
        assertEquals(32, students[6].getCredits());
        assertEquals(18, (int) courses[2].getCredits().get(courses[2].getEnrollStudent().indexOf(students[6])));
        assertFalse(students[6].getEnrollCourses().contains(courses[3]));

//        // Now finalize and verify final enrollments
//        manager.finalizeEnrollments();
    }

    @Test
    void test04() {
        // First round of bidding
        for (Student student : students) {
            int bidAmount = 10;
            // Enroll in courses with enough credits
            for (int i = 0; i < 4; i++) {
                student.enrollCourse(courses[i].getCourseID(), bidAmount);
            }
        }

        // Modify bids for a few students
        students[0].modifyEnrollCredit("CS1", 15); // Student 1 increases their bid on CS1 from 10 to 15
        students[1].modifyEnrollCredit("CS2", 20); // Student 2 increases their bid on CS2 from 10 to 20

        // Students drop courses
        students[2].dropEnrollCourse("CS3"); // Student 3 drops CS3 and gets back 10 credits

        // Let's calculate the remaining credits manually:
        // Student 1 initially had 50 credits, spent (10 * 4) on other courses, then increased bid on CS1 by 5 credits (from 10 to 15)
        assertEquals(50 - (10 * 4) - 5, students[0].getCredits());

        // Student 2 initially had 50 credits, spent (10 * 4) on other courses, then increased bid on CS2 by 10 credits (from 10 to 20)
        assertEquals(50 - (10 * 4) - 10, students[1].getCredits());

        // Student 3 initially had 50 credits, spent (10 * 4) on all 5 courses, but then dropped CS3 getting back 10 credits
        assertEquals(50 - (10 * 4) + 10, students[2].getCredits());

        // Finalize enrollments
        manager.finalizeEnrollments();

        // Check that system is no longer open for enrollments
        assertFalse(manager.getIfOpen());

        // Check enrolled students for each course
        for (Course course : courses) {
            assertTrue(course.getSuccessStudents().size() <= 2);
        }

        // Verify correct enrollment
        assertTrue(courses[0].getSuccessStudents().contains(students[0]) && courses[1].getSuccessStudents().contains(students[1]));
        // Verifications for CS2 and other courses would be similar assuming we know who bid what.
        assertEquals(1, courses[1].getSuccessStudents().size());
        assertEquals(1, courses[0].getSuccessStudents().size());

    }

    @Test
    void test05() {
        // Student enrolls in courses with varying credits
        students[0].enrollCourse("CS1", 5);
        students[0].enrollCourse("CS2", 10);
        students[0].enrollCourse("CS3", 15);

        // Student modifies their bid for one course
        students[0].modifyEnrollCredit("CS1", 10);

        // Student drops a course
        students[0].dropEnrollCourse("CS3");

        assertFalse(students[0].enrollCourse("CS4", 35));
        assertFalse(students[0].dropEnrollCourse("CS5"));

        assertTrue(students[0].dropEnrollCourse("CS2"));
        assertTrue(students[0].enrollCourse("CS4", 35));
        assertEquals(5, students[0].getCredits());

        // Get the courses with scores for the student
        List<String> enrolledCoursesWithScores = students[0].getCoursesWithScores();

        // Assert that they are enrolled in the right courses with the correct scores
        assertTrue(enrolledCoursesWithScores.contains("CS1: 10"));
        assertTrue(enrolledCoursesWithScores.contains("CS4: 35"));
        assertFalse(enrolledCoursesWithScores.contains("CS3: 15")); // Dropped course should not appear

        // Optionally, assert the list size to ensure no additional courses are present
        assertEquals(2, enrolledCoursesWithScores.size());
    }

    @Test
    void test06() {
        // Let's enroll multiple students in multiple courses, modifying credits, and dropping courses.
        // Enrolling students in the courses with varying credits.
        assertTrue(students[0].enrollCourse(courses[0].getCourseID(), 10));
        assertTrue(students[1].enrollCourse(courses[0].getCourseID(), 15));
        assertTrue(students[2].enrollCourse(courses[0].getCourseID(), 10));
        assertTrue(students[3].enrollCourse(courses[1].getCourseID(), 20));
        assertTrue(students[4].enrollCourse(courses[1].getCourseID(), 20));
        assertTrue(students[5].enrollCourse(courses[1].getCourseID(), 5));

        // Modifying credits of enrollment.
        assertTrue(students[2].modifyEnrollCredit(courses[0].getCourseID(), 12));

        // Dropping course enrollment.
        assertTrue(students[5].dropEnrollCourse(courses[1].getCourseID()));

        assertEquals(40, students[0].getCredits());
        assertEquals(50, students[5].getCredits());
        // Check Student 5 was successfully removed from CS2 enrollments with credits refunded.
        assertFalse(courses[1].getEnrollStudent().contains(students[5]));

        // Finalize enrollments.
        manager.finalizeEnrollments();

        // Assert enrollments after finalizing.
        // CS1 should only have the two top-scoring students due to tiebreaker rule.
        assertEquals(2, courses[0].getSuccessStudents().size());
        assertTrue(courses[0].getSuccessStudents().contains(students[1]));
        assertTrue(courses[0].getSuccessStudents().contains(students[2]));

        // Student 0 tried to enroll in CS1 but got dropped due to lower credits.
        assertFalse(courses[0].getSuccessStudents().contains(students[0]));

        // CS2 should have two students successfully enrolled due to tie, but no drop because it's under capacity.
        assertEquals(2, courses[1].getSuccessStudents().size());
        assertTrue(courses[1].getSuccessStudents().contains(students[3]));
        assertTrue(courses[1].getSuccessStudents().contains(students[4]));
    }

    @Test
    void test07() {
        // Enrolling and dropping courses before finalizing to test system robustness
        assertTrue(students[7].enrollCourse(courses[2].getCourseID(), 10));
        assertTrue(students[7].dropEnrollCourse(courses[2].getCourseID()));

        assertTrue(students[8].enrollCourse(courses[4].getCourseID(), 12));
        assertTrue(students[8].modifyEnrollCredit(courses[4].getCourseID(), 15));

        // Attempt to drop a course not enrolled in
        assertFalse(students[9].dropEnrollCourse(courses[1].getCourseID()));

        // Attempt to modify a course not enrolled in
        assertFalse(students[9].modifyEnrollCredit(courses[1].getCourseID(), 20));

        assertEquals(50, students[7].getCredits());
        assertEquals(35, students[8].getCredits());
        assertEquals(50, students[9].getCredits());

        manager.finalizeEnrollments();

        // After finalizing enrollments, Student 7 should not be enrolled in CS3, credit unchanged.
        assertFalse(courses[2].getSuccessStudents().contains(students[7]));

        // After modifying the score, Student 8 should be enrolled in CS5, credits deducted.
        assertTrue(courses[4].getSuccessStudents().contains(students[8]));

        // Ensure that Student 9's failed operations have not impacted their credits.
    }

    @Test
    void test08() {

        assertTrue(students[0].enrollCourse("CS1", 10));
        assertTrue(students[1].enrollCourse("CS1", 10));
        assertTrue(students[2].enrollCourse("CS1", 10));
        assertTrue(students[3].enrollCourse("CS1", 20));

        assertTrue(students[4].enrollCourse("CS2", 20)); //
        assertTrue(students[5].enrollCourse("CS2", 20)); //
        assertTrue(students[6].enrollCourse("CS2", 10)); //

        assertTrue(students[7].enrollCourse("CS3", 15)); //
        assertTrue(students[8].enrollCourse("CS3", 15)); //
        assertTrue(students[9].enrollCourse("CS3", 15)); //

        manager.finalizeEnrollments(); //

        assertFalse(manager.getIfOpen()); //

        assertTrue(courses[0].getSuccessStudents().contains(students[3]));
        assertFalse(courses[0].getSuccessStudents().contains(students[0]));
        assertFalse(courses[0].getSuccessStudents().contains(students[1]));
        assertFalse(courses[0].getSuccessStudents().contains(students[2]));

        assertTrue(courses[1].getSuccessStudents().contains(students[4]));
        assertTrue(courses[1].getSuccessStudents().contains(students[5]));
        assertFalse(courses[1].getSuccessStudents().contains(students[6]));

        assertFalse(courses[2].getSuccessStudents().contains(students[7]));
        assertFalse(courses[2].getSuccessStudents().contains(students[8]));
        assertFalse(courses[2].getSuccessStudents().contains(students[9]));
    }

    @Test
    void test09() {
        assertFalse(students[0].enrollCourse("CS1", -10));

        assertFalse(students[1].enrollCourse("CS1", 60));

        assertFalse(students[2].enrollCourse("CS999", 10));

        manager.setIfOpen(false); //
        assertFalse(students[3].modifyEnrollCredit("CS1", 20)); //
        manager.setIfOpen(true); //

        assertTrue(students[3].enrollCourse("CS1", 20));

        List<String> student0Courses = students[0].getCoursesWithScores();
        List<String> student3Courses = students[3].getCoursesWithScores();

        assertTrue(student0Courses.isEmpty()); //
        assertEquals(1, student3Courses.size()); //
        assertTrue(student3Courses.get(0).contains("CS1: 20")); //
        assertEquals(50, students[0].getCredits());  //
        assertEquals(50, students[1].getCredits());  //
        assertEquals(50, students[2].getCredits());  //

        assertEquals(50 - 20, students[3].getCredits()); //

        manager.finalizeEnrollments();

        assertFalse(students[3].modifyEnrollCredit("CS1", 15));

        assertFalse(students[3].dropEnrollCourse("CS1"));

    }

    @Test
    void test10() {
        Course maxCapacityCourse = new Course("CS_LARGE", "Large Course", 5);
        manager.addCourse(maxCapacityCourse);
        assertTrue(students[0].enrollCourse("CS_LARGE", 20));
        assertTrue(students[1].enrollCourse("CS_LARGE", 10));
        assertTrue(students[2].enrollCourse("CS_LARGE", 30));
        assertTrue(students[3].enrollCourse("CS_LARGE", 15));
        assertTrue(students[4].enrollCourse("CS_LARGE", 5));
        assertTrue(students[5].enrollCourse("CS_LARGE", 25));
        assertTrue(students[6].enrollCourse("CS_LARGE", 10));
        assertTrue(students[7].enrollCourse("CS_LARGE", 20));

        assertTrue(students[5].modifyEnrollCredit("CS_LARGE", 8));
        assertEquals(50 - 20, students[0].getCredits());
        assertEquals(50 - 10, students[1].getCredits());
        assertEquals(50 - 30, students[2].getCredits());
        assertEquals(50 - 15, students[3].getCredits()); //
        assertEquals(50 - 5, students[4].getCredits());  //
        assertEquals(50 - 8, students[5].getCredits());  //
        assertEquals(50 - 10, students[6].getCredits());
        assertEquals(50 - 20, students[7].getCredits());

        List<String> student5Courses = students[5].getCoursesWithScores();
        assertEquals(1, student5Courses.size()); //
        assertTrue(student5Courses.get(0).contains("CS_LARGE: 8")); //
        manager.finalizeEnrollments();

        assertEquals(4, maxCapacityCourse.getSuccessStudents().size());
        assertTrue(maxCapacityCourse.getSuccessStudents().contains(students[2]));
        assertTrue(maxCapacityCourse.getSuccessStudents().contains(students[0]));
        assertFalse(maxCapacityCourse.getSuccessStudents().contains(students[5])); //
        assertTrue(maxCapacityCourse.getSuccessStudents().contains(students[3]));
        assertTrue(maxCapacityCourse.getSuccessStudents().contains(students[7]));

        assertFalse(maxCapacityCourse.getSuccessStudents().contains(students[1]));
        assertFalse(maxCapacityCourse.getSuccessStudents().contains(students[4]));
        assertFalse(maxCapacityCourse.getSuccessStudents().contains(students[6]));


    }

}
