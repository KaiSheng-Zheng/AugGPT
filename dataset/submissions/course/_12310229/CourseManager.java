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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if (credits<=0){
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        Course course = null;
        Course course2=null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        for (Course d : student.getEnrollCourses()) {
            if (d.getCourseID().equals(courseId)) {
                course2 = d;
                break;
            }
        }
        if (course2 != null) {
            return false;
        }
        if (student.getCredits() < credits) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        if (credits<=0){
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index==-1){
            return false;
        }
        if (course.getCredits().get(index) + student.getCredits() < credits) {
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        course.getCredits().set(index,credits);
        student.setCredits(student.getCredits() + originalCredits - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        
        if (index==-1){
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(course);
        student.setCredits(student.getCredits()+originalCredits);
        return true;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!this.ifOpen){
            return null;
        }
        ArrayList<String> Coursecredits=new ArrayList<>();
        for (Course c:student.getEnrollCourses()){
            int index=-1;
            for (int i = 0; i <c.getEnrollStudent().size() ; i++) {
                if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())){
                    index=i;
                    break;
                }
            }
            Coursecredits.add(c.getCourseID()+": "+c.getCredits().get(index));
        }
        return Coursecredits;
    }
    public void finalizeEnrollments(){
        this.ifOpen=false;
        for (Course c:courses){
            double test=-0.5;
            while (true){
                test+=0.5;
                int sum=0;
                for (int d:c.getCredits()){
                    if (d>=test){
                        sum++;
                    }
                }
                if (sum<=c.getMaxCapacity()){
                    break;
                }
            }
            for (int i = 0; i <c.getCredits().size() ; i++) {
                if (c.getCredits().get(i)>=test){
                    c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                }
            }
        }
    }
}