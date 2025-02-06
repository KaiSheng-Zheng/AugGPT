import java.util.*;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen = true;

    public CourseManager() {
        setIfOpen(true);
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
// getter for students

    public ArrayList<Course> getCourses() {
        return courses;
    }

    // getter for courses
    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    // setter for ifOpen
    public boolean getIfOpen() {
        return ifOpen;
    }

    // getter for ifOpen
    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    // Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.
//
//

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        int n = -1, c = student.getCredits();
        if (student.getCredits() >= credits && credits > 0) {
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {
                    n = i;
                    break;
                }
            }
        } else return false;
        if (n == -1) {
            return false;
        }
        if (student.getEnrollCourses().contains(courses.get(n))) {
            return false;
        }
        courses.get(n).getEnrollStudent().add(student);
        courses.get(n).getCredits().add(credits);
        student.getEnrollCourses().add(courses.get(n));
        student.setCredits(c - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        int n = -1, m = 0, c = student.getCredits();

        for (int i = 0; i < courses.size(); i++) {
            if (courseId.equals(courses.get(i).getCourseID())) {
                n = i;
                break;
            }
        }
        if (n == -1) {
            return false;
        }
        if (!student.getEnrollCourses().contains(courses.get(n))) {
            return false;
        }
        for (int i = 0; i < courses.get(n).getEnrollStudent().size(); i++) {
            if (courses.get(n).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                m = i;
                break;
            }
        }
        int xx = courses.get(n).getCredits().get(m);
        if (c - credits + xx < 0) {
            return false;
        }
        courses.get(n).getCredits().set(m, credits);
        student.setCredits(c - credits + xx);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        int n = -1, m = 0, c = student.getCredits();

        for (int i = 0; i < courses.size(); i++) {
            if (courseId.equals(courses.get(i).getCourseID())) {
                n = i;
                break;
            }
        }
        if (n == -1) {
            return false;
        }
        if (!student.getEnrollCourses().contains(courses.get(n))) {
            return false;
        }
        for (int i = 0; i < courses.get(n).getEnrollStudent().size(); i++) {
            if (courses.get(n).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                m = i;
                break;
            }
        }
        c = c + courses.get(n).getCredits().get(m);
        courses.get(n).getEnrollStudent().remove(m);
        courses.get(n).getCredits().remove(m);
        student.getEnrollCourses().remove(courses.get(n));
        student.setCredits(c);
        return true;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        int temp = 0;
        Student st;
        boolean flag = false; //标识变量，表示是否进行交换
        for (int k = 0; k < courses.size(); k++) {
            for (int i = 0; i < courses.get(k).getCredits().size() - 1; i++) {
                for (int j = 0; j < courses.get(k).getCredits().size() - 1 - i; j++) {
                    if (courses.get(k).getCredits().get(j) > courses.get(k).getCredits().get(j + 1)) {
                        flag = true;
                        st = courses.get(k).getEnrollStudent().get(j);
                        temp = courses.get(k).getCredits().get(j);
                        courses.get(k).getCredits().set(j, courses.get(k).getCredits().get(j + 1));
                        courses.get(k).getCredits().set(j + 1, temp);
                        courses.get(k).getEnrollStudent().set(j, courses.get(k).getEnrollStudent().get(j + 1));
                        courses.get(k).getEnrollStudent().set(j + 1, st);
                    }
                }
                if (!flag) {//在一趟排序中，一次交换都没发生过
                    break;
                } else {
                    flag = false;//重置flag，进行下次判断
                }
            }
        }
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getMaxCapacity(); j++) {
                courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
            }
            for (int j = courses.get(i).getMaxCapacity() - 1; j >= 0; j--) {
                if (courses.get(i).getCredits().get(j) == courses.get(i).getCredits().get(j + 1)) {
                    courses.get(i).getSuccessStudents().remove(j);

                } else {
                    break;
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> a = new ArrayList<>();
        return a;
    }
}

