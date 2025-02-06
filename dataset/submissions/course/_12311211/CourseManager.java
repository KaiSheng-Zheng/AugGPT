import java.util.ArrayList;


public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        setIfOpen(true);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        course.setCourseManager(this);
        this.courses.add(course);

    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        this.students.add(student);

    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!getIfOpen() || credits <= 0) {
            return false;
        }
        int a = 9999;
        int b = 9999;
        for (int i = 0; i < courses.size(); i++) {
            if (courseId.equals(this.courses.get(i).getCourseID()))
                a = i;
        }
        for (int i = 0; i < students.size(); i++) {
            if (student.equals(this.students.get(i)))
                b = i;
        }
        if (a == 9999 || b == 9999) {
            return false;
        }
        if (credits > student.getCredits()) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        courses.get(a).getEnrollStudent().add(student);
        courses.get(a).getCredits().add(credits);
        student.getEnrollCourses().add(courses.get(a));
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        int backCredits = 0;
        if (!getIfOpen()) {
            return false;
        }
        int courseIndex = 9999;
        boolean ifChoose = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courseId.equals(this.courses.get(i).getCourseID()))
                courseIndex = i;
        }
        for (int i = 0; i < courses.get(courseIndex).getEnrollStudent().size(); i++) {
            if (courses.get(courseIndex).getEnrollStudent().get(i).equals(student)) {
                ifChoose = true;
                break;
            }
        }
        int studentIndex = 0;
        studentIndex = courses.get(courseIndex).getEnrollStudent().indexOf(student);
        if (courseIndex == 9999 || !ifChoose) {
            return false;
        }
        backCredits = student.getCredits() + courses.get(courseIndex).getCredits().get(studentIndex);
        if (credits > backCredits) {
            return false;
        }
        student.setCredits(backCredits - credits);
        courses.get(courseIndex).getCredits().set(studentIndex, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!getIfOpen()) {
            return false;
        }
        int courseIndex = 9999;
        boolean ifChoose = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courseId.equals(this.courses.get(i).getCourseID()))
                courseIndex = i;
        }
        for (int i = 0; i < courses.get(courseIndex).getEnrollStudent().size(); i++) {
            if (courses.get(courseIndex).getEnrollStudent().get(i).equals(student)) {
                ifChoose = true;
                break;
            }
        }
        int studentIndex = 0;
        studentIndex = courses.get(courseIndex).getEnrollStudent().indexOf(student);
        if (courseIndex == 9999 || !ifChoose) {
            return false;
        }
        student.getEnrollCourses().remove(courses.get(courseIndex));
        student.setCredits(student.getCredits() + courses.get(courseIndex).getCredits().get(studentIndex));
        courses.get(courseIndex).getEnrollStudent().remove(student);
        courses.get(courseIndex).getCredits().remove(studentIndex);
        return true;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getMaxCapacity() >= courses.get(i).getEnrollStudent().size()) {
                for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                }
            } else {
                ArrayList<Integer> creditsCopy = new ArrayList<>();
                int choseNum = 0;
                choseNum = courses.get(i).getMaxCapacity();
                for (int j = 0; j < courses.get(i).getCredits().size(); j++) {
                    creditsCopy.add(j, courses.get(i).getCredits().get(j));
                }
                bubbleSort(creditsCopy);

                if(creditsCopy.get(courses.get(i).getMaxCapacity())==creditsCopy.get(courses.get(i).getMaxCapacity()-1) ){
                    for (int j = courses.get(i).getMaxCapacity()-2; j >= 0; j--) {
                        int a=creditsCopy.get(j);int b=creditsCopy.get(courses.get(i).getMaxCapacity()-1);
                        if(a==b){
                            choseNum--;
                        }
                    }
                    choseNum--;
                }
               
                if (choseNum!=0) {
                    int finalLimitCredit = creditsCopy.get(choseNum-1);
                    for (int j = 0; j < courses.get(i).getCredits().size(); j++) {
                        if (courses.get(i).getCredits().get(j) >= finalLimitCredit) {
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                            courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                        }
                    }
                }

            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!getIfOpen()) {
            return null;
        }
        ArrayList<String> courseWithCredits = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            int studentIndex = 0;
            studentIndex = student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student);
            courseWithCredits.add(i, student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(studentIndex));
        }
        return courseWithCredits;
    }

    public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) < list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}