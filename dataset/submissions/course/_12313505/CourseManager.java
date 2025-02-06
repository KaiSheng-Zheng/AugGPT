import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    public ArrayList<Student> getStudents(){return students;}
    public ArrayList<Course> getCourses(){return courses;}
    public void setIfOpen(Boolean ifOpen){this.ifOpen=ifOpen;}
    public boolean getIfOpen(){return ifOpen;}
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen==false) return false;
        if (0 > credits ||credits > student.getCredits()) return false;
        Course course=null;
        for (Course courseTest : courses) {
            if (courseTest.getCourseID().equals(courseId)) {
                course = courseTest;
                break;
            }
        }
        if (course==null) return false;
        if (course.getEnrollStudent().contains(student)) return false;
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        student.getEnrollCourses().add(course);
        course.getCredits().add(credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen==false) return false;
        Course course = null;
        for (Course courseTest : courses) {
            if (courseTest.getCourseID().equals(courseId)) {
                course = courseTest;
                break;
            }
        }
        if (course==null) return false;
        if (!course.getEnrollStudent().contains(student)) return false;
        int k=course.getEnrollStudent().indexOf(student);
        int oldcredit = course.getCredits().get(k);
        if (student.getCredits() + oldcredit < credits) return false;
        course.getCredits().set(k, credits);
        student.setCredits(student.getCredits() + oldcredit - credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen==false) return false;
        Course course = null;
        for (Course courseTest : courses) {
            if (courseTest.getCourseID().equals(courseId)) {
                course = courseTest;
                break;
            }
        }
        if (course==null) return false;
        if (!course.getEnrollStudent().contains(student)) return false;
        int k=course.getEnrollStudent().indexOf(student);
        int oldcredit = course.getCredits().get(k);
        course.getCredits().remove(k);
        course.getEnrollStudent().remove(student);
        student.getEnrollCourses().remove(course);
        student.setCredits(student.getCredits() + oldcredit);
        return true;
    }
    public void finalizeEnrollments(){
        if(ifOpen==false) return;
        ifOpen=false;
        for (Course course : courses) {
            ArrayList<Integer> rankCredits = new ArrayList<>(course.getCredits());
            ArrayList<Integer> container = new ArrayList<>();
            int m = course.getMaxCapacity();
            Collections.sort(rankCredits, Comparator.reverseOrder());
            int lowest=0;
            for (int number : rankCredits) {
                if (container.size() < m) {
                    container.add(number);
                }
                else if (container.get(container.size() - 1).equals(number)) {
                    container.removeIf(n->n==number);
                    break;
                }
            }
            if (!container.isEmpty()) {
                lowest = container.get(container.size() - 1);
            }
            ArrayList<Student> index = new ArrayList<>();
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                Student student = course.getEnrollStudent().get(i);
                if(container.isEmpty())lowest=course.getCredits().get(i)+1;
                if (course.getCredits().get(i) >= lowest) {
                    boolean add = index.add(student);
                    student.getSuccessCourses().add(course);
                }
            }
            course.setSuccessStudents(index);
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen==false) return null;
        int enrollmentCredits=0;
        String courseID=null;
        Course course=null;
        int i = 0;
        ArrayList<String> list= new ArrayList<>();
        while (i < student.getEnrollCourses().size()) {
            course = student.getEnrollCourses().get(i);
            int k = course.getEnrollStudent().indexOf(student);
            courseID = course.getCourseID();
            enrollmentCredits = course.getCredits().get(k);
            list.add(String.format("%s: %d", courseID, enrollmentCredits));
            i++;
        }
        return list;
    }
}