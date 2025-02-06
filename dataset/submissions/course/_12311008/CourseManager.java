import java.util.ArrayList;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students;
    // Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.
    private boolean ifOpen;

    // Represent system open(true) or not(false).
    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    // Constructor, initializes the course and student lists, and set the system default status open(true).
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
        courses.add(course);
        course.setCourseManager(this);
    }

    // Register a course.
// Add a course object to courses and set the courseManager of the course object to this manager.
// It is guaranteed that all courseIDs are unique.
    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
// Register a student.
// Add a student object to students and set the courseManager of the student object to this manager.
// It is guaranteed that all studentIDs are unique.

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (getIfOpen()) {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    if (!student.getEnrollCourses().contains(course) && credits > 0 && student.getCredits() >= credits) {
                        int credits01 = student.getCredits() - credits;
                        student.setCredits(credits01);
                        student.getEnrollCourses().add(course);
                        course.getEnrollStudent().add(student);
                        for (int x = 0; x < students.size(); x++) {
                            course.getCredits().add(0);
                            if (getStudents().get(x).equals(student)) {
                                course.getCredits().set(x, credits);
                            }
                            if (course.getCredits().get(x) == 0) {
                                course.getCredits().set(x, 0);
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (getIfOpen()) {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    for (int x = 0; x < students.size(); x++) {
                        if (student.getEnrollCourses().contains(course) && student.getCredits() + course.getCredits().get(x) >= credits && credits > 0) {
                            if (getStudents().get(x).equals(student)) {
                                int credits01 = student.getCredits() + course.getCredits().get(x);
                                student.setCredits(credits01);
                                course.getCredits().set(x, credits);
                                credits01 = credits01 - course.getCredits().get(x);
                                student.setCredits(credits01);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (getIfOpen()) {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    if (student.getEnrollCourses().contains(course)) {
                        for (int x = 0; x < students.size(); x++) {
                            if (getStudents().get(x).equals(student)) {
                                int credits01 = student.getCredits() + course.getCredits().get(x);
                                student.setCredits(credits01);
                                course.getCredits().set(x, 0);
                            }
                        }
                    student.getEnrollCourses().remove(course);
                    course.getEnrollStudent().remove(student);
                    student.getSuccessCourses().remove(course);
                    course.getSuccessStudents().remove(student);
                    return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments() {
        if (getIfOpen()) {
            ifOpen = false;
        }
        for (Course course : courses) {
            ArrayList<Integer> abc = new ArrayList<>();
            for (int i = 0; i < course.getCredits().size(); i++) {
                abc.add(course.getCredits().get(i));
            }
            ArrayList<Integer> xyz = new ArrayList<>();
            for (int i = 0; i < course.getCredits().size(); i++) {
                xyz.add(course.getCredits().get(i));
            }
            course.getCredits().sort(Comparator.reverseOrder());
            if (course.getMaxCapacity() < abc.size()) {
                if (course.getCredits().get(course.getMaxCapacity()) >= course.getCredits().get(course.getMaxCapacity() - 1)) {
                    for (int x = course.getMaxCapacity() - 1; x >= 0; x--) {
                        if (course.getCredits().get(course.getMaxCapacity()) >= course.getCredits().get(x)) {
                            course.getCredits().set(x, 0);
                        }
                    }
                    course.getCredits().set(course.getMaxCapacity(), 0);
                }
                for (int x = course.getMaxCapacity(); x < abc.size(); x++) {
                    course.getCredits().set(x, 0);
                }
            }
            for (int j = 0; j < course.getCredits().size(); j++) {
                if (course.getCredits().get(j) < course.getCredits().get(course.getMaxCapacity() - 1)) {
                    course.getCredits().set(j, 0);
                }
            }
            for (int x = 0; x < abc.size(); x++) {
                if (!course.getCredits().contains(abc.get(x))) {
                    abc.set(x, 0);
                }
            }
            for (int x = 0; x < abc.size(); x++) {
                if (!abc.get(x).equals(0)) {
                    course.getSuccessStudents().add(getStudents().get(x));
                    getStudents().get(x).getSuccessCourses().add(course);
                }
            }
            for (int i = course.getCredits().size()-1; i >=0; i--) {
                if(course.getCredits().get(i).equals(0)){
                    course.getCredits().remove(i);
                }
            }
        }
    }

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     *
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (getIfOpen()) {
            ArrayList<String> enrolledCourses = new ArrayList<>();
            for (int x = 0; x < students.size(); x++) {
                if (getStudents().get(x).equals(student)) {
                    for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                        String s = student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(x);
                        enrolledCourses.add(s);
                    }
                }
            }
            return enrolledCourses;
        }
        return null;
    }
}