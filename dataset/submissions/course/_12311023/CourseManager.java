import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void setIfOpen(Boolean ifOpen){
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen(){
        return this.ifOpen;
    }

    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not
     already enrolled, the credits is greater than 0, and they have enough credits to
     bid.
     * If successful, the student's credits will be reduced by the amount bid on the
     course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean Returns true if student enroll this course successfully;
    otherwise, it returns false.
     */

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        boolean courseTest = false;
        boolean isIn = false;
        int record = 0;

        for(int counter = 0; counter < courses.size(); counter++){
            if (courses.get(counter).getCourseID().equals(courseId)){
                courseTest = true;
                record = counter;
            }
        }

        for(int counter = 0; counter < student.getEnrollCourses().size(); counter++){
            if (student.getEnrollCourses().get(counter).getCourseID().equals(courseId)){
                isIn = true;
            }
        }

        if (ifOpen){
            if (courseTest && !isIn) {
                if (credits > 0 && credits <= student.getCredits()) {

                    student.setCredits(student.getCredits() - credits);
                    ArrayList<Course> tempEnrollCourses = new ArrayList<>();
                    tempEnrollCourses.addAll(student.getEnrollCourses());
                    tempEnrollCourses.add(courses.get(record));
                    student.setEnrollCourses(tempEnrollCourses);
                    //operator on Student-EnrollCourses

                    ArrayList<Integer> tempCredits = new ArrayList<>();
                    tempCredits.addAll(courses.get(record).getCredits());
                    tempCredits.add(credits);
                    courses.get(record).setCredits(tempCredits);
                    //operator on Course-Credits

                    ArrayList<Student> tempEnrollStudents = new ArrayList<>();
                    tempEnrollStudents.addAll(courses.get(record).getEnrollStudent());
                    tempEnrollStudents.add(student);
                    courses.get(record).setEnrollStudent(tempEnrollStudents);
                    //operator on Course-EnrollStudent

                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled
     course.
     * The modification will only be successful if the course exists, the student is
     currently enrolled in the course,and the new bid is within the student's
     available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to
     reflect the new bid amount. The corresponding list in Student and Course should
     be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean Returns true if the bid modification was successful;
    otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        boolean courseTest = false;
        boolean isIn = false;
        int record1 = 0;
        int record2 = 0;

        for(int counter = 0; counter < courses.size(); counter++){
            if (courses.get(counter).getCourseID().equals(courseId)){
                courseTest = true;
                record1 = counter;
            }
        }

        for(int counter = 0; counter < student.getEnrollCourses().size(); counter++){
            if (student.getEnrollCourses().get(counter).getCourseID().equals(courseId)){
                isIn = true;
            }
        }

        for(int counter = 0; counter < courses.get(record1).getEnrollStudent().size(); counter++){
            if (courses.get(record1).getEnrollStudent().get(counter).equals(student)){
                record2 = counter;
            }
        }

        if(ifOpen){
            if(courseTest && isIn){
                if(credits - courses.get(record1).getCredits().get(record2) <= student.getCredits() && credits > 0){

                    student.setCredits(student.getCredits() + courses.get(record1).getCredits().get(record2) - credits);

                    ArrayList<Integer> tempCredits= new ArrayList<>();
                    tempCredits.addAll(courses.get(record1).getCredits());
                    tempCredits.set(record2, credits);
                    courses.get(record1).setCredits(tempCredits);

                    return true;

                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently
     enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid
     for this course will be refunded in full. The corresponding list in Student and
     Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean Returns true if the student successfully drops the course;
    otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        boolean courseTest = false;
        boolean isIn = false;
        int record1 = 0;
        int record2 = 0;
        int record3 = 0;

        for(int counter = 0; counter < courses.size(); counter++){
            if (courses.get(counter).getCourseID().equals(courseId)){
                courseTest = true;
                record1 = counter;
            }
        }

        for(int counter = 0; counter < student.getEnrollCourses().size(); counter++){
            if (student.getEnrollCourses().get(counter).getCourseID().equals(courseId)){
                isIn = true;
            }
        }

        for(int counter = 0; counter < courses.get(record1).getEnrollStudent().size(); counter++){
            if (courses.get(record1).getEnrollStudent().get(counter).equals(student)){
                record2 = counter;
            }
        }

        for(int counter = 0; counter < student.getEnrollCourses().size(); counter++){
            if (student.getEnrollCourses().get(counter).getCourseID().equals(courseId)){
                record3 = counter;
            }
        }

        if(ifOpen){

            if (courseTest && isIn){
                ArrayList<Student> tempEnrollStudent = new ArrayList<>();
                ArrayList<Integer> tempCredits = new ArrayList<>();
                ArrayList<Course> tempEnrollCourses = new ArrayList<>();

                tempEnrollStudent.addAll(courses.get(record1).getEnrollStudent());
                tempEnrollStudent.remove(record2);
                courses.get(record1).setEnrollStudent(tempEnrollStudent);

                tempCredits.addAll(courses.get(record1).getCredits());
                student.setCredits(courses.get(record1).getCredits().get(record2) + student.getCredits());
                tempCredits.remove(record2);
                courses.get(record1).setCredits(tempCredits);

                tempEnrollCourses.addAll(student.getEnrollCourses());
                tempEnrollCourses.remove(record3);
                student.setEnrollCourses(tempEnrollCourses);

                return true;

            }else {

                return false;

            }
        }else {
            return false;
        }
    }


    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids
     and the course capacities. Students with higher bids are prioritized. The
     corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need
     to be updated.
     */
    public void finalizeEnrollments(){
        ifOpen = false;
        for (int counter1 = 0; counter1 < courses.size(); counter1++){
            ArrayList<Student> copyEnrollStudent = new ArrayList<>();
            ArrayList<Student> bufferEnrollStudent = new ArrayList<>();
            ArrayList<Integer> copyCredits = new ArrayList<>();
            ArrayList<Integer> bufferCredits = new ArrayList<>();


            copyEnrollStudent.addAll(courses.get(counter1).getEnrollStudent());
            bufferEnrollStudent.addAll(courses.get(counter1).getEnrollStudent());
            copyCredits.addAll(courses.get(counter1).getCredits());
            bufferCredits.addAll(courses.get(counter1).getCredits());


            for (int counter2 = 0; counter2 < copyCredits.size(); counter2 ++){
                ;
                int tempPosition = counter2;
                for (int counter3 = counter2; counter3 < copyCredits.size(); counter3 ++) {
                    if (copyCredits.get(counter3) >= copyCredits.get(tempPosition)) {
                        tempPosition = counter3;
                    }
                }

                bufferEnrollStudent.set(counter2,copyEnrollStudent.get(tempPosition));
                bufferEnrollStudent.set(tempPosition,copyEnrollStudent.get(counter2));
                copyEnrollStudent.set(counter2,bufferEnrollStudent.get(counter2));
                copyEnrollStudent.set(tempPosition,bufferEnrollStudent.get(tempPosition));

                bufferCredits.set(counter2,copyCredits.get(tempPosition));
                bufferCredits.set(tempPosition,copyCredits.get(counter2));
                copyCredits.set(counter2,bufferCredits.get(counter2));
                copyCredits.set(tempPosition,bufferCredits.get(tempPosition));

            }
            //this cyclone complete the reorder of list according to the credits

            int validPosition = - 1;
            int position;
            if(copyEnrollStudent.size() > courses.get(counter1).getMaxCapacity()){
                for ( position = courses.get(counter1).getMaxCapacity() - 1; position >= 0; position --){
                    if(copyCredits.get(position) > copyCredits.get(position + 1)){
                        validPosition = position;
                        break;
                    }
                }
            }else {
                validPosition=copyEnrollStudent.size()-1;
            }

            ArrayList<Student> tempSuccessStudents = new ArrayList<>();

            for (int counter4 = 0; counter4 < validPosition + 1; counter4++){

                tempSuccessStudents.add(copyEnrollStudent.get(counter4));

                ArrayList<Course> tempSuccessCourses = new ArrayList<>();
                tempSuccessCourses.addAll(courses.get(counter1).getEnrollStudent().get(counter4).getSuccessCourses());
                tempSuccessCourses.add(courses.get(counter1));
                courses.get(counter1).getEnrollStudent().get(counter4).setSuccessCourses(tempSuccessCourses);

            }

            courses.get(counter1).setSuccessStudents(tempSuccessStudents);



        }

    }


    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the
     student in enrollCourses, follow the format: "courseID: enrollmentCredits"
     (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective
    credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){

        if(ifOpen){
            ArrayList<String> tempEnrolledCoursesWithCredits = new ArrayList<>();
            for(int counter1 = 0; counter1 < student.getEnrollCourses().size(); counter1 ++){

                int index1 = 0;
                for (int counter2 = 0; counter2 < courses.size(); counter2++){
                    if (courses.get(counter2).getCourseID().equals(student.getEnrollCourses().get(counter1).getCourseID())) {
                        index1 = counter2;
                    }
                }

                int index2 = 0;
                for (int counter3 = 0; counter3 < courses.get(index1).getEnrollStudent().size(); counter3++){
                    if (courses.get(index1).getEnrollStudent().get(counter3).getStudentID().equals(student.getStudentID())){
                        index2 = counter3;
                    }
                }


                tempEnrolledCoursesWithCredits.add(String.format(student.getEnrollCourses().get(counter1).getCourseID() + ": " + courses.get(index1).getCredits().get(index2)));
            }

            return tempEnrolledCoursesWithCredits;

        }else {
            return null;
        }

    }
}
