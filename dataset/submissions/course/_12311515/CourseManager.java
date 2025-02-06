import java.util.*;
public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private boolean ifOpen;

    public CourseManager() {
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return this.ifOpen;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean existence = false;
        int courseposition = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                existence = true;
                courseposition = i;
                break;
            }
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                return false;
            }
        }
        if (!existence) return false;
        if (credits <= 0) return false;
        if (student.getCredits() < credits) return false;
        if (!ifOpen) return false;
        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(courses.get(courseposition));
        courses.get(courseposition).getEnrollStudent().add(student);
        courses.get(courseposition).getCredits().add(credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean existence = false;
        int courseposition = 0;
        int creditposition = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                existence = true;
                courseposition = i;
                break;
            }
        }
        if (!existence) return false;
        existence = false;
        for (int i = 0; i < courses.get(courseposition).getEnrollStudent().size(); i++) {
            if (courses.get(courseposition).getEnrollStudent().get(i) == student) {
                creditposition = i;
                existence = true;
            }
        }
        if (!existence) return false;
        if ((student.getCredits() + courses.get(courseposition).getCredits().get(creditposition))-credits<0){
            return false;
        }
        if(!ifOpen) return false;
        student.setCredits((student.getCredits() + courses.get(courseposition).getCredits().get(creditposition))-credits);
        courses.get(courseposition).getCredits().set(creditposition,credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean existence = false;
        int courseposition = 0;
        int creditposition = 0;
        int courseinstudentposition = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                existence = true;
                courseposition = i;
                break;
            }
        }
        if (!existence) return false;
        existence = false;
        for (int i = 0; i < courses.get(courseposition).getEnrollStudent().size(); i++) {
            if (courses.get(courseposition).getEnrollStudent().get(i) == student) {
                creditposition = i;
                existence = true;
            }
        }
        for(int i = 0; i<student.getEnrollCourses().size(); i++) {
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId))   courseinstudentposition=i;
        }
        if (!existence) return false;
        if(!ifOpen) return false;
        student.setCredits(student.getCredits()+courses.get(courseposition).getCredits().get(creditposition));
        courses.get(courseposition).getEnrollStudent().remove(creditposition);
        courses.get(courseposition).getCredits().remove(creditposition);
        student.getEnrollCourses().remove(courseinstudentposition);
        return  true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for(int i = 0 ; i < courses.size() ; i++){
            for(int j = 0 ; j < courses.get(i).getCredits().size() ; j++){
                for(int k = 0 ; k < courses.get(i).getCredits().size()  - 1 ; k++ ){
                    if(courses.get(i).getCredits().get(k) < courses.get(i).getCredits().get(k+1)){
                        int midtern = courses.get(i).getCredits().get(k+1);
                        courses.get(i).getCredits().set(k+1,courses.get(i).getCredits().get(k));
                        courses.get(i).getCredits().set(k,midtern);
                        Student midtern1 = courses.get(i).getEnrollStudent().get(k+1);
                        courses.get(i).getEnrollStudent().set(k+1,courses.get(i).getEnrollStudent().get(k));
                        courses.get(i).getEnrollStudent().set(k,midtern1);
                    }
                }
            }
        }
        for(int i = 0 ; i < courses.size() ; i++){
            int capacity = courses.get(i).getMaxCapacity();
            for(int j = 0 ; j < courses.get(i).getCredits().size() ; j++){
                int studentposition = 0;
                if(capacity>0){
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    for(int k = 0 ; k < students.size() ; k++){
                        if(students.get(k).getStudentID().equals(courses.get(i).getEnrollStudent().get(j).getStudentID())){
                            studentposition = k;
                            break;
                        }
                    }
                    students.get(studentposition).getSuccessCourses().add(courses.get(i));
                    capacity--;
                }
            }
            if(courses.get(i).getMaxCapacity()<courses.get(i).getEnrollStudent().size()){
                for(int j = courses.get(i).getMaxCapacity()-1 ; j >= 0 ; j--){
                    if(courses.get(i).getCredits().get(courses.get(i).getMaxCapacity())<courses.get(i).getCredits().get(j)){
                        break;
                    }
                    else{
                        courses.get(i).getSuccessStudents().remove(j);
                        int studentposition = 0;
                        for(int k = 0 ; k < students.size() ; k++){
                            if (students.get(k).getStudentID().equals(courses.get(i).getEnrollStudent().get(j).getStudentID())){
                                studentposition = k;
                                break;
                            }
                        }
                        students.get(studentposition).getSuccessCourses().remove(courses.get(i));
                    }
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> answer = new ArrayList<String>();
        for(int i = 0 ; i < courses.size() ; i++ ){
            for(int j = 0 ; j < courses.get(i).getEnrollStudent().size() ; j++ ){
                if(student.getStudentID().equals(courses.get(i).getEnrollStudent().get(j).getStudentID())){
                    answer.add(courses.get(i).getCourseID()+": "+courses.get(i).getCredits().get(j).toString());
                }
            }
        }
        return answer;
    }
}