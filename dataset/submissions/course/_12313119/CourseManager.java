import java.util.*;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.ifOpen = true;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public CourseManager(ArrayList<Course> courses, ArrayList<Student> students, boolean ifOpen) {
        this.courses = courses;
        this.students = students;
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

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
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
        //1
        if (!this.ifOpen) {
            return false;
        }
        //2
        if (credits <= 0) {
            return false;
        }
        //3
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
        //4
        boolean re = false;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                re = true;
                break;
            }
        }
        if (re) {
            return false;
        }
        if (student.getCredits() < credits) {
            return false;
        }
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
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
        boolean al = true;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                al = false;
                break;
            }
        }
        if (al) {
            return false;
        }
        int index = -2;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }

        int originalCredits = course.getCredits().get(index);
        if (originalCredits + student.getCredits() < credits) {
            return false;
        }
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
        boolean re = true;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                re = false;
                break;
            }
        }
        if (re) {
            return false;
        }
        int studentIndexInCourse = 0;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                studentIndexInCourse = i;
                break;
            }
        }
        int courseIndexInStudent = 0;
        for (int j = 0; j < student.getEnrollCourses().size(); j++) {
            if (student.getEnrollCourses().get(j).getCourseID().equals(courseId)) {
                courseIndexInStudent = j;
            }

        }
        int finalCridit = student.getCredits() + course.getCredits().get(studentIndexInCourse);
        student.setCredits(finalCridit);
        student.getEnrollCourses().remove(courseIndexInStudent);
        course.getEnrollStudent().remove(studentIndexInCourse);
        course.getCredits().remove(studentIndexInCourse);
        return true;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
//        int index = 0;
        ArrayList<Course> coursesEnrolled = new ArrayList<>(student.getEnrollCourses());
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (int i = 0; i < coursesEnrolled.size(); i++) {
            Course c = coursesEnrolled.get(i);
            for (int i1 = 0; i1 < c.getEnrollStudent().size(); i1++) {
                if (c.getEnrollStudent().get(i1).getStudentID().equals(student.getStudentID())) {
//                    index = i1;
                    String courseID = c.getCourseID();
                    int thisCourseCredit = c.getCredits().get(i1);
                    enrolledCoursesWithCredits.add(String.format("%s: %d", courseID, thisCourseCredit));
                }
            }
        }
        return enrolledCoursesWithCredits;
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (Course c : courses) {
            ArrayList<Integer> creditOfEnroll = new ArrayList<>(c.getCredits());
//            creditOfEnroll = (ArrayList<Integer>) c.getCredits().clone();
            creditOfEnroll.sort(Comparator.naturalOrder());
            int minCredit = 0;
            if (c.getMaxCapacity() < creditOfEnroll.size()) {
                int creditOfLastOneSuccess = creditOfEnroll.get(creditOfEnroll.size() - c.getMaxCapacity());
                int creditOfFirstOneFailed = creditOfEnroll.get(creditOfEnroll.size() - c.getMaxCapacity() - 1);
                if (creditOfFirstOneFailed == creditOfLastOneSuccess) {
                    int idxOfLastOneThatShouldBeKickedOut = creditOfEnroll.lastIndexOf(creditOfEnroll.get(creditOfEnroll.size() - c.getMaxCapacity()));
                    if (idxOfLastOneThatShouldBeKickedOut < creditOfEnroll.size() - 1) {
                        minCredit = creditOfEnroll.get(idxOfLastOneThatShouldBeKickedOut + 1);
                    }
                    else {
                        continue;
                    }
                } else {
                    minCredit = creditOfEnroll.get(creditOfEnroll.size() - c.getMaxCapacity());
                }
            }
            for (int i = 0; i < creditOfEnroll.size(); i++) {
                if (c.getCredits().get(i) >= minCredit) {
                    c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                }
            }
        }
    }
}



