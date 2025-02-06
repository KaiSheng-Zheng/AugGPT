import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

class CourseManager{
    private ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students;
    // Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.
    private boolean ifOpen;
    // Represent system open(true) or not(false).
    public CourseManager(){
        this.courses=new ArrayList<>();
        this.students=new ArrayList<>();
        this.ifOpen=true;
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
        this.ifOpen=ifOpen;
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
    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    // Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique./**
// * Attempts to enroll a Student in a Course.
// * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
// * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
// * Only available when ifOpen is true. Return false if ifOpen is false.
// * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
// */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if(!ifOpen)
            return false;
        for(Course course:courses) {
            if (Objects.equals(course.getCourseID(), courseId)) {
                int i=course.getEnrollStudent().indexOf(student);
                if (i<0 && credits >= 0 && credits <= student.getCredits()) {
                    student.setCredits(student.getCredits() - credits);
                    student.getEnrollCourses().add(course);
                    student.setEnrollCourses(student.getEnrollCourses());
                    course.getEnrollStudent().add(student);
                    course.setEnrollStudent(course.getEnrollStudent());
                    course.getCredits().add(credits);
                    course.setCredits(course.getCredits());
                    return true;
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
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen)
            return false;
        if(getIfOpen()&&credits>=0) {
            for (Course course : courses)
                if (Objects.equals(course.getCourseID(), courseId)) {
                    int i=course.getEnrollStudent().indexOf(student);
                    if(i<0)
                        return false;
                    if(student.getCredits()+course.getCredits().get(i)-credits>=0){
                        student.setCredits(student.getCredits()+course.getCredits().get(i)-credits);
                        course.getCredits().set(i,credits);
                        course.setCredits(course.getCredits());
                        return true;
                    }
                    else
                        return false;
                }
        }
        return false;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen)
            return false;
        if(getIfOpen()) {
            for (Course course : courses)
                if (Objects.equals(course.getCourseID(), courseId)) {
                    int i=course.getEnrollStudent().indexOf(student);
                    if(i<0)
                        return false;
                    student.getEnrollCourses().remove(course);
                    student.setEnrollCourses(student.getEnrollCourses());
                    student.setCredits(student.getCredits()+course.getCredits().get(i));
                    course.getCredits().remove(i);
                    course.setCredits(course.getCredits());
                    course.getEnrollStudent().remove(i);
                    course.setEnrollStudent(course.getEnrollStudent());
                    return true;
                }
            return false;
        }
        return false;
    }
    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        ifOpen=false;
        setIfOpen(false);
        for(Course course:courses) {
            if (course.getEnrollStudent().size() > course.getMaxCapacity()) {
                ArrayList<Integer> ex=(ArrayList<Integer>)course.getCredits().clone();
                int k = course.getEnrollStudent().size() - course.getMaxCapacity();
                //ex=course.getCredits();
                Collections.sort(ex);
                int p= ex.get(k-1);
                //int p=hahaha(course.getCredits(),k);
                for (Student sb : course.getEnrollStudent()) {
                    int i=course.getEnrollStudent().indexOf(sb);
                    if (course.getCredits().get(i) >p){
                        course.getSuccessStudents().add(sb);
                        course.setSuccessStudents(course.getSuccessStudents());
                        sb.getSuccessCourses().add(course);
                        sb.setSuccessCourses(sb.getSuccessCourses());
                    }
                }
            }
            else{
                for (Student sb : course.getEnrollStudent()) {
                    course.getSuccessStudents().add(sb);
                    course.setSuccessStudents(course.getSuccessStudents());
                    sb.getSuccessCourses().add(course);
                    sb.setSuccessCourses(sb.getSuccessCourses());
                    }
            }
        }
    }
    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> sariel = new ArrayList<>();
        for(Course course:student.getEnrollCourses()){
            int i=course.getEnrollStudent().indexOf(student);
            sariel.add(course.getCourseID()+": "+(course.getCredits().get(i)));
        }
        return sariel;
    }
}