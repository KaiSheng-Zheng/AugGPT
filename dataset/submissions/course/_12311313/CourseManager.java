import java.util.*;
import java.util.stream.IntStream;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        this.ifOpen = true;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
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
    public boolean enrollStudentInCourse(Student student, String courseId, int points) {
        if (!getIfOpen() || points <= 0 || student.getCredits() < points) {
            return false;
        }
        Course courseToEnroll = null;
        for (Course course : getCourses()) {
            if (course.getCourseID().equals(courseId)) {
                courseToEnroll = course;
                break;
            }
        }
        if (courseToEnroll == null ||student.getEnrollCourses().contains(courseToEnroll)) {
            return false;
        }
        int credit = student.getCredits() - points;
        student.setCredits(credit);
        student.getEnrollCourses().add(courseToEnroll);
        courseToEnroll.getEnrollStudent().add(student);
        courseToEnroll.getCredits().add(points);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!getIfOpen()) {
            return false;
        }
        Course course = null;
        for (Course c : getCourses()) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null ||!student.getEnrollCourses().contains(course)) {
            return false;
        }
        int currentBid = course.getCredits().get(course.getEnrollStudent().indexOf(student));
        if (student.getCredits() + currentBid < credits) {
            return false;
        }
        student.setCredits(student.getCredits() + currentBid - credits);
        course.getCredits().set(course.getEnrollStudent().indexOf(student), credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!getIfOpen()) {
            return false;
        }
        Course courseToDrop = null;
        for (Course course : getCourses()) {
            if (course.getCourseID().equals(courseId)) {
                courseToDrop = course;
                break;
            }
        }
        if (courseToDrop == null || !student.getEnrollCourses().contains(courseToDrop)) {
            return false;
        }
        student.getEnrollCourses().remove(courseToDrop);
        int index = courseToDrop.getEnrollStudent().indexOf(student);
        if (index != -1) {
            int creditsRefunded = courseToDrop.getCredits().get(index);
            student.setCredits(student.getCredits() + creditsRefunded);
            courseToDrop.getEnrollStudent().remove(index);
            courseToDrop.getCredits().remove(index);
        }
        return true;
    }
    public void finalizeEnrollments() {
        this.setIfOpen(false);
        for (Course course : this.getCourses()) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();
            ArrayList<Integer> bidCredits = course.getCredits();
            ArrayList<Student> successfulStudents = new ArrayList<>();
            ArrayList<Integer> sortedbidCredits = new ArrayList<>();
            List<Integer> sortedIndices = IntStream.range(0, bidCredits.size())
                    .boxed()
                    .sorted((i, j) -> bidCredits.get(j).compareTo(bidCredits.get(i)))
                    .toList();
            for (int i = 0; i < bidCredits.size(); i++) {
                sortedbidCredits.add(bidCredits.get(sortedIndices.get(i)));
            }
            int capacity = course.getMaxCapacity();
            for (int i = 0; i < Math.min(capacity, enrolledStudents.size()); i++) {
                int ind = sortedIndices.get(i);
                successfulStudents.add(enrolledStudents.get(ind));
            }
            if (capacity < enrolledStudents.size()) {
                int nextCredits = sortedbidCredits.get(successfulStudents.size());
                int lastValidCredits = sortedbidCredits.get(successfulStudents.size() - 1);
                if (nextCredits == lastValidCredits) {
                    for (int i = 0; i < bidCredits.size()-1; i++) {
                        successfulStudents.removeIf(s -> bidCredits.get(enrolledStudents.indexOf(s)) == lastValidCredits);
                    }
                }
            }
            course.setSuccessStudents(successfulStudents);
            for (Student student : successfulStudents) {
                ArrayList<Course> successCourses = student.getSuccessCourses();
                successCourses.add(course);
                student.setSuccessCourses(successCourses);
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.getIfOpen()) {
            return null;
        } else {
            ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
            ArrayList<Course> enrolledCourses = student.getEnrollCourses();
            for (Course course : enrolledCourses) {
                int studentIndex = course.getEnrollStudent().indexOf(student);
                int creditsBid = course.getCredits().get(studentIndex);
                enrolledCoursesWithCredits.add(course.getCourseID() + ": " + creditsBid);
            }
            return enrolledCoursesWithCredits;
        }
    }
}