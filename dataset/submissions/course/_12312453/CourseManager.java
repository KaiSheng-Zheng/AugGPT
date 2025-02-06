import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
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

    public boolean isIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        for (Course course : courses){
            if (courseId.equals(course.getCourseID())
                    && !course.getEnrollStudent().contains(student)
                    && credits > 0 && credits <= student.getCredits()){
                student.setCredits(student.getCredits() - credits);
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
                student.getEnrollCourses().add(course);
                return true;
            }
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        for (Course course : courses){
            if (courseId.equals(course.getCourseID())
                    && course.getEnrollStudent().contains(student)
                    && credits > 0 && credits <= student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student))){
                student.setCredits(student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)) - credits);
                course.getCredits().set(course.getEnrollStudent().indexOf(student), credits);
                return true;
            }
        }
        return false;
    }

    //student choose to drop the course
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }
        for (Course course : courses){
            if (courseId.equals(course.getCourseID())
                    && course.getEnrollStudent().contains(student)){
                student.setCredits(student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
                course.getCredits().remove(course.getEnrollStudent().indexOf(student));
                course.getEnrollStudent().remove(student);
                student.getEnrollCourses().remove(course);
                return true;
            }
        }
        return false;
    }

    public void finalizeEnrollments(){
        for (Course course : courses){
            //whether it need to drop
            while (course.getEnrollStudent().size() > course.getMaxCapacity()){
                //use a new arraylist to sort
                ArrayList<Integer> arrange = new ArrayList<>();
                arrange.addAll(course.getCredits());
                Collections.sort(arrange);
                Collections.reverse(arrange);
                //drop students that have the same credits
                for (int i = course.getCredits().size() - 1; i >= 0; i--){
                    if (course.getCredits().get(i).equals(arrange.get(arrange.size() - 1))){
                        course.getEnrollStudent().get(i).getEnrollCourses().remove(course);
                        course.getEnrollStudent().remove(i);
                        course.getCredits().remove(i);
                    }
                }
                //update arrange
                for (int i = arrange.size() - 2; i >= 0; i--){
                    if (arrange.get(i).equals(arrange.get(i + 1))){
                        arrange.remove(i + 1);
                    }
                    else {
                        arrange.remove(i + 1);
                        break;
                    }
                }
            }
            //update successful one
            course.getSuccessStudents().addAll(course.getEnrollStudent());
            for (Student student : course.getSuccessStudents()){
                student.getSuccessCourses().add(course);
            }
        }
        ifOpen = false;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (ifOpen){
            ArrayList<String> printing = new ArrayList<>();
            for (Course course : student.getEnrollCourses()){
                printing.add(course.getCourseID() + ": " + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
            }
            return printing;
        }
        else {
            return null;
        }
    }
}