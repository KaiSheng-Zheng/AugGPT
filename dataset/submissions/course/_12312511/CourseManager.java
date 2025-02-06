import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        ifOpen = true;
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean NEW_ifOpen) {
        this.ifOpen = NEW_ifOpen;
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

    private Course course_to_operate(String courseID) {
        for (Course i : courses) {
            if (i.getCourseID().equals(courseID)) {
                return i;
            }
        }
        return null;
    }

    private int index_of_student(Student student, Course course) {
        return course.getEnrollStudent().indexOf(student);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (credits < 1) {
            return false;
        }
        Course course_to_enroll = course_to_operate(courseId);
        if (course_to_enroll == null) {
            return false;
        }

        if (course_to_enroll.getEnrollStudent().contains(student)) {
            return false;
        }
        int credit_after_enroll = student.getCredits() - credits;
        if (credit_after_enroll < 0) {
            return false;
        }
        student.setCredits(credit_after_enroll);
        student.getEnrollCourses().add(course_to_enroll);
        course_to_enroll.getEnrollStudent().add(student);
        course_to_enroll.getCredits().add(credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int new_credits) {
        if (!ifOpen) {
            return false;
        }
        if (new_credits < 1) {
            return false;
        }
        Course course_to_modify = course_to_operate(courseId);
        if (course_to_modify == null) {
            return false;
        }
        int index = index_of_student(student, course_to_modify);
        if (index == -1) {
            return false;
        }
        int credit_after_modify = student.getCredits()
                + course_to_modify.getCredits().get(index)
                - new_credits;
        if (credit_after_modify < 0) {
            return false;
        }
        student.setCredits(credit_after_modify);
        course_to_modify.getCredits().set(index, new_credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course_to_drop = course_to_operate(courseId);
        if (course_to_drop == null) {
            return false;
        }
        int index = index_of_student(student, course_to_drop);
        if (index == -1) {
            return false;
        }
        student.setCredits(student.getCredits() + course_to_drop.getCredits().get(index));
        student.getEnrollCourses().remove(course_to_drop);
        course_to_drop.getCredits().remove(index);
        course_to_drop.getEnrollStudent().remove(index);
        return true;
    }

    public void finalizeEnrollments() {
        this.setIfOpen(false);

        ArrayList<Integer> I;
        ArrayList<Student> S;

        int hou, qian;
        Student back, front;
        for (Course cos : courses) {
            ArrayList<Integer> creditsBackup = cos.getCredits();
            ArrayList<Student> studentBackup = cos.getEnrollStudent();

            S = cos.getEnrollStudent();
            I = cos.getCredits();
            for (int i = 0; i < I.size() - 1; i++) {
                for (int j = 0; j < I.size() - 1 - i; j++) {
                    hou = I.get(j + 1);
                    qian = I.get(j);
                    if (hou > qian) {
                        I.set(j, hou);
                        I.set(j + 1, qian);
                        back = S.get(j + 1);
                        front = S.get(j);
                        S.set(j, back);
                        S.set(j + 1, front);
                    }
                }
                cos.setCredits(creditsBackup);
                cos.setEnrollStudent(studentBackup);
            }
        }
        for (Course cos : courses) {
            S = cos.getEnrollStudent();
            I = cos.getCredits();
            cos.setSuccessStudents(S);
            if (S.size() > cos.getMaxCapacity()) {
                int index = 0;
                for (int i = cos.getMaxCapacity() - 1; i >= 0; i--) {
                    if (I.get(i) > I.get(cos.getMaxCapacity())) {
                        index = i;
                        break;
                    }
                }
                while (S.size() > index + 1) {
                    S.remove(index + 1);
                }
                cos.setSuccessStudents(S);
            }
        }
        for (Student stu : students) {
            ArrayList<Course> C = new ArrayList<>();
            for (Course cos : stu.getEnrollCourses()) {
                if (cos.getSuccessStudents().contains(stu)) {
                    C.add(cos);
                }
            }
            stu.setSuccessCourses(C);
        }
        ifOpen = false;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen) {
            ArrayList<String> Output = new ArrayList<>();
            String s;
            for (Course c : student.getEnrollCourses()) {
                int index = c.getEnrollStudent().indexOf(student);
                if (index != -1) {
                    s = c.getCourseID() + ": " + c.getCredits().get(index);
                    Output.add(s);
                }
            }
            return Output;
        } else {
            return null;
        }

    }
}
