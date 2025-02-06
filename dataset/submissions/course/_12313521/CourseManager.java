import java.util.ArrayList;

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
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
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
        Course a=null;
        if(!ifOpen){
            return false;
        }else if(credits<0){
            return false;
        }else if(student.getCredits()<credits){
            return false;
        }else {
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                //    b=false;
                    return false;
                }
            }
                for (int j = 0; j < courses.size(); j++) {
                    if (courses.get(j).getCourseID().equals(courseId)) {
                        student.setCredits(student.getCredits()-credits);
                        for (int k = 0; k < courses.size(); k++) {
                            if(courses.get(k).getCourseID().equals(courseId)){
                                a=courses.get(k);
                            }
                        }
                        a.getEnrollStudent().add(student);
                        a.getCredits().add(credits);
                        student.getEnrollCourses().add(a);
                        return true;
                    }
                }
            return false;
        }
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,int credits){
        Course a=null;
        if(!ifOpen){
            return false;
        }else {
            for (int j = 0; j < courses.size(); j++) {
                if (courses.get(j).getCourseID().equals(courseId)) {
                    a=courses.get(j);
                    for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                        if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                            for (int k = 0; k < a.getEnrollStudent().size(); k++) {
                                if(a.getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())){
                                    if(credits>student.getCredits()+a.getCredits().get(k)){
                                        return false;
                                    }
                                    student.setCredits(student.getCredits()+a.getCredits().get(k)-credits);
                                    a.getCredits().set(k,credits);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        Course a=null;
        if(!ifOpen){
            return false;
        }else {
            for (int i = 0; i < courses.size(); i++) {
                if(courses.get(i).getCourseID().equals(courseId)){
                    a=courses.get(i);
                    int x=0;
                    for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                        if (student.getEnrollCourses().get(j).getCourseID().equals(courseId)){
                            x=j;
                            for (int k = 0; k < a.getEnrollStudent().size(); k++) {
                                if(a.getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())){
                                    student.setCredits(student.getCredits()+a.getCredits().get(k));
                                    a.getEnrollStudent().remove(k);
                                    a.getCredits().remove(k);
                                    student.getEnrollCourses().remove(x);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        int b;
        Student a=null;
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                for (int k = j+1; k < courses.get(i).getEnrollStudent().size(); k++) {
                    if(courses.get(i).getCredits().get(j)<courses.get(i).getCredits().get(k)){
                        b=courses.get(i).getCredits().get(j);
                        courses.get(i).getCredits().set(j,courses.get(i).getCredits().get(k));
                        courses.get(i).getCredits().set(k,b);
                        a=courses.get(i).getEnrollStudent().get(j);
                        courses.get(i).getEnrollStudent().set(j,courses.get(i).getEnrollStudent().get(k));
                        courses.get(i).getEnrollStudent().set(k,a);
                    }
                }
            }
            int x=0;
            int y=0;
            if(courses.get(i).getMaxCapacity()>=courses.get(i).getEnrollStudent().size()){
                for (int l = 0; l < courses.get(i).getEnrollStudent().size(); l++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(l));
                }
                for (int l = 0; l < courses.get(i).getSuccessStudents().size(); l++) {
                    a=courses.get(i).getSuccessStudents().get(l);
                    a.getSuccessCourses().add(courses.get(i));
                }
            }else if(courses.get(i).getCredits().get(courses.get(i).getMaxCapacity()-1)!=courses.get(i).getCredits().get(courses.get(i).getMaxCapacity())){
                for (int l = 0; l < courses.get(i).getMaxCapacity(); l++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(l));
                }
                for (int l = 0; l < courses.get(i).getSuccessStudents().size(); l++) {
                    a=courses.get(i).getSuccessStudents().get(l);
                    a.getSuccessCourses().add(courses.get(i));
                }
            }else{
                y=courses.get(i).getCredits().get(courses.get(i).getMaxCapacity()-1);
                while (courses.get(i).getCredits().get(x)!=y){
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(x));
                    x++;
                }
                for (int l = 0; l < courses.get(i).getSuccessStudents().size(); l++) {
                    a=courses.get(i).getSuccessStudents().get(l);
                    a.getSuccessCourses().add(courses.get(i));
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen){
            return null;
        }else {
            ArrayList<String> a=new ArrayList<>();
            for (int i = 0; i < courses.size(); i++) {
                for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                    if (courses.get(i).getCourseID().equals(student.getEnrollCourses().get(j).getCourseID())){
                        a.add(courses.get(i).getCourseID()+": "+student.getEnrollCourses().get(j).getCredits().get(courses.get(i).getEnrollStudent().indexOf(student)));
                    }
                }
            }
            return a;
        }
    }
}
