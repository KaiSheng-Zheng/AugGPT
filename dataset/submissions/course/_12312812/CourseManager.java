import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private boolean IfOpen;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public void setIfOpen(boolean IfOpen) {
        this.IfOpen = IfOpen;
    }

    public boolean getIfOpen() {
        return IfOpen;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        students.add(student);
    }

    public void addCourse(Course course) {
        course.setCourseManager(this);
        courses.add(course);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (IfOpen) {
            int j = students.indexOf(student);
            Student s = students.get(j);
            int i = 0;
            for (Course c : courses) {
                if (c.getCourseID().equals(courseId) && s.getCredits() >= credits && s.getCredits() > 0 && credits > 0) {
                    boolean IfEnrolled = c.getEnrollStudent().contains(s);
                    if (!IfEnrolled) {
                        ArrayList<Student> enroll = c.getEnrollStudent();
                        enroll.add(student);
                        c.setEnrollStudent(enroll);
                        ArrayList<Integer> credit = c.getCredits();
                        credit.add(credits);
                        c.setCredits(credit);
                        ArrayList<Course> ec = s.getEnrollCourses();
                        ec.add(c);
                        s.setEnrollCourses(ec);
                        s.setCredits(s.getCredits() - credits);
                        students.set(j, s);
                        courses.set(i, c);
                        return true;
                    } else return false;
                }
                i++;
            }
            return false;
        } else return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (IfOpen) {
            int k = students.indexOf(student);
            int j = 0;
            for (Course c : courses) {
                if (courseId.equals(c.getCourseID())) {
                    if (student.getEnrollCourses().contains(c) == false) break;
                    int i = 0;
                    for (Student s : c.getEnrollStudent()) {
                        if (s.getStudentID().equals(student.getStudentID()) && s.getCredits() + (c.getCredits()).get(i) >= credits) {
                            s.setCredits(s.getCredits() - (credits - (c.getCredits()).get(i)));
                            ArrayList<Integer> cr = c.getCredits();
                            cr.set(i, credits);
                            c.setCredits(cr);
                            courses.set(j, c);
                            students.set(k, s);
                            return true;
                        }
                        i++;
                    }
                }
                j++;
            }
            return false;
        } else return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (IfOpen) {
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                if (s.getStudentID().equals(student.getStudentID())) {
                    for (int j = 0; j < courses.size(); j++) {
                        Course c = courses.get(j);
                        if (courseId.equals(c.getCourseID())) {
                            for (int k = 0; k < c.getEnrollStudent().size(); k++) {
                                Student sc = c.getEnrollStudent().get(k);
                                if (sc.getStudentID().equals(student.getStudentID())) {
                                    for (int l = 0; l < s.getEnrollCourses().size(); l++) {
                                        Course cs = s.getEnrollCourses().get(l);
                                        if (cs.getCourseID().equals(courseId)) {
                                            ArrayList<Student> enrollStudent = c.getEnrollStudent();
                                            enrollStudent.remove(k);
                                            c.setEnrollStudent(enrollStudent);
                                            ArrayList<Integer> credits = c.getCredits();
                                            int m = credits.get(k);
                                            credits.remove(k);
                                            c.setCredits(credits);
                                            courses.set(j, c);
                                            s.setCredits(s.getCredits() + m);
                                            ArrayList<Course> enrollCourse = s.getEnrollCourses();
                                            enrollCourse.remove(l);
                                            s.setEnrollCourses(enrollCourse);
                                            students.set(i, s);
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        } else return false;
    }

    public void finalizeEnrollments() {
        IfOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.getCredits().size() > c.getMaxCapacity()) {
                ArrayList<Integer> credits1 = new ArrayList<>();
                for (int t : c.getCredits()) {
                    credits1.add(t);
                }
                Collections.sort(credits1);
                int m = credits1.get(credits1.size() - c.getMaxCapacity() - 1);
                ArrayList<Student> success = new ArrayList<>();
                for (int j = 0; j < c.getEnrollStudent().size(); j++) {
                    Student s = c.getEnrollStudent().get(j);
                    int cr = c.getCredits().get(j);
                    if (cr > m) {
                        success.add(s);
                    }
                }
                c.setSuccessStudents(success);

            } else {
                c.setSuccessStudents(c.getEnrollStudent());
            }
            courses.set(i, c);
        }
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            ArrayList<Course> success = new ArrayList<>();
            for (Course c : s.getEnrollCourses()) {
                for (Student ss : c.getSuccessStudents()) {
                    if (ss.getStudentID().equals(s.getStudentID())) {
                        success.add(c);
                    }
                }
            }
            s.setSuccessCourses(success);
            students.set(i, s);
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (IfOpen) {
            ArrayList<String> EnrolledCoursesWithCredits = new ArrayList<>();
            for (Student s : students) {
                if (s.getStudentID().equals(student.getStudentID())) {
                    for (int i = 0; i < s.getEnrollCourses().size(); i++) {
                        for (int j = 0; j < s.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                            if (s.getStudentID().equals(s.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID())) {
                                String e = s.getEnrollCourses().get(i).getCourseID() + ": " + Integer.toString(s.getEnrollCourses().get(i).getCredits().get(j));
                                EnrolledCoursesWithCredits.add(e);
                            }
                        }
                    }
                }
            }
            return EnrolledCoursesWithCredits;
        } else return null;
    }
}
