import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager()
    {
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }
    public void addCourse(Course course){
        course.setCourseManager(this);
        courses.add(course);
    }
    public void addStudent(Student student){
        student.setCourseManager(this);
        students.add(student);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!getIfOpen()) { return false; }
        boolean exist = false;
        Course cse=null;
        for(Course cs:courses){
            if(cs.getCourseID().equals(courseId)) {
                exist = true;
                cse=cs;
                break;
            }
        }
        if (!exist) { return false;}
        ArrayList<Course> sec=student.getEnrollCourses();
        for(Course c:sec)if(c.getCourseID().equals(courseId))return false;
        if(credits<=0||credits>student.getCredits())
        {
            return false;
        }
        student.setCredits(student.getCredits()-credits);
        sec.add(cse);
        cse.getEnrollStudent().add(student);
        cse.getCredits().add(credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!getIfOpen() || credits<=0) { return false; }
        boolean exist = false;
        Course cse=null;
        for(Course cs:courses){
            if(cs.getCourseID().equals(courseId)) {
                exist = true;
                cse=cs;
                break;
            }
        }
        if(!exist){return false;}
        ArrayList<Course> sec=student.getEnrollCourses();
        for(Course c:sec){
            if(c.getCourseID().equals(courseId))
            {
                exist=true;
                break;
            }
        }
        if(!exist) {return false;}
        int k=0;
        for(k=0;k<cse.getEnrollStudent().size();k++)
        {
            if(cse.getEnrollStudent().get(k)==student)
            {
                if(credits>student.getCredits()+cse.getCredits().get(k))
                {
                    return false;
                }
                student.setCredits(student.getCredits()+cse.getCredits().get(k)-credits);
                cse.getCredits().set(k,credits);
                return true;
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!getIfOpen()) { return false; }
        boolean exist = false;
        Course cse=null;
        for(Course cs:courses){
            if(cs.getCourseID().equals(courseId)) {
                exist = true;
                cse=cs;
                break;
            }
        }
        if(!exist){return false;}
        int j=0;
        exist=false;
        ArrayList<Course> sec=student.getEnrollCourses();
        for(;j<sec.size();j++)
        {
            if(sec.get(j).getCourseID().equals(courseId))
            {
                exist=true;
                break;
            }
        }
        if(!exist)
        {
            return false;
        }
        int k=0;
        for(k=0;k<cse.getEnrollStudent().size();k++)
        {
            if(cse.getEnrollStudent().get(k)==student)
            {
                break;
            }
        }
        student.setCredits(student.getCredits()+cse.getCredits().get(k));
        cse.getCredits().remove(k);
        cse.getEnrollStudent().remove(k);
        sec.remove(j);
        return true;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        for(Course ccourse:courses) {
            int mx=0;
            ArrayList<Integer> cc=(ArrayList<Integer>) ccourse.getCredits().clone();
            int cap=ccourse.getMaxCapacity();
            if(cc.size()>cap){
                cc.sort(Comparator.reverseOrder());
                mx=cc.get(cap);
                System.out.println(mx);
            }
            for (int j = 0; j < ccourse.getEnrollStudent().size(); j++) {
                if (ccourse.getCredits().get(j) > mx) {
                    ccourse.getSuccessStudents().add(ccourse.getEnrollStudent().get(j));
                    for(Student st:students)
                    {
                        if(st==ccourse.getEnrollStudent().get(j))
                        {
                            st.getSuccessCourses().add(ccourse);
                        }
                    }
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> s=new ArrayList<>();
        if(!getIfOpen()) return s;
        for(Course cs:student.getEnrollCourses())
        {
            int cdd=0;
            for(int j=0;j<cs.getEnrollStudent().size();j++)
            {
                if(cs.getEnrollStudent().get(j)==student)
                {
                    cdd=cs.getCredits().get(j);
                    break;
                }
            }
            s.add(cs.getCourseID()+": "+cdd);
        }
        return s;
    }
}