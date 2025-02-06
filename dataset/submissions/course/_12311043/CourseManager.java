import java.util.ArrayList;
class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }
    public ArrayList<Student> getStudents() {// getter for students
        return students;
    }
    public ArrayList<Course> getCourses() {// getter for courses
        return courses;
    }
    public void setIfOpen(Boolean ifOpen) {// setter for ifOpen
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {// getter for ifOpen
        return ifOpen;
    }
    public void addCourse(Course course) {
        courses.add(course); // Add the course object to courses
        course.setCourseManager(this); // Set the courseManager of the course object to this manager
    }
    public void addStudent(Student student) {
        students.add(student); // Add the student object to students
        student.setCourseManager(this);//set the courseManager of the student object to this manager
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        boolean condition=false;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                condition=true;
                break;
            }
        }
        if(!condition){
            return false;
        }
        condition=false;
        for(Course c:student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                condition=true;
                break;
            }
        }
        if(condition){
            return false;
        }
        if(credits < 0 || credits > student.getCredits()){
            return false;
        }
        int remainingCredits = student.getCredits() - credits;
        if (remainingCredits >= 0) {
            student.setCredits(remainingCredits);
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    student.getEnrollCourses().add(course);
                    course.getEnrollStudent().add(student);
                    course.getCredits().add(credits);
                }
            }
            return true;
        } else {
            return false;
        }
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        boolean condition = false;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                condition = true;
                break;
            }
        }
        if (!condition) {
            return false;
        }
        condition = false;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                condition = true;
                break;
            }
        }
        if (!condition) {
            return false;
        }
        if (credits < 0 ) {//|| credits > student.getCredits()
            return false;
        }
        for(Course c:courses) {
            if (c.getCourseID().equals(courseId)) {
                for(int i=0;i<c.getEnrollStudent().size();i++){
                    if(c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                        int currentcredit=c.getCredits().get(i);
                        if(credits > currentcredit + student.getCredits()){
                            return false;
                        }
                        student.setCredits(student.getCredits()+currentcredit-credits);
                        c.getCredits().set(i,credits);
                    }
                }
            }
        }
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        boolean condition=false;
        for(Course c:courses){
            if(c.getCourseID().equals(courseId)){
                condition=true;
                break;
            }
        }
        if(!condition){
            return false;
        }
        condition=false;
        for(Course c:student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                condition=true;
                break;
            }
        }
        if(!condition){
            return false;
        }
        for(Course c:courses) {
            if (c.getCourseID().equals(courseId)) {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        int CurrentCredit = c.getCredits().get(i);
                        student.setCredits(student.getCredits()+CurrentCredit);
                        c.getEnrollStudent().remove(i);
                        c.getCredits().remove(i);
                        break;
                    }
                }
            }
        }
        for(Course c:student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                student.getEnrollCourses().remove(c);
                break;
            }
        }
        return true;
    }
    public void finalizeEnrollments() {
        if (ifOpen) {
            ifOpen = false;
        }
        for (Course currentCourse : courses) {
            ArrayList<Student> sortedStudents = currentCourse.getEnrollStudent();
            ArrayList<Student> successStudentsList = new ArrayList<>();
            ArrayList<Integer> currentCourseCredits = currentCourse.getCredits();
        for(int i = 0; i < sortedStudents.size() - 1; i++) {
           for(int j = i + 1; j < sortedStudents.size(); j++) {
            if(currentCourseCredits.get(i) < currentCourseCredits.get(j)) {
                Student temp;
                temp = sortedStudents.get(i);
                sortedStudents.set(i, sortedStudents.get(j));
                sortedStudents.set(j, temp);
                int intTemp;
                intTemp = currentCourseCredits.get(i);
                currentCourseCredits.set(i, currentCourseCredits.get(j));
                currentCourseCredits.set(j, intTemp);
                }
            }
        }
            int maxCapacity = currentCourse.getMaxCapacity();
            if(sortedStudents.size() <= maxCapacity){
                //currentCourse.setSuccessStudents(sortedStudents);
                for (int i = 0; i < sortedStudents.size(); i++) {
                    successStudentsList.add(sortedStudents.get(i));
                }
            }
            if(sortedStudents.size() > maxCapacity){
                int lowestCredits = currentCourseCredits.get(maxCapacity);
                for (int i = 0; i < sortedStudents.size(); i++) {
                    if(currentCourseCredits.get(i) <= lowestCredits){
                        break;
                    }
                    successStudentsList.add(sortedStudents.get(i));
                }
            }
            currentCourse.setSuccessStudents(successStudentsList);
            for (Student student : successStudentsList) {
                student.getSuccessCourses().add(currentCourse);
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for(Course course : student.getEnrollCourses()){
            int i, studentIndex;
            for ( i = 0; i < course.getEnrollStudent().size(); i++) {
                if(course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                    break;
                }
            }
            studentIndex = i ;
            String courseInfo = course.getCourseID() + ": " + course.getCredits().get(studentIndex);
            enrolledCoursesWithCredits.add(courseInfo);
        }
        return enrolledCoursesWithCredits;
    }
}