
import java.util.ArrayList;
public class CourseManager {
    private  ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.
    private  ArrayList<Student> students;
    // Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.
    private boolean ifOpen;
    // Represent system open(true) or not(false).

    public CourseManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        ifOpen = true;
    }


    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    // setter for ifOpen
    public boolean getIfOpen() {
        return ifOpen;
    }
    // getter for ifOpen

    public ArrayList<Student> getStudents() {
        return students;
    }
    // getter for students
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // getter for courses
    public ArrayList<Student> setStudents() {
        return students;
    }
    public ArrayList<Course> setCourses() {
        return courses;
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
        boolean b = false;
        for (Course course : courses) {
            if (ifOpen&&students.contains(student)&&course.getCourseID().equals(courseId)&&
                    !course.getEnrollStudent().contains(student)&&
                    credits >= 0 && credits <= student.getCredits()) {
                student.getEnrollCourses().add(course);
                course.getEnrollStudent().add(student);
                if (students.indexOf(student) > course.getCredits().size()) {
                    for (int i = course.getCredits().size(); i < students.indexOf(student); i++) {
                        course.getCredits().add(i, 0);
                    }
                    course.getCredits().add(students.indexOf(student), credits);
                }
                else if(students.indexOf(student) < course.getCredits().size())
                    {course.getCredits().set(students.indexOf(student),credits);}
                else {course.getCredits().add(students.indexOf(student), credits);}
                b = true;
                student.setCredits(student.getCredits() - credits);
            }
        }
        return b;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean bb = false;
        if (ifOpen) {
            for (Course course : courses) {
                if (course.getEnrollStudent().contains(student)&&
                        course.getCourseID().equals(courseId) && credits >= 0 &&
                        credits <= student.getCredits()+course.getCredits().get(students.indexOf(student))) {
                    student.setCredits(student.getCredits() + course.getCredits().get(students.indexOf(student)));
                    course.getCredits().set(students.indexOf(student), credits);
                    student.setCredits(student.getCredits() - credits);
                    bb = true;
                }
            }
        }
        return bb;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean bbb = false;
        if (ifOpen) {
            for (Course course : courses) {
                if (course.getEnrollStudent().contains(student)&&course.getCourseID().equals(courseId)) {
                    student.getEnrollCourses().remove(course);
                    course.getEnrollStudent().remove(student);
                    student.setCredits(student.getCredits() + course.getCredits().get(students.indexOf(student)));
                    course.getCredits().set(students.indexOf(student), 0);
                    bbb=true;
                }
            }
            return bbb;
        } else return false;
    }


    public void finalizeEnrollments() {
        ifOpen = false;

        int[][] test = new int[courses.size()][];
        //initialize!!!
        int k = 0;
        for (Course course : courses) {
            test[k] = new int[course.getCredits().size()];
            for (int i = 0; i < course.getCredits().size(); i++) {
                test[k][i] = course.getCredits().get(i);
            }
            k++;
        }

        int kk = 0;
        for (Course course : courses) {
            if (course.getCredits().size() > 1) {
                for (int j = 0; j < course.getCredits().size() - 1; j++) {
                    for (int s = 1; s + j < course.getCredits().size(); s++) {
                        if (test[kk][j] < test[kk][j + s]) {
                            int temp = test[kk][j];
                            test[kk][j] = test[kk][j + s];
                            test[kk][j + s] = temp;
                        }
                    }
                }
            }
            kk++;
        }
        //get successStudents//add only when it does not contain!
        int i = 0;
        for (Course course : courses) {
            for (int j = 0; j < course.getMaxCapacity() && j < test[i].length; j++) {
                if (course.getMaxCapacity() >= test[i].length) {
                    for (Student student : course.getEnrollStudent()) {
                        if(!course.getSuccessStudents().contains(student)){
                        course.getSuccessStudents().add(student);}
                    }
                }
                if (course.getMaxCapacity() < test[i].length){
                    for (Student student : course.getEnrollStudent()) {
                        if(course.getCredits().get(students.indexOf(student))==test[i][j]&&
                                course.getCredits().get(students.indexOf(student))!=test[i][course.getMaxCapacity()]&&
                        !course.getSuccessStudents().contains(student)){
                            course.getSuccessStudents().add(student);
                        }
                    }
                }
            }
            i++;
        }

        for (Student student :students){
            for(Course course :courses){
                if(course.getSuccessStudents().contains(student)&&!student.getSuccessCourses().contains(course)){
                    student.getSuccessCourses().add(course);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> enrolledCourses = new ArrayList<>();
        if(!ifOpen){
        return null;}
        else {
            for (Course course : student.getEnrollCourses()) {
                enrolledCourses.add(course.getCourseID() + ": " + course.getCredits().get(students.indexOf(student)));
            }
        }
        return enrolledCourses;
    }
}