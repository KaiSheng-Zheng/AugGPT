import java.util.*;

import static java.util.Collections.min;
import static java.util.Collections.sort;

public class CourseManager {
    private ArrayList<Course> courses;

    private ArrayList<Student> students;

    private boolean ifOpen;

    public CourseManager() {
        ifOpen = true;
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        var course = getCourse(courseId);
        if (!ifOpen || failedToEnroll(student, course, credits)) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }

    private boolean failedToEnroll(Student student, Course course, int credits) {
        if (course == null) {
            return true;
        }
        if (credits < 0 || credits > student.getCredits()) {
            return true;
        }
        var enrollStudents = course.getEnrollStudent();
        for (var enrollStudent : enrollStudents) {
            if (enrollStudent.equals(student)) {
                return true;
            }
        }
        return false;
    }

    private Course getCourse(String courseId) {
        for (var course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        var course = getCourse(courseId);
        if (!ifOpen || failedToModify(student, course, credits)) {
            return false;
        }

        int index = course.getEnrollStudent().indexOf(student);
        var courseCredits = course.getCredits();
        int prevCredits = courseCredits.get(index);

        student.setCredits(student.getCredits() + prevCredits - credits);
        courseCredits.set(index, credits);

        return true;
    }

    private boolean failedToModify(Student student, Course course, int credits) {
        if (course == null || credits < 0) {
            return true;
        }
        // Never enrolled.
        if (!course.getEnrollStudent().contains(student)) {
            return true;
        }

        int index = course.getEnrollStudent().indexOf(student);
        int prevCredits = course.getCredits().get(index);
        return student.getCredits() + prevCredits - credits < 0;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        var course = getCourse(courseId);
        if (!ifOpen || failToDrop(student, course)) {
            return false;
        }

        int index = course.getEnrollStudent().indexOf(student);
        int credits = course.getCredits().get(index);

        student.setCredits(student.getCredits() + credits);
        student.getEnrollCourses().remove(course);
        course.getEnrollStudent().remove(student);
        course.getCredits().remove(index);

        return true;
    }

    private boolean failToDrop(Student student, Course course) {
        return course == null || !course.getEnrollStudent().contains(student);
    }

    public void finalizeEnrollments() {
        if(!ifOpen) return ;

        ifOpen = false;
        for (var course : courses) {
            var enrollStudent = course.getEnrollStudent();
            var credits = course.getCredits();

            var temp = new ArrayList<>(enrollStudent);
            enrollStudent.sort((s1, s2) -> {
                int n1 = temp.indexOf(s1);
                int n2 = temp.indexOf(s2);
                return credits.get(n2) - credits.get(n1);
            });
            credits.sort((c1, c2) -> c2 - c1);

            var successStudents = course.getSuccessStudents();
            int maxCap = course.getMaxCapacity();
            for (int i = 0; i < Math.min(maxCap, enrollStudent.size()); i++) {
                successStudents.add(enrollStudent.get(i));
            }

            if (maxCap < enrollStudent.size()) {
                int lastCredit = credits.get(Math.min(maxCap, enrollStudent.size()));
                int end = Math.min(maxCap, enrollStudent.size()) - 1;
                while (!successStudents.isEmpty() && credits.get(end) == lastCredit) {
                    successStudents.remove(end);
                    end -= 1;
                }
            }

            for (var student : successStudents) {
                student.getSuccessCourses().add(course);
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        var enrollCourses = student.getEnrollCourses();
        var result = new ArrayList<String>();
        for (var course : enrollCourses) {
            int index = course.getEnrollStudent().indexOf(student);
            int credit = course.getCredits().get(index);
            String s = String.format("%s: %d", course.getCourseID(), credit);
            result.add(s);
        }
        return result;
    }
}

