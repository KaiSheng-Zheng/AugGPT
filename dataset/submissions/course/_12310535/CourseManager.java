import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);

    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if (credits<=0)
            return false;
        Course course = null;
        for (Course c:courses ){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }}
            if (course == null){
               return false;
            }

        if (student.getCredits()<credits)
            return false;
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.setCredits(student.getCredits()-credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student,String courseID,int credits){
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c:courses ){
            if (c.getCourseID().equals(courseID)){
                course = c;}
                break;}
            if (course == null)
                return false;

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
            break;}
        }
        if (index == -1){
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        student.setCredits(student.getCredits()+originalCredits-credits);
        course.getCredits().set(index,credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student,String courseId){
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c:courses ){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;}}
            if (course == null){
                return false;}

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;}
        }
        if (index == -1){
            return false;
        }
        student.setCredits(student.getCredits()+course.getCredits().get(index));
        student.getEnrollCourses().remove(course);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);

        return true;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> enrolledCourses = new ArrayList<>();
        if(!this.ifOpen){
            return null;}
        for (Course c:student.getEnrollCourses()) {
            int indexOfCourse = c.getEnrollStudent().indexOf(student);
            int creditsFromTheStudent = c.getCredits().get(indexOfCourse);
            enrolledCourses.add(String.format("%s: %d",c.getCourseID(),creditsFromTheStudent));
        }
        return enrolledCourses;
    }


    public void finalizeEnrollments(){
        setIfOpen(false);
        for (Course c : courses){
            ArrayList<Integer> studentCredits = new ArrayList<>();
            for (int i = 0; i < c.getCredits().size(); i++) {
                studentCredits.add(c.getCredits().get(i));
            }
            if (c.getMaxCapacity()<c.getEnrollStudent().size()){
                for (int i = 0; i < studentCredits.size(); i++) {
                    studentCredits.set(i,-studentCredits.get(i));
                }Collections.sort(studentCredits);
                for (int i = 0; i < studentCredits.size(); i++) {
                    studentCredits.set(i,-studentCredits.get(i));
                } int n = studentCredits.get(c.getMaxCapacity());
                for (int i = studentCredits.size()-1; i >= c.getMaxCapacity() ; i--) {
                    studentCredits.remove(i);
                }
                if (studentCredits.get(c.getMaxCapacity()-1)==n){
                    for (int j = studentCredits.size() - 1;j>=0;j--){
                        if (studentCredits.get(j)==n){
                            studentCredits.remove(j);
                        }
                    }
                }
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    for (int f:studentCredits){
                        if (c.getCredits().get(i)>=f){
                            ArrayList<Student> successStudent = c.getSuccessStudents();
                            successStudent.add(c.getEnrollStudent().get(i));
                            c.setSuccessStudents(successStudent);
                            ArrayList<Course> successCourse = c.getEnrollStudent().get(i).getSuccessCourses();
                            successCourse.add(c);
                            c.getEnrollStudent().get(i).setSuccessCourses(successCourse);
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
}
