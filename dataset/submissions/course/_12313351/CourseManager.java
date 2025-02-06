import java.util.ArrayList;
import java.util.Comparator;

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

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course courses) {
        this.courses.add(courses);
        courses.setCourseManager(this);
    }

    public void addStudent(Student students) {
        this.students.add(students);
        students.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        } else {
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
            if (credits <= 0) {
                return false;
            }
            if (student.getCredits() < credits) {
                return false;
            }
            if (student.getEnrollCourses().contains(course)) {
                return false;
            }
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(course);
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            return true;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen == false) {
            return false;
        } else {
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
            if (!student.getEnrollCourses().contains(course)) {
                return false;
            }
            if (credits <= 0) {
                return false;
            }
            //missing boundary check on whether student have enough credit to bid.
            student.setCredits(student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)) - credits);
            course.getCredits().set(course.getEnrollStudent().indexOf(student), credits);
            return true;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        } else {
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
            if (!student.getEnrollCourses().contains(course)) {
                return false;
            }
            int studentIndex = course.getEnrollStudent().indexOf(student);
            if (studentIndex == -1) {
                return false;
            }
            student.setCredits(student.getCredits() + course.getCredits().get(studentIndex));
            student.getEnrollCourses().remove(course);
            course.getCredits().remove(studentIndex);
            course.getEnrollStudent().remove(student);
            return true;
        }
    }
    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            if (course.getMaxCapacity() >= course.getEnrollStudent().size()) {
                for (Student student : course.getEnrollStudent()) {
                    student.getSuccessCourses().add(course);
                    course.getSuccessStudents().add(student);
                }
            }
            if (course.getMaxCapacity() < course.getEnrollStudent().size()) {
                ArrayList<Integer> inputCredits = new ArrayList<>();
                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                    inputCredits.add(course.getCredits().get(i));
                }
                inputCredits.sort(Comparator.reverseOrder());

                if (inputCredits.get(course.getMaxCapacity() - 1) != inputCredits.get(course.getMaxCapacity())) {
                    for (int i = 0; i < course.getMaxCapacity(); i++) {
                        int time = 0;
                        for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                            if (course.getCredits().get(j).equals(inputCredits.get(i))) {
                                course.getEnrollStudent().get(j).getSuccessCourses().add(course);
                                course.getSuccessStudents().add(course.getEnrollStudent().get(j));
                                time++;
                            }
                        }
                        i += time - 1;
                    }
                } else {
                    int maxSatisfy = 0;
                    for (int i = 0; i < inputCredits.get(course.getMaxCapacity()); i++) {
                        if (inputCredits.get(i).equals(inputCredits.get(course.getMaxCapacity() - 1))) {
                            maxSatisfy = i;
                            break;
                        }
                    }
                    if (maxSatisfy == 0) {
                        course.getSuccessStudents().isEmpty();
                    } else {
                        for (int j = 0; j < maxSatisfy; j++) {
                            for (int k = 0; k < course.getCredits().size(); k++) {
                                if (course.getCredits().get(k).equals(inputCredits.get(j))) {
                                    course.getSuccessStudents().add(course.getEnrollStudent().get(k));
                                    course.getEnrollStudent().get(k).getSuccessCourses().add(course);
                                    course.getCredits().set(k, -1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen == false) {
            return new ArrayList<>();
        } else {
            ArrayList<String> result = new ArrayList<>();
            for (Course course : student.getEnrollCourses()) {
                if (student.getEnrollCourses().indexOf(course)!=-1){
                    result.add(course.getCourseID() + ": " + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
                }
            }
            return result;
        }
    }
}