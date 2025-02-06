import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

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
        if (!ifOpen) return false;
        if (credits <= 0) return false;
        Course course = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                course = courses.get(i);
                break;
            }
        }
        if (course == null) return false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                return false;
            }
        }
        if (student.getCredits() - credits < 0) return false;

        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        Course course = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                course = courses.get(i);
                break;
            }
        }
        if (course == null) return false;
        int value = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                value = 1;
            }
        }
        if (value == -1) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        if (originalCredits + student.getCredits() < credits) {
            return false;
        } else {
            student.setCredits(originalCredits + student.getCredits() - credits);
            course.getCredits().set(index, credits);
            return true;
        }

    }

    public boolean dropStudentEnrollmentCourse(Student s, String courseId) {
        if (!ifOpen) return false;
        Course course = null;

        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (course == null) return false;

        if (!s.getEnrollCourses().removeIf(c -> c.getCourseID().equals(courseId))) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(s)) {
                index = i;
                break;
            }
        }

        if (index == -1) return false;

        s.setCredits(s.getCredits() + course.getCredits().get(index));

        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);

        return true;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;
        else {
            ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
            int index = -1;
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if (student.getStudentID().equals(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID())) {
                        index = j;
                        break;
                    }
                }
                String id = student.getEnrollCourses().get(i).getCourseID();
                int c = student.getEnrollCourses().get(i).getCredits().get(index);
                String formattedString = String.format("%s: %d", id, c);
                enrolledCoursesWithCredits.add(formattedString);
            }
            return enrolledCoursesWithCredits;
        }
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course course : courses) {
            int capacity = course.getMaxCapacity();
            ArrayList<Integer> bubbleCredits = new ArrayList<>(course.getCredits());
            ArrayList<Student> bubbleStudents = new ArrayList<>(course.getEnrollStudent());

            for (int j = 0; j < bubbleCredits.size() - 1; j++) {
                for (int k = 0; k < bubbleCredits.size() - 1 - j; k++) {
                    if (bubbleCredits.get(k) < bubbleCredits.get(k + 1)) {
                        Collections.swap(bubbleCredits, k, k + 1);
                        Collections.swap(bubbleStudents, k, k + 1);
                    }
                }
            }

            course.getSuccessStudents().clear();
            if (capacity >= bubbleStudents.size()) {
                for (int j = 0; j < bubbleStudents.size(); j++) {
                    Student student = bubbleStudents.get(j);
                    student.getSuccessCourses().add(course);
                    course.getSuccessStudents().add(student);
                }
            } else {
                int N = bubbleCredits.get(capacity);
                for (int j = 0; j < bubbleStudents.size(); j++) {
                    if (bubbleCredits.get(j) > N) {
                        Student student = bubbleStudents.get(j);
                        student.getSuccessCourses().add(course);
                        course.getSuccessStudents().add(student);
                    }
                }
            }
        }
    }
}