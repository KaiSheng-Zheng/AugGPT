import java.util.ArrayList;
import java.util.Collections;
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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        Course course = null;
        for (Course c1 : courses) {
            if (c1.getCourseID().equals(courseId)) {
                course = c1;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        for (Course c2 : student.getEnrollCourses()) {
            if (!c2.getCourseID().equals(courseId)) {
                return false;
            }
        }

        int currentCredits = student.getCredits();
        currentCredits -= credits;
        student.setCredits(currentCredits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c1 : courses) {
            if (c1.getCourseID().equals(courseId)) {
                course = c1;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        for (Course c2 : student.getEnrollCourses()) {
            if (!c2.getCourseID().equals(courseId)) {
                return false;
            }
        }


        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        if (student.getCredits() + originalCredits < credits) {
            return false;
        }
        int currentCredits = student.getCredits();
        currentCredits = currentCredits + originalCredits - credits;
        student.setCredits(currentCredits);
        course.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c1 : courses) {
            if (c1.getCourseID().equals(courseId)) {
                course = c1;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        for (Course c2 : student.getEnrollCourses()) {
            if (!c2.getCourseID().equals(courseId)) {
                return false;
            }
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(student);
        student.getEnrollCourses().remove(course);
        int currentCredits = student.getCredits();
        currentCredits += originalCredits;
        student.setCredits(currentCredits);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();
        for (Course c : student.getEnrollCourses()) {
            int index = -1;
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }
            int credits = c.getCredits().get(index);
            list.add(c.getCourseID() + ": " + String.valueOf(credits));
        }
        return list;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course c : courses) {
            ArrayList<Integer> list = new ArrayList<>(c.getCredits());
            Collections.sort(list);
            Collections.reverse(list);
            ArrayList<Integer> modifiedList = new ArrayList<>();
            if (list.size() >= c.getMaxCapacity() + 1 && list.get(c.getMaxCapacity() - 1).equals(list.get(c.getMaxCapacity()))) {
                for (int i = 0; i < c.getMaxCapacity(); i++) {
                    if (list.get(i) > list.get(c.getMaxCapacity())) {
                        modifiedList.add(list.get(i));
                    }
                }
            } else {
                for (int j = 0; j < c.getMaxCapacity() && j < list.size(); j++) {
                    modifiedList.add(list.get(j));
                }
            }
            int number = c.getMaxCapacity();
            if (modifiedList.size() >= number) {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if (c.getCredits().get(i) >= modifiedList.get(number - 1)) {
                        c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                        c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                    }
                }
            } else {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if (c.getCredits().get(i) >= modifiedList.get(modifiedList.size() - 1))
                    c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                }
            }
        }
    }
}

