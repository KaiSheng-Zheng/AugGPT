import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        ifOpen = true;
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
// getter for students

    public ArrayList<Course> getCourses() {
        return courses;
    }
// getter for courses

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
// setter for ifOpen

    public boolean getIfOpen() {
        return ifOpen;
    }
// getter for ifOpen

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        Course course = null;
        boolean courseExist = false;
        for (Course courseTest : courses) {
            if (courseTest.getCourseID().equals(courseId)) {
                courseExist = true;
                course = courseTest;
                break;
            }
        }
        if (!courseExist) return false;
        if (course.getEnrollStudent().contains(student)) return false;
        if (!(0 < credits && credits <= student.getCredits())) return false;
        student.setCredits(student.getCredits() - credits);

        ArrayList<Student> EnrollStudentList = course.getEnrollStudent();
        EnrollStudentList.add(student);

        ArrayList<Course> EnrollCourseList = student.getEnrollCourses();
        EnrollCourseList.add(course);

        ArrayList<Integer> CreditsList = course.getCredits();
        CreditsList.add(credits);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        Course course = null;
        boolean courseExist = false;
        for (Course courseTest : courses) {
            if (courseTest.getCourseID().equals(courseId)) {
                courseExist = true;
                course = courseTest;
                break;
            }
        }
        if (!courseExist) return false;
        if (!course.getEnrollStudent().contains(student)) return false;
        int creditOld = course.getCredits().get(course.getEnrollStudent().indexOf(student));
        if (student.getCredits() + creditOld < credits) return false;
        ArrayList<Integer> CreditsList = course.getCredits();
        CreditsList.set(course.getEnrollStudent().indexOf(student), credits);

        student.setCredits(student.getCredits() + creditOld - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;
        Course course = null;
        boolean courseExist = false;
        for (Course courseTest : courses) {
            if (courseTest.getCourseID().equals(courseId)) {
                courseExist = true;
                course = courseTest;
                break;
            }
        }
        if (!courseExist) return false;
        if (!course.getEnrollStudent().contains(student)) return false;
        int creditOld = course.getCredits().get(course.getEnrollStudent().indexOf(student));

        ArrayList<Integer> CreditsList = course.getCredits();
        CreditsList.remove(course.getEnrollStudent().indexOf(student));

        ArrayList<Student> EnrollStudentList = course.getEnrollStudent();
        EnrollStudentList.remove(student);

        ArrayList<Course> EnrollCourseList = student.getEnrollCourses();
        EnrollCourseList.remove(course);

        student.setCredits(student.getCredits() + creditOld);
        return true;
    }

    public void finalizeEnrollments() {
        if (!ifOpen) return;
        ifOpen = false;
        for (Course course : courses) {
            int minEnrollCredit = 1;
            ArrayList<Integer> creditsList = new ArrayList<>(course.getCredits());
            while (creditsList.size() > course.getMaxCapacity()) {
                for (int i = 0; i < creditsList.size(); i++) {
                    if (creditsList.get(i) == minEnrollCredit) {
                        creditsList.remove(i);
                        i--;
                    }
                }
                minEnrollCredit++;
            }
            ArrayList<Student> successStudent = new ArrayList<>();
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                Student student = course.getEnrollStudent().get(i);
                if (course.getCredits().get(i) >= minEnrollCredit) {
                    successStudent.add(student);
                    ArrayList<Course> successCourses = student.getSuccessCourses();
                    successCourses.add(course);
                }
            }
            course.setSuccessStudents(successStudent);
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;
        String courseID;
        int credit;
        Course course;
        ArrayList<String> getEnrolledCoursesWithCreditsList = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            course = student.getEnrollCourses().get(i);
            courseID = student.getEnrollCourses().get(i).getCourseID();
            credit = course.getCredits().get(course.getEnrollStudent().indexOf(student));
            getEnrolledCoursesWithCreditsList.add(String.format("%s: %d", courseID, credit));
        }
        return getEnrolledCoursesWithCreditsList;
    }
}