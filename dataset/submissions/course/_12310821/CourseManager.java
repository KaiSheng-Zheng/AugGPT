import java.util.*;

public class CourseManager {

    private Map<String, Course> courses;
    private Map<String, Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new HashMap<>();
        students = new HashMap<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    public ArrayList<Course> getCourses() {
        return new ArrayList<>(courses.values());
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        if (!courses.containsKey(course.getCourseID())) {
            course.setCourseManager(this);
            courses.put(course.getCourseID(), course);
        } else {
            System.out.println("Course ID already exists.");
        }
    }

    public void addStudent(Student student) {
        if (!students.containsKey(student.getStudentID())) {
            student.setCourseManager(this);
            students.put(student.getStudentID(), student);
        } else {
            System.out.println("Student ID already exists.");
        }
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = courses.get(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return false;
        }
        if (student.getCredits() < credits) {
            System.out.println("Insufficient credits for enrollment.");
            return false;
        }
        if (course.getMaxCapacity() <= course.getEnrollStudent().size()) {
            System.out.println("Course is full.");
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = courses.get(courseId);
        if (course == null || !student.getEnrollCourses().contains(course)) {
            System.out.println("Student is not enrolled in this course.");
            return false;
        }
        int index = course.getEnrollStudent().indexOf(student);
        if (index != -1 && index < course.getCredits().size()) {
            int oldCredits = course.getCredits().get(index);
            if (student.getCredits() + oldCredits < credits) {
                System.out.println("Insufficient credits to modify enrollment.");
                return false;
            }
            student.setCredits(student.getCredits() + oldCredits - credits);
            course.getCredits().set(index, credits);
            return true;
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course = courses.get(courseId);
        if (course == null || !student.getEnrollCourses().contains(course)) {
            System.out.println("Student is not enrolled in this course.");
            return false;
        }
        int index = course.getEnrollStudent().indexOf(student);
        int credits = course.getCredits().get(index);
        student.setCredits(student.getCredits() + credits);
        student.getEnrollCourses().remove(course);
        course.getEnrollStudent().remove(student);
        course.getCredits().remove(index);
        return true;
    }

    public void finalizeEnrollments() {
        for (Course course : courses.values()) {
            List<Student> successStudents = new ArrayList<>();
            for (Student student : course.getEnrollStudent()) {
                int index = course.getEnrollStudent().indexOf(student);
                if (student.getCredits() >= course.getCredits().get(index)) {
                    successStudents.add(student);
                }
            }
            ArrayList<Student> arrayListSuccessStudents = new ArrayList<>(successStudents);
            course.setSuccessStudents(arrayListSuccessStudents);

            if (!successStudents.isEmpty()) {
                for (Student student : successStudents) {
                    student.getSuccessCourses().add(course);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            int credits = course.getCredits().get(index);
            enrolledCoursesWithCredits.add(course.getCourseID() + ": " + credits);
        }
        return enrolledCoursesWithCredits;
    }
}