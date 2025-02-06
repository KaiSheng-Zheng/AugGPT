import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
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
        if (ifOpen && courses.contains(useCourseIdToFindCourse(courseId)) && !(student.getEnrollCourses().contains(useCourseIdToFindCourse(courseId))) && credits > 0 && student.getCredits() >= credits) {
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(useCourseIdToFindCourse(courseId));
            useCourseIdToFindCourse(courseId).getEnrollStudent().add(student);
            useCourseIdToFindCourse(courseId).getCredits().add(credits);
            return true;
        } else {
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen && courses.contains(useCourseIdToFindCourse(courseId)) && student.getEnrollCourses().contains(useCourseIdToFindCourse(courseId)) && student.getCredits() + useStudentAndCourseToFindCredits(student, courseId) >= credits) {
            student.setCredits(student.getCredits() + useStudentAndCourseToFindCredits(student, courseId) - credits);
            useCourseIdToFindCourse(courseId).getCredits().set(useCourseIdToFindCourse(courseId).getEnrollStudent().indexOf(student), credits);
            return true;
        } else {
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen && courses.contains(useCourseIdToFindCourse(courseId)) && student.getEnrollCourses().contains(useCourseIdToFindCourse(courseId))) {
            student.setCredits(student.getCredits() + useStudentAndCourseToFindCredits(student, courseId));
            int index = useCourseIdToFindCourse(courseId).getEnrollStudent().indexOf(student);
            student.getEnrollCourses().remove(useCourseIdToFindCourse(courseId));
            useCourseIdToFindCourse(courseId).getEnrollStudent().remove(index);
            useCourseIdToFindCourse(courseId).getCredits().remove(index);
            return true;
        } else {
            return false;
        }
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course CourseHere : courses) {
            int studentNumber = CourseHere.getEnrollStudent().size();
            int acquiredCredits = 0;
            while (studentNumber > CourseHere.getMaxCapacity()) {
                for (int i = 0; i < CourseHere.getEnrollStudent().size(); i++) {
                    Student studentHere = CourseHere.getEnrollStudent().get(i);
                    int CreditsOfThisStudent = useStudentAndCourseToFindCredits(studentHere, CourseHere.getCourseID());
                    if (CreditsOfThisStudent <= acquiredCredits) {
                        CourseHere.getEnrollStudent().remove(studentHere);
                        CourseHere.getCredits().remove(i);
                        i--;
                        studentNumber--;
                    }
                }
                acquiredCredits++;
            }
            for (Student studentHereAgain : CourseHere.getEnrollStudent()) {
                int CreditsOfThisStudentAgain = useStudentAndCourseToFindCredits(studentHereAgain, CourseHere.getCourseID());
                if (CreditsOfThisStudentAgain >= acquiredCredits) {
                    CourseHere.getSuccessStudents().add(studentHereAgain);
                    studentHereAgain.getSuccessCourses().add(CourseHere);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen) {
            ArrayList<String> strings = new ArrayList<>();
            for (Course courseHereAgain : student.getEnrollCourses()) {
                for (Student studentHere : courseHereAgain.getEnrollStudent()) {
                    if (studentHere.getStudentID().equals(student.getStudentID())) {
                        int index = courseHereAgain.getEnrollStudent().indexOf(studentHere);
                        int creditsHere = courseHereAgain.getCredits().get(index);
                        strings.add(courseHereAgain.getCourseID() + ": " + creditsHere);
                    }
                }
            }
            return strings;
        } else {
            return null;
        }
    }

    private Course useCourseIdToFindCourse(String courseId) {
        for (Course courseHere : courses) {
            if (courseHere.getCourseID().equals(courseId)) {
                return courseHere;
            }
        }
        return null;
    }

    private int useStudentAndCourseToFindCredits(Student student, String courseId) {
        Course courseHere1 = useCourseIdToFindCourse(courseId);
        int index = courseHere1.getEnrollStudent().indexOf(student);
        int credits = courseHere1.getCredits().get(index);
        return credits;
    }
}