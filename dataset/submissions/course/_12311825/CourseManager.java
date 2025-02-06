import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
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
        boolean exist = false;
        boolean enroll = false;
        int a = -1;
        for (int i = 0 ; i < courses.size() ; i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                exist = true;
                a = i;
                break;
            }
        }
        for (int i = 0 ; i < courses.get(a).getEnrollStudent().size() ; i++) {
            if (courses.get(a).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                enroll = true;
                break;
            }
        }
        if (!ifOpen || credits <= 0 || !exist || enroll || credits > student.getCredits()) {
            return false;
        }
        else {
            student.setCredits(student.getCredits() - credits);
            courses.get(a).getEnrollStudent().add(student);
            courses.get(a).getCredits().add(credits);
            student.getEnrollCourses().add(courses.get(a));
            return true;
        }
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean exist = false;
        boolean enroll = false;
        int a = -1;
        int b = -1;
        for (int i = 0 ; i < courses.size() ; i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                exist = true;
                a = i;
                break;
            }
        }
        for (int i = 0; i < courses.get(a).getEnrollStudent().size(); i++) {
            if (courses.get(a).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                enroll = true;
                b = i;
                break;
            }
        }
        if (!ifOpen || !exist || !enroll || courses.get(a).getCredits().get(b) + student.getCredits() < credits){
            return false;
        }
        else {
            student.setCredits(courses.get(a).getCredits().get(b) + student.getCredits() - credits);
            courses.get(a).getCredits().set(b, credits);
            return true;
        }
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean exist = false;
        boolean enroll = false;
        int a = -1;
        int b = -1;
        int c = -1;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                exist = true;
                a = i;
                break;
            }
        }
        for (int i = 0; i < courses.get(a).getEnrollStudent().size(); i++) {
            if (courses.get(a).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                enroll = true;
                b = i;
                break;
            }
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                c = i;
                break;
            }
        }
        if (!ifOpen || !exist || !enroll) {
            return false;
        }
        else {
            student.setCredits(student.getCredits() + courses.get(a).getCredits().get(b));
            courses.get(a).getCredits().remove(b);
            courses.get(a).getEnrollStudent().remove(b);
            student.getEnrollCourses().remove(c);
            return true;
        }
    }
    public void finalizeEnrollments() {
        setIfOpen(false);
        int[] arr;
        int[] s;
        int[] cr;
        for (int i = 0; i < courses.size(); i++) {
            arr = new int[courses.get(i).getMaxCapacity() + 1];
            s = new int[courses.get(i).getMaxCapacity() + 1];
            cr = new int[courses.get(i).getCredits().size()];
            for (int j = 0; j < cr.length; j++) {
                cr[j] = courses.get(i).getCredits().get(j);
            }
            for (int j = 0; j < courses.get(i).getMaxCapacity() + 1; j++) {
                int m = -1;
                int n = -1;
                for (int k = 0; k < cr.length; k++) {
                    if (cr[k] > m) {
                        m = cr[k];
                        n = k;
                    }
                }
                if (n < cr.length && n != -1) {
                    cr[n] = -1;
                }
                arr[j] = m;
                s[j] = n;
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[arr.length - 1]) {
                    s[j] = -1;
                }
            }
            for (int j = 0; j < s.length; j++) {
                if (s[j] != -1) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(s[j]));
                }
            }
            for (int j = 0; j < students.size(); j++) {
                if (s[j] != -1 && students.get(j).getStudentID().equals(courses.get(i).getEnrollStudent().get(s[j]).getStudentID())) {
                    students.get(j).getSuccessCourses().add(courses.get(i));
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        else {
            int e = -1;
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).equals(student)) {
                        e = student.getEnrollCourses().get(i).getCredits().get(j);
                    }
                }
                strings.add(student.getEnrollCourses().get(i).getCourseID() + ": " + e);
            }
            return strings;
        }
    }
}