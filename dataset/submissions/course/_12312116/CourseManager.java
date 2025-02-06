import java.util.ArrayList;
import java.util.Arrays;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
//        Student.setCourseManager(this);
    }

    public void addStudent(Student students) {
        this.students.add(students);
        students.setCourseManager(this);
    }

    public void addCourse(Course courses) {
        this.courses.add(courses);
        courses.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {

        Course course = null;

        //Determine whether the course is valid
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (course == null) {
            return false;
        }

        //Determine whether the student has enrolled in this course
        for (Course c : student.getEnrollCourses()) {
            if (c.equals(course)) {
                return false;
            }
        }

        if (!ifOpen || credits <= 0 || student.getCredits() - credits < 0) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);

        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;

    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {

        Course course = null;

        //Determine whether the course is valid
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (course == null) {
            return false;
        }

        //Determine whether the student has enrolled in this course
        int id = 0;
        boolean flag = false;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                flag = true;
                id = i;
            }
        }

        if (!ifOpen || credits <= 0 || !flag || student.getCredits() + course.getCredits().get(id) - credits < 0) {
            return false;
        }

        student.setCredits(student.getCredits() + course.getCredits().get(id) - credits);
        course.getCredits().set(id, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {

        Course course = null;

        //Determine whether the course is valid
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (course == null) {
            return false;
        }

        //Determine whether the student has enrolled in this course
        int id = 0;
        boolean flag = false;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                flag = true;
                id = i;
                break;
            }
        }

        if (!ifOpen || !flag) {
            return false;
        }

        student.setCredits(student.getCredits() + course.getCredits().get(id));
        student.getEnrollCourses().remove(course);
        course.getCredits().remove(id);
        course.getEnrollStudent().remove(id);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {

        if (!ifOpen) {
            return null;
        }

        ArrayList<String> toCredits = new ArrayList<String>();
        for (Course c : student.getEnrollCourses()) {
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (c.getEnrollStudent().get(i).equals(student)) {
                    toCredits.add(c.getCourseID() + ": " + c.getCredits().get(i));
                    break;
                }
            }
        }
        return toCredits;

    }

    public void finalizeEnrollments() {
        setIfOpen(false);

        int[] theirCredits1;
        for (int i = 0; i < this.courses.size(); i++) {
            ArrayList<Student> enrollStudent = this.courses.get(i).getEnrollStudent();
            ArrayList<Integer> theirCredits = this.courses.get(i).getCredits();
            theirCredits1 = new int[theirCredits.size()];
            for (int j = 0; j < theirCredits1.length; j++) {
                theirCredits1[j] = theirCredits.get(j);
            }

            Arrays.sort(theirCredits1);
            
            for (int j = 0, k = theirCredits1.length - 1; j < k; j++, k--) {
                int temp = theirCredits1[j];
                theirCredits1[j] = theirCredits1[k];
                theirCredits1[k] = temp;
            }

            int edge = 0;
            if (theirCredits.size() > this.courses.get(i).getMaxCapacity()) {
                edge = theirCredits1[this.courses.get(i).getMaxCapacity() - 1];
            }

            int count = 0;
            for (int j = 0; j < theirCredits.size(); j++) {
                if (theirCredits.get(j) >= edge) {
                    count++;
                }
            }

            for (int j = 0; j < theirCredits.size(); j++) {
                if (count <= this.courses.get(i).getMaxCapacity()) {
                    if (theirCredits.get(j) >= edge){
                        this.courses.get(i).getSuccessStudents().add(enrollStudent.get(j));
                        enrollStudent.get(j).getEnrollCourses().add(this.courses.get(i));
                    }
                } else {
                    edge++;
                    if (theirCredits.get(j) >= edge){
                        this.courses.get(i).getSuccessStudents().add(enrollStudent.get(j));
                        enrollStudent.get(j).getEnrollCourses().add(this.courses.get(i));
                    }
                    edge--;
                }
            }
        }
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

}

