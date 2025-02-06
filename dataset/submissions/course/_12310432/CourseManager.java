import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifopen;

    public CourseManager() {
        ifopen = true;
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifopen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifopen;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public void setSetifopen(boolean setifopen) {
        this.ifopen = setifopen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifopen || credits <= 0) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        Student student1 = null;
        for (Student s : students) {
            if (s.getStudentID().equals(student.getStudentID())) {
                student1 = s;
                break;
            }
        }
        if (student1 == null) return false;
        if (student.getCredits() < credits) return false;
        student1.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student1);
        course.getCredits().add(credits);
        student1.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifopen) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        int ab = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                ab = i;
                break;
            }
        }
        if (ab == -1) return false;
        int oric = course.getCredits().get(ab);
        int tt = student.getCredits();
        if (tt + oric < credits) return false;
        student.setCredits(student.getCredits() - (credits - oric));
        course.getCredits().set(ab, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifopen) return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        int ab = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                ab = i;
                break;
            }
        }
        if (ab == -1) return false;
        student.setCredits(student.getCredits() + course.getCredits().get(ab));
        course.getEnrollStudent().remove(ab);
        course.getCredits().remove(ab);
        student.getEnrollCourses().remove(course);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifopen) return null;
        ArrayList<String> fc;
        fc = new ArrayList<String>();
        int ab = -1;
        int tip = -1;
        for (int j = 0; j < courses.size(); j++) {
            ab = -1;
            for (int i = 0; i < courses.get(j).getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(courses.get(j).getEnrollStudent().get(i).getStudentID())) {
                    ab = i;
                    tip = 1;
                    break;
                }
            }
            if (ab == -1) continue;
            String ss = String.valueOf(courses.get(j).getCredits().get(ab));
            fc.add(courses.get(j).getCourseID()+": "+ss);
        }
       // if (tip == -1) return null;
        return fc;
    }

    public void finalizeEnrollments() {
        this.ifopen = false;
        for (Course c : courses) {
            if (c.getMaxCapacity() >= c.getEnrollStudent().size()) {
                c.setSuccessStudents(c.getEnrollStudent());
            } else {
                ArrayList<Integer> creditsCopy = new ArrayList<>(c.getCredits());
                ArrayList<Student> studentsNew = new ArrayList<Student>();
                creditsCopy.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                int t = creditsCopy.get(c.getMaxCapacity());
                for (int i = 0; i < c.getCredits().size(); i++) {
                    if (c.getCredits().get(i) > t) {
                        studentsNew.add(c.getEnrollStudent().get(i));
                    }
                }
                c.setSuccessStudents(studentsNew);
            }
            for (int i = 0; i < c.getSuccessStudents().size(); i++) {
                c.getSuccessStudents().get(i).getSuccessCourses().add(c);
            }
        }
    }
}
