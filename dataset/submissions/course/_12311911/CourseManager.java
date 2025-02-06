import java.util.ArrayList;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return this.ifOpen;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }

        Course course = this.getCourseByID(courseId);
        if (course == null || student.getEnrollCourses().contains(course) || credits <= 0 || student.getCredits() < credits) {
            return false;
        }

        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }

        Course course = this.getCourseByID(courseId);
        if (course == null || !student.getEnrollCourses().contains(course) || credits <= 0 || student.getCredits() + course.getCredits().get(student.getEnrollCourses().indexOf(course)) < credits) {
            return false;
        }

        int oldCredits = course.getCredits().get(student.getEnrollCourses().indexOf(course));
        student.setCredits(student.getCredits() + oldCredits - credits);
        course.getCredits().set(student.getEnrollCourses().indexOf(course), credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }

        Course course = this.getCourseByID(courseId);
        if (course == null || !student.getEnrollCourses().contains(course)) {
            return false;
        }

        int index = student.getEnrollCourses().indexOf(course);
        int credits = course.getCredits().get(index);
        student.setCredits(student.getCredits() + credits);
        student.getEnrollCourses().remove(index);
        course.getEnrollStudent().remove(student);
        course.getCredits().remove(index);
        return true;
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;

        for (Course course : this.courses) {
            course.getEnrollStudent().sort(Comparator.comparingInt(s -> course.getCredits().get(course.getEnrollStudent().indexOf(s))).reversed());
            int capacity = course.getMaxCapacity();
            ArrayList<Student> successStudents = new ArrayList<>();
            ArrayList<Integer> successCredits = new ArrayList<>();

            for (Student student : course.getEnrollStudent()) {
                if (capacity > 0) {
                    successStudents.add(student);
                    successCredits.add(course.getCredits().get(course.getEnrollStudent().indexOf(student)));
                    capacity--;
                } else {
                    break;
                }
            }

            course.setSuccessStudents(successStudents);
            course.setCredits(successCredits);

            for (Student student : successStudents) {
                student.getSuccessCourses().add(course);
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        }

        ArrayList<String> result = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = student.getEnrollCourses().indexOf(course);
            result.add(course.getCourseID() + ": " + course.getCredits().get(index));
        }
        return result;
    }

    private Course getCourseByID(String courseId) {
        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}
