import java.util.*;

public class CourseManager {
    private boolean ifOpen;
    private final ArrayList<Student> students;
    private final ArrayList<Course> courses;

    public CourseManager() {
        this.ifOpen = false;
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
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
        if (ifOpen) {
            Course course = findCourseById(courseId);
            if (course != null) {
                if (course.getEnrollStudent().size() < course.getMaxCapacity()) {
                    course.getEnrollStudent().add(student);
                    course.getCredits().add(credits);
                    return true;
                } else {
                    // Check if the new student's credits are higher than the lowest bid
                    int lowestBid = Collections.min(course.getCredits());
                    if (credits > lowestBid) {
                        int lowestIndex = course.getCredits().indexOf(lowestBid);
                        course.getEnrollStudent().set(lowestIndex, student);
                        course.getCredits().set(lowestIndex, credits);
                        return true;
                    } else if (credits == lowestBid) {
                        // If new student's credits are equal to the lowest bid, replace all students with the same bid
                        for (int i = 0; i < course.getCredits().size(); i++) {
                            if (course.getCredits().get(i) == lowestBid) {
                                course.getEnrollStudent().set(i, student);
                                course.getCredits().set(i, credits);
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int findLowestBidStudentIndex(Course course) {
        int lowestIndex = -1;
        int lowestBid = Integer.MAX_VALUE;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getCredits().get(i) < lowestBid) {
                lowestBid = course.getCredits().get(i);
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course course = findCourseById(courseId);
        if (course != null) {
            int index = course.getEnrollStudent().indexOf(student);
            if (index != -1) {
                course.getCredits().set(index, credits);
                return true;
            } else {
                // If student is not enrolled, try enrolling with new credits
                return enrollStudentInCourse(student, courseId, credits);
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course course = findCourseById(courseId);
        if (course != null) {
            int index = course.getEnrollStudent().indexOf(student);
            if (index != -1) {
                course.getEnrollStudent().remove(index);
                int credits = course.getCredits().remove(index);

                // Update student's enrolled courses with credits
                for (Student enrolledStudent : students) {
                    if (enrolledStudent.equals(student)) {
                        ArrayList<Course> enrolledCourses = enrolledStudent.getEnrollCourses();
                        ArrayList<Integer> studentCredits = new ArrayList<>(enrolledStudent.getCredits());
                        int courseIndex = enrolledCourses.indexOf(courseId);
                        if (courseIndex != -1) {
                            enrolledCourses.remove(courseIndex);
                            studentCredits.remove(courseIndex);
                        }
                        break;
                    }
                }

                return true;
            }
        }
        return false;
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public void finalizeEnrollments() {
        for (Course course : courses) {
            List<Student> enrollStudents = course.getEnrollStudent();
            List<Integer> credits = course.getCredits();
            List<Student> successStudents = new ArrayList<>();

            if (enrollStudents.size() > course.getMaxCapacity()) {
                // Create a map to store students with the same credits
                Map<Integer, List<Student>> creditMap = new HashMap<>();
                for (int i = 0; i < enrollStudents.size(); i++) {
                    int credit = credits.get(i);
                    creditMap.putIfAbsent(credit, new ArrayList<>());
                    creditMap.get(credit).add(enrollStudents.get(i));
                }

                // Sort the credits in descending order
                List<Integer> sortedCredits = new ArrayList<>(creditMap.keySet());
                Collections.sort(sortedCredits, Collections.reverseOrder());

                // Select students up to capacity, considering students with the same credits
                int count = 0;
                for (Integer credit : sortedCredits) {
                    List<Student> studentsWithSameCredit = creditMap.get(credit);
                    if (count + studentsWithSameCredit.size() > course.getMaxCapacity()) {
                        // If adding this group of students would exceed capacity, skip them
                        continue;
                    }
                    if (studentsWithSameCredit.size() > course.getMaxCapacity() - count) {
                        // If the group itself exceeds remaining capacity, skip all of them
                        continue;
                    }
                    for (Student student : studentsWithSameCredit) {
                        if (count < course.getMaxCapacity()) {
                            successStudents.add(student);
                            count++;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                successStudents.addAll(enrollStudents);
            }

            course.setSuccessStudents((ArrayList<Student>) successStudents);
        }

        // Update ifOpen status to false after finalizing enrollments
        setIfOpen(false);
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        // Implement logic for getting enrolled courses with corresponding credits for a student
        return new ArrayList<>(); // Placeholder return
    }

    public boolean getIfOpen() {
        return ifOpen;
    }
}