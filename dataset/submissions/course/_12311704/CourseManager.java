import java.util.ArrayList;
import java.util.Objects;

public class CourseManager {
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
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

    private ArrayList<Student> students = new ArrayList<>();

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return this.ifOpen;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }


    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean ifEnrolled = false;
        boolean ifmeiyouenrolled = true;
        boolean ifCourseExist = false;
        boolean CreditsBiggerThanAndEnoughCredits = false;
        for (Course c : courses) {
            if (courseId.equals(c.getCourseID())) {
                ifCourseExist = true;
                break;
            }
        }

        for (Course c : student.getEnrollCourses()) {
            if (Objects.equals(courseId, c.getCourseID())) {
                ifmeiyouenrolled = false;
                break;
            }
        }

        if (credits > 0 && student.getCredits() >= credits) {
            CreditsBiggerThanAndEnoughCredits = true;
        }
        if (ifOpen) {
            if (ifCourseExist && ifmeiyouenrolled && CreditsBiggerThanAndEnoughCredits) {
                for (Course c : courses) {
                    if (courseId.equals(c.getCourseID())) {
                        ifEnrolled = true;
                        ArrayList<Student> tempEnrolledStudentsOfaCourse = new ArrayList<>(c.getEnrollStudent());
                        ArrayList<Course> tempEnrolledCoursesofaStudent = new ArrayList<>(student.getEnrollCourses());
                        ArrayList<Integer> tempCreditsofaCourse = new ArrayList<>(c.getCredits());
                        tempEnrolledStudentsOfaCourse.add(student);
                        c.setEnrollStudent(tempEnrolledStudentsOfaCourse);
                        tempEnrolledCoursesofaStudent.add(c);
                        student.setEnrollCourses(tempEnrolledCoursesofaStudent);
                        tempCreditsofaCourse.add(credits);
                        c.setCredits(tempCreditsofaCourse);
                        student.setCredits(student.getCredits() - credits);
                        break;
                    }
                }
            }
        } else {
            return ifEnrolled;
        }
        return ifEnrolled;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean ifCourseExist1 = false;
        boolean modifyYes = false;
        for (Course c : courses) {
            if (courseId.equals(c.getCourseID())) {
                ifCourseExist1 = true;
                break;
            }
        }
        for (Course c : student.getEnrollCourses()) {
            if (courseId.equals(c.getCourseID()) && credits <= student.getCredits() + c.getCredits().get(c.getEnrollStudent().indexOf(student)) && credits > 0 && ifCourseExist1) {
                student.setCredits(student.getCredits() + c.getCredits().get(c.getEnrollStudent().indexOf(student)) - credits);
                ArrayList<Integer> tempcd = new ArrayList<>();
                tempcd.addAll(c.getCredits());
                tempcd.set((c.getEnrollStudent().indexOf(student)), credits);
                c.setCredits(tempcd);
                modifyYes = true;
                break;
            }
        }
        if (!ifOpen) {
            return false;
        }
        return modifyYes;
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {

        ArrayList<Student> tempstd = new ArrayList<>();
        ArrayList<Integer> tempcredits = new ArrayList<>();
        ArrayList<Course> tempcs = new ArrayList<>();
        boolean drop = false;
        for (Course c : courses) {
            if (Objects.equals(courseId, c.getCourseID())) {
                tempcs.addAll(student.getEnrollCourses());
                tempcredits.addAll(c.getCredits());
                tempstd.addAll(c.getEnrollStudent());
                for (Course cs : student.getEnrollCourses()) {
                    if (courseId.equals(cs.getCourseID())) {
                        student.setCredits(student.getCredits() + cs.getCredits().get(cs.getEnrollStudent().indexOf(student)));//refund
                        tempstd.remove(student);
                        tempcredits.remove(cs.getEnrollStudent().indexOf(student));//deletingcredits
                        cs.setCredits(tempcredits);
                        cs.setEnrollStudent(tempstd);//deleting the corresponding student
                        tempcs.remove(cs);
                        student.setEnrollCourses(tempcs);//deleting the corresponding course
                        drop = true;
                        break;
                    }
                }
                break;
            }
        }
        if (!ifOpen) {
            return false;
        }
        return drop;
    }


    public ArrayList getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> get = new ArrayList<>();

        for (Course course : student.getEnrollCourses()) {
            get.add(course.getCourseID() + ": " + course.getCredits().get(course.getEnrollStudent().indexOf(student)));//courseID: enrollmentCredits
        }
        if (!ifOpen) {
            return null;
        }
        return get;
    }

    public void finalizeEnrollments() {
        this.setIfOpen(false);
        for (Course c : this.courses) {
            ArrayList<Integer> tempccre = new ArrayList<>(c.getCredits());
            ArrayList<Student> tempss = new ArrayList<>(c.getEnrollStudent());
            ArrayList<Student> tempStuSuccess = new ArrayList<>();

            for (int i = 1; i < tempccre.size(); i++) {
                boolean flag = true;
                for (int j = 0; j < tempccre.size() - i; j++) {
                    if (tempccre.get(j) < tempccre.get(j + 1)) {
                        int tmp = tempccre.get(j);
                        tempccre.set(j, tempccre.get(j + 1));
                        tempccre.set(j + 1, tmp);
                        Student tmp1 = tempss.get(j);
                        tempss.set(j, tempss.get(j + 1));
                        tempss.set(j + 1, tmp1);
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }

//        c.setEnrollStudent(tempss);
//        c.setCredits(tempccre);

            //Select the successfully enrolling students
            if (c.getEnrollStudent().size() <= c.getMaxCapacity()) {
                c.setSuccessStudents(c.getEnrollStudent());
            } else {
                if (c.getMaxCapacity() != 0 && Objects.equals(tempccre.get(c.getMaxCapacity() - 1), tempccre.get(c.getMaxCapacity()))) {
                    for (int i = c.getMaxCapacity() - 1; i >= 0; i--) {
                        if (!Objects.equals(tempccre.get(i), tempccre.get(c.getMaxCapacity() - 1))) {//||!Objects.equals(tempccre.get(i),tempccre.get(c.getMaxCapacity()))||(tempccre.size()>=c.getMaxCapacity()+2 && Objects.equals(tempccre.get(c.getMaxCapacity() + 1), tempccre.get(c.getMaxCapacity())))
                            for (int j = 0; j <= i; j++) {
                                tempStuSuccess.add(tempss.get(j));
                            }
                            c.setSuccessStudents(tempStuSuccess);
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i <= c.getMaxCapacity() - 1; i++) {
                        tempStuSuccess.add(tempss.get(i));
                    }
                    c.setSuccessStudents(tempStuSuccess);
                }
            }
            for (Student s : c.getSuccessStudents()) {
                ArrayList<Course> tempSuccessCourse = new ArrayList<>(s.getSuccessCourses());
                tempSuccessCourse.add(c);
                s.setSuccessCourses(tempSuccessCourse);
            }
        }
    }
}