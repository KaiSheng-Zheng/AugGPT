
import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        ifOpen = true;
        courses = new ArrayList<>();
        students = new ArrayList<>();
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
        return this.ifOpen;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {

        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        boolean out = true;
        int studentCode = 0;
        int courseCode = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                courseCode = i;
                out = false;
            }
        }
        if (out) {
            return false;
        }
        out = true;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(student)) {
                studentCode = i;
                out = false;
            }
        }
        if (out) {
            return false;
        }
        if (courses.get(courseCode).getEnrollStudent().contains(student)) {
            return false;
        }
        if(credits<=0){
            return false;
        }
        if (credits > student.getCredits()) {
            return false;
        }
        Course course1 = courses.get(courseCode);
        ArrayList<Student> students1 = course1.getEnrollStudent();
        students1.add(student);
        course1.setEnrollStudent(students1);
        ArrayList<Integer> credits1 = course1.getCredits();
        credits1.add(credits);
        course1.setCredits(credits1);
        Student student1 = students.get(studentCode);
        ArrayList<Course> courses1 = student1.getEnrollCourses();
        courses1.add(course1);
        student1.setEnrollCourses(courses1);
        student1.setCredits(student1.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        boolean out = true;
        int studentCode = 0;
        int courseCode = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                courseCode = i;
                out = false;
            }
        }
        if (out) {
            return false;
        }
        out = true;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(student)) {
                studentCode = i;
                out = false;
            }
        }
        if (out) {
            return false;
        }
        if (!courses.get(courseCode).getEnrollStudent().contains(student)) {
            return false;
        }
        Course course1 = courses.get(courseCode);
        int creditCode = 0;
        for (int i = 0; i < course1.getEnrollStudent().size(); i++) {
            if (course1.getEnrollStudent().get(i).equals(student)) {
                creditCode = i;
            }
        }
        ArrayList<Integer> credits1 = course1.getCredits();
        int temp = credits1.get(creditCode);
        int newCredits = temp + student.getCredits();
        student.setCredits(newCredits);
        if (credits>student.getCredits()) {
            return false;
        }
        credits1.set(creditCode, credits);
        course1.setCredits(credits1);
        int a = newCredits - credits;
        student.setCredits(a);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        boolean out = true;
        int studentCode = 0;
        int courseCode = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                courseCode = i;
                out = false;
            }
        }
        if (out) {
            return false;
        }
        out = true;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(student)) {
                studentCode = i;
                out = false;
            }
        }
        if (out) {
            return false;
        }
        if (!courses.get(courseCode).getEnrollStudent().contains(student)) {
            return false;
        }
        Course course1 = courses.get(courseCode);
        Student student1 = students.get(studentCode);
        for (int i = 0; i < course1.getEnrollStudent().size(); i++) {
            if (course1.getEnrollStudent().get(i).equals(student)) {
                studentCode = i;
            }
        }
        ArrayList<Integer> credits1 = course1.getCredits();
        int temp = credits1.get(studentCode);
        int newCredits = temp + student.getCredits();
        student.setCredits(newCredits);
        ArrayList<Student> students1 = course1.getEnrollStudent();
        students1.remove(student);
        course1.setEnrollStudent(students1);
        credits1.remove(studentCode);
        course1.setCredits(credits1);
        student1.getEnrollCourses().remove(course1);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Integer> temp = courses.get(i).getCredits();
            ArrayList<Student> tag = courses.get(i).getEnrollStudent();
            for (int j = 0; j < temp.size(); j++) {
                for (int k = 0; k < temp.size()-1; k++) {
                    if (temp.get(k + 1) > (temp.get(k))) {
                         int a = temp.get(k);
                        temp.set(k, temp.get(k + 1));
                        temp.set(k+1,a);
                        Student b = tag.get(k);
                        tag.set(k, tag.get(k + 1));
                        tag.set(k+1,b);
                    }
                }
            }
            int x =courses.get(i).getMaxCapacity();
            if(courses.get(i).getEnrollStudent().size()>x) {
                if (courses.get(i).getCredits().get(x - 1).equals(courses.get(i).getCredits().get(x))) {
                    int Min = courses.get(i).getCredits().get(x - 1);
                    for (int k = 0; k < x; k++) {
                        if (courses.get(i).getCredits().get(k) > Min) {
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(k));
                            courses.get(i).getEnrollStudent().get(k).getSuccessCourses().add(courses.get(i));

                        }
                    }
                } else {
                    for (int k = 0; k < x; k++) {
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(k));
                        courses.get(i).getEnrollStudent().get(k).getSuccessCourses().add(courses.get(i));
                    }
                }
            }
            else{
                for (int k = 0; k <courses.get(i).getEnrollStudent().size() ; k++) {
                   {
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(k));
                       courses.get(i).getEnrollStudent().get(k).getSuccessCourses().add(courses.get(i));
                    }
                }
            }
            courses.get(i).setSuccessStudents( courses.get(i).getSuccessStudents());
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> LIST = new ArrayList<>();
        if(!ifOpen){
            return null;
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            int d=student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student);
          int a =  student.getEnrollCourses().get(i).getCredits().get(d);
          LIST.add(student.getEnrollCourses().get(i).getCourseID()+": "+a);
        }
        return  LIST;
    }
}
