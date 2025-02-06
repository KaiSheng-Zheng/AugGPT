


import java.util.ArrayList;

import java.util.List;

public class CourseManager {
    // Maintains a record of all courses successfully registered.
    // It is guaranteed that students enrolled in a course must exist in students.
    private List<Course> courses;
    // Maintains a record of all students successfully registered.
    // It is guaranteed that courses student enrolled in must exist in courses.
    private List<Student> students;
    // Represent system open(true) or not(false).
    private boolean isOpen;

    public CourseManager(boolean isOpen) {
        this.isOpen = isOpen;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // Constructor, initializes the course and student lists, and set the system
    //default status open(true).
    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        isOpen = true;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return isOpen;
    }

    public void setIfOpen(boolean open) {
        isOpen = open;
    }

    /**
     * Register a course. Add a course object to courses and set the courseManager
     * of the course object to this manager. It is guaranteed that all courseIDs are
     * unique.
     */
    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    /**
     * Register a course. Add a student object to students and set the courseManager
     * of the student object to this manager. It is guaranteed that all studentIDs are
     * unique.
     *
     * @param student
     */
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not
     * already enrolled, the credits is greater than 0, and they have enough credits to
     * bid.
     * If successful, the student's credits will be reduced by the amount bid on the
     * course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if student enroll this course successfully;
     * otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int points) {
        if (!isOpen)
            return false;

        if(points<0)
            return false;
        // check course exists
        Course course = isCourseExists(courseId);
        if (course == null)
            return false;
        // check the student has not already enrolled
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                return false;
            }
        }
        //the credits is greater than 0, and they have enough credits to bid.
        if (student.getCredits() <= 0 || student.getCredits() - points < 0) {
            return false;
        }
        //If successful, the student's credits will be reduced by the amount bid on the course.
        student.setCredits(student.getCredits() - points);
        //The corresponding list in Student and Course should be updated.
        course.getEnrollStudent().add(student);
        course.getCredits().add(points);
        student.getEnrollCourses().add(course);

        return true;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled
     * course.
     * The modification will only be successful if the course exists, the student is
     * currently enrolled in the course,and the new bid is within the student's
     * available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to
     * reflect the new bid amount. The corresponding list in Student and Course should
     * be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the bid modification was successful;
     * otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,
                                                  int credits) {
        if (!isOpen)
            return false;
        //The modification will only be successful if the course exists
        Course course = isCourseExists(courseId);
        if (course == null)
            return false;
        //the student is currently enrolled in the course
        Course enrolledCourse = getEnrolledCourse(student, courseId);
        if (enrolledCourse == null)
            return false;
        //new bid is within the student's available credits
        int index = getEnrolledCourseIndex(enrolledCourse, student);
        int credit = enrolledCourse.getCredits().get(index);
        if ((student.getCredits() + credit - credits) < 0)
            return false;
        // This can be used to increase or decrease the bid.
        student.setCredits(student.getCredits() + credit - credits);
        course.getCredits().set(index, credits);
        return true;
    }


    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently
     * enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid
     * for this course will be refunded in full. The corresponding list in Student and
     * Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the student successfully drops the course;
     * otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student s, String courseId) {
        if (!isOpen)
            return false;
        //The drop will succeed only if the course exists
        Course course = isCourseExists(courseId);
        if (course == null)
            return false;
        //  the student is currently enrolled in it.
        Course enrolledCourse = getEnrolledCourse(s, courseId);
        if (enrolledCourse == null)
            return false;
        //course will be refunded in full
        int index = getEnrolledCourseIndex(enrolledCourse, s);
        int courseCredits = enrolledCourse.getCredits().remove(index);
        enrolledCourse.getEnrollStudent().remove(index);
        s.getEnrollCourses().remove(enrolledCourse);
        s.setCredits(s.getCredits() + courseCredits);
        return true;
    }

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the
     * student in enrollCourses, follow the format: "courseID: enrollmentCredits"
     * (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     *
     * @return A list of Strings, each representing the courses and the respective
     * credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!isOpen) {
            return null;
        }
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course course = student.getEnrollCourses().get(i);
            int credits = getStudentCourseCredits(student, course);
            results.add(String.format("%s: %d",
                    student.getEnrollCourses().get(i).getCourseID(), credits));
        }
        return results;
    }

    private int getStudentCourseCredits(Student s, Course c) {
        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
            if (s.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                return c.getCredits().get(i);
            }
        }
        return -1;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids
     * and the course capacities. Students with higher bids are prioritized.
     * The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need
     * to be updated.
     */
    public void finalizeEnrollments() {
        this.isOpen = false;
        for (Course c : courses) {
            int minCredit = getSuccessCredits(c);
            if (minCredit == 0) {
                c.getSuccessStudents().addAll(c.getEnrollStudent());
            } else {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    int credit = c.getCredits().get(i);
                    Student student = c.getEnrollStudent().get(i);
                    if (credit >= minCredit) {
                        c.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(c);
                    }
                }
            }
        }
    }

    private int getSuccessCredits(Course course) {
        int size = course.getMaxCapacity();
        if (course.getEnrollStudent().size() <= size)
            return 0;
        ArrayList<Integer> credits = new ArrayList<>(course.getCredits());
        credits.sort((o1, o2) -> o2 - o1);
        int minCredits = credits.get(size - 1);
        if (minCredits == credits.get(size)) {
            return minCredits + 1;
        } else {
            return minCredits;
        }
    }



    private Course isCourseExists(String courseId) {
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        return course;
    }

    private Course getEnrolledCourse(Student student, String courseId) {
        Course enrolledCourse = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                enrolledCourse = c;
                break;
            }
        }
        return enrolledCourse;
    }

    private static int getEnrolledCourseIndex(Course c, Student s) {
        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
            if (c.getEnrollStudent().get(i).getStudentID().equals(s.getStudentID())) {
                return i;
            }
        }
        return 0;
    }

}