import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if (credits <= 0) {
            return false;
        }

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

        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                return false;
            }
        }

        if (student.getCredits() < credits) {
            return false;
        }
//        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);

        for (Course cours : courses) {
            if (cours.getCourseID().equals(courseId)) {
                student.getEnrollCourses().add(cours);
            }
        }
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;

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

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index < 0) {
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        if (credits - originalCredits > student.getCredits()) {
            return false;
        }
        student.setCredits(student.getCredits() + originalCredits - credits);
        course.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }
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

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        student.setCredits(student.getCredits() + course.getCredits().get(index));
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);

        int ind = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())) {
                ind = i;
                break;
            }
        }
        student.getEnrollCourses().remove(ind);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        int index = -1;
        int credit;
        String name;
        for (Course course : student.getEnrollCourses()) {
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }
            name = course.getCourseID();
            credit = course.getCredits().get(index);
            list.add(name + ": " + credit);
        }
        return list;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            if (course.getCredits().size()<=course.getMaxCapacity()){
                for (Student student : course.getEnrollStudent()) {
                    course.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(course);
                    }
                // no continue, may leak some case.
            }
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < course.getCredits().size(); i++) {
                list1.add(course.getCredits().get(i));
            }
            Collections.sort(list1);

            // bug: the calculation of boundNumber is not robust.
            // This cannot handle the case when list1.size() equals 2 and course.getMaxCapacity() equals 2
            // and two student bid different number of point.
            // Then the top-1 student will be added to success list AGAIN.
            int boundNumber = 0;
            for (int i = list1.size(); i > Math.max(0, list1.size() - course.getMaxCapacity()); i--) {
                if (i-2 >= 0) {
                    boundNumber = list1.get(i - 2) + 1;
                }
            }

            // this would be robust to all case:
            // int boundNumber = 0;
            // if (list1.size()<=course.getMaxCapacity()) 
            //     boundNumber = 0;
            // else 
            //     boundNumber = list1.get(list1.size() - course.getMaxCapacity() - 1) + 1;


            for (int i = 0; i < course.getCredits().size(); i++) {
                int index;
                if (course.getCredits().get(i) >= boundNumber) {
                    index = i;
                    course.getSuccessStudents().add(course.getEnrollStudent().get(index));
                }
            }
            for (Student student : students) {
                if (course.getSuccessStudents().contains(student)) {
                    student.getSuccessCourses().add(course);
                }
            }
        }

    }

}



