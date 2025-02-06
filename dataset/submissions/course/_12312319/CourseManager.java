import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;

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
        return  ifOpen;
    }

    public void setCourses(Course course) {
        this.courses.add(Course);
        course.setCourseManager(this);
    }


    public void setStudents(Student student) {
        this.students.add(Student);
        student.setCourseManager(this);
    }
}