import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private boolean ifOpen = true;

    public CourseManager() {
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        if (!courses.stream().anyMatch(c -> c.getCourseID().equals(course.getCourseID()))) {
            course.setCourseManager(this);
            courses.add(course);
        }
    }

    public void addStudent(Student student) {
        if (!students.stream().anyMatch(s -> s.getStudentID().equals(student.getStudentID()))) {
            student.setCourseManager(this);
            students.add(student);
        }
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen || credits <= 0 || student.getCredits() < credits) {
            return false;
        }
        Course course = findCourse(courseId);
        if (course == null || !course.getEnrollStudents().contains(student)) {
            student.enrollCourse(course, credits);
            return true;
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int newCredits) {
        if (!ifOpen || newCredits <= 0) {
            return false;
        }
        Course course = findCourse(courseId);
        if (course != null && course.getEnrollStudents().contains(student)) {
            student.modifyEnrollCredit(course, newCredits);
            return true;
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourse(courseId);
        if (course != null && course.getEnrollStudents().contains(student)) {
            student.dropEnrollCourse(course);
            return true;
        }
        return false;
    }

    public void finalizeEnrollments() {
        if (ifOpen) {
            return;
        }
        for (Course course : courses) {
            // Assuming Course class has a method to finalize enrollments
            course.finalizeEnrollments();
        }
        ifOpen = false;
    }

    public List<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        return student.getEnrollCourses().stream()
                .map(course -> course.getCourseID() + ": " + student.getCreditsBidForCourse(course))
                .collect(Collectors.toList());
    }

    private Course findCourse(String courseId) {
        return courses.stream().filter(course -> course.getCourseID().equals(courseId)).findFirst().orElse(null);
    }
}
