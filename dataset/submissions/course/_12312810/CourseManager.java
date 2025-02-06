import java.util.ArrayList;
class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen || student.getCredits() < 0 || student.getCredits() < credits || credits <= 0) {
            return false;
        }
        for (Course enrolledCourse : student.getEnrollCourses()) {
            if (enrolledCourse.getCourseID().equals(courseId)) {
                return false;
            }
        }
        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseId)) {
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
                student.getEnrollCourses().add(course);
                student.setCredits(student.getCredits() - credits);
                return true;
            }
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        if (!ifOpen) {
            return false;
        }
        boolean flag=false;
        for (Course enrolledCourse : student.getEnrollCourses()) {
            if (enrolledCourse.getCourseID().equals(courseId)) {
                flag=true;
            }
        }
        if (flag){
        int index = -1;
        ArrayList<Student> enrolledCourses = course.getEnrollStudent();
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getStudentID().equals(student.getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        int a = course.getCredits().get(index);
        int b = student.getCredits() + a;
        if (credits <= 0 || credits > b || b < 0) {
            return false;
        }
        student.setCredits(student.getCredits() + a - credits);
        course.getCredits().set(index, credits);
        return  true;}
        else {return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        if (!ifOpen) {
            return false;
        }
        int index = -1;
        ArrayList<Course> enrolledCourses = student.getEnrollCourses();
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getCourseID().equals(courseId)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        int index1 = -1;
        ArrayList<Student> enrollStudent = course.getEnrollStudent();
        for (int i = 0; i < enrollStudent.size(); i++) {
            if (enrollStudent.get(i).getStudentID().equals(student.getStudentID())) {
                index1 = i;
                break;
            }
        }
        if (index1 == -1) {
            return false;
        }
        int c = course.getCredits().get(index1);
        student.setCredits(student.getCredits() + c);
        course.getCredits().remove(index1);
        course.getEnrollStudent().remove(index1);
        student.getEnrollCourses().remove(index);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<Course> d = student.getEnrollCourses();
        ArrayList<String> enrolledCourses = new ArrayList<>();
        if (!ifOpen) {
            return null;
        }
        for (Course course : d) {
            int studentIndex = course.getEnrollStudent().indexOf(student);
            if (studentIndex == -1) {
                continue;
            }
            int creditsIndex = studentIndex;
            int credits = course.getCredits().get(creditsIndex);
            String e = course.getCourseID() + ": " + credits;
            enrolledCourses.add(e);
        }
        return enrolledCourses;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course course : courses) {
            if (!ifOpen) {
                int threshold = Math.min(course.getMaxCapacity(),course.getEnrollStudent().size());
                for (int i = 0; i < course.getEnrollStudent().size()-1; i++) {
                    for (int j = 0; j < course.getEnrollStudent().size() - i - 1; j++) {
                        if (course.getCredits().get(j) < course.getCredits().get(j + 1)) {
                            int temp = course.getCredits().get(j);
                            Student temp2=course.getEnrollStudent().get(j);
                            course.getEnrollStudent().set(j,course.getEnrollStudent().get(j+1));
                            course.getEnrollStudent().set(j+1,temp2);
                            course.getCredits().set(j,course.getCredits().get(j + 1));
                            course.getCredits().set(j + 1,  temp);
                        }
                    }
                }
                if (course.getEnrollStudent().size()<=course.getMaxCapacity()){
                    for (int i = 0; i < threshold; i++) {
                        course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                        course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                    }
                }
                else if (course.getEnrollStudent().size() > course.getMaxCapacity()) {
                    int lastSuccessfulCredit = course.getCredits().get(course.getMaxCapacity());
                    System.out.println(lastSuccessfulCredit);
                    int lastSameCreditIndex = threshold-1 ;
                    while (course.getCredits().get(lastSameCreditIndex) == lastSuccessfulCredit ) {
                        threshold--;
                     lastSameCreditIndex--;
                     if (lastSameCreditIndex<0){break;}
                    }
                    for (int i = 0; i <threshold; i++) {
                        course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                        course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                    }
                }
            }
        }
    }
}