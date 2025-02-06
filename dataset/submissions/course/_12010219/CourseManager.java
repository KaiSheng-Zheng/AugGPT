Public class CourseManagerTest {
 private String studentID;
private String email;
private String name;

 void setUp() {
        courseManager = new CourseManager();
        courseManager.setIfOpen(true);

class Course {
private int credits;
private ArrayList<Course> enrollCourses;
private ArrayList<Course> successCourses;
private ArrayList<Course> courses
private ArrayList<Student> students
private boolean ifOpen

 
    public Course(String courseID, String courseName, int maxCapacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseManager = null;
        this.enrollStudent = new ArrayList<>();
        this.credits = new ArrayList<>();
        this.successStudents = new ArrayList<>();
 
class Student {
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
 
    public boolean enrollStudentInCourse(Student student,String coursed,int credits)
{
        return courseManager.enrollStudentInCourse(this, courseId, credits);
    }
 
    public void setEnrollCourses(ArrayList<Course> enrollCourses) {
        this.enrollCourses = enrollCourses;
    }
 
    public boolean modifyStudentEnrollmentCredits(Student student,String coursed,int credit){
        return courseManager.modifyStudentEnrollmentCredits(this, courseId, credits);
    }
 
    public boolean dropStudentEnrollmentCourse(Student student,String courseId)
 {
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
 
public void addCourse(Course course) {
this.addCourse = addCourse;

    public ArrayList<String> getCoursesWithScores() {
        return courseManager.getEnrolledCoursesWithCredits(this);
    }
 
    public String getStudentID() {
        return this.studentID;
    }
}
public ArrayList<String> getEnrolledCoursesWithCredits(Student student)



