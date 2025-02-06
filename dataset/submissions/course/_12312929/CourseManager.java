import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
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
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                if (course.getEnrollStudent().contains(student) || credits <= 0 || !(student.getCredits() >=credits)) {
                    return false;
                }
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
                student.getEnrollCourses().add(course);
                student.setCredits(student.getCredits() - credits);
                return true;
            }
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                int index = course.getEnrollStudent().indexOf(student);
                if (index == -1) {
                    return false;
                }
                if (credits <= 0 || !(student.getCredits()+course.getCredits().get(index)>=credits)) {
                    return false;
                }
                student.setCredits(student.getCredits() - (credits - course.getCredits().get(index)));
                course.getCredits().set(index, credits);
                return true;
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                int index = course.getEnrollStudent().indexOf(student);
                if (index == -1) {
                    return false;
                }
                int refundedCredits = course.getCredits().get(index);
                student.setCredits(student.getCredits() + refundedCredits);
                course.getEnrollStudent().remove(index);
                course.getCredits().remove(index);
                student.getEnrollCourses().remove(course);
                return true;
            }
        }
        return false;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            List<Student> successStudents = new ArrayList<>();
            int Capacity = course.getMaxCapacity();
            ArrayList arry = new ArrayList();
            for (int i = 0;i < course.getCredits().size();i++){
                arry.add(course.getCredits().get(i));
            }
            Collections.sort(arry);
            int sum = 0;
            for (int i = course.getCredits().size()-1; i >= 0; i--) {
                for (int x = 0; x < course.getCredits().size(); x++) {
                    for (int y = 0; y < course.getCredits().size(); y++)
                        if (course.getCredits().get(x).equals(course.getCredits().get(y))) {
                            sum++;
                        }
                }
                if (sum == 0 || course.getCredits().size()<=course.getMaxCapacity()) {
                    successStudents.add(course.getEnrollStudent().get(i));
                }else {
                    if (Capacity <= 0)
                        break;
                    int k = course.getCredits().size()-course.getMaxCapacity();
                if (i>=course.getCredits().size()-course.getMaxCapacity()&&(arry.get(k)!=arry.get(k-1)||arry.get(i)!=arry.get(k))){
                    for (int n = 0;n<course.getCredits().size();n++){
                        if (course.getCredits().get(n)==arry.get(i)){
                            successStudents.add(course.getEnrollStudent().get(n));
                        }
                    }
                    Capacity--;
                }
                }
            }
            for (int m = 0;m < successStudents.size();m++){
            for (int n = successStudents.size()-1; n > m;n--){
                   if (successStudents.get(m).equals(successStudents.get(n))){
                       successStudents.remove(n);
                    }
                }
            }
            course.setSuccessStudents((ArrayList<Student>) successStudents);
        }
        for (Student student : students) {
            List<Course> successCourses = new ArrayList<>();
            for (Course course : student.getEnrollCourses()) {
                if (course.getSuccessStudents().contains(student)) {
                    successCourses.add(course);
                }
            }
            student.setSuccessCourses((ArrayList<Course>) successCourses);
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : courses) {
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (course.getEnrollStudent().get(i).equals(student)) {
                    String courseInfo = course.getCourseID() + ": " + course.getCredits().get(i);
                    enrolledCoursesWithCredits.add(courseInfo);
                }
            }
        }
        return enrolledCoursesWithCredits;
    }
}
