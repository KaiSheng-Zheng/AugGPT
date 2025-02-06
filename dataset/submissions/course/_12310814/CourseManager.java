
import java.util.ArrayList;
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
    courses = new ArrayList<>();
    students = new ArrayList<>();
    ifOpen = true;
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

    public boolean isIfOpen() {
        return ifOpen;
    }
    // setter for ifOpen
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    // getter for ifOpen
    public boolean getIfOpen(){
    return ifOpen;
    }
    public void addCourse(Course course){
    courses.add(course);
    course.setCourseManager(this);
    }
    // Register a course. Add a course object to courses and
    // set the courseManager of the course object to this manager.
    // It is guaranteed that all courseIDs are unique.
    public void addStudent(Student student){
    students.add(student);
    student.setCourseManager(this);
    }
    // Register a course. Add a student object to students and set the courseManager of the student object to this manager.
    // It is guaranteed that all studentIDs are unique.
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
    public boolean enrollStudentInCourse(Student student, String courseId, int
            credits){
            boolean course_find = false;
            boolean student_not_enroll = true;
            boolean credit_valid = false;
            //circulate to judge the existence of the courseId
            for (int i = 0; i < courses.size(); i++) {
                if(courseId.equals(courses.get(i).getCourseID())){
                    course_find = true;
                    break;
                }
            }
            //judge whether the student has enrolled this class
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                    student_not_enroll = false;
                }
            }
            //judge whether the credit is valid
            if(credits > 0 && credits <= student.getCredits()){
                credit_valid = true;
            }
            Course target_course = find_course(courseId);
            if(isIfOpen() && course_find && student_not_enroll && credit_valid){
                student.getEnrollCourses().add(target_course);
                student.setEnrollCourses(student.getEnrollCourses());
                target_course.getEnrollStudent().add(student);
                target_course.setEnrollStudent(target_course.getEnrollStudent());//!!!!!!!!!!!!!!!
                target_course.getCredits().add(credits);
                student.setCredits(student.getCredits() - credits);
                return true;
            }
            return false;
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

    public Course find_course(String courseId) {
        Course course_target = null;
        //circulate to judge the existence of the courseId
        for (int i = 0; i < courses.size(); i++) {
            if (courseId.equals(courses.get(i).getCourseID())) {
                course_target = courses.get(i);
            }
        }
        return course_target;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        boolean course_find = false;
        boolean student_enroll = false;
        boolean credit_valid = false;
        Course course_target = null;
        //circulate to judge the existence of the courseId
        for (int i = 0; i < courses.size(); i++) {
            if(courseId.equals(courses.get(i).getCourseID())){
                course_find = true;
                course_target = courses.get(i);
                break;
            }
        }

        // If the course is not found
        if (!course_find || course_target == null) {
            return false;
        }

        //judge whether the student has enrolled this class
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                student_enroll = true;
                break;
            }
        }

        //judge whether the credit is valid
        int index = -1;//Ensure continue while finding out the valid index
        for (int i = 0; i < Objects.requireNonNull(course_target).getEnrollStudent().size(); i++) {
            if(course_target.getEnrollStudent().get(i).equals(student)){
                index = i;
                break;
            }
        }

        // If the index is still -1 and student not enrolled in the course
        if(index == -1 || !student_enroll) {
            return false;
        }

        //Do
        if(credits > 0 && credits <= student.getCredits() + course_target.getCredits().get(index)){
            credit_valid = true;
        }

        if(isIfOpen() && credit_valid){
            student.setCredits(student.getCredits() + course_target.getCredits().get(index) - credits);
            course_target.getCredits().set(index, credits);
            course_target.setCredits(course_target.getCredits());//Substitution
            return true;
        }

        return false;
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
        boolean course_find = false;
        boolean student_enroll = false;

        // Find the course
        Course course = find_course(courseId);

        // If the course is not found, return false or perform other error handling
        if (course == null) {
            return false;
        }

        //circulate to judge the existence of the courseId
        for (int i = 0; i < courses.size(); i++) {
            if(courseId.equals(courses.get(i).getCourseID())){
                course_find = true;
                break;
            }
        }

        //judge whether the student has enrolled this class
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                student_enroll = true;
                break;
            }
        }

        // If the student is not enrolled in the course, return false or perform other error handling
        if (!student_enroll) {
            return false;
        }

        // If the course is not found, return false or perform other error handling
        if (!course_find) {
            return false;
        }

        // Proceed
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if(course.getEnrollStudent().get(i).equals(student)){
                index = i;
                break;
            }
        }

        if(index != -1 && isIfOpen()){
            student.setCredits(student.getCredits() + course.getCredits().get(index));
            student.getEnrollCourses().remove(course);
            course.getCredits().remove(index);
            course.getEnrollStudent().remove(index);
            return true;
        }

        return false;
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
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCredits().isEmpty()) {

                continue;
            }
            //First Array
            for (int k = 0; k < courses.get(i).getCredits().size() - 1; k++) {
                for (int j = k + 1; j < courses.get(i).getCredits().size(); j++) {
                    if (courses.get(i).getCredits().get(k) < courses.get(i).getCredits().get(j)) {

                        int tempCredit = courses.get(i).getCredits().get(k);
                        courses.get(i).getCredits().set(k, courses.get(i).getCredits().get(j));
                        courses.get(i).getCredits().set(j, tempCredit);


                        Student tempStudent = courses.get(i).getEnrollStudent().get(k);
                        courses.get(i).getEnrollStudent().set(k, courses.get(i).getEnrollStudent().get(j));
                        courses.get(i).getEnrollStudent().set(j, tempStudent);
                    }
                }
            }
            //Compare the max capacity and the size
            if(courses.get(i).getMaxCapacity() < courses.get(i).getCredits().size()){
                if(!Objects.equals(courses.get(i).getCredits().get(courses.get(i).getMaxCapacity() - 1),
                        courses.get(i).getCredits().get(courses.get(i).getMaxCapacity()))) {
                    //Add
                    ArrayList<Student> success = new ArrayList<>();
                    for (int j = 0; j < courses.get(i).getMaxCapacity(); j++) {
                        success.add(courses.get(i).getEnrollStudent().get(j));
                    }
                    courses.get(i).setSuccessStudents(success);
                    //Remove
                    courses.get(i).setEnrollStudent(success);
                    //The fail student,lose the course
                    for (int j =  courses.get(i).getMaxCapacity(); j < courses.get(i).getEnrollStudent().size(); j++) {
                        courses.get(i).getEnrollStudent().get(j).getEnrollCourses().remove(courses.get(i));
                    }
                }
                //The students with the same credits fail
                else{
                    int bound = 0;
                    int a = 2;
                    //Maybe out of bond
                    while (a <= courses.get(i).getMaxCapacity() && Objects.equals(
                            courses.get(i).getCredits().get(courses.get(i).getMaxCapacity() - 1),
                            courses.get(i).getCredits().get(courses.get(i).getMaxCapacity() - a))) {
                        a ++;
                    }
                    bound = courses.get(i).getMaxCapacity() - a + 1;//Right
                    //Add
                    ArrayList<Student> success = new ArrayList<>();
                    for (int j = 0; j < bound; j++) {
                        success.add(courses.get(i).getEnrollStudent().get(j));
                    }
                    courses.get(i).setSuccessStudents(success);
                    //Remove
                    courses.get(i).setEnrollStudent(success);
                    //The fail student,lose the course
                    for (int j =  courses.get(i).getMaxCapacity(); j < courses.get(i).getEnrollStudent().size(); j++) {
                        courses.get(i).getEnrollStudent().get(j).getEnrollCourses().remove(courses.get(i));
                    }
                }
            }
            else {
                courses.get(i).setSuccessStudents(courses.get(i).getEnrollStudent());
            }
        }
        setIfOpen(false);
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
        if(isIfOpen()){
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int index = -1;
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if(student.getEnrollCourses().get(i).getEnrollStudent().get(j).equals(student)){
                        index = j;
                        break;
                    }
                }
                if(index != -1){
                    list.add(student.getEnrollCourses().get(i).getCourseID() + ": " +
                            student.getEnrollCourses().get(i).getCredits().get(index));
                }
            }
            return list;
        }
        return null;
    }
}

