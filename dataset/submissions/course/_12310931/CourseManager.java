import java.util.ArrayList;
public class CourseManager {
    public ArrayList<Course> courses;
    public ArrayList<Student> students;
    public boolean ifOpen;
    public CourseManager(){
        this.students = new ArrayList<Student>();
        this.courses = new ArrayList<Course>();
        this.ifOpen = true;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public void setIfOpen(boolean ifOpen){
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(credits <= 0)return false;
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                if(student.getCredits() >= credits){
                    if(ifOpen == true){
                        //missing the addition of student's enrollCourses list.
                        courses.get(i).getEnrollStudent().add(student);
                        courses.get(i).getCredits().add(credits);
                        student.setCredits(student.getCredits() - credits);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(credits <= 0)return false;
        else if(ifOpen == false)return false;
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                for(int j = 0; j < courses.get(i).getEnrollStudent().size(); j++){
                    if(courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        if(credits - courses.get(i).getCredits().get(j) <= student.getCredits()){
                            student.setCredits(student.getCredits() + courses.get(i).getCredits().get(j));
                            courses.get(i).getCredits().set(j, credits);
                            student.setCredits(student.getCredits() - credits);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void finalizeEnrollments(){
        for(int i = 0; i < courses.size(); i++){
            for(int j = 0; j < courses.get(i).getMaxCapacity(); j++){
                int max = 0;
                int count = 1;
                int locate = -1;
                for(int k = 0; k < courses.get(i).getCredits().size(); k++){
                    if(courses.get(i).getCredits().get(k) > max){
                        max = courses.get(i).getCredits().get(k);
                        locate = k;
                        count = 1;
                    }
                    else if(courses.get(i).getCredits().get(k) == max){
                        count++;
                    }
                }
                if(locate == -1)break;
                if(j + count > courses.get(i).getMaxCapacity())break;
                else{
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(locate));
                    courses.get(i).getEnrollStudent().remove(locate);
                    courses.get(i).getCredits().remove(locate);
                }
            }
        }
        ifOpen = false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                for(int j = 0; j < courses.get(i).getEnrollStudent().size(); j++){
                    if(student.getStudentID().equals(courses.get(i).getEnrollStudent().get(j).getStudentID())){
                        if(getIfOpen() == true){
                            student.setCredits(student.getCredits()+courses.get(i).getCredits().get(j));
                            courses.get(i).getEnrollStudent().remove(j);
                            courses.get(i).getCredits().remove(j);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> name = new ArrayList<String>();
        if(ifOpen == true){
            for(int i = 0; i < courses.size(); i++){
                for(int j = 0; j < courses.get(i).getEnrollStudent().size(); j++){
                    if(courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        name.add(toString(i, j));
                    }
                }
            }
            return name;
        }
        else return null;
    }
    public String toString(int i, int j){
        return courses.get(i).getCourseID() + ": " + courses.get(i).getCredits().get(j);
    }
}