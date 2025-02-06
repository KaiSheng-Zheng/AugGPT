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
public CourseManager() {
    courses = new ArrayList<>();
    students = new ArrayList<>();
    ifOpen = true;
}
// Constructor, initializes the course and student lists, and set the system default status open(true).
public ArrayList<Student> getStudents(){
// getter for students
    return students;
}

    public ArrayList<Course> getCourses(){
// getter for courses
        return courses;
    }


    public void setIfOpen(Boolean ifOpen){
// setter for ifOpen
        this.ifOpen = ifOpen;
    }


    public boolean getIfOpen(){
// getter for ifOpen
        return ifOpen;
    }

    public void addCourse(Course course){
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student){
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.
        students.add(student);
        student.setCourseManager(this);
    }
    // Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.
    //set the courseManager of the course object to this manager in addCourse
    //set the courseManager of the course object to this manager in addCourse
    //set the courseManager of the course object to this manager in addCourse
    //set the courseManager of the student object to this manager in addStudent
    //set the courseManager of the student object to this manager in addStudent
    //set the courseManager of the student object to this manager in addStudent
    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (!ifOpen) {return false;}
        else {
            Course course = null;
            for (Course c : courses) {
                if (c.getCourseID().equals(courseId)) {
                    course = c;
                    break;
                }
            }
            if (course == null) {return false;}
            if (student.getEnrollCourses().contains(course)) {return false;}
            if (credits <= 0) return false;
            if (student.getCredits() < credits) return false;
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(course);
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            return true;
        }
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!ifOpen) {return false;}
        else {
            Course course = null;
            for (Course c : courses) {
                if (c.getCourseID().equals(courseId)) {
                    course = c;
                    break;
                }
            }
            if (course == null) {return false;}
            if (!student.getEnrollCourses().contains(course)) {return false;}
            if (credits <= 0) return false;
            if (student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)) - credits < 0) return false;
            student.setCredits(student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)) - credits);
            course.getCredits().set(course.getEnrollStudent().indexOf(student), credits);
            return true;
        }
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!ifOpen) {return false;}
        else {
            Course course = null;
            for (Course c : courses) {
                if (c.getCourseID().equals(courseId)) {
                    course = c;
                    break;
                }
            }
            if (course == null) {return false;}
            if (!student.getEnrollCourses().contains(course)) {return false;}
            student.setCredits(student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
            student.getEnrollCourses().remove(course);
            course.getCredits().remove(course.getEnrollStudent().indexOf(student));
            course.getEnrollStudent().remove(student);
            return true;
        }
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments() {
        if (!ifOpen) {
            return;
        } else {
            for (Course course : courses) {
                int max = course.getMaxCapacity();
                int num = course.getEnrollStudent().size();
                if (num <= max) {
                    course.getSuccessStudents().addAll(course.getEnrollStudent());
                    course.getEnrollStudent().clear();
                    course.getCredits().clear();
                } else {
                   
                    ArrayList<Integer> credits = new ArrayList<>();
                    for (int i = 0; i < num; i++) {
                        credits.add(course.getCredits().get(i));
                    }
                    credits.sort((o1, o2) -> o2 - o1);
                    int a = credits.get(0);
                    int min = credits.get(max);

                    System.out.println(credits);
                   int temp=credits.get(max-1);
                    System.out.println(temp);
                    System.out.println(min);
                   if (temp==min){
//                       System.out.println("sadsadas");
                       for (int i = 0; i < num; i++) {
                           if (course.getCredits().get(i) > temp) {
                               course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                           }
                       }
                   }else {
//                       System.out.println("esls");
                       for (int i = 0; i < num; i++) {
                           if (course.getCredits().get(i) >= temp) {
                               course.getSuccessStudents().add(course.getEnrollStudent().get(i));
//                               System.out.println("succ  " + i);
                           }
                       }
                   }

                }
            }
            for (Student student : students) {
                for (Course course : student.getEnrollCourses()) {
                    if (course.getSuccessStudents().contains(student)) {
                        student.getSuccessCourses().add(course);
                    }
                }
            }
            ifOpen = false;
        }
    }
    //It should be noted that, as in the case of our normal selection, if the number of electors exceeds the maximum number of courses, the principle of "same credit, same drop" will be followed.
    //Eg. If the maximum number of students is 10, and 15 students choose this course, and after sorted by enrolled points, if the 8th, 9th, 10th, and 11th students are all of the same credit, then the four of them will not be able to choose the course successfully, and the number of successful students will be seven.

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen) {return null;}
        else {
            ArrayList<String> res = new ArrayList<>();
            for (Course course : student.getEnrollCourses()) {
                res.add(course.getCourseID() + ": " + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
            }
            return res;
        }
    }


}
