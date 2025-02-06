import java.util.ArrayList;

public class CourseManager {


    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;


    // Constructor, initializes the course and student lists, and set the system default status open(true).
    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    // Register a course. Add a course object to courses and set the courseManager
    //of the course object to this manager. It is guaranteed that all courseIDs are unique.
    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);

    }

    // Register a course. Add a student object to students and set the courseManager
    //of the student object to this manager. It is guaranteed that all studentIDs are unique.
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        //1.open
        if (!this.ifOpen) {
            return false;
        }
        //2.
        if (credits <= 0) {
            return false;
        }
        //3.
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;//
                break;
            }
        }
        if (course == null) {
            return false;
        }
        //4.
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                return false;
            }
        }
        //5.
        if (student.getCredits() < credits) {
            return false;
        }
        //1.
        student.setCredits(student.getCredits() - credits);
        //2.
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        //3.
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        //1.isOpen
        if (!this.ifOpen) {
            return false;
        }
        //2.
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

        if (credits <= 0) {
            return false;
        }

        //3.
        Student st = null;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                st = student;
                break;
            }
        }
        if (st == null) {
            return false;
        }
        //4.

        //2.
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                if (student.getCredits() + course.getCredits().get(i) < credits) {
                    return false;
                }
                student.setCredits(student.getCredits() + course.getCredits().get(i) - credits);
                course.getCredits().set(i, credits);
                break;
            }
        }
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        //1.isOpen
        if (!this.ifOpen) {
            return false;
        }
        //2.
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
        //3.
        Student st = null;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).equals(student)) {
                st = student;
                break;
            }
        }
        if (st == null) {
            return false;
        }
        //
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        student.setCredits(student.getCredits() + course.getCredits().get(index));
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(course.getCourseID())) {
                student.getEnrollCourses().remove(i);
            }
        }
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        //1.isOpen
        if (!this.ifOpen) {
            return null;
        }
        //
        ArrayList<String> list = new ArrayList<>();
        for (Course c : student.getEnrollCourses()) {
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    list.add(c.getCourseID() + ": " + c.getCredits().get(i));
                }
            }
        }
        return list;
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;

        for (Course c : this.courses) {
            ArrayList<M> m = new ArrayList<>(c.getCredits().size());

            for (int i = 0; i < c.getCredits().size(); i++) {
                M e = new M(i, c.getCredits().get(i));
                m.add(e);
            }
            M temp = null;
            for (int i = 0; i < c.getCredits().size() ; i++) {
                for (int j = 0; j < c.getCredits().size() - 1; j++) {
                    if (m.get(j).getPoints() < m.get(j + 1).getPoints()) {
                        temp = m.get(j);
                        m.set(j, m.get(j + 1));
                        m.set(j + 1, temp);
                    }
                }
            }
//            System.out.println("ks");
//            for (int i = 0; i < m.size(); i++) {
//                System.out.println(m.get(i));
//            }
//            System.out.println("js");

            if (c.getMaxCapacity() < m.size()) {
                int unlucky = m.get(c.getMaxCapacity() - 1).getPoints();

//                System.out.println("AAAAA"+unlucky);

                int LargeCount = 0;
                for (int i = 0; i < c.getCredits().size(); i++) {
                    if (m.get(i).getPoints()>=unlucky){
                        LargeCount++;
                    }
                }
                System.out.println(LargeCount);
                if (LargeCount > c.getMaxCapacity()) {
                    for (int j = 0; j < m.size(); j++) {
                        if (m.get(j).getPoints() <= unlucky) {
                            m.get(j).setPoints(-1);
                        }
                    }
                }else {
                    for (int j = 0; j < m.size(); j++) {
                        if (m.get(j).getPoints() < unlucky) {
                            m.get(j).setPoints(-1);
                        }
                    }
                }

            }
//            System.out.println("ks");
//            for (int i = 0; i < m.size(); i++) {
//                System.out.println(m.get(i));
//            }
//            System.out.println("js");

            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (m.get(i).getPoints() != -1) {
                    c.getSuccessStudents().add(c.getEnrollStudent().get(m.get(i).getIndex()));
                    c.getEnrollStudent().get(m.get(i).getIndex()).getSuccessCourses().add(c);
                }
            }
        }
    }
}

class M {
    private int index;
    private int points;

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "M{" +
                "index=" + index +
                ", points=" + points +
                '}';
    }

    public M(int index, int points) {
        this.index = index;
        this.points = points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
