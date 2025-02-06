import java.util.ArrayList;



public class CourseManager {
    private ArrayList<Course> courses;
// Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students;
// Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.

    private boolean ifOpen;
// Represent system open(true) or not(false).

    public CourseManager(){
        students=new ArrayList<>();
        courses=new ArrayList<>();
        this.ifOpen=true;
    }
// Constructor, initializes the course and student lists, and set the system default status open(true).

    public ArrayList<Student> getStudents(){
        return students;
    }
// getter for students

    public ArrayList<Course> getCourses(){
        return courses;

    }
// getter for courses

    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }
// setter for ifOpen

    public boolean getIfOpen(){
        return ifOpen;
    }
// getter for ifOpen

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);


    }
    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager.
    // It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);

    }
    // Register a student. Add a student object to students and set the courseManager of the student object to this manager.
    //It is guaranteed that all studentIDs are unique.

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen == false) {
            return false;
        }
        boolean flag1 = false;
        Course cou1 = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                cou1 = courses.get(i);
                if (cou1.getEnrollStudent().contains(student)) return false;
                flag1 = true;
            }
        }
        if (!flag1) return false;

        if (credits <= 0) {
            return false;
        }
        if (student.getCredits() < credits) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(cou1);
        cou1.getEnrollStudent().add(student);
        cou1.getCredits().add(credits);
        return true;


    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!ifOpen) {
            return false;
        }

        boolean flag2 = false;
        Course cou1 = null;
        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getCourseID().equals(courseId)) {
                cou1 = courses.get(i);
                if (!cou1.getEnrollStudent().contains(student)) return false;
                flag2 = true;
            }
        }
        if (!flag2) return false;

        if (credits <= 0) {
            return false;
        }
        int index=cou1.getEnrollStudent().indexOf(student);
        int already=cou1.getCredits().get(index);
        if (student.getCredits()+already < credits) {
            return false;
        }

        student.setCredits(student.getCredits()+already-credits);
      //  student.getEnrollCourses().add(cou1);
        cou1.getCredits().set(index,credits);

        return true;

    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!ifOpen) {
            return false;
        }
        for(int j =0 ; j < student.getEnrollCourses().size() ; j++){
            Course cou2=student.getEnrollCourses().get(j);

            if(cou2.getCourseID().equals(courseId)){
                int index=cou2.getEnrollStudent().indexOf(student);
                int already=cou2.getCredits().get(index);
                student.getEnrollCourses().remove(cou2);
                student.setCredits(student.getCredits()+already);
                cou2.getCredits().remove(index);
                cou2.getEnrollStudent().remove(student);
                return true;


            }
        }
        return  false;


    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        ifOpen= false;
        for(int j=0 ; j < courses.size() ; j++){
            Course cou=courses.get(j);
           
            if(cou.getEnrollStudent().size()<=cou.getMaxCapacity()){
                cou.getSuccessStudents().addAll(cou.getEnrollStudent());

            } else{
                int max=0;
                for(int i =0; i < cou.getCredits().size();i++){
                    if(cou.getCredits().get(i)>max){
                        max=cou.getCredits().get(i);
                    }
                }
                int upperbound;

                while(true) {
                    int h = 0;
                    for (int k = 0; k < cou.getEnrollStudent().size(); k++) {
                        if (max <= cou.getCredits().get(k)) {
                            h++;
                        }
                    }
                    if (h > cou.getMaxCapacity()) {
                        upperbound = max + 1;
                        break;
                    } else {
                        max--;
                    }
                }
                for(int g = 0; g < cou.getCredits().size(); g++){
                    if(upperbound <= cou.getCredits().get(g)){
                        cou.getSuccessStudents().add(cou.getEnrollStudent().get(g));
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
        ArrayList<String> c=new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size();i++) {
            Course cou3 = student.getEnrollCourses().get(i);
            int index = cou3.getEnrollStudent().indexOf(student);
            int already = cou3.getCredits().get(index);
            String b=cou3.getCourseID() + ": " + already;
            c.add(b);
        }

        return c;
    }



}
