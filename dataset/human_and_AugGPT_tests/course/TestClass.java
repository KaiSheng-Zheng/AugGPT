import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import java.util.*;


public class TestClass {

    @Test
    public void testEnrollStudentInCourse_4gnm() throws Exception {
        // Create CourseManager instance
        CourseManager courseManager = new CourseManager();

        // Create a Course with a capacity of 2
        Course course = new Course("CS101", "Computer Science", 2);
        courseManager.addCourse(course);

        // Create a Student with 10 credits
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addStudent(student);

        // Enroll the student in the course with a bid of 5 credits
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student, "CS101", 5));

        // Verify that the student is enrolled in the course
        Field enrollCoursesField = Student.class.getDeclaredField("enrollCourses");
        enrollCoursesField.setAccessible(true);
        Assertions.assertEquals(1, ((ArrayList<Course>) enrollCoursesField.get(student)).size());

        // Verify the credits left for the student
        Assertions.assertEquals(5, student.getCredits());

        // Verify that the course has the student enrolled
        Field enrollStudentsField = Course.class.getDeclaredField("enrollStudent");
        enrollStudentsField.setAccessible(true);
        Assertions.assertEquals(1, ((ArrayList<Student>) enrollStudentsField.get(course)).size());
    }

    @Test
    public void testModifyStudentEnrollmentCredits_q4kb() throws Exception {
        // Create CourseManager instance
        CourseManager courseManager = new CourseManager();

        // Create a Course with a capacity of 2
        Course course = new Course("CS101", "Computer Science", 2);
        courseManager.addCourse(course);

        // Create a Student with 10 credits
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addStudent(student);

        // Enroll the student in the course with a bid of 5 credits
        courseManager.enrollStudentInCourse(student, "CS101", 5);

        // Modify the student's bid to 3 credits
        Assertions.assertTrue(courseManager.modifyStudentEnrollmentCredits(student, "CS101", 3));

        // Verify the student's credits after modification
        Assertions.assertEquals(7, student.getCredits());

        // Verify the course's credits list
        Field creditsField = Course.class.getDeclaredField("credits");
        creditsField.setAccessible(true);
        Assertions.assertEquals(3, ((ArrayList<Integer>) creditsField.get(course)).get(0));
    }

    @Test
    public void testDropStudentEnrollmentCourse_vgk3() throws Exception {
        // Create CourseManager instance
        CourseManager courseManager = new CourseManager();

        // Create a Course with a capacity of 2
        Course course = new Course("CS101", "Computer Science", 2);
        courseManager.addCourse(course);

        // Create a Student with 10 credits
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addStudent(student);

        // Enroll the student in the course with a bid of 5 credits
        courseManager.enrollStudentInCourse(student, "CS101", 5);

        // Drop the student's enrollment in the course
        Assertions.assertTrue(courseManager.dropStudentEnrollmentCourse(student, "CS101"));

        // Verify that the student is no longer enrolled in the course
        Field enrollCoursesField = Student.class.getDeclaredField("enrollCourses");
        enrollCoursesField.setAccessible(true);
        Assertions.assertEquals(0, ((ArrayList<Course>) enrollCoursesField.get(student)).size());

        // Verify the student's credits are refunded
        Assertions.assertEquals(10, student.getCredits());

        // Verify the course has no enrolled students
        Field enrollStudentsField = Course.class.getDeclaredField("enrollStudent");
        enrollStudentsField.setAccessible(true);
        Assertions.assertEquals(0, ((ArrayList<Student>) enrollStudentsField.get(course)).size());
    }

    @Test
    public void testEnrollStudentInCourse_vd18() throws Exception {
        // Create a CourseManager instance and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);
        
        // Create a Course and add it to the CourseManager
        Course course = new Course("CS101", "Computer Science 101", 2);
        courseManager.addCourse(course);
        
        // Create a Student and add it to the CourseManager
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addStudent(student);
        
        // Enroll the student in the course with a bid of 5 credits
        boolean enrollmentResult = courseManager.enrollStudentInCourse(student, "CS101", 5);
        
        // Assert the enrollment was successful and check the student's and course's state
        Assertions.assertTrue(enrollmentResult);
        Assertions.assertEquals(5, student.getCredits());
        Assertions.assertEquals(1, course.getEnrollStudent().size());
        Assertions.assertEquals(5, course.getCredits().get(0));
    }

    @Test
    public void testModifyStudentEnrollmentCredits_bizq() throws Exception {
        // Setup the CourseManager and open it
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);
        
        // Create a Course and Student
        Course course = new Course("CS101", "Computer Science 101", 2);
        courseManager.addCourse(course);
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addStudent(student);
        
        // Enroll the student and then modify the bid credits
        courseManager.enrollStudentInCourse(student, "CS101", 5);
        boolean modifyResult = courseManager.modifyStudentEnrollmentCredits(student, "CS101", 3);
        
        // Assert modification was successful and check new credits
        Assertions.assertTrue(modifyResult);
        Assertions.assertEquals(7, student.getCredits());
        Assertions.assertEquals(3, course.getCredits().get(0));
    }

    @Test
    public void testDropStudentEnrollmentCourse_o805() throws Exception {
        // Setup the CourseManager and open it
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);
        
        // Create a Course and Student
        Course course = new Course("CS101", "Computer Science 101", 2);
        courseManager.addCourse(course);
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addStudent(student);
        
        // Enroll the student and then drop the course
        courseManager.enrollStudentInCourse(student, "CS101", 5);
        boolean dropResult = courseManager.dropStudentEnrollmentCourse(student, "CS101");
        
        // Assert the drop was successful and check the student's credits are refunded
        Assertions.assertTrue(dropResult);
        Assertions.assertEquals(10, student.getCredits()); // 5 credits refunded
        Assertions.assertEquals(0, course.getEnrollStudent().size());
    }

    //@Test
    public void testFinalizeEnrollments_rs7f() throws Exception {
        // Setup the CourseManager and open it
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);
        
        // Create Courses and Students
        Course course1 = new Course("CS101", "Computer Science 101", 2);
        Course course2 = new Course("CS102", "Computer Science 102", 2);
        courseManager.addCourse(course1);
        courseManager.addCourse(course2);
        
        Student student1 = new Student("S001", "student1@example.com", "Alice", 10);
        Student student2 = new Student("S002", "student2@example.com", "Bob", 8);
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        
        // Enroll students in courses with different credits
        courseManager.enrollStudentInCourse(student1, "CS101", 5);
        courseManager.enrollStudentInCourse(student2, "CS101", 4);
        courseManager.enrollStudentInCourse(student1, "CS102", 6);
        courseManager.enrollStudentInCourse(student2, "CS102", 2);
        
        // Finalize enrollments
        Method finalizeEnrollmentsMethod = CourseManager.class.getDeclaredMethod("finalizeEnrollments");
        finalizeEnrollmentsMethod.setAccessible(true);
        finalizeEnrollmentsMethod.invoke(courseManager);
        
        // Assert the finalization results
        Assertions.assertEquals(2, course1.getSuccessStudents().size());
        Assertions.assertEquals(2, course2.getSuccessStudents().size());
        Assertions.assertTrue(student1.getSuccessCourses().contains(course1));
        Assertions.assertTrue(student2.getSuccessCourses().contains(course1));
    }

    @Test
    public void testEnrollStudentInCourseWithValidData_490v() throws Exception {
        // Create CourseManager instance
        CourseManager courseManager = new CourseManager();
        // Create a Course with maximum capacity of 1
        Course course = new Course("CS101", "Intro to CS", 1);
        // Create a Student with enough credits
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        
        // Register the course and student in the CourseManager
        courseManager.addCourse(course);
        courseManager.addStudent(student);
        
        // Open the course selection
        courseManager.setIfOpen(true);
        
        // Enroll the student in the course with 5 credits
        boolean result = courseManager.enrollStudentInCourse(student, "CS101", 5);
        
        // Assert the enrollment was successful
        Assertions.assertTrue(result);
        
        // Use reflection to check if the student is enrolled in the course
        Method getEnrollCoursesMethod = Student.class.getDeclaredMethod("getEnrollCourses");
        getEnrollCoursesMethod.setAccessible(true);
        ArrayList<Course> enrolledCourses = (ArrayList<Course>) getEnrollCoursesMethod.invoke(student);
        
        // Assert the student is now enrolled in the course
        Assertions.assertEquals(1, enrolledCourses.size());
        Assertions.assertEquals("CS101", enrolledCourses.get(0).getCourseID());
        
        // Check the student's remaining credits
        Assertions.assertEquals(5, student.getCredits());
    }

    //@Test
    public void testModifyStudentEnrollmentCreditsWithValidData_f4bm() throws Exception {
        // Set up CourseManager and Course
        CourseManager courseManager = new CourseManager();
        Course course = new Course("CS102", "Data Structures", 1);
        Student student = new Student("S002", "student2@example.com", "Jane Doe", 10);
        
        // Register and open the course
        courseManager.addCourse(course);
        courseManager.addStudent(student);
        courseManager.setIfOpen(true);
        courseManager.enrollStudentInCourse(student, "CS102", 5);
        
        // Modify the student's bid to 7 credits for the same course
        boolean result = courseManager.modifyStudentEnrollmentCredits(student, "CS102", 7);
        
        // Assert that the modification failed due to insufficient credits
        Assertions.assertFalse(result);
        
        // Check the student's credits should still be 5
        Assertions.assertEquals(5, student.getCredits());
        
        // Modify to a valid credit amount
        result = courseManager.modifyStudentEnrollmentCredits(student, "CS102", 3);
        
        // Assert the modification was successful
        Assertions.assertTrue(result);
        
        // Check the student's remaining credits
        Assertions.assertEquals(7, student.getCredits());
    }

    @Test
    public void testDropStudentEnrollmentCourse_rfqw() throws Exception {
        // Create CourseManager and necessary entities
        CourseManager courseManager = new CourseManager();
        Course course = new Course("CS103", "Algorithms", 2);
        Student student = new Student("S003", "student3@example.com", "Alice", 10);
        
        // Register course and student
        courseManager.addCourse(course);
        courseManager.addStudent(student);
        courseManager.setIfOpen(true);
        
        // Enroll the student in the course
        courseManager.enrollStudentInCourse(student, "CS103", 5);
        
        // Drop the student from the course
        boolean result = courseManager.dropStudentEnrollmentCourse(student, "CS103");
        
        // Assert the drop was successful
        Assertions.assertTrue(result);
        
        // Check if the student's credits have been refunded
        Assertions.assertEquals(10, student.getCredits());
        
        // Use reflection to check if the student is still enrolled
        Method getEnrollCoursesMethod = Student.class.getDeclaredMethod("getEnrollCourses");
        getEnrollCoursesMethod.setAccessible(true);
        ArrayList<Course> enrolledCourses = (ArrayList<Course>) getEnrollCoursesMethod.invoke(student);
        
        // Assert the student is no longer enrolled
        Assertions.assertTrue(enrolledCourses.isEmpty());
    }

    @Test
    public void testFinalizeEnrollmentsWithCapacity_csj9() throws Exception {
        // Create CourseManager and set up courses and students
        CourseManager courseManager = new CourseManager();
        Course course = new Course("CS104", "Operating Systems", 2);
        Student student1 = new Student("S004", "student4@example.com", "Bob", 10);
        Student student2 = new Student("S005", "student5@example.com", "Charlie", 8);
        Student student3 = new Student("S006", "student6@example.com", "Diana", 6);
        
        // Register students and course
        courseManager.addCourse(course);
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addStudent(student3);
        courseManager.setIfOpen(true);
        
        // Enroll students with different credit bids
        courseManager.enrollStudentInCourse(student1, "CS104", 5); // Enroll first student
        courseManager.enrollStudentInCourse(student2, "CS104", 7); // Enroll second student
        courseManager.enrollStudentInCourse(student3, "CS104", 7); // Enroll third student
        
        // Finalize enrollments
        courseManager.finalizeEnrollments();
        
        // Assert the course should have only 2 successful enrollments
        Assertions.assertEquals(2, course.getSuccessStudents().size());
        
        // Assert both students have successfully enrolled
        Assertions.assertTrue(course.getSuccessStudents().contains(student1));
        Assertions.assertTrue(course.getSuccessStudents().contains(student2));
        
        // Check that student3 did not enroll successfully
        Assertions.assertFalse(course.getSuccessStudents().contains(student3));
    }

    //@Test
    public void testEnrollStudentInCourseWithInvalidConditions_5u33() throws Exception {
        // Create CourseManager instance and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create a student and a course
        Student student = new Student("S001", "student@example.com", "Student One", 5);
        Course course = new Course("C001", "Course One", 2);
        
        // Register the student and course
        courseManager.addStudent(student);
        courseManager.addCourse(course);
        
        // Attempt to enroll with zero credits, should return false
        Assertions.assertFalse((Boolean) invokeEnrollMethod_9uvu(courseManager, student, "C001", 0));
        
        // Attempt to enroll when ifOpen is false
        setIfOpenMethod.invoke(courseManager, false);
        Assertions.assertFalse((Boolean) invokeEnrollMethod_9uvu(courseManager, student, "C001", 3));
    }

    @Test
    public void testModifyStudentEnrollmentCredits_6stk() throws Exception {
        // Create CourseManager instance and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create student and course, register them
        Student student = new Student("S002", "student2@example.com", "Student Two", 10);
        Course course = new Course("C002", "Course Two", 2);
        courseManager.addStudent(student);
        courseManager.addCourse(course);

        // Enroll the student with an initial credit of 5
        invokeEnrollMethod_9uvu(courseManager, student, "C002", 5);
        
        // Modify the bid credits for the course
        Assertions.assertTrue((Boolean) invokeModifyCreditsMethod_fkm8(courseManager, student, "C002", 3));

        // Attempt to modify credits beyond available credits, should return false
        Assertions.assertFalse((Boolean) invokeModifyCreditsMethod_fkm8(courseManager, student, "C002", 15));
    }

    @Test
    public void testDropStudentEnrollmentCourse_8d8o() throws Exception {
        // Create CourseManager instance and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create a student and a course
        Student student = new Student("S003", "student3@example.com", "Student Three", 8);
        Course course = new Course("C003", "Course Three", 1);
        courseManager.addStudent(student);
        courseManager.addCourse(course);

        // Enroll the student in the course
        invokeEnrollMethod_9uvu(courseManager, student, "C003", 5);

        // Drop the enrollment
        Assertions.assertTrue((Boolean) invokeDropMethod_se3s(courseManager, student, "C003"));
        
        // Attempt to drop again, should return false
        Assertions.assertFalse((Boolean) invokeDropMethod_se3s(courseManager, student, "C003"));
    }

    @Test
    public void testFinalizeEnrollments_x09s() throws Exception {
        // Create CourseManager instance and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create students and courses
        Student student1 = new Student("S004", "student4@example.com", "Student Four", 10);
        Student student2 = new Student("S005", "student5@example.com", "Student Five", 5);
        Course course = new Course("C004", "Course Four", 2);
        
        // Register students and course
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addCourse(course);

        // Enroll students with different credits
        invokeEnrollMethod_9uvu(courseManager, student1, "C004", 8);
        invokeEnrollMethod_9uvu(courseManager, student2, "C004", 5);

        // Finalize enrollments
        Method finalizeEnrollmentsMethod = CourseManager.class.getDeclaredMethod("finalizeEnrollments");
        finalizeEnrollmentsMethod.setAccessible(true);
        finalizeEnrollmentsMethod.invoke(courseManager);

        // Check if success students are updated correctly
        Method getSuccessStudentsMethod = Course.class.getDeclaredMethod("getSuccessStudents");
        getSuccessStudentsMethod.setAccessible(true);
        ArrayList<Student> successStudents = (ArrayList<Student>) getSuccessStudentsMethod.invoke(course);
        Assertions.assertEquals(2, successStudents.size());
    }

    private Object invokeEnrollMethod_9uvu(CourseManager courseManager, Student student, String courseId, int points) throws Exception {
        Method enrollMethod = CourseManager.class.getDeclaredMethod("enrollStudentInCourse", Student.class, String.class, int.class);
        enrollMethod.setAccessible(true);
        return enrollMethod.invoke(courseManager, student, courseId, points);
    }

    private Object invokeModifyCreditsMethod_fkm8(CourseManager courseManager, Student student, String courseId, int credits) throws Exception {
        Method modifyMethod = CourseManager.class.getDeclaredMethod("modifyStudentEnrollmentCredits", Student.class, String.class, int.class);
        modifyMethod.setAccessible(true);
        return modifyMethod.invoke(courseManager, student, courseId, credits);
    }

    private Object invokeDropMethod_se3s(CourseManager courseManager, Student student, String courseId) throws Exception {
        Method dropMethod = CourseManager.class.getDeclaredMethod("dropStudentEnrollmentCourse", Student.class, String.class);
        dropMethod.setAccessible(true);
        return dropMethod.invoke(courseManager, student, courseId);
    }

    @Test
    public void testEnrollStudentInCourseWithNegativePoints_izsj() throws Exception {
        // Create CourseManager instance and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create a Course and Student
        Course course = new Course("CS101", "Computer Science 101", 2);
        Student student = new Student("S1", "student@example.com", "John Doe", 5);

        // Add Course and Student to CourseManager
        courseManager.addCourse(course);
        courseManager.addStudent(student);

        // Attempt to enroll the student with negative credits
        boolean result = courseManager.enrollStudentInCourse(student, "CS101", -1);

        // Assert that enrollment fails due to negative points
        Assertions.assertFalse(result);
    }

    @Test
    public void testDropStudentEnrollmentCourseWhenCourseIsClosed_cc7h() throws Exception {
        // Create CourseManager instance and set it to closed
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, false);

        // Create a Course and Student
        Course course = new Course("CS101", "Computer Science 101", 2);
        Student student = new Student("S3", "student3@example.com", "Mark Smith", 10);
        courseManager.addCourse(course);
        courseManager.addStudent(student);

        // Enroll the student first
        courseManager.enrollStudentInCourse(student, "CS101", 5);

        // Attempt to drop the course
        boolean result = courseManager.dropStudentEnrollmentCourse(student, "CS101");

        // Assert that dropping fails because the course selection is closed
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetEnrolledCoursesWithCreditsWhenClosed_a78l() throws Exception {
        // Create CourseManager instance and set it to closed
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, false);

        // Create a Course and Student
        Course course = new Course("CS101", "Computer Science 101", 2);
        Student student = new Student("S4", "student4@example.com", "Lucy Brown", 10);
        courseManager.addCourse(course);
        courseManager.addStudent(student);

        // Enroll the student first
        courseManager.enrollStudentInCourse(student, "CS101", 5);

        // Attempt to get enrolled courses with credits when the selection is closed
        ArrayList<String> enrolledCourses = courseManager.getEnrolledCoursesWithCredits(student);

        // Assert that the result is null since course selection is closed
        Assertions.assertNull(enrolledCourses);
    }

    @Test
    public void testEnrollStudentInCourseAndDrop_xdc5() throws Exception {
        // Create CourseManager, Course, and Student instances
        CourseManager courseManager = new CourseManager();
        Course course = new Course("CS101", "Intro to Computer Science", 2);
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        
        // Register the course and student
        Method addCourseMethod = CourseManager.class.getDeclaredMethod("addCourse", Course.class);
        addCourseMethod.setAccessible(true);
        addCourseMethod.invoke(courseManager, course);
        
        Method addStudentMethod = CourseManager.class.getDeclaredMethod("addStudent", Student.class);
        addStudentMethod.setAccessible(true);
        addStudentMethod.invoke(courseManager, student);
        
        // Enroll student in the course with a bid of 5 credits
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student, "CS101", 5));
        
        // Verify that the student is enrolled and credits are updated
        Assertions.assertEquals(5, student.getCredits());
        Assertions.assertEquals(1, student.getEnrollCourses().size());
        
        // Drop the enrollment and check if credits are refunded
        Assertions.assertTrue(courseManager.dropStudentEnrollmentCourse(student, "CS101"));
        Assertions.assertEquals(10, student.getCredits());
        Assertions.assertEquals(0, student.getEnrollCourses().size());
    }

    @Test
    public void testModifyEnrollmentCredits_eebc() throws Exception {
        // Create CourseManager, Course, and Student instances
        CourseManager courseManager = new CourseManager();
        Course course = new Course("CS102", "Data Structures", 2);
        Student student = new Student("S002", "student2@example.com", "Jane Doe", 10);
        
        // Register the course and student
        Method addCourseMethod = CourseManager.class.getDeclaredMethod("addCourse", Course.class);
        addCourseMethod.setAccessible(true);
        addCourseMethod.invoke(courseManager, course);
        
        Method addStudentMethod = CourseManager.class.getDeclaredMethod("addStudent", Student.class);
        addStudentMethod.setAccessible(true);
        addStudentMethod.invoke(courseManager, student);
        
        // Enroll student in the course with a bid of 5 credits
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student, "CS102", 5));
        
        // Modify the bid credits to 3
        Assertions.assertTrue(courseManager.modifyStudentEnrollmentCredits(student, "CS102", 3));
        
        // Check if credits are updated correctly
        Assertions.assertEquals(7, student.getCredits());
        Assertions.assertEquals(3, course.getCredits().get(0).intValue());
    }

    @Test
    public void testGetEnrolledCoursesWithCredits_ff57() throws Exception {
        // Create CourseManager and Student instances
        CourseManager courseManager = new CourseManager();
        Student student = new Student("S003", "student3@example.com", "Alice Smith", 10);
        
        // Register the student
        Method addStudentMethod = CourseManager.class.getDeclaredMethod("addStudent", Student.class);
        addStudentMethod.setAccessible(true);
        addStudentMethod.invoke(courseManager, student);
        
        // Create and add courses
        Course course1 = new Course("CS103", "Algorithms", 3);
        Course course2 = new Course("CS104", "Operating Systems", 3);
        Method addCourseMethod = CourseManager.class.getDeclaredMethod("addCourse", Course.class);
        addCourseMethod.setAccessible(true);
        addCourseMethod.invoke(courseManager, course1);
        addCourseMethod.invoke(courseManager, course2);
        
        // Enroll in courses with credits
        courseManager.enrollStudentInCourse(student, "CS103", 4);
        courseManager.enrollStudentInCourse(student, "CS104", 6);
        
        // Retrieve enrolled courses with credits
        Method getCoursesWithScoresMethod = Student.class.getDeclaredMethod("getCoursesWithScores");
        getCoursesWithScoresMethod.setAccessible(true);
        ArrayList<String> enrolledCourses = (ArrayList<String>) getCoursesWithScoresMethod.invoke(student);
        
        // Validate results
        Assertions.assertEquals(2, enrolledCourses.size());
        Assertions.assertTrue(enrolledCourses.contains("CS103: 4"));
        Assertions.assertTrue(enrolledCourses.contains("CS104: 6"));
    }

    //@Test
    public void testFinalizeEnrollments_ej9r() throws Exception {
        // Create CourseManager and Course instances
        CourseManager courseManager = new CourseManager();
        Course course = new Course("CS105", "Software Engineering", 2);
        Student student1 = new Student("S004", "student4@example.com", "Bob Brown", 10);
        Student student2 = new Student("S005", "student5@example.com", "Eve White", 8);
        
        // Register the course and students
        Method addCourseMethod = CourseManager.class.getDeclaredMethod("addCourse", Course.class);
        addCourseMethod.setAccessible(true);
        addCourseMethod.invoke(courseManager, course);
        
        Method addStudentMethod = CourseManager.class.getDeclaredMethod("addStudent", Student.class);
        addStudentMethod.setAccessible(true);
        addStudentMethod.invoke(courseManager, student1);
        addStudentMethod.invoke(courseManager, student2);
        
        // Enroll students in the course with credits
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student1, "CS105", 5));
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student2, "CS105", 6));
        
        // Finalize enrollments
        Method finalizeEnrollmentsMethod = CourseManager.class.getDeclaredMethod("finalizeEnrollments");
        finalizeEnrollmentsMethod.setAccessible(true);
        finalizeEnrollmentsMethod.invoke(courseManager);
        
        // Check successful enrollments
        Assertions.assertEquals(1, course.getSuccessStudents().size());
        Assertions.assertTrue(course.getSuccessStudents().contains(student1));
        Assertions.assertTrue(student1.getSuccessCourses().contains(course));
        Assertions.assertFalse(student2.getSuccessCourses().contains(course));
    }

    @Test
    public void testModifyStudentEnrollmentCredits_PartlyCovered_yfaw() throws Exception {
        // Create a CourseManager instance
        CourseManager courseManager = new CourseManager();
        
        // Create a Student instance with initial credits
        Student student = new Student("S1", "student1@example.com", "Student One", 10);
        // Add the student to the CourseManager
        courseManager.addStudent(student);
        
        // Create a Course instance with a capacity
        Course course = new Course("C1", "Course One", 2);
        // Add the course to the CourseManager
        courseManager.addCourse(course);
        
        // Enroll the student in the course with 5 credits
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student, "C1", 5));
        
        // Modify the enrollment credits to 3, should succeed as credits are available
        Assertions.assertTrue(courseManager.modifyStudentEnrollmentCredits(student, "C1", 3));
        
        // Now, check if the credits have been updated correctly
        Method getCreditsMethod = Student.class.getDeclaredMethod("getCredits");
        getCreditsMethod.setAccessible(true);
        int remainingCredits = (int) getCreditsMethod.invoke(student);
        
        // The remaining credits should now be 7 (initial 10 - 3 for course)
        Assertions.assertEquals(7, remainingCredits);
    }

    @Test
    public void testDropStudentEnrollmentCourse_PartlyCovered_ir8p() throws Exception {
        // Create a CourseManager instance
        CourseManager courseManager = new CourseManager();
        
        // Create a Student instance
        Student student = new Student("S2", "student2@example.com", "Student Two", 15);
        courseManager.addStudent(student);
        
        // Create a Course instance
        Course course = new Course("C2", "Course Two", 3);
        courseManager.addCourse(course);
        
        // Enroll the student in the course
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student, "C2", 10));
        
        // Drop the student from the course
        Assertions.assertTrue(courseManager.dropStudentEnrollmentCourse(student, "C2"));
        
        // Check if the student's enrolled courses are empty
        Method getEnrollCoursesMethod = Student.class.getDeclaredMethod("getEnrollCourses");
        getEnrollCoursesMethod.setAccessible(true);
        ArrayList<Course> enrollCourses = (ArrayList<Course>) getEnrollCoursesMethod.invoke(student);
        
        // The student should have no enrolled courses now
        Assertions.assertTrue(enrollCourses.isEmpty());
    }

    @Test
    public void testFinalizeEnrollments_NotCovered_hv5e() throws Exception {
        // Create a CourseManager instance
        CourseManager courseManager = new CourseManager();
        
        // Create and add two students
        Student student1 = new Student("S3", "student3@example.com", "Student Three", 10);
        Student student2 = new Student("S4", "student4@example.com", "Student Four", 5);
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        
        // Create a Course instance with capacity
        Course course = new Course("C3", "Course Three", 1);
        courseManager.addCourse(course);
        
        // Enroll both students with different credits
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student1, "C3", 10));
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student2, "C3", 5));
        
        // Finalize enrollments to determine successful students
        courseManager.finalizeEnrollments();
        
        // Check the successStudents list in Course using reflection
        Method getSuccessStudentsMethod = Course.class.getDeclaredMethod("getSuccessStudents");
        getSuccessStudentsMethod.setAccessible(true);
        ArrayList<Student> successStudents = (ArrayList<Student>) getSuccessStudentsMethod.invoke(course);
        
        // There should only be one successful student based on the bids
        Assertions.assertEquals(1, successStudents.size());
        Assertions.assertEquals("S3", successStudents.get(0).getStudentID());
    }

    @Test
    public void testGetEnrolledCoursesWithCredits_NotCovered_o4jb() throws Exception {
        // Create a CourseManager instance
        CourseManager courseManager = new CourseManager();
        
        // Create a Student instance
        Student student = new Student("S5", "student5@example.com", "Student Five", 20);
        courseManager.addStudent(student);
        
        // Create a Course instance
        Course course = new Course("C4", "Course Four", 2);
        courseManager.addCourse(course);
        
        // Enroll the student in the course
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student, "C4", 8));
        
        // Retrieve enrolled courses with credits
        ArrayList<String> enrolledCoursesWithCredits = courseManager.getEnrolledCoursesWithCredits(student);
        
        // There should be one entry in the list
        Assertions.assertEquals(1, enrolledCoursesWithCredits.size());
        // Check the format of the returned string
        Assertions.assertEquals("C4: 8", enrolledCoursesWithCredits.get(0));
    }

    @Test
    public void testModifyStudentEnrollmentCredits_WhenCourseIsNull_ShouldReturnFalse_ehd0() throws Exception {
        // Create CourseManager instance and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create a student with sufficient credits and enroll them in a course
        Student student = new Student("S002", "student2@example.com", "Student Two", 10);
        Course course = new Course("C002", "Course Two", 5);
        Method addStudentMethod = CourseManager.class.getDeclaredMethod("addStudent", Student.class);
        addStudentMethod.setAccessible(true);
        addStudentMethod.invoke(courseManager, student);
        Method addCourseMethod = CourseManager.class.getDeclaredMethod("addCourse", Course.class);
        addCourseMethod.setAccessible(true);
        addCourseMethod.invoke(courseManager, course);
        courseManager.enrollStudentInCourse(student, "C002", 5);

        // Modify credits for a course that is null
        boolean result = courseManager.modifyStudentEnrollmentCredits(student, "C003", 3);

        // Assert that modifying credits returns false
        Assertions.assertFalse(result);
    }

    @Test
    public void testDropStudentEnrollmentCourse_WhenCourseIsNull_ShouldReturnFalse_kwcu() throws Exception {
        // Create CourseManager instance and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create a student and enroll them in a course
        Student student = new Student("S003", "student3@example.com", "Student Three", 10);
        Course course = new Course("C003", "Course Three", 5);
        Method addStudentMethod = CourseManager.class.getDeclaredMethod("addStudent", Student.class);
        addStudentMethod.setAccessible(true);
        addStudentMethod.invoke(courseManager, student);
        Method addCourseMethod = CourseManager.class.getDeclaredMethod("addCourse", Course.class);
        addCourseMethod.setAccessible(true);
        addCourseMethod.invoke(courseManager, course);
        courseManager.enrollStudentInCourse(student, "C003", 5);

        // Drop a course that is null
        boolean result = courseManager.dropStudentEnrollmentCourse(student, "C004");

        // Assert that dropping enrollment returns false
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetEnrolledCoursesWithCredits_WhenIfOpenIsFalse_ShouldReturnNull_2g6u() throws Exception {
        // Create CourseManager instance and set it to closed
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, false);

        // Create a student and enroll them in a course
        Student student = new Student("S004", "student4@example.com", "Student Four", 10);
        Course course = new Course("C004", "Course Four", 5);
        Method addStudentMethod = CourseManager.class.getDeclaredMethod("addStudent", Student.class);
        addStudentMethod.setAccessible(true);
        addStudentMethod.invoke(courseManager, student);
        Method addCourseMethod = CourseManager.class.getDeclaredMethod("addCourse", Course.class);
        addCourseMethod.setAccessible(true);
        addCourseMethod.invoke(courseManager, course);
        courseManager.enrollStudentInCourse(student, "C004", 5);

        // Attempt to get enrolled courses when ifOpen is false
        ArrayList<String> enrolledCourses = courseManager.getEnrolledCoursesWithCredits(student);
        
        // Assert that the result is null
        Assertions.assertNull(enrolledCourses);
    }

    @Test
    public void testModifyStudentEnrollmentCredits_PartlyCovered_1ord() throws Exception {
        // Create CourseManager, Student, and Course instances.
        CourseManager courseManager = new CourseManager();
        Student student = new Student("S1", "student1@example.com", "Student One", 10);
        Course course = new Course("C1", "Course One", 2);

        // Register the student and course to the CourseManager.
        courseManager.addStudent(student);
        courseManager.addCourse(course);

        // Open the course selection phase.
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Enroll the student in the course with a bid of 5 credits.
        courseManager.enrollStudentInCourse(student, "C1", 5);

        // Modify the enrollment credits from 5 to 3.
        Assertions.assertTrue(student.modifyEnrollCredit("C1", 3));
    }

    @Test
    public void testDropStudentEnrollmentCourse_NotCovered_r4uz() throws Exception {
        // Setup the CourseManager, Student, and Course.
        CourseManager courseManager = new CourseManager();
        Student student = new Student("S2", "student2@example.com", "Student Two", 15);
        Course course = new Course("C2", "Course Two", 2);
        
        // Register student and course.
        courseManager.addStudent(student);
        courseManager.addCourse(course);
        
        // Open the selection phase.
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);
        
        // Enroll the student in the course.
        courseManager.enrollStudentInCourse(student, "C2", 5);
        
        // Drop the student's enrollment.
        Assertions.assertTrue(courseManager.dropStudentEnrollmentCourse(student, "C2"));
        
        // Check if the student is no longer enrolled in the course.
        Assertions.assertTrue(student.getEnrollCourses().isEmpty());
        Assertions.assertEquals(15, student.getCredits()); // Credits should remain unchanged after drop.
    }

    @Test
    public void testGetEnrolledCoursesWithCredits_PartlyCovered_f6bt() throws Exception {
        // Initialize CourseManager, Student, and Course.
        CourseManager courseManager = new CourseManager();
        Student student = new Student("S3", "student3@example.com", "Student Three", 20);
        Course course = new Course("C3", "Course Three", 3);
        
        // Register student and course.
        courseManager.addStudent(student);
        courseManager.addCourse(course);
        
        // Open the course selection phase.
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);
        
        // Enroll the student with 10 credits.
        courseManager.enrollStudentInCourse(student, "C3", 10);
        
        // Retrieve the list of enrolled courses with credits.
        ArrayList<String> enrolledCourses = courseManager.getEnrolledCoursesWithCredits(student);
        
        // Validate the enrollment string.
        Assertions.assertEquals("C3: 10", enrolledCourses.get(0));
    }

    //@Test
    public void testFinalizeEnrollments_NotCovered_kyl1() throws Exception {
        // Create CourseManager and two Students.
        CourseManager courseManager = new CourseManager();
        Student student1 = new Student("S4", "student4@example.com", "Student Four", 10);
        Student student2 = new Student("S5", "student5@example.com", "Student Five", 15);
        
        // Create a Course with limited capacity.
        Course course = new Course("C4", "Course Four", 1);
        
        // Register students and course.
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addCourse(course);
        
        // Open the selection phase.
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);
        
        // Enroll both students with different credits.
        courseManager.enrollStudentInCourse(student1, "C4", 10);
        courseManager.enrollStudentInCourse(student2, "C4", 15);
        
        // Finalize enrollments to determine who gets in.
        courseManager.finalizeEnrollments();
        
        // Assert that only one student is successfully enrolled based on credits.
        Assertions.assertEquals(1, course.getSuccessStudents().size());
        Assertions.assertEquals("S4", course.getSuccessStudents().get(0).getStudentID()); // Assuming student1 wins due to higher credits.
    }

    //@Test
    public void testModifyStudentEnrollmentCredits_xqbz() throws Exception {
        // Create a CourseManager instance and open the course selection
        CourseManager manager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(manager, true);

        // Create a Course and a Student, and register them
        Course course = new Course("CS101", "Computer Science 101", 30);
        Student student = new Student("S001", "student@example.com", "John Doe", 100);
        manager.addCourse(course);
        manager.addStudent(student);

        // Enroll the student in the course with an initial bid
        boolean enrolled = manager.enrollStudentInCourse(student, "CS101", 50);
        Assertions.assertTrue(enrolled, "The student should be successfully enrolled.");

        // Modify the bid for the already enrolled course
        boolean modified = manager.modifyStudentEnrollmentCredits(student, "CS101", 30);
        Assertions.assertTrue(modified, "The student's enrollment credits should be modified successfully.");

        // Check if the credits were updated correctly
        Method getCreditsMethod = Student.class.getDeclaredMethod("getCredits");
        getCreditsMethod.setAccessible(true);
        int remainingCredits = (int) getCreditsMethod.invoke(student);
        Assertions.assertEquals(20, remainingCredits, "The remaining credits should be 20 after modification.");

        // Ensure the course's credit list is updated
        Method getCreditsMethodCourse = Course.class.getDeclaredMethod("getCredits");
        getCreditsMethodCourse.setAccessible(true);
        ArrayList<Integer> courseCredits = (ArrayList<Integer>) getCreditsMethodCourse.invoke(course);
        Assertions.assertTrue(courseCredits.contains(30), "The course should reflect the modified credits.");
    }

    @Test
    public void testDropStudentEnrollmentCourse_e7c3() throws Exception {
        // Create a CourseManager instance and open the course selection
        CourseManager manager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(manager, true);

        // Create a Course and a Student, and register them
        Course course = new Course("CS102", "Computer Science 102", 30);
        Student student = new Student("S002", "student2@example.com", "Jane Doe", 100);
        manager.addCourse(course);
        manager.addStudent(student);

        // Enroll the student in the course
        boolean enrolled = manager.enrollStudentInCourse(student, "CS102", 50);
        Assertions.assertTrue(enrolled, "The student should be successfully enrolled.");

        // Drop the student's enrollment from the course
        boolean dropped = manager.dropStudentEnrollmentCourse(student, "CS102");
        Assertions.assertTrue(dropped, "The student should successfully drop the course.");

        // Check if the student's enrollments are updated
        Method getEnrollCoursesMethod = Student.class.getDeclaredMethod("getEnrollCourses");
        getEnrollCoursesMethod.setAccessible(true);
        ArrayList<Course> enrolledCourses = (ArrayList<Course>) getEnrollCoursesMethod.invoke(student);
        Assertions.assertTrue(enrolledCourses.isEmpty(), "The student should have no enrolled courses after dropping.");
    }

    @Test
    public void testGetEnrolledCoursesWithCredits_7e3e() throws Exception {
        // Create a CourseManager instance and open the course selection
        CourseManager manager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(manager, true);

        // Create a Course and a Student, and register them
        Course course = new Course("CS103", "Computer Science 103", 30);
        Student student = new Student("S003", "student3@example.com", "Alice Smith", 100);
        manager.addCourse(course);
        manager.addStudent(student);

        // Enroll the student in the course with a bid
        boolean enrolled = manager.enrollStudentInCourse(student, "CS103", 40);
        Assertions.assertTrue(enrolled, "The student should be successfully enrolled.");

        // Retrieve the enrolled courses with credits
        ArrayList<String> enrolledCourses = manager.getEnrolledCoursesWithCredits(student);
        Assertions.assertNotNull(enrolledCourses, "The list of enrolled courses should not be null.");
        Assertions.assertEquals(1, enrolledCourses.size(), "The student should have one enrolled course.");
        Assertions.assertEquals("CS103: 40", enrolledCourses.get(0), "The enrolled course details are incorrect.");
    }

    //@Test
    public void testFinalizeEnrollments_43c8() throws Exception {
        // Create a CourseManager instance and open the course selection
        CourseManager manager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(manager, true);

        // Create Courses and Students
        Course course1 = new Course("CS104", "Computer Science 104", 2);
        Course course2 = new Course("CS105", "Computer Science 105", 2);
        Student student1 = new Student("S004", "student4@example.com", "Bob Brown", 100);
        Student student2 = new Student("S005", "student5@example.com", "Charlie Green", 80);
        Student student3 = new Student("S006", "student6@example.com", "Daisy White", 60);
        
        // Register courses and students
        manager.addCourse(course1);
        manager.addCourse(course2);
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        // Enroll students with different bids
        manager.enrollStudentInCourse(student1, "CS104", 50);
        manager.enrollStudentInCourse(student2, "CS104", 50);
        manager.enrollStudentInCourse(student3, "CS104", 50); // Should be dropped due to capacity

        // Finalize enrollments
        Method finalizeEnrollmentsMethod = CourseManager.class.getDeclaredMethod("finalizeEnrollments");
        finalizeEnrollmentsMethod.setAccessible(true);
        finalizeEnrollmentsMethod.invoke(manager);

        // Check successful enrollments for the course
        Method getSuccessStudentsMethod = Course.class.getDeclaredMethod("getSuccessStudents");
        getSuccessStudentsMethod.setAccessible(true);
        ArrayList<Student> successStudents = (ArrayList<Student>) getSuccessStudentsMethod.invoke(course1);
        Assertions.assertEquals(2, successStudents.size(), "There should be 2 successful students in the course.");
    }

    @Test
    public void testModifyStudentEnrollmentCreditsWhenIfOpenFalse_53lt() throws Exception {
        // Create CourseManager instance
        CourseManager courseManager = new CourseManager();
        // Create a Course and Student
        Course course = new Course("CS101", "Computer Science 101", 30);
        Student student = new Student("S1", "student@example.com", "John Doe", 100);
        
        // Register Course and Student
        courseManager.addCourse(course);
        courseManager.addStudent(student);
        
        // Enroll student in the course with some credits
        courseManager.enrollStudentInCourse(student, "CS101", 20);
        
        // Close the course selection phase
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, false);
        
        // Attempt to modify the credits while ifOpen is false
        boolean result = (boolean) CourseManager.class.getDeclaredMethod("modifyStudentEnrollmentCredits", Student.class, String.class, int.class)
                .invoke(courseManager, student, "CS101", 30);
        
        // Verify that the modification was not successful
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetEnrolledCoursesWithCreditsWhenIfOpenFalse_gzmf() throws Exception {
        // Create CourseManager instance
        CourseManager courseManager = new CourseManager();
        // Create a Course and Student
        Course course = new Course("CS102", "Computer Science 102", 30);
        Student student = new Student("S2", "student2@example.com", "Jane Doe", 100);
        
        // Register Course and Student
        courseManager.addCourse(course);
        courseManager.addStudent(student);
        
        // Enroll student in the course with some credits
        courseManager.enrollStudentInCourse(student, "CS102", 25);
        
        // Close the course selection phase
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, false);
        
        // Attempt to get enrolled courses with credits while ifOpen is false
        ArrayList<String> enrolledCourses = (ArrayList<String>) CourseManager.class.getDeclaredMethod("getEnrolledCoursesWithCredits", Student.class)
                .invoke(courseManager, student);
        
        // Verify that the result is null since ifOpen is false
        Assertions.assertNull(enrolledCourses);
    }

    @Test
    public void testFinalizeEnrollmentsWithMultipleStudents_53bx() throws Exception {
        // Create CourseManager instance
        CourseManager courseManager = new CourseManager();
        // Create a Course
        Course course = new Course("CS104", "Computer Science 104", 2); // Capacity of 2
        courseManager.addCourse(course);
        
        // Create and register multiple Students
        Student student1 = new Student("S4", "student4@example.com", "Alice Doe", 100);
        Student student2 = new Student("S5", "student5@example.com", "Bob Doe", 90);
        Student student3 = new Student("S6", "student6@example.com", "Charlie Doe", 80);
        
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addStudent(student3);
        
        // Open the course selection phase
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);
        
        // Enroll students in the course with different credits
        courseManager.enrollStudentInCourse(student1, "CS104", 30);
        courseManager.enrollStudentInCourse(student2, "CS104", 40);
        courseManager.enrollStudentInCourse(student3, "CS104", 20); // This one should not be successful due to capacity
        
        // Finalize enrollments
        Method finalizeEnrollmentsMethod = CourseManager.class.getDeclaredMethod("finalizeEnrollments");
        finalizeEnrollmentsMethod.setAccessible(true);
        finalizeEnrollmentsMethod.invoke(courseManager);
        
        // Verify that only two students are successfully enrolled
        ArrayList<Student> successStudents = (ArrayList<Student>) Course.class.getDeclaredMethod("getSuccessStudents")
                .invoke(course);
        
        Assertions.assertEquals(2, successStudents.size());
        Assertions.assertTrue(successStudents.contains(student1));
        Assertions.assertTrue(successStudents.contains(student2));
        Assertions.assertFalse(successStudents.contains(student3));
    }

    @Test
    public void testEnrollStudentInCourseAndModifyEnrollmentCredits_2gqk() throws Exception {
        // Initialize CourseManager and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create a course and add it to the CourseManager
        Course course = new Course("CS101", "Intro to CS", 2);
        courseManager.addCourse(course);

        // Create a student and add them to the CourseManager
        Student student = new Student("S001", "student@example.com", "John Doe", 10);
        courseManager.addStudent(student);

        // Enroll the student in the course with a bid of 5 credits
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student, "CS101", 5));

        // Modify the student's enrollment credits for the same course to 7 credits
        Assertions.assertTrue(courseManager.modifyStudentEnrollmentCredits(student, "CS101", 7));

        // Check if the credits of the student are updated correctly
        Method getCreditsMethod = Student.class.getDeclaredMethod("getCredits");
        getCreditsMethod.setAccessible(true);
        int remainingCredits = (int) getCreditsMethod.invoke(student);
        Assertions.assertEquals(3, remainingCredits); // 10 - 7 = 3

        // Check if the credits in the course are updated correctly
        Method getCreditsMethodCourse = Course.class.getDeclaredMethod("getCredits");
        getCreditsMethodCourse.setAccessible(true);
        ArrayList<Integer> courseCredits = (ArrayList<Integer>) getCreditsMethodCourse.invoke(course);
        Assertions.assertEquals(7, courseCredits.get(0)); // Should be 7
    }

    //@Test
    public void testDropStudentEnrollmentCourseAndGetEnrolledCoursesWithCredits_6a60() throws Exception {
        // Initialize CourseManager and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create a course and add it to the CourseManager
        Course course = new Course("CS102", "Data Structures", 2);
        courseManager.addCourse(course);

        // Create a student and add them to the CourseManager
        Student student = new Student("S002", "student2@example.com", "Jane Doe", 10);
        courseManager.addStudent(student);

        // Enroll the student in the course with a bid of 5 credits
        Assertions.assertTrue(courseManager.enrollStudentInCourse(student, "CS102", 5));

        // Drop the student from the course
        Assertions.assertTrue(courseManager.dropStudentEnrollmentCourse(student, "CS102"));

        // Verify that the student's credits are refunded
        Method getCreditsMethod = Student.class.getDeclaredMethod("getCredits");
        getCreditsMethod.setAccessible(true);
        int remainingCredits = (int) getCreditsMethod.invoke(student);
        Assertions.assertEquals(10, remainingCredits); // Should be 10 after refund

        // Verify that the enrolled courses list is empty
        Method getEnrolledCoursesWithCreditsMethod = CourseManager.class.getDeclaredMethod("getEnrolledCoursesWithCredits", Student.class);
        getEnrolledCoursesWithCreditsMethod.setAccessible(true);
        ArrayList<String> enrolledCourses = (ArrayList<String>) getEnrolledCoursesWithCreditsMethod.invoke(courseManager, student);
        Assertions.assertNull(enrolledCourses); // Should return null since course was dropped
    }

    @Test
    public void testFinalizeEnrollments_m6jc() throws Exception {
        // Initialize CourseManager and set it to open
        CourseManager courseManager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(courseManager, true);

        // Create courses and add them to the CourseManager
        Course course1 = new Course("CS103", "Algorithms", 2);
        Course course2 = new Course("CS104", "Operating Systems", 2);
        courseManager.addCourse(course1);
        courseManager.addCourse(course2);

        // Create students and add them to the CourseManager
        Student student1 = new Student("S003", "student3@example.com", "Alice", 10);
        Student student2 = new Student("S004", "student4@example.com", "Bob", 10);
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);

        // Enroll students in courses
        courseManager.enrollStudentInCourse(student1, "CS103", 6);
        courseManager.enrollStudentInCourse(student2, "CS103", 5); // Bob should be enrolled as well

        // Finalize enrollments
        Method finalizeEnrollmentsMethod = CourseManager.class.getDeclaredMethod("finalizeEnrollments");
        finalizeEnrollmentsMethod.setAccessible(true);
        finalizeEnrollmentsMethod.invoke(courseManager);

        // Check success students in the course
        Method getSuccessStudentsMethod = Course.class.getDeclaredMethod("getSuccessStudents");
        getSuccessStudentsMethod.setAccessible(true);
        ArrayList<Student> successStudents = (ArrayList<Student>) getSuccessStudentsMethod.invoke(course1);
        Assertions.assertEquals(2, successStudents.size()); // Both should be enrolled
    }

    @Test
    public void testGetStudentsAndCourses_6cdr() throws Exception {
        // Initialize CourseManager and set it to open
        CourseManager courseManager = new CourseManager();

        // Create a course and add it to the CourseManager
        Course course = new Course("CS105", "Software Engineering", 2);
        courseManager.addCourse(course);

        // Create a student and add them to the CourseManager
        Student student = new Student("S005", "student5@example.com", "Charlie", 10);
        courseManager.addStudent(student);

        // Access students list and assert it contains the added student
        Method getStudentsMethod = CourseManager.class.getDeclaredMethod("getStudents");
        getStudentsMethod.setAccessible(true);
        ArrayList<Student> students = (ArrayList<Student>) getStudentsMethod.invoke(courseManager);
        Assertions.assertTrue(students.contains(student)); // Student should be in the list

        // Access courses list and assert it contains the added course
        Method getCoursesMethod = CourseManager.class.getDeclaredMethod("getCourses");
        getCoursesMethod.setAccessible(true);
        ArrayList<Course> courses = (ArrayList<Course>) getCoursesMethod.invoke(courseManager);
        Assertions.assertTrue(courses.contains(course)); // Course should be in the list
    }

    @Test
    public void testModifyStudentEnrollmentCredits_NotEnrolled_ceuy() throws Exception {
        // Create CourseManager instance and set it open
        CourseManager manager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(manager, true);

        // Create a student and add to CourseManager
        Student student = new Student("S1", "email@example.com", "Student One", 10);
        manager.addStudent(student);

        // Create a course and add to CourseManager
        Course course = new Course("C1", "Course One", 30);
        manager.addCourse(course);

        // Attempt to modify credits for a course not enrolled in
        boolean result = (boolean) CourseManager.class.getDeclaredMethod("modifyStudentEnrollmentCredits", Student.class, String.class, int.class)
                .invoke(manager, student, "C1", 5);

        // Assert that modification failed as student is not enrolled
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetEnrolledCoursesWithCredits_WhileClosed_pc6o() throws Exception {
        // Create CourseManager instance and set it closed
        CourseManager manager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(manager, false);

        // Create a student and add to CourseManager
        Student student = new Student("S2", "email@example.com", "Student Two", 15);
        manager.addStudent(student);

        // Attempt to get enrolled courses while system is closed
        ArrayList<String> enrolledCourses = (ArrayList<String>) CourseManager.class.getDeclaredMethod("getEnrolledCoursesWithCredits", Student.class)
                .invoke(manager, student);

        // Assert that the result is null as the system is closed
        Assertions.assertNull(enrolledCourses);
    }

    @Test
    public void testDropStudentEnrollmentCourse_NotEnrolled_r5e5() throws Exception {
        // Create CourseManager instance and set it open
        CourseManager manager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(manager, true);

        // Create a student and add to CourseManager
        Student student = new Student("S3", "email@example.com", "Student Three", 20);
        manager.addStudent(student);

        // Create a course and add to CourseManager
        Course course = new Course("C2", "Course Two", 30);
        manager.addCourse(course);

        // Attempt to drop a course that student is not enrolled in
        boolean result = (boolean) CourseManager.class.getDeclaredMethod("dropStudentEnrollmentCourse", Student.class, String.class)
                .invoke(manager, student, "C2");

        // Assert that the drop operation failed
        Assertions.assertFalse(result);
    }

    //@Test
    public void testFinalizeEnrollments_CreditsBoundary_2v6w() throws Exception {
        // Create CourseManager instance and set it open
        CourseManager manager = new CourseManager();
        Method setIfOpenMethod = CourseManager.class.getDeclaredMethod("setIfOpen", Boolean.class);
        setIfOpenMethod.setAccessible(true);
        setIfOpenMethod.invoke(manager, true);

        // Create students with specific credits
        Student student1 = new Student("S4", "email@example.com", "Student Four", 5);
        Student student2 = new Student("S5", "email@example.com", "Student Five", 5);
        manager.addStudent(student1);
        manager.addStudent(student2);

        // Create a course with a max capacity of 1
        Course course = new Course("C3", "Course Three", 1);
        manager.addCourse(course);

        // Students attempt to enroll with the same credits
        manager.enrollStudentInCourse(student1, "C3", 5);
        manager.enrollStudentInCourse(student2, "C3", 5);

        // Finalize enrollments
        manager.finalizeEnrollments();

        // Use reflection to access successStudents from Course
        Method getSuccessStudentsMethod = Course.class.getDeclaredMethod("getSuccessStudents");
        getSuccessStudentsMethod.setAccessible(true);
        ArrayList<Student> successStudents = (ArrayList<Student>) getSuccessStudentsMethod.invoke(course);

        // Assert that only one student is successfully enrolled
        Assertions.assertEquals(1, successStudents.size());
    }


}
