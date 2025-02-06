import java.util.ArrayList;
import java.util.Collections;

import java.util.Objects;


public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
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

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addCourse(Course course) {
        course.setCourseManager(this);
        courses.add(course);
    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        students.add(student);
    }


    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen) {
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {
                    for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                        if ((student.getEnrollCourses().get(j).getCourseID()).equals(courseId)) {
                            return false;
                        }
                    }
                    if (student.getCredits() > 0 & student.getCredits() >= credits & credits >= 0) {

                        student.setCredits(student.getCredits() - credits);

                        ArrayList<Course> xxCC = student.getEnrollCourses();
                        xxCC.add(courses.get(i));
                        student.setEnrollCourses(xxCC);

                        ArrayList<Student> oo = courses.get(i).getEnrollStudent();
                        oo.add(student);
                        courses.get(i).setEnrollStudent(oo);

                        ArrayList<Integer> xx = courses.get(i).getCredits();
                        xx.add(credits);
                        courses.get(i).setCredits(xx);

                        return true;
                    }


                }
            }
        }
        return false;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen) {//ifOpen
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {//course exists
                    for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                        if ((student.getEnrollCourses().get(j).getCourseID()).equals(courseId)) {//the student is currently enrolled in the course
                            for (int k = 0; k < courses.get(i).getEnrollStudent().size(); k++) {
                                if (courses.get(i).getEnrollStudent().get(k).equals(student)) {
                                    if (student.getCredits() >= 0 & student.getCredits() + courses.get(i).getCredits().get(k) >= credits & credits > 0) {

                                        student.setCredits(student.getCredits() + courses.get(i).getCredits().get(k) - credits);

                                        ArrayList<Integer> xx = courses.get(i).getCredits();
                                        xx.set(k, credits);
                                        courses.get(i).setCredits(xx);

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
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen) {//ifOpen
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {//course exists
                    for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                        if ((student.getEnrollCourses().get(j).getCourseID()).equals(courseId)) {//the student is currently enrolled in the course
                            for (int k = 0; k < courses.get(i).getEnrollStudent().size(); k++) {
                                if (courses.get(i).getEnrollStudent().get(k).equals(student)) {

                                    student.setCredits(student.getCredits() + courses.get(i).getCredits().get(k));

                                    ArrayList<Integer> xx = courses.get(i).getCredits();
                                    xx.remove(k);
                                    courses.get(i).setCredits(xx);

                                    ArrayList<Student> oo = courses.get(i).getEnrollStudent();
                                    oo.remove(k);
                                    courses.get(i).setEnrollStudent(oo);

                                    ArrayList<Course> o = student.getEnrollCourses();
                                    o.remove(j);
                                    student.setEnrollCourses(o);

                                    return true;
                                }
                            }

                        }
                    }
                }
            }
        }
        return false;
    }


    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getMaxCapacity() >= courses.get(i).getCredits().size()) {//all success
                ArrayList<Student> as = courses.get(i).getEnrollStudent();
                courses.get(i).setSuccessStudents(as);

                for (int j = 0; j < students.size(); j++) {
                    if (students.get(j).getEnrollCourses().contains(courses.get(i))) {
                        ArrayList<Course> sc = new ArrayList<>();
                        sc.add(courses.get(i));
                        students.get(j).setSuccessCourses(sc);

                    }
                }
            } else {
                ArrayList<Integer> ori = courses.get(i).getCredits();
                ArrayList<Integer> sort = new ArrayList<>(ori);
                Collections.sort(sort);
                Collections.reverse(sort);

                //the same credit extended
                if (sort.get(courses.get(i).getMaxCapacity()).equals(sort.get(courses.get(i).getMaxCapacity() - 1))) {
                    Integer de = sort.get(courses.get(i).getMaxCapacity());
                    for (int j = 0; j < sort.size(); j++) {
                        Integer ele = sort.get(j);
                        if (ele.equals(de)|ele < de) {
                            sort.remove(j);
                            sort.add(10021);
                            j--;
                        }
                    }

                }
                //regular

                for (int j = 0; j < courses.get(i).getMaxCapacity(); j++) {
                    for (int k = 0; k < ori.size(); k++) {

                        if (Objects.equals(ori.get(k), sort.get(j))) {
                            if (courses.get(i).getSuccessStudents().contains(courses.get(i).getEnrollStudent().get(k))){
                                continue;
                            }
                            ArrayList<Student> ss;
                            ss = courses.get(i).getSuccessStudents();
                            ss.add(courses.get(i).getEnrollStudent().get(k));
                            courses.get(i).setSuccessStudents(ss);

                            for (int l = 0; l < students.size(); l++) {
                                for (int m = 0; m < courses.get(i).getSuccessStudents().size(); m++) {
                                    if (courses.get(i).getSuccessStudents().get(m).equals(students.get(l))) {
                                        if (students.get(l).getSuccessCourses().contains(courses.get(i))){
                                            continue;
                                        }
                                        ArrayList<Course> sc;
                                        sc = students.get(l).getSuccessCourses();
                                        sc.add(courses.get(i));
                                        students.get(l).setSuccessCourses(sc);
                                    }
                                }
                            }
                            break;
                        }
                    }
                }

            }
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen) {
            ArrayList<String> out = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                Course sc = student.getEnrollCourses().get(i);
                for (int j = 0; j < sc.getEnrollStudent().size(); j++) {
                    if (sc.getEnrollStudent().get(j).equals(student)) {
                        Integer ec = sc.getCredits().get(j);
                        String ecs = ec.toString();
                        String pun = ": ";
                        out.add(sc.getCourseID() + pun + ecs);
                        break;
                    }
                }
            }
            return out;
        } else {
            return null;
        }

    }

}
