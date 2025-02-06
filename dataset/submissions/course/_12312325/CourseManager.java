import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen = ifOpen;
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
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        if(credits<=0){
            return false;
        }
        if(student.getCredits()<credits){
            return false;
        }
        for(Course course: courses){
            if(course.getCourseID().equals(courseId)){
                student.setCredits(student.getCredits()-credits);
                ArrayList<Student> enrollStudent=course.getEnrollStudent();
                ArrayList<Integer> Credits=course.getCredits();
                ArrayList<Course> enrollCourses=student.getEnrollCourses();
                enrollStudent.add(student);
                Credits.add(credits);
                enrollCourses.add(course);
                course.setEnrollStudent(enrollStudent);
                course.setCredits(Credits);
                student.setEnrollCourses(enrollCourses);
                return true;
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        for(Course course: courses){
            if(course.getCourseID().equals(courseId)){
                for(int i=0;i<course.getEnrollStudent().size();i++){
                    if(course.getEnrollStudent().get(i).equals(student))
                    {
                        if(student.getCredits()+course.getCredits().get(i)-credits<0){
                            return false;
                        }
                        ArrayList<Integer> Credits=course.getCredits();
                        student.setCredits(student.getCredits()-credits+course.getCredits().get(i));
                        Credits.set(i, credits);
                        course.setCredits(Credits);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }
        for(Course course: courses){
            if(course.getCourseID().equals(courseId)){
                for(int i=0;i<course.getEnrollStudent().size();i++){
                    if(course.getEnrollStudent().get(i).equals(student)){
                        ArrayList<Student> enrollStudent=course.getEnrollStudent();
                        ArrayList<Integer> Credits=course.getCredits();
                        ArrayList<Course> enrollCourses=student.getEnrollCourses();
                        enrollStudent.remove(i);
                        student.setCredits(student.getCredits()+Credits.get(i));
                        Credits.remove(i);
                        enrollCourses.remove(course);
                        course.setEnrollStudent(enrollStudent);
                        course.setCredits(Credits);
                        student.setEnrollCourses(enrollCourses);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        for(Course course: courses){
            for(int i=0;i<course.getEnrollStudent().size();i++){
                if(course.getEnrollStudent().get(i).equals(student)){
                    result.add(course.getCourseID()+": "+course.getCredits().get(i));
                }
            }
        }
        return result;
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        for (Course course: courses){
            ArrayList<Student> enrollStudent=course.getEnrollStudent();
            ArrayList<Integer> Credits=course.getCredits();
            for(int i=0;i<enrollStudent.size();i++){
                for (int j=0;j<enrollStudent.size()-1;j++){
                    if(Credits.get(j)<Credits.get(j+1)){
                        Student tempStudent = enrollStudent.get(j+1);
                        enrollStudent.set(j+1, enrollStudent.get(j));
                        enrollStudent.set(j, tempStudent);
                        Integer tempCredit = Credits.get(j+1);
                        Credits.set(j+1, Credits.get(j));
                        Credits.set(j, tempCredit);
                    }
                }
            }
            course.setEnrollStudent(enrollStudent);
            course.setCredits(Credits);
            ArrayList<Student> successStudents=course.getSuccessStudents();
            if(course.getMaxCapacity()>=enrollStudent.size()){
                successStudents.addAll(enrollStudent);
            }
            else{
                for (int i = 0; i < course.getMaxCapacity() ; i++) {
                    successStudents.add(enrollStudent.get(i));
                }
                for (int i = course.getMaxCapacity()-1; i >=0; i--) {
                    if (Credits.get(i) ==Credits.get(i+1)) {
                        successStudents.remove(i);
                    }else{
                        break;
                    }
                }
            }
        }
        for(Student student: students){
            ArrayList<Course> enrollCourses=student.getEnrollCourses();
            ArrayList<Course> successCourses=student.getSuccessCourses();
            for(Course course: courses){
                if(enrollCourses.contains(course)){
                    if(course.getSuccessStudents().contains(student)){
                        successCourses.add(course);
                    }
                }
            }
        }
    }
}
