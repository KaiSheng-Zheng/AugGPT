import java.util.ArrayList;
public class CourseManager {
    private boolean ifOpen;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        //the course exists
        if(!ifOpen) return false;
        //the credits to bid is greater than 0
        if(credits<=0) return false;
        //they have enough credits to bid
        if(student.getCredits()<credits) return false;
        //the student has not already enrolled
        Course found = null;
        for(Course i : courses)
            if(courseId.equals(i.getCourseID())) {
                found = i;
                break;
            }
        if(found == null) return false;
        for(Course i : student.getEnrollCourses())
            if(courseId.equals(i.getCourseID()))
                return false;
        //the student's credits will be reduced by the amount bid on the course
        student.setCredits(student.getCredits()-credits);
        //The corresponding list in Student and Course should be updated.
        found.getEnrollStudent().add(student);
        found.getCredits().add(credits);
        student.getEnrollCourses().add(found);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen) return false;
        //Fail
        //course exists
        Course found = null;
        for(Course i : courses)
            if(courseId.equals(i.getCourseID())) {
                found = i;
                break;
            }
        if(found == null) return false;
        //the student is currently enrolled in the course
        boolean tmp = false;
        for(Course i : student.getEnrollCourses())
            if(courseId.equals(i.getCourseID()))
                tmp = true;
        if(!tmp) return false;
        //Success to do
        //the student's credits will be updated to reflect the new bid amount.
        int index = -1;
        for(int i=0;i<found.getEnrollStudent().size();++i){
            if(student.getStudentID().equals(found.getEnrollStudent().get(i).getStudentID())){
                index = i;
            }
        }
        if(index == -1) return false;
        found.getEnrollStudent().get(index).setCredits(credits);
        int credit1 = found.getCredits().get(index);
        //the new bid is within the student's available credits
        if(student.getCredits()+credit1<credits) return false;
        found.getCredits().set(index, credit1);
        student.setCredits(student.getCredits()-credit1+credits);
        //The corresponding list in Student and Course should be updated.
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen) return false;
        Course found = null;
        for(Course i : courses)
            if(courseId.equals(i.getCourseID())) {
                found = i;
                break;
            }
        if(found == null) return false;
        boolean tmp = false;
        for(Course i : student.getEnrollCourses())
            if(courseId.equals(i.getCourseID()))
                tmp = true;
        if(!tmp) return false;
        int index = -1;
        for(int i = 0; i < found.getEnrollStudent().size(); ++i){
            if(student.getStudentID().equals(found.getEnrollStudent().get(i).getStudentID())){
                index = i;
            }
        }
        if(index == -1) return false;
        int index2 = -1;
        for(int i = 0; i < student.getEnrollCourses().size(); ++i){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                index2 = i;
            }
        }
        student.setCredits(student.getCredits()+found.getCredits().get(index));
        found.getEnrollStudent().remove(index);
        found.getCredits().remove(index);
        student.getEnrollCourses().remove(index2);
        return true;
    }

    public void finalizeEnrollments(){
        ifOpen = false;
        for(int i = 0; i < courses.size(); ++i){
            int least = 0;
            for(int k=0;;++k) {
                int upper_sum = 0;
                int max = courses.get(i).getMaxCapacity();
                for (int j = 0; j < courses.get(i).getEnrollStudent().size(); ++j) {
                    if(courses.get(i).getCredits().get(i)<k) ++upper_sum;
                }
                if(upper_sum<max){
                    least = k;
                    break;
                }
            }
            for(int k = 0;k < courses.get(i).getEnrollStudent().size(); k++){
                if(courses.get(i).getCredits().get(k)<=least){
                    courses.get(i).getEnrollStudent().remove(k);
                    courses.get(i).getCredits().remove(k);
                    --k;
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if(!ifOpen) return null;
        ArrayList<String> enrolledCourses;
        enrolledCourses = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            String course = student.getEnrollCourses().get(i).getCourseID();
            for(int j = 0; j < courses.size(); ++j){
                if(courses.get(j).getCourseID().equals(course)) {
                    for (int k = 0; k < courses.get(j).getEnrollStudent().size(); ++k) {
                        if (courses.get(j).getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())) {
                            enrolledCourses.add(student.getStudentID() + ": " + courses.get(j).getCredits().get(k));
                            break;
                        }
                    }
                }
            }
        }
        return enrolledCourses;
    }
}
