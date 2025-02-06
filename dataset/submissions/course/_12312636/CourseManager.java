import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CourseManager {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
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
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    //
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!this.ifOpen)
            return false;
        if(credits<=0)
            return false;
        Course course=null;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course==null)
            return false;

        if(student.getCredits()<credits)
            return  false;


        Student stu=null;
        for(Student s:students){
            if(s.getEnrollCourses().equals(courseId)){
                stu=s;
                break;
            }
        }
        if (stu!=null)
            return false;
        student.setCredits(student.getCredits()-credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);

        return  true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!this.ifOpen)
            return false;
        Course course=null;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course==null)
            return false;

        if(!course.getEnrollStudent().contains(student))
            return false;
        int index=-1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID()) ){
                index=i;
                break;
            }
        }

        int originalCredits=course.getCredits().get(index);
        if(student.getCredits()+originalCredits<credits)
            return  false;
        student.setCredits(student.getCredits()+originalCredits-credits);
        course.getCredits().set(index,credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!this.ifOpen)
            return false;
        Course course=null;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course==null)
            return false;
        Student stu=null;

        if(student.getEnrollCourses().contains(course)){
            stu=student;
        }
        if (stu==null)
            return false;
        int index = course.getEnrollStudent().indexOf(student);
        int beforeCredits = course.getCredits().get(index);

        student.getEnrollCourses().remove(course);
        student.setCredits(beforeCredits+student.getCredits());
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(student);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!this.ifOpen)
            return null;
        ArrayList<String> c = new ArrayList<>();
        int index;
        int credit;
        for (Course course : student.getEnrollCourses()) {
            index = course.getEnrollStudent().indexOf(student);
            credit = course.getCredits().get(index);
            c.add(String.format("%s: %d", course.getCourseID(), credit));
        }
        return  c;
    }

    public void finalizeEnrollments(){
        this.ifOpen=false;
        for (Course course : courses) {
            ArrayList<Student> enrollStudents = course.getEnrollStudent();
            ArrayList<Integer> enrollCredits = course.getCredits();

            int capacity = course.getMaxCapacity();
            for (int i = 0; i < enrollCredits.size(); i++) {
                for (int j = i+1; j < enrollCredits.size(); j++) {
                    if(enrollCredits.get(i)< enrollCredits.get(j)){
                        Collections.swap(enrollCredits, i, j);
                        Collections.swap(enrollStudents, i, j);
                    }
                }
            }
            //bug: capacity >= 1 and capacity == 1 will handle the case capacity = 1 twice.
            if (capacity>=1){
                if (enrollCredits.size() > capacity) {
                    if (!Objects.equals(enrollCredits.get(capacity - 1), enrollCredits.get(capacity))) {
                        course.getSuccessStudents().addAll(enrollStudents.subList(0, capacity));
                    }
                    if (Objects.equals(enrollCredits.get(capacity - 1), enrollCredits.get(capacity))){
                        for (int i = 1; i<capacity ; i++) {
                            if(!Objects.equals(enrollCredits.get(capacity-1), enrollCredits.get(capacity-1-i))){
                                ArrayList<Student> successStudentsToChoose = new ArrayList<>(enrollStudents.subList(0, capacity-i));
                                for (Student student: successStudentsToChoose){
                                    course.getSuccessStudents().add(student);
                                }
                                break;
                            }
                        }
                    }
                }
                if (enrollCredits.size() <=capacity) {
                    course.getSuccessStudents().addAll(enrollStudents);
                }
            }
            if(capacity==1){
                if (enrollCredits.size() >capacity) {
                    if (!Objects.equals(enrollCredits.get(0), enrollCredits.get(capacity))) {
                        course.getSuccessStudents().add(enrollStudents.get(0));
                    }
                }
                if (enrollCredits.size() <=capacity) {
                    course.getSuccessStudents().addAll(enrollStudents);
                }
            }

            for (Student student : course.getSuccessStudents()) {
                student.getSuccessCourses().add(course);
            }

        }
    }
}