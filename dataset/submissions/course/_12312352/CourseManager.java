import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen=ifOpen;
    }
    public boolean getIfOpen() {
        return ifOpen;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public ArrayList<Student> getStudents() {
        return students;
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
        if (credits < 0 || (!this.ifOpen)) return false;
        Course course1 = findCourse(courseId);
        if (course1 == null) return false;
        if (course1.getEnrollStudent().contains(student) || student.getCredits() == 0) return false;
        if (student.getCredits() < credits) return false;
        //if ((students.contains(student))&&(student.getCredits()>0)&&(student.getCredits()>=credits)&&())
        course1.getEnrollStudent().add(student);
        student.setCredits(student.getCredits() - credits);

        student.getEnrollCourses().add(course1);

        course1.getCredits().add(credits);
        return true;
    }
    public void finalizeEnrollments() {
        ifOpen=false;
        setIfOpen(false);
        ArrayList<Student> o = new ArrayList<>(Collections.emptyList());
        a:for (Course c : courses
        ) {
            if (c.getMaxCapacity() == 0) {
                c.setSuccessStudents(o);
                continue;
            }
            int[] array = new int[c.getCredits().size()+2];//why?
            int[] array2 = new int[c.getCredits().size()+2];
            for (int i = 0; i < c.getCredits().size(); i++) {
                array[i] = c.getCredits().get(i);
                array2[i] = i;
            }
            for (int j = 0; j < array.length; j++) {
                for (int i = 0; i < array.length - j - 1; i++) {
                    if (array[i] < array[i + 1]) {
                        int temp = array[i];
                        int temp2 = array2[i];
                        array[i] = array[i + 1];
                        array2[i] = array2[i + 1];
                        array[i + 1] = temp;
                        array2[i + 1] = temp2;
                    }
                }
            }
            int num = c.getMaxCapacity();
            if (num==0 || c.getEnrollStudent().isEmpty()){c.setSuccessStudents(o);
                    continue;}
            ArrayList<Student> p = new ArrayList<>(num+1);
            if(num>=array.length){
                //why
                for (int i = 0; i < array.length; i++) {
                    p.add(c.getEnrollStudent().get(i));
                }
                c.setSuccessStudents(p);
            }
            else{
                do {
                    if (array[num] < array[num - 1]) break;
                    num--;
                    if (num==0){c.setSuccessStudents(o);
                    continue a;}
                } while (true);
            }

            for (int i = 0; i < num; i++) {
                p.add(c.getEnrollStudent().get(array2[i]));
            }
            c.setSuccessStudents(p);
        }
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (credits < 0 || (!this.ifOpen)) return false;
        Course course1 = findCourse(courseId);
        if (course1 == null || !(course1.getEnrollStudent().contains(student))) return false;

        int index = course1.getEnrollStudent().indexOf(student);
        if (student.getCredits() < credits - course1.getCredits().get(index)) return false;
        int origin=course1.getCredits().get(index);
        student.setCredits(student.getCredits()+origin - credits);
        course1.getCredits().set(index,credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) return false;
        Course course1 = findCourse(courseId);
        if (course1 == null || !(course1.getEnrollStudent().contains(student))) return false;
        int index = course1.getEnrollStudent().indexOf(student);
        course1.getEnrollStudent().remove(index);
        student.getEnrollCourses().remove(course1);
        int credit = course1.getCredits().get(index);
        student.setCredits(student.getCredits() + credit);
        course1.getCredits().remove(index);
        return true;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if  (!students.contains(student)) return null;
        if (!this.ifOpen) return null;
        ArrayList<String> a = new ArrayList<>();
        int x = student.getEnrollCourses().size();
        int i = 1;
        while (i <= x) {
            Course course = student.getEnrollCourses().get(i - 1);
            String v1 = String.valueOf(course.getCourseID());
            int index = course.getEnrollStudent().indexOf(student);
            int y = course.getCredits().get(index);
            a.add(v1 + ": " + String.valueOf(y));
            i++;
        }
        return a;
    }
    private Course findCourse(String courseId) {
        for (Course course : courses
        ) {
            if (Objects.equals(course.getCourseID(), courseId))
                return course;
        }
        return null;
    }
}
