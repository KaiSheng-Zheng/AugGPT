import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

class CourseManager{
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private boolean ifOpen;
    public CourseManager(){
        ArrayList<Student> students=new ArrayList<>();
        ArrayList<Course> courses=new ArrayList<>();
        boolean ifOpen=true;
        this.students=students;
        this.courses=courses;
        this.ifOpen=ifOpen;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public boolean getIfOpen() {
        return ifOpen;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credit) {
        ArrayList<Student> enrollStudent;
        ArrayList<Course> enrollCourse;
        ArrayList<Integer> credits;
        if (!ifOpen) return false;
        if (credit<=0) return false;
        if (student.getCredits()>credit||student.getCredits()==credit) {
            for(Course course:courses){
                if (Objects.equals(course.getCourseID(), courseId)){
                    enrollStudent=course.getEnrollStudent();
                    enrollStudent.add(student);
                    course.setEnrollStudent(enrollStudent);
                    enrollCourse=student.getEnrollCourses();
                    enrollCourse.add(course);
                    student.setEnrollCourses(enrollCourse);
                    credits=course.getCredits();
                    credits.add(credit);
                    course.setCredits(credits);
                    student.setCredits(student.getCredits()-credit);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (dropStudentEnrollmentCourse(student,courseId)){
            return enrollStudentInCourse(student,courseId,credits);
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        ArrayList<Student> enrollStudent;
        ArrayList<Course> enrollCourse;
        ArrayList<Integer> credits;
        int dropStudent=0;
        int dropCourse=0;
        if (!ifOpen) return false;
        for (Course course:courses){
            if (Objects.equals(course.getCourseID(), courseId)){
                for (Student student0:course.getEnrollStudent()){
                    if (Objects.equals(student0.getStudentID(),student.getStudentID())){
                        student.setCredits(student0.getCredits()+course.getCredits().get(dropStudent));
                        enrollStudent=course.getEnrollStudent();
                        enrollStudent.remove(dropStudent);
                        credits=course.getCredits();
                        credits.remove(dropStudent);
                        enrollCourse=student.getEnrollCourses();
                        for (Course course0:student.getEnrollCourses()){
                            if (Objects.equals(course0.getCourseID(),courseId)){
                                enrollCourse.remove(dropCourse);
                                course.setEnrollStudent(enrollStudent);
                                course.setCredits(credits);
                                student.setEnrollCourses(enrollCourse);
                                return true;
                            }
                            dropCourse++;
                        }
                    }
                    dropStudent++;
                }
            }
        }
        return false;
    }
    public void finalizeEnrollments(){
        int order=0;
        int credit=0;
        int i=0;
        ArrayList<Student> SuccessStudents=new ArrayList<>();
        ArrayList<Course> SuccessCourses;
        ArrayList<Integer> SuccessCredits=new ArrayList<>();
        ArrayList<Integer> credits;
        for (Course course:courses) {
            if (!course.getEnrollStudent().isEmpty()) {
                    for (int j = 0; j < course.getMaxCapacity() + 1; j++) {
                        for (Student student : course.getEnrollStudent()) {
                            if (course.getCredits().get(i) > credit) {
                                credit = course.getCredits().get(i);
                                order = i;
                            }
                            i++;
                        }
                        if (course.getEnrollStudent().isEmpty()) break;
                        SuccessStudents.add(course.getEnrollStudent().get(order));
                        SuccessCourses = course.getEnrollStudent().get(order).getSuccessCourses();
                        SuccessCourses.add(course);
                        course.getEnrollStudent().get(order).setSuccessCourses(SuccessCourses);
                        credits=course.getCredits();
                        credits.remove(order);
                        course.setCredits(credits);
                        SuccessCredits.add(credit);
                        course.getEnrollStudent().remove(order);
                        i = 0;
                        credit = 0;
                        order = 0;
                    }
                int last = SuccessStudents.size() - 1;
                if (SuccessStudents.size() > course.getMaxCapacity()) {
                    while (Objects.equals(SuccessCredits.get(last), SuccessCredits.get(last - 1))) {
                        SuccessCourses = SuccessStudents.get(last).getSuccessCourses();
                        SuccessCourses.remove(SuccessCourses.size() - 1);
                        SuccessStudents.get(last).setSuccessCourses(SuccessCourses);
                        SuccessStudents.remove(last);
                        last--;
                        if (last == 0) break;
                    }
                    SuccessCourses = SuccessStudents.get(last).getSuccessCourses();
                    SuccessCourses.remove(SuccessCourses.size() - 1);
                    SuccessStudents.get(last).setSuccessCourses(SuccessCourses);
                    SuccessStudents.remove(last);
                }
                course.setSuccessStudents(SuccessStudents);
                SuccessStudents = new ArrayList<>();
                SuccessCredits=new ArrayList<>();
            }
        }
        ifOpen=false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> enrolledCoursesWithCredits=new ArrayList<>();
        int position=0;
        if (!ifOpen) return null;
        for (Course course:student.getEnrollCourses()){
            for (Student student0:course.getEnrollStudent()){
                if (Objects.equals(student.getStudentID(),student0.getStudentID())){
                    enrolledCoursesWithCredits.add(course.getCourseID()+": "+course.getCredits().get(position));
                }
                position++;
            }
            position=0;
        }
        return enrolledCoursesWithCredits;
    }
}