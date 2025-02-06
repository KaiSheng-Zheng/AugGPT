import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(ArrayList<Course> courses, ArrayList<Student> students) {
        this.courses = new ArrayList<>();
        this.courses = courses;
        this.students = new ArrayList<>();
        this.students = students;
        ifOpen = true;
    }

    public CourseManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {
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
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen)
            return false;
        if (student.getCredits() < credits)
            return false;
        if (credits <= 0)
            return false;
        for (Course cours : student.getEnrollCourses()) {
            if (cours.getCourseID().equals(courseId))
                return false;
        }
        for (Course cours : courses) {
            if (cours.getCourseID().equals(courseId)) {
                student.setCredits(student.getCredits() - credits);
                cours.getEnrollStudent().add(student);
                student.getEnrollCourses().add(cours);
                cours.getCredits().add(credits);
                return true;
            }
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen)
            return false;
        if (credits <= 0)
            return false;
        int i = 0;
        for (Course cours : student.getEnrollCourses()) {
            if (cours.getCourseID().equals(courseId)) {
                i = cours.getEnrollStudent().indexOf(student);
                if (cours.getCredits().get(i) + student.getCredits() < credits)
                    break;
                student.setCredits(student.getCredits() + cours.getCredits().get(i) - credits);
                cours.getCredits().set(i, credits);
                return true;
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student s, String courseId) {
        if (!ifOpen)
            return false;
        int i = 0;
        for (Course cours : s.getEnrollCourses()) {
            if (cours.getCourseID().equals(courseId)) {
                i = cours.getEnrollStudent().indexOf(s);
                s.setCredits(s.getCredits() + cours.getCredits().get(i));
                s.getEnrollCourses().remove(cours);
                cours.getEnrollStudent().remove(i);
                cours.getCredits().remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen)
            return null;
        ArrayList<String> arrayList = new ArrayList<String>();
        int i = 0;
        for (Course enrollCours : student.getEnrollCourses()) {
            i = enrollCours.getEnrollStudent().indexOf(student);
            String s = enrollCours.getCourseID() + ": " + enrollCours.getCredits().get(i);
            arrayList.add(s);
        }
        return arrayList;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course cours : courses) {
            ArrayList<Student> successStudents = new ArrayList<>();
            int minCredit = successNum(cours);
            for (int i = 0; i < cours.getCredits().size(); i++) {
                if (cours.getCredits().get(i) >= minCredit) {
                    successStudents.add(cours.getEnrollStudent().get(i));
                } else {
                    cours.getEnrollStudent().get(i).getEnrollCourses().remove(cours);
                }
            }
            cours.setSuccessStudents(successStudents);
        }
        for (Student student : students) {
            student.setSuccessCourses(student.getEnrollCourses());
        }


    }

    public int successNum(Course course) {
        int max = course.getMaxCapacity();
        ArrayList<Integer> creditsList = new ArrayList<>();
        for (int i = 0; i < course.getCredits().size(); i++) {
            creditsList.add(course.getCredits().get(i));
        }
        Collections.sort(creditsList);
        int lastIndex = creditsList.size() - max;
        if (max >= creditsList.size())
            return 0;
        int last = creditsList.get(lastIndex);
        int a = last+1 ;
        if (last != creditsList.get(lastIndex - 1))
            return last;
        else {
            for (int i = lastIndex; i < creditsList.size(); i++) {
                if (creditsList.get(i) != last) {
                    a = creditsList.get(i);
                    break;
                }
            }
            return a ;
        }
    }
}
