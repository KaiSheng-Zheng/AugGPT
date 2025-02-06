
import java.util.ArrayList;


public class CourseManager{
    private ArrayList<Course> courses;
// Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.

    private ArrayList<Student> students;
// Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.

    private boolean ifOpen;
// Represent system open(true) or not(false).


    public CourseManager(ArrayList<Course> courses, ArrayList<Student> students) {
        this.courses = courses;
        this.students = students;
        this.ifOpen = true;
    }

    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student) {

        students.add(student);
        student.setCourseManager(this);
    }
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        int temp = -1;
        if(credits < 0 ) return false;

        if (!getIfOpen()) return false;
        if(getCourses().isEmpty()) return false;
        for (int i = 0; i < getCourses().size(); i++) {
            if (getCourses().get(i).getCourseID().equals(courseId)) {
                temp = i;
                break;
            }
        }
        if(temp == -1) return  false;
        if (student.getCredits() >= credits && ! student.getEnrollCourses().contains(getCourses().get(temp))) {
            student.setCredits((student.getCredits() - credits));
            student.getEnrollCourses().add(getCourses().get(temp));
            getCourses().get(temp).getEnrollStudent().add(student);
            getCourses().get(temp).getCredits().add(credits);
            return true;

        }
        else return false;

    }
    /*
     *
     * ok Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * ok Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        int temp1 = -1;
        int temp2 = 0;
        if(!getIfOpen()) return false;
        if(student.getEnrollCourses().isEmpty()) return false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                temp1 = i;
                break;
            }
        }
        if(temp1 == -1) return  false;
        if(!student.getEnrollCourses().isEmpty()) {
            if (!student.getEnrollCourses().get(temp1).getEnrollStudent().isEmpty()) {
                for (int i = 0; i < student.getEnrollCourses().get(temp1).getEnrollStudent().size(); i++) {
                    if (student.getEnrollCourses().get(temp1).getEnrollStudent().get(i).equals(student)) {
                        temp2 = i;
                        break;
                    }
                }
            }
        }
        if(!student.getEnrollCourses().isEmpty()) {
            if (!student.getEnrollCourses().get(temp1).getEnrollStudent().isEmpty()) {
                student.setCredits(student.getCredits() + student.getEnrollCourses().get(temp1).getCredits().get(temp2));
                if(student.getCredits() < credits) return false;
                student.setCredits(student.getCredits()-credits);
                student.getEnrollCourses().get(temp1).getCredits().set(temp2,credits);
            }
        }


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
        int temp1=-1;
        int temp2=0;
        if(!getIfOpen()) return false;
        if(student.getEnrollCourses().isEmpty()) return false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                temp1 = i;
                break;
            }
        }
        if(temp1 == -1) return false;
        if(!student.getEnrollCourses().isEmpty()) {
            if (!student.getEnrollCourses().get(temp1).getEnrollStudent().isEmpty()) {
                for (int i = 0; i < student.getEnrollCourses().get(temp1).getEnrollStudent().size(); i++) {
                    if (student.getEnrollCourses().get(temp1).getEnrollStudent().get(i).equals(student)) {
                        temp2 = i;
                        break;
                    }
                }
                student.setCredits(student.getCredits() + student.getEnrollCourses().get(temp1).getCredits().get(temp2));
                student.getEnrollCourses().get(temp1).getEnrollStudent().remove(temp2);
                student.getEnrollCourses().get(temp1).getCredits().remove(temp2);
                student.getEnrollCourses().remove(student.getEnrollCourses().get(temp1));
            }
        }
        return true;
    }



    /**
     * ok Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        setIfOpen(false);
        for (Course course : courses) {
            ArrayList<Student> enrollStudents = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            int num = 0;
            if(enrollStudents.isEmpty()) continue;
            if(credits.isEmpty()) continue;
            if(course.getSuccessStudents().isEmpty()) num = course.getMaxCapacity();
            else num = course.getMaxCapacity()-course.getSuccessStudents().size();
            for (int i = 0; i < enrollStudents.size() - 1; i++) {
                for (int j = 0; j < enrollStudents.size() - i - 1; j++) {

                    if (credits.get(j) < credits.get(j + 1)) {
                        Student tempStudent = enrollStudents.get(j);
                        enrollStudents.set(j, enrollStudents.get(j + 1));
                        enrollStudents.set(j + 1, tempStudent);
                        int tempCredits = credits.get(j);
                        credits.set(j, credits.get(j + 1));
                        credits.set(j + 1, tempCredits);
                    }
                }
            }


            int numMingE = enrollStudents.size();
            if(num<enrollStudents.size()) {
                numMingE = num;
                while(numMingE > 0 && credits.get(numMingE - 1).equals(credits.get(numMingE))){
                numMingE--;
                }
            }
            for (int i = 0; i < numMingE; i++) {
                course.getSuccessStudents().add(enrollStudents.get(i));
                enrollStudents.get(i).getSuccessCourses().add(course);
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
        if(!getIfOpen()) return null;

        ArrayList<String> ans = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {

            int temp = -1;
            if(course.getCredits().isEmpty()) continue;
            for (int i = 0; i < course.getCredits().size(); i++) {
                if(course.getEnrollStudent().get(i).equals(student)) {
                    temp = i;
                    break;
                }
            }
            if(temp == -1) continue;

            ans.add(course.getCourseID()+": " + course.getCredits().get(temp));
        }
        return ans;
    }
}




