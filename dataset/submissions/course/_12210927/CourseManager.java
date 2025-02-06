import java.util.*;

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
    // Constructor, initializes the course and student lists, and set the system


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
        courses.add(course);
        course.setCourseManager(this);
    }
/*    // Register a course. Add a course object to courses and set the courseManager
    of the course object to this manager. It is guaranteed that all courseIDs are
    unique.*/
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
/*    // Register a course. Add a student object to students and set the courseManager
    of the student object to this manager. It is guaranteed that all studentIDs are
    unique.*/
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
        boolean a = true;
        if (credits<=0){
            a = false;
        }else {
            if (student.getCredits()<credits){
                a = false;
            }
        }
        if (!ifOpen){
            a = false;
        }

        for (int i=0;i<student.getEnrollCourses().size();i++){
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                a = false;
                break;
            }
        }
        if (a){
            boolean b =false;
            if (!courses.isEmpty()){
                for (Course cours : courses) {
                    if (cours.getCourseID().equals(courseId)) {
                        b = true;
                        student.getEnrollCourses().add(cours);
                        student.setCredits(student.getCredits() - credits);
                        cours.getEnrollStudent().add(student);
                        cours.getCredits().add(credits);

                    }
                }
            }
            if (!b){
                a = false;
            }
        }
        return a;

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
        boolean a = true;
        boolean c = false;
        for (int i=0;i<student.getEnrollCourses().size();i++){
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                c = true;
                break;
            }
        }
        if (!c){
            a = false;
        }
        if (credits<=0){
            a = false;
        }
        if (!ifOpen){
            a = false;
        }
        if (a){
            boolean b =false;
            if (!courses.isEmpty()){
                for (Course cours : courses) {
                    if (cours.getCourseID().equals(courseId)) {
                        for (int j = 0; j < cours.getEnrollStudent().size(); j++) {
                            if (cours.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                                if (student.getCredits() >= credits - cours.getCredits().get(j)) {
                                    student.setCredits(student.getCredits() - credits + cours.getCredits().get(j));
                                    cours.getCredits().set(j, credits);
                                    b = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (!b){
                a = false;
            }
        }
        return a;

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
        boolean a = ifOpen;
        boolean c = false;
        int guo = 0;
        for (int i=0;i<student.getEnrollCourses().size();i++){
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                c = true;
                guo = i;
                break;
            }
        }
        if (!c){
            a = false;
        }
        if (a){
            boolean b = false;
            for (int i =0;i<courses.size();i++){
                if (courses.get(i).getCourseID().equals(courseId)){
                    for (int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                        if (courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                            courses.get(i).getEnrollStudent().remove(j);
                            int m = courses.get(i).getCredits().remove(j);
                            student.setCredits(student.getCredits()+m);
                            student.getEnrollCourses().remove(guo);
                            b = true;
                        }
                    }
                }
            }
            if (!b){
                a = false;
            }
        }

        return a;
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
        for (int i = 0;i<courses.size();i++){
            if (courses.get(i).getMaxCapacity()<courses.get(i).getCredits().size()){
                int jg = Integer.MAX_VALUE;
                ArrayList<Integer> curr = new ArrayList<>(courses.get(i).getCredits());
                Collections.sort(curr);

                if (curr.get(curr.size()-courses.get(i).getMaxCapacity())==curr.get(curr.size()-courses.get(i).getMaxCapacity()-1)){
                    for (int m = curr.size()-courses.get(i).getMaxCapacity();m<curr.size();m++){
                        if (curr.get(m)>curr.get(m-1)){
                            jg = curr.get(m);
                            break;
                        }
                    }
                }else {
                    jg = curr.get(curr.size()-courses.get(i).getMaxCapacity());
                }

                for (int j =0;j<courses.get(i).getCredits().size();j++){
                    if (courses.get(i).getCredits().get(j)>=jg){
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                        courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                    }
                }
            }else {
                for (int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
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
        if (ifOpen) {
            ArrayList<String> a = new ArrayList<>();
            for (int i =0;i<student.getEnrollCourses().size();i++){
                for (int j =0;j<student.getEnrollCourses().get(i).getEnrollStudent().size();j++){
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        String cre = String.valueOf(student.getEnrollCourses().get(i).getCredits().get(j));
                        a.add(student.getEnrollCourses().get(i).getCourseID()+": "+cre);
                    }
                }
            }
            return a;
        }else {
            return null;
        }

    }
}
