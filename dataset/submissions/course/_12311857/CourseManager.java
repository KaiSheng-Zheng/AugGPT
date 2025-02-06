import java.util.ArrayList;
import java.util.Collections;
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

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
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
        Course course1 = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course1 = c;
                break;
            }
        }
        if (course1 == null) {
            return false;
        }
        Course course2 = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                course2 = c;
                break;
            }
        }
        if (course2 != null) {
            return false;
        }
        if (student.getCredits() < credits) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        course1.getEnrollStudent().add(student);
        course1.getCredits().add(credits);
        student.getEnrollCourses().add(course1);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        Course course1 = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course1 = c;
                break;
            }
        }
        if (course1 == null) {
            return false;
        }
        Course course2 = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                course2 = c;
                break;
            }
        }
        if (course2 == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course2.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course2.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course2.getCredits().get(index);
        if (student.getCredits() + originalCredits < credits) {
            return false;
        }
        student.setCredits(student.getCredits() + originalCredits - credits);
        course2.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen)
            return false;
        Course course1 = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course1 = c;
                break;
            }
        }
        if (course1 == null) {
            return false;
        }
        Course course2 = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                course2 = c;
                break;
            }
        }
        if (course2 == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course2.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course2.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int Credits = course2.getCredits().get(index);
        for (int i = 0; i < course2.getCredits().size(); i++) {
            if (i == index) {
                course2.getCredits().remove(i);
                break;
            }
        }
        for (int i = 0; i < course2.getEnrollStudent().size(); i++) {
            if (i == index) {
                course2.getEnrollStudent().remove(i);
                break;
            }
        }
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                student.getEnrollCourses().remove(c);
                break;
            }
        }
        student.setCredits(student.getCredits() + Credits);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen)
            return null;
        ArrayList<String> EnrolledCoursesWithCredits = new ArrayList<String>();
        for (Course c : student.getEnrollCourses()) {
            int index = -1;
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }
            Integer Credits = c.getCredits().get(index);
            String CourseId = c.getCourseID();
            String s = CourseId + ": " +Credits;
            EnrolledCoursesWithCredits.add(s);
        }
        return EnrolledCoursesWithCredits;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course c : courses) {
            ArrayList<Integer> Credit = new ArrayList<Integer>();
            for (int i = 0; i < c.getCredits().size(); i++) {
                Credit.add(c.getCredits().get(i));
            }
            Collections.sort(Credit, Collections.reverseOrder());
            if (c.getCredits().size() <= c.getMaxCapacity()) {
                c.setSuccessStudents(c.getEnrollStudent());
                for (Student s : c.getSuccessStudents()) {
                    for (Course cc : s.getEnrollCourses()) {
                        if (cc.getCourseID().equals(c.getCourseID())) {
                            s.getSuccessCourses().add(cc);
                        }
                    }
                }
            } else {
                Integer num = 0;
                for (; ; num++) {
                    int capacity = 0;
                    for (int i = 0; i < Credit.size(); i++) {
                        if (Credit.get(i) >= num) {
                            capacity++;
                        }
                    }
                    if (capacity <= c.getMaxCapacity()) {
                        break;
                    }
                }
                for (int i = 0; i < c.getCredits().size(); i++) {
                    int n = 0;
                    if (c.getCredits().get(i) >= num) {
                        c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                        for (Course cc : c.getSuccessStudents().get(n).getEnrollCourses()) {
                            if (cc.getCourseID().equals(c.getCourseID())) {
                                c.getSuccessStudents().get(n).getSuccessCourses().add(cc);
                                n++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
}
