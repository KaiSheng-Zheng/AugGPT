import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class CourseManager {
    private boolean ifOpen;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public CourseManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.ifOpen = true;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        courses.add(course);
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
        Course enrolledCourse = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                enrolledCourse = c;
                break;
            }
        }
        if (enrolledCourse != null) {
            return false;
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
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int newCredits) {
        if (!ifOpen) return false;
        Course course = findCourse(courseId);
        if (course == null) return false;

        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1) return false;

        int currentCredits = course.getCredits().get(index);
        course.getCredits().set(index, newCredits);
        student.setCredits(student.getCredits() + currentCredits - newCredits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;

        Course course = findCourse(courseId);

        if (course == null) return false;

        int index = course.getEnrollStudent().indexOf(student);

        if (index == -1) {
            return false;
        }
        int credits = course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(course);
        student.setCredits(student.getCredits() + credits);
        return true;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);

        for (Course course : courses) {
            List<Student> enrolledStudents = new ArrayList<>(course.getEnrollStudent());
            List<Integer> bids = new ArrayList<>(course.getCredits());
            List<Pair<Student, Integer>> bidPairs = new ArrayList<>();

            for (int i = 0; i < enrolledStudents.size(); i++) {
                bidPairs.add(new Pair<>(enrolledStudents.get(i), bids.get(i)));
            }
            bidPairs.sort((p1, p2) -> {
                if (p1.second.equals(p2.second)) {
                    return 0;
                }
                return p2.second - p1.second;
            });

            course.getSuccessStudents().clear();
            int maxCapacity = course.getMaxCapacity();
            int enrolledCount = 0;
            Integer lastBid = null;

            for (Pair<Student, Integer> bidPair : bidPairs) {
                if (enrolledCount < maxCapacity) {
                    if (lastBid == null || !lastBid.equals(bidPair.second)) {

                        course.getSuccessStudents().add(bidPair.first);
                        enrolledCount++;
                        lastBid = bidPair.second;
                    } else {

                        Integer finalLastBid = lastBid;
                        if (enrolledCount + (bidPairs.stream()
                                .filter(p -> p.second.equals(finalLastBid))
                                .count() - 1)
                                <= maxCapacity) {

                            course.getSuccessStudents().add(bidPair.first);
                            enrolledCount++;
                        } else {

                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }

    class Pair<T1, T2> {
        T1 first;
        T2 second;
        Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            int credits = course.getCredits().get(index);
            enrolledCoursesWithCredits.add(course.getCourseID() +" :" + credits);
        }
        return enrolledCoursesWithCredits;
    }

    private Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}