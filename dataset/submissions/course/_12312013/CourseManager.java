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

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
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

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        Course course = null;
        for (Course c : courses
        ) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        Course enrolCourse = null;
        for (Course c : student.getEnrollCourses()
        ) {
            if (c.equals(course)) {
                enrolCourse = course;
                break;
            }
        }

        if (enrolCourse != null) {
            return false;
        }

        if (student.getCredits() < credits) {
            return false;
        }
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,
                                                  int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses
        ) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        Course enrolCourse = null;
        for (Course c : student.getEnrollCourses()
        ) {
            if (c.equals(course)) {
                enrolCourse = course;
                break;
            }
        }

        if (enrolCourse == null) {
            return false;
        }

        int originalCredits = course.getCredits().get(index);

        if (credits - originalCredits > student.getCredits()) {
            return false;
        }
        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + originalCredits - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses
        ) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        
        Course enrolCourse = null;
        for (Course c : student.getEnrollCourses()
        ) {
            if (c.equals(course)) {
                enrolCourse = course;
                break;
            }
        }

        if (enrolCourse == null) {
            return false;
        }

        student.getEnrollCourses().remove(courseId);
        student.setCredits(course.getCredits().get(index) + student.getCredits());
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> output = new ArrayList<>();
        for (Course c : courses
        ) {
            String courseId = c.getCourseID();

            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                    int credit = c.getCredits().get(i);
                    String transform = String.format("%s: %d", courseId, credit);
                    output.add(transform);
                    break;
                }
            }
        }
        return output;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course c : courses
        ) {
            for (int i = 0; i < c.getCredits().size() - 1; i++) {
                for (int j = 0; j < c.getCredits().size() - i - 1; j++) {
                    if (c.getCredits().get(j) < c.getCredits().get(j + 1)) {
                        int temp = c.getCredits().get(j);
                        Student Temp = c.getEnrollStudent().get(j);
                        c.getCredits().set(j, c.getCredits().get(j + 1));
                        c.getEnrollStudent().set(j, c.getEnrollStudent().get(j + 1));
                        c.getCredits().set(j + 1, temp);
                        c.getEnrollStudent().set(j + 1, Temp);
                    }
                }
            }



            if (c.getCredits().size() <= c.getMaxCapacity()) {
                c.setSuccessStudents(c.getEnrollStudent());
                for (Student s : c.getSuccessStudents()
                ) {
                    s.getSuccessCourses().add(c);
                }
            }

            if (c.getCredits().size() > c.getMaxCapacity()) {

                if (!c.getCredits().get(c.getMaxCapacity() - 1).equals(c.getCredits().get(c.getMaxCapacity()))) {
                    c.getEnrollStudent().subList(c.getMaxCapacity(), c.getEnrollStudent().size()).clear();
                    c.setSuccessStudents(c.getEnrollStudent());
                    for (Student s : c.getSuccessStudents()
                    ) {
                        s.getSuccessCourses().add(c);
                    }
                }

                if (c.getCredits().get(c.getMaxCapacity() - 1).equals(c.getCredits().get(c.getMaxCapacity()))) {
                    for (int i = c.getMaxCapacity(); i < c.getCredits().size(); i++) {
                        c.getEnrollStudent().remove(i);
                    }
                    int temp = c.getCredits().get(c.getMaxCapacity() - 1);
                    for (int i = c.getMaxCapacity() - 1; i >= 0; i--) {
                        if (c.getCredits().get(i) == temp) {
                            c.getEnrollStudent().remove(i);
                        }
                    }
                    c.setSuccessStudents(c.getEnrollStudent());
                    for (Student s : c.getSuccessStudents()
                    ) {
                        s.getSuccessCourses().add(c);
                    }
                }
            }
        }
    }
}
