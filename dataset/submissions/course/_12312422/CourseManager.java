import java.util.ArrayList;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses= new ArrayList<>();
        students= new ArrayList<>();
        ifOpen=true;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public void setIfOpen(boolean ifOpen){
        this.ifOpen=ifOpen;
    }
    public boolean getIfOpen(){
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
    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        if(!ifOpen){
            return false;
        }
        if(credits<=0){
            return false;
        }
        if (this.courses==null){
            return false;
        }
        if(student.getCredits()<credits){
            return false;
        }
        for (int i=0;i<courses.size();i++){
            if (courses.get(i).getCourseID().equals(courseId)){
                Course course=courses.get(i);
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
                student.setCredits(student.getCredits()-credits);
                student.getEnrollCourses().add(course);
                return true;
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student,String courseId,int credits){
        if(!ifOpen){
            return false;
        }
        if(this.courses==null){
            return false;
        }
        if (credits<=0){
            return false;
        }
        for (int i=0;i<this.courses.size();i++){
            if (this.courses.get(i).getCourseID().equals(courseId)){
                Course course=this.courses.get(i);
                if (course.getEnrollStudent()!=null && !course.getEnrollStudent().isEmpty()){
                    int index=course.getEnrollStudent().indexOf(student);
                    if (index!=-1){
                        int diff=course.getCredits().get(index)-credits;
                        if ((student.getCredits()+diff)>=0){
                            student.setCredits(student.getCredits()+diff);
                            course.getCredits().set(index,credits);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student,String courseId){
        if (!ifOpen){
            return false;
        }
        if (this.courses==null || this.courses.isEmpty()){
            return false;
        }else{
            for (int i=0;i<this.courses.size();i++){
                if (this.courses.get(i).getCourseID().equals(courseId)){
                    Course course=this.courses.get(i);
                    int index=course.getEnrollStudent().indexOf(student);
                    if (index!=-1){
                        int credits=course.getCredits().get(index);
                        student.setCredits(student.getCredits()+credits);
                        course.getCredits().remove(index);
                        course.getEnrollStudent().remove(index);
                        student.getEnrollCourses().remove(course);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen){
            return new ArrayList<>();
        }else {
            ArrayList<String> str=new ArrayList<>();
            for (int i=0;i<this.courses.size();i++){
                Course c=this.courses.get(i);
                int index=c.getEnrollStudent().indexOf(student);
                if (index!=-1){
                    int credits=c.getCredits().get(index);
                    str.add(c.getCourseID()+": "+credits);
                }
            }
            return str;
        }
    }
    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i=0;i<this.courses.size();i++){
            Course c=courses.get(i);
            if (c.getMaxCapacity()>=c.getEnrollStudent().size()){
                for (int j=0;j<c.getEnrollStudent().size();j++){
                    Student student=c.getEnrollStudent().get(j);
                    student.getSuccessCourses().add(c);
                    c.getSuccessStudents().add(student);
                }
            }else{
                ArrayList<Integer> sortcredits =new ArrayList<>();
                for (int j=0;j<c.getCredits().size();j++){
                    sortcredits.add(c.getCredits().get(j));
                }
                sortcredits.sort(Comparator.reverseOrder());
                if (sortcredits.get(c.getMaxCapacity()-1)!=sortcredits.get(c.getMaxCapacity())){
                    for (int j=0;j<c.getMaxCapacity();j++){
                        for (int k=0;k<c.getCredits().size();k++){
                            if (c.getCredits().get(k).equals(sortcredits.get(j))){
                                Student student=c.getEnrollStudent().get(k);
                                c.getSuccessStudents().add(student);
                                student.getSuccessCourses().add(c);
                                c.getCredits().set(k,-1);
                            }
                        }
                    }
                }else {
                    int integer=0;
                    for (int j=0;j<c.getMaxCapacity();j++){
                        if (sortcredits.get(j).equals(sortcredits.get(c.getMaxCapacity()-1))){
                            integer=j;
                            break;
                        }
                    }
                    for (int j=0;j<integer;j++){
                        for (int k=0;k<c.getCredits().size();k++){
                            if (c.getCredits().get(k).equals(sortcredits.get(j))){
                                Student student=c.getEnrollStudent().get(k);
                                c.getSuccessStudents().add(student);
                                student.getSuccessCourses().add(c);
                                c.getCredits().set(k,-1);
                            }
                        }
                    }
                }
            }
        }
    }
}