import java.util.ArrayList;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        setIfOpen(true);
    }

    public ArrayList<Student> getStudents() { return students; }
    public ArrayList<Course> getCourses() { return courses; }
    public void setIfOpen(Boolean ifOpen) { this.ifOpen = ifOpen; }
    public boolean getIfOpen() { return ifOpen; }

    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (! getIfOpen()){
            return false;
        }else {
            for (Course course : courses) {
                if (courseId.equals(course.getCourseID())) {
                    if (!course.getEnrollStudent().contains(student)) {
                        if (student.getCredits() >= credits && credits > 0) {
                            student.setCredits(student.getCredits() - credits);
                            ArrayList<Student> tempStudent = course.getEnrollStudent();
                            tempStudent.add(student);
                            course.setEnrollStudent(tempStudent);

                            ArrayList<Course> temCourse = student.getEnrollCourses();
                            temCourse.add(course);
                            student.setEnrollCourses(temCourse);

                            ArrayList<Integer> tempCredit = course.getCredits();
                            tempCredit.add(credits);
                            course.setCredits(tempCredit);
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (! getIfOpen()){
            return false;
        }else {
            for (Course course: courses) {
                if (courseId.equals(course.getCourseID())) {
                    if (course.getEnrollStudent().contains(student)){
                        int index = course.getEnrollStudent().indexOf(student);
                        if (student.getCredits() >= credits - course.getCredits().get(index) && credits > 0){
                            student.setCredits(student.getCredits() + course.getCredits().get(index) - credits);

                            ArrayList<Integer> tempCredit = course.getCredits();
                            tempCredit.remove(index);
                            tempCredit.add(index, credits);
                            course.setCredits(tempCredit);
                            return true;
                        }
                    }
                }
            }return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (! getIfOpen()){
            return false;
        }else {
            for (Course course: courses) {
                if (courseId.equals(course.getCourseID())) {
                    if (course.getEnrollStudent().contains(student)){
                        int index1 = course.getEnrollStudent().indexOf(student);
                        student.setCredits(student.getCredits() + course.getCredits().get(index1));

                        ArrayList<Integer> tempCredit = course.getCredits();
                        tempCredit.remove(index1);
                        course.setCredits(tempCredit);

                        ArrayList<Student> tempStudent = course.getEnrollStudent();
                        tempStudent.remove(index1);
                        course.setEnrollStudent(tempStudent);

                        int index2 = student.getEnrollCourses().indexOf(course);
                        ArrayList<Course> tempCourse = student.getEnrollCourses();
                        tempCourse.remove(index2);
                        student.setEnrollCourses(tempCourse);
                        return true;
                    }
                }
            }return false;
        }
    }

    public void finalizeEnrollments(){
        setIfOpen(false);
        for (Course course: courses) {
            ArrayList<Integer> tempCredit = course.getCredits();
            ArrayList<Student> tempStudent = course.getEnrollStudent();
            int n = tempCredit.size();
            for (int i = n; i > 1; i--) {
                for (int j = n - 1; j > n - i; j--){
                    if (tempCredit.get(j - 1) < tempCredit.get(j)){
                        int c = tempCredit.get(j);
                        tempCredit.remove(j);
                        tempCredit.add(j - 1, c);
                        Student s = tempStudent.get(j);
                        tempStudent.remove(j);
                        tempStudent.add(j - 1, s);
                    }
                }
            }
            course.setCredits(tempCredit);
            course.setEnrollStudent(tempStudent);

            int max = course.getMaxCapacity();
            if (max >= course.getEnrollStudent().size()){
                for (int i = 0; i < course.getEnrollStudent().size(); i++){
                    Student student = course.getEnrollStudent().get(i);
                    ArrayList<Course> tempCourse = student.getSuccessCourses();
                    tempCourse.add(course);
                    student.setSuccessCourses(tempCourse);

                    ArrayList<Student> tempSuccessStudent = course.getSuccessStudents();
                    tempSuccessStudent.add(student);
                    course.setSuccessStudents(tempSuccessStudent);
                }
            }else {
                while (max > 0 && course.getCredits().get(max).equals(course.getCredits().get(max - 1)) ){
                    max --;
                }
                for (int i = 0; i < max; i++) {
                    Student student = course.getEnrollStudent().get(i);
                    ArrayList<Course> tempCourse = student.getSuccessCourses();
                    tempCourse.add(course);
                    student.setSuccessCourses(tempCourse);

                    ArrayList<Student> tempSuccessStudent = course.getSuccessStudents();
                    tempSuccessStudent.add(student);
                    course.setSuccessStudents(tempSuccessStudent);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (! getIfOpen()){
            return null;
        }else {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i ++) {
                Course course = student.getEnrollCourses().get(i);
                String courseID = course.getCourseID();
                int index = course.getEnrollStudent().indexOf(student);
                String credits = course.getCredits().get(index).toString();
                String format = courseID + ": " + credits;
                list.add(format);
            }
            return list;
        }
    }
}
