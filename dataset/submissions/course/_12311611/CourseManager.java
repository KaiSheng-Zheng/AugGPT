import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        if (courses.contains(course)) {
            return;
        }
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        if (students.contains(student)) {
            return;
        }
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourseById(courseId);
        if (course == null || student == null || student.getEnrollCourses().contains(course) || credits <= 0 || student.getCredits() < credits) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(course);
        course.getCredits().add(credits);
        course.getEnrollStudent().add(student);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourseById(courseId);
        if (course == null || student == null || !student.getEnrollCourses().contains(course)) {
            return false;
        }
        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1) {
            return false;
        }
        int preCredit = course.getCredits().get(index);
        if (credits <= 0 || student.getCredits() + preCredit < credits) {
            return false;
        }
        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + preCredit - credits);
        return true;
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourseById(courseId);
        if (course == null || student == null || !student.getEnrollCourses().contains(course)) {
            return false;
        }
        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1) {
            return false;
        }
        student.setCredits(student.getCredits() + course.getCredits().get(index));
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(course);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            int capacity = course.getMaxCapacity();

            List<Integer> indices = IntStream.range(0, credits.size()).boxed().collect(Collectors.toList());

            Collections.sort(indices, (i, j) -> credits.get(j).compareTo(credits.get(i)));

            ArrayList<Student> sortedStudents = new ArrayList<>(enrolledStudents.size());
            ArrayList<Integer> sortedCredits = new ArrayList<>(credits.size());

            for (Integer index : indices) {
                sortedStudents.add(enrolledStudents.get(index));
                sortedCredits.add(credits.get(index));
            }

            for (int i = 0; i < sortedStudents.size(); i++) {
                enrolledStudents.set(i, sortedStudents.get(i));
                credits.set(i, sortedCredits.get(i));
            }

            int size = enrolledStudents.size();
            if (size <= capacity) {
                for (int i = 0; i < enrolledStudents.size(); i++) {
                    Student student = enrolledStudents.get(i);
                    student.getSuccessCourses().add(course);
                    course.getSuccessStudents().add(student);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (enrolledStudents.size() > capacity) {
                        enrolledStudents.remove(size - i - 1);
                    } else break;
                }
                for (int i = 0; i < capacity; i++) {
                    if (credits.get(capacity - 1 - i).equals(credits.get(capacity))) {
                        enrolledStudents.remove(capacity - i - 1);
                    } else break;
                }
                for (int i = 0; i < enrolledStudents.size(); i++) {
                    Student student = enrolledStudents.get(i);
                    student.getSuccessCourses().add(course);
                    course.getSuccessStudents().add(student);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen){
            return null;
        }
        ArrayList<String> enrolledCourses = new ArrayList<>();

        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            if (index == -1) {
                continue;
            }
            int credits = course.getCredits().get(index);
            enrolledCourses.add(course.getCourseID() + ": " + credits);
        }

        return enrolledCourses;
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}
