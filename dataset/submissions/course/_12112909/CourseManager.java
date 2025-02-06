import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public CourseManager() {
        // these three lines
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        student.setCourseManager(this);
    }


    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (credits <= 0 || student.getCredits() < credits || !ifOpen) {
            return false;
        }

        Course course = getCourseById(courseId);
        if (course == null) {
            return false; // Course does not exist
        }

        if (course.getEnrollStudent().size() > course.getMaxCapacity()) {
            return false; // Course is full
        }

        if (student.getEnrollCourses().contains(course)) {
            // Student is already enrolled in the course
            return false;
        }

        // Deduct credits from student before adding to course
        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen || credits <= 0) {
            return false;
        }

        Course course = getCourseById(courseId);
        if (course == null) {
            return false; // Course does not exist
        }

        if (!student.getEnrollCourses().contains(course)) {
            return false; // Student is not enrolled in the course
        }

        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1) {
            return false; // Student is not found in the course's enrollment list
        }

        // Update the credits for the course
        int oldCredits = course.getCredits().get(index);
        if (student.getCredits() + oldCredits >= credits) {
            // Deduct old credits and add new credits to student
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

        Course course = getCourseById(courseId);
        if (course == null) {
            return false; // Course does not exist
        }

        if (!student.getEnrollCourses().contains(course)) {
            return false; // Student is not enrolled in the course
        }

        // Refund credits to student before removing from course
        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1) {
            return false; // Student is not found in the course's enrollment list
        }
        int creditsToRefund = course.getCredits().get(index);
        student.setCredits(student.getCredits() + creditsToRefund);
        course.getEnrollStudent().remove(student);
        course.getCredits().remove(index);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        for (Course course : courses) {
            if (course.getEnrollStudent().isEmpty()) {
                continue; 
            }

            Collections.sort(course.getEnrollStudent(), (s1, s2) -> {
                int creditsS1 = course.getCredits().get(course.getEnrollStudent().indexOf(s1));
                int creditsS2 = course.getCredits().get(course.getEnrollStudent().indexOf(s2));
                return Integer.compare(creditsS2, creditsS1);
            });

            int successfulStudents = 0;
            ArrayList<Student> studentsToRemove = new ArrayList<>();

            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                Student student = course.getEnrollStudent().get(i);
                int currentCredits = course.getCredits().get(i);
                int index = Math.min(course.getEnrollStudent().size(), course.getMaxCapacity());

                if (successfulStudents < course.getMaxCapacity()) {
                    successfulStudents++;
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                } else {
 
                    studentsToRemove.add(student);
                    student.setCredits(student.getCredits() + currentCredits); // 
                }

                if (successfulStudents == course.getMaxCapacity()) {
                    break;
                }
            }

            for (Student student : studentsToRemove) {
                dropStudentEnrollmentCourse(student, course.getCourseID());
            }
        }
    }



    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null; // Return null if ifOpen is false
        }

        ArrayList<String> result = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = student.getEnrollCourses().indexOf(course);
            result.add(course.getCourseID() + ": " + course.getCredits().get(index));
        }
        return result;
    }


    private Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }

        return null;
    }
}