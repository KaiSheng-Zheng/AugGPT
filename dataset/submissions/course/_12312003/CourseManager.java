import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
        ifOpen = true;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    Scanner input = new Scanner(System.in);

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen || credits <= 0)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        Course tempCourse1 = null;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course tempCourse2 = student.getEnrollCourses().get(i);
            if (tempCourse2.getCourseID().equals(courseId)) {
                tempCourse1 = tempCourse2;
                break;
            }
        }
        if (tempCourse1 != null)
            return false;
        if (student.getCredits() < credits) {
            return false;
        }
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        int courseIndex = courses.indexOf(course);
        student.getEnrollCourses().add(courses.get(courseIndex));
        student.setCredits(student.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseID, int credits) {
        if (!this.ifOpen || credits <= 0)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseID)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        Course tempCourse1 = null;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course tempCourse2 = student.getEnrollCourses().get(i);
            if (tempCourse2.getCourseID().equals(courseID)) {
                tempCourse1 = tempCourse2;
                break;
            }
        }
        if (tempCourse1 == null)
            return false;
        int index = -1;
        int credit1;
        index = course.getEnrollStudent().indexOf(student);
        credit1 = course.getCredits().get(index);
        if (credit1 + student.getCredits() < credits)
            return false;

        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + credit1 - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;
        Course tempCourse1 = null;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course tempCourse2 = student.getEnrollCourses().get(i);
            if (tempCourse2.getCourseID().equals(courseId)) {
                tempCourse1 = tempCourse2;
                break;
            }
        }
        if (tempCourse1 == null)
            return false;
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        student.setCredits(student.getCredits() + course.getCredits().get(index));
        student.getEnrollCourses().remove(course);
        course.getEnrollStudent().remove(student);
        course.getCredits().remove(index);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course cours : this.courses) {
            if (cours.getCredits() != null) {
                ArrayList<Integer> cloneCredits = (ArrayList<Integer>)cours.getCredits().clone();
                cloneCredits.sort(Collections.reverseOrder());
                if (cloneCredits.size()<=cours.getMaxCapacity()){
                    for (int i = 0; i < cloneCredits.size(); i++) {
                        cours.getSuccessStudents().add(cours.getEnrollStudent().get(i));
                        cours.getEnrollStudent().get(i).getSuccessCourses().add(cours);
                    }
                }
                if (cloneCredits.size()>cours.getMaxCapacity()) {
                    int successCredit = cloneCredits.get(cours.getMaxCapacity()-1);
                    if (cloneCredits.get(cours.getMaxCapacity()) == successCredit) {
                        successCredit = successCredit + 1;
                    }
                    int successNum = 0;
                    for (int j = 0; j < cours.getCredits().size() && successNum < cours.getMaxCapacity(); j++) {
                            if (cours.getCredits().get(j) >= successCredit) {
                            cours.getSuccessStudents().add(cours.getEnrollStudent().get(j));
                            cours.getEnrollStudent().get(j).getSuccessCourses().add(cours);
                            successNum+=1;
                        }
                    }
                }
            }
        }
        }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen)
            return null;
        ArrayList<String> getEnrolledCoursesWithCredits = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            int index = 0;
            for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                if (student.getStudentID().equals(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID())) {
                    index = j;
                    break;
                }
            }
            getEnrolledCoursesWithCredits.add(student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(index));
        }
        return getEnrolledCoursesWithCredits;
    }
}
