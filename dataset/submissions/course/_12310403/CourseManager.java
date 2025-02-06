import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }
    public ArrayList<Student> getStudents()
    {
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
    public Course getCourse_Id(String courseId){
        for(Course course :courses ){
            if(course.getCourseID().equals(courseId)){
                return course;
            }
        }
        return null;
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        if(!students.contains(student)){
            return false;
        }
        Course course = getCourse_Id(courseId);
        if(course.equals(null)){
            return false;
        }
        if(course.getEnrollStudent().contains(student)){
            return false;
        }
        if(student.getCredits()<credits){
            return false;
        }
        if(student.getCredits()<=0){
            return false;
        }
        student.setCredits(student.getCredits()-credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        if(!students.contains(student)){
            return false;
        }
        Course course = getCourse_Id(courseId);
        if(course.equals(null)){
            return false;
        }
        if(!course.getEnrollStudent().contains(student)){
            return false;
        }
        int scredits=student.getCredits();
        int index=course.getEnrollStudent().indexOf(student);
        if(scredits+course.getCredits().get(index)<credits){
            return false;
        }
        student.setCredits(scredits+course.getCredits().get(index)-credits);
        course.getCredits().set(index,credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }
        if(!students.contains(student)){
            return false;
        }
        Course course = getCourse_Id(courseId);
        if(course.equals(null)){
            return false;
        }
        if(!course.getEnrollStudent().contains(student)){
            return false;
        }
        int scredits=student.getCredits();
        int index=course.getEnrollStudent().indexOf(student);
        student.setCredits(scredits+course.getCredits().get(index));
        student.getEnrollCourses().remove(course);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        return true;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        for(Course course : courses){
            Integer baseline=getbaseline(course);
            ArrayList <Integer> credits = course.getCredits();
            ArrayList <Student> students = course.getEnrollStudent();
            for(int i=0;i<credits.size();i++){
                if(credits.get(i)>=baseline){
                    Student student=students.get(i);
                    student.getSuccessCourses().add(course);
                    course.getSuccessStudents().add(student);
                }
            }
        }
    }
    public Integer getbaseline(Course course_){
        ArrayList<Integer> credits = new ArrayList<>(course_.getCredits());
        Collections.sort(credits,Collections.reverseOrder());
        if(credits.size()<=course_.getMaxCapacity()){
            return 0;
        }
        if(credits.get(course_.getMaxCapacity()-1).equals(credits.get(course_.getMaxCapacity()))){
            return credits.get(course_.getMaxCapacity()-1)+1;
        }
        return credits.get(course_.getMaxCapacity()-1);
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){
            return null;
        }
        ArrayList <String> infos = new ArrayList<>();
        ArrayList <Course> courses=student.getEnrollCourses();
        for(Course course:courses){
            int index = course.getEnrollStudent().indexOf(student);
            String id=course.getCourseID();
            infos.add(id+": "+course.getCredits().get(index));
        }
        return infos;
    }



}
