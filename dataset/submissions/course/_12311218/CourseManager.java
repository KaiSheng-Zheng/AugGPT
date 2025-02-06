import java.util.ArrayList;
import java.util.Arrays;

class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

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

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    // Register a student. Add a student object to students and set the courseManager of the student object to this manager.
    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen){return false;}
        if(student.getCredits()<credits||credits<1){return false;}
        int index=find(courseId,courses);
        if(index==-1){return false;}
        if(courses.get(index).getEnrollStudent().contains(student)){return false;}

        student.setCredits(student.getCredits()-credits);
        student.getEnrollCourses().add(courses.get(index));

        courses.get(index).getEnrollStudent().add(student);
        courses.get(index).getCredits().add(credits);
        return true;
    }
    public static int find(String Id,ArrayList<Course> courses ){
        for (Course course:courses){
            if (Id.equals(course.getCourseID())){
                return courses.indexOf(course);
            }
        }
        return -1;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){return false;}
        int index=find(courseId,courses);
        if(index==-1){return false;}
        if (!student.getEnrollCourses().contains(courses.get(index))){return false;}
        int CreditsIndex=courses.get(index).getEnrollStudent().indexOf(student);
        int FormerCredits = courses.get(index).getCredits().get(CreditsIndex);
        int creditsLeft=student.getCredits()+FormerCredits-credits;
        if (creditsLeft<0){return false;}
        courses.get(index).getCredits().set(CreditsIndex,credits);
        student.setCredits(creditsLeft);
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
        if(!ifOpen){return false;}
        int index=find(courseId,courses);
        if(index==-1){return false;}
        if (!student.getEnrollCourses().contains(courses.get(index))){return false;}
        int CreditsIndex=courses.get(index).getEnrollStudent().indexOf(student);
        int FormerCredits = courses.get(index).getCredits().get(CreditsIndex);
        student.getEnrollCourses().remove(courses.get(index));
        courses.get(index).getEnrollStudent().remove(CreditsIndex);
        courses.get(index).getCredits().remove(CreditsIndex);
        student.setCredits(student.getCredits()+FormerCredits);
        return true;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments(){
        ifOpen=false;
        for(Course course:courses){
            if (course.getCredits().isEmpty()){continue;}
            int min;
            int[] credit = tointArray(course.getCredits());
            int[] L_Credit=tointArray(course.getCredits());
            Arrays.sort(L_Credit);
            ArrayList<Integer> successCredits= new ArrayList<>(course.getCredits().size());
            int limit=dropCredits(course.getMaxCapacity(),counter(L_Credit));
            for (int i = 0; i < course.getCredits().size(); i++) {
                if (credit[i]<limit){
                    continue;
                }
                successCredits.add(course.getCredits().get(i));
                course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                course.getEnrollStudent().get(i).getSuccessCourses().add(course);
            }
            course.setCredits(successCredits);
        }
    }
    public  static int[] tointArray(ArrayList<Integer> arrayList){
        int[] intArray = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            intArray[i]= arrayList.get(i);
        }
        return intArray;
    }
    public static int[] counter(int[] credits){
        int[] counter=new int[credits[credits.length-1]+1];
        for (int i = 0; i < credits.length; i++) {
            counter[credits[i]]++;
        }
        return counter;
    }
    public static int dropCredits(int capacity ,int[] credits){
        int numOfStudents=0;
        int limit=0;
        for (int i = credits.length-1; i >=0 ; i--) {
            numOfStudents+=credits[i];
            if (numOfStudents>capacity){limit=i+1;break;}
        }
        return limit;
    }

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen){return null;}
        ArrayList<String> CoursesWithCredits=new ArrayList<>();
        int index=0;
        for (Course courses:student.getEnrollCourses()){
            index=courses.getEnrollStudent().indexOf(student);
            String brand;
            brand = courses.getCourseID() +": "+ courses.getCredits().get(index);
            CoursesWithCredits.add(brand);
        }
        return CoursesWithCredits;
    }
}