import java.util.ArrayList;

public class CourseManager {
 private final ArrayList<Course> courses;
 private final ArrayList<Student> students;
 //missing getter

 private boolean ifOpen;


    public CourseManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        setIfOpen(true);
    }

   public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {
        return ifOpen;
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){

        if(!getIfOpen()||courses.isEmpty()){return false;}
        else{
        Course course = null;
        for(Course a : courses){
            if(a.getCourseID().equals(courseId)){
                course = a;
                break;
            }
        }
        if(course!=null&&!course.getEnrollStudent().contains(student)&&student.getCredits()>=credits&&credits>0){
           int m = student.getCredits();
            student.setCredits(m-credits);
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            student.getEnrollCourses().add(course);
            return true;
        }
        else{
            return false;
        }

    }}
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!getIfOpen()||courses.isEmpty()){return false;}
        else{
            Course course = null;
            for(Course a : courses){
                if(a.getCourseID().equals(courseId)){
                    course = a;
                    break;
                }
            }

            if(course!=null&&course.getEnrollStudent().contains(student)){
            int index = course.getEnrollStudent().indexOf(student);
            if(course.getCredits().get(index)+student.getCredits()>=credits){
                student.setCredits(course.getCredits().get(index)+student.getCredits()-credits);
                course.getCredits().remove(index);
                course.getEnrollStudent().remove(student);
                student.getEnrollCourses().remove(course);
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
                student.getEnrollCourses().add(course);
                return true;}
            else{return false;}}
            else{ return false;
            }



    }
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!getIfOpen()||courses.isEmpty()){return false;}
        else{
            Course course = null;
            for(Course a : courses){
                if(a.getCourseID().equals(courseId)){
                    course = a;
                    break;
                }
            }
            if(course!=null&&course.getEnrollStudent().contains(student)){
                int index = course.getEnrollStudent().indexOf(student);
                student.setCredits(course.getCredits().get(index)+student.getCredits());
                course.getCredits().remove(index);
                course.getEnrollStudent().remove(student);
                student.getEnrollCourses().remove(course);
                return true;
            }
            else{
                return false;
            }

        }

    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!getIfOpen() || courses.isEmpty()) {
            return new ArrayList<>();
        } else {
            ArrayList<String> list = new ArrayList<>();
            for (Course course : student.getEnrollCourses()) {

                if (course.getEnrollStudent() != null && !course.getEnrollStudent().isEmpty()) {
                    int index = course.getEnrollStudent().indexOf(student);

                    if (index != -1 && index < course.getCredits().size()) {
                        list.add(course.getCourseID() + ": " + course.getCredits().get(index));
                    }
                }
            }
            return list;
        }
    }
    public void addStudent(Student student){
       this.students.add(student);
       student.setCourseManager(this);

    }
    public void addCourse(Course course){
       this.courses.add(course);
       course.setCourseManager(this);

    }
    public void finalizeEnrollments(){
        setIfOpen(false);
        for(Course course : courses){
            if (course.getEnrollStudent() != null&&!course.getEnrollStudent().isEmpty()){
                for(int i =0;i<course.getEnrollStudent().size();i++){
                course.getSuccessStudents().add(course.getEnrollStudent().get(i));
            }
            if(course.getCredits().size()<=course.getMaxCapacity()){
            }
            else{
            for(int i=0;i<course.getCredits().size()-1;i++){
                for(int j=0;j<course.getCredits().size()-1-i;j++){
                    if(course.getCredits().get(j)>course.getCredits().get(j+1)){
                        int maxi = course.getCredits().get(j);
                        int mini = course.getCredits().get(j+1);
                        Student maxii = course.getSuccessStudents().get(j);
                        Student minii = course.getSuccessStudents().get(j+1);
                        course.getCredits().set(j,mini);
                        course.getSuccessStudents().set(j,minii);
                        course.getCredits().set(j+1,maxi);
                        course.getSuccessStudents().set(j+1,maxii);
                    }
                }
            }
            while(course.getCredits().size()>course.getMaxCapacity()){
            int min = course.getCredits().get(0);
            while(course.getCredits().size()>0&&course.getCredits().get(0)==min){
                course.getCredits().remove(0);
                course.getSuccessStudents().remove(0);
            }}
            }
        }}
        for(Student student : students){
            if(student.getEnrollCourses() != null&&!student.getEnrollCourses().isEmpty()){
            for(int i = 0; i<student.getEnrollCourses().size();i++){
                if(student.getEnrollCourses().get(i).getEnrollStudent().contains(student)){
                    student.getSuccessCourses().add(student.getEnrollCourses().get(i));
                }
            }
        }}

    }




}