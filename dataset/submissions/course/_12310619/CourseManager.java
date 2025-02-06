import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class CourseManager{

    
    private ArrayList<Course> courses = new ArrayList<>();
// Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students = new ArrayList<>();
// Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.
    private boolean ifOpen=true;
// Represent system open(true) or not(false)

    public CourseManager() {

    }
    // Constructor, initializes the course and student lists, and set the system

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    /*public Course getCourse(String courseId){
        for(int n=0;n<courses.size();n++){
            if(courses.get(n).getCourseID().equals(courseId)){
                return courses;
            }
        }
    }*/
    public boolean courseHaveTestStudent(Student student, String courseId){
        for(int n=0;n<student.getEnrollCourses().size();n++){
            if(student.getEnrollCourses().get(n).getCourseID().equals(courseId)){
                return true;
            }
        }
        return false;
    }
    public boolean courseHaveTestCourse(String courseId){
        for(int n=0;n<courses.size();n++){
            if(courses.get(n).getCourseID().equals(courseId)){
                return true;
            }
        }
        return false;
    }
    public int courseFind(String courseId){
        int n = 0;
        for(;n<courses.size();n++){
            if(courses.get(n).getCourseID().equals(courseId)){
                return n;
            }
        }
        return -1;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        if(credits<=0){
            return false;
        }
        //System.out.println(student.getCredits());
        if(student.getCredits()<credits){
            return false;
        }
        if(!courseHaveTestCourse(courseId)){
            return false;
        }
        //System.out.println(1);
        if(courseHaveTestStudent(student,courseId)){
            System.out.println(student.getStudentID()+" "+courseId);
            //System.out.println(courseHaveTestStudent(student,courseId));
            return false;
        }
        /*boolean a = false;
        for(int n=0;n<courses.size();n++){
                if(courses.get(n).getCourseID().equals(courseId)){
                    a = true;
                    break;
                }
        }
        if(!a){
            return false;
        }
        for(int n=0;n<student.getEnrollCourses().size();n++){
            if(student.getEnrollCourses().get(n).getCourseID().equals(courseId)){
                return false;
            }
        }*/
        for(int n=0;n<courses.size();n++){
            if(courses.get(n).getCourseID().equals(courseId)){
                student.getEnrollCourses().add(courses.get(courseFind(courseId)));
                courses.get(n).getEnrollStudent().add(student);
                courses.get(n).getCredits().add(credits);
            }
        }
        student.setCredits(student.getCredits()-credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        if(!courseHaveTestCourse(courseId)){
            return false;
        }
        if(!courseHaveTestStudent(student,courseId)){
            return false;
        }
        for(int n = 0;n<courses.get(courseFind(courseId)).getEnrollStudent().size();n++){
            if(student.getStudentID().equals(courses.get(courseFind(courseId)).getEnrollStudent().get(n).getStudentID())){
                if(credits>student.getCredits()+courses.get(courseFind(courseId)).getCredits().get(n)){
                    return false;
                }
            }
        }

        for(int n = 0;n<courses.get(courseFind(courseId)).getEnrollStudent().size();n++){
            if(student.getStudentID().equals(courses.get(courseFind(courseId)).getEnrollStudent().get(n).getStudentID())){
                
                student.setCredits(student.getCredits()+courses.get(courseFind(courseId)).getCredits().get(n)-credits);
                courses.get(courseFind(courseId)).getCredits().set(n,credits);
            }
        }
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }
        if(!courseHaveTestCourse(courseId)){
            return false;
        }
        if(!courseHaveTestStudent(student,courseId)){
            return false;
        }
        for(int n = 0;n<courses.get(courseFind(courseId)).getEnrollStudent().size();n++){
            if(student.equals(courses.get(courseFind(courseId)).getEnrollStudent().get(n))){
               
                student.setCredits(student.getCredits()+courses.get(courseFind(courseId)).getCredits().get(n));
                courses.get(courseFind(courseId)).getCredits().remove(n);
                courses.get(courseFind(courseId)).getEnrollStudent().remove(n);
            }
        }
        for(int n = 0;n<student.getEnrollCourses().size();n++){
            if(student.getEnrollCourses().get(n).getCourseID().equals(courseId)){
                student.getEnrollCourses().remove(n);
                break;
            }
        }
        return true;
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        for(int courseNumber = 0;courseNumber<courses.size();courseNumber++){
            int [] array = new int [courses.get(courseNumber).getEnrollStudent().size()];
            for(int n = 0;n<courses.get(courseNumber).getEnrollStudent().size();n++){
                array [n] = courses.get(courseNumber).getCredits().get(n);
            }
            Arrays.sort(array);
            if(courses.get(courseNumber).getMaxCapacity()<array.length){
                int min = array[array.length-1-courses.get(courseNumber).getMaxCapacity()];
                for(int m = 0;m<courses.get(courseNumber).getEnrollStudent().size();m++){
                    if(courses.get(courseNumber).getCredits().get(m)>min){
                        courses.get(courseNumber).getSuccessStudents().add(courses.get(courseNumber).getEnrollStudent().get(m));
                        courses.get(courseNumber).getEnrollStudent().get(m).getSuccessCourses().add(courses.get(courseNumber));
                    }
                }
            }else {
                for(int m = 0;m<courses.get(courseNumber).getEnrollStudent().size();m++){
                    courses.get(courseNumber).getSuccessStudents().add(courses.get(courseNumber).getEnrollStudent().get(m));
                    courses.get(courseNumber).getEnrollStudent().get(m).getSuccessCourses().add(courses.get(courseNumber));
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){
            return null;
        }
        ArrayList<String> studentClass = new ArrayList<>();
        for(int n = 0;n<student.getEnrollCourses().size();n++){
            for(int m = 0;m<student.getEnrollCourses().get(n).getCredits().size();m++){
                if(student.getEnrollCourses().get(n).getEnrollStudent().get(m).equals(student)){
                    //System.out.println(studentClass.size());
                    //System.out.println(student.getEnrollCourses().get(n).getCourseID() +": "+ student.getEnrollCourses().get(n).getCredits().get(m).toString());
                    studentClass.add(student.getEnrollCourses().get(n).getCourseID() +": "+ student.getEnrollCourses().get(n).getCredits().get(m).toString());
                }
            }
        }
        return studentClass;
    }

    public void addCourse(Course course1) {
      courses.add(course1);
      course1.setCourseManager(this);
    }
}