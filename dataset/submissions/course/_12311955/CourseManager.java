import com.sun.source.tree.NewArrayTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
      courses=new ArrayList<>();
      students=new ArrayList<>();
      ifOpen=true;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen)
            return false;
        if (credits <= 0)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        Course course1=null;
        for (Course c:student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                course1=c;
                break;
            }
        }if (course1 !=null)return false;
        if (student.getCredits()<credits)return false;
        student.setCredits(student.getCredits()-credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!ifOpen)return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        int index=-1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index=i;
                break;
            }
        }
        if (index==-1)return false;
        int originalCredits=course.getCredits().get(index);
        if (student.getCredits()+originalCredits<credits)return false;
        student.setCredits(student.getCredits()+originalCredits-credits);
        course.getCredits().set(index, credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!ifOpen)return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        int index=-1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index=i;
                break;
            }
        }
        if (index==-1)return false;
        int originalCredits=course.getCredits().get(index);
        student.setCredits(student.getCredits()+originalCredits);
        int index1=-1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                index1=i;
                break;
            }
        }
        student.getEnrollCourses().get(index1).getCredits().remove(index);
        student.getEnrollCourses().get(index1).getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(index1);
        return true;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen)return null;
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                if (student.getStudentID().equals(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID())){
                    list.add(i,student.getEnrollCourses().get(i).getCourseID()+": " +student.getEnrollCourses().get(i).getCredits().get(j));
                }
            }
        }return list;
}
    public void finalizeEnrollments(){
        setIfOpen(false);
        int count=0;
        int INTEGER=0;
        int index=-1;
        for (Course c:courses){
            ArrayList<Student> ss=new ArrayList<>();
            ArrayList<Course> sc=new ArrayList<>();
            Integer []credits=new Integer[ c.getCredits().size()];
            for (int i = 0; i < c.getCredits().size(); i++) {
                credits[i]=c.getCredits().get(i);
            }
            Arrays.sort(credits, Collections.reverseOrder());
            if (c.getMaxCapacity()>=c.getCredits().size()){if (c.getCredits().size()!=0)INTEGER=credits[c.getCredits().size()-1];}
            else {if (credits[c.getMaxCapacity()]!=credits[c.getMaxCapacity()-1])  {
                 INTEGER=credits[c.getMaxCapacity()-1];
             } else {
                 for (int i = c.getMaxCapacity()-1; i >=0; i--) {
                     if (credits[i]!=credits[c.getMaxCapacity()-1]){
                         INTEGER=credits[i];break;
                     }if (i==0)INTEGER=200;
                 }
             }}
            for (int i = 0; i < c.getCredits().size(); i++) {
                if (c.getCredits().get(i)>=INTEGER){
                index=i;
                ss.add(c.getEnrollStudent().get(index));
                sc.add(c);
                }
            }
            for (int i = 0; i < ss.size(); i++) {
                ss.get(i).setSuccessCourses(sc);
            }
            c.setSuccessStudents(ss);
        }
    }
    }




