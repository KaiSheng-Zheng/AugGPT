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

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
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
        if (credits <= 0) {
            return false;
        }
        if (!ifOpen) {
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
        if (credits > student.getCredits()) {
            return false;
        }
        int renew = student.getCredits() - credits;
        student.setCredits(renew);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        Course coursestudent = null;
        for (Course d : student.getEnrollCourses()) {
            if (d.getCourseID().equals(courseId)) {
                coursestudent = d;
                break;
            }
        }
        if (coursestudent == null) {
            return false;
        }
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
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
        Course coursestudent = null;
        for (Course d : student.getEnrollCourses()) {
            if (d.getCourseID().equals(courseId)) {
                coursestudent = d;
                break;
            }
        }
        if (coursestudent == null) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        if (credits - originalCredits > student.getCredits()) {
            return false;
        }
        int newcredit = student.getCredits() + originalCredits - credits;
        course.getCredits().set(index, credits);
        student.setCredits(newcredit);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
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
        Course coursestudent = null;
        for (Course d : student.getEnrollCourses()) {
            if (d.getCourseID().equals(courseId)) {
                coursestudent = d;
                break;
            }
        }
        if (coursestudent == null) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        int index2 = 0;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                index2 = i;
                break;
            }
        }
        student.getEnrollCourses().remove(index2);
        student.setCredits(student.getCredits() + originalCredits);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen) {
            return null;
        } else {
            ArrayList<String> chuangjian = new ArrayList<>();
            for (Course c : student.getEnrollCourses()) {
                int m = 0;
                for (Course d : courses){
                    if (d.getCourseID().equals(c.getCourseID())){
                        for (int j = 0; j < d.getEnrollStudent().size(); j++){
                            if (student.equals(d.getEnrollStudent().get(j))){
                                m = d.getCredits().get(j);
                                chuangjian.add(c.getCourseID() + ": " + m);
                            }
                        }
                    }
                }
            }
            return chuangjian;
        }
    }
    public void finalizeEnrollments() {
        setIfOpen(false);
        ArrayList<Student> student = new ArrayList<>();
        ArrayList<Integer> credits = new ArrayList<>();
        ArrayList<Integer> linshicredits = new ArrayList<>();
        for (Course c : courses) {
            if (c.getEnrollStudent().isEmpty()) {
                continue;
            }
            int max = c.getMaxCapacity();
            int panduan = 0;
            int panduan1 = 0;
            int ifover = 0;
            student = c.getEnrollStudent();
            credits = c.getCredits();
            linshicredits.addAll(credits);
            for (int i = 0; i < linshicredits.size() - 1; i++) {
                int m = i;
                for (int j = i + 1; j < linshicredits.size(); j++) {
                    if (linshicredits.get(j) > linshicredits.get(m)) {
                        m = j;
                        int temp = linshicredits.get(i);
                        linshicredits.set(i, linshicredits.get(m));
                        linshicredits.set(m, temp);
                    }
                }
            }
            if (linshicredits.size() > max) {
                for (int i = 0; i < max; i++) {
                    panduan = linshicredits.get(i);
                }
                for (int k = 0; k < credits.size(); k++) {
                    if (credits.get(k) >= panduan) {
                        ifover++;
                    }
                }
                for (int k = 0; k < credits.size(); k++) {
                    if (ifover == max) {
                        if (credits.get(k) >= panduan) {
                            c.getSuccessStudents().add(student.get(k));
                            c.getEnrollStudent().get(k).getSuccessCourses().add(c);
                        }
                    } else if (ifover > max) {
                        if (credits.get(k) >= panduan + 1) {
                            c.getSuccessStudents().add(student.get(k));
                            c.getEnrollStudent().get(k).getSuccessCourses().add(c);
                        }
                    } else if (ifover < max) {
                        c.getSuccessStudents().add(student.get(k));
                        c.getEnrollStudent().get(k).getSuccessCourses().add(c);
                    }
                }
            }
            if (linshicredits.size() <= max) {
                for (int k = 0; k < credits.size(); k++) {
                    c.getSuccessStudents().add(student.get(k));
                    c.getEnrollStudent().get(k).getSuccessCourses().add(c);
                }
            }
        }
    }
}
