import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }


    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }

        if (credits <= 0) {
            return false;
        }

        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        student.getEnrollCourses();
        boolean s = false;
        for (Course d : student.getEnrollCourses()) {
            if (d.getCourseID().equals(courseId)) {
                s = true;
                break;
            }
        }
        if (s) {
            return false;
        }

        if (student.getCredits() < credits) {
            return false;
        }

        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }

        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }

        int originalCredits = course.getCredits().get(index);
        if (originalCredits + student.getCredits() - credits < 0) {
            return false;
        }

        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + originalCredits - credits);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }

        int i = -1;
        for (int j = 0; j < student.getEnrollCourses().size(); j++) {
            if (student.getEnrollCourses().get(j).getCourseID().equals(courseId)) {
                i = j;
                break;
            }
        }
        if (i==-1){
            return false;
        }

        student.setCredits(student.getCredits() + course.getCredits().get(index));
        student.getEnrollCourses().remove(i);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        } else {
            ArrayList<String> EnrolledCoursesWithCredits = new ArrayList<>();
            for (Course c : courses) {
                int index = -1;
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                        index = i;
                        break;
                    }
                }
                if (index==-1){
                    continue;
                }
                EnrolledCoursesWithCredits.add(c.getCourseID() + ":" + c.getCredits().get(index));
            }

            return EnrolledCoursesWithCredits;
        }
    }

    public void finalizeEnrollments() {
         setIfOpen(false);
        for (Course c : courses) {
            int max = 0;
            int min = 100;
            for (int i = 0; i < c.getCredits().size(); i++) {
                if (c.getCredits().get(i)>max){
                    max=c.getCredits().get(i);
                }
                if (c.getCredits().get(i)<min){
                    min=c.getCredits().get(i);
                }
            }
            int target=(max+min)/2;
            int num=0;
            for (int i = 0; i < c.getCredits().size(); i++){
                if (c.getCredits().get(i)>target){
                    num++;
                }
            }
            if (num<c.getMaxCapacity()){
                for (int i=target-1;i>=min;i--){
                    num=0;
                    for (int j = 0; j < c.getCredits().size(); j++){
                        if (c.getCredits().get(j)>i){
                            num++;
                        }
                    }
                    if (num>c.getMaxCapacity()){
                        target=i+1;
                        break;
                    }
                }
            }else {
                for (int i=target+1;i<=max;i++){
                    num=0;
                    for (int j = 0; j < c.getCredits().size(); j++){
                        if (c.getCredits().get(j)>i){
                            num++;
                        }
                    }
                    if (num<c.getMaxCapacity()){
                        target=i-1;
                        break;
                    }
                }
            }
            for (int i=0;i<c.getCredits().size();i++){
                if (c.getCredits().get(i)>target){
                    c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                    c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                }
            }
        }
    }


}