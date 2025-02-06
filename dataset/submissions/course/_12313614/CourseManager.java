

import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
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
        courses.add(course);
        course.setCourseManager(this);

    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course m : this.courses) {
            if (m.getCourseID().equals(courseId)) {//check in course
                course = m;
            }
        }
        if (course == null) {
            return false;
        }
        for (Course m : student.getEnrollCourses()) {
            if (courseId.equals(m.getCourseID())) {
                return false;
            }
        }
        if (credits <= 0 || credits > student.getCredits()) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        for (Course m : this.courses) {
            if (m.getCourseID().equals(courseId)) {
                m.getEnrollStudent().add(student);
                m.getCredits().add(credits);
                student.getEnrollCourses().add(m);

            }
        }
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course m : this.courses) {
            if (m.getCourseID().equals(courseId)) {//check in course
                course = m;
            }
        }
        if (course == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
            }

        }
        if (index == -1) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        if (credits > student.getCredits() + originalCredits) {
            return false;
        }
        course.getCredits().set(index, credits);
        student.setCredits(originalCredits + student.getCredits() - credits);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course m : this.courses) {
            if (m.getCourseID().equals(courseId)) {//check in course
                course = m;
            }
        }
        if (course == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
            }

        }
        if (index == -1) {
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        student.setCredits(student.getCredits() + originalCredits);
        int indexInStudentCourse = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())) {
                indexInStudentCourse = i;
            }

        }
        student.getEnrollCourses().remove(indexInStudentCourse);
        return true;
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (Course m : this.courses) {
            int n = m.getCredits().size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (m.getCredits().get(j) < m.getCredits().get(j + 1)) {
                        int temp = m.getCredits().get(j);
                        Student temp2 = m.getEnrollStudent().get(j);
                        m.getCredits().set(j, m.getCredits().get(j + 1));
                        m.getEnrollStudent().set(j, m.getEnrollStudent().get(j + 1));
                        m.getCredits().set(j + 1, temp);
                        m.getEnrollStudent().set(j + 1, temp2);
                    }
                }
            }

            m.getSuccessStudents().clear();

            int a = 0;
            if (m.getMaxCapacity() >= m.getCredits().size()) {
                for (int i = 0; i < m.getCredits().size(); i++) {
                    m.getSuccessStudents().add(m.getEnrollStudent().get(i));

                }
            }else{
            if (m.getCredits().get(m.getMaxCapacity() - 1) > m.getCredits().get(m.getMaxCapacity())) {
                for (int i = 0; i < m.getMaxCapacity(); i++) {
                    m.getSuccessStudents().add(m.getEnrollStudent().get(i));

                }
            } else {
                a=m.getMaxCapacity()-1;
                while (m.getCredits().get(a) == m.getCredits().get(m.getMaxCapacity())) {
                    a--;
                    if(a<0) break;

                }
                for (int i = 0; i <= a; i++) {
                    m.getSuccessStudents().add(m.getEnrollStudent().get(i));

                }
            }
            for (Student successStudent : m.getSuccessStudents()) {
                successStudent.getSuccessCourses().add(m);
            }
            }
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen == false) {
            return null;
        }
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            enrolledCoursesWithCredits.add(student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student)));

        }
        return enrolledCoursesWithCredits;
    }

}

