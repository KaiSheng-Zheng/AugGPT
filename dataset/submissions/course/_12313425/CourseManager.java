import java.util.ArrayList;
import java.util.Collections;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int
            credits){
            if (!this.ifOpen)
                return  false;
            if (credits<=0){
                return false;
            }
            Course course=null;
        for (Course c:courses) {
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course==null){
            return false;
        }
            Course enrollcourse=null;
        for (Course c:student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                enrollcourse=c;
                break;
            }
        }
        if (enrollcourse==null){
            return false;
        }
        if (student.getCredits()<credits){
            return false;
        }
        student.setCredits(student.getCredits()-credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,
                                                  int credits){
        if (!this.ifOpen)
            return  false;
        Course course=null;
        for (Course c:courses) {
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course==null){
            return false;
        }
        int index=-1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index=i;
                break;
            }
            }
        int oringinnalCredis=course.getCredits().get(index);
        if ((oringinnalCredis+credits)>student.getCredits()){
            return false;
        }
        course.getCredits().set(index,student.getCredits()+oringinnalCredis-credits);
        student.setCredits(student.getCredits()-credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!this.ifOpen)
            return  false;
        Course course=null;
        for (Course c:courses) {
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course==null){
            return false;
        }
        int index=-1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index=i;
                break;
            }
        }
        course.getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(index);
        student.setCredits(student.getCredits()+course.getCredits().get(index));
        course.getCredits().remove(index);
        return true;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!this.ifOpen)
            return null;
        ArrayList<String> arr = new ArrayList<>();
        for (Course c : student.getEnrollCourses()) {
            int index = -1;
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                int credits = c.getCredits().get(index);
                arr.add("Course: " + c.getCourseID() + ", Credits: " + credits);
            }
        }
        return arr;
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        for (Course c : courses){
            for (int i = 0; i < c.getCredits().size() - 1; i++) {
                for (int j = 0; j < c.getCredits().size() - 1 - i; j++) {
                    if (c.getCredits().get(j) > c.getCredits().get(j + 1)) {
                        int tempCredits = c.getCredits().get(j);
                        c.getCredits().set(j, c.getCredits().get(j + 1));
                        c.getCredits().set(j + 1, tempCredits);
                        Student tempEnrollStudent = c.getEnrollStudent().get(j);
                        c.getEnrollStudent().set(j, c.getEnrollStudent().get(j + 1));
                        c.getEnrollStudent().set(j + 1, tempEnrollStudent);
                        for (int k = 0; k < c.getMaxCapacity(); k++) {
                            c.getSuccessStudents().set(k, c.getEnrollStudent().get(k));
                        for (Student student:students){
                            for (Course course:student.getEnrollCourses()){
                                if (course.getSuccessStudents().contains(student)){
                                    student.getSuccessCourses().add(course);
                                    for (int d : c.getCredits()) {
                                        int minValue = Collections.min(c.getCredits());
                                        if (c.getCredits().get(c.getCredits().size()-1)!=minValue){
                                            break;
                                        }
                                        for (int l = 0; l <c.getCredits().size() ; l++) {
                                            if (c.getCredits().get(l)==minValue) {
                                                c.getCredits().remove(l);
                                                student.getSuccessCourses().remove(l);
                                                l--;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        }
    }


    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public CourseManager(){
        courses =new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
}
