import java.util.ArrayList;

public class CourseManager {
    private boolean IfOpen;
    // Represent system open(true) or not(false).
    private ArrayList<Student> students;
    // Maintains a record of all students successfully registered.
    // It is guaranteed that courses student enrolled in must exist in courses.
    private ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.
    // It is guaranteed that students enrolled in a course must exist in students.
    public CourseManager(){
        students= new ArrayList<>();
       courses = new ArrayList<>();
        IfOpen = true;
    }
    // Constructor, initializes the course and student lists, and set the system default status open(true).

    public void setIfOpen(boolean b) {
        this.IfOpen = b;
    }
    // setter for ifOpen

    public boolean getIfOpen() {
        return IfOpen;
    }
    // getter for ifOpen

    public ArrayList<Student> getStudents(){
        return students;
    }
    // getter for students

    public ArrayList<Course> getCourses(){
        return courses;
    }
    // getter for courses

    public void addStudent(Student student1) {
        students.add(student1);
        student1.setCourseManager(this);
    }
    // Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.

    public void addCourse(Course course1) {
        courses.add(course1);
        course1.setCourseManager(this);
    }
    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(IfOpen){
            for(int i=0;i<courses.size();i++){
                if(courseId.equals(courses.get(i).getCourseID())){
                    if(student.getEnrollCourses().contains(courses.get(i))){
                        return false;
                    }else{
                        if(credits>=0&&credits<=student.getCredits()){
                            student.getEnrollCourses().add(courses.get(i));
                            courses.get(i).getEnrollStudent().add(student);
                            courses.get(i).getCredits().add(credits);
                            student.setCredits(student.getCredits()-credits);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(IfOpen){
            for(int i=0;i<courses.size();i++){
                if(courseId.equals(courses.get(i).getCourseID())){
                    if(student.getEnrollCourses().contains(courses.get(i))){
                        if(credits<=(student.getCredits()+courses.get(i).getCredits().get(courses.get(i).getEnrollStudent().indexOf(student)))){
                            student.setCredits(student.getCredits()+courses.get(i).getCredits().get(courses.get(i).getEnrollStudent().indexOf(student))-credits);
                            courses.get(i).getCredits().set(courses.get(i).getEnrollStudent().indexOf(student),credits);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(IfOpen){
            for(int i=0;i<courses.size();i++){
                if(courseId.equals(courses.get(i).getCourseID())){
                    if(student.getEnrollCourses().contains(courses.get(i))){
                        student.setCredits(student.getCredits()+courses.get(i).getCredits().get(courses.get(i).getEnrollStudent().indexOf(student)));
                        student.getEnrollCourses().remove(courses.get(i));
                        courses.get(i).getCredits().remove(courses.get(i).getEnrollStudent().indexOf(student));
                        courses.get(i).getEnrollStudent().remove(student);

                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){

        setIfOpen(false);
        for(int i=0;i<courses.size();i++){
            String[][] array = new String[students.size()][2];
            for(int j=0,k=0;j<students.size();j++){
                if(students.get(j).getEnrollCourses().contains(courses.get(i))){
                    array[k][0] = students.get(j).getStudentID();
                    array[k][1] = String.valueOf(courses.get(i).getCredits().get(courses.get(i).getEnrollStudent().indexOf(students.get(j))));
                    k++;
                }
            }
            for(int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                for(int k=0;k<courses.get(i).getEnrollStudent().size()-1;k++){
                    if(Integer.parseInt(array[k][1])<Integer.parseInt(array[k+1][1])){
                        String x = array[k][0];
                        String y = array[k][1];
                        array[k][0] = array[k+1][0];
                        array[k][1] = array[k+1][1];
                        array[k+1][0] = x;
                        array[k+1][1] = y;
                    }
                }
            }
            if(courses.get(i).getMaxCapacity()>=courses.get(i).getEnrollStudent().size()){
                for(int j=0;j<courses.get(i).getEnrollStudent().size();j++){
                    int tempi = 0;
                    for(int k=0;k<courses.get(i).getEnrollStudent().size();k++){
                        if(array[j][0].equals(courses.get(i).getEnrollStudent().get(k).getStudentID())){
                            tempi = k;
                        }
                    }
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(tempi));
                    students.get(tempi).getSuccessCourses().add(courses.get(i));
                }
            }else{
                if(Integer.parseInt(array[courses.get(i).getMaxCapacity()-1][1])>Integer.parseInt(array[courses.get(i).getMaxCapacity()][1])){
                    for(int j=0;j<courses.get(i).getMaxCapacity();j++){
                        int tempi = 0;
                        for(int k=0;k<courses.get(i).getEnrollStudent().size();k++){
                            if(array[j][0].equals(courses.get(i).getEnrollStudent().get(k).getStudentID())){
                                tempi = k;
                            }
                        }
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(tempi));
                        students.get(tempi).getSuccessCourses().add(courses.get(i));
                    }
                }else if(Integer.parseInt(array[courses.get(i).getMaxCapacity()-1][1])==Integer.parseInt(array[courses.get(i).getMaxCapacity()][1])){
                    int a = 0;
                    for(int j=0;j<courses.get(i).getMaxCapacity();j++){
                        if(array[j][1].equals(array[courses.get(i).getMaxCapacity()][1])){
                            a=j;
                            break;
                        }
                    }
                    for(int j=0;j<a;j++){
                        int tempi = 0;
                        for(int k=0;k<courses.get(i).getEnrollStudent().size();k++){
                            if(array[j][0].equals(courses.get(i).getEnrollStudent().get(k).getStudentID())){
                                tempi = k;
                            }
                        }
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(tempi));
                        students.get(tempi).getSuccessCourses().add(courses.get(i));
                    }
                }
            }
        }
    }

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(IfOpen){
            ArrayList<String> a = new ArrayList<>();
            for(int i=0;i<student.getEnrollCourses().size();i++){
                a.add(student.getEnrollCourses().get(i).getCourseID()+": "+String.valueOf(student.getEnrollCourses().get(i).getCredits().get(student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student))));
            }
            return a;
        }
        return null;
    }
}
