import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {

    private boolean ifOpen;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    private Course courseRequired(String courseId){
        Course courseRequired = null;
        for(Course c: courses){
            if(c.getCourseID() == courseId){
                courseRequired = c;
                break;
            }
        }
        return courseRequired;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen(){
        return ifOpen;
    }


    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }


    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public CourseManager(){
        ifOpen = true;
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        Course CR = courseRequired(courseId);
        boolean hasEnrolled = false;
        boolean hasEnoughCredits = false;
        boolean enrollDone = false;
        int I = 0;
        if(student.getEnrollCourses().contains(CR)){
            hasEnrolled = true;
        }
        if(student.getCredits() >= credits){
            hasEnoughCredits = true;
        }
        if(CR!=null){
            if((ifOpen)&&courses.contains(CR)&&(!hasEnrolled)&&(credits >= 0)&&(hasEnoughCredits)){
                CR.getEnrollStudent().add(student);
                CR.getCredits().add(credits);
                student.getEnrollCourses().add(CR);
                student.setCredits(student.getCredits()-credits);
                enrollDone = true;
            }
        }
        return enrollDone;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean hasModified = false;
        Course CR = courseRequired(courseId);
        boolean courseExist = false;
        boolean hasEnrolled = false;
        boolean hasEnoughCredits = false;
        if(CR!=null){
            courseExist = true;
        }
        if(courseExist) {
            int J = 0;
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (CR.getEnrollStudent().get(i) == student){
                    hasEnrolled = true;
                    J = i;
                }
            }
            if (student.getCredits() + CR.getCredits().get(J) >= credits) {
                hasEnoughCredits = true;
            }
            if (ifOpen && (hasEnrolled) && (hasEnoughCredits)) {
                student.setCredits(student.getCredits() + CR.getCredits().get(J) - credits);
                CR.getCredits().set(J, credits);
                hasModified = true;
            }
        }
        return hasModified;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean dropped = false;
        Course CR = courseRequired(courseId);
        boolean courseExist = false;
        if (ifOpen) {
            boolean hasEnrolled = false;
            int J = 0;
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (CR.getEnrollStudent().get(i) == student) {
                    hasEnrolled = true;
                    J = i;
                }
            }
            if(CR!=null) {
                if (ifOpen && courses.contains(CR) && (hasEnrolled)) {
                    student.setCredits(student.getCredits() + CR.getCredits().get(J));
                    CR.getCredits().remove(J);
                    CR.getEnrollStudent().remove(J);
                    dropped = true;
                }
            }
        }
        return dropped;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> enrollCoursesWithCredits = new ArrayList<>();
        int K = 0;
        int I = 0;
        for (int k = 0; k < student.getEnrollCourses().size(); k++) {
            for (int i = 0; i < student.getEnrollCourses().get(k).getEnrollStudent().size(); i++) {
                if (student.getEnrollCourses().get(k).getEnrollStudent().get(i) == student) {
                    I = i;
                }
            }
            enrollCoursesWithCredits.set(k, student.getEnrollCourses().get(k).getCourseID() + ": " +student.getEnrollCourses().get(k).getCredits().get(I));
        }
        if(!ifOpen)return null;
        else return enrollCoursesWithCredits;
    }

    public void finalizeEnrollments() {
        for (int i = 0; i < courses.size(); i++) {
            Student temStudent;
            for (int  j = 0; j < courses.get(i).getEnrollStudent().size()-1; j++) {
                for (int k = 0; k < courses.get(i).getEnrollStudent().size()-1; k++) {
                    if(courses.get(i).getCredits().get(k)>courses.get(i).getCredits().get(k+1)){
                        temStudent = courses.get(i).getEnrollStudent().get(k);
                        courses.get(i).getEnrollStudent().set(k,courses.get(i).getEnrollStudent().get(k+1));
                        courses.get(i).getEnrollStudent().set(k+1,temStudent);
                    }
                }
            }
            Collections.reverse(courses.get(i).getEnrollStudent());

            for (int j = 0; j < courses.get(i).getMaxCapacity(); j++) {
                courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                courses.get(i).getSuccessStudents().get(j).getSuccessCourses().add(courses.get(i));
            }
        }
        ifOpen = false;
    }
}
