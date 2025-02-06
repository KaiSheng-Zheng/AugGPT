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
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    // Constructor, initializes the course and student lists, and set the system
    // default status open(true).
    public ArrayList<Student> getStudents() {
        return students;
    }
    // getter for students
    public ArrayList<Course> getCourses() {
        return courses;
    }
    // getter for courses
    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen=ifOpen;
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
    // Register a course. Add a course object to courses and set the courseManager
    // of the course object to this manager. It is guaranteed that all courseIDs are
    // unique.
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }
    // Register a course. Add a student object to students and set the courseManager
    // of the student object to this manager. It is guaranteed that all studentIDs are
    // unique.
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
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if(!ifOpen) return false;

        if(credits<=0) return false;

        Course course=null;
        for(Course c: this.courses) {
            if(c.getCourseID().equals(courseId)) {
                course=c;
                break;
            }
        }
        if(course==null) return false;

        for(Course c: student.getEnrollCourses()) {
            if(c.getCourseID().equals(courseId)) {
                return false;
            }
        }

        if(student.getCredits()<credits) return false;


        student.setCredits(student.getCredits()-credits);

        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);

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
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if(!ifOpen) return false;

        if(credits<=0) return false;

        Course course=null;
        for(Course c: this.courses) {
            if(c.getCourseID().equals(courseId)) {
                course=c;
                break;
            }
        }
        if(course==null) return false;

        int index=-1;
        for(int i=0;i<course.getEnrollStudent().size();i++) {
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index=i;
                break;
            }
        }
        if(index==-1) return false;

        int originalCredit=course.getCredits().get(index);
        if(originalCredit+student.getCredits()<credits) return false;


        student.setCredits(student.getCredits()+originalCredit-credits);
        course.getCredits().set(index,credits);

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
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if(!ifOpen) return false;

        Course course=null;
        for(Course c: this.courses) {
            if(c.getCourseID().equals(courseId)) {
                course=c;
                break;
            }
        }
        if(course==null) return false;

        int index=-1;
        for(int i=0;i<course.getEnrollStudent().size();i++) {
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index=i;
                break;
            }
        }
        if(index==-1) return false;
        int originalCredit=course.getCredits().get(index);


        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);

        for(int i=0;i<student.getEnrollCourses().size();i++) {
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                student.getEnrollCourses().remove(i);
                break;
            }
        }

        student.setCredits(student.getCredits()+originalCredit);

        return true;
    }
    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids
     and the course capacities. Students with higher bids are prioritized. The
     corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need
     to be updated.
     */
    public void finalizeEnrollments() {
        ifOpen=false;
        int Min=0x7f;
        for(Course c:this.courses) {
            ArrayList<Integer> copy=new ArrayList<>();
            for(int x:c.getCredits()) {
                copy.add(x);
            }
            Collections.sort(copy, Collections.reverseOrder());
            int capacity=c.getMaxCapacity();
            if(capacity>=c.getCredits().size()) Min=0;
            else {
                if(copy.get(capacity-1)!=copy.get(capacity)) {
                    Min=copy.get(capacity-1);
                }
                else {
                    Min=copy.get(capacity-1)+1;
                }
            }

            for(int i=0;i<c.getCredits().size();i++) {
                if(c.getCredits().get(i)>=Min) {
                    c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    c.getEnrollStudent().get(i).getSuccessCourses().add(c);
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
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if(!ifOpen) return null;


        ArrayList<String> res=new ArrayList<>();
        for(Course c:student.getEnrollCourses()) {
            for(int i=0;i<c.getEnrollStudent().size();i++) {
                if(c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    res.add(c.getCourseID()+": "+Integer.toString(c.getCredits().get(i)));
                }
            }
        }

        return res;
    }

}
