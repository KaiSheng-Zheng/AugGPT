import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    //missing getter
    private boolean ifOpen;
    public CourseManager() {
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    public boolean getIfOpen() {
        return ifOpen;
    }
    public void setIfOpen(boolean ifOpen){
        this.ifOpen=ifOpen;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean ifEnrolled = false;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                ifEnrolled = true;
                break;
            }
        }
        if (!ifOpen || credits <= 0 || student.getCredits() < credits || ifEnrolled) {
            return false;
        }
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                student.getEnrollCourses().add(course);
                student.setCredits(student.getCredits() - credits);
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
                return true;
            }
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course thisCourse = null;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                thisCourse = course;
                break;
            }
        }
        if (thisCourse == null) {
            return false;
        }
        int index, originCredits;
        if (thisCourse.getEnrollStudent().contains(student)) {
            index = thisCourse.getEnrollStudent().indexOf(student);
            originCredits = thisCourse.getCredits().get(index);
            int currentCredit = student.getCredits() + originCredits - credits;
            if (currentCredit >= 0) {
                student.setCredits(currentCredit);
                thisCourse.getCredits().set(index, credits);
                return true;
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course thisCourse = null;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                thisCourse = course;
                break;
            }
        }
        if (thisCourse == null) {
            return false;
        }
        int index;
        if (thisCourse.getEnrollStudent().contains(student)) {
            index = thisCourse.getEnrollStudent().indexOf(student);
            student.setCredits(student.getCredits()+thisCourse.getCredits().get(index));
            thisCourse.getCredits().remove(index);
            thisCourse.getEnrollStudent().remove(index);
            student.getEnrollCourses().remove(thisCourse);
            return true;
        }
        return false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> arr=new ArrayList<>();
        int index;
        int credits;
        for(Course course:student.getEnrollCourses()){
            index=course.getEnrollStudent().indexOf(student);
            credits=course.getCredits().get(index);
            arr.add(course.getCourseID()+": "+credits);
        }
        return arr;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        for(Course course:courses){
            if(course.getCredits().size()<=course.getMaxCapacity()){
                course.setSuccessStudents(course.getEnrollStudent());
                for(Student student:course.getEnrollStudent()){
                    student.getSuccessCourses().add(course);
                }
                continue;
            }
            ArrayList<Integer> sortedArr=new ArrayList<>(course.getCredits());
            sortedArr.sort(Collections.reverseOrder());
            int limit=sortedArr.get(course.getMaxCapacity());
            for(int i=0;i<course.getEnrollStudent().size();i++){
                if(course.getCredits().get(i)>limit){
                    course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                    course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                }
            }
        }
    }
}
