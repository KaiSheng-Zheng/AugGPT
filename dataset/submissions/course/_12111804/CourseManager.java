import java.util.ArrayList;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
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
        course.setCourseManager(this);
        courses.add(course);
    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        students.add(student);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if(!ifOpen){
            return false;
        }
        if(credits <= 0){
            return false;
        }
        Course course = null;
        for(Course c: courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
            }
        }
        if(course == null){
            return false;
        }
        if(course.getEnrollStudent().contains(student)){
            return false;
        }
        if(credits > student.getCredits()){
            return false;
        }
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if(!ifOpen){
            return false;
        }
        if(credits <= 0){
            return false;
        }
        Course course = null;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
            }
        }
        if(course == null){
            return false;
        }
        if(!course.getEnrollStudent().contains(student)){
            return false;
        }
        int index = course.getEnrollStudent().indexOf(student);
        int originCredits = course.getCredits().get(index);
        if (student.getCredits() + originCredits < credits) {
            return false;
        }
        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + originCredits - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if(!ifOpen){
            return false;
        }
        Course course = null;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
            }
        }
        if(course == null){
            return false;
        }
        if(!course.getEnrollStudent().contains(student)){
            return false;
        }
        int index = course.getEnrollStudent().indexOf(student);
        int originCredits = course.getCredits().get(index);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);
        student.setCredits(student.getCredits() + originCredits);
        student.getEnrollCourses().remove(course);
        return true;
    }
    
    public void finalizeEnrollments() {
        for (Course course : courses) {
            int size = course.getEnrollStudent().size();
            int[] credits = new int[size];
            for (int i = 0; i < size; i++) {
                credits[i] = course.getCredits().get(i);
            }
            int success = 0;
            int lowest = 0;
            int max = course.getMaxCapacity();
            do {
                lowest++;
                success = 0;
                for (int i = 0; i < size; i++) {
                    if (credits[i] >= lowest) {
                        success++;
                    }
                }
            } while (success > max);
            for (int i = 0; i < size; i++) {
                if (credits[i] >= lowest) {
                    Student student = course.getEnrollStudent().get(i);
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                }
            }
            ifOpen = false;
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> retrieval = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            String ID = course.getCourseID();
            int credit = course.getCredits().get(index);
            retrieval.add(String.format("%s: %d", ID, credit));
        }
        return retrieval;
    }
}
