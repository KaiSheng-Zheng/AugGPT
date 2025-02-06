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
        if (!this.ifOpen) return false;
        if (credits <= 0) {
            return false;
        }
        Course c = getCourseById(courseId);
        if (c == null) {
            return false;
        }
        if (student.getEnrollCourses().contains(c)) {
            return false;
        }
        if (student.getCredits() < credits) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        c.getEnrollStudent().add(student);
        c.getCredits().add(credits);
        student.getEnrollCourses().add(c);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) return false;
        if (credits < 0) {
            return false;
        }
        Course c = getCourseById(courseId);
        if (c == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        int originalCredits = c.getCredits().get(index);
        if (credits - originalCredits > student.getCredits()) {
            return false;
        }
        c.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + originalCredits - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) return false;
        Course c = getCourseById(courseId);
        if (c == null) {
            return false;
        }
        if (!student.getEnrollCourses().contains(c)) {
            return false;
        }

        int studentIndex = c.getEnrollStudent().indexOf(student);
        if (studentIndex == -1) {
            return false;
        }
        c.getEnrollStudent().remove(studentIndex);
        int creditsDropped = c.getCredits().remove(studentIndex);
        student.getEnrollCourses().remove(c);
        student.setCredits(student.getCredits() + creditsDropped);

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) return null;
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        ArrayList<Course> enrolledCourses = student.getEnrollCourses();
        ArrayList<Student> enrolledStudents;

        for (Course c : enrolledCourses) {
            enrolledStudents = c.getEnrollStudent();
            int index = enrolledStudents.indexOf(student);
            if (index == -1 || index >= c.getCredits().size()) {
                continue;
            }
            int credits = c.getCredits().get(index);
            enrolledCoursesWithCredits.add(c.getCourseID() + ": " + credits);
        }
        return enrolledCoursesWithCredits;
    }


    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (Course c : this.courses) {
            ArrayList<Integer> creditList = c.getCredits();

            int successfulCredits = calculateSuccessfulCredits(creditList, c.getMaxCapacity());
            ArrayList<Student> enrolledStudents = c.getEnrollStudent();
            ArrayList<Student> successfulStudents = new ArrayList<>();

            for (int i = 0; i < creditList.size(); i++) {
                if (creditList.get(i) >= successfulCredits) {
                    successfulStudents.add(enrolledStudents.get(i));
                }
            }

            c.setSuccessStudents(successfulStudents);
            for (Student student : successfulStudents) {
                if (!student.getSuccessCourses().contains(c)) {
                    student.getSuccessCourses().add(c);
                }
            }
        }
    }


    private int calculateSuccessfulCredits(ArrayList<Integer> creditList, int capacity) {
        if (capacity >= creditList.size()) {
            return -1;
        }

        ArrayList<Integer> sortedCredits = new ArrayList<>(creditList);
        Collections.sort(sortedCredits, Collections.reverseOrder());

        int threshold = sortedCredits.get(capacity - 1);

        if (capacity < sortedCredits.size() && sortedCredits.get(capacity) == threshold) {
            return threshold + 1;
        } else {
            return threshold;
        }
    }

    private Course getCourseById(String courseId) {
        for (Course c : courses) {
            if (c.getCourseID().equals((courseId))) {
                return c;
            }
        }
        return null;
    }
}