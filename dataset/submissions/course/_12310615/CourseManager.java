import java.util.ArrayList;
import java.util.Arrays;
public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students=new ArrayList<>();
    private boolean ifOpen=true;
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public boolean isIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
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
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (credits<=0|| ifOpen!=true ||credits>student.getCredits()){
            return false;}
        for(int m=0;m<student.getEnrollCourses().size();m++){
            if(student.getEnrollCourses().get(m).getCourseID().equals(courseId)){
                return false;
            }
        }
        for(int i=0;i<courses.size();i++){
            if(courseId.equals(courses.get(i).getCourseID())){
                courses.get(i).getEnrollStudent().add(student);
                courses.get(i).getCredits().add(credits);
                student.setCredits(student.getCredits()-credits);
                student.getEnrollCourses().add(courses.get(i));
                return true;
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (credits>0&&ifOpen==true){
            for (int i=0;i<student.getEnrollCourses().size();i++){
                if(courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                    for (int m=0;m<courses.size();m++){
                        if (courseId.equals(courses.get(m).getCourseID())){
                            for (int n=0;n<courses.get(m).getEnrollStudent().size();n++){
                                if (student.getStudentID().equals(courses.get(m).getEnrollStudent().get(n).getStudentID())){
                                    if (credits<=student.getCredits()+courses.get(m).getCredits().get(n)){
                                        student.setCredits(student.getCredits()+courses.get(m).getCredits().get(n)-credits);
                                        courses.get(m).getCredits().remove(n);
                                        courses.get(m).getCredits().add(n,credits);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (ifOpen!=true){
            return false;
        }
        for (int i=0;i<student.getEnrollCourses().size();i++){
            if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                for(int n=0;n<courses.size();n++){
                    if (courseId.equals(courses.get(n).getCourseID())){
                        for (int m=0;m<courses.get(n).getEnrollStudent().size();m++){
                            if (student.getStudentID().equals(courses.get(n).getEnrollStudent().get(m).getStudentID())){
                                courses.get(n).getEnrollStudent().remove(m);
                                student.setCredits(student.getCredits()+courses.get(n).getCredits().get(m));
                                courses.get(n).getCredits().remove(m);
                                student.getEnrollCourses().remove(i);
                                return true;
                                }
                            }
                        }
                    }
                }
            }
        return false;
    }
    public void finalizeEnrollments(){
        setIfOpen(false);
        for (int i=0;i<courses.size();i++){
            int mincredit=0;
            if (courses.get(i).getMaxCapacity()>=courses.get(i).getEnrollStudent().size()){
                courses.get(i).setSuccessStudents(courses.get(i).getEnrollStudent());
                for (int m=0;m<courses.get(i).getEnrollStudent().size();m++){
                    courses.get(i).getEnrollStudent().get(m).getSuccessCourses().add(courses.get(i));
                }
            }
            else {
                int[] Copy=new int[courses.get(i).getCredits().size()];
                for(int n=0;n<courses.get(i).getCredits().size();n++){
                    Copy[n]=courses.get(i).getCredits().get(n);
                }
                Arrays.sort(Copy);
                if (courses.get(i).getMaxCapacity()>1){
                    if(Copy[Copy.length-courses.get(i).getMaxCapacity()]==Copy[Copy.length-courses.get(i).getMaxCapacity()-1]&&Copy[Copy.length-courses.get(i).getMaxCapacity()]==Copy[Copy.length-courses.get(i).getMaxCapacity()+1]){
                        for (int a=Copy.length-courses.get(i).getMaxCapacity()+1;a< Copy.length;a++){
                            if (Copy[Copy.length-courses.get(i).getMaxCapacity()]!=Copy[a]){
                                mincredit=Copy[a];
                            }
                            else {mincredit=Copy[Copy.length-courses.get(i).getMaxCapacity()]+1;}
                        }
                    }
                    if (Copy[Copy.length-courses.get(i).getMaxCapacity()]==Copy[Copy.length-courses.get(i).getMaxCapacity()-1]&&Copy[Copy.length-courses.get(i).getMaxCapacity()]!=Copy[Copy.length-courses.get(i).getMaxCapacity()+1]){
                        mincredit=Copy[Copy.length-courses.get(i).getMaxCapacity()+1];
                    }
                    if (Copy[Copy.length-courses.get(i).getMaxCapacity()]!=Copy[Copy.length-courses.get(i).getMaxCapacity()-1]&&Copy[Copy.length-courses.get(i).getMaxCapacity()]==Copy[Copy.length-courses.get(i).getMaxCapacity()+1]){
                        mincredit=Copy[Copy.length-courses.get(i).getMaxCapacity()];
                    }
                    if (Copy[Copy.length-courses.get(i).getMaxCapacity()]!=Copy[Copy.length-courses.get(i).getMaxCapacity()-1]&&Copy[Copy.length-courses.get(i).getMaxCapacity()]!=Copy[Copy.length-courses.get(i).getMaxCapacity()+1]){
                        mincredit=Copy[Copy.length-courses.get(i).getMaxCapacity()];
                    }
                    for (int b=0;b<courses.get(i).getCredits().size();b++){
                        if (courses.get(i).getCredits().get(b)>=mincredit){
                            courses.get(i).getSuccessStudents().add( courses.get(i).getEnrollStudent().get(b));
                            courses.get(i).getEnrollStudent().get(b).getSuccessCourses().add(courses.get(i));
                        }
                    }
                }
                else {
                    if (Copy[Copy.length-courses.get(i).getMaxCapacity()]==Copy[Copy.length-courses.get(i).getMaxCapacity()-1]){
                        mincredit=Copy[Copy.length-courses.get(i).getMaxCapacity()]+1;
                    }
                    else {mincredit=Copy[Copy.length-courses.get(i).getMaxCapacity()];}
                    for (int b=0;b<courses.get(i).getCredits().size();b++){
                    if (courses.get(i).getCredits().get(b)>=mincredit){
                        courses.get(i).getSuccessStudents().add( courses.get(i).getEnrollStudent().get(b));
                        courses.get(i).getEnrollStudent().get(b).getSuccessCourses().add(courses.get(i));
                        }
                    }
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String>EnrolledCoursesWithCredits=new ArrayList<>();
        if (ifOpen==true){
            for (int i=0;i<student.getEnrollCourses().size();i++){
                for(int m=0;m<courses.size();m++){
                    if(student.getEnrollCourses().get(i).getCourseID().equals(courses.get(m).getCourseID())){
                        for (int n=0;n<courses.get(m).getEnrollStudent().size();n++){
                            if(courses.get(m).getEnrollStudent().get(n).getStudentID().equals(student.getStudentID())){
                                EnrolledCoursesWithCredits.add(courses.get(m).getCourseID()+": "+courses.get(m).getCredits().get(n));
                            }
                        }
                    }
                }
            }
        }
        return EnrolledCoursesWithCredits;
    }
}
