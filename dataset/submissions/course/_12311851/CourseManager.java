import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;//
    // Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students;
    // Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.
    private boolean ifOpen;
// Represent system open(true) or not(false).

    public CourseManager() {
        //
        courses = new ArrayList<>();

        //
        students = new ArrayList<>();


        ifOpen = true;
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

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addStudent(Student student) {

        // Constructor, initializes the course and student lists, and set the system   default status open(true).
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }




    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
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
        if (course == null)
            return false;
        Course courese2 = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {//error
                courese2 = c;
                break;
            }
        }
        if (courese2 != null)
            return false;

        if (student.getCredits() - credits < 0)
            return false;
//if
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen)
            return false;
        if (credits <= 0) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;//
                break;
            }
        }
        if (course == null)
            return false;

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if(index<0){
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        if ((originalCredits + student.getCredits()) < credits)
            return false;

        Course courese2 = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                courese2 = c;
                break;
            }
        }
        if (courese2 == null)
            return false;
// if success
        student.setCredits((originalCredits + student.getCredits()) -credits);

        course.getCredits().set(index,credits);//



        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;//
                break;
            }
        }
        if (course == null)
            return false;
        Course courese2 = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                courese2 = c;
                break;
            }
        }
        if (courese2 == null)
            return false;
        int index = -1; //
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if(index<0){
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        //if success
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(student);
        student.getEnrollCourses().remove(course);
        student.setCredits(student.getCredits()+originalCredits);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen)
            return null;
        ArrayList<String> enrolledCoursesWithCredits =new ArrayList<>();
        StringBuilder combineCourseIdAndCredits =new StringBuilder();
        int index = 0;
        for (Course c : student.getEnrollCourses()) {
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if(student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())){
                  index =i;
                  combineCourseIdAndCredits.append(c.getCourseID());
                  combineCourseIdAndCredits.append(": ");
                  combineCourseIdAndCredits.append(c.getCredits().get(index));
                  enrolledCoursesWithCredits.add(combineCourseIdAndCredits.toString());
                  combineCourseIdAndCredits.setLength(0);
                  break;
                }
            }

        }
        return enrolledCoursesWithCredits;
    }
    public void finalizeEnrollments() {
        ifOpen = false;


        for (Course cGiven : courses) {
            if (cGiven.getMaxCapacity() >= cGiven.getCredits().size()) {
                //
                cGiven.getSuccessStudents().addAll(cGiven.getEnrollStudent());
                for (Student student : cGiven.getEnrollStudent()) {
                    student.getSuccessCourses().add(cGiven);
                }
            }
            //
            //
            else{
            ArrayList<Integer> temp = new ArrayList<>(cGiven.getCredits());
            for (int i = 0; i < temp.size() ; i++) {
                for (int j = 0; j < temp.size() - i - 1; j++) {
                    if (temp.get(j) < temp.get(j + 1)) {
                        int tem = temp.get(j);
                        temp.set(j, temp.get(j + 1));
                        temp.set(j + 1, tem);
                    }
                    }
                }

            //



                if (temp.get(cGiven.getMaxCapacity() - 1) > temp.get(cGiven.getMaxCapacity())) {
                    //
                    int lowestCredits = temp.get(cGiven.getMaxCapacity() - 1);
                    for (int j = 0; j < cGiven.getCredits().size() ; j++) {
                        if(cGiven.getCredits().get(j)<lowestCredits){
                            cGiven.getCredits().remove(j);
                            cGiven.getEnrollStudent().remove(j);
                            j--;
                        }
                    }
                    cGiven.getSuccessStudents().addAll(cGiven.getEnrollStudent());
                    for (Student student:cGiven.getEnrollStudent()) {
                        student.getSuccessCourses().add(cGiven);
                    }
                }
                if (temp.get(cGiven.getMaxCapacity() - 1) .equals( temp.get(cGiven.getMaxCapacity()))) {
                    int embarrassingNumber =temp.get(cGiven.getMaxCapacity() - 1);
                    for (int j = 0; j < cGiven.getCredits().size(); j++) {
                        if(cGiven.getCredits().get(j)<=embarrassingNumber){
                            cGiven.getCredits().remove(j);
                            cGiven.getEnrollStudent().remove(j);
                            j--;
                        }
                    }
                    cGiven.getSuccessStudents().addAll(cGiven.getEnrollStudent());//remove the student??? yes!
                    for (Student student:cGiven.getEnrollStudent()) {
                        student.getSuccessCourses().add(cGiven);
                    }
                }
            }
        }
    }
}
