import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // getter for students
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // getter for courses
    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    // setter for ifOpen
    public boolean getIfOpen() {
        return ifOpen;
    }

    // getter for ifOpen
    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);

    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen) {
            for(int i=0;i< courses.size();i++){
                if(courseId.equals(courses.get(i).getCourseID())){
                    for(int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                        if(courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                            return false;
                        }
                    }
                    if(credits>0 && credits<= student.getCredits()){
                        courses.get(i).getCredits().add(credits);
                        courses.get(i).setCredits(courses.get(i).getCredits());
                        courses.get(i).getEnrollStudent().add(student);
                        courses.get(i).setEnrollStudent(courses.get(i).getEnrollStudent());
                        student.getEnrollCourses().add(courses.get(i));
                        student.setEnrollCourses(student.getEnrollCourses());
                        student.setCredits(student.getCredits()-credits);
                        return true;
                    }
                }
            }
            return false;
        }
        else{
            return false;
        }
    }


    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if(ifOpen){
            for(int i=0;i<courses.size();i++){
                if(courseId.equals(courses.get(i).getCourseID())){
                    for(int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                        if(courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                            int a=courses.get(i).getCredits().get(j);
                            int b=a+student.getCredits();
                            if(credits>0 && credits<=b){
                                student.setCredits(b);
                                courses.get(i).getCredits().remove(j);
                                courses.get(i).getCredits().add(j,credits);
                                student.setCredits(b-credits);
                                return true;
                            }
                            else{
                                return false;
                            }
                        }
                    }
                    return false;
                }
            }
            return false;
        }
        else{
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
        if(ifOpen){
            for(int i=0;i<courses.size();i++){
                if(courseId.equals(courses.get(i).getCourseID())){
                    for(int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                        if(courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                            courses.get(i).getEnrollStudent().remove(j);
                            student.setCredits(courses.get(i).getCredits().get(j)+student.getCredits());
                            courses.get(i).getCredits().remove(j);
                            for(int k=0;k<student.getEnrollCourses().size();k++){
                                if(student.getEnrollCourses().get(k).getCourseID().equals(courses.get(i).getCourseID())){
                                    student.getEnrollCourses().remove(k);
                                    student.setEnrollCourses(student.getEnrollCourses());
                                    return true;
                                }
                            }

                        }
                    }
                    return false;
                }
            }
            return false;
        }
        else{
            return false;
        }
    }
    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        for(int i=0;i< courses.size();i++){
            for(int j=0;j<courses.get(i).getCredits().size()-1;j++){
                int max=j;
                for(int k=j+1;k<courses.get(i).getCredits().size();k++){
                    if (courses.get(i).getCredits().get(k) > courses.get(i).getCredits().get(max)) {
                        max=k;
                    }
                }
                int a=courses.get(i).getCredits().get(j);
                int b=courses.get(i).getCredits().get(max);
                courses.get(i).getCredits().remove(j);
                courses.get(i).getCredits().add(j,b);
                courses.get(i).getCredits().remove(max);
                courses.get(i).getCredits().add(max,a);
                Student s1=courses.get(i).getEnrollStudent().get(j);
                Student s2=courses.get(i).getEnrollStudent().get(max);
                courses.get(i).getEnrollStudent().remove(j);
                courses.get(i).getEnrollStudent().add(j,s2);
                courses.get(i).getEnrollStudent().remove(max);
                courses.get(i).getEnrollStudent().add(max,s1);
            }
            if(courses.get(i).getEnrollStudent().size()<=courses.get(i).getMaxCapacity()){
                for(int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                }
            }
            else{
                int standard=courses.get(i).getCredits().get(courses.get(i).getMaxCapacity());
                for(int j=0;j<courses.get(i).getMaxCapacity();j++){
                    if(courses.get(i).getCredits().get(j)>standard){
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    }
                }
            }
        }
        for(int i=0;i< students.size();i++){
            for(int j=0;j<students.get(i).getEnrollCourses().size();j++){
                for(int k=0;k<students.get(i).getEnrollCourses().get(j).getSuccessStudents().size();k++){
                    if(students.get(i).getEnrollCourses().get(j).getSuccessStudents().get(k).getStudentID().equals(students.get(i).getStudentID())){
                        students.get(i).getSuccessCourses().add(students.get(i).getEnrollCourses().get(j));
                    }
                }
            }
        }
        setIfOpen(false);
    }
    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> array=new ArrayList<>();
        if(ifOpen){
            for(int i=0;i<student.getEnrollCourses().size();i++){
                for(int j=0;j<student.getEnrollCourses().get(i).getEnrollStudent().size();j++){
                    if(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        String s=String.format("%s: %d",student.getEnrollCourses().get(i).getCourseID(),student.getEnrollCourses().get(i).getCredits().get(j));
                        array.add(s);
                    }
                }
            }
        }
        return array;
    }
}