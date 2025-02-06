import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int creditBid) {
        if (!ifOpen || student.getCredits() < creditBid || creditBid <= 0) {
            return false;
        }

        Course course = courses.stream().filter(c -> c.getCourseID().equals(courseId)).findFirst().orElse(null);
        if (course == null || course.getEnrollStudent().contains(student)) {
            return false;
        }

        student.setCredits(student.getCredits() - creditBid);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(creditBid);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int newCreditBid) {
        if (!ifOpen) {
            return false;
        }

        Course course = courses.stream().filter(c -> c.getCourseID().equals(courseId)).findFirst().orElse(null);
        if (course == null) {
            return false;
        }

        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1 || student.getCredits() + course.getCredits().get(index) < newCreditBid) {
            return false;
        }

        student.setCredits(student.getCredits() + course.getCredits().get(index) - newCreditBid);
        course.getCredits().set(index, newCreditBid);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }

        Course course = courses.stream().filter(c -> c.getCourseID().equals(courseId)).findFirst().orElse(null);
        if (course == null) {
            return false;
        }

        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1) {
            return false;
        }

        student.setCredits(student.getCredits() + course.getCredits().get(index));
        course.getEnrollStudent().remove(student);
        course.getCredits().remove(index);
        student.getEnrollCourses().remove(course);
        return true;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course course : courses) {
            List<Student> sortedStudents = course.getEnrollStudent().stream()
                    .sorted((s1, s2) -> Integer.compare(course.getCredits().get(course.getEnrollStudent().indexOf(s2)), course.getCredits().get(course.getEnrollStudent().indexOf(s1))))
                    .collect(Collectors.toList());

            course.setSuccessStudents(new ArrayList<>());
            int max = course.getMaxCapacity();
            for (int i = 0; i < Math.min(sortedStudents.size(), max); i++) {
                course.getSuccessStudents().add(sortedStudents.get(i));
            }
        }
    }

    public void setIfOpen(boolean b) {
        ifOpen = b;
    }

    public boolean getIfOpen() {
        return false;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> coursesWithCredits = new ArrayList<>();
        ArrayList<Course> enrolledCourses = student.getEnrollCourses();
        return coursesWithCredits;
    }
}
