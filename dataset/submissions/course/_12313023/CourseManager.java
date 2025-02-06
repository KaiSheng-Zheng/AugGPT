import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private boolean ifOpen;
    public CourseManager() {
        ifOpen = true;
    }

    public CourseManager(ArrayList<Course> courses) {
        this.courses = courses;
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
        course.setCourseManager(this);
        courses.add(course);
    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        students.add(student);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    if (student.getEnrollCourses().size() != 0) {
                        for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                            if (!(student.getEnrollCourses().get(j).getCourseID().equals(courseId))) {
                                if (j == student.getEnrollCourses().size() - 1 && credits > 0 && credits <= student.getCredits()) {
                                    student.setCredits(student.getCredits() - credits);
                                    courses.get(i).getCredits().add(credits);
                                    student.getEnrollCourses().add(courses.get(i));
                                    courses.get(i).getEnrollStudent().add(student);
                                    return true;
                                }
                            }
                        }
                    } else {
                        if (credits > 0 && credits <= student.getCredits()) {
                            student.setCredits(student.getCredits() - credits);
                            courses.get(i).getCredits().add(credits);
                            student.getEnrollCourses().add(courses.get(i));
                            courses.get(i).getEnrollStudent().add(student);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                        if (student.getEnrollCourses().get(j).getCourseID().equals(courseId)) {
                            if (student.getCredits() + courses.get(i).getCredits().get(courses.get(i).getEnrollStudent().indexOf(student)) >= credits) {
                                student.setCredits(student.getCredits() + courses.get(i).getCredits().get(courses.get(i).getEnrollStudent().indexOf(student)));
                                student.setCredits(student.getCredits() - credits);
                                courses.get(i).getCredits().set(courses.get(i).getEnrollStudent().indexOf(student), credits);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                        if (student.getEnrollCourses().get(j).getCourseID().equals(courseId)) {
                            student.setCredits(student.getCredits() + courses.get(i).getCredits().get(courses.get(i).getEnrollStudent().indexOf(student)));
                            student.getEnrollCourses().remove(j);
                            courses.get(i).getCredits().remove(courses.get(i).getEnrollStudent().indexOf(student));
                            courses.get(i).getEnrollStudent().remove(student);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            select(courses.get(i));
        }
    }

    public void select(Course course) {
        int max = 0;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            max = max(course);
            int temp = 0;
            for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                if (max == course.getCredits().get(j)) {
                    temp++;
                }
                if (j == course.getEnrollStudent().size()-1) {
                    if (temp + course.getSuccessStudents().size() <= course.getMaxCapacity()) {
                        for (int k = 0; k < course.getEnrollStudent().size(); k++) {
                            if (max == course.getCredits().get(k)) {
                                course.getSuccessStudents().add(course.getEnrollStudent().get(k));
                                course.getEnrollStudent().get(k).getSuccessCourses().add(course);
                                course.getCredits().set(k, 0);
                            }
                        }
                    }
                }
            }
        }
    }

    public int max(Course course) {
        int max = 0;
        for (int i = 0; i < course.getCredits().size(); i++) {
            if (max < course.getCredits().get(i)) {
                max = course.getCredits().get(i);
            }
        }
        return max;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen) {
            ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                enrolledCoursesWithCredits.add(student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student)));
            }
            return enrolledCoursesWithCredits;
        }
        return null;
    }
}
