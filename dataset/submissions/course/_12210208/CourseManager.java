import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {
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
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourse(courseId);
        if (course == null || student.getEnrollCourses().contains(course) || credits <= 0 || credits > student.getCredits()) {
            return false;
        }
        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourse(courseId);
        if (course == null || !student.getEnrollCourses().contains(course) || credits < 0 || credits > student.getCredits() + getCurrentBid(student, course)) {
            return false;
        }
        int index = course.getEnrollStudent().indexOf(student);
        int oldCredits = course.getCredits().get(index);
        student.setCredits(student.getCredits() + oldCredits - credits);
        course.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourse(courseId);
        if (course == null || !student.getEnrollCourses().contains(course)) {
            return false;
        }
        student.getEnrollCourses().remove(course);
        int index = course.getEnrollStudent().indexOf(student);
        int oldCredits = course.getCredits().get(index);
        student.setCredits(student.getCredits() + oldCredits);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);
        return true;
    }

    public void finalizeEnrollments() {
        if (ifOpen==true){
        for (Course course : courses) {
            ArrayList<Student> enrollStudents = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            int capacity = course.getMaxCapacity();

            enrollStudents.sort(Comparator.comparingInt(s -> -credits.get(enrollStudents.indexOf(s))));

            ArrayList<Student> successStudents = new ArrayList<>();
            int lastCredit = -1;
            int lastRank = -1;
            for (int i = 0; i < enrollStudents.size(); i++) {
                int credit = credits.get(i);
                if (credit != lastCredit) {
                    lastCredit = credit;
                    lastRank = i;
                }
                if (lastRank < capacity) {
                    successStudents.add(enrollStudents.get(i));
                }
            }
            course.setSuccessStudents(successStudents);

            for (Student student : successStudents) {
                student.getSuccessCourses().add(course);
            }
        }
     ifOpen=false;
    }

    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int credit = getCurrentBid(student, course);
            result.add(course.getCourseID() + ": " + credit);
        }
        return result;
    }

    private Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private int getCurrentBid(Student student, Course course) {
        int index = course.getEnrollStudent().indexOf(student);
        return course.getCredits().get(index);
    }
}