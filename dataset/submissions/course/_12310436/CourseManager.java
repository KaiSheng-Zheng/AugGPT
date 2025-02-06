import java.util.ArrayList;
import java.util.List;

public class CourseManager {
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
        ifOpen=true;
        courses= new ArrayList<>();
        students = new ArrayList<>();

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
        this.ifOpen=ifOpen;
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
        boolean m1=false;
        int c=0;
        for (int i = 0; i < courses.size(); i++) {
            if(courseId.equals(courses.get(i).getCourseID())){
                m1=true;
                c=i;
            }
        }
        boolean m2=true;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if(courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                m2=false;
            }
        }
        boolean m3=false;
        if(credits>0){
            m3=true;
        }
        boolean m4=false;
        if(student.getCredits()>=credits){
            m4=true;
        }
        boolean m5=false;
        if(ifOpen==true){
            m5=true;
        }
        if(m1==true && m2==true && m3==true && m4==true && m5==true){
            student.setCredits(student.getCredits()-credits);
            student.getEnrollCourses().add(courses.get(c));
            student.setEnrollCourses(student.getEnrollCourses());
            courses.get(c).getEnrollStudent().add(student);
            courses.get(c).setEnrollStudent(courses.get(c).getEnrollStudent());
            courses.get(c).getCredits().add(credits);
            return true;
        }else{
            return false;
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
        boolean m1=false;
        int c=0;
        for (int i = 0; i < courses.size(); i++) {
            if(courseId.equals(courses.get(i).getCourseID())){
                m1=true;
                c=i;
            }
        }
        boolean m2=false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if(courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                m2=true;
            }
        }
        if(m2==false){
            return false;
        }
        boolean m3=false;
        int m = 0 ;
        if(m1==true){
            for (int i = 0; i < courses.get(c).getEnrollStudent().size(); i++) {
                if(student.equals(courses.get(c).getEnrollStudent().get(i))){
                    m=i;
                }
            }
            int credit1=courses.get(c).getCredits().get(m);
            if(student.getCredits()+credit1 >= credits){
                m3=true;
            }
        }
        if(ifOpen==true && m1==true && m2==true && m3==true){
            student.setCredits(student.getCredits()+courses.get(c).getCredits().get(m)-credits);
            courses.get(c).getCredits().set(m,credits);
            return true;
        }else{
            return false;
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
        boolean m1=false;
        int c=0;
        for (int i = 0; i < courses.size(); i++) {
            if(courseId.equals(courses.get(i).getCourseID())){
                m1=true;
                c=i;
            }
        }
        boolean m2=false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if(courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                m2=true;
            }
        }
        int m=0;
        int n=0;
        if(m1==true){
            for (int i = 0; i < courses.get(c).getEnrollStudent().size(); i++) {
                if(student.equals(courses.get(c).getEnrollStudent().get(i))){
                    m=i;
                }
            }
            for (int i = 0; i <student.getEnrollCourses().size(); i++) {
                if(courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                    n=i;
                }
            }
        }
        if(m1==true && m2==true && ifOpen==true){
            student.setCredits(student.getCredits()+courses.get(c).getCredits().get(m));
            student.getEnrollCourses().remove(n);
            courses.get(c).getEnrollStudent().remove(m);
            courses.get(c).getCredits().remove(m);
            return true;
        }else{
            return false;
        }

    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        setIfOpen(false);
        if(ifOpen==false){
            for (int i = 0; i < courses.size(); i++) {
                for (int j = 1; j < courses.get(i).getCredits().size(); j++) {
                    for (int k = j; k > 0; k--) {
                        if(courses.get(i).getCredits().get(k)>courses.get(i).getCredits().get(k-1)){
                            int b =courses.get(i).getCredits().get(k-1);
                            courses.get(i).getCredits().set(k-1,courses.get(i).getCredits().get(k));
                            courses.get(i).getCredits().set(k,b);
                            Student a = courses.get(i).getEnrollStudent().get(k-1);
                            courses.get(i).getEnrollStudent().set(k-1,courses.get(i).getEnrollStudent().get(k));
                            courses.get(i).getEnrollStudent().set(k,a);
                        }
                    }
                }
            }
            for (int i = 0; i < courses.size(); i++) {

                int subscrip = -1;
                if(courses.get(i).getCredits().size()<=courses.get(i).getMaxCapacity()){
                    subscrip=courses.get(i).getCredits().size()-1;
                }else{
                    for (int j = 0; j < courses.get(i).getMaxCapacity(); j++) {
                        if(courses.get(i).getCredits().get(j)!=courses.get(i).getCredits().get(j+1)){
                            subscrip=j;
                        }
                    }
                }
                for (int j = 0; j < subscrip+1; j++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
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
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen==true){
            ArrayList<String> studentenroll = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int studentcredit=0;
                for (int j = 0; j <student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if(student.getStudentID().equals(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID())){
                        studentcredit=student.getEnrollCourses().get(i).getCredits().get(j);
                        break;
                    }
                }
                studentenroll.add(student.getEnrollCourses().get(i).getCourseID() + ": " +studentcredit);
            }
            return (studentenroll);
        }else{
            return null;
        }
    }





}
