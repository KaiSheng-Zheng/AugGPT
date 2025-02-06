import java.util.ArrayList;

public class CourseManager {

    private final ArrayList<Course> courses;
    private final ArrayList<Student> students;
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
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        Course course = findCourseById(courseId);
        if (course == null || student.getEnrollCourses().contains(course) || credits <= 0 || student.getCredits() < credits)
            return false;

        student.modifyCredits(-credits);
        student.addEnrollCourse(course);
        student.modifySuccessCourses(course, true);

        course.addEnrollStudent(student);
        course.addCredits(credits);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        Course course = findCourseById(courseId);
        if (course == null || !student.getEnrollCourses().contains(course) || credits <= 0 || student.getCredits() < credits)
            return false;

        int index = student.getEnrollCourses().indexOf(course);
        int previousCredits = course.getCredits().get(index);

        student.modifyCredits(previousCredits - credits);
        student.modifyEnrollCourseCredits(course, credits);

        course.modifyCredits(index, credits);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;
        Course course = findCourseById(courseId);
        if (course == null || !student.getEnrollCourses().contains(course))
            return false;

        int index = student.getEnrollCourses().indexOf(course);
        int credits = course.getCredits().get(index);

        student.modifyCredits(credits);
        student.removeEnrollCourse(course);
        student.modifySuccessCourses(course, false);

        course.removeEnrollStudent(student);
        course.removeCredits(index);

        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            ArrayList<Student> enrollStudents = course.getEnrollStudents();
            ArrayList<Integer> credits = course.getCredits();
            int capacity = course.getMaxCapacity();
            int totalCredits = 0;


            for (int i = 0; i < enrollStudents.size(); i++) {
                for (int j = i + 1; j < enrollStudents.size(); j++) {
                    if (credits.get(i) < credits.get(j)) {
                        Student tempStudent = enrollStudents.get(i);
                        int tempCredits = credits.get(i);

                        enrollStudents.set(i, enrollStudents.get(j));
                        credits.set(i, credits.get(j));

                        enrollStudents.set(j, tempStudent);
                        credits.set(j, tempCredits);
                    }
                }
            }


            int lastIndex = -1;
            for (int i = 0; i < enrollStudents.size() && i < capacity; i++) {
                if (i > 0 && credits.get(i) == credits.get(i - 1)) {
        
                    continue;
                }
                lastIndex = i;
                totalCredits += credits.get(i);
                course.addSuccessStudent(enrollStudents.get(i));
            }

        
            for (int i = lastIndex + 1; i < enrollStudents.size(); i++) {
                enrollStudents.get(i).modifyCredits(credits.get(i));
            }
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = student.getEnrollCourses().indexOf(course);
            enrolledCoursesWithCredits.add(course.getCourseID() + ": " + student.getCreditsForCourse(index));
        }
        return enrolledCoursesWithCredits;
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId))
                return course;
        }
        return null;
    }
}
