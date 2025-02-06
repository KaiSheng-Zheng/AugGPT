import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private boolean isOpen;

    public CourseManager() {
        this.isOpen = false;
    }

    public void setIfOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean getIfOpen() {
        return isOpen;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    private Course getCourse(String courseId) {
        return courses.stream().filter(c -> c.getCourseID().equals(courseId)).findFirst().orElse(null);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int creditBid) {
        if (!isOpen || student.getCredits() < creditBid) return false;

        Course course = getCourse(courseId);
        if (course == null) return false;

        if (course.getEnrollStudent().contains(student)) return false;

        student.setCredits(student.getCredits() - creditBid);
        course.getEnrollStudent().add(student);
        course.getCredits().add(creditBid);
        student.getEnrollCourses().add(course);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int newCreditBid) {
        if (!isOpen) return false;

        Course course = getCourse(courseId);
        if (course == null) return false;

        int studentIndex = course.getEnrollStudent().indexOf(student);
        if (studentIndex == -1) return false;

        int currentBid = course.getCredits().get(studentIndex);
        if (student.getCredits() + currentBid < newCreditBid) return false;

        student.setCredits(student.getCredits() + currentBid - newCreditBid);
        course.getCredits().set(studentIndex, newCreditBid);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!isOpen) return false;

        Course course = getCourse(courseId);
        if (course == null) return false;

        int studentIndex = course.getEnrollStudent().indexOf(student);
        if (studentIndex == -1) return false;

        int bidCredits = course.getCredits().get(studentIndex);
        student.setCredits(student.getCredits() + bidCredits);
        course.getEnrollStudent().remove(studentIndex);
        course.getCredits().remove(studentIndex);
        student.getEnrollCourses().remove(course);

        return true;
    }

    public void finalizeEnrollments() {
        if (isOpen) {
            setIfOpen(false);
            for (Course course : courses) {
                HashMap<Integer, List<Student>> bidGroups = new HashMap<>();

                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                    Student student = course.getEnrollStudent().get(i);
                    Integer bid = course.getCredits().get(i);
                    bidGroups.computeIfAbsent(bid, k -> new ArrayList<>()).add(student);
                }

                List<Integer> sortedBids = new ArrayList<>(bidGroups.keySet());
                sortedBids.sort(Comparator.reverseOrder());

                List<Student> successfulStudents = new ArrayList<>();
                for (Integer bid : sortedBids) {
                    if (successfulStudents.size() + bidGroups.get(bid).size() <= course.getMaxCapacity()) {
                        successfulStudents.addAll(bidGroups.get(bid));
                    } else if (successfulStudents.size() < course.getMaxCapacity()) {

                        break;
                    }
                }


                course.setSuccessStudents((ArrayList<Student>) successfulStudents);
                successfulStudents.forEach(s -> s.getSuccessCourses().add(course));


                course.getEnrollStudent().forEach(s -> {
                    if (!successfulStudents.contains(s)) {
                        int bidIndex = course.getEnrollStudent().indexOf(s);
                        int refundCredits = course.getCredits().get(bidIndex);
                        s.setCredits(s.getCredits() + refundCredits);
                    }
                });

                course.getEnrollStudent().clear();
                course.getCredits().clear();
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!isOpen) return null;

        ArrayList<String> coursesWithCredits = new ArrayList<>();
        for (Course course : courses) {
            if (course.getEnrollStudent().contains(student)) {
                int index = course.getEnrollStudent().indexOf(student);
                coursesWithCredits.add(course.getCourseID() + ": " + course.getCredits().get(index));
            }
        }
        return coursesWithCredits;
    }
}

