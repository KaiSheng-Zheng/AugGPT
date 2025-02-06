import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }








    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (!this.ifOpen) return false;

        if (credits<=0) return false;

        Course course = null;
        for (Course c:courses){
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course == null) return false;

        int index = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                index=i;
            }
        }
        if (index != -1) return false;

        if (student.getCredits()<credits) return false;


        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits()-credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!this.ifOpen) return false;

        Course course = null;
        for (Course c:courses){
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course == null) return false;

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i ;
                break;
            }
        }
        if (index == -1 ) return false;

        int originalCredits = course.getCredits().get(index);
        int stuOriCredit = student.getCredits();
        if (originalCredits+stuOriCredit < credits) return false;

        course.getCredits().set(index,credits);
        student.setCredits(stuOriCredit+originalCredits-credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!this.ifOpen) return false;

        Course course = null;
        for (Course c:courses){
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course == null) return false;

        int index =-1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i ;
                break;
            }
        }
        if (index == -1 ) return false;

        int originalCredits = course.getCredits().get(index);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        int indexCourse = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                indexCourse= i;
            }
        }
        student.setCredits(student.getCredits()+originalCredits);
        student.getEnrollCourses().remove(indexCourse);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!this.ifOpen) return null;
        ArrayList<String> coursesWithCredits = new ArrayList<>();
        int creditFor;
        for (Course c:courses){
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (c.getEnrollStudent().get(i).equals(student)){
                    creditFor = c.getCredits().get(i);
                    coursesWithCredits.add(c.getCourseID()+": "+creditFor);
                }
            }
        }
        return coursesWithCredits;
    }

    public void finalizeEnrollments(){
        this.setIfOpen(false);
        int people;
        ArrayList<Student> successPeople;
        for (Course c : courses) {
            successPeople = new ArrayList<>();
            for (int i = 0; ; i++) {
                people=0;
                successPeople = new ArrayList<>();
                for (int j =0 ;j<c.getCredits().size();j++){
                    if (c.getCredits().get(j)>i) {
                        successPeople.add(c.getEnrollStudent().get(j));
                        people++;
                    }
                }
                if (people<=c.getMaxCapacity()){
                    c.setSuccessStudents(successPeople);
                    break;
                }
            }
        }
        ArrayList<Course> successCourse;
        for (Student s : students) {
            successCourse = new ArrayList<>();
            for (Course c : courses){
                if (c.getSuccessStudents().contains(s)){
                    successCourse.add(c);
                }
            }
            s.setSuccessCourses(successCourse);
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
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
}
