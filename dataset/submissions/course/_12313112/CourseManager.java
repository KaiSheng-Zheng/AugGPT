import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        ifOpen = true;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);

    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int points) {
        boolean i = true, j = false;
        Course a = null;
        for (Course course : this.getCourses()) {
            if (course.getCourseID().equals(courseId)) {
                i = false;
                a = course;
                break;
            }
        }
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                j = true;
                break;
            }
        }

        if (points <= 0 || !this.getIfOpen() || points > student.getCredits() || i || j || student.getCredits() < 0) {
            return false;
        } else {
            student.setCredits(student.getCredits() - points);
            student.getEnrollCourses().add(a);
            a.getEnrollStudent().add(student);
            a.getCredits().add(points);
            return true;
        }

    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean i = true, j = true;
        Course a = null;
        for (Course course : this.getCourses()) {
            if (course.getCourseID().equals(courseId)) {
                i = false;
                a = course;
                break;
            }
        }
        int k = 0;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                j = false;
                k = a.getCredits().get(a.getEnrollStudent().indexOf(student));
                break;
            }
        }
        if (credits <= 0 || !this.getIfOpen() || credits - k > student.getCredits() || i || j || student.getCredits() < 0 || k <= 0) {
            return false;
        } else {
            a.getCredits().set(a.getEnrollStudent().indexOf(student), credits);
            student.setCredits(student.getCredits() + k - credits);
            return true;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean i = true, j = true;
        Course a = null;
        for (Course course : this.getCourses()) {
            if (course.getCourseID().equals(courseId)) {
                i = false;
                a = course;
                break;
            }
        }
        int b = 0;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                j = false;
                b = a.getCredits().get(a.getEnrollStudent().indexOf(student));
                break;
            }
        }

        if (!this.getIfOpen() || i || j) {
            return false;
        } else {
            a.getCredits().remove(a.getEnrollStudent().indexOf(student));
            a.getEnrollStudent().remove(student);
            student.getEnrollCourses().remove(a);
            student.setCredits(student.getCredits() + b);
            return true;
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.getIfOpen()) {
            return null;
        } else {
            ArrayList<String> list = new ArrayList<>();
            for (Course course : student.getEnrollCourses()) {
                int credit = 0;
                for (int i = 0; i < course.getCredits().size(); i++) {
                    if (course.getEnrollStudent().get(i) == student) {
                        credit = course.getCredits().get(i);
                        break;
                    }
                }
                list.add(course.getCourseID() + ": " + credit);

            }
            return list;
        }
    }

    public void finalizeEnrollments() {
        this.setIfOpen(false);
        for (Course course : this.getCourses()) {
            ArrayList<Integer> creditList = new ArrayList<>(course.getCredits());
            for (int i = 0; i < course.getCredits().size(); i++) {
                creditList.set(i,course.getCredits().get(i));
            }

            if (creditList.size() <= course.getMaxCapacity()) {
                for (Student student : course.getEnrollStudent()) {
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                }

            } else {
                creditList.sort(Collections.reverseOrder());
                int min = creditList.get(course.getMaxCapacity());
                for (int i=0; i <course.getCredits().size();i++) {
                    if ( course.getCredits().get(i)> min) {
                        Student student = course.getEnrollStudent().get(i);
                        course.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(course);
                    }
                }
            }
        }
    }
}