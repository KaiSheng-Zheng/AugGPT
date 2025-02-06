import java.util.ArrayList;

public class CourseManager {
    private Course c;
    private ArrayList<Course> courses ;
    private ArrayList<Student> students ;
    //missing getter
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }

    public Course getC() {
        return c;
    }

    public void setC(Course c) {
        this.c = c;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void findCourse(String a) {
        for (Course c : getCourses()) {
            if (c.getCourseID().equals(a)) {
                setC(c);
                return;
            }
        }
        setC(null);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        findCourse(courseId);
        if (student == null) {
            return false;
        }
        if (getC() == null)
            return false;
        if (!getIfOpen())
            return false;
        if (credits <= 0)
            return false;
        if (getC().getEnrollStudent().contains(student))
            return false;
        if (student.getCredits() < credits) {
            return false;
        } else {
            getC().getEnrollStudent().add(student);
            getC().getCredits().add(credits);
            student.getEnrollCourses().add(getC());
            student.setCredits(student.getCredits() - credits);
            return true;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        findCourse(courseId);
        int index = getC().getEnrollStudent().indexOf(student);
        if (student == null) {
            return false;
        }
        if (getC() == null)
            return false;
        if (!getIfOpen())
            return false;
        if (credits <= 0)
            return false;
        if (!getC().getEnrollStudent().contains(student))
            return false;
        int origin = getC().getCredits().get(index) + student.getCredits();
        if (origin < credits)
            return false;
        else {
            getC().getCredits().set(index, credits);
            student.setCredits(origin - credits);
            return true;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        findCourse(courseId);
        if (student == null) {
            return false;
        }
        if (getC() == null)
            return false;
        if (!getIfOpen())
            return false;
        if (!getC().getEnrollStudent().contains(student))
            return false;
        else {
            int index = getC().getEnrollStudent().indexOf(student);
            student.setCredits(student.getCredits() + getC().getCredits().get(index));
            getC().getCredits().remove(index);
            getC().getEnrollStudent().remove(student);
            student.getEnrollCourses().remove(getC());
            return true;
        }
    }

    public void finalizeEnrollments() {
        for (Course c : courses) {
            setIfOpen(false);
            ArrayList<Student> A = c.getEnrollStudent();
            ArrayList<Integer> B = c.getCredits();
            if (c.getMaxCapacity() < A.size()) {
                for (int i = 0; i < A.size(); i++) {
                    int count = 0;
                    for (Integer integer : B) {
                        if (B.get(i) <= integer) {
                            count++;
                        }
                    }
                    if (count <= getC().getMaxCapacity()) {
                        A.get(i).getSuccessCourses().add(c);
                        c.getSuccessStudents().add(A.get(i));
                    }
                }
            } else {
                for (Student student : A) {
                    student.getSuccessCourses().add(c);
                }
                c.setSuccessStudents(A);
            }
            setIfOpen(false);
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!getIfOpen()) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            int index = student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student);
            list.add(String.format("%s: %d", student.getEnrollCourses().get(i).getCourseID(), student.getEnrollCourses().get(i).getCredits().get(index)));
        }
        return list;
    }
}