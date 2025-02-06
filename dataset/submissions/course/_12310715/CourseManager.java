import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
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
        course.setCourseManager(this);
        courses.add(course);
    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        students.add(student);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        Course course = searchCourse(courseId);

        if (!ifOpen || course == null || student == null || credits <= 0 || credits > student.getCredits() || course.getEnrollStudent().contains(student)) {
            return false;
        }

        student.setCredits(student.getCredits() - credits);

        ArrayList<Course> tempListC = student.getEnrollCourses();
        tempListC.add(searchCourse(courseId));
        ArrayList<Student> tempListS = course.getEnrollStudent();
        tempListS.add(student);
        student.setEnrollCourses(tempListC);
        course.setEnrollStudent(tempListS);

        ArrayList<Integer> tempListI = course.getCredits();
        tempListI.add(credits);
        course.setCredits(tempListI);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course course = searchCourse(courseId);

        if (!ifOpen || course == null || student == null || !course.getEnrollStudent().contains(student) || credits <= 0 || credits > student.getCredits() + getCredits(courseId, student)) {
            return false;
        }

        student.setCredits(student.getCredits() +(getCredits(courseId, student) - credits));

        int index = course.getEnrollStudent().indexOf(student);

        ArrayList<Integer> tempListI = course.getCredits();
        tempListI.set(index, credits);
        course.setCredits(tempListI);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseID) {
        Course course = searchCourse(courseID);

        if (course == null || student == null || !course.getEnrollStudent().contains(student)) {
            return false;
        }

        if (ifOpen) {
            student.setCredits(student.getCredits() + getCredits(courseID, student));
        }

        ArrayList<Course> tempListC = student.getEnrollCourses();
        ArrayList<Student> tempListS = course.getEnrollStudent();
        ArrayList<Integer> tempListI = course.getCredits();

        tempListI.remove(tempListS.indexOf(student));
        tempListC.remove(course);
        tempListS.remove(student);

        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        for (Course course : courses) {
            int capability = course.getMaxCapacity();

            while (course.getEnrollStudent().size() > capability) {
                ArrayList<Integer> tempListI = course.getCredits();
                ArrayList<Student> tempListS = course.getEnrollStudent();
                ArrayList<Integer> tempListIndex = new ArrayList<>();
                int minCredit = Collections.min(tempListI);

                for (int i = 0; i < tempListI.size(); i++) {
                    if (tempListI.get(i) == minCredit) {
                        tempListIndex.add(i);
                    }
                }
                Collections.sort(tempListIndex);
                int counter = 0;

                for (int index : tempListIndex) {
                    tempListI.remove(index-counter);
                    tempListS.remove(index-counter);
                    counter++;
                }

                course.setCredits(tempListI);
                course.setEnrollStudent(tempListS);
            }

            for (Student student : course.getEnrollStudent()) {
                ArrayList<Course> tempListC = student.getSuccessCourses();
                tempListC.add(course);
                student.setSuccessCourses(tempListC);

                ArrayList<Student> tempListS= course.getSuccessStudents();
                tempListS.add(student);
                course.setSuccessStudents(tempListS);
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }

        ArrayList<String> tempList = new ArrayList<>();

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            String courseId = student.getEnrollCourses().get(i).getCourseID();
            int credits = getCredits(courseId, student);
            tempList.add(String.format("%s: %d", courseId,credits));
        }

        return tempList;
    }

    private Course searchCourse(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }

        return null;
    }

    private int getCredits(String courseId, Student student) {
        Course course = searchCourse(courseId);
        String studentId = student.getStudentID();
        if (course == null) {
            return 0;
        }

        int index = 0;
        for (Student tempStudent : students) {
            if (tempStudent.getStudentID().equals(studentId)) {
                index = course.getEnrollStudent().indexOf(tempStudent);
                break;
            }
        }

        return course.getCredits().get(index);
    }

}
