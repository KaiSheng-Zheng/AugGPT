import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = true;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addStudent(Student student) {
        if (students.contains(student)){
            return;
        }
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        if (courses.contains(course)){
            return;
        }
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null || student == null ) {
            return false;
        }
        if(student.getEnrollCourses().contains(course) || student.getCredits() < credits){
            return false;
        }
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.setCredits(student.getCredits() - credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int Credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }

        int courseIndex = course.getEnrollStudent().indexOf(student);
        if (courseIndex == -1) {
            return false;
        }
        if (course == null || student == null ) {
                return false;
            }
            if( !student.getEnrollCourses().contains(course) || Credits <= 0 || student.getCredits() + course.getCredits().get(courseIndex) < Credits){
                return false;
            }
            int oldCredits = course.getCredits().get(courseIndex);
            course.getCredits().set(courseIndex, Credits);
            student.setCredits(student.getCredits() + oldCredits - Credits);
            return true;
        }
    public boolean dropStudentEnrollmentCourse(Student s, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null || s == null || !s.getEnrollCourses().contains(course)) {
            return false;
        }
        int yyy=course.getEnrollStudent().indexOf(s);
        if(yyy==-1){
            return false;
        }
        s.setCredits(s.getCredits() + course.getCredits().get(yyy));
        course.getCredits().remove(course.getEnrollStudent().indexOf(s));
        course.getEnrollStudent().remove(s);
        s.getEnrollCourses().remove(course);

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int credits = course.getCredits().get(course.getEnrollStudent().indexOf(student));
            String courseInfo = course.getCourseID() + ": " + credits;
            enrolledCoursesWithCredits.add(courseInfo);
        }
        return enrolledCoursesWithCredits;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            int capacity = course.getMaxCapacity();
            Collections.sort(enrolledStudents, Comparator.comparingInt(student -> credits.get(enrolledStudents.indexOf(student))).reversed());
            Collections.sort(credits, Collections.reverseOrder());
                if (capacity >= enrolledStudents.size()) {
                    for (Student student : enrolledStudents) {
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                    }
                }else {
                    int a=enrolledStudents.size();
                    for(int i=0;i<a;i++){
                        if(enrolledStudents.size()>capacity){
                            enrolledStudents.remove(a-i-1);
                        }else break;
                    }
                    for(int i=0;i<capacity;i++){
                        if(credits.get(capacity-1-i).equals(credits.get(capacity))){
                            enrolledStudents.remove(capacity-1-i);
                        }else break;
                    }
                }
                for (int i=0;i<enrolledStudents.size();i++) {
                    Student student=enrolledStudents.get(i);
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
            }
        }
    }
}


