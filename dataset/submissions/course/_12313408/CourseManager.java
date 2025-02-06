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

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) return false;
        if (credits <= 0) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) return false;
        }
        if (student.getCredits() < credits) return false;

        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) return false;
        if (credits <= 0) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;

        int originalCredits = course.getCredits().get(index);
        if (student.getCredits() + originalCredits < credits) return false;

        student.setCredits(student.getCredits() + originalCredits - credits);
        course.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;

        int originalCredits = course.getCredits().get(index);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(course);
        student.setCredits(student.getCredits() + originalCredits);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) return null;
        ArrayList<String> credit = new ArrayList<>();
        for(Course course:student.getEnrollCourses()){
            int index = -1;
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }
            credit.add(course.getCourseID()+": "+course.getCredits().get(index).toString());
        }
        return credit;
    }

    public void finalizeEnrollments(){
        ifOpen=false;
        for(Course c:courses){
            if(c.getEnrollStudent().size()<=c.getMaxCapacity()){
                c.setSuccessStudents(c.getEnrollStudent());
                for(Student s:c.getEnrollStudent()){
                    s.getSuccessCourses().add(c);
                }
            }else {
                ArrayList<Integer> n=new ArrayList<>();
                for(Integer i:c.getCredits()){
                    n.add(i);
                }
                n.sort(Comparator.reverseOrder());
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if(c.getCredits().get(i)>n.get(c.getMaxCapacity())){
                        c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                        c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                    }
                }
            }
        }
    }

}
