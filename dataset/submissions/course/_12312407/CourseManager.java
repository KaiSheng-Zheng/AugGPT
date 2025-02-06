import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseManager {

    //Fields:

    private ArrayList<Course> courses;
// Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.

    private ArrayList<Student> students;
// Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.

    private boolean ifOpen;
// Represent system open(true) or not(false).

    //Constructor:

    public CourseManager(){
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }
// Constructor, initializes the course and student lists, and set the system default status open(true).

    //Methods:

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
        if (!this.courses.contains(course)) {
            this.courses.add(course);
            course.setCourseManager(this);
        }
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student){
        if (!this.students.contains(student)) {
            this.students.add(student);
            student.setCourseManager(this);
        }
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
        //jian cha shi fou kai fang
        if (!this.ifOpen) {
            return false;
        }
        //jian cha deng ji xue sheng xin xi shi fou you xiao.
        if (student == null || credits <= 0) {
            return false;
        }
        Course course = findCourseId(courseId);
        ////jian cha deng ji ke cheng xin xi shi fou you xiao.
        if (course == null) {
            return false;
        }
        //ru guo xue sheng yi jing deng ji.
        if (course.getEnrollStudent().contains(student)) {
            return false;
        }
        //ru guo xue sheng tou fen guo gao.
        if (student.getCredits() < credits) {
            return false;
        }
        //zhu ce ke cheng,deng ji ming zi.
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        //zhu ru xue fen.
        course.getCredits().add(credits);
        //geng xin xue fen.
        student.setCredits(student.getCredits() - credits);
        return true;

    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!this.ifOpen) {
            return false;
        }

        if (student == null || credits <= 0) {
            return false;
        }

        Course course = findCourseId(courseId);
        if (course == null) {
            return false;
        }

        if (!course.getEnrollStudent().contains(student)) {
            return false;
        }

        int currentBid = studentCredits(course, student);

        if (currentBid == 0) {

            return false;
        }
        //ru guo xiu gai de fen shu guo gao.
        if (student.getCredits() < credits - currentBid) {
            return false;
        }

        for (int i = 0; i < course.getCredits().size(); i++) {
            if (course.getCredits().get(i).equals(currentBid)) {
                course.getCredits().set(i, credits);
                break;
            }
        }
        //huo qu tou fen.

        // gen xin xue sheng sheng yu zong fen.
        student.setCredits(student.getCredits() + currentBid - credits);

        return true;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!this.ifOpen) {
            return false;
        }
        if (student == null ) {
            return false;
        }
        Course course = findCourseId(courseId);
        if (course == null) {
            return false;
        }
        if (!course.getEnrollStudent().contains(student)) {
            return false;
        }

        student.setCredits(student.getCredits() + studentCredits(course, student));
        //jia hui fen shu
        course.getCredits().remove(Integer.valueOf(studentCredits(course, student)));
        //yi chu
        course.getEnrollStudent().remove(student);
        //yi chu xue sheng ji lu.
        student.getEnrollCourses().remove(course);
        //yi chu ke cheng ji lu.

        return true;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        this.ifOpen = false;
        
        for (Course course : this.courses) {
            List<Student> enrolledStudents = new ArrayList<>(course.getEnrollStudent());
            // yi bao ming xue sheng.
            List<Integer> creditsList = new ArrayList<>(course.getCredits());
            // xue sheng de tou fen.

            // dui tou fen jin xing pai xv.
            for (int i = 0; i < enrolledStudents.size() - 1; i++) {
                for (int j = i + 1; j < enrolledStudents.size(); j++) {
                    if (creditsList.get(j) > creditsList.get(i)) {
                        Collections.swap(enrolledStudents, i, j);
                        Collections.swap(creditsList, i, j);
                    }
                }
            }
            //AI ti gong de cong da dao xiao pai xv fang fa.

            List<Student> successStudents = new ArrayList<>();
            // xuan ke cheng gong xue sheng
            int capacity = course.getMaxCapacity();
            // ke cheng rong liang

            // an zhao tou fen cong gao dao di pai xv
            for (int i = 0; i < enrolledStudents.size() && successStudents.size() < capacity; i++) {
                //xiao yu xue sheng ren shu, xiao yu ke cheng rong liang.
                Student selectedStudent = enrolledStudents.get(i);
                successStudents.add(selectedStudent);

                // tong fen zhi liu yi bu fen ren.
                if (i < enrolledStudents.size() - 1 && creditsList.get(i) == creditsList.get(i + 1)) {
                    enrolledStudents.remove(i + 1);
                    creditsList.remove(i + 1);
                    i--;
                }
            }

            // geng xin xuan ke cheng gong lie biao
            course.setSuccessStudents(new ArrayList<>(successStudents));
        }
    }

    //Since It can't write Chinese notes, I chose to use pinyin instead.
    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!this.ifOpen) {
            return null;
        }
        if (student == null) {
            return null;
        }
        //zhu ce ke cheng suo yong xue fen.
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        //zhu ce cheng gong xue sheng.
        ArrayList<Course> enrollCourses = student.getEnrollCourses();

        if (enrollCourses == null || enrollCourses.isEmpty()) {
            return enrolledCoursesWithCredits;
        }
        for (Course course : enrollCourses) {
            int studentCredits = 0;
            for (int i = 0; i < course.getCredits().size(); i++) {
                if (course.getEnrollStudent().get(i).equals(student)) {
                    studentCredits = course.getCredits().get(i);
                    break;
                }
            }
            enrolledCoursesWithCredits.add(course.getCourseID() + ": " + studentCredits);
        }
        return enrolledCoursesWithCredits;
    }
    /**
     * used AI in the process of writing the homework.
     * The main thing is to use AI to help understand the problem, build some methods, build some Arraylists, and simplify the process.
    */


    //Find out if the ecourseId exists.
    public Course findCourseId(String courseId) {
        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    //Matching student credits.
    public int studentCredits(Course course, Student student) {
        if (course == null || student == null) {
            return 0;
        }
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                return course.getCredits().get(i);
            }
        }
        return 0;
    }
}
