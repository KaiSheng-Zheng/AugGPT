import java.util.ArrayList;
import java.util.Objects;

class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public CourseManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        this.ifOpen = true;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean ifCourseExist(String courseId) {
        for (Course c : courses) {
            if (courseId.equals(c.getCourseID())) {
                return true;
            }
        }
        return false;
    }

    public Course getCourse(String courseId) {
        for (Course c : courses) {
            if (courseId.equals(c.getCourseID())) {
                return c;
            }
        }
        return null;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (ifCourseExist(courseId) && !getCourse(courseId).getEnrollStudent().contains(student) && student.getCredits() >= credits && credits > 0) {
            int p = student.getCredits();
            student.setCredits(p - credits);
            getCourse(courseId).getEnrollStudent().add(student);
            getCourse(courseId).getCredits().add(credits);
            student.getEnrollCourses().add(getCourse(courseId));
            return true;
        } else return false;
    }

    public int getStudentCreditsForCourselc(Student student, String courseId) {
        int k = 0;
        if (!getCourse(courseId).getEnrollStudent().isEmpty()) {
            for (int i = 0; i <= getCourse(courseId).getEnrollStudent().size() - 1; i++) {
                if (student.equals(getCourse(courseId).getEnrollStudent().get(i))) {
                    k = i;
                }
            }
        }
        return k;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (ifCourseExist(courseId) && getCourse(courseId).getEnrollStudent().contains(student) && credits <= (student.getCredits() + getCourse(courseId).getCredits().get(getStudentCreditsForCourselc(student, courseId))) && credits > 0) {
            int r = student.getCredits() + getCourse(courseId).getCredits().get(getStudentCreditsForCourselc(student, courseId)) - credits;
            student.setCredits(r);
            getCourse(courseId).getCredits().set(getStudentCreditsForCourselc(student, courseId), credits);
            return true;
        } else return false;
    }

    public int getStudentCourseLocation(Student student, String courseId) {
        int k = 0;
        for (int i = 0; i <= student.getEnrollCourses().size() - 1; i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                k = i;
            }
        }
        return k;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        if (ifCourseExist(courseId) && getCourse(courseId).getEnrollStudent().contains(student)) {
            int u = getStudentCreditsForCourselc(student, courseId);
            int v = getStudentCourseLocation(student, courseId);
            int r = student.getCredits() + getCourse(courseId).getCredits().get(u);
            student.setCredits(r);
            getCourse(courseId).getEnrollStudent().remove(u);
            getCourse(courseId).getCredits().remove(u);
            student.getEnrollCourses().remove(v);
            return true;
        } else return false;
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;
        int temp1, temp2;

        for (Course w : courses) {
            if (!w.getEnrollStudent().isEmpty()) {
                if (w.getEnrollStudent().size() <= w.getMaxCapacity()) {
                    for (int i = 0; i <= w.getEnrollStudent().size() - 1; i++) {
                        w.getSuccessStudents().add(w.getEnrollStudent().get(i));
                        w.getEnrollStudent().get(i).getSuccessCourses().add(w);
                    }
                } else {
                    ArrayList<Integer> copy = new ArrayList<>();
                    ArrayList<Integer> copyIndex = new ArrayList<>();
                    copy = w.getCredits();
                    for (int i = 0; i <= copy.size() - 1; i++) {
                        copyIndex.add(i);
                    }
                    for (int i = 0; i < copy.size() - 1; i++) {
                        for (int j = 0; j < copy.size() - 1; j++) {
                            if (copy.get(j) < copy.get(j + 1)) {
                                temp1 = copy.get(j);
                                temp2 = copy.get(j + 1);
                                copy.set(j, temp2);
                                copy.set(j + 1, temp1);
                                temp1 = copyIndex.get(j);
                                temp2 = copyIndex.get(j + 1);
                                copyIndex.set(j, temp2);
                                copyIndex.set(j + 1, temp1);
                            }
                        }
                    }
                    if (copy.get(w.getMaxCapacity() - 1).equals(copy.get(w.getMaxCapacity()))) {
                        int equal = copy.get(w.getMaxCapacity());
                        for (int i = w.getMaxCapacity(); i <= copy.size() - 1; i++) {
                            copy.remove(i);
                            copyIndex.remove(i);
                            i--;
                        }
                        for (int i = 0; i <= copy.size() - 1; i++) {
                            if (copy.get(i) == equal){
                                copy.remove(i);
                                copyIndex.remove(i);
                                i--;
                            }
                        }
                    } else {
                        for (int i = w.getMaxCapacity(); i <= copy.size() - 1; i++) {
                            copy.remove(i);
                            copyIndex.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i <= copy.size() - 1; i++) {
                        w.getSuccessStudents().add(w.getEnrollStudent().get(copyIndex.get(i)));
                        w.getEnrollStudent().get(copyIndex.get(i)).getSuccessCourses().add(w);
                    }
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> retrieves = new ArrayList<>();
        for (int i = 0; i <= student.getEnrollCourses().size() - 1; i++) {
            retrieves.add(student.getEnrollCourses().get(i).getCourseID() + ": " + String.valueOf(getCourse(student.getEnrollCourses().get(i).getCourseID()).getCredits().get(getStudentCreditsForCourselc(student, student.getEnrollCourses().get(i).getCourseID()))));
        }
        return retrieves;
    }
}