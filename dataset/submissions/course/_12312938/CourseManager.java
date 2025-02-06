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
    public ArrayList<Student> getStudents(){
        return students;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }


    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private int findIndexByStudent(Student student, String courseId){
        Course course = findCourseById(courseId);
        int index = 0;
        for (Student theStudent : course.getEnrollStudent()){
            if (theStudent.equals(student)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourseById(courseId);
        if (course == null) {
            return false;
        }

        if (student.getEnrollCourses().contains(course)) {
            return false;
        }

        if (student.getCredits() < credits) {
            return false;
        }


        if (credits <= 0) {
            return false;
        }

        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        student.getEnrollCourses().add(course);
        course.getCredits().add(credits);

        return true;
    }



    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = findCourseById(courseId);
        if (course == null) {
            return false;
        }

        if (!course.getEnrollStudent().contains(student)) {
            return false;
        }

        int originCourseCredit = course.getCredits().get(findIndexByStudent(student, courseId));
        if (credits < 0 || credits > student.getCredits() + originCourseCredit) {
            return false;
        }

        dropStudentEnrollmentCourse(student, courseId);
        enrollStudentInCourse(student, courseId, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }

        Course course = findCourseById(courseId);
        if (course == null) {
            return false;
        }

        if (!student.getEnrollCourses().contains(course)) {
            return false;
        }

        int originCourseCredit = course.getCredits().get(findIndexByStudent(student, courseId));
        student.setCredits(student.getCredits() + originCourseCredit);
        course.getCredits().remove(findIndexByStudent(student, courseId));
        course.getEnrollStudent().remove(student);
        student.getEnrollCourses().remove(course);

        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        for (Course course : courses) {
            course.setSuccessStudents(course.getEnrollStudent());
            ArrayList<Integer> successCredits = course.getCredits();
            if (course.getMaxCapacity() >= course.getSuccessStudents().size()){
                continue;
            }
            int minimumCredit =1000;
            while (course.getMaxCapacity() < course.getSuccessStudents().size()){
                minimumCredit =1000;
                for (Student student : course.getSuccessStudents()){
                    if (course.getCredits().get(findIndexByStudent(student, course.getCourseID())) < minimumCredit){
                        minimumCredit = course.getCredits().get(findIndexByStudent(student, course.getCourseID()));
                    }
                }
                for (int i = 0; i < course.getSuccessStudents().size(); i++){
                    if (successCredits.get(i) == minimumCredit){
                        course.getSuccessStudents().remove(i);
                        successCredits.remove(i);
                        i--;
                    }
                }
            }
            for (Student student : course.getSuccessStudents()){
                student.getSuccessCourses().add(course);
            }

        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        for (Course course : student.getEnrollCourses()){
            result.add(String.format("%s: %d", course.getCourseID(), course.getCredits().get(findIndexByStudent(student,course.getCourseID()))));
        }
        return result;
    }
}