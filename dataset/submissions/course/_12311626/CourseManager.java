import java.util.ArrayList;
import java.util.Collections;


public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        setIfOpen(true);
    }
    public ArrayList<Student> getStudents() {
        return students;
    };
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
        if (courses.contains(course)){
            return;
        }
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student) {
        if (students.contains(student)){
            return;
        }
        students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean a = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courseId.equals(courses.get(i).getCourseID())) {
                a = true;
            }
        }
        boolean b = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(student)) {
                b = true;
            }
        }
        boolean c = true;
       for (Course course : courses) {
           if (course.getCourseID().equals(courseId)){
           if (student.getEnrollCourses().contains(course)) {
               c = false;
}
           }
       }
        boolean d = false;
        if (credits <= student.getCredits()) {
            d = true;
        }
        boolean e = false;
        if (credits > 0) {
            e = true;
        }
        boolean f = true;
        if (!ifOpen) {
            f = false;
        }
        if (a && b && c && d && e && f) {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    student.setCredits(student.getCredits() - credits);
                    student.getEnrollCourses().add(course);
                    course.getEnrollStudent().add(student);
                    course.getCredits().add(credits);
                    return true;
                }
            }
        } else return false;
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean a1 = false;
       for (Course course : courses){
           if (course.getCourseID().equals(courseId)){
               a1 = true;
               break;
           }
       }
        boolean b1=false;
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).equals(student)){
                b1=true;
                break;
            }
        }
        boolean c1 = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                c1 = true;
            }
        }
        boolean d1 = false;
        int preCredit = 0 ;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                if (course.getEnrollStudent().contains(student)) {
                    preCredit = course.getCredits().get(course.getEnrollStudent().indexOf(student));
                    if (course.getEnrollStudent().indexOf(student)==-1){
                        return false;
                    }
                    break;
                }else return false;
            }
        }
        if (credits <= student.getCredits() + preCredit) {
            d1 = true;
        }
        boolean e1 = false;
        if (credits > 0) {
            e1 = true;
        }
        boolean f1 = true;
        if (!this.ifOpen) {
            f1 = false;
        }
        if (a1 && b1 &&c1&& d1 && e1 && f1 ) {
            student.setCredits(student.getCredits() + preCredit - credits);
            for (Course course : courses){
                if (course.getCourseID().equals(courseId)){
                course.getCredits().remove(course.getEnrollStudent().indexOf(student));
                course.getCredits().add(course.getEnrollStudent().indexOf(student),credits);
                break;}else  return false;}
        } else {return false;}
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean a2 = false;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)){
                if (course.getEnrollStudent().contains(student)) {
                    a2 = true;
                    break;
                }else return false;
            }
            }
            boolean b2 = false;
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {
                    b2 = true;
                }
            }
            boolean c2 = false;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).equals(student)) {
                    c2 = true;
                }
            }
            boolean d2 = true;
            if (!this.ifOpen) {
                d2 = false;
            }
            boolean e2 = false;
            for (Course course : courses){
                if (course.getCourseID().equals(courseId)){
                    if (student.getEnrollCourses().contains(course)){
                        e2 = true;
                    }
                }
            }
            if (a2 && b2 && c2 && d2 && e2) {
                for (Course course: courses) {
                    if (course.getCourseID().equals(courseId)) {
                        student.setCredits(student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
                        student.getEnrollCourses().remove(course);
                        course.getEnrollStudent().remove(student);
                        break;
                    }
                }
                return true;
            } else {
                return false;
            }
        };
        public void finalizeEnrollments() {
            setIfOpen(false);
            for (Course course : courses) {
                ArrayList<Student> enrolledStudent = course.getEnrollStudent();
                ArrayList<Integer> credits = course.getCredits();
                int capacity = course.getMaxCapacity();

                ArrayList<Integer> sortedCredits = new ArrayList<>(credits);
                Collections.sort(sortedCredits, Collections.reverseOrder());

                ArrayList<Student> sortedStudents = new ArrayList<>();
                for (int sortedCredit : sortedCredits) {
                    int index = credits.indexOf(sortedCredit);
                    sortedStudents.add(enrolledStudent.get(index));
                }
                int size = sortedCredits.size();
                if (size <= capacity) {
                    for (int i = 0; i < size; i++) {
                        Student student = sortedStudents.get(i);
                        student.getSuccessCourses().add(course);
                        course.getSuccessStudents().add(student);
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        if (sortedStudents.size() > capacity) {
                            sortedStudents.remove(sortedStudents.size() - 1);
                        }
                    }
                    for (int i = 0; i < capacity; i++) {
                        if (sortedCredits.get(capacity).equals(sortedCredits.get(capacity - 1 - i))) {
                            sortedStudents.remove(capacity - 1 - i);
                        }
                    }
                    for (int i = 0; i < sortedStudents.size(); i++) {
                        Student student = sortedStudents.get(i);
                        student.getSuccessCourses().add(course);
                        course.getSuccessStudents().add(student);
                    }
                }
            }
        }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen){
            return null;
        }
        ArrayList<String>  ab= new ArrayList<>();
        for (Course course: student.getEnrollCourses()){
            int credits = course.getCredits().get(course.getEnrollStudent().indexOf(student));
            String jieGuo=course.getCourseID()+": "+credits;
            ab.add(jieGuo);
                    }
        return ab;
                }
    }