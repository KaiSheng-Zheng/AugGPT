import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
        ifOpen = true;

    }

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
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {

        if (!this.ifOpen) {
            return false;
        }

        if (credits <= 0) {
            return false;
        }

        // check if course exist
        Course theCourse = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {

                theCourse = c;
                break;
            }
        }
        if (theCourse == null) {
            return false;
        }

        //check if students have not enrolled --> return true
        boolean studentNotEnroll = true;
        for (Course co : student.getEnrollCourses()) {
            if (co.getCourseID().equals(courseId)) {
                studentNotEnroll = false;
                break;
            }
        }
        if (!studentNotEnroll) {
            return false;
        }

        if (student.getCredits() < credits) {
            return false;
        }


        student.setCredits(student.getCredits() - credits); //leftover credits
        theCourse.getEnrollStudent().add(student);
        theCourse.getCredits().add(credits);
        student.getEnrollCourses().add(theCourse);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }

        //check if course exists
        Course theCourse = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                theCourse = c;
                break;
            }
        }

        if (theCourse == null) {
            return false;
        }


        //student already enrolled --> true
        boolean studentNotEnroll = true;

        for (Course co : student.getEnrollCourses()){
            if (co.getCourseID().equals(courseId)){ 
                studentNotEnroll = false;

                break;
            }
        }
        if (studentNotEnroll){
            return false;
        }


        int index = -1;
        for (int i = 0; i < theCourse.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(theCourse.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }

        int originalCredit = theCourse.getCredits().get(index); // credits of first bid
        if (credits > originalCredit + student.getCredits()) {
            return false;
        }
        student.setCredits(student.getCredits() + originalCredit - credits);
        theCourse.getCredits().set(index, credits);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }

        //check course exist
        Course theCourse = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                theCourse = c;
                break;
            }
        }
        if (theCourse == null){
            return false;
        }

        //student enrolled --> true
        boolean studentEnroll = false;

        for (Course co : student.getEnrollCourses()) {
            if (co.getCourseID().equals(courseId)){ // not yet enrolled
                studentEnroll = true;


            }
        }
        if (!studentEnroll){
            return false;
        }



        int indexstudent = -1;
        int indexcourse = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                indexcourse = i;
                break;
            }
        }
        for (int i =0 ; i < theCourse.getEnrollStudent().size(); i++){

            if (theCourse.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                indexstudent = i;
            }
        }

        student.setCredits(student.getCredits() + theCourse.getCredits().get(indexstudent));
        theCourse.getCredits().remove(indexstudent);
        theCourse.getEnrollStudent().remove(indexstudent);
        student.getEnrollCourses().remove(indexcourse);


        return true;
    }
    int index = -1;
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();





        for (Course c : courses) {

            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    courseList.add(c) ;
                    index.add(i);
                    break;
                }
            }

        }
        for (int i = 0; i < courseList.size(); i++){
            String theCourseId = courseList.get(i).getCourseID();
            int credit = courseList.get(i).getCredits().get(index.get(i));
            result.add(theCourseId + ": " + credit);
        }
        return result;

    }






    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (Course c : courses){
            ArrayList<Integer> successIndex = new ArrayList<>();

            ArrayList<Integer> temp = new ArrayList<>();
            ArrayList<Integer> indexList = new ArrayList<>();

            ArrayList<Integer> successTemp = new ArrayList<>();
            ArrayList<Student> tempSuccessStudentList = new ArrayList<>();


            int max = c.getMaxCapacity();


            // cloning credit list
            for (int i = 0; i < c.getCredits().size(); i++){
                temp.add(c.getCredits().get(i));
            }

            //get the large to small order
            Collections.sort(temp);
            Collections.reverse(temp);

            for(int i = 0; i < temp.size(); i++){
                for (int j = 0 ; j < c.getCredits().size(); j++){
                    if (temp.get(i).equals(c.getCredits().get(j)) && !indexList.contains(j)){

                        indexList.add(j);
                        break;

                    }
                }
            }

            // if credit list > max

            if (temp.size() > max){
                // get success index from credit list (before evaluate the "same credit - same drop")
                for (int i = 0; i < max; i++){
                    successIndex.add(indexList.get(i));
                }

                // success index list after evaluation
                int indexToRemove = 0;
                if (temp.get(max).equals(temp.get(max-1))){
                    indexToRemove = indexList.get(max-1);

                    for (int i = 0; i < successIndex.size(); i++){
                        if (successIndex.get(i).equals(indexToRemove)){
                            successIndex.remove(i);
                            i--;
                        }
                    }
                }

                for (int i = 0; i< successIndex.size(); i++){
                    c.getSuccessStudents().add(c.getEnrollStudent().get(successIndex.get(i)));
                    c.getEnrollStudent().get(successIndex.get(i)).getSuccessCourses().add(c);
                }
            }

            if (temp.size() <= max){
                for(int i =0; i < temp.size(); i++){
                    c.getSuccessStudents().add(c.getEnrollStudent().get(indexList.get(i)));
                    c.getEnrollStudent().get(indexList.get(i)).getSuccessCourses().add(c);
                }
            }
        }
    }
}



