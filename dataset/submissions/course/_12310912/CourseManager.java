import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.

    private ArrayList<Student> students;
    //Maintains a record of all students successfully registered

    private boolean ifOpen;//Represent the system open or not

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }
    // Constructor, initializes the course and student lists, and set the system
    //default status open(true).

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }// Register a course. Add a course object to courses and set the courseManager of the course object to this manager.

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }// Register a course. Add a student object to students and set the courseManager of the student object to this manager.

    /*
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not
     already enrolled, the credits is greater than 0, and they have enough credits to
     bid.
     * If successful, the student's credits will be reduced by the amount bid on the
     course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean Returns true if student enroll this course successfully;
    otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseID, int credits) {
        if (ifOpen == false) return false;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                if (student.getEnrollCourses().contains(course)) return false;
                if (credits <= 0) return false;
                if (student.getCredits() < credits) return false;
                student.getEnrollCourses().add(course);
                student.setCredits(student.getCredits() - credits);
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
                return true;
            }
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
     * @return boolean Returns true if the bid modification was successful;
     * otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseID, int credits) {
        if (ifOpen == false) return false;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseID)) {
                if (credits <= 0) return false;

                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                    if (course.getEnrollStudent().get(i).equals(student)) {
                        if (course.getCredits().get(i) + student.getCredits() < credits) return false;
                        student.setCredits(student.getCredits() + course.getCredits().get(i) - credits);
                        course.getCredits().set(i, credits);
                        return true;
                    }
                }
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
     * @return boolean Returns true if the student successfully drops the course;
     * otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseID) {
        if (ifOpen == false) return false;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseID)) {
                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                    if (course.getEnrollStudent().get(i).equals(student)) {
                        student.setCredits(student.getCredits() + course.getCredits().get(i));
                        course.getCredits().remove(i);
                        student.getEnrollCourses().remove(course);
                        course.getEnrollStudent().remove(student);
                        break;
                    }
                }

                return true;
            }
        }
        return false;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids
     * and the course capacities. Students with higher bids are prioritized. The
     * corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need
     * to be updated.
     *
     * @return
     */
    public void finalizeEnrollments() {
        if (ifOpen) {
            for (Course course : courses) {
                //List<Student> enrolledStudents = course.getEnrollStudent();
                //enrolledStudents.sort((a, b) -> b.getCredits() - a.getCredits());

                List<Student> enrolledStudents = course.getEnrollStudent();
                List<Integer> credits = course.getCredits();

                for (int i = 0; i < enrolledStudents.size() - 1; i++) {
                    for (int j = 0; j < enrolledStudents.size() - 1 - i; j++) {
                        if (credits.get(j) < credits.get(j + 1)) {

                            Student tempStudent = enrolledStudents.get(j);
                            enrolledStudents.set(j, enrolledStudents.get(j + 1));
                            enrolledStudents.set(j + 1, tempStudent);

                            int tempCredits = credits.get(j);
                            credits.set(j, credits.get(j + 1));
                            credits.set(j + 1, tempCredits);
                        }
                    }
                }

                int maxCapacity = course.getMaxCapacity();
                int allStudents = enrolledStudents.size();
                if (allStudents <= maxCapacity) {
                    course.getSuccessStudents().addAll(enrolledStudents);
                    for (Student student : enrolledStudents) {
                        student.getSuccessCourses().add(course);
                    }
                } else {
                    int count = 0;
                    int mcredits = course.getCredits().get(maxCapacity);
                    for (int i = 0; i < allStudents; i++) {
                        if (credits.get(i) <= mcredits) {
                            count++;
                        }
                    }
                    course.getSuccessStudents().addAll(enrolledStudents.subList(0, allStudents - count));
                    for (Student student : course.getSuccessStudents()) {
                        student.getSuccessCourses().add(course);
                    }
                }

            }
            ifOpen = false;
        }
    }
    /*It should be noted that, as in the case of our normal selection, if the number of electors exceeds
the maximum number of courses, the principle of "same credit, same drop" will be followed.
Eg. If the maximum number of students is 10, and 15 students choose this course, and after
sorted by enrolled points, if the 8th, 9th, 10th, and 11th students are all of the same credit, then
the four of them will not be able to choose the course successfully, and the number of successful
students will be seven. */

    /*
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
        if (ifOpen == false) return null;
        ArrayList<String> result = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (course.getEnrollStudent().get(i).equals(student)) {
                    result.add(course.getCourseID() + ": " + course.getCredits().get(i));
                }
            }
        }
        return result;
    }


}