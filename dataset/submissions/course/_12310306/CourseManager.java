import java.util.ArrayList;

public class CourseManager {
    private boolean ifOpen;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public void addStudent(Student student) {
        if (student.getCredits() <= 0) return;
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        if (course.getMaxCapacity() <= 0) return;
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) return false;

        if (credits < 0) return false;

        Course course = null;
        for (Course c : courses) {
            if (courseId.equals(c.getCourseID())) {
                course = c;
                break;
            }
        }
        if (course == null) return false;

        for (Course c : student.getEnrollCourses()) {
            if (courseId.equals(c.getCourseID()))
                return false;
        }

        if (student.getCredits() < credits) return false;

        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        if (credits < 0) return false;

        Course course = null;
        for (Course c : courses) {
            if (courseId.equals(c.getCourseID())) {
                course = c;
                break;
            }
        }
        if (course == null) return false;

        int sign = 0;
        for (Course c : student.getEnrollCourses()) {
            if (courseId.equals(c.getCourseID())) {
                sign = 1;
                break;
            }
        }
        if (sign == 0) return false;

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;

        int originalCredits = course.getCredits().get(index);
        if (student.getCredits() + originalCredits < credits) return false;

        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + originalCredits - credits);
        return true;

    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;

        Course course = null;
        for (Course c : courses) {
            if (courseId.equals(c.getCourseID())) {
                course = c;
                break;
            }
        }
        if (course == null) return false;

        int sign = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())) {
                sign = i;
                break;
            }
        }
        if (sign == -1) return false;

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;

        student.setCredits(student.getCredits() + course.getCredits().get(index));//1.
        student.getEnrollCourses().remove(sign);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;

        ArrayList<String> EnrolledCoursesWithCredits = new ArrayList<>();
        int sign = -1;
        for (Course c : student.getEnrollCourses()) {
            int index = -1;
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                sign = 0;
                break;
            }
            String credit = "" + c.getCredits().get(index);
            EnrolledCoursesWithCredits.add(c.getCourseID() + ": " + credit);
        }
        if (sign == 0) return null;

        return EnrolledCoursesWithCredits;
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        ArrayList<Integer> number = new ArrayList<>();
        for (Course c : courses) {
            int num = 0;
            int sign1 = -1;
            ArrayList<Integer> CreditCopy = new ArrayList<>();

            for (int cre : c.getCredits()) {
                CreditCopy.add(cre);
            }

            CreditCopy.sort((x, y) -> Integer.compare(y, x));

            if (c.getCredits().isEmpty()) {
                number.add(num);
                sign1 = 0;
            } else if (c.getMaxCapacity() >= c.getCredits().size())
                num = CreditCopy.get(c.getCredits().size() - 1);
            else if (!CreditCopy.get(c.getMaxCapacity() - 1).equals(CreditCopy.get(c.getMaxCapacity())))
                num = CreditCopy.get(c.getMaxCapacity() - 1);
            else {
                int sign = -1;
                for (int i = c.getMaxCapacity() - 1; i >= 0; i--) {
                    if (!CreditCopy.get(i).equals(CreditCopy.get(c.getMaxCapacity() - 1))) {
                        num = CreditCopy.get(i);
                        sign = 1;
                        break;
                    }
                }
                if (sign == -1)
                    num = CreditCopy.get(0) + 1;
            }
            
            if(sign1==-1) number.add(num);
        }

//        for (int i : number) {
//            System.out.println(i);
//        }
        int coursenum = 0;
        for (Course c : courses) {
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                // System.out.println(c.getCredits().get(i));
                if (c.getCredits().get(i) >= number.get(coursenum)) {
                    ArrayList<Student> stulist = c.getSuccessStudents();
                    stulist.add(c.getEnrollStudent().get(i));
                    c.setSuccessStudents(stulist);

                    ArrayList<Course> coulist = c.getEnrollStudent().get(i).getSuccessCourses();
                    coulist.add(c);
                    c.getEnrollStudent().get(i).setSuccessCourses(coulist);
                }
            }
            coursenum++;
        }

//        for(Course c:courses){
//            for (int i = 0; i <5 ; i++) {
//                System.out.println(c.getSuccessStudents().get(i).getStudentID());
//            }
//        }

//        for(Student stu:students){
//            System.out.println(stu.getSuccessCourses());
//        }
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

    public void setIfOpen(boolean b) {
        this.ifOpen = b;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }
}
