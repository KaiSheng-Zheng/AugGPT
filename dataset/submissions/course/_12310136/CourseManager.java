import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
        //why this expression
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
        //this
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        boolean test = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).equals(course)) {
                test = true;
                break;
            }
        }
        if (test) {
            return false;
        }//already in list


        if (student.getCredits() - credits < 0) {
            return false;
        }
        student.getEnrollCourses().add(course);
        //if successful
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);//
        course.getCredits().add(credits);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }


        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }


        boolean test = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).equals(course)) {
                test = true;
                break;
            }
        }
        if (!test) {
            return false;
        }


        int index = 0;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        if (credits > student.getCredits() + originalCredits) {
            return false;
        }//credit is not enough


        course.getCredits().set(index, credits);
        student.setCredits(originalCredits + student.getCredits() - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }


        if (!this.ifOpen) {
            return false;
        }


        boolean test = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                test = true;
                break;
            }
        }
        if (!test) {
            return false;
        }


        int index = 0;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);


        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(course);
        student.setCredits(student.getCredits() + originalCredits);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();

        for (Course c : student.getEnrollCourses()) {

            int index = c.getEnrollStudent().indexOf(student);
            String cre = String.valueOf(c.getCredits().get(index));
            list.add(c.getCourseID() + ": " + cre);




        }

        return list;
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (Course c : this.courses) {
            ArrayList<Integer> credit0 = new ArrayList<>(c.getCredits());
            //credit0 = c.getCredits();
            credit0.sort(Collections.reverseOrder());
            if (credit0.isEmpty()) continue;
            //c.getMaxCapacity();
            int standard;
            if (c.getMaxCapacity() >= credit0.size()) {
                standard = credit0.get(credit0.size() - 1);
            } else {
                if (credit0.get(c.getMaxCapacity() - 1).equals(credit0.get(c.getMaxCapacity()))) {
                    standard = credit0.get(c.getMaxCapacity() - 1) + 1;
                } else {
                    standard = credit0.get(c.getMaxCapacity() - 1);
                }
            }
            for (int i = 0; i < c.getCredits().size(); i++) {
                if (c.getCredits().get(i) >= standard) {
                    c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                }
            }

        }
    }


}
