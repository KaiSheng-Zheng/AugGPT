import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class CourseManager {
        private ArrayList<Course> courses=new ArrayList<>();
// Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.

        private ArrayList<Student> students=new ArrayList<>();
// Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.

        private boolean ifOpen;
// Represent system open(true) or not(false).
public CourseManager(){
    ifOpen=true;
}
// Constructor, initializes the course and student lists, and set the system default status open(true).
public ArrayList<Student> getStudents(){return students;}
// getter for students

    public ArrayList<Course> getCourses(){return courses;}
// getter for courses

    public void setIfOpen(Boolean ifOpen){this.ifOpen=ifOpen;}
// setter for ifOpen

    public boolean getIfOpen(){return ifOpen;}
// getter for ifOpen
    private boolean checkCourse(String courseid,ArrayList<Course>a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getCourseID().equals(courseid)) {
                return true;
            }
        }return false;
    }

    public void addCourse(Course course){
        if(checkCourse(course.getCourseID(),courses)==false){this.courses.add(course);course.setCourseManager(this);
    }
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    private boolean checkStudent(String student,ArrayList<Student>a){
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).getStudentID().equals(student) ){
                    return true;
                } } return false;
            }
            public void addStudent (Student student){
                if (checkStudent(student.getStudentID(),students) == false) {
                    this.students.add(student);
                    student.setCourseManager(this);
                }
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.
            }
        Map<String,Integer>a=new HashMap<>();

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(ifOpen==true){for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                if(checkStudent(student.getStudentID(),courses.get(i).getEnrollStudent())==false) {
                    if(credits>0&credits<=student.getCredits()) {
                        student.setCredits(student.getCredits()-credits);
                        ArrayList<Student>tran=courses.get(i).getEnrollStudent();
                        tran.add(student);
                        courses.get(i).setEnrollStudent(tran);
                        ArrayList<Course>tranb=student.getEnrollCourses();
                        tranb.add(courses.get(i));
                        student.setEnrollCourses(tranb);
                        a.put(student.getStudentID()+courses.get(i).getCourseID(),credits);
                        ArrayList<Integer>tranc=courses.get(i).getCredits();
                        tranc.add(credits);
                        courses.get(i).setCredits(tranc);
                        return true;
                    }}}}}
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
        if(ifOpen==true) {if(checkCourse(courseId,student.getEnrollCourses())==true) {
            if(credits<=student.getCredits()+a.get(student.getStudentID()+courseId)) {
                for(int i=0;i<courses.size();i++){
                    if(courses.get(i).getCourseID().equals(courseId))
                    {ArrayList<Integer>k=courses.get(i).getCredits();
                            k.remove(a.get(student.getStudentID()+courseId));
                            k.add(credits);
                            courses.get(i).setCredits(k);}}
                student.setCredits(student.getCredits()+a.get(student.getStudentID()+courseId)-credits);
                a.put(student.getStudentID()+courseId,credits);
                return true;

            }}}return false;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(ifOpen==true) {if(checkCourse(courseId,student.getEnrollCourses())==true) {
            student.setCredits(student.getCredits()+a.get(student.getStudentID()+courseId));
            for(int i=0;i<courses.size();i++){
                if(courses.get(i).getCourseID().equals(courseId)){
                    ArrayList<Integer>k=courses.get(i).getCredits();
                    k.remove(a.get(student.getStudentID()+courseId));
                    courses.get(i).setCredits(k);
                    ArrayList<Student>t=courses.get(i).getEnrollStudent();
                    t.remove(student);
                    courses.get(i).setEnrollStudent(t);
                    ArrayList<Course>u=student.getEnrollCourses();
                    u.remove(courses.get(i));
                    student.setEnrollCourses(u);
                }
            }
                    a.put(student.getStudentID()+courseId,0);
            return true;
        }}return false;}

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        ifOpen=false;
        for(int i=0;i<courses.size();i++){
            while(courses.get(i).getEnrollStudent().size()>courses.get(i).getMaxCapacity()){
            {int min=courses.get(i).getCredits().get(0);
             for(int j=0;i<courses.get(i).getCredits().size();j++){
                 if(min>courses.get(i).getCredits().get(j)){min=courses.get(i).getCredits().get(j);}
            }
             for(int k=0;k<students.size();k++){
                 if (a.get(students.get(k).getStudentID()+courses.get(i).getCourseID())==min){
                     ArrayList x=students.get(k).getEnrollCourses();
                     x.remove(courses.get(i));
                     students.get(k).setEnrollCourses(x);
                     ArrayList y=courses.get(i).getEnrollStudent();
                     y.remove(students.get(k));
                     courses.get(i).setEnrollStudent(y);}
                 }
             ArrayList z=courses.get(i).getCredits();
             z.remove(min);
             courses.get(i).setCredits(z);
             }
            }
            courses.get(i).setSuccessStudents(courses.get(i).getEnrollStudent());
            }
        for(int k=0;k< students.size();k++){
            students.get(k).setSuccessCourses(students.get(k).getEnrollCourses());
        }
    }
    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList aa=new ArrayList<>();
        if(ifOpen==true){for(int i=0;i<student.getEnrollCourses().size();i++){
         String b=student.getEnrollCourses().get(i).getCourseID()+": "+a.get(student.getStudentID()+student.getEnrollCourses().get(i).getCourseID());
         aa.add(b);
        }
        }
        return null;
    }
}