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

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if (credits <= 0)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        Course course1 = null;
        for (Course c1 : student.getEnrollCourses()) {
            if (c1.getCourseID().equals(courseId)) {
                course1 = c1;
                break;
            }
        }
        if (course1 != null)
            return false;
        if (student.getCredits() < credits)
            return false;
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return false;
        int originalCredits = course.getCredits().get(index);
        if ((student.getCredits() + originalCredits) < credits)
            return false;
        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + originalCredits - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return false;
        student.setCredits(student.getCredits() + course.getCredits().get(index));
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(course);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen)
            return null;
        ArrayList<String> s = new ArrayList<>();
        for (Course c : student.getEnrollCourses()) {
            int index = 0;
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    index = i;
                    break;
                }
            }
            s.add(c.getCourseID() + ": " + c.getCredits().get(index));
        }
        return s;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course c : courses) {
            int n = c.getEnrollStudent().size();
            while (n-- > 0) {
                for (int i = 0; i < c.getEnrollStudent().size() - 1; i++) {
                    if (c.getCredits().get(i) < c.getCredits().get(i + 1)) {
                        int temp = c.getCredits().get(i + 1);
                        c.getCredits().set(i + 1, c.getCredits().get(i));
                        c.getCredits().set(i, temp);
                        Student temp1 = c.getEnrollStudent().get(i + 1);
                        c.getEnrollStudent().set(i + 1, c.getEnrollStudent().get(i));
                        c.getEnrollStudent().set(i, temp1);
                    }
                }
            }
            if (c.getEnrollStudent().size() <= c.getMaxCapacity()) {
                c.setSuccessStudents(c.getEnrollStudent());
            } else {
                if (c.getCredits().get(c.getMaxCapacity() - 1).equals(c.getCredits().get(c.getMaxCapacity()))) {
                    int x = c.getCredits().get(c.getMaxCapacity() - 1) + 1;
                    for (int i = 0; i < c.getCredits().size(); i++) {
                        if (c.getCredits().get(i) >= x) {
                            c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                        }
                    }
                } else {
                    for (int i = 0; i < c.getMaxCapacity(); i++) {
                        c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    }
                }
            }
        }
        for (Student s : students) {
            for (Course c : courses) {
                if (c.getSuccessStudents().contains(s)) {
                    s.getSuccessCourses().add(c);
                }
            }
        }
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
}
