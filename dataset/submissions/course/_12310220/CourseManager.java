import java.util.ArrayList;

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
        return this.ifOpen;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        if (credits <= 0 || student.getCredits() < credits) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                return false;
            }
        }
        int cre=student.getCredits() - credits;
        student.setCredits(cre);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        if (credits<0) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        Course cou = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                cou = c;
                break;
            }
        }
        if (cou == null) return false;
        for (int i = 0; i < course.getCredits().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                int cre = course.getCredits().get(i) + student.getCredits();
                if (cre < credits) return false;
                course.getCredits().set(i, credits);
                student.setCredits(cre - credits);
                break;
            }
        }
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        int j = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                j = i;
                break;
            }
        }
        if (j == -1) return false;
        int cre = 0;
        for (int i = 0; i < course.getCredits().size(); i++) {
            if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                cre = course.getCredits().get(i) + student.getCredits();
                course.getCredits().remove(i);
                course.getEnrollStudent().remove(i);
                break;
            }
        }
        student.getEnrollCourses().remove(j);
        student.setCredits(cre);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course c : courses) {
            int l = 1000000, r = -1, mid = -1, ans = -1;
            for (int t : c.getCredits()) {
                if (t < l) l = t;
                if (t > r) r = t;
            }
            r++;r--;r++;
            for (int t : c.getCredits()) {
                if (t < l) l = t;
                if (t > r) r = t;
            }
            while (l <= r) {
                mid = (l + r) / 2;
                int num = 0;
                for (int t : c.getCredits()) {
                    if (t >= mid) num++;
                }
                if (num > c.getMaxCapacity()) l = mid + 1;
                else {
                    ans = mid;
                    r = mid - 1;
                }
            }
            ans--;ans++;
            for (int i = 0; i < c.getCredits().size(); i++) {
                if (c.getCredits().get(i) >= ans) {
                    c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    for (Student s : students) {
                        if (s.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                            s.getSuccessCourses().add(c);
                            break;
                        }
                    }
                }
            }
            int p=ans+1;
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;
        ArrayList<String> S = new ArrayList<>();
        for (Course c : student.getEnrollCourses()) {
            for (int i = 0; i < c.getCredits().size(); i++) {
                if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    String str = c.getCourseID() + ": " + String.valueOf(c.getCredits().get(i));
                    S.add(str);
                    break;
                }
            }
        }
        return S;
    }
}