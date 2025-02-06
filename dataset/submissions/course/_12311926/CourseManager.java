import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public CourseManager(ArrayList<Course> courses, ArrayList<Student> students, boolean ifOpen) {
        this.courses = courses;
        this.students = students;
        this.ifOpen = ifOpen;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(boolean ifopen) {
        this.ifOpen = ifopen;
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
        if (!ifOpen) {
            return false;
        }

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                return false;
            }
        }
        if (credits <= 0 || credits > student.getCredits()) {
            return false;
        }
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                student.getEnrollCourses().add(courses.get(i));
                courses.get(i).getEnrollStudent().add(student);
                courses.get(i).getCredits().add(credits);
                student.setCredits(student.getCredits() - credits);
                return true;
            }
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            int a = findCredits(student, courseId);
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId) && credits <= (student.getCredits() + a)) {
                student.setCredits(student.getCredits() + a - credits);
                for (int i1 = 0; i1 < student.getEnrollCourses().get(i).getEnrollStudent().size(); i1++) {
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(i1).equals(student)) {
                        student.getEnrollCourses().get(i).getCredits().set(i1, credits);
                    }
                }

                return true;
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                int index = student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student);
                student.getEnrollCourses().get(i).getEnrollStudent().remove(student);
                student.setCredits(student.getCredits() + student.getEnrollCourses().get(i).getCredits().get(index));
                student.getEnrollCourses().get(i).getCredits().remove(index);
                student.getEnrollCourses().remove(student.getEnrollCourses().get(i));
                return true;
            }
        }
        return false;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            if (!courses.get(i).getCredits().isEmpty()) {
                int sum = 0;
                while (sum <= courses.get(i).getMaxCapacity()) {
                    int max = courses.get(i).getCredits().get(0);
                    for (int i1 = 0; i1 < courses.get(i).getCredits().size(); i1++) {
                        if (courses.get(i).getCredits().get(i1) > max) {
                            max = courses.get(i).getCredits().get(i1);
                        }
                    }
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i1 = 0; i1 < courses.get(i).getCredits().size(); i1++) {
                        if (courses.get(i).getCredits().get(i1) == max) {
                            list.add(i1);
                            sum++;
                            courses.get(i).getCredits().set(i1, -1);
                        }
                    }
                    if (sum <= courses.get(i).getMaxCapacity()) {
                        for (int j = 0; j < list.size(); j++) {
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(list.get(j)));
                        }
                    }
                }

                for (int i3 = 0; i3 < students.size(); i3++) {

                    for (int i2 = 0; i2 < courses.get(i).getSuccessStudents().size(); i2++) {
                        if (courses.get(i).getSuccessStudents().get(i2).equals(students.get(i3))) {
                            students.get(i3).getSuccessCourses().add(courses.get(i));
                        }
                    }

                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> list = new ArrayList<>();
        if (!ifOpen) {
        } else {
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                String a = student.getEnrollCourses().get(i).getCourseID();
                int b = findCredits(student, student.getEnrollCourses().get(i).getCourseID());
                String c = a + ": " + b;
                list.add(c);
            }

        }
        return list;
    }


    public int findCredits(Student student, String courseId) {
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                for (int i1 = 0; i1 < student.getEnrollCourses().get(i).getEnrollStudent().size(); i1++) {
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(i1).equals(student)) {
                        return student.getEnrollCourses().get(i).getCredits().get(i1);
                    }
                }
            }
        }
        return -1;
    }

}
