import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CourseManager {
    private ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.
    // It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students;
    // Maintains a record of all students successfully registered.
    // It is guaranteed that courses student enrolled in must exist in courses.
    private boolean ifOpen;
    // Represent system open(true) or not(false).
    public CourseManager(){
        this.courses = new ArrayList<Course>();
        this.students = new ArrayList<Student>();
        this.ifOpen = true;
    }
    // Constructor, initializes the course and student lists, and set the system default status open(true).
    public ArrayList<Student> getStudents(){
        return students;
    }
    // getter for students
    public ArrayList<Course> getCourses(){
        return courses;
    }
    // getter for courses
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen = ifOpen;
    }
    // setter for ifOpen
    public boolean getIfOpen(){
        return ifOpen;
    }
    // getter for ifOpen
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager.
    // It is guaranteed that all courseIDs are unique.
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    // Register a course. Add a student object to students and set the courseManager of the student object to this manager.
    // It is guaranteed that all student IDs are unique.

    /**
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
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (!ifOpen) {
            return false;
        }
        Course courseToEnroll = null;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                courseToEnroll = course;
                break;
            }
        }
        if (courseToEnroll == null || student.getCredits() < credits || credits <= 0) {
            return false;
        }
        for (Course enrolledCourse : student.getEnrollCourses()) {
            if (enrolledCourse.getCourseID().equals(courseId)) {
                return false;
            }
        }
        student.getEnrollCourses().add(courseToEnroll);
        courseToEnroll.getEnrollStudent().add(student);
        courseToEnroll.getCredits().add(credits);
        student.setCredits(student.getCredits() - credits);
        return true;
    }
    /**
     * Modifies the number of credits a student has bid on an already enrolled
     course.
     * The modification will only be successful if the course exists, the student is
     currently enrolled in the course,and the new bid is within the student's
     available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to
     reflect the new bid amount. The corresponding list in Student and Course should
     be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean Returns true if the bid modification was successful;
    otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        Course toEnrollCourse = null;
        int currentCredits = -1;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                toEnrollCourse = course;
                break;
            }
        }
        if (toEnrollCourse == null) {
            return false;
        }

        int studentIndex = toEnrollCourse.getEnrollStudent().indexOf(student);
        if (studentIndex >= 0) {
            currentCredits = toEnrollCourse.getCredits().get(studentIndex);
        } else {
            return false;
        }

        if (student.getCredits() + currentCredits < credits || credits <= 0) {
            return false;
        }
        toEnrollCourse.getCredits().set(studentIndex, credits);
        student.setCredits(student.getCredits() - credits + currentCredits);
        return true;

    }
    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently
     enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid
     for this course will be refunded in full. The corresponding list in Student and
     Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean Returns true if the student successfully drops the course;
    otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }
        Course toDropCourse = null;
        int studentIndex = -1;
        for(Course course : student.getEnrollCourses()){
            if(courseId.equals(course.getCourseID())){
                toDropCourse = course;
                studentIndex = course.getEnrollStudent().indexOf(student);
                if (studentIndex >= 0) {
                    int toRefundCredit = course.getCredits().get(studentIndex);
                    course.getEnrollStudent().remove(studentIndex);
                    course.getCredits().remove(studentIndex);
                    student.getEnrollCourses().remove(course);
                    student.setCredits(student.getCredits() + toRefundCredit);
                }
                break;
            }
        }
        return toDropCourse != null && studentIndex >= 0;
    }
    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids
     and the course capacities. Students with higher bids are prioritized. The
     corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need
     to be updated.
     */
    public void finalizeEnrollments(){
        ifOpen = false;
        for (Course course : courses){
            if (course.getEnrollStudent().size() > course.getMaxCapacity()){
                ArrayList<Integer> creditNumbers = (ArrayList<Integer>)course.getCredits().clone();
                Collections.sort(creditNumbers);
                ArrayList<Integer> sortCreditNumbers = new ArrayList<>();
                sortCreditNumbers.add(creditNumbers.get(0));
                for (int i = 1; i < creditNumbers.size(); i++) {
                    if (!creditNumbers.get(i).equals(creditNumbers.get(i-1))){
                        sortCreditNumbers.add(creditNumbers.get(i));
                    }
                }
                int toBeRemoved = 0;
                for (Integer sortCreditNumber : sortCreditNumbers) {
                    for (int j = 0; j < course.getCredits().size(); j++) {
                        if (course.getCredits().get(j).equals(sortCreditNumber)) {
                            course.getCredits().set(j, -1);
                            toBeRemoved++;
                        }
                    }
                    if (course.getEnrollStudent().size() - toBeRemoved <= course.getMaxCapacity()) {
                        break;
                    }
                }
                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                    if (course.getCredits().get(i) > 0){
                        course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                        course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                    }
                }
            }else if(!course.getEnrollStudent().isEmpty()){
                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                        course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                        course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                }
            }
        }
    }
    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the
     student in enrollCourses, follow the format: "courseID: enrollmentCredits"
     (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective
    credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(ifOpen){
            ArrayList<String> result = new ArrayList<>();
            for (Course course : student.getEnrollCourses()){
                String credit = String.valueOf(course.getCredits().get(course.getEnrollStudent().indexOf(student)));
                result.add(course.getCourseID() + ": " + credit);
            }
            return result;
        }
        return null;
    }
}
