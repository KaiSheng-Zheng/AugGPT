import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private final ArrayList<Course> courses;
    private final ArrayList<Student> students;
    private boolean ifOpen;


    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return this.ifOpen;
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
        Course curCourse = null;
        for (Course cours : courses) {
            if (cours.getCourseID().equals(courseId)) {
                curCourse = cours;
            }
        }
        if (curCourse == null) {
            return false;
        }

        for (int i = 0; i < curCourse.getEnrollStudent().size(); i++) {
            if (student == curCourse.getEnrollStudent().get(i)) {
                return false;
            }
        }

        if (!(ifOpen && (credits > 0 && credits <= student.getCredits()))) {
            return false;
        }
        student.getEnrollCourses().add(curCourse);
        student.setCredits(student.getCredits() - credits);
        curCourse.getEnrollStudent().add(student);
        curCourse.getCredits().add(credits);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course curCourse = null;
        for (Course cours : courses) {
            if (cours.getCourseID().equals(courseId)) {
                curCourse = cours;
            }
        }
        if (curCourse == null) {
            return false;
        }

        for (Student tmpStudent : curCourse.getEnrollStudent()) {
            if (student == tmpStudent) {
                for (int i = curCourse.getCredits().size() - 1; i >= 0 ; i--) {
                    if (student == curCourse.getEnrollStudent().get(i)) {
                        int curCredits = curCourse.getCredits().get(i);
                        if (!(ifOpen && (credits > 0 && credits <= student.getCredits() + curCredits))) {
                            return false;
                        }
                        student.setCredits(student.getCredits() + curCredits - credits);
                        curCourse.getCredits().set(i, credits);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {

        Course curCourse = null;
        for (Course cours : courses) {
            if (cours.getCourseID().equals(courseId)) {
                curCourse = cours;
            }
        }
        if (curCourse == null) {
            return false;
        }
        for (Student tmpStudent : curCourse.getEnrollStudent()) {
            if (student == tmpStudent) {
                if (!ifOpen) {
                    return false;
                }
                break;
            }
        }

        for (int i = curCourse.getCredits().size() - 1; i >= 0; i--) {
            if (student == curCourse.getEnrollStudent().get(i)) {
                student.setCredits(student.getCredits() + curCourse.getCredits().get(i));
                //not a bug, just a different implementation of remove
                curCourse.getCredits().set(i, 0);
                curCourse.getEnrollStudent().set(i, null);
                student.getEnrollCourses().remove(curCourse);
                return true;
            }
        }

        return false;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course curCourse : this.courses) {
            int maxCapacity = curCourse.getMaxCapacity();
            if (curCourse.getCredits().size() < maxCapacity) {
                for (int i = 0; i < curCourse.getCredits().size(); i++) {
                    if (curCourse.getCredits().get(i) != 0) {
                        Student student = curCourse.getEnrollStudent().get(i);
                        curCourse.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(curCourse);
                    }
                }
            } else {
                ArrayList<Integer> copyCredits = new ArrayList<>(curCourse.getCredits());
                copyCredits.sort(Collections.reverseOrder());
                int threshold = copyCredits.get(maxCapacity - 1);
                int cnt = 0;
                for (Integer credit : curCourse.getCredits()) {
                    if (credit >= threshold) {
                        cnt += 1;
                    }
                }

                if (cnt > maxCapacity) {
                    threshold += 1;
                }
                for (int i = 0; i < curCourse.getCredits().size(); i++) {
                    if (curCourse.getCredits().get(i) >= threshold && curCourse.getCredits().get(i) != 0) {
                        Student student = curCourse.getEnrollStudent().get(i);
                        curCourse.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(curCourse);
                    }
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> res = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            String courseId = course.getCourseID();

            int courseIdx = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {
                    courseIdx = i;
                    break;
                }
            }
            Course curCourse = courses.get(courseIdx);
            for (int j = 0; j < curCourse.getCredits().size(); j++) {
                if (student == curCourse.getEnrollStudent().get(j)) {
                    res.add(courseId + ": " + curCourse.getCredits().get(j));
                    break;
                }
            }
        }
        return res;
    }
}