import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings("ALL")
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    //Constructor
    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    //Methods
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

    public boolean enrollStudentInCourse(Student student, String CourseID, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        for (Course course : courses) {
            if (course.getCourseID().equals(CourseID)) {
                if (course.getEnrollStudent().contains(student)) {
                    return false;
                }
                if (student.getCredits() - credits >= 0) {
                    student.setCredits(student.getCredits() - credits);
                    student.getEnrollCourses().add(course);
                    course.getEnrollStudent().add(student);
                    course.getCredits().add(credits);
                    return true;
                }
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
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                int index = course.getEnrollStudent().indexOf(student);
                if (index == -1) {
                    return false;
                }
                if (credits == course.getCredits().get(index)) {
                    return false;
                }
                if (student.getCredits() + course.getCredits().get(index) - credits >= 0) {
                    student.setCredits(student.getCredits() + course.getCredits().get(index) - credits);
                    course.getCredits().set(index, credits);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                int index = course.getEnrollStudent().indexOf(student);
                if (index == -1) {
                    return false;
                }
                int temp = course.getCredits().get(index);
                student.setCredits(student.getCredits() + temp);
                course.getCredits().remove(course.getEnrollStudent().indexOf(student));
                course.getEnrollStudent().remove(student);
                student.getEnrollCourses().remove(course);
                return true;
            }
        }
        return false;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            ArrayList<Integer> courseCredits = course.getCredits();
            ArrayList<Student> courseStudents = course.getEnrollStudent();
            // Bubble sort
            for (int i = 0; i < courseCredits.size() - 1; i++) {
                for (int j = 0; j < courseCredits.size() - 1 - i; j++) {
                    if (courseCredits.get(j) < courseCredits.get(j + 1)) {
                        // Swap credits.get(j) and credits.get(j + 1)
                        int temp = courseCredits.get(j);
                        courseCredits.set(j, courseCredits.get(j + 1));
                        courseCredits.set(j + 1, temp);

                        // Swap corresponding students in enrollStudent list
                        Student tempStudent = courseStudents.get(j);
                        courseStudents.set(j, courseStudents.get(j + 1));
                        courseStudents.set(j + 1, tempStudent);
                    }
                }
            }

            ArrayList<Student> tempStudent = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < courseCredits.size(); i++) {
                int temp = 0;
                temp++;
                while (i + 1 < courseCredits.size() && Objects.equals(courseCredits.get(i), courseCredits.get(i + 1))) {
                    i++;
                    temp++;
                }
                if (count + temp > course.getMaxCapacity()) {
                    break;
                } else {
                    for (int j = count; j < count + temp; j++) {
                        tempStudent.add(courseStudents.get(j));
                    }
                    count += temp;
                }
            }
            course.setSuccessStudents(tempStudent);
        }
        for (Student student : students) {
            ArrayList<Course> tempCourse = new ArrayList<>();
            for (Course course : student.getEnrollCourses()) {
                if (course.getSuccessStudents().contains(student)) {
                    tempCourse.add(course);
                }
            }
            student.setSuccessCourses(tempCourse);
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrollCWC = new ArrayList<>();
        for (Course course : courses) {
            if (course.getEnrollStudent().contains(student)) {
                enrollCWC.add(course.getCourseID() + ": " + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
            }
        }
        return enrollCWC;
    }

}