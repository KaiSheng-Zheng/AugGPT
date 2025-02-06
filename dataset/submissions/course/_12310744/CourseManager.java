import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    public ArrayList<Student> getStudents(){
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
        course.setCourseManager(this);
        for (Course course1:courses) {
            if (course1.getCourseID().equals(course.getCourseID())) {
                return;
            }
        }
        courses.add(course);
    }
    public void addStudent(Student student){
        student.setCourseManager(this);
        for (Student student1 : students) {
            if (student1.getStudentID().equals(student.getStudentID())) {
                return;
            }
        }
        students.add(student);
    }
    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        if(!ifOpen){
            return false;
        }
        boolean judgment=false;
        for (Course course1:courses) {
            if (course1.getCourseID().equals(courseId)) {
                judgment = true;
            }
        }
        if (!judgment){
            return judgment;
        }
        for (Course course:courses) {
            if (course.getCourseID().equals(courseId)) {
                for (Student student1 : course.getEnrollStudent()) {
                    if (student1.getStudentID().equals(student.getStudentID())) {
                        return false;
                    }
                }
            }
        }
        if(credits<=0 | student.getCredits()<credits) {
            return false;
        }
        int temp= student.getCredits();
        student.setCredits(temp-credits);
        for (Course course1:courses) {
            if (course1.getCourseID().equals(courseId)) {
                course1.getEnrollStudent().add(student);
                course1.getCredits().add(credits);
                student.getEnrollCourses().add(course1);
            }
        }
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student,String courseId,int credits){
        if(!ifOpen){
            return false;
        }
        boolean judgment=false;
        for (Course course1:courses) {
            if (course1.getCourseID().equals(courseId)) {
                for(Student student1:course1.getEnrollStudent()){
                    if (student1.getStudentID().equals(student.getStudentID())){
                        judgment = true;
                    }
                }
            }
        }
        if (!judgment){
            return judgment;
        }
        for (Course course1:courses) {
            if (course1.getCourseID().equals(courseId)) {
                for (int i=0;i<course1.getEnrollStudent().size();i++){
                    if(course1.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                        if(course1.getCredits().get(i)+student.getCredits()<credits){
                            return false;
                        }
                        else{
                            student.setCredits(course1.getCredits().get(i)+student.getCredits()-credits);
                            course1.getCredits().set(i,credits);
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student,String courseId){
        if(!ifOpen){
            return false;
        }
        boolean judgment=false;
        for (Course course1:courses) {
            if (course1.getCourseID().equals(courseId)) {
                for(Student student1:course1.getEnrollStudent()){
                    if (student1.getStudentID().equals(student.getStudentID())){
                        judgment = true;
                    }
                }
            }
        }
        if (!judgment){
            return judgment;
        }
        for (Course course1:courses) {
            if (course1.getCourseID().equals(courseId)) {
                for (int i=0;i<course1.getEnrollStudent().size();i++){
                    if(course1.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                        course1.getEnrollStudent().remove(i);
                        student.setCredits(student.getCredits()+course1.getCredits().get(i));
                        course1.getCredits().remove(i);
                        student.getEnrollCourses().remove(course1);
                    }
                }
            }
        }
        return true;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        for (Course course:courses){
            int a=0;
            ArrayList <Integer> pos=new ArrayList<>();
            while (course.getMaxCapacity()>a & a<course.getEnrollStudent().size()){
                int temp=a;
                int largestpos=0;
                for (int i=1;i<course.getCredits().size();i++){
                    if(course.getCredits().get(i)>course.getCredits().get(largestpos)){
                        largestpos=i;
                    }
                }
                int largestcredit=course.getCredits().get(largestpos);
                for (int i=0;i<course.getCredits().size();i++){
                    if(course.getCredits().get(i)==largestcredit){
                        pos.add(i);
                        a++;
                        course.getCredits().set(i,0);
                    }
                }
                if (course.getMaxCapacity()<a){
                    pos= new ArrayList<>(pos.subList(0,temp));
                }
            }
            for (int i=0;i< pos.size();i++){
                course.getSuccessStudents().add(course.getEnrollStudent().get(pos.get(i)));
                course.getEnrollStudent().get(pos.get(i)).getSuccessCourses().add(course);
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> a=new ArrayList<>();
        if (!ifOpen){
            return null;
        }
        else{
            for (int i=0;i<student.getEnrollCourses().size();i++){
                for(int j=0;j<student.getEnrollCourses().get(i).getEnrollStudent().size();j++){
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        a.add(student.getEnrollCourses().get(i).getCourseID()+": "+student.getEnrollCourses().get(i).getCredits().get(j));
                    }
                }
            }
        }
        return a;
    }
}
