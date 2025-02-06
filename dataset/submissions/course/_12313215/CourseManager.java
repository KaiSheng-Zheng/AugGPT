import java.util.ArrayList;
public class CourseManager {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private boolean ifOpen;

    public CourseManager(){
        ifOpen = true;
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }
    public void setIfOpen(boolean ifOpen){this.ifOpen = ifOpen;}
    public boolean getIfOpen(){return ifOpen;}

    public ArrayList<Student> getStudents() {return students;}

    public ArrayList<Course> getCourses() {return courses;}

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        if(!ifOpen||student.getCredits()<0){return false;}
        Course course = null;
        for (Course courseType : courses) {
            if (courseType.getCourseID().equals(courseId)) {
                course = courseType;
            }
        }

        if (course == null) {return false;}
        boolean flag = false;
        ArrayList<Student> enrollStudents = course.getEnrollStudent();
        if (credits < 0 || credits > student.getCredits()) {flag = true;}
        else for (Student enrollStudent : enrollStudents) {if (enrollStudent.equals(student)) {flag = true;}}
        if(flag){return false;}
        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course course = null;
        for (Course courseType : courses) {
            if (courseType.getCourseID().equals(courseId)) {
                course = courseType;
            }
        }
        if(course == null || !ifOpen|| !course.getEnrollStudent().contains(student)||student.getCredits()<0){return false;}
        boolean flag = false;
        int formerCredits = course.getCredits().get(course.getEnrollStudent().indexOf(student));
        if (credits < 0  || student.getCredits() + formerCredits - credits < 0) {flag = true;}

        if (flag) {return false;}

        ArrayList<Integer> courseCredits = course.getCredits();
        student.setCredits(student.getCredits() + formerCredits - credits);
        courseCredits.set(course.getEnrollStudent().indexOf(student), credits);

        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course course = null;
        for (Course courseType : courses) {
            if (courseType.getCourseID().equals(courseId)) {
                course = courseType;
            }
        }
        if(course == null||!ifOpen|| !course.getEnrollStudent().contains(student)||student.getCredits()<0){return false;}

        int credits = course.getCredits().get(course.getEnrollStudent().indexOf(student));

        course.getCredits().remove(course.getEnrollStudent().indexOf(student));
        course.getEnrollStudent().remove(student);
        student.setCredits(student.getCredits() + credits);
        student.getEnrollCourses().remove(course);

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen||courses.size()==0||student.getCredits()<0) {return null;}
        ArrayList<String> result = new ArrayList<String>();
        for (Course course : student.getEnrollCourses()) {
            int credit = course.getCredits().get(course.getEnrollStudent().indexOf(student));
            result.add(String.format("%s: %d", course.getCourseID(), credit));
        }
        return result;
    }
    public void finalizeEnrollments() {
        if (ifOpen) {
            setIfOpen(false);
            for(Student student:students){
                student.getSuccessCourses().add(null);
            }
            if (!courses.isEmpty()) {
                for (Course course : courses) {
                    ArrayList<Student> enrollStudent = course.getEnrollStudent();
                    ArrayList<Integer> credits = course.getCredits();

                    for(int i = 0;i < enrollStudent.size();i++){
                        for(int j = enrollStudent.size()-1;j >i ;j--){
                            if(credits.get(j) > credits.get(j-1)){
                                int tempCredit = credits.get(j-1);
                                Student tempStudent = enrollStudent.get(j-1);
                                credits.set(j-1,credits.get(j));
                                credits.set(j,tempCredit);
                                enrollStudent.set(j-1,enrollStudent.get(j));
                                enrollStudent.set(j,tempStudent);
                            }
                        }
                    }
                    ArrayList<Student> successStudents = course.getSuccessStudents();
                    int maxCapacity = course.getMaxCapacity();
                    for (int i = 0; i < Math.min(maxCapacity, enrollStudent.size()); i++) {
                        successStudents.add(enrollStudent.get(i));
                    }

                    if (maxCapacity < enrollStudent.size()) {
                        int lastCredit = credits.get(maxCapacity);
                        int end = maxCapacity - 1;
                        while (successStudents.size()!=0 && credits.get(end) == lastCredit) {
                            successStudents.remove(end);
                            end -= 1;
                        }
                    }

                    for (Student student : successStudents) {
                        student.getSuccessCourses().add(course);
                    }
                }
            }
        }
    }
}
