
import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {

    private ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students;
    // Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // getter for students
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // getter for courses
    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    // setter for ifOpen
    public boolean getIfOpen() {
        return ifOpen;
    }

    // getter for ifOpen
    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    // Register a course.
    // Add a course object to courses
    // set the courseManager of the course object to this manager.
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }
    // Register a course.
    // Add a student object to students
    // and set the courseManager of the student object to this manager.
    // It is guaranteed that all studentIDs are unique.

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not
     * already enrolled, the credits is greater than 0, and they have enough credits to
     * bid.
     * If successful, the student's credits will be reduced by the amount bid on the
     * course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean Returns true if student enroll this course successfully;
     * otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean isValid = true;
        if (credits < 0){
            isValid = false;
        }
        //ifOpen
        if (!ifOpen) {
            isValid = false;
        }
        Course targetCourse = findTargetCourse(courseId, courses);
        if (targetCourse == null) {
            isValid = false;
        }
        if (isCourseChosen(student, targetCourse)) {
            isValid = false;
        }
        if (student.getCredits() <= 0 || student.getCredits() < credits) {
            isValid = false;
        }
        if (isValid) {
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(targetCourse);
            targetCourse.getEnrollStudent().add(student);
            targetCourse.getCredits().add(credits);
        }
        return isValid;
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
     * @return boolean Returns true if the bid modification was successful;
     * otherwise, it returns false.
     */

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean isValid = true;
        if (credits < 0){
            isValid = false;
        }
        //ifOpen
        if (!ifOpen) {
            isValid = false;
        }
        Course targetCourse = findTargetCourse(courseId, courses);
        if (targetCourse == null) {
            isValid = false;
        }
        if (!isCourseChosen(student, targetCourse)) {
            isValid = false;
        }
        int previousCredits = findCredits(targetCourse, student);

        if (student.getCredits() <= 0 || student.getCredits() + previousCredits < credits) {
            isValid = false;
        }
        if (isValid) {
            previousCredits = findCredits(targetCourse, student);
            student.setCredits(student.getCredits() - credits + previousCredits);
            targetCourse.setCredits(changeCourseCredits(targetCourse, student, credits));
        }
        return isValid;
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
     * @return boolean Returns true if the student successfully drops the course;
     * otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean isValid = true;
        //ifOpen
        if (!ifOpen) {
            isValid = false;
        }
        if (student.getCredits() <= 0) {
            isValid = false;
        }
        Course targetCourse = findTargetCourse(courseId, courses);
        if (targetCourse == null) {
            isValid = false;
        }
        if (!isCourseChosen(student, targetCourse)) {
            isValid = false;
        }
        ArrayList<Integer> credits = targetCourse.getCredits();
        int index = 0;
        for (int i = 0; i < credits.size(); i++) {
            if (credits.get(i) == student.getCredits()) {
                index = i;
            }
        }
        if (isValid) {
            student.setCredits(student.getCredits() + findCredits(targetCourse, student));
            //course
            targetCourse.getCredits().remove(index);
            targetCourse.getEnrollStudent().remove(student);
            //student
            student.getEnrollCourses().remove(targetCourse);
            student.setCredits(student.getCredits() + findCredits(targetCourse, student));
        }
        return isValid;
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
        boolean isValid = true;
        if (!ifOpen) {
            isValid = false;
        }

        ArrayList<Course> courseTemp = student.getEnrollCourses();
        ArrayList<String> rs = new ArrayList<>();

        if (isValid) {
            ArrayList<String> temp = new ArrayList<>();
            for (Course course : courseTemp) {
                int credits = findCredits(course, student);
                temp.add(course.getCourseID() + ": " + credits);
            }
            rs.addAll(temp);
        }
        return rs;
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
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            for (int j = 0; j < students.size(); j++) {
                Student student = students.get(j);
                if (findCredits(course,student) > minimumCredits(course)){
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                }
            }
        }

    }
    //find target course
    public static Course findTargetCourse(String courseID, ArrayList<Course> courses) {
        int index = -100;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseID)) {
                index = i;
                break;
            }
        }
        if (index != -100) {

            return courses.get(index);
        } else {
            return null;
        }
    }

    public static Student targetStudent(String studentID, ArrayList<Student> students) {
        int index = -100;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentID)) {
                index = i;
                break;
            }
        }
        if (index != -100) {
            Student targetStudent = students.get(index);
            return targetStudent;
        } else {
            return null;
        }
    }
    //whether the student enrolls in the course
    public static boolean isCourseChosen(Student student, Course course) {
        boolean rs = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(course.getCourseID())) {
                rs = true;
                break;
            }
        }
        return rs;
    }
// find students' credits on a course
    public static int findCredits(Course course, Student student) {
        ArrayList<Student> enrolledStudents = course.getEnrollStudent();
        int index = enrolledStudents.indexOf(student);
        if (index != -1) {
            return course.getCredits().get(index);
        } else {
            return 0;
        }
    }

    //change a student's credits in a course
    public static ArrayList<Integer> changeCourseCredits(Course course, Student student, int credit) {
        ArrayList<Integer> credits = course.getCredits();
        int index = course.getEnrollStudent().indexOf(student);
        if (index != -1) {
            credits.set(index, credit);
        }
        return credits;
    }

    public static int minimumCredits(Course course) {
        if (course.getMaxCapacity() >= course.getEnrollStudent().size()) {
            return 1;
        } else {
            int difference = course.getEnrollStudent().size() - course.getMaxCapacity();
            ArrayList<Integer> credits = new ArrayList<>(course.getCredits());
            Collections.sort(credits);
            return credits.get(difference - 1);
        }
    }
}
