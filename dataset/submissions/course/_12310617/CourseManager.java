import java.util.ArrayList;
import java.util.Collections;
public class CourseManager {
    private ArrayList<Course> courses=new ArrayList<Course>();
    private ArrayList<Student> students=new ArrayList<Student>();
    private boolean ifOpen;

    public CourseManager() {
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
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
        boolean flag1=true;
        boolean flag2=false;
        if(this.getIfOpen()) {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    for (Student student1 : course.getEnrollStudent()) {
                        if (student1.getStudentID().equals(student.getStudentID())) {
                            flag1 = false;
                            break;
                        }
                    }
                    if (flag1 & student.getCredits() >= credits & credits > 0) {
                        flag2 = true;
                        student.setCredits(student.getCredits() - credits);
                        course.getEnrollStudent().add(student);
                        course.getCredits().add(credits);
                        student.getEnrollCourses().add(course);
                    }
                    break;
                }

            }
        }
        return flag2;

    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        boolean flag=false;
        if(this.getIfOpen()) {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    for (Student student1 : course.getEnrollStudent()) {
                        if (student1.getStudentID().equals(student.getStudentID()) ) {
                            int index1=course.getEnrollStudent().indexOf(student);
                            int creditChange=credits-course.getCredits().get(index1);
                            if ( credits>0 & creditChange<=student.getCredits()){
                                flag=true;
                                student.setCredits(student.getCredits()-creditChange);
                                course.getCredits().set(index1,credits);
                            }
                            break;
                        }
                    }
                    break;
                }

            }
        }
        return flag;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        boolean flag=false;
        if(this.getIfOpen()) {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    for (Student student1 : course.getEnrollStudent()) {
                        if (student1.getStudentID().equals(student.getStudentID()) ) {
                            flag=true;
                            int index1=course.getEnrollStudent().indexOf(student);
                            student1.setCredits(student1.getCredits()+course.getCredits().get(index1));
                            student1.getEnrollCourses().remove(course);
                            course.getCredits().remove(index1);
                            course.getEnrollStudent().remove(index1);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return flag;
    }
    public void finalizeEnrollments(){
        this.setIfOpen(false);
        for (Course course:courses){
            for (int j=0;j<course.getEnrollStudent().size()-1;j++) {
                for (int i = 0; i < course.getEnrollStudent().size()-1; i++) {
                    if (course.getCredits().get(i) < course.getCredits().get(i + 1)) {
                        Collections.swap(course.getCredits(), i, i + 1);
                        Collections.swap(course.getEnrollStudent(), i, i + 1);
                    }
                }
            }
            if (course.getEnrollStudent().size()==1){
                Student student=course.getEnrollStudent().get(0);
                course.getSuccessStudents().add(student);
                student.getSuccessCourses().add(course);
            }

            if (course.getEnrollStudent().size()>1) {
                int capacity = 1;
                int sameCredits = 1;
                while (capacity < course.getMaxCapacity() & capacity < course.getCredits().size()) {

                    if (course.getCredits().get(capacity) == course.getCredits().get(capacity - 1)) {
                        sameCredits++;
                    } else {
                        sameCredits = 1;
                    }
                    capacity++;
                }
                if (sameCredits==1 & capacity < course.getCredits().size()){
                    if (course.getCredits().get(capacity) == course.getCredits().get(capacity-1)){
                        capacity-=1;
                    }
                }
                if (capacity == course.getMaxCapacity() & sameCredits >= 2 & capacity < course.getCredits().size()) {
                    if (course.getCredits().get(capacity) == course.getCredits().get(capacity-1)) {
                        capacity = capacity - sameCredits;
                    }
                }
                for (int i = 0; i < capacity; i++) {
                    Student successStudent = course.getEnrollStudent().get(i);
                    course.getSuccessStudents().add(successStudent);
                    successStudent.getSuccessCourses().add(course);
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (this.getIfOpen()){
            ArrayList<String> list=new ArrayList<String>();
            for (Course course:student.getEnrollCourses()){
                String string=course.getCourseID()+": "+course.getCredits().get(course.getEnrollStudent().indexOf(student));
                list.add(string);
            }
            return list;
        }else {return null;}
    }
}
