package ass4;

import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
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
        this.ifOpen = ifOpen;
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
// Register a course. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (!ifOpen){
            return false;
        }

        if(credits < 0){
            return false;
        }

        int courseIndex = -1;
        int studentIndex = -1;
        for (int i = 0; i < this.courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                courseIndex = i;
                break;
            }
        }
        if(courseIndex == -1){
            return false;
        }
        Course thisCourse = this.courses.get(courseIndex);

        for (int i = 0; i < thisCourse.getEnrollStudent().size(); i++) {
            if(thisCourse.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                studentIndex = i;
                return false;
            }
        }

        if(student.getCredits() < credits){
            return false;
        }
        else{
            //thisCourse.getEnrollStudent().add(student); //need to be sorted
            //thisCourse.getCredits().add(credits);       //need to be sorted

            int putPosition = -1;
            for (int i = 0; i < thisCourse.getCredits().size(); i++) {
                if(credits > thisCourse.getCredits().get(i)){
                    putPosition = i;
                    break;
                }
            }
            if(putPosition == -1){
                thisCourse.getEnrollStudent().add(student);
                thisCourse.getCredits().add(credits);
            }
            else{
                Student tempStudent = thisCourse.getEnrollStudent().get(thisCourse.getEnrollStudent().size() - 1);
                int tempCredit = thisCourse.getCredits().get(thisCourse.getCredits().size() - 1);
                thisCourse.getEnrollStudent().add(tempStudent);
                thisCourse.getCredits().add(tempCredit);
                for (int i = thisCourse.getCredits().size() - 2; i > putPosition; i--) {
                    tempStudent = thisCourse.getEnrollStudent().get(i-1);
                    tempCredit = thisCourse.getCredits().get(i-1);
                    thisCourse.getEnrollStudent().set(i, tempStudent);
                    thisCourse.getCredits().set(i, tempCredit);
                }
                thisCourse.getEnrollStudent().set(putPosition, student);
                thisCourse.getCredits().set(putPosition, credits);
            }

            student.getEnrollCourses().add(thisCourse);
            student.setCredits(student.getCredits() - credits);
        }

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
        if(!ifOpen){
            return false;
        }

        int courseIndex = -1;
        int studentIndex = -1;
        for (int i = 0; i < this.courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                courseIndex = i;
                break;
            }
        }
        if(courseIndex == -1){
            return false;
        }
        Course thisCourse = this.courses.get(courseIndex);

        for (int i = 0; i < thisCourse.getEnrollStudent().size(); i++) {
            if(thisCourse.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                studentIndex = i;
                break;
            }
        }
        if(studentIndex == -1){
            return false;
        }
        Student thisStudent = thisCourse.getEnrollStudent().get(studentIndex);

        if(thisStudent.getCredits() + thisCourse.getCredits().get(studentIndex) < credits){
            return false;
        }
        else{
            int originalCredit =  thisCourse.getCredits().get(studentIndex);
            //thisCourse.getCredits().set(studentIndex, credits);                 //need to be sorted
            //thisStudent.setCredits(thisStudent.getCredits() + originalCredit);

            dropStudentEnrollmentCourse(student, courseId);
            enrollStudentInCourse(student, courseId, credits);
        }

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
        if(!ifOpen){
            return false;
        }

        int courseIndex = -1;
        int studentIndex = -1;
        for (int i = 0; i < this.courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                courseIndex = i;
                break;
            }
        }
        if(courseIndex == -1){
            return false;
        }
        Course thisCourse = this.courses.get(courseIndex);

        int credit = 0;
        for (int i = 0; i < thisCourse.getEnrollStudent().size(); i++) {
            if(thisCourse.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                studentIndex = i;
                credit = thisCourse.getCredits().get(studentIndex);
                break;
            }
        }
        if(studentIndex == -1){
            return false;
        }
        Student thisStudent = thisCourse.getEnrollStudent().get(studentIndex);

        thisCourse.getEnrollStudent().remove(studentIndex);
        thisCourse.getCredits().remove(studentIndex);
        student.getEnrollCourses().remove(thisCourse);
        student.setCredits(student.getCredits() + credit);

        return true;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        setIfOpen(false);
        for (int i = 0; i < getCourses().size(); i++) {
            Course tempCourse = getCourses().get(i);
            int successAmount = 0;
            int currentAmount = 0;
            int currentCredit = 0;

            if(tempCourse.getMaxCapacity() >= tempCourse.getEnrollStudent().size()){
                //successAmount = tempCourse.getSuccessStudents().size();
                tempCourse.setSuccessStudents(tempCourse.getEnrollStudent());
                for (int j = 0; j < tempCourse.getSuccessStudents().size(); j++) {
                    tempCourse.getSuccessStudents().get(j).getSuccessCourses().add(tempCourse);
                }
            }
            else{
                for (int j = 0; j < tempCourse.getCredits().size(); ) {
                    currentAmount = 0;
                    currentCredit = tempCourse.getCredits().get(j);
                    for (int k = j; k < tempCourse.getCredits().size(); k++) {
                        if(tempCourse.getCredits().get(k) == currentCredit){
                            currentAmount ++;
                        }
                        if(tempCourse.getCredits().get(k) != currentCredit){
                            break;
                        }
                    }

                    if(currentAmount + successAmount > tempCourse.getMaxCapacity()){
                        return;
                    }
                    else{
                        successAmount += currentAmount;

                        for (int k = j; k < j + currentAmount; k++) {
                            // here to add
                            tempCourse.getSuccessStudents().add(tempCourse.getEnrollStudent().get(k));
                            tempCourse.getEnrollStudent().get(k).getSuccessCourses().add(tempCourse);
                        }

                        j += currentAmount;
                    }
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
        if(!ifOpen){
            return null;
        }

        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course tempCourse = student.getEnrollCourses().get(i);
            int credit  = -1;
            for (int j = 0; j < tempCourse.getEnrollStudent().size(); j++) {
                if(student.getStudentID().equals(tempCourse.getEnrollStudent().get(j).getStudentID())){
                    credit = tempCourse.getCredits().get(j);
                    break;
                }
            }

            String str = String.format("%s: %d", tempCourse.getCourseID(), credit);
            res.add(str);
        }

        return res;
    }
}


class Course {
    private String courseID;
    private String courseName;
    private int maxCapacity;
    private CourseManager courseManager;
    private ArrayList<Student> enrollStudent;
    private ArrayList<Integer> credits;
    private ArrayList<Student> successStudents;

    public Course(String courseID, String courseName, int maxCapacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.courseManager = null;
        this.enrollStudent = new ArrayList<>();
        this.credits = new ArrayList<>();
        this.successStudents = new ArrayList<>();
    }

    public void setEnrollStudent(ArrayList<Student> enrollStudent) {
        this.enrollStudent = enrollStudent;
    }

    public void setCredits(ArrayList<Integer> credits) {
        this.credits = credits;
    }

    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public ArrayList<Integer> getCredits() {
        return credits;
    }

    public ArrayList<Student> getEnrollStudent() {
        return enrollStudent;
    }

    public String getCourseID() {
        return courseID;
    }

    public ArrayList<Student> getSuccessStudents() {
        return successStudents;
    }

    public void setSuccessStudents(ArrayList<Student> successStudents) {
        this.successStudents = successStudents;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}


class Student {
    private String studentID;
    private String email;
    private String name;
    private CourseManager courseManager;
    private int credits;
    private ArrayList<Course> enrollCourses;
    private ArrayList<Course> successCourses;

    public Student(String studentID, String email, String name, int credits) {
        this.studentID = studentID;
        this.email = email;
        this.name = name;
        this.courseManager = null;
        this.credits = credits;
        this.enrollCourses = new ArrayList<>();
        this.successCourses = new ArrayList<>();
    }

    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public ArrayList<Course> getEnrollCourses() {
        return enrollCourses;
    }

    public boolean enrollCourse(String courseId, int credits) {
        return courseManager.enrollStudentInCourse(this, courseId, credits);
    }

    public void setEnrollCourses(ArrayList<Course> enrollCourses) {
        this.enrollCourses = enrollCourses;
    }

    public boolean modifyEnrollCredit(String courseId, int credits) {
        return courseManager.modifyStudentEnrollmentCredits(this, courseId, credits);
    }

    public boolean dropEnrollCourse(String courseId) {
        return courseManager.dropStudentEnrollmentCourse(this, courseId);
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public ArrayList<Course> getSuccessCourses() {
        return successCourses;
    }

    public void setSuccessCourses(ArrayList<Course> successCourses) {
        this.successCourses = successCourses;
    }

    public ArrayList<String> getCoursesWithScores() {
        return courseManager.getEnrolledCoursesWithCredits(this);
    }

    public String getStudentID() {
        return this.studentID;
    }
}
