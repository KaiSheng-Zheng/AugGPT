import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseManager {
    private ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.
    // It is guaranteed that students enrolled in a course must exist in students.

    private ArrayList<Student> students;
    // Maintains a record of all students successfully registered.
    // It is guaranteed that courses student enrolled in must exist in courses.

    private boolean ifOpen;
    // Represent system open(true) or not(false).

    // Constructor, initializes the course and student lists, and set the system default status open(true).
    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }
// getter for students

    public ArrayList<Course> getCourses() {
        return this.courses;
    }
// getter for courses

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
// setter for ifOpen

    public boolean getIfOpen() {
        return this.ifOpen;
    }
// getter for ifOpen

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getCourseID().equals(courseId)) {
                course = this.courses.get(i);
                break;
            }
        }
        if (course == null) {
            return false;
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                return false;
            }
        }
        if (credits <= 0) {
            return false;
        }
        if (credits > student.getCredits()) {
            return false;
        }

        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getCourseID().equals(courseId)) {
                course = this.courses.get(i);
                break;
            }
        }
        if (course == null) {
            return false;
        }
        boolean b = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                b = true;
                break;
            }
        }
        if (!b) {
            return false;
        }
        int bid = 0;
        // get the credit the student bid before
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                bid = course.getCredits().get(i);
                break;
            }
        }
        int bidBefore = student.getCredits() + bid;
        if (bidBefore < credits) {
            return false;
        }

        student.setCredits(bidBefore - credits);
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                course.getCredits().set(i, credits);
                break;
            }
        }
        return true;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getCourseID().equals(courseId)) {
                course = this.courses.get(i);
                break;
            }
        }
        if (course == null) {
            return false;
        }
        boolean b = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                b = true;
                break;
            }
        }
        if (!b) {
            return false;
        }

        int bid = 0;
        int idx = -1;
        // get the credit the student bid before
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                bid = course.getCredits().get(i);
                idx = i;
                break;
            }
        }
        student.setCredits(student.getCredits() + bid);
        student.getEnrollCourses().remove(course);
        course.getEnrollStudent().remove(idx);
        course.getCredits().remove(idx);
        return true;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (int i = 0; i < this.courses.size(); i++) {
            Course course = this.courses.get(i);
            List<Pair> list = new ArrayList<>();
            for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                list.add(new Pair(course.getEnrollStudent().get(j), course.getCredits().get(j)));
            }
            Collections.sort(list);
            if (list.size() <= course.getMaxCapacity()) {
                for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                    course.getSuccessStudents().add(course.getEnrollStudent().get(j));
                }
            } else {
                int line = list.get(course.getMaxCapacity()).credit;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).credit > line) {
                        course.getSuccessStudents().add(list.get(j).student);
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < this.students.size(); i++) {
            Student student = this.students.get(i);
            for (int j = 0; j < this.courses.size(); j++) {
                Course course = this.courses.get(j);
                if (course.getSuccessStudents().contains(student)) {
                    student.getSuccessCourses().add(course);
                }
            }
        }
    }

    class Pair implements Comparable<Pair> {
        Student student;
        int credit;

        public Pair(Student student, int credit) {
            this.student = student;
            this.credit = credit;
        }

        @Override
        public int compareTo(Pair o) {
            return o.credit - this.credit;
        }
    }

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < this.courses.size(); i++) {
            Course course = this.courses.get(i);
            int idx = -1;
            for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                if (course.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                    idx = j;
                    break;
                }
            }
            if (idx != -1) {
                ans.add(course.getCourseID() + ": " + course.getCredits().get(idx));
            }
        }
        return ans;
    }
}
