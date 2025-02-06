import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
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

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if (credits <= 0)
            return false;
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        for (Course EnrolledCourse : student.getEnrollCourses()) {
            if (EnrolledCourse.getCourseID().equals(courseId)) {
                course = EnrolledCourse;
                break;
            }
        }
        if (student.getCredits() - credits < 0)
            return false;
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if (credits <= 0)
            return false;
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        for (Course EnrolledCourse : student.getEnrollCourses()) {
            if (EnrolledCourse.getCourseID().equals(courseId)) {
                course = EnrolledCourse;
                break;
            }
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        int originalCredits = course.getCredits().get(index);
        int availableCredits = student.getCredits() + originalCredits;
        if (credits > availableCredits)
            return false;
        student.setCredits(availableCredits - credits);
        course.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        for (Course EnrolledCourse : student.getEnrollCourses()) {
            if (EnrolledCourse.getCourseID().equals(courseId)) {
                course = EnrolledCourse;
                break;
            }
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size() ; i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;
        int newCredits = student.getCredits() + course.getCredits().get(index);
        student.setCredits(newCredits);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(student);
        student.getEnrollCourses().remove(course);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> EnrolledCoursesWithCredits = new ArrayList<>();

        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            if (index != -1) {
                int credit = course.getCredits().get(index);
                String CourseWithCredit = course.getCourseID() + ": " + credit;
                EnrolledCoursesWithCredits.add(CourseWithCredit);
            }
        }
        return EnrolledCoursesWithCredits;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            if (course.getEnrollStudent().size() > course.getMaxCapacity()) {
                List<Student> enrolledStudents = course.getEnrollStudent();
                List<Integer> creditsList = course.getCredits();
                List<Integer> rankToll = new ArrayList<>(creditsList);
                rankToll.sort(Collections.reverseOrder());
                rankToll.add(0);
                int least = rankToll.get(course.getMaxCapacity());
                if (least == rankToll.get(course.getMaxCapacity())-1) {
                    least++;
                }
                for (int i = 0; i < course.getCredits().size(); i++) {
                    if (course.getCredits().get(i) > least) {
                        Student student = enrolledStudents.get(i);
                        course.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(course);
                    }
                }
            } else{
                List<Student> enrolledStudents = course.getEnrollStudent();
                for (int i = 0; i < course.getCredits().size(); i++) {
                    if (course.getCredits().get(i) > 0) {
                        Student student = enrolledStudents.get(i);
                        course.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(course);
                    }
                }
            }
        }
    }
}
