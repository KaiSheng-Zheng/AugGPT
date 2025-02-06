import java.util.ArrayList;
import java.util.Arrays;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    private boolean ifOpen;

    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int
            credits){
        if(!this.ifOpen){
            return false;
        }
        if(credits <= 0){
            return false;
        }
        Course course = null;
        for(Course c: courses){
            if(c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if(course == null){
            return false;
        }

        Course course1 = null;
        for(Course c : student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)) {
                course1 = c;
                break;
            }
        }
        if(course1 != null){
            return false;
        }
        if(student.getCredits() < credits){
            return false;
        } else {
            int a = student.getCredits() - credits;
            student.setCredits(a);

            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);

            student.getEnrollCourses().add(course);
            return true;
        }

    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,
                                                  int credits){
        if(!this.ifOpen){
            return false;
        }
        Course course = null;
        for(Course c: courses){
            if(c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if(course == null){
            return false;
        }

        Course course1 = null;
        for(Course c : student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)) {
                course1 = c;
                break;
            }
        }
        if(course1 == null){
            return false;
        }
        int index = -1;
        for(int i = 0; i < course.getEnrollStudent().size(); i++){
            if(course.getEnrollStudent().get(i).equals(student)){
                index = i;
                break;
            }
        }

        if(student.getCredits() + course.getCredits().get(index) < credits){
            return false;
        }
        else {
            student.setCredits(student.getCredits() + course.getCredits().get(index) - credits);

            course.getCredits().set(index, credits);
            return true;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!this.ifOpen){
            return false;
        }
        Course course = null;
        for(Course c: courses){
            if(c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if(course == null){
            return false;
        }
        Course course1 = null;
        for(Course c : student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)) {
                course1 = c;
                break;
            }
        }
        if(course1 == null) {
            return false;
        }

        else {
        int index2 = -1;
        for(int i = 0; i < student.getEnrollCourses().size(); i++){
            if(student.getEnrollCourses().get(i).equals(course)){
                index2 = i;
                break;
            }
        }

        int index = -1;
        for(int i = 0; i < course.getEnrollStudent().size(); i++){
            if(course.getEnrollStudent().get(i).equals(student)){
                index = i;
                break;
            }
        }

            student.getEnrollCourses().remove(index2);
            student.setCredits(student.getCredits() + course.getCredits().get(index));

            course.getEnrollStudent().remove(index);
            course.getCredits().remove(index);
            return true;
        }
    }

    public void finalizeEnrollments(){
        ifOpen = false;

        int mincredit = 0;
        for(int i = 0; i < courses.size(); i++){
            Course co = courses.get(i);
            if(co.getCredits().size() > 0) {
                int[] ar = new int[co.getCredits().size()];
                for (int j = 0; j < co.getCredits().size(); j++) {
                    ar[j] = co.getCredits().get(j);
                }
                Arrays.sort(ar);
                if (co.getCredits().size() >= co.getMaxCapacity()) {
                    mincredit = ar[co.getCredits().size() - co.getMaxCapacity()];
                }
                if (co.getCredits().size() < co.getMaxCapacity()) {
                    mincredit = ar[0];
                }

                int mi = 0;
                for (int j = 0; j < co.getCredits().size(); j++) {
                    if (co.getCredits().get(j) > mincredit) {
                        Student theone = co.getEnrollStudent().get(j);
                        co.getSuccessStudents().add(theone);
                        theone.getSuccessCourses().add(co);
                    }
                    if (co.getCredits().get(j) == mincredit) {
                        mi++;
                    }
                }
                    if (mi <= co.getMaxCapacity() - co.getSuccessStudents().size()) {
                        for (int j = 0; j < co.getCredits().size(); j++) {
                            if(co.getCredits().get(j).equals(mincredit)) {
                                Student theone = co.getEnrollStudent().get(j);
                                co.getSuccessStudents().add(theone);
                                theone.getSuccessCourses().add(co);
                            }
                        }

                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!this.ifOpen) {
            return null;
        }
        ArrayList<String> ar = new ArrayList<>();

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course co = student.getEnrollCourses().get(i);
            int index = -1;
            for (int j = 0; j < co.getEnrollStudent().size(); j++) {
                if (co.getEnrollStudent().get(j).equals(student)) {
                    index = j;
                    break;
                }
            }
            ar.add(co.getCourseID() + ": " + co.getCredits().get(index));
        }
        return ar;
    }

}
