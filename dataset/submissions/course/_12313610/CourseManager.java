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

    // getter for students
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
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
        for (Course enrolledCourse : student.getEnrollCourses()) {
            if (!enrolledCourse.getCourseID().equals(courseId)) {
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
        if (!this.ifOpen) {
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
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        if (student.getCredits() < credits) {
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        course.getCredits().set(index, student.getCredits() + originalCredits - credits);
        course.getEnrollStudent().set(index, student);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student s, String courseId) {
        if (!this.ifOpen) {
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
        for (int i = 0; i < s.getEnrollCourses().size(); i++) {
            if (s.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        s.getEnrollCourses().remove(course);
        s.setCredits(s.getCredits() + course.getCredits().get(index));

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : courses) {
            if (course.getEnrollStudent().contains(student)) {
                int index = -1;
                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                    if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID()))
                        index = i;
                }
                if (index == -1) {
                    return null;
                }
                int credits = course.getCredits().get(index);
                String courseWithCredits = course.getCourseID() + ": " + credits;
                enrolledCoursesWithCredits.add(courseWithCredits);
            }
        }

        return enrolledCoursesWithCredits;
    }
    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();
            ArrayList<Integer> creditsList = course.getCredits();
            int capacity = course.getMaxCapacity();
            int sumCredits = 0;
            for (int credits : creditsList) {
                sumCredits += credits;
            }
            int threshold = (sumCredits / creditsList.size()) + capacity;
            for (int i = 0; i < creditsList.size(); i++) {
                int credits = creditsList.get(i);
                Student student = enrolledStudents.get(i);
                if (credits >= threshold) {
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                }
            }
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {

    }

    public boolean getIfOpen() {
        return ifOpen;
    }


}