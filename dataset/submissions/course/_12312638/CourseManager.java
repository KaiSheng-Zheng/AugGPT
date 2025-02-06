import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;



    //Constructor
    public CourseManager() {
        this.ifOpen = true;

        //Initialize Arraylist
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();

    }

    //methods
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        getCourses().add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        getStudents().add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {

        //IfCourseExist
        Course chooseCourse = null;
        boolean isCourseExist = false;
        for(int i=0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseId)  ){
                isCourseExist = true;
                chooseCourse = courses.get(i);
                break;
            }
        }

        //IfStudentNotEnrolled
        boolean notEnrolled = true;



            for(int i=0; i < student.getEnrollCourses().size(); i++) {
                if(student.getEnrollCourses().get(i).getCourseID().equals(courseId) ) {
                    notEnrolled = false; // enrolled
                    break;
                }
            }



        if(getIfOpen()) {
            if(credits > 0){
                if(student.getCredits() >= credits) {
                    if(isCourseExist){
                        if(notEnrolled){

                            // students credits will be reduced
                            int newCredits = student.getCredits() - credits;
                            student.setCredits(newCredits);


                            // -add student into enroll student list
                            chooseCourse.getEnrollStudent().add(student);

                            // -add points into course credits list(need to check back)
                            chooseCourse.getCredits().add(credits);

                            // -add course into enrolled courses list
                            student.getEnrollCourses().add(chooseCourse);


                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
//        System.out.println("here it passes");
        //IfCourseExist
        boolean isCourseExist = false;
        for(int i=0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseId)  ){
                isCourseExist = true;
                break;
            }
        }

        //IfStudentEnrolled
        int studentIndex = 0;
        Course specificCourse = null;
        int currentCourseCredits = 0;
        boolean alreadyEnrolled = false;


            for(int i=0; i < student.getEnrollCourses().size(); i++) {
                if(student.getEnrollCourses().get(i).getCourseID().equals(courseId) ) {
                    alreadyEnrolled = true;
                    specificCourse = student.getEnrollCourses().get(i);
                    //get studentIndex and then credit index they are the same

                    break;
                }

            }


if(specificCourse != null) {
    for(int j=0; j< specificCourse.getEnrollStudent().size(); j++ ) {
        if(specificCourse.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID()) ) {
            studentIndex = j;
            currentCourseCredits = specificCourse.getCredits().get(j);
            break;
        }
    }
}
//        System.out.println(student.getCredits());

        int totalCredits = student.getCredits() + currentCourseCredits;

        if(getIfOpen()) {
            if(isCourseExist){
                if(alreadyEnrolled) {
                    if(credits > 0){
                        if(totalCredits >= credits){
                            // In students: update his/her remained credits
                            int newCredits = totalCredits - credits;
                            student.setCredits(newCredits);

                            //In course: update the corresponding credits according to the index
                            specificCourse.getCredits().set(studentIndex, credits);

//                            System.out.println(credits);
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {

        //IsCourseExist
        boolean isCourseExist = false;
        for(int i=0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseId)  ){
                isCourseExist = true;
                break;
            }
        }

        boolean alreadyEnrolled = false;

        Course specificCourse = null;
        int studentIndex = 0;

        int currentCourseCredits = 0;

        int courseIndex = 0;


            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).getCourseID().equals(courseId) ) {
                    alreadyEnrolled = true;
                    courseIndex = i;
                    specificCourse = student.getEnrollCourses().get(i);

                    break;
                }
            }


        if(specificCourse !=null) {
            //get studentIndex and then credit index they are the same
            for(int j=0; j< specificCourse.getEnrollStudent().size(); j++ ) {
                if(specificCourse.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID()) ) {
                    studentIndex = j;
                    currentCourseCredits = specificCourse.getCredits().get(j);
                    break;
                }
            }
        }


        if(getIfOpen()){
            if(isCourseExist) {
                if(alreadyEnrolled) {
                   // Remove the corresponding credits in credits list according to index
                    specificCourse.getCredits().remove(studentIndex);

                    //Remove the student in enrolled students list.
                    specificCourse.getEnrollStudent().remove(studentIndex);

                    //Remove enrolled course in course list.
                    student.getEnrollCourses().remove(courseIndex);

                    //Update the credits
                    int newCredits = student.getCredits() + currentCourseCredits;
                    student.setCredits(newCredits);
//                    System.out.println(student.getCredits());

                    return true;
                }
            }
        }

        return false;
    }




    public void finalizeEnrollments() {
        setIfOpen(false);

        // Extract each course
        for(int k=0; k< courses.size(); k++) {
            Course course = courses.get(k);



            //deep copy of arrayList
            if(!course.getCredits().isEmpty()) {                  //need to check back
                int maxCapacity = course.getMaxCapacity();    // size of max capacity
                int trueMaxCapacity = maxCapacity - 1;       //true max capacity for array

//                System.out.println(course.getCredits().size());
                ArrayList<Integer> copyCrdPoints = deepCopy(course.getCredits());
//                System.out.println(copyCrdPoints);

                //sort from large to small credits points
                Collections.sort(copyCrdPoints, Collections.reverseOrder());

//                System.out.println(copyCrdPoints.size());

                //take prioritize list
                if (copyCrdPoints.size() > maxCapacity) {

                //find at least possible credit point from sorted array
                int leastCredit = copyCrdPoints.get(trueMaxCapacity);
                int leastPlusCredit = copyCrdPoints.get(maxCapacity);


                ArrayList<Student> successStudentsList = new ArrayList<>();
                if (leastCredit == leastPlusCredit) {

                    for (int i = 0; i < course.getCredits().size(); i++) {
                        if (course.getCredits().get(i) > leastCredit) {
                            successStudentsList.add(course.getEnrollStudent().get(i));
                            course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                        }
                    }

                } else {

                    for (int i = 0; i < course.getCredits().size(); i++) {
                        if (course.getCredits().get(i) >= leastCredit) {
                            successStudentsList.add(course.getEnrollStudent().get(i));
                            course.getEnrollStudent().get(i).getSuccessCourses().add(course);

                        }
                    }
                }
                course.setSuccessStudents(successStudentsList);
            }
                // take all students
                if (copyCrdPoints.size() <= maxCapacity) {

                        course.setSuccessStudents(course.getEnrollStudent());


                    for (int i =0; i < course.getEnrollStudent().size(); i++) {
                        course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                    }
                }
            }
        }




    }

    private ArrayList<Integer> deepCopy(ArrayList<Integer> credits) {
        ArrayList<Integer> copiedList = new ArrayList<>();

        for (Integer item : credits) {
            copiedList.add(new Integer(item));
        }

        return copiedList;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        //1. New an ArrayList<String>
        ArrayList<String> enrolledCoursesWithCreditsList = new ArrayList<>();

        if(getIfOpen()){

                for(int i=0; i < student.getEnrollCourses().size(); i++) {
                    Course specificCourse = student.getEnrollCourses().get(i);

                    String courseID = specificCourse.getCourseID();
                    int studentCredits = 0;


                    //get studentIndex and then credit index they are the same
                    for(int j=0; j< specificCourse.getEnrollStudent().size(); j++ ) {
                        if(specificCourse.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID()) ) {
                            studentCredits =  specificCourse.getCredits().get(j);
                            break;
                        }
                    }
                    String combinedStr = courseID + ": " + Integer.toString(studentCredits);
                    enrolledCoursesWithCreditsList.add(combinedStr);
                }
//                System.out.println(enrolledCoursesWithCreditsList);
                return enrolledCoursesWithCreditsList;

        }
        return null;
    }

}

