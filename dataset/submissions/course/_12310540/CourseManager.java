import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public boolean isIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student) {

        this.students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if(!this.ifOpen) return false;
        if (this.ifOpen) {
            if(credits > 0 && credits<=student.getCredits()) {
                for (Course c : courses) {
                    if (c.getCourseID().equals(courseId)) {
                        int k = student.getEnrollCourses().indexOf(c);
                        if(k<0){
                            student.setCredits(student.getCredits()-credits);
                            c.getEnrollStudent().add(student);
                            c.setEnrollStudent(c.getEnrollStudent());
                            student.getEnrollCourses().add(c);
                            student.setEnrollCourses(student.getEnrollCourses());
                            c.getCredits().add(credits);
                            c.setCredits(c.getCredits());
                            return true;
                        }
                    }
                }
            }
        }return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!this.ifOpen) return false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                int k = c.getEnrollStudent().indexOf(student);
                if(k<0) return false;
                if (credits <= student.getCredits()+c.getCredits().get(k)) {
                    student.setCredits(student.getCredits() - (credits - c.getCredits().get(k)));
                    c.getCredits().set(k, credits);
                    return true;
                }else return false;
            }
        }return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!this.ifOpen) return false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                int k = c.getEnrollStudent().indexOf(student);
                if(k<0) return false;
                int Remove = c.getCredits().get(k);
                student.setCredits(student.getCredits() + Remove);
                student.getEnrollCourses().remove(c);
                student.setEnrollCourses(student.getEnrollCourses());
                c.getCredits().remove(k);
                c.setCredits(c.getCredits());
                c.getEnrollStudent().remove(k);
                c.setEnrollStudent(c.getEnrollStudent());
                return true;
            }
        }
        return false;
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        for (Course c : courses) {
            if(c.getEnrollStudent().size()>c.getMaxCapacity()){
                ArrayList<Integer> a = (ArrayList<Integer>) c.getCredits().clone();
                int b = a.size() - c.getMaxCapacity();
                Collections.sort(a);
                int min = a.get(b-1);
                for (Student sb : c.getEnrollStudent()) {
                    int index = c.getEnrollStudent().indexOf(sb);
                    if(c.getCredits().get(index)>min){
                        sb.getSuccessCourses().add(c);
                        sb.setSuccessCourses(sb.getSuccessCourses());
                        c.getSuccessStudents().add(sb);
                        c.setSuccessStudents(c.getSuccessStudents());
                    }
                }
            }else{
                for (Student sb : c.getEnrollStudent()) {
                    sb.getSuccessCourses().add(c);
                    sb.setSuccessCourses(sb.getSuccessCourses());
                    c.getSuccessStudents().add(sb);
                    c.setSuccessStudents(c.getSuccessStudents());
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen) return null;
        ArrayList<String> a = new ArrayList<>();
        for (Course c : student.getEnrollCourses()) {
            int k = c.getEnrollStudent().indexOf(student);
            if (k != -1) {
                int credits = c.getCredits().get(k);
                String b = c.getCourseID()+ ": " + credits;
                a.add(b);
            }
        }
        return a;
    }
}
