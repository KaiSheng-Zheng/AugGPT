import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course>courses=new ArrayList<>();
    private ArrayList<Student>students=new ArrayList<>();
    private boolean ifOpen;
    public CourseManager(){
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

    public boolean getIfOpen() {
        return ifOpen;
    }
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    public Course idToCourse(String courseId){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)){
                return courses.get(i);
            }
        }
        return null;
    }
    public boolean hadEnrollTheCourse(Student student,String courseId){
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) return true;
        }
        return false;
    }
    public int scCredits(Student student,Course course){
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student))return course.getCredits().get(i);
        }
        return 0;
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (!hadEnrollTheCourse(student, courseId) && student.getCredits()>=credits && Objects.nonNull(idToCourse(courseId)) && credits>0 && ifOpen){
            student.getEnrollCourses().add(idToCourse(courseId));
            student.setCredits(student.getCredits()-credits);
            idToCourse(courseId).getEnrollStudent().add(student);
            idToCourse(courseId).getCredits().add(credits);
            return true;
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (hadEnrollTheCourse(student,courseId) && student.getCredits()+scCredits(student,idToCourse(courseId))>=credits && Objects.nonNull(idToCourse(courseId)) && credits>0 && ifOpen){
            student.setCredits(student.getCredits()+scCredits(student,idToCourse(courseId))-credits);
            for (int i = 0; i < idToCourse(courseId).getCredits().size(); i++) {
                if (idToCourse(courseId).getEnrollStudent().get(i).equals(student)){
                    idToCourse(courseId).getCredits().set(i,credits);
                }
            }
            return true;
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (hadEnrollTheCourse(student,courseId) &&  Objects.nonNull(idToCourse(courseId)) && ifOpen){
            for (int i = idToCourse(courseId).getCredits().size()-1; i >=0; i--) {
                if (idToCourse(courseId).getEnrollStudent().get(i).equals(student)){
                    student.setCredits(student.getCredits()+idToCourse(courseId).getCredits().get(i));
                    idToCourse(courseId).getCredits().remove(i);
                    idToCourse(courseId).getEnrollStudent().remove(i);
                    student.getEnrollCourses().remove(idToCourse(courseId));
                }
            }
            return true;
        }
        return false;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        for (Course cours : courses) {
            for (int j = 0; j < cours.getCredits().size(); j++) {
                for (int k = 0; k < j; k++) {
                    if (cours.getCredits().get(j)>cours.getCredits().get(k)){
                        Collections.swap(cours.getCredits(),j,k);
                        Collections.swap(cours.getEnrollStudent(),j,k);
                    }
                }
            }
        }
        for (Course cour : courses){
            if (cour.getMaxCapacity()<cour.getCredits().size()){
                int c = cour.getCredits().get(cour.getMaxCapacity());
                for (int i = cour.getCredits().size()-1; i >=0; i--) {
                    if (cour.getCredits().get(i)<=c){
                        cour.getCredits().remove(i);
                        cour.getEnrollStudent().get(i).getEnrollCourses().remove(cour);
                        cour.getEnrollStudent().remove(i);
                    }
                    else {
                        cour.getSuccessStudents().add(cour.getEnrollStudent().get(i));
                        cour.getEnrollStudent().get(i).getSuccessCourses().add(cour);
                    }
                }
            }
            else for (int i = 0; i < cour.getCredits().size(); i++) {
                cour.getSuccessStudents().add(cour.getEnrollStudent().get(i));
                cour.getEnrollStudent().get(i).getSuccessCourses().add(cour);
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> stud=new ArrayList<>();
        for (Course cours: student.getEnrollCourses()) {
            stud.add(String.format("%s: %d",cours.getCourseID(),scCredits(student,cours)));
        }
        return stud;
    }

}