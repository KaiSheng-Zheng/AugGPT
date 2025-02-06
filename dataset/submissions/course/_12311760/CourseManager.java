import java.util.ArrayList;
import java.util.Objects;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        ifOpen = true;
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
        boolean b = false;
        for (Student j : students) {
            for (Course i : courses) {
                if (ifOpen && i.getCourseID().equals(courseId) && j == student && j.getCredits() >= credits && credits > 0) {
                    ArrayList<Student> n = i.getEnrollStudent();
                    n.add(student);
                    i.setEnrollStudent(n);

                    ArrayList<Integer> m = i.getCredits();
                    m.add(credits);
                    i.setCredits(m);

                    ArrayList<Course> k = j.getEnrollCourses();
                    k.add(i);
                    j.setEnrollCourses(k);

                    j.setCredits(j.getCredits() - credits);

                    b = true;
                    break;
                }
            }
        }
        return b;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseID, int credits) {
        boolean b = false;
        for (Student i : students) {
            for (Course j : courses) {
                if (ifOpen && j.getCourseID().equals(courseID) && i == student && credits > 0) {
                    for (Student k : j.getEnrollStudent()) {
                        int t = j.getEnrollStudent().indexOf(k);
                        if (k == student && k.getCredits() + j.getCredits().get(t) >= credits) {
                            int a = j.getCredits().get(t);
                            ArrayList<Integer> r = new ArrayList<>(j.getCredits());
                            r.set(t, credits);
                            j.setCredits(r);
                            student.setCredits(student.getCredits() + a - credits);
                            b = true;
                            break;
                        }
                    }
                }
            }
        }
        return b;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseID) {
        boolean b = false;
        for (Student i : students) {
            for (Course j: courses) {
                if (ifOpen && courseID.equals(j.getCourseID()) && i == student) {
                    for (Student k: j.getEnrollStudent()) {
                        if (k == student) {
                            int t1 = j.getEnrollStudent().indexOf(k);
                            student.setCredits(student.getCredits() + j.getCredits().get(t1));
                            ArrayList<Student> r1 = j.getEnrollStudent();
                            r1.remove(t1);
                            j.setEnrollStudent(r1);
                            ArrayList<Integer> r3 = j.getCredits();
                            r3.remove(t1);
                            j.setCredits(r3);

                            int t2 = student.getEnrollCourses().indexOf(j);
                            ArrayList<Course> r2 = student.getEnrollCourses();
                            r2.remove(t2);
                            student.setEnrollCourses(r2);
                            b = true;
                            break;
                        }
                    }
                }
            }
        }
        return b;
    }
    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course i: courses) {
            if (i.getEnrollStudent().size() <= i.getMaxCapacity()) {
                i.setSuccessStudents(i.getEnrollStudent());
                for (Student j: i.getEnrollStudent()) {
                    ArrayList<Course> r1 = j.getSuccessCourses();
                    r1.add(i);
                    j.setEnrollCourses(r1);
                }
            }
            else {
                for (int j = i.getEnrollStudent().size()-1; j > 0 ; j--) {
                    for (int k = 0; k < j; k++) {
                        if (i.getCredits().get(k) < i.getCredits().get(k+1)) {
                            Integer a = i.getCredits().get(k);
                            Student b = i.getEnrollStudent().get(k);
                            ArrayList<Integer> c = i.getCredits();
                            c.set(k, i.getCredits().get(k+1));
                            c.set(k+1, a);
                            i.setCredits(c);

                            ArrayList<Student> d = i.getEnrollStudent();
                            d.set(k, i.getEnrollStudent().get(k+1));
                            d.set(k+1, b);
                            i.setEnrollStudent(d);
                        }
                    }
                }
                if (i.getMaxCapacity() > 0) {
                    int t = i.getMaxCapacity() - 1;
                    if (i.getCredits().get(t).equals(i.getCredits().get(t+1))) {
                        while (t > 0) {
                            if (i.getCredits().get(t).equals(i.getCredits().get(t-1))) {
                                t--;
                            }
                            else {
                                break;
                            }
                        }
                        t--;
                    }
                    ArrayList<Student> a = i.getSuccessStudents();
                    if (t >= 0) {
                        for (int j = 0; j < t+1; j++) {
                            a.add(i.getEnrollStudent().get(j));
                        }
                        i.setSuccessStudents(a);
                        for (int j = 0; j < t+1; j++) {
                            Student b = i.getEnrollStudent().get(j);
                            ArrayList<Course> c = b.getSuccessCourses();
                            c.add(i);
                            b.setSuccessCourses(c);
                        }
                    }
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> a = new ArrayList<>();
        if (ifOpen) {
            for (Course i: student.getEnrollCourses()) {
                String b = i.getCredits().get(i.getEnrollStudent().indexOf(student)).toString();
                String c = ": ";
                String d = i.getCourseID().concat(c).concat(b);
                a.add(d);
            }
        }
        return a;
    }
}