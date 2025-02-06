import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private static boolean ifOpen;

    public CourseManager() {
        courses=new ArrayList<>();
        students= new ArrayList<>();
        setIfOpen(true);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

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

    // Register a course. Add a course object to courses and set the courseManager
    //of the course object to this manager. It is guaranteed that all courseIDs are
    //unique.
    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
    // Register a course. Add a student object to students and set the courseManager
    //of the student object to this manager. It is guaranteed that all studentIDs are
    //unique.

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
    public boolean enrollStudentInCourse(Student student, String courseId, int
            credits) {
        //if close or insufficient credits,output false
        if (ifOpen == false || student.getCredits() - credits < 0) {
            return false;
        } else {
            //if this student has had this course,false
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).getCourseID().equals(courseId) ) {
                    return false;
                }
            }
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    //let this course add a student
                    ArrayList<Student> currentstudent = courses.get(i).getEnrollStudent();
                    currentstudent.add(student);
                    courses.get(i).setEnrollStudent(currentstudent);
                    //let this course's credit list extend 1
                    ArrayList<Integer> creditrank = courses.get(i).getCredits();
                    creditrank.add(credits);
                    courses.get(i).setCredits(creditrank);
                    //let the student have one more course
                    ArrayList<Course> currentcourses = student.getEnrollCourses();
                    currentcourses.add(courses.get(i));
                    student.setEnrollCourses(currentcourses);
                    //decrese the credits of the student
                    student.setCredits(student.getCredits() - credits);

                    return true;
                }
            }
            return false;
        }
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
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,
                                                  int credits) {
        if (ifOpen == false) {
            return false;
        }
        if(credits==0){
            dropStudentEnrollmentCourse(student,courseId);
        }
        if(credits<0){
            return false;
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {//
            if (student.getEnrollCourses().get(i).getCourseID() .equals(courseId)) {//find the course?
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {//find what index the student is
                    //
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {//find the index j
                        int credit_bided_in_the_course = student.getEnrollCourses().get(i).getCredits().get(j);
                        int credit_after_refund = credit_bided_in_the_course + student.getCredits();
                        if (credit_after_refund - credits >= 0) {
                            student.getEnrollCourses().get(i).getCredits().set(j, credits);//
                            student.setCredits(credit_after_refund - credits);
                            return true;
                        }
                        return false;
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
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen) {
            Course coursetodrop = null;
            for (Course course : student.getEnrollCourses()) {
                if (course.getCourseID().equals(courseId)) {
                    coursetodrop = course;
                    break;
                }
            }
            if (coursetodrop != null) {
                int creditindex = coursetodrop.getEnrollStudent().indexOf(student);
                int credit = coursetodrop.getCredits().remove(creditindex);
                student.setCredits(student.getCredits() + credit);
                boolean remove1 = coursetodrop.getEnrollStudent().remove(student);
                boolean remove2 = student.getEnrollCourses().remove(coursetodrop);
                for (Course course : student.getEnrollCourses()) {
                    if (course.getCourseID().equals(courseId)) {
                        student.getEnrollCourses().remove(course);
                    }
                }
                if (remove1 && remove2) {
                    return true;
                }
            }
        }
        return false;
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
        ArrayList<String> courseinfo = new ArrayList<>();
        ArrayList<Course> courses = student.getEnrollCourses();
        for (Course course : courses) {
            int index = course.getEnrollStudent().indexOf(student);
            int credit = course.getCredits().get(index);
            String infoi = course.getCourseID() + ": " + credit;
            courseinfo.add(infoi);
        }
        return courseinfo;
    }

    public void finalizeEnrollments() {
        if (ifOpen) {
            setIfOpen(false);
            for (Course coursei : courses) {
                ArrayList<Integer> n = coursei.getCredits();
                ArrayList<Student> s = coursei.getEnrollStudent();
                if (coursei.getMaxCapacity() >= n.size()) {
                    coursei.setSuccessStudents(s);
                    for (Student stu : s) {
                        stu.getSuccessCourses().add(coursei);
                    }
                    return;
                }
                for (int i = 0; i < n.size() - 1; i++) {
                    for (int j = 0; j < n.size() - 1 - i; j++) {
                        if (n.get(j) < n.get(j + 1)) {
                            Collections.swap(n, j, j + 1);
                            Collections.swap(s, j, j + 1);
                        }
                    }
                }
                int lastindex;
                lastindex = coursei.getMaxCapacity() - 1;
                for (int i = lastindex; i >= 0; i--) {
                    if (n.get(lastindex).equals(n.get(lastindex + 1))) {
                        lastindex--;
                    }
                }
                if(lastindex<0){
                    return;
                }
                for (int i = 0; i <= lastindex; i++) {
                    coursei.getSuccessStudents().add(s.get(i));
                    s.get(i).getSuccessCourses().add(coursei);
                }
            }
        }
    }
}
