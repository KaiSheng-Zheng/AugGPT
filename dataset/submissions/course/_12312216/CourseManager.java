import java.util.ArrayList;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
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
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){

        if (!getIfOpen()) {return false;}

        if (credits<=0) {return false;}

        Course enrolledCourse=null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                enrolledCourse=c;
                break;
            }
        }
        if (enrolledCourse==null) {return false;}

        for (Student s : enrolledCourse.getEnrollStudent()) {
            if (s.getStudentID().equals(student.getStudentID())) {
                return false;
            }
        }


        if (student.getCredits()<credits) {return false;}

        student.setCredits(student.getCredits()-credits);

        ArrayList<Integer> creditsList = enrolledCourse.getCredits();
        creditsList.add(credits);
        enrolledCourse.setCredits(creditsList);

        ArrayList<Student> studentsList = enrolledCourse.getEnrollStudent();
        studentsList.add(student);
        enrolledCourse.setEnrollStudent(studentsList);


        ArrayList<Course> coursesList = student.getEnrollCourses();
        coursesList.add(enrolledCourse);
        student.setEnrollCourses(coursesList);

        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){

        if (!getIfOpen()) {return false;}

        Course course=null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course=c;
                break;
            }
        }
        if (course==null) {return false;}

        Course enrolledCourse=null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                enrolledCourse=c;
                break;
            }
        }
        if (enrolledCourse==null) {return false;}
        int index=-1;
        for (int i = 0; i <enrolledCourse.getEnrollStudent().size() ; i++) {
            if (student.getStudentID().equals(enrolledCourse.getEnrollStudent().get(i).getStudentID())) {
                index=i;
                break;
            }
        }
        int currentCredits=enrolledCourse.getCredits().get(index);

        if (student.getCredits()+currentCredits<credits) {return false;}

        student.setCredits(student.getCredits()+currentCredits-credits);

        ArrayList<Integer> creditsList = enrolledCourse.getCredits();
        creditsList.set(index, credits);
        enrolledCourse.setCredits(creditsList);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){

        if (!getIfOpen()) {return false;}

        Course course=null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course=c;
                break;
            }
        }
        if (course==null) {return false;}

        Course enrolledCourse=null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                enrolledCourse=c;
                break;
            }
        }
        if (enrolledCourse==null) {return false;}
        int index=-1;
        for (int i = 0; i <enrolledCourse.getEnrollStudent().size() ; i++) {
            if (student.getStudentID().equals(enrolledCourse.getEnrollStudent().get(i).getStudentID())) {
                index=i;
                break;
            }
        }
        ArrayList<Course> coursesList = student.getEnrollCourses();
        coursesList.remove(enrolledCourse);
        student.setEnrollCourses(coursesList);

        student.setCredits(student.getCredits()+enrolledCourse.getCredits().get(index));

        ArrayList<Student> studentsList = enrolledCourse.getEnrollStudent();
        studentsList.remove(index);
        enrolledCourse.setEnrollStudent(studentsList);

        ArrayList<Integer> creditsList = enrolledCourse.getCredits();
        creditsList.remove(index);
        enrolledCourse.setCredits(creditsList);

        return true;
    }

    public void finalizeEnrollments(){
        setIfOpen(false);
        for (int i = 0; i < this.courses.size(); i++) {
            for (int j = 0; j < this.courses.get(i).getCredits().size()-1; j++) {
                for (int k = 0; k < this.courses.get(i).getCredits().size() - 1 - j; k++) {
                    if (this.courses.get(i).getCredits().get(k) < this.courses.get(i).getCredits().get(k + 1)) {
                        int temp = this.courses.get(i).getCredits().get(k);
                        ArrayList<Integer> creditsList = this.courses.get(i).getCredits();
                        creditsList.set(k, this.courses.get(i).getCredits().get(k + 1));
                        creditsList.set(k + 1, temp);
                        this.courses.get(i).setCredits(creditsList);

                        Student tempStudent = this.courses.get(i).getEnrollStudent().get(k);
                        ArrayList<Student> studentsList = this.courses.get(i).getEnrollStudent();
                        studentsList.set(k, this.courses.get(i).getEnrollStudent().get(k + 1));
                        studentsList.set(k + 1, tempStudent);
                        this.courses.get(i).setEnrollStudent(studentsList);

                    }
                }
            }
        }
        outerloop:
        for (int i = 0; i < this.courses.size(); i++) {
            ArrayList<Student> successStudents = new ArrayList<Student>();
            if(this.courses.get(i).getEnrollStudent().size()<=this.courses.get(i).getMaxCapacity()){
                successStudents=this.courses.get(i).getEnrollStudent();
            }else{
                int failedcredit=this.courses.get(i).getCredits().get(this.courses.get(i).getMaxCapacity());
                int successindex=-1;
                for (int j = this.courses.get(i).getMaxCapacity()-1; j>=0; j--) {
                    if (this.courses.get(i).getCredits().get(j) != failedcredit) {
                        successindex = j;
                        break;
                    }
                    if(j==0){
                        this.courses.get(i).setSuccessStudents(successStudents);
                        continue outerloop;
                    }
                }
                for (int j = 0; j <=successindex; j++) {
                    successStudents.add(this.courses.get(i).getEnrollStudent().get(j));
                }
            }
            this.courses.get(i).setSuccessStudents(successStudents);

        }
        for (int i = 0; i < this.students.size(); i++) {
            ArrayList<Course> successCourses = new ArrayList<>();
            for (int j = 0; j < this.students.get(i).getEnrollCourses().size(); j++) {
                if(this.students.get(i).getEnrollCourses().get(j).getSuccessStudents().isEmpty()){
                    break;
                }
                if (this.students.get(i).getEnrollCourses().get(j).getSuccessStudents().contains(this.students.get(i))) {
                    successCourses.add(this.students.get(i).getEnrollCourses().get(j));
                }
            }
            this.students.get(i).setSuccessCourses(successCourses);
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrolledCoursesInfo = new ArrayList<>();
        for (Course c: student.getEnrollCourses()) {
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                    enrolledCoursesInfo.add(c.getCourseID() + ": " + c.getCredits().get(i));
                    break;
                }
            }
        }
        return enrolledCoursesInfo;
    }
}
