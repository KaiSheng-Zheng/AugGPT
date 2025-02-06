import java.util.ArrayList;
public class CourseManager{
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        this.courses = new ArrayList<Course>();
        this.students = new ArrayList<Student>();
        this.ifOpen = true;
    }
    public ArrayList<Course> getCourses(){return courses;}
    public ArrayList<Student> getStudents(){return students;}
    public void setIfOpen(Boolean ifOpen){this.ifOpen=ifOpen;}
    public boolean getIfOpen(){return ifOpen;}
    public void setCourses(ArrayList<Course> courses){this.courses = courses;}
    public void setStudents(ArrayList<Student> students){this.students = students;}
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
     public boolean enrollStudentInCourse(Student student, String courseID, int credits){
        if(this.ifOpen == false){return false;}
            if(credits<=0){return false;}
            Course course = null;
            for(Course c : student.getEnrollCourses()){
                if(c.getCourseID().equals(courseID)){
                    course = c;
                }
            }
            if(course==null){return false;}
            if(student.getCredits()<credits){return false;}
            student.setCredits(student.getCredits()-credits);
            student.getEnrollCourses().add(course);
            course.getCredits().add(credits);
            course.getEnrollStudent().add(student);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseID, int credits){
        if(this.ifOpen == false){
            return false;
        }
        if(credits<=0){return false;}
        Course course = null;
        for(Course c : student.getEnrollCourses()){
                if(c.getCourseID().equals(courseID)){
                    course = c;
                }
            }
            if(course == null){return false;}
            for(int i = 0;i<course.getEnrollStudent().size();i++){
                if(course.getEnrollStudent().get(i) == student){
                    student.setCredits(student.getCredits()-credits+course.getCredits().get(i));
                    course.getCredits().add(i,credits);
                    course.getCredits().remove(i+1);
                }
            }
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseID){
        if(this.ifOpen == false){return false;}
         Course course = null;
        for(Course c : student.getEnrollCourses()){
                if(c.getCourseID().equals(courseID)){
                    course = c;
                }
            }
            if(course == null){return false;}   
            for(int i = 0;i<course.getEnrollStudent().size();i++){
                if(course.getEnrollStudent().get(i).equals(student)){
                  student.setCredits(student.getCredits()+course.getCredits().get(i));  
                  course.getCredits().remove(i);
                  student.getEnrollCourses().remove(course);
                  course.getEnrollStudent().remove(student);
                }
            }
        return true;
    }
    public void finalizeEnrollments(){
        if(ifOpen == false){
            for(Course c : courses){
                for(int i = 0;i<c.getCredits().size()-3;i++){
                    for(int j = 0; j<c.getCredits().size()-3-i;j++){
                    if(c.getCredits().get(j)<=c.getCredits().get(j+1)){
                        int temp = c.getCredits().get(j);
                        int temp1 = c.getCredits().get(j+1);
                        c.getCredits().add(j,temp1);
                        c.getCredits().remove(j+1);
                        c.getCredits().add(j+1,temp);
                        c.getCredits().remove(j+2);
                        Student student = c.getEnrollStudent().get(j);
                        Student student1 = c.getEnrollStudent().get(j+1);
                        c.getEnrollStudent().add(j,student1);
                        c.getEnrollStudent().remove(j+1);
                        c.getEnrollStudent().add(j+1,student);
                        c.getEnrollStudent().remove(j+2);
                    }
                }
                }
                int t = c.getMaxCapacity();
                if(t<c.getEnrollStudent().size()){
                    for(int j = 0;j<t;j++){
                        if(c.getCredits().get(t-1).equals(c.getCredits().get(t-1-j))){
                            c.getCredits().remove(t-1-j);
                            c.getEnrollStudent().remove(t-1-j);
                        }
                        if(c.getCredits().get(t-1)>c.getCredits().get(t-1-j)){
                            break;
                        }
                    }
                    c.setSuccessStudents(c.getEnrollStudent());
                }
                if(t>=c.getEnrollStudent().size()){
                    c.setSuccessStudents(c.getEnrollStudent());
                }
                for(Student s : students){
                    for(int i = 0;i<c.getEnrollStudent().size();i++){
                        if(!s.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())){
                            s.getEnrollCourses().remove(c);
                        }
                    }
                    s.setSuccessCourses(s.getEnrollCourses());
                }
            }
        }
    }
    private ArrayList<String> coursewithcredits = new ArrayList<>();
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(ifOpen == false){return null;}
        Course course = null;
            for(Course c : this.getCourses()){
                for(int i = 0;i<student.getEnrollCourses().size();i++){
                    if(c.getCourseID().equals(student.getEnrollCourses().get(i))){
                    course= c;
                    String sb = String.format("%s: %d",c.getCourseID(),student.getCredits());
                    coursewithcredits.add(sb);
                }}}
            return coursewithcredits;
}}