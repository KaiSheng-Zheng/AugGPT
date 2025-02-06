import java.util.ArrayList;
import java.util.Comparator;

class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        ifOpen = false;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
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
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        Course thisCourse = null;
        boolean ifFind = false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                thisCourse = c;
                ifFind = true;
                break;
            }
        }
        if (this.ifOpen &&
                ifFind &&
                !student.getEnrollCourses().contains(thisCourse) &&
                credits > 0 &&
                credits <= student.getCredits()) {
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(thisCourse);
            thisCourse.getEnrollStudent().add(student);
            thisCourse.getCredits().add(credits);
            return true;
        } else {
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course thisCourse = null;
        int index = 0;
        boolean ifFind = false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                thisCourse = c;
                ifFind = true;
                break;
            }
        }
        if (this.ifOpen &&
                ifFind &&
                student.getEnrollCourses().contains(thisCourse) &&
                (credits <= thisCourse.getCredits().get(thisCourse.getEnrollStudent().indexOf(student)) + student.getCredits()) &&
                credits > 0) {
            index = thisCourse.getEnrollStudent().indexOf(student);
            student.setCredits(student.getCredits() + thisCourse.getCredits().get(index) - credits);
            thisCourse.getCredits().set(index, credits);
            return true;
        } else {
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course thisCourse = null;
        int index = 0;
        boolean ifFind = false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                thisCourse = c;
                ifFind = true;
                break;
            }
        }
        if (this.ifOpen &&
                ifFind &&
                student.getEnrollCourses().contains(thisCourse)) {
            index = thisCourse.getEnrollStudent().indexOf(student);
            student.setCredits(student.getCredits() + thisCourse.getCredits().get(index));
            student.getEnrollCourses().remove(thisCourse);
            thisCourse.getEnrollStudent().remove(index);
            thisCourse.getCredits().remove(index);
            return true;
        } else {
            return false;
        }
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (Course c : courses) {
            int cap = c.getMaxCapacity();
            if (c.getMaxCapacity() >= c.getEnrollStudent().size()) {
                c.setSuccessStudents(c.getEnrollStudent());
                c.getEnrollStudent().forEach((e) -> {
                    e.getSuccessCourses().add(c);
                });
                continue;
            } else {
                ArrayList<Integer> k = new ArrayList<Integer>(c.getCredits());
                k.sort(Comparator.reverseOrder());
                int endCredit = k.get(cap);
                if (k.lastIndexOf(endCredit) == cap - 1) {
                    c.setSuccessStudents(c.getEnrollStudent());
                    c.getEnrollStudent().forEach((e) -> {
                        e.getSuccessCourses().add(c);
                    });
                    continue;
                } else {
                    for(int i=0;i<c.getEnrollStudent().size();i++){
                        if (c.getCredits().get(i) > endCredit) {
                            c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                            c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                        }
                    }
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen) {
            ArrayList<String> ans = new ArrayList<>();
            student.getEnrollCourses().forEach((c) -> {
                ans.add(String.format("%s: %d", c.getCourseID(), c.getCredits().get(c.getEnrollStudent().indexOf(student))));
            });
            return ans;
        } else {
            return null;
        }
    }
}
