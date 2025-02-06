import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        students=new ArrayList<>();
        courses=new ArrayList<>();
        // Constructor, initializes the course and student lists, and set the system default status open(true).
        setIfOpen(true);

    }

    // getter for students
    public ArrayList<Student> getStudents(){
        return students;
    }

    // getter for courses
    public ArrayList<Course> getCourses(){
        return courses;
    }


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
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        } else {
            int k = 0;
            int rec = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    k++;
                    rec = i;
                    break;
                }
            }
            if (k == 1) {
                int k1 = 0;
                for (int i = 0; i < courses.get(rec).getEnrollStudent().size(); i++) {
                    if (courses.get(rec).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        k1++;
                    }
                }
                if (k1 == 1) {
                    return false;
                } else {
                    if (credits > 0) {
                        if (student.getCredits() < credits)
                            return false;
                        else{
                            courses.get(rec).getEnrollStudent().add(student);
                            courses.get(rec).getCredits().add(credits);
                            student.getEnrollCourses().add(courses.get(rec));
                            student.setCredits(student.getCredits()-credits);
                            return true;
                        }
                    } else
                        return false;
                }
            }
            else
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
        if(ifOpen){
            int k = 0;
            int rec = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    k++;
                    rec = i;
                    break;
                }
            }
            if (k == 1) {
                int k1 = 0;
                int rec1=0;
                for (int i = 0; i < courses.get(rec).getEnrollStudent().size(); i++) {
                    if (courses.get(rec).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        k1++;
                        rec1=i;
                        break;
                    }
                }
                if (k1 == 1) {
                    int a=student.getCredits();
                    int b=courses.get(rec).getCredits().get(rec1);
                    if (a+b>=credits){
                        student.setCredits(a+b-credits);
                        courses.get(rec).getCredits().set(rec1,credits);
                        return true;
                    }
                    else{
                        return false;
                    }
                } else {
                    return false;
                }
            }
            else
                return false;

        }
        else
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
        if(ifOpen){
            int k = 0;
            int rec = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    k++;
                    rec = i;
                    break;
                }
            }
            if (k == 1) {
                int k1 = 0;
                int rec1=0;
                for (int i = 0; i < courses.get(rec).getEnrollStudent().size(); i++) {
                    if (courses.get(rec).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        k1++;
                        rec1=i;
                        break;
                    }
                }
                if (k1 == 1) {
                    int a=student.getCredits();
                    int b=courses.get(rec).getCredits().get(rec1);
                    student.setCredits(a+b);
                    courses.get(rec).getEnrollStudent().remove(rec1);
                    student.getEnrollCourses().remove(courses.get(rec));
                    courses.get(rec).getCredits().remove(rec1);
                    return true;

                } else {
                    return false;
                }
            }
            else
                return false;

        }
        else
            return false;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        setIfOpen(false);
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Student> newarr=new ArrayList<>();
            ArrayList<Course> newarr2=new ArrayList<>();
            int cnt=0;
            for (int j = 0; j < courses.get(i).getCredits().size(); j++) {
                if (cnt<courses.get(i).getMaxCapacity()){
                    int max= Collections.max(courses.get(i).getCredits());
                    int max1=courses.get(i).getMaxCapacity();
                    int cnt2=0;
                    boolean b1=true;
                    for (int k = 0; k < courses.get(i).getCredits().size(); k++) {
                        if (cnt+cnt2>max1){
                            cnt=max1;
                            b1=false;
                            break;
                        }
                        if (max==courses.get(i).getCredits().get(k)){
                            cnt2++;
                        }
                    }
                    if (cnt+cnt2>max1){
                        break;
                    }
                   if(!b1)
                       break;
                   for (int k = 0; k < courses.get(i).getCredits().size(); k++) {
                        if (max==courses.get(i).getCredits().get(k)){
                            if (courses.get(i).getEnrollStudent()==null){
                                break;
                            }
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(k));
                            courses.get(i).getEnrollStudent().get(k).getSuccessCourses().add(courses.get(i));
                            courses.get(i).getEnrollStudent().remove(k);
                            courses.get(i).getCredits().remove(k);
                            cnt++;
                            k--;
                            j--;
                        }
                    }
                }
                else
                    break;;
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
        ArrayList<String> arr=new ArrayList<>();
        if (ifOpen){
            for (int i = 0; i < courses.size(); i++) {
                for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                    if (courses.get(i).getEnrollStudent().contains(student)){
                        arr.add(courses.get(i).getCourseID().toString()+": "+courses.get(i).getCredits().get(j));
                    }
                }
            }
            return arr;
        }
        else
            return null;
    }
}
