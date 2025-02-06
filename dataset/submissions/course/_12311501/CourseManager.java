import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class CourseManager {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    //Constructor

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }


    //method:


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
        course.setCourseManager(CourseManager.this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(CourseManager.this);
    }


    private Course findcourse(String courseId) {
        for (int i = 0; i < getCourses().size(); i++) {
            if (courseId.equals(getCourses().get(i).getCourseID())) {
                return (getCourses().get(i));
            }
        }
        return getCourses().get(0);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean judge1 = false;
        boolean judge2 = true;
        if (getIfOpen() && student.getCredits() - credits >= 0 && credits > 0) {
            for (int i = 0; i < getCourses().size(); i++) {
                if (courseId.equals(getCourses().get(i).getCourseID())) {
                    judge1 = true;
                    break;
                }
            }

            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())) {
                    judge2 = false;
                    break;
                }
            }

            if (judge1 && judge2) {
                student.setCredits(student.getCredits() - credits);

                student.getEnrollCourses().add(findcourse(courseId));

                findcourse(courseId).getEnrollStudent().add(student);

                findcourse(courseId).getCredits().add(credits);

                return true;
            }
        }
        return false;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean judge1 = false;
        if (getIfOpen() && credits > 0) {
            Course course = null;
            for (int i = 0; i < getCourses().size(); i++) {
                if (courseId.equals(getCourses().get(i).getCourseID())) {
                    judge1 = true;
                    course = getCourses().get(i);
                    break;
                }
            }

            int index=-1;
            for(int i = 0; i<student.getEnrollCourses().size(); i++) {
                if(courseId.equals(student.getEnrollCourses().get(i).getCourseID())) {
                    index=i;
                    break;
                }
            }
            if(index==-1) {return false;}

            for(int i = 0; i<course.getEnrollStudent().size(); i++) {
                if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                    index=i;
                    break;
                }
            }

            if (judge1) {
                if (student.getCredits() + course.getCredits().get(index) >= credits) {

                    student.setCredits(student.getCredits() + (course.getCredits().get(index) - credits));

                    course.getCredits().set(index, credits);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean judge1 = false;
        Course course = null;

        for (int i = 0; i < getCourses().size(); i++) {
            if (courseId.equals(getCourses().get(i).getCourseID())) {
                judge1 = true;
                course = getCourses().get(i);
                break;
            }
        }

        if (!getIfOpen() || !student.getEnrollCourses().contains(course) || !judge1) {
            return false;
        }


        student.setCredits(student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)));


        course.getCredits().remove(course.getEnrollStudent().indexOf(student));
        course.getEnrollStudent().remove(student);


        student.getEnrollCourses().remove(course);

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> enrolledCourses = new ArrayList<>();
        if (getIfOpen()) {
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int index = 0;
                ArrayList<Integer> numbers = new ArrayList<>(student.getEnrollCourses().get(i).getCredits());
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if(student.getEnrollCourses().get(i).getEnrollStudent().get(j).equals(student)) {
                        index=j;
                        break;
                    }
                }
                enrolledCourses.add(student.getEnrollCourses().get(i).getCourseID() + ": " + numbers.get(index));

            }
            return enrolledCourses;
        }
        return null;
    }

    public void finalizeEnrollments() {

        for (Course course : getCourses()) {
            if (course.getEnrollStudent().size() > course.getMaxCapacity()) {

                List<Student> enrollStudents = course.getEnrollStudent();
                List<Integer> enrollCredits = course.getCredits();
                for (int i = 0; i < enrollStudents.size() - 1; i++) {
                    for (int j = 0; j < enrollStudents.size() - i - 1; j++) {
                        int credits1 = enrollCredits.get(j);
                        int credits2 = enrollCredits.get(j + 1);
                        if (credits1 < credits2) {
                            Student tempStudent = enrollStudents.get(j);
                            enrollStudents.set(j, enrollStudents.get(j + 1));
                            enrollStudents.set(j + 1, tempStudent);
                            enrollCredits.set(j, credits2);
                            enrollCredits.set(j + 1, credits1);
                        }
                    }
                }
                int Index = course.getMaxCapacity() - 1;
                if(enrollCredits.get(Index + 1).equals(course.getCredits().get(Index))) {
                    int a = enrollCredits.get(Index);

                    while (Index >= 0 && enrollCredits.get(Index).equals(a)) {
                        Index--;
                    }

                    if(Index >= 0 ) {
                        List<Student> successStudents = enrollStudents.subList(0, Index + 1);
                        course.setSuccessStudents(new ArrayList<>(successStudents));
                    }
                }
                else{
                    List<Student> successStudents = enrollStudents.subList(0, Index + 1);
                    course.setSuccessStudents(new ArrayList<>(successStudents));
                }

            }
            else {
                course.setSuccessStudents(new ArrayList<>(course.getEnrollStudent()));
            }
        }
        setIfOpen(false);
    }
}
