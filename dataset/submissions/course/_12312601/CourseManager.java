import java.util.ArrayList;
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

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
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
        if (course == null) {
            return false;
        }
        Course getEnrollCourse = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                getEnrollCourse = c;
                break;
            }
        }
        if (getEnrollCourse != null) {
            return false;
        }
        if (student.getCredits() < credits) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
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
        if (course == null) {
            return false;
        }
        Course course1 = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                course1 = c;
                break;
            }
        }
        if (course1 == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course1.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course1.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        int originalCredits = course1.getCredits().get(index);
        if (student.getCredits() + originalCredits - credits < 0) {
            return false;
        }
        student.setCredits(student.getCredits() + originalCredits - credits);
        course1.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c:courses){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
        Course course1 = null;
        for (Course c: student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                course1 = c;
                break;
            }
        }
        if (course1 == null){
            return false;
        }
        int index = -1;
        for (int i = 0; i <course1.getEnrollStudent().size(); i++) {
            if(student.getStudentID().equals(course1.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        int save = course1.getCredits().get(index);
        course1.getCredits().remove(index);
        student.setCredits(student.getCredits()+save);
        course1.getEnrollStudent().remove(student);
        student.getEnrollCourses().remove(course1);
        return true;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!this.ifOpen){
            return null;}
        ArrayList<String> coursesWithCredits = new ArrayList<>();
        for (Course c: student.getEnrollCourses()){
            int studentIndex = c.getEnrollStudent().indexOf(student);
            if (studentIndex != -1){
                String courseInfo = c.getCourseID() + ": " + c.getCredits().get(studentIndex);
                coursesWithCredits.add(courseInfo);
            }
        }
        return coursesWithCredits;
    }
    public void finalizeEnrollments(){
        this.ifOpen = false;
        for (Course course : this.courses){
        ArrayList<Integer> creditsList = new ArrayList<>(course.getCredits());
        int capacity = course.getMaxCapacity();
        for (int i = 0; i < course.getCredits().size(); i++) {
            if (creditsList.size() <= capacity){
                for (Student student : course.getEnrollStudent()){
                    if (!course.getSuccessStudents().contains(student)) {
                        course.getSuccessStudents().add(student);
                    }
                    if (!student.getSuccessCourses().contains(course)) {
                        student.getSuccessCourses().add(course);
                    }
                }
                } else
                {creditsList.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                            }
                        });
                int integer = creditsList.get(capacity)+1;
                if (course.getCredits().get(i) >= integer){
                    Student student = course.getEnrollStudent().get(i);
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                    }
                }
            }
        }
    }
}