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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);

    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (!this.ifOpen){
            return false;
        }
        if (credits <= 0 ){
            return false;
        }


        Course course = null;
        for (Course c : courses){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }


        course = null;
        for (Course c : student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course != null){
            return false;
        }


        for (Course c : courses){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }


        if (student.getCredits() < credits){
            return false;
        }
        student.setCredits(student.getCredits()-credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!this.ifOpen){
            return false;
        }
        if (credits <= 0 ){
            return false;
        }
        Course course = null;
        for (Course c : courses){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
        course = null;
        for (Course c : student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        if (student.getCredits()<(credits-originalCredits)){
            return false;
        }
        student.setCredits(student.getCredits()-(credits-originalCredits));
        course.getCredits().set(index,credits);
        getEnrolledCoursesWithCredits(student);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!this.ifOpen){
            return false;
        }
        Course course = null;
        for (Course c : courses){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
        course = null;
        for (Course c : student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
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
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = -1;
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                    index = i;
                    break;
                }
            }
            int credits = course.getCredits().get(index);
            enrolledCoursesWithCredits.add(course.getCourseID()+": "+credits);
        }
        return enrolledCoursesWithCredits;
    }
    public void finalizeEnrollments(){
        this.ifOpen = false;
        for (Course course : this.getCourses()){
            int integer = 0;
            int count;
            ArrayList<Integer> successStudentIndex = new ArrayList<>();
            do {
                integer++;
                count = 0;
                successStudentIndex.clear();
                for (int i = 0; i < course.getCredits().size(); i++) {
                    if (course.getCredits().get(i) >= integer){
                        count++;
                        successStudentIndex.add(i);
                    }
                }
            }while (count > course.getMaxCapacity());

            for (int index : successStudentIndex){
                course.getSuccessStudents().add(course.getEnrollStudent().get(index));
                course.getEnrollStudent().get(index).getSuccessCourses().add(course);

            }
        }
    }

}