import java.util.ArrayList;

public class CourseManager{
    private ArrayList<Course> courses;
// Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.

    private ArrayList<Student> students;
// Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.

    private boolean ifOpen;
    // Represent system open(true) or not(false).
    public CourseManager(){
        this.students = new ArrayList<Student>();
        this.courses = new ArrayList<Course>();
        this.ifOpen=true;
    }
    // Constructor, initializes the course and student lists, and set the system default status open(true).
    public ArrayList<Student> getStudents(){

        return this.students;
    }
// getter for students

    public ArrayList<Course> getCourses(){

        return this.courses;
    }
// getter for courses

    public void setIfOpen(Boolean ifOpen){

        this.ifOpen=ifOpen;
    }
// setter for ifOpen

    public boolean getIfOpen(){

        return this.ifOpen;
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
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.
    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        for (Course course:this.courses){
            if(course.getCourseID().equals(courseId) && credits>0 && credits<=student.getCredits() && !student.getEnrollCourses().contains(course) && ifOpen) {
                student.setCredits(student.getCredits()-credits);
                student.getEnrollCourses().add(course);
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
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
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen)
            return false;
        for (Course course:student.getEnrollCourses()){
            if(course.getCourseID().equals(courseId) && credits>0 && credits<=(student.getCredits()+course.getCredits().get(course.getEnrollStudent().indexOf(student)))) {
                student.setCredits(student.getCredits()+course.getCredits().get(course.getEnrollStudent().indexOf(student))-credits);
                course.getCredits().set(course.getEnrollStudent().indexOf(student),credits);
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
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        for (Course course:student.getEnrollCourses()){
            if (course.getCourseID().equals(courseId) && ifOpen){
                student.setCredits(student.getCredits()+course.getCredits().get(course.getEnrollStudent().indexOf(student)));
                student.getEnrollCourses().remove(course);
                course.getCredits().remove(course.getEnrollStudent().indexOf(student));
                course.getEnrollStudent().remove(student);
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
    public void finalizeEnrollments(){
        this.ifOpen=false;
        for (Course course:this.courses) {
            int max=course.getMaxCapacity();
            if(max>course.getEnrollStudent().size())
                max=course.getEnrollStudent().size();
            for (int i = 0; i < course.getCredits().size(); i++) {
                for (int j = course.getCredits().size() - 1; j > i; j--) {
                    if (course.getCredits().get(j - 1) < course.getCredits().get(j)) {
                        int zuanhuanCredits;
                        Student zuanhuanStudent;
                        zuanhuanCredits = course.getCredits().get(j);
                        zuanhuanStudent = course.getEnrollStudent().get(j);
                        course.getCredits().set(j, course.getCredits().get(j - 1));
                        course.getEnrollStudent().set(j, course.getEnrollStudent().get(j - 1));
                        course.getCredits().set(j - 1, zuanhuanCredits);
                        course.getEnrollStudent().set(j - 1, zuanhuanStudent);
                    }
                }
            }
            if(max<course.getEnrollStudent().size()) {
                if (course.getCredits().get(course.getMaxCapacity()).equals(course.getCredits().get(course.getMaxCapacity() - 1))) {
                    max=course.getCredits().indexOf(course.getCredits().get(course.getMaxCapacity()));
                }
            }
            for (int i = 0; i < max; i++) {
                course.getSuccessStudents().add(course.getEnrollStudent().get(i));
            }
            for (Student student:course.getSuccessStudents())
            {
                student.getSuccessCourses().add(course);
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
        if (!ifOpen)
            return null;
        ArrayList<String> result=new ArrayList<>();
        for (Course course:student.getEnrollCourses())
        {
            result.add(course.getCourseID()+": "+course.getCredits().get(course.getEnrollStudent().indexOf(student)));
        }
        return result;
    }
}