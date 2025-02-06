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
// Represent system open(true) or not(false).

    public CourseManager() {
        ifOpen = true;
        courses = new ArrayList<>();
        students = new ArrayList<>();
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
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student) {

        this.students.add(student);
        student.setCourseManager(this);
    }
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists,
     * the student has not already enrolled,
     * the credits to bid is greater than 0,
     * and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen == false) {
            return false;
        }
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)&&!courses.get(i).getEnrollStudent().contains(student)&&credits>0&&student.getCredits()>=credits){
                courses.get(i).getEnrollStudent().add(student);
                courses.get(i).getCredits().add(credits);
                student.getEnrollCourses().add(courses.get(i));
                int restcredits = student.getCredits()-credits;
                student.setCredits(restcredits);
                return true;
            }
        }
        return false;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if(ifOpen == false){
            return false;
        }
        for (int i = 0; i < courses.size(); i++) {
            int index=courses.get(i).getEnrollStudent().indexOf(student);
            if(courses.get(i).getCourseID().equals(courseId)&&courses.get(i).getEnrollStudent().contains(student)&&credits<= student.getCredits() + courses.get(i).getCredits().get(index)){
                int restcredits = student.getCredits() + courses.get(i).getCredits().get(index) - credits;
                courses.get(i).getCredits().set(index,credits);
                student.setCredits(restcredits);
                return true;
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
        if(ifOpen == false){
            return false;
        }
        for (int i = 0; i < courses.size(); i++) {
            int index = courses.get(i).getEnrollStudent().indexOf(student);
            if(courses.get(i).getCourseID().equals(courseId)&&courses.get(i).getEnrollStudent().contains(student)){
                int restcredits = student.getCredits() + courses.get(i).getCredits().get(index);
                student.setCredits(restcredits);
                student.getEnrollCourses().remove(courses.get(i));
                courses.get(i).getEnrollStudent().remove(index);
                courses.get(i).getCredits().remove(index);
                return true;
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
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Integer> copy = new ArrayList<>();
            for (int j = 0; j < courses.get(i).getCredits().size(); j++) {
                copy.add(courses.get(i).getCredits().get(j));
            }
            Collections.sort(copy);
            Collections.reverse(copy);
            int lowest = 0;
            if (courses.get(i).getEnrollStudent().size() > courses.get(i).getMaxCapacity()) {
                lowest = copy.get(courses.get(i).getMaxCapacity() - 1);
                if (lowest == copy.get(courses.get(i).getMaxCapacity())) {
                    lowest += 1;
                }
                for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                    if (courses.get(i).getCredits().get(j) >= lowest) {
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    }
                }
            } else {
                for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                }
            }
        }
        ifOpen = false;
    }

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     *
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if(ifOpen == false){
            return null;
        }
        ArrayList<String> result=new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            result.add(student.getEnrollCourses().get(i).getCourseID()+": "+student.getEnrollCourses().get(i).getCredits().get(student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student)));
        }
        return result;
    }
}
