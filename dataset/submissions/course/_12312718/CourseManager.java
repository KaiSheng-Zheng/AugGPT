import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private boolean ifOpen;

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen == false) {
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
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                return false;
            }
        }
        if (student.getCredits() < credits) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen == false) {
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
        Course enrollCourse = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                enrollCourse = c;
                break;
            }
        }
        if (enrollCourse == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        if (student.getCredits() + originalCredits < credits) {
            return false;
        }
        student.setCredits(student.getCredits() + originalCredits - credits);
        course.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen == false) {
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
        int index = -1;
        Student st1 = null;
        for (Student s : course.getEnrollStudent()) {
            if (s.getStudentID().equals(student.getStudentID())) {
                index = course.getEnrollStudent().indexOf(s);
                st1 = s;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        int indexInStudent = -1;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                indexInStudent = student.getEnrollCourses().indexOf(c);
                break;
            }
        }
        student.setCredits(student.getCredits() + course.getCredits().get(index));
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(st1);
        student.getEnrollCourses().remove(indexInStudent);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen == false) {
            return null;
        }
        int index = -1;
        int credit = 0;
        ArrayList<String> credits = new ArrayList<String>();
        for (Course c : student.getEnrollCourses()) {
            for (Student s : c.getEnrollStudent()) {
                if (s.getStudentID().equals(student.getStudentID())) {
                    index = c.getEnrollStudent().indexOf(s);
                    credit = c.getCredits().get(index);
                }
            }
            credits.add(String.format("%s: %d", c.getCourseID(), credit));
        }
        return credits;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course c : this.courses) {
            //find the largest credit in a specific c
            int max = 0;
            for (int i = 0; i < c.getCredits().size(); i++) {
                if (c.getCredits().get(i) > max) {
                    max = c.getCredits().get(i);
                }
            }
            //decide the lowest scoreline
            int highNum = 0;//number of students who are higher than or equal the scoreline
            int scoreLine = 0;
            for (int i = 0; i <= 2*max; i++) {
                //test every scoreline
                highNum = 0;
                for (int j = 0; j < c.getCredits().size(); j++) {
                    if (c.getCredits().get(j) >= i) {
                        highNum++;
                    }
                }
                if (highNum <= c.getMaxCapacity()) {
                    scoreLine = i;
                    break;
                }
            }
            //get successful student id and add them into the success student list
            //add this specific course c into success course list of success student
            for (int i = 0; i < c.getCredits().size(); i++) {
                if (c.getCredits().get(i) >= scoreLine) {
                    c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                }
            }
        }
    }

    public void addStudent(Student student1) {
        this.students.add(student1);
        student1.setCourseManager(this);
    }

    public void addCourse(Course course1) {
        this.courses.add(course1);
        course1.setCourseManager(this);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }
}