import java.util.ArrayList;

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
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student){
        students.add(student);
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
        boolean enroll = false;
        if(ifOpen && credits > 0){
            for(Course c : courses){
                if(c.getCourseID().equals(courseId) && student.getCredits() >= credits && !c.getEnrollStudent().contains(student)){
                    c.getEnrollStudent().add(student);
                    c.getCredits().add(credits);
                    student.setCredits(student.getCredits() - credits);
                    student.getEnrollCourses().add(c);
                    enroll = true;
                }
            }
        }
        return enroll;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        boolean modify = false;
        if(ifOpen && credits > 0){
            for(Course c : courses){
                if(c.getCourseID().equals(courseId)){
                    for(int i = 0; i < c.getEnrollStudent().size(); i ++){
                        if(c.getEnrollStudent().get(i) == student && c.getCredits().get(i) + student.getCredits() >= credits){
                            student.setCredits(c.getCredits().get(i) + student.getCredits() - credits);
                            c.getCredits().set(i, credits);
                            modify = true;
                        }
                    }
                }
            }
        }
        return modify;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        boolean drop = false;
        if(ifOpen){
            for(Course c : courses){
                if(c.getCourseID().equals(courseId)){
                    for(int i = 0; i < c.getEnrollStudent().size(); i++){
                        if(c.getEnrollStudent().get(i) == student){
                            student.setCredits(student.getCredits() + c.getCredits().get(i));
                            c.getCredits().remove(i);
                            c.getEnrollStudent().remove(i);
                            student.getEnrollCourses().remove(c);
                            drop = true;
                        }
                    }
                }
            }
        }
        return drop;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        if(ifOpen){
            for(Course c : courses){
                int capacity = c.getMaxCapacity();
                if(capacity >= c.getCredits().size()){
                    for(int j = 0; j < c.getCredits().size(); j++){
                        c.getEnrollStudent().get(j).getSuccessCourses().add(c);
                        c.getSuccessStudents().add(c.getEnrollStudent().get(j));
                    }
                } else {
                    //sort
                    int len = c.getCredits().size();
                    for(int i = 0; i < len - 1; i ++){
                        for(int j = i + 1; j < len; j ++){
                            if(c.getCredits().get(i) < c.getCredits().get(j)){
                                int cre = c.getCredits().get(i);
                                c.getCredits().set(i, c.getCredits().get(j));
                                c.getCredits().set(j, cre);
                                Student stu = c.getEnrollStudent().get(i);
                                c.getEnrollStudent().set(i, c.getEnrollStudent().get(j));
                                c.getEnrollStudent().set(j,stu);
                            }
                        }
                    }
                    int numSameCredits = 0;
                    int num = c.getCredits().get(capacity);
                    for(int i = capacity - 1; i >= 0; i --){
                        if(num == c.getCredits().get(i)) numSameCredits ++;
                        else break;
                    }
                    //success
                    
                    for(int i = 0; i < capacity - numSameCredits; i++){
                        c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                        c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    }
//                    for(int j = capacity; j < creditsInput.get(i).size(); j ++){
//                        enrollStudents.get(i).get(j).getEnrollCourses().remove(courses.get(i));
//                    }
                }
            }
            ifOpen = false;
        }
    }

//    It should be noted that, as in the case of our normal selection, if the number of electors exceeds the maximum number of courses, the principle of "same credit, same drop" will be followed.
//    Eg. If the maximum number of students is 10, and 15 students choose this course, and after sorted by enrolled points, if the 8th, 9th, 10th, and 11th students are all of the same credit, then the four of them will not be able to choose the course successfully, and the number of successful students will be seven.

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (ifOpen){
            ArrayList<String> EnrolledCoursesWithCredits = new ArrayList<>();
            for(Course c : courses){
                int n = c.getEnrollStudent().indexOf(student);
                if(n != -1){
                    EnrolledCoursesWithCredits.add(String.format("%s: %d", c.getCourseID(), c.getCredits().get(n)));
                }
            }
            return EnrolledCoursesWithCredits;
        }
        return null;
    }

// Constructor, initializes the course and student lists, and set the system default status open(true).



}
