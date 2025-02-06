import java.util.ArrayList;

public class Course {
    private String courseID;
    private String courseName;
    private int maxCapacity;
    private CourseManager courseManager;
    private ArrayList<Student> enrollStudent;
    private ArrayList<Integer> credits;
    private ArrayList<Student> successStudents;

    public Course(String courseID, String courseName, int maxCapacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.courseManager = null;
        this.enrollStudent = new ArrayList<>();
        this.credits = new ArrayList<>();
        this.successStudents = new ArrayList<>();
    }

    public void setEnrollStudent(ArrayList<Student> enrollStudent) {
        this.enrollStudent = enrollStudent;
    }

    public void setCredits(ArrayList<Integer> credits) {
        this.credits = credits;
    }

    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public ArrayList<Integer> getCredits() {
        return credits;
    }

    public ArrayList<Student> getEnrollStudent() {
        return enrollStudent;
    }

    public String getCourseID() {
        return courseID;
    }

    public ArrayList<Student> getSuccessStudents() {
        return successStudents;
    }

    public void setSuccessStudents(ArrayList<Student> successStudents) {
        this.successStudents = successStudents;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}