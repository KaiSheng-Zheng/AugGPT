import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class CourseManager {
    private ArrayList<Course>courses;
    private ArrayList<Student>students;
    private boolean ifOpen;
    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student>getStudents(){
        return students;
    }
    public void setStudents(ArrayList<Student>students){
        this.students = students;
    }

    public ArrayList<Course>getCourses(){
        return courses;
    }
    public void setCourses(ArrayList<Course>courses){
        this.courses = courses;
    }

    public boolean getIfOpen(){
        return ifOpen;
    }
    public void setIfOpen(boolean ifOpen){
        this.ifOpen = ifOpen;
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        if(!ifOpen){
            return false;
        }
        if(credits <= 0){
            return false;
        }
        Course course =null;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if(course == null){
                return false;
        }

        Course studentcourse = null;
        for(Course c:student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                studentcourse = c;
                break;
            }
        }
        if(studentcourse != null){
                return false;
        }
        if(student.getCredits() < credits){
            return false;
        }
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits()-credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student,String courseId,int credits){
        if(!ifOpen){
            return false;
        }
        Course course = null;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if(course == null){
            return false;
        }
        Course studentcourse = null;
        for(Course s:student.getEnrollCourses()){
            if(s.getCourseID().equals(courseId)){
                studentcourse = s;
                break;
            }
        }
        if(studentcourse == null){
            return false;
        }
        int index = -1;
        for(int i = 0;i < course.getEnrollStudent().size();i++){
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        if(credits > student.getCredits()+course.getCredits().get(index)){
            return false;
        }
        int creditbefore = course.getCredits().get(index);
        course.getCredits().set(index,credits);
        student.setCredits(student.getCredits()+creditbefore-credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }
        Course course = null;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if(course == null){
            return false;
        }
        Course studentcourse = null;
        for(Course c:student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                studentcourse = c;
                break;
            }
        }
        if(studentcourse == null){
            return false;
        }
        int index = -1;
        for(int i = 0;i < course.getEnrollStudent().size();i++){
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        student.setCredits(student.getCredits()+course.getCredits().get(index));
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        for(int i = 0;i < student.getEnrollCourses().size();i++){
            if(course.getCourseID().equals(student.getEnrollCourses().get(i).getCourseID())){
                index = i;
                break;
            }
        }
        student.getEnrollCourses().remove(index);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> arr = new ArrayList<>();
        int index = -1;
        int credits = 0;
        Course course = null;
        for (Course c : courses) {
            boolean x = false;
            for (int i = 0; i < student.getEnrollCourses().size() ; i++) {
                if (c.getCourseID().equals(student.getEnrollCourses().get(i).getCourseID())) {
                    x = true;
                }
            }
            if (x) {
                for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                    if (c.getCourseID().equals(student.getEnrollCourses().get(i).getCourseID())) {
                        course = c;
                        break;
                    }
                }
                for (Course z : student.getEnrollCourses()) {
                    for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                        if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                            index = i;
                            break;
                        }
                    }
                    credits = z.getCredits().get(index);
                }
                if (credits != 0) {
                    arr.add(course.getCourseID() + ": " + credits);
                }
                if (course == null) {
                    return null;
                }
            }
        }
        return arr;
    }

        public void finalizeEnrollments () {
            ifOpen = false;
            Integer creditsinside;
            Student studentinside;
            int j = 0, k = 0;
            ArrayList<Course> arr = new ArrayList<>();
            for (Course c : courses) {
                for (int l = 0; l < c.getCredits().size(); l++) {
                    for (int i = 0; i < c.getCredits().size() - 1; i++) {
                        if (c.getCredits().get(i) < c.getCredits().get(i + 1)) {
                            creditsinside = c.getCredits().get(i);
                            c.getCredits().set(i, c.getCredits().get(i + 1));
                            c.getCredits().set(i + 1, creditsinside);
                            studentinside = c.getEnrollStudent().get(i);
                            c.getEnrollStudent().set(i, c.getEnrollStudent().get(i + 1));
                            c.getEnrollStudent().set(i + 1, studentinside);
                        }
                    }
                }
                j = c.getMaxCapacity();
                if (c.getCredits().size() <= j) {
                    c.setSuccessStudents(c.getEnrollStudent());
                    for (Student s : students) {
                        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                            if (s.getStudentID() == c.getSuccessStudents().get(i).getStudentID()) {
                                arr.add(c);
                            }
                        }
                        s.setSuccessCourses(arr);
                    }
                } else if (c.getCredits().get(j - 1) == c.getCredits().get(j)) {
                    k = c.getCredits().get(j - 1) + 1;
                } else k = c.getCredits().get(j - 1);
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if (c.getCredits().get(i) < k) {
                        c.getEnrollStudent().remove(i);
                        i--;
                    }
                }
                c.setSuccessStudents(c.getEnrollStudent());
                for (Student s : students) {
                    for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                        if (s.getStudentID() == c.getSuccessStudents().get(i).getStudentID()) {
                            arr.add(c);
                        }
                    }
                    s.setSuccessCourses(arr);
                }
            }
        }
    }