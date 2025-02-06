import java.util.ArrayList;
import java.util.Collections;


public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }


    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }


    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if (credits <= 0)
            return false;
        if(credits > student.getCredits()){
            return false;
        }
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if ((student.getEnrollCourses().get(i).getCourseID()).equals(courseId)) {
                return false;
            }
        }
        if (student.getCredits() - credits < 0) {
            return false;
        }
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if(credits<=0){
            return false;
        }
        ArrayList<Course> List = new ArrayList<>();
        List = student.getEnrollCourses();
        Course course1 = null;
        Course course2 = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course1 = c;
            }
        }
        if (course1 == null) {
            return false;
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                course2 = student.getEnrollCourses().get(i);
                break;
            }
        }
        if (course2 == null) {
            return false;
        } else {
            int index = -1;

            if (course2.getEnrollStudent().isEmpty()) {
                return false;
            }
            for (int i = 0; i < course1.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(course1.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                return false;
            }
            int originalCredits = course1.getCredits().get(index);
            if (student.getCredits() + originalCredits - credits < 0) {
                return false;
            }
            student.setEnrollCourses(List);
            student.setCredits(student.getCredits() +originalCredits - credits);
            course1.getCredits().set(index, credits);
            return true;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
            }
        }
        if (course == null) {
            return false;
        }
        int index = -1;
        int index1 = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i) == student) {
                index = i;
            }
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                index1 = i;
            }
        }
        if ((index == -1) || (index1 == -1)) {
            return false;
        }
        student.setCredits(course.getCredits().get(index) + student.getCredits());
        student.getEnrollCourses().remove(index1);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> List = new ArrayList<>();

        for (Course c : this.courses) {
            Course course = null;
            int index = 0;
            course = c;
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (c.getEnrollStudent().get(i).equals(student)) {
                    index = i;
                List.add(toString(c.getCourseID(), course.getCredits().get(index)));
                break;}
            }
        }
        return List;
    }

    private String toString(String course, Integer integer) {
        return course + ": " + integer;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course c : this.courses) {
            ArrayList<Integer> List1 = new ArrayList<>(c.getCredits());
            List1.sort(Collections.reverseOrder());
            int k = 0;
            if(c.getMaxCapacity()>= List1.size()){
                k = 0;
            }else {
                if ((List1.get(c.getMaxCapacity() - 1).equals(List1.get(c.getMaxCapacity())))) {
                    k = List1.get(c.getMaxCapacity() - 1) + 1;
                } else {
                    k = List1.get(c.getMaxCapacity() - 1);
                }
            }
                ArrayList<Student> total = new ArrayList<>();
                for (int j = 0; j < c.getEnrollStudent().size(); j++) {
                    if (c.getCredits().get(j) >= k) {
                        Student student = c.getEnrollStudent().get(j);
                        total.add(student);
                    }
                }
                c.setSuccessStudents(total);
        }
        for(Student d :this.students){
            ArrayList<Course> List = new ArrayList<>();
            for (Course e:this.courses){
                for (int i = 0; i < e.getSuccessStudents().size(); i++) {
                        if(e.getSuccessStudents().get(i).equals(d)){
                             List.add(e);
                        }
                }
            }
            d.setSuccessCourses(List);
        }
    }

    public boolean getIfOpen() {
        return ifOpen;
    }
}