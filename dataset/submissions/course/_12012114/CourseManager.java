import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    /**
     * Maintains a record of all courses successfully registered.
     * It is guaranteed that students enrolled in a course must exist in students.
     */
    private ArrayList<Course> courses ;

    /**
     *  Maintains a record of all students successfully registered.
     *  It is guaranteed that courses student enrolled in must exist in courses.
     */
    private ArrayList<Student> students;

    /**
     * Represent system open(true) or not(false).
     */
    private boolean ifOpen;

    public CourseManager(){
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }

    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    public void setIfOpen(Boolean ifOpen){
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen(){
        return this.ifOpen;
    }

    /**
     * Register a course. Add a course object to courses and set the courseManager
     * of the course object to this manager. It is guaranteed that all courseIDs are
     * unique.
     * @param course
     */
    public void addCourse(Course course){
        if(course != null){
            boolean flag = false;
            for (Course existCourse : this.courses) {
                if(existCourse.getCourseID().equals(course.getCourseID())){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                this.courses.add(course);
                course.setCourseManager(this);
            }
        }
    }

    /**
     * Register a course. Add a student object to students and set the courseManager
     * of the student object to this manager. It is guaranteed that all studentIDs are
     * unique.
     * @param student
     */
    public void addStudent(Student student){
        if(student != null){
            boolean flag = false;
            for (Student existStudent : this.students) {
                if(existStudent.getStudentID().equals(student.getStudentID())){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                student.setCourseManager(this);
                students.add(student);
            }
        }

    }

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
        if(ifOpen){
            Course order = null;
            for (Course course : courses) {
                if(course.getCourseID().equals(courseId)){
                    order = course;
                    break;
                }
            }
            boolean isEnroll = false;
            for (Course enrollCourse : student.getEnrollCourses()) {
                if (enrollCourse.getCourseID().equals(courseId)) {
                    isEnroll = true;
                    break;
                }
            }
            if(order != null && credits>0 && student.getCredits()>=credits && !isEnroll ){
                order.getEnrollStudent().add(student);
                order.getCredits().add(credits);
                student.getEnrollCourses().add(order);
                student.setCredits(student.getCredits()-credits);
                return true;
            }
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
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(ifOpen){
            Course order = null;
            for (Course course : courses) {
                if(course.getCourseID().equals(courseId)){
                    order = course;
                    break;
                }
            }
            Student enrollStudent = null;
            int enrollCredits = 0;
            int index = -1;
            for (int i = 0; i < order.getEnrollStudent().size(); i++) {
                if (order.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    enrollStudent = order.getEnrollStudent().get(i);
                    enrollCredits = order.getCredits().get(i);
                    index = i;
                    break;
                }
            }

            if(order != null && enrollStudent != null && student.getCredits()>=credits-enrollCredits ){
                order.getCredits().set(index,credits);
                student.setCredits(student.getCredits()-credits+enrollCredits);
                return true;
            }
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
        if(ifOpen){
            Course order = null;
            for (Course course : courses) {
                if(course.getCourseID().equals(courseId)){
                    order = course;
                    break;
                }
            }
            if(order != null){
                int index = -1;
                for (int i = 0; i < order.getEnrollStudent().size(); i++) {
                    if(order.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                        index = i;
                        break;
                    }
                }
                if(index >=0){
                    student.setCredits(student.getCredits()+order.getCredits().get(index));
                    for (Course enrollCourse : student.getEnrollCourses()) {
                        if (enrollCourse.getCourseID().equals(order.getCourseID())) {
                            student.getEnrollCourses().remove(enrollCourse);
                            break;
                        }
                    }
                    order.getEnrollStudent().remove(index);
                    order.getCredits().remove(index);
                    return true;
                }
            }
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
        this.ifOpen = false;
        for (Course course : courses) {
            int maxCapacity = course.getMaxCapacity();
            ArrayList<Integer> credits = course.getCredits();
            ArrayList<Integer> copy = new ArrayList<>(credits);

            while (course.getSuccessStudents().size()<maxCapacity){
                int maxValue = -1;
                for (int i = 0; i < copy.size(); i++) {
                    if(copy.get(i) > maxValue){
                        maxValue = copy.get(i);
                    }
                }
                if(maxValue >= 0){
                    List<Integer> maxIndex = new ArrayList<>();
                    for (int i = 0; i < copy.size(); i++) {
                        if (copy.get(i) == maxValue) {
                            maxIndex.add(i);
                        }
                    }
                    if(maxIndex.size() <= course.getMaxCapacity()-course.getSuccessStudents().size()){
                        for (Integer index : maxIndex) {
                            copy.set(index,Integer.MIN_VALUE);
                            Student student = course.getEnrollStudent().get(index);
                            course.getSuccessStudents().add(student);
                            student.getSuccessCourses().add(course);
                        }
                    }else{
                        break;
                    }
                }else {
                    break;
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
            ArrayList<String> courses = new ArrayList<String>();
            for (Course enrollCourse : student.getEnrollCourses()) {
                for (int i = 0; i < enrollCourse.getEnrollStudent().size(); i++) {
                    if (enrollCourse.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        courses.add(enrollCourse.getCourseID()+": "+enrollCourse.getCredits().get(i));
                        break;
                    }
                }
            }
            return courses;
        }
        return null;
    }
}