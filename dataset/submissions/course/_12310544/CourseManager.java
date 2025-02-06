import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = false;
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

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        Student stu = null;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                return false;
            }
        }
        if (student.getCredits() < credits) {
            return false;
        }
        int a = student.getCredits() - credits;
        student.setCredits(a);

        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        Student stu = null;
        int index = -1;


        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                index = i;
                stu = student;
                break;
            }
        }
        if (stu == null) {
            return false;
        }
        if (course.getCredits().get(index) + student.getCredits() - credits < 0) {
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + originalCredits - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        Student stu = null;
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                index = i;
                stu = student;
                break;
            }
        }
        if (stu == null) {
            return false;
        }
        student.setCredits(stu.getCredits() + course.getCredits().get(index));
        student.getEnrollCourses().remove(course);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        /*int num = 0;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                student.getEnrollCourses().remove(i);
                num = i;
                break;
            }
        }*/

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        int index = 0;
        ArrayList<String> str = new ArrayList<>();
        for (Course c : student.getEnrollCourses()) {
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (c.getEnrollStudent().get(i).equals(student)) {
                    index = i;
                    str.add(c.getCourseID() + ": " + c.getCredits().get(i));
                    break;
                }
            }
        }
        return str;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course c : this.courses) {
            for (int i = 0; i < c.getCredits().size(); i++) {
                for (int j = 0; j < c.getCredits().size() - 1; j++) {
                    if (c.getCredits().get(j) < c.getCredits().get(j + 1)) {
                        int temp = c.getCredits().get(j);
                        Student stu = c.getEnrollStudent().get(j);
                        c.getCredits().set(j, c.getCredits().get(j + 1));
                        c.getEnrollStudent().set(j, c.getEnrollStudent().get(j + 1));
                        c.getCredits().set(j + 1, temp);
                        c.getEnrollStudent().set(j + 1, stu);
                    }
                }
            }

            ArrayList<Integer> credits = new ArrayList<>();
            for (int i = 0; i < c.getMaxCapacity(); i++) {
                if (c.getCredits().size() == 0) {
                    break;
                } else {
                    if (i == c.getCredits().size() - 1) {
                        credits.add(c.getCredits().get(i));
                        break;
                    } else if (i != c.getMaxCapacity() - 1 && i < c.getCredits().size()) {
                        credits.add(c.getCredits().get(i));
                    } else if (i == c.getMaxCapacity() - 1) {
                        if (c.getCredits().get(i).equals(c.getCredits().get(i + 1))) {
                            credits.remove(c.getCredits().get(i));
                            break;
                        } else {
                            credits.add(c.getCredits().get(i));
                        }
                    }

                    /*if (c.getCredits().size() <= c.getMaxCapacity() && i < c.getCredits().size()) {
                        credits.add(c.getCredits().get(i));
                    } else {
                        if (i != c.getMaxCapacity() - 1) {
                            credits.add(c.getCredits().get(i));
                        }
                        if (i == c.getMaxCapacity() - 1) {
                            if (c.getCredits().get(i).equals(c.getCredits().get(i + 1))) {
                                credits.remove(c.getCredits().get(i));
                                break;
                            } else {
                                credits.add(c.getCredits().get(i));
                            }
                        }
                    }*/
                }
            }
            for (int i = 0; i < credits.size(); i++) {
                c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                c.getEnrollStudent().get(i).getSuccessCourses().add(c);
            }
        }


    }
}