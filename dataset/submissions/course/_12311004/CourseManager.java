import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//import java.util.HashMap;
//import java.util.Map;
public class CourseManager {
    //    public static void main(String[] args) {
//
//    }
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

//    CourseManager cm = new CourseManager();
//    private Map<String, Course> courseMap = new HashMap<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int points) {
        if (!ifOpen || points <= 0 || !courseFinder(courseId) || compare(getCourse(courseId), student.getStudentID()) || student.getCredits() < points)
            return false;
        else {
            student.setCredits(student.getCredits() - points);
            getCourse(courseId).getEnrollStudent().add(student);
            getCourse(courseId).getCredits().add(points);
            student.getEnrollCourses().add(getCourse(courseId));
            return true;
  
            //what's the difference between such operation and a "set" method?
        }
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
 
        if(!ifOpen || !courseFinder(courseId) || !studentFinder(student.getStudentID(), courseId) || (student.getCredits() + getCourse(courseId).getCredits().get(getCourse(courseId).getEnrollStudent().indexOf(student)) < credits)) return false;
        else {
            student.setCredits(student.getCredits() + getCourse(courseId).getCredits().get(getCourse(courseId).getEnrollStudent().indexOf(student)) - credits);
            getCourse(courseId).getCredits().set(getCourse(courseId).getEnrollStudent().indexOf(student), credits);
            return true;
        }
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen || !courseFinder(courseId) || !studentFinder(student.getStudentID(), courseId)) return false;
        else {
            student.setCredits(student.getCredits() + getCourse(courseId).getCredits().get(getCourse(courseId).getEnrollStudent().indexOf(student)));
            student.getEnrollCourses().remove(getCourse(courseId));
            getCourse(courseId).getCredits().remove(getCourse(courseId).getEnrollStudent().indexOf(student));
            getCourse(courseId).getEnrollStudent().remove(student);
   
            return true;
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen) return null;
        else{
            ArrayList<String> EnrolledCoursesWithCredits = new ArrayList<>();
            for(Course course : student.getEnrollCourses()){
                EnrolledCoursesWithCredits.add(course.getCourseID() + ": " + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
            }
            return EnrolledCoursesWithCredits;
        }
    }
    public void finalizeEnrollments(){
        ifOpen = false;
//        ArrayList<Integer> filter = new ArrayList<>();
        for (Course course : courses){
            if(course.getCredits().isEmpty()) continue;
            sortCourse(course);
        }
       
    }
    public void sortCourse(Course course){
        ArrayList<Integer> sortCredits = new ArrayList<>(course.getCredits());
        Collections.sort(sortCredits);
        Collections.reverse(sortCredits);
        ArrayList<Student> successStudent = new ArrayList<>();
        if(course.getMaxCapacity() >= course.getEnrollStudent().size()){
            for(int i = 0; i < course.getCredits().size(); i++){

                    successStudent.add(course.getEnrollStudent().get(i));
                    course.setSuccessStudents(successStudent);

                   
                    course.getEnrollStudent().get(i).getSuccessCourses().add(course);

            }
            return;
        }
        int max = sortCredits.get(course.getMaxCapacity() - 1);//When getting, make sure it is in the arraylist!
        int counter = 0;
        for (Integer i : course.getCredits()){
            if (i >= max) counter++;
        }
        int standard = 0;
        if (counter > course.getMaxCapacity()){
            standard = max + 1;
        }
        else standard = max;

        

        for(int i = 0; i < course.getCredits().size(); i++){
            if(course.getCredits().get(i) >= standard){
                successStudent.add(course.getEnrollStudent().get(i));
                course.setSuccessStudents(successStudent);

                
                course.getEnrollStudent().get(i).getSuccessCourses().add(course);
            }
        }
    }
    public boolean courseFinder(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) return true;
        }
            return false;
    }
    public Course getCourse (String courseId){
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) return course;
        }
        return null;
    }
    public boolean studentFinder(String studentID, String courseId) {
        for (Course courseFind : courses) {
            if (courseFind.getCourseID().equals(courseId))
                return compare(courseFind,studentID);
        }
        return false;
    }
    public boolean compare(Course courseFind, String studentID){
        for(Student s : courseFind.getEnrollStudent()){
            if (s.getStudentID().equals(studentID)) return true;
        }
        return false;
    }
}
