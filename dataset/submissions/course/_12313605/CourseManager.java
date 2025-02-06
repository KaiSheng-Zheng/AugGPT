import java.util.ArrayList;
import java.util.Objects;

public class CourseManager {
    private final ArrayList<Course> courses;
    private final ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    public ArrayList<Student> getStudents(){
       return students;
    }
    // getter for students
    public ArrayList<Course> getCourses(){
        return courses;
    }
    // getter for courses
    public void setIfOpen(Boolean ifOpen){
         this.ifOpen=ifOpen;
    }
    // setter for ifOpen
    public boolean getIfOpen(){
        return ifOpen;
    }
    // getter for ifOpen
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int points){
        if(!ifOpen){return false;};
        if(points<=0){return false;};
        for (int i=0;i<courses.size();i++){
            if (courses.get(i).getCourseID().equals(courseId)){break;}
            if(i+1==courses.size()){return false;}
        }
        for(int i =0;i<student.getEnrollCourses().size();i++){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){return false;}
        }
        if(points>student.getCredits()){return false;}
        student.setCredits(student.getCredits()-points);
        for(int i=0;i<courses.size();i++){
        if(courses.get(i).getCourseID().equals(courseId)){
            student.getEnrollCourses().add(courses.get(i));
            courses.get(i).getEnrollStudent().add(student);
            courses.get(i).getCredits().add(points);
            break;
        };
        }
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int points){
        if(!ifOpen){return false;};
        if(points<=0){return false;};
        if(student.getEnrollCourses().isEmpty()){return false;}
        for (int i=0;i<courses.size();i++){
            if (courses.get(i).getCourseID().equals(courseId)){break;}
            if(i+1==courses.size()){return false;}
        }
        for(int i =0;i<student.getEnrollCourses().size();i++){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){break;}
            if (i+1==student.getEnrollCourses().size()){
                return false;
            }
        }
        int b=0;
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                for(int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                    if(courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        b=courses.get(i).getCredits().get(j);
                        if(b+student.getCredits()<points){return false;}
                        courses.get(i).getCredits().set(j,points);
                    }
                }
            }
        }
        student.setCredits(student.getCredits()+b-points);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){return false;};
        if(student.getEnrollCourses().isEmpty()){return false;}
        for (int i=0;i<courses.size();i++){
            if (courses.get(i).getCourseID().equals(courseId)){break;}
            if(i+1==courses.size()){return false;}
        }
        for(int i =0;i<student.getEnrollCourses().size();i++){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){break;}
            if (i+1==student.getEnrollCourses().size()){
                return false;
            }
        }
        int b=0;
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                for(int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                    if(courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        b=courses.get(i).getCredits().get(j);
                        courses.get(i).getEnrollStudent().remove(j);
                        courses.get(i).getCredits().remove(j);
                    }
                }
            }
        }
        for(int i=0;i<student.getEnrollCourses().size();i++){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                student.getEnrollCourses().remove(i);
            }
        }
        student.setCredits(student.getCredits()+b);
        return true;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){return null;};
        ArrayList<String>t = new ArrayList<>();
        int b;
        String c;
        for(int i=0;i<student.getEnrollCourses().size();i++){
            for(int j=0;j<student.getEnrollCourses().get(i).getEnrollStudent().size();j++){
                if(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                    b=student.getEnrollCourses().get(i).getCredits().get(j);
                    c=student.getEnrollCourses().get(i).getCourseID()+": "+b;
                    t.add(c);
                }
            }
        }
        return t;
    }
    public void finalizeEnrollments(){
       setIfOpen(false);
for(int i=0;i<courses.size();i++){
    if(courses.get(i).getCredits().isEmpty()){continue;}
    if(courses.get(i).getCredits().size()<=courses.get(i).getMaxCapacity()){
        for(int t=0;t<courses.get(i).getEnrollStudent().size();t++){
                courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(t));
                courses.get(i).getEnrollStudent().get(t).getSuccessCourses().add(courses.get(i));
            }
       continue;
    }
    int[]a=new int[courses.get(i).getCredits().size()];
   for(int j=0;j<courses.get(i).getCredits().size();j++){
       a[j]=courses.get(i).getCredits().get(j);
   }
    for (int k = 0; k <a.length - 1; k++) {
        for (int m= 0; m < a.length - 1; m++) {
            if (a[m] < a[m + 1]) {
                int temp = a[m];
                a[m] = a[m + 1];
                a[m + 1] = temp;
            }
        }
    }
    int score=999999999,cap=courses.get(i).getMaxCapacity();
for (int n=0;n<cap;n++){
    if(a[cap-n-1]>a[cap-n]){
        score=a[cap-n-1];
        break;
    }
}
for(int t=0;t<courses.get(i).getEnrollStudent().size();t++){
    if(courses.get(i).getCredits().get(t)>=score){
        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(t));
        courses.get(i).getEnrollStudent().get(t).getSuccessCourses().add(courses.get(i));
    }
        }
    }
}
}