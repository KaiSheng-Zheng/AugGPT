import java.util.ArrayList;
import java.util.Objects;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        this.ifOpen = true;
        this.students=new ArrayList<Student>();
        this.courses=new ArrayList<Course>();
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    public ArrayList<Course> getCourses(){
        return this.courses;
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }
    public boolean getIfOpen(){
        return this.ifOpen;
    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen)return false;
        if(student.getCredits()<credits)return false;//if can't afford,false
        if(credits<=0)return false;//if no points, then false
        if(student.getCredits()<=0)return false;//if no points, then false
        if(getCourseFromID(courseId)==null)return false;//course doesn't exist,then false
        Course cor=getCourseFromID(courseId);
        if(student.getEnrollCourses().contains(getCourseFromID(courseId)))return false;//if enrolled,then false
        student.setCredits(student.getCredits()-credits);//update credit
        ArrayList<Course> a =student.getEnrollCourses();
        a.add(cor);
        student.setEnrollCourses(a);
        //update student info
        ArrayList<Student> b=cor.getEnrollStudent();
        b.add(student);
        cor.setEnrollStudent(b);//add the stu
        ArrayList<Integer>c=cor.getCredits();
        c.add(credits);
        cor.setCredits(c);//add the credit
        //update course info
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        Course cor=getCourseFromID(courseId);
        if(!ifOpen)return false;//Only available when ifOpen is true. Return false if ifOpen is false.
        if(getCourseFromID(courseId)==null)return false;//course should exist
        if(!cor.getEnrollStudent().contains(student))return false;//the student is currently enrolled in the course
        int i;
        for (i = 0; i <cor.getCredits().size(); i++) {
            if(Objects.equals(cor.getEnrollStudent().get(i), student))break;
        }
        if(cor.getCredits().get(i)+ student.getCredits()<credits)return false;
        student.setCredits(student.getCredits()+cor.getCredits().get(i)-credits);//modify the credit of stu
        ArrayList<Integer> d=cor.getCredits();
        d.set(i,credits);
        cor.setCredits(d);//the last 3 lines change the credit in the course
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen)return false;//if open
        if(getCourseFromID(courseId)==null)return false;//do exist
        Course cor=getCourseFromID(courseId);
        ArrayList<Student>stu=cor.getEnrollStudent();
        ArrayList<Course>corlist=student.getEnrollCourses();
        if(!stu.contains(student))return false;//student enrolled
        int i;
        for (i = 0; i <student.getEnrollCourses().size(); i++) {
            if(Objects.equals(student.getEnrollCourses().get(i), cor))break;
        }
        corlist.remove(i);
        student.setEnrollCourses(corlist);//now the student cleared out the class,yet credit were not returned
        for (i = 0; i <cor.getCredits().size(); i++) {
            if(Objects.equals(cor.getEnrollStudent().get(i), student))break;
        }
        student.setCredits(student.getCredits()+cor.getCredits().get(i));//refund
        stu.remove(i);
        cor.setEnrollStudent(stu);//remove student from course
        ArrayList<Integer>cre=cor.getCredits();
        cre.remove(i);
        cor.setCredits(cre);
        return true;
    }
    public void finalizeEnrollments(){
        if(ifOpen) {
            for (int i = 0; i < courses.size(); i++) {
                RankStudents(courses.get(i));
            }
            ifOpen=false;
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen)return null;
        ArrayList<String> cop=new ArrayList<String>();
        int xy;
        String cid;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            ArrayList<Student> fuu=student.getEnrollCourses().get(i).getEnrollStudent();
            for (int j = 0; j < fuu.size(); j++) {
                if(Objects.equals(student,fuu.get(j))) {
                    xy=student.getEnrollCourses().get(i).getCredits().get(j);
                    cid=student.getEnrollCourses().get(i).getCourseID();
                    cop.add(String.format("%s: %d",cid,xy));
                    break;
                }
            }
        }
        return cop;
    }
    public Course getCourseFromID(String id){
        for(Course tmp:courses){
            if(tmp.getCourseID().equals(id))return tmp;
        }
        return null;
    }
    public void RankStudents(Course corr){
        ArrayList<Integer>point=corr.getCredits();
        ArrayList<Student>stu=corr.getEnrollStudent();
        int seat=corr.getMaxCapacity();
        if(seat>= point.size()){
            corr.setSuccessStudents(stu);
            for (int i = 0; i < stu.size(); i++) {
                ArrayList<Course> xxx=stu.get(i).getSuccessCourses();
                xxx.add(corr);
                stu.get(i).setSuccessCourses(xxx);
            }
        }
        else{
            for (int i =stu.size()-1; i >0; i--) {
                for (int j = 0; j < i; j++) {
                    if(point.get(j)<point.get(j+1)){
                        Student fuck=stu.get(j);
                        int fuc=point.get(j);
                        stu.set(j,stu.get(j+1));
                        point.set(j,point.get(j+1));
                        stu.set(j+1,fuck);
                        point.set(j+1,fuc);
                    }
                }
            }
            while((seat>=1)&&(Objects.equals(point.get(seat - 1), point.get(seat)))){
                seat--;
            }
            ArrayList<Student> sucStu=new ArrayList<Student>();
            for (int i = 0; i < seat; i++) {
                sucStu.add(stu.get(i));
                ArrayList<Course> xxx=stu.get(i).getSuccessCourses();
                xxx.add(corr);
                stu.get(i).setSuccessCourses(xxx);
            }
            corr.setSuccessStudents(sucStu);
        }

    }
}
