import java.util.*;
public class CourseManager {
    private ArrayList<Course> courses=new ArrayList<Course>();
    // Maintains a record of all courses successfully registered.
    // It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students=new ArrayList<Student>();
    // Maintains a record of all students successfully registered.
    // It is guaranteed that courses student enrolled in must exist in courses.
    private boolean ifOpen;
    // Represent system open(true) or not(false).




    public CourseManager(){

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

    }    // setter for ifOpen

    public boolean getIfOpen(){
        return ifOpen;
    }
    // getter for ifOpen




    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);

    }    // Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.
    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        Course course = ifCourseHas(courseId);
        if(!(this.ifOpen)){
            return false;
        }else if(credits<=0){
            return false;
        }else if (ifCourseHas(courseId)==null){
            return false;
        }else if(ifStudentChoose(student,courseId)){
            return false;
        } else if (student.getCredits()<credits) {
            return false;
        } else {
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            student.getEnrollCourses().add(course);
            student.setCredits(student.getCredits()-credits);
            return true;
        }
    }
    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(ifCourseHas(courseId)==null){
            return false;
        }else if (!ifOpen){
            return false;
        }else if(!(ifStudentChoose(student,courseId))){
            return false;
        }else if(ifCreditsRational(student,courseId,credits)){
            return false;
        }else {
            return true;
        }
    }    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }
        if(ifCourseHas(courseId)==null){
            return false;
        }else if(!(ifStudentChoose(student,courseId))){
            return false;
        }else {
            Course course = ifCourseHas(courseId);
            student.setCredits(student.getCredits()+course.getCredits().get(course.getEnrollStudent().indexOf(student)));
            course.getCredits().remove(course.getEnrollStudent().indexOf(student));
            course.getEnrollStudent().remove(student);
            student.getEnrollCourses().remove(course);
            return true;
        }
    }
    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        this.ifOpen=false;
        for (Course i : courses){
            int minCredit=0;
            ArrayList<Integer> temp = (ArrayList<Integer>) i.getCredits().clone();
            temp.sort(Comparator.naturalOrder());
            if (temp.size()>i.getMaxCapacity()){
                if(temp.get(temp.size()-i.getMaxCapacity())==temp.get(temp.size()-i.getMaxCapacity()-1)){
                    if (temp.lastIndexOf(temp.get(temp.size()-i.getMaxCapacity()))+1<temp.size()){
                        minCredit = temp.get(temp.lastIndexOf(temp.get(temp.size()-i.getMaxCapacity()))+1);
                    }else {
                        continue;
                    }

                }else {
                    minCredit = temp.get(temp.size()-i.getMaxCapacity());
                }
            }
            for (int j=0;j<temp.size();j++){
                if (i.getCredits().get(j)>=minCredit){
                    i.getSuccessStudents().add(i.getEnrollStudent().get(j));
                    i.getEnrollStudent().get(j).getSuccessCourses().add(i);
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
        if (!ifOpen){
            return null;
        }
        ArrayList<String> temp = new ArrayList<>();
        for (Course course:courses){
            String courseID,credit;
            if (!course.getEnrollStudent().contains(student)){
                continue;
            }
            courseID = course.getCourseID();
            credit = course.getCredits().get(course.getEnrollStudent().indexOf(student)).toString();
            temp.add(courseID+": "+credit);
        }
        return temp;
    }
    public Course ifCourseHas(String courseID){
        Course temp = null;
        for(Course i : courses){
            if(i.getCourseID().equals(courseID)){
                temp=i;
            }
        }
        return temp;
    }
    public boolean ifStudentChoose(Student student,String courseID){
        for(Course i : student.getEnrollCourses()){
            if(i.getCourseID().equals(courseID)){
                return  true;
            }
        }
        return false;
    }
    public boolean ifCreditsRational(Student student, String courseId, int credits){
       Course temp = ifCourseHas(courseId);
       for (int i=0;i<temp.getEnrollStudent().size();i++){
           if (temp.getEnrollStudent().get(i)==student){
               if (student.getCredits()+temp.getCredits().get(i)<credits){
                   return true;
               }else {
                   student.setCredits(student.getCredits()+temp.getCredits().get(i)-credits);
                   temp.getCredits().set(i,credits);
                   return false;
               }
           }
       }
       return false;
    }


    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
}

