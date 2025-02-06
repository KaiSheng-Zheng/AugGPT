import java.util.*;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;


    public CourseManager() {
        courses = new ArrayList<Course>();
        this.students = new ArrayList<Student>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
// getter for students

    public ArrayList<Course> getCourses() {
        return courses;
    }
// getter for courses

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
// setter for ifOpen

    public boolean getIfOpen() {
        return ifOpen;
    }
// getter for ifOpen

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen == false) {
            return false;
        } else ;


        int index = -1;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                index = i;
            } else ;
        }
        if (index == -1) {
            return false;
        } else ;

        ArrayList<Course> enroll = student.getEnrollCourses();
        for (int i = 0; i < enroll.size(); i++) {
            if (enroll.get(i).getCourseID().equals(courseId)) {
                return false;
            } else ;
        }

        if (credits <= 0) {
            return false;
        } else if (student.getCredits() < credits) {
            return false;
        } else {
            student.setCredits(student.getCredits() - credits);
        }
        enroll.add(courses.get(index));
        courses.get(index).getEnrollStudent().add(student);
        courses.get(index).getCredits().add(credits);
        return true;
    }

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled,
     * the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course.
     * The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen == false) {
            return false;
        } else ;

        int index = -1;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                index = i;
            } else ;
        }
        if (index == -1) {
            return false;
        } else ;

        ArrayList<Course> enroll = student.getEnrollCourses();

        int x = 0;
        for (int i = 0; i < enroll.size(); i++) {
            if (enroll.get(i).getCourseID().equals(courseId)) {
                ArrayList<Student> enrollstu = enroll.get(i).getEnrollStudent();
                ArrayList<Integer> cred = enroll.get(i).getCredits();

                x = enrollstu.indexOf(student);
                int oldcredit = cred.get(x);
                int oldshengyu = student.getCredits();

                if ((oldshengyu - (credits - oldcredit)) < 0) {
                    return false;
                } else ;
                student.getEnrollCourses().get(i).getCredits().set(x, credits);
                student.setCredits(oldshengyu - credits + oldcredit);
                return true;
            } else ;
        }
        return false;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits.
     * This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen == false) {
            return false;
        } else ;

        int index2 = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                index2 = i;
            } else ;
        }
        if (index2 == -1) {
            return false;
        } else ;

        int x = 0;
        ArrayList<Course> enroll = student.getEnrollCourses();
        for (int i = 0; i < enroll.size(); i++) {
            if (enroll.get(i).getCourseID().equals(courseId)) {
                ArrayList<Student> enrollstu = enroll.get(i).getEnrollStudent();
                ArrayList<Integer> cred = enroll.get(i).getCredits();
                x = enrollstu.indexOf(student);
                int oldcredit = cred.get(x);
                int oldshengyu = student.getCredits();



                Course tempcourse=enroll.get(i);
                int ind=tempcourse.getEnrollStudent().indexOf(student);
                tempcourse.getEnrollStudent().remove(student);
                tempcourse.getCredits().remove(ind);
                student.getEnrollCourses().remove(index2);

                student.setCredits(oldshengyu + oldcredit);
            }
        }
        return true;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full.
     * The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public void finalizeEnrollments() {
        ifOpen = false;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCredits().size() <= courses.get(i).getMaxCapacity()) {
                courses.get(i).setSuccessStudents(courses.get(i).getEnrollStudent());
            }
            else {
                ArrayList<Integer> enrollcredits=new ArrayList<>();
                for(int j=0;j<courses.get(i).getCredits().size();j++){
                    enrollcredits.add(j,courses.get(i).getCredits().get(j));
                }
                Collections.sort(enrollcredits, Collections.reverseOrder());
                while(enrollcredits.size()<courses.get(i).getMaxCapacity()){
                    enrollcredits.add(0);
                }

              //  enrollcredits= new ArrayList<>(enrollcredits.subList(0, courses.get(i).getMaxCapacity()-1));

                int critical= enrollcredits.get(courses.get(i).getMaxCapacity() - 1);
                int numstud=0;
                for(int n=0;n<courses.get(i).getCredits().size();n++){
                    if(courses.get(i).getCredits().get(n)>=critical){
                        numstud=numstud+1;
                    }else ;
                }
           
                if(numstud==courses.get(i).getMaxCapacity()){
                    ArrayList<Student> successStudents = new ArrayList<>();
                    for(int j=0;j<courses.get(i).getCredits().size();j++){
                        if(courses.get(i).getCredits().get(j)>=critical){

                            successStudents.add(courses.get(i).getEnrollStudent().get(j));
                            courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                        }else;
                    }
                    courses.get(i).setSuccessStudents(successStudents);
                }else {
                    ArrayList<Student> successStudents = new ArrayList<>();
                    for(int j=0;j<courses.get(i).getCredits().size();j++){
                        if(courses.get(i).getCredits().get(j)>critical){
                            successStudents.add(courses.get(i).getEnrollStudent().get(j));
                            courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                        }else;
                    }
                    courses.get(i).setSuccessStudents(successStudents);
                }
            }
        }
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities.
     * Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
            if(ifOpen==false){
                return null;
            }else;
            int index3=0;
            for(int i=0;i<students.size();i++){
                if(students.get(i).equals(student)){
                    index3=i;
                }else;
            }

            int index4=0;
            ArrayList<String> courwithcredit=new ArrayList<>();
            ArrayList<Integer> credi=new ArrayList<>();

                for(int k=0;k<student.getEnrollCourses().size();k++){
                    Course tempcourse=student.getEnrollCourses().get(k);
                    credi.add(tempcourse.getCredits().get(tempcourse.getEnrollStudent().indexOf(student)));
                    courwithcredit.add(student.getEnrollCourses().get(k).getCourseID()+": "+credi.get(k));
                }


            return courwithcredit;

    }
    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses,
     * follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
}
