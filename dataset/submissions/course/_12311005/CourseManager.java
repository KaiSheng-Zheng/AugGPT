import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private boolean ifOpen = true;

    public CourseManager() {

    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
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
        if (!ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        if (!courses.contains(matchCourseId(courseId))) {
            return false;
        }
        if (credits > student.getCredits()) {
            return false;
        }
        Course course = matchCourseId(courseId);
        student.getEnrollCourses().add(course);
        if (checkIfStudentGetEnrollCourses(matchCourseId(courseId), student)==null) {
            return false;
        }
        course.getCredits().add(credits);
        course.getEnrollStudent().add(student);
        student.setCredits(student.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        if (!courses.contains(matchCourseId(courseId))) {
            return false;
        }
        if (checkIfStudentGetEnrollCourses(matchCourseId(courseId), student)==null) {
            return false;
        }
        Course course = matchCourseId(courseId);
        int index = course.getEnrollStudent().indexOf(student);
        student.setCredits(student.getCredits() + course.getCredits().get(index));
        if (credits > student.getCredits()) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        course.getCredits().remove(index);
        course.getCredits().add(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        if (!courses.contains(matchCourseId(courseId))) {
            return false;
        }
        if (checkIfStudentGetEnrollCourses(matchCourseId(courseId), student)==null) {
            return false;
        }
        Course course = matchCourseId(courseId);
        int index = course.getEnrollStudent().indexOf(student);
        int credit = course.getCredits().get(index);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(student);
        student.getEnrollCourses().remove(course);
        student.setCredits(student.getCredits() + credit);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            ArrayList<Integer> newCredits= new ArrayList<>();
            for (int j = 0; j < course.getCredits().size(); j++) {
                newCredits.add(j,course.getCredits().get(j));
            }
            newCredits.sort(Collections.reverseOrder());
            ArrayList<Integer> credits = course.getCredits();
            int n = course.getMaxCapacity();
            int Integer = 0;
            int chazhi = course.getMaxCapacity() - course.getEnrollStudent().size();
            if (chazhi >= 0) {
                for (int j = 0; j <course.getEnrollStudent().size() ; j++) {
                    course.getSuccessStudents().add(course.getEnrollStudent().get(j));
                    course.getEnrollStudent().get(j).getSuccessCourses().add(course);
                }
                return;
            } else {
                if (newCredits.get(n - 1) == newCredits.get(n)) {
                    Integer = newCredits.get(n - 1) + 1;
                } else {
                    Integer = newCredits.get(n - 1);
                }
                for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                    if (course.getCredits().get(j) >= Integer) {
                        course.getSuccessStudents().add(course.getEnrollStudent().get(j));
                        course.getEnrollStudent().get(j).getSuccessCourses().add(course);
                    }
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> s1 = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course course = student.getEnrollCourses().get(i);
            int index = course.getEnrollStudent().indexOf(student);
            int integer = course.getCredits().get(index);
            String string = course.getCourseID() + ": " + String.valueOf(integer);
            s1.add(string);
        }
        return s1;
    }

    private Course checkIfStudentGetEnrollCourses(Course course, Student student) {

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (course.equals(student.getEnrollCourses().get(i))) {
                return course;
            }
        }
        return null;
    }

    private Course matchCourseId(String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                return courses.get(i);
            }
        }
        return null;
    }
}