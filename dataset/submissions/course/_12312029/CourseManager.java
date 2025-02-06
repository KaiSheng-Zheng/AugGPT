import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

class CourseManager {
    private ArrayList<Course> courses;

    private ArrayList<Student> students;

    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }




    public ArrayList<Student> getStudents() {
        return students;
    }


    public ArrayList<Course> getCourses() {
        return courses;

    }


    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = false;
    }


    public boolean getIfOpen() {
        return ifOpen;
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
        if (ifOpen == false) return false;

        if (students.contains(student) == false) return false;

        boolean cosExist = false;

        for (Course c : courses) {
            if (c.getCourseID().equals(courseId) == true) {
                cosExist = true;
                break;
            }
        }
        if (cosExist == false) return false;
        Course courseToErl = null;
        int index=0 ;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)){
                courseToErl = courses.get(i);
                index = i;
            }
        }
        if (courseToErl.getEnrollStudent().contains(student)) return false;

        if (credits < 1 || student.getCredits() - credits < 0) return false;

        student.getEnrollCourses().add(courseToErl);
        student.setCredits(student.getCredits() - credits);

        courses.get(index).getEnrollStudent().add(student);
        courses.get(index).getCredits().add(credits);


        return true;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (students.contains(student) == false) return false;
        boolean cosExist = false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId) == true) {
                cosExist = true;
                break;
            }
        }
        if (cosExist == false) return false;
        boolean susExs = false;
        for (Course c : courses) {
            if (c.getEnrollStudent().contains(student) && c.getCourseID().equals(courseId)) susExs = true;
        }
        if (susExs == false) return false;
        if (credits < 1 ) return false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        int stdsc = 0;
                        for (int j = 0; j < students.size(); j++) {
                            if (students.get(j).getStudentID().equals(student.getStudentID())) {
                                if( students.get(j).getCredits() - credits + c.getEnrollStudent().get(i).getCredits() < 0 ){
                                    return false;
                                }
                                students.get(j).setCredits(students.get(j).getCredits() - credits + c.getEnrollStudent().get(i).getCredits());
                            }
                        }
                        c.getCredits().set(i, credits);
                    }
                }
            }
        }
        return true;
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean cosExist = false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId) == true) {
                cosExist = true;
                break;
            }
        }
        if( cosExist == false ) return false;
        boolean susExs = false;
        for (Course c : courses) {
            if (c.getEnrollStudent().contains(student)&&c.getCourseID().equals(courseId)) susExs = true;
        }
        if (susExs == false) return false;
        int crd = -1;
        if (ifOpen == true) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                        if (courses.get(i).getEnrollStudent().get(j).equals(student.getStudentID())) {
                            crd = courses.get(i).getCredits().get(j);
                            for( int l =0 ;l<students.size();l++ ){
                                if( students.get(l).getStudentID().equals(student.getStudentID()) ){
                                    students.get(l).setCredits(students.get(l).getCredits()+crd);
                                    for( int m =0;m<students.get(l).getEnrollCourses().size();m++ ){
                                        if( students.get(l).getEnrollCourses().get(m).getCourseID().equals(courseId) ){
                                            students.get(l).getEnrollCourses().remove(m);
                                        }
                                    }
                                }
                            }
                            courses.get(i).getEnrollStudent().remove(j);
                            courses.get(i).getCredits().remove(j);
                            break;
                        }
                    }
                }
            }


            return true;
        }
        return false;
    }



    public void finalizeEnrollments() {
        ifOpen = false;
        int tmp;
        Student tmpS;
        for (Course cos : courses) {
            for (int i = 0; i < cos.getEnrollStudent().size() - 1; i++) {
                for (int j = 0; j < cos.getEnrollStudent().size() - 1 - i; j++) {
                    if (cos.getCredits().get(i) < cos.getCredits().get(i + 1)) {
                        tmp = cos.getCredits().get(i);
                        cos.getCredits().set(i, cos.getCredits().get(i + 1));
                        cos.getCredits().set(i + 1, tmp);
                        tmpS = cos.getEnrollStudent().get(i);
                        cos.getEnrollStudent().set(i, cos.getEnrollStudent().get(i + 1));
                        cos.getEnrollStudent().set(i + 1, tmpS);
                    }
                }
            }
        }
        for (Course cos : courses) {
            if (cos.getEnrollStudent().size() <= cos.getMaxCapacity()) {

                cos.setSuccessStudents(cos.getEnrollStudent());

                continue;
            }
            int index = -1;
            ArrayList<Student> stu = new ArrayList<>();
            for (int i = cos.getMaxCapacity(); i > 0; i--) {
                if (cos.getCredits().get(i) < cos.getCredits().get(i - 1)) {
                    index = i;
                    for (int j = 0; j < index - 1; i++) {
                        stu.add(i, cos.getEnrollStudent().get(j));
                    }
                    cos.setSuccessStudents(stu);
                    break;
                } else if (i == 1) {
                    break;
                }
            }
        }

        for (Student sbsus : students) {
            ArrayList<Course> cou = new ArrayList<>();
            for (Course cos : courses) {
                if (cos.getSuccessStudents().contains(sbsus)) {
                    cou.add(cos);
                }
            }
            sbsus.setSuccessCourses(cou);
        }

    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> cmd = new ArrayList<>();
        if (ifOpen == false) return null;
        for (Student stu : students) {
            if (stu.getStudentID().equals(student.getStudentID())) {
                for (int i = 0, cred = 0; i < stu.getEnrollCourses().size(); i++) {

                    for (int j = 0; j < courses.size(); j++) {
                        if (courses.get(j).getCourseID().equals(stu.getEnrollCourses().get(i).getCourseID())) {
                            for (int k = 0; k < courses.get(j).getEnrollStudent().size(); k++) {
                                if (courses.get(j).getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())) {
                                    cred = courses.get(j).getEnrollStudent().get(k).getCredits();
                                }
                            }
                        }
                    }

                    String s1 = cred+"";
                    cmd.add(stu.getEnrollCourses().get(i).getCourseID()+": "+s1);
                }
            }
        }
        return cmd;
    }


}





