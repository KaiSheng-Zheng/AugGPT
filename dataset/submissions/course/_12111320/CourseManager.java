import java.util.ArrayList;
import java.util.Comparator;

public class CourseManager {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setCourseManager(this);

    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
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
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }

        Course course = getCourseById(courseId);
        if (course == null) {
            return false;
        }

        if (student.getEnrollCourses().contains(course)) {
            return false;
        }

        if (student.getCredits() >= credits) {
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(course);
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            return true;
        }

        return false;
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
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }

        Course course = getCourseById(courseId);
        if (course == null) {
            return false;
        }

        if (!student.getEnrollCourses().contains(course)) {
            return false;
        }

//        int index = student.getEnrollCourses().indexOf(course);
//        int oldCredits = course.getCredits().get(index);
//        if (student.getCredits() + oldCredits >= credits) {
//            student.setCredits(student.getCredits() - (credits - oldCredits));
//            course.getCredits().set(index, credits);
//            return true;
//        }
//        int index = student.getEnrollCourses().indexOf(course);
        int index = course.getEnrollStudent().indexOf(student);

        if (index >= 0) {
            int oldCredits = course.getCredits().get(index);
            if (student.getCredits() + oldCredits >= credits) {
                student.setCredits(student.getCredits() + (credits - oldCredits));
                course.getCredits().set(index, credits);
                return true;
            }
        }

        return false;
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
//    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
//        if (!ifOpen) {
//            return false;
//        }
//
//        Course course = getCourseById(courseId);
//        if (course == null) {
//            return false;
//        }
//
//        if (!student.getEnrollCourses().contains(course)) {
//            return false;
//        }
//
//        int index = student.getEnrollCourses().indexOf(course);
//        student.setCredits(student.getCredits() + course.getCredits().get(index));
//        student.getEnrollCourses().remove(course);
//        course.getEnrollStudent().remove(student);
//        course.getCredits().remove(index);
//        return true;
//    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }

        Course course = getCourseById(courseId);
        if (course == null) {
            return false;
        }

        if (!student.getEnrollCourses().contains(course)) {
            return false;
        }

        int index = student.getEnrollCourses().indexOf(course);
        student.getEnrollCourses().remove(course);
        course.getEnrollStudent().remove(student);
        course.getCredits().remove(index);

        if (index >= 0 && index < course.getCredits().size()) {
            student.setCredits(student.getCredits() + course.getCredits().get(index));
        }
        return true;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids
     * and the course capacities. Students with higher bids are prioritized. The
     * corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need
     * to be updated.
     */
    public void finalizeEnrollments() {
        ifOpen = false;

        for (Course course : courses) {
            course.getEnrollStudent().sort(Comparator.comparingInt(Student::getCredits).reversed());

            int successfulStudents = 0;
            ArrayList<Student> newEnrollStudentList = new ArrayList<>();
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                Student student = course.getEnrollStudent().get(i);
                if (successfulStudents < course.getMaxCapacity()) {
                    successfulStudents++;
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                    newEnrollStudentList.add(student);
                } else if (successfulStudents == course.getMaxCapacity()) {
                    if (student.getCredits() == course.getEnrollStudent().get(successfulStudents - 1).getCredits()) {
                        successfulStudents++;
                        course.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(course);
                        newEnrollStudentList.add(student);
                    } else {
                        break;
                    }
                }
            }
            course.setEnrollStudent(newEnrollStudentList);

            for (int i = successfulStudents; i < course.getEnrollStudent().size(); i++) {
                Student student = course.getEnrollStudent().get(i);
                dropStudentEnrollmentCourse(student, course.getCourseID());
            }
        }
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
        if (!ifOpen) {
            return null;
        }

        ArrayList<String> result = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            result.add(course.getCourseID() + ": " + course.getCredits().get(student.getEnrollCourses().indexOf(course)));
        }

        return result;
    }

    // this one is a new method
    private Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}