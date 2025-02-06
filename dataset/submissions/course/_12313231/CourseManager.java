import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
public  class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        ifOpen = true;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public  int findstudent(String studentid){int i;
        for (i=0;i<students.size();i++){
            if(Objects.equals(students.get(i).getStudentID(), studentid)){
                break;
            }
        }return i;
    }
    public  int findcourse(String courseid){int i;
        for (i=0;i<courses.size();i++){
            if(Objects.equals(courses.get(i).getCourseID(), courseid)){
                break;
            }
        }return i;
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }

    public boolean getIfOpen(){
        return ifOpen;
    }
    public ArrayList<Student> getStudents() {return students;}

    public ArrayList<Course> getCourses() {return courses;}

    public void addCourse(Course course) {this.courses.add(course);
        course.setCourseManager(this);}

    public void addStudent(Student student) {this.students.add(student);
        student.setCourseManager(this);}
    public boolean enrollStudentInCourse(Student student, String courseId, int points) {
        boolean i = true, j = false;
        Course a = null;
        for (Course course : this.getCourses()) {
            if (course.getCourseID().equals(courseId)) {
                i = false;
                a = course;
                break;
            }
        }
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                j = true;
                break;
            }
        }

        if (points <= 0 || !this.getIfOpen() || points > student.getCredits() ||student.getCredits() < 0|| i || j ) {
            return false;
        } else {
            student.setCredits(student.getCredits() - points);
            student.getEnrollCourses().add(a);
            a.getEnrollStudent().add(student);
            a.getCredits().add(points);
            return true;
        }

    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean j = true, k = true;
        Course a = null;
        for (Course course : this.getCourses()) {
            if (course.getCourseID().equals(courseId)) {
                j = false;
                a = course;
                break;
            }
        }
        int i = 0;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                k = false;
                int p= 0;
                if (a != null) {
                    p = a.getCredits().get(a.getEnrollStudent().indexOf(student));
                }
                i = p;
                break;
            }
        }
        if (credits <= 0 || !this.getIfOpen() || credits - i > student.getCredits() || j || k || student.getCredits() < 0 || i <= 0) {
            return false;
        } else {
            a.getCredits().set(a.getEnrollStudent().indexOf(student), credits);
            student.setCredits(student.getCredits() + i - credits);
            return true;
        }
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean i = true;int thiscredit = 0;
        Course thiscourse= courses.get(findcourse(courseId));
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                thiscredit = thiscourse.getCredits().get(thiscourse.getEnrollStudent().indexOf(student));
                i = false;
                break;
            }
        }

        if (!this.getIfOpen()||i) {
            return false;
        } else {
            thiscourse.getCredits().remove(thiscourse.getEnrollStudent().indexOf(student));
            thiscourse.getEnrollStudent().remove(student);
            student.getEnrollCourses().remove(thiscourse);
            student.setCredits(student.getCredits() + thiscredit);
            return true;
        }
    }
    public void finalizeEnrollments() {
        for (Course thiscourse : this.getCourses()) {
            ArrayList<Integer> thiscredit = new ArrayList<>(thiscourse.getCredits());
            for (int i = 0; i < thiscourse.getCredits().size(); i++) {
                thiscredit.set(i,thiscourse.getCredits().get(i));
            }

            if (thiscredit.size() <= thiscourse.getMaxCapacity()) {
                for (Student student : thiscourse.getEnrollStudent()) {
                    thiscourse.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(thiscourse);
                }

            } else {
                thiscredit.sort(Collections.reverseOrder());
                int mininmum = thiscredit.get(thiscourse.getMaxCapacity());
                for (int i=0; i <thiscourse.getCredits().size();i++) {
                    if (thiscourse.getCredits().get(i)> mininmum) {
                        Student student = thiscourse.getEnrollStudent().get(i);
                        thiscourse.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(thiscourse);
                    }
                }
            }
        }this.setIfOpen(false);
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (this.getIfOpen()==false) {
            return null;}
        else {ArrayList<String> studentlist = new ArrayList<>();
            for (Course thiscourse : student.getEnrollCourses()) {
                int thiscredits=1;
                for (int i = 0; i < thiscourse.getCredits().size(); i++) {
                    if (Objects.equals(thiscourse.getEnrollStudent().get(i).getStudentID(), student.getStudentID())) {
                        thiscredits = thiscourse.getCredits().get(i);
                        break;
                    }
                }
                studentlist.add(thiscourse.getCourseID() + ": " + thiscredits);

            }
            return studentlist;
        }
    }
}