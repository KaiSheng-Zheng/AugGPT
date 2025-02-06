import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
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
            }
        }
        if (course == null) {
            return false;
        }
        Course enrollcourse = null;
        for (Course d : student.getEnrollCourses()) {
            if (d.getCourseID().equals(courseId))
                enrollcourse = d;
        }
        if (enrollcourse != null)
            return false;
        if (student.getCredits() < credits)
            return false;
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
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
        if(index==-1)
            return false;
        int originalCredits = course.getCredits().get(index);
        course.getCredits().set(index, credits);
        // no boundary check! will decrease to negative credit
        student.setCredits( student.getCredits() + originalCredits - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen)
            return false;

        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
            }
        }
        if (course == null) {
            return false;
        }

        if (!student.getEnrollCourses().contains(course)) {
            return false;
        }


        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if(index==-1)
            return false;
        int originalCredits = course.getCredits().get(index);
        student.setCredits(student.getCredits() + originalCredits);
        student.getEnrollCourses().remove(course);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);
        return true;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen)
            return null;
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = -1;
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }
            if(index==-1)
                break;
            enrolledCoursesWithCredits.add(course.getCourseID() + ": " + course.getCredits().get(index));
        }

        return enrolledCoursesWithCredits;
    }

    public void finalizeEnrollments() {
        for (Course course : getCourses()) {
            int r=0;
            bubbleSort(course,course.getEnrollStudent());
            for (int x = 0; x < 500; x++) {
                int t = 0;
                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                    if (course.getCredits().get(i) >= x)
                        t += 1;
                }
                if(t<=course.getMaxCapacity()){
                    r=t;
                    break;
                }
            }
            for (int i = 0; i < r; i++) {
                Student student = course.getEnrollStudent().get(i);
                student.getSuccessCourses().add(course);
                course.getSuccessStudents().add(student);
            }
            course.getEnrollStudent().subList(0, r).clear();
        }
        setIfOpen(false);
    }

        public static void bubbleSort(Course course,ArrayList<Student> students) {
            for (int i = 0; i < students.size()-1; i++) {
                for (int j = 0; j < students.size()-1-i; j++) {
                    if (course.getCredits().get(j) < course.getCredits().get(j+1)) {
                        Student temp = course.getEnrollStudent().get(j);
                        course.getEnrollStudent().set(j, course.getEnrollStudent().get(j + 1));
                        course.getEnrollStudent().set(j + 1, temp);
                        int k=course.getCredits().get(j);
                        course.getCredits().set(j,course.getCredits().get(j+1));
                        course.getCredits().set(j+1,k);
                    }
                }
            }


        }}


