import java.util.ArrayList;

import java.util.List;
public class Student {
    private String studentID;
    private String email;
    private String name;
    private CourseManager courseManager;
    private int credits;
    private ArrayList<Course> enrollCourses;
    private ArrayList<Course> successCourses;

    public Student(String studentID, String email, String name, int credits) {
        this.studentID = studentID;
        this.email = email;
        this.name = name;
        this.courseManager = null;
        this.credits = credits;
        this.enrollCourses = new ArrayList<>();
        this.successCourses = new ArrayList<>();
    }

    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public ArrayList<Course> getEnrollCourses() {
        return enrollCourses;
    }

    public boolean enrollCourse(String courseId, int credits) {
        return courseManager.enrollStudentInCourse(this, courseId, credits);
    }

    public void setEnrollCourses(ArrayList<Course> enrollCourses) {
        this.enrollCourses = enrollCourses;
    }

    public boolean modifyEnrollCredit(String courseId, int credits) {
        return courseManager.modifyStudentEnrollmentCredits(this, courseId, credits);
    }

    public boolean dropEnrollCourse(String courseId) {
        return courseManager.dropStudentEnrollmentCourse(this, courseId);
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public ArrayList<Course> getSuccessCourses() {
        return successCourses;
    }

    public void setSuccessCourses(ArrayList<Course> successCourses) {
        this.successCourses = successCourses;
    }

    public ArrayList<String> getCoursesWithScores() {
        return courseManager.getEnrolledCoursesWithCredits(this);
    }

    public String getStudentID() {
        return this.studentID;
    }
}