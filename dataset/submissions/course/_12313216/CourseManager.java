import java.util.ArrayList;
import java.util.Objects;

public class CourseManager {
    private boolean ifOpen;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Integer> enrollCredits = new ArrayList<>();
    public void setIfOpen(boolean ifOpen){
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
// getter for students

    public ArrayList<Course> getCourses(){
        return courses;
    }
// getter for courses

    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.





    public boolean checkCourseExist(String courseId){
        boolean result = false;
        for (int i = 0;i < courses.size();i++){
            if (Objects.equals(courseId, courses.get(i).getCourseID())){
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean checkEnrollCourse(Student student, String courseId){
        boolean result = true;
        if (!student.getEnrollCourses().isEmpty()) {
            for (int i = 0;i < student.getEnrollCourses().size();i++){
                if (Objects.equals(student.getEnrollCourses().get(i).getCourseID(), courseId)){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }





    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (ifOpen){
            if (credits <= student.getCredits() && checkEnrollCourse(student,courseId) && checkCourseExist(courseId)&& credits > 0) {
                student.setCredits(student.getCredits() - credits);
                int Num = 0;
                for (int i = 0;i < courses.size();i++){
                    if (Objects.equals(courses.get(i).getCourseID(),courseId)){
                        Num = i;
                        break;
                    }
                }
                student.getEnrollCourses().add(courses.get(Num));
                int afterNum = student.getEnrollCourses().size();
                student.getEnrollCourses().get(afterNum - 1).getEnrollStudent().add(student);
                student.getEnrollCourses().get(afterNum - 1).getCredits().add(credits);
                return true;
            }
            else return false;
        }
        else return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (ifOpen){
            if (checkCourseExist(courseId)  &&!checkEnrollCourse(student,courseId) && credits > 0){
                int enrollCourseNum = 0;
                for (int i = 0;i < student.getEnrollCourses().size();i++){
                    if (Objects.equals(student.getEnrollCourses().get(i).getCourseID(),courseId)){
                        enrollCourseNum = i;
                        break;
                    }
                }
                if (credits <= student.getCredits() + student.getEnrollCourses().get(enrollCourseNum).getCredits().get(student.getEnrollCourses().get(enrollCourseNum).getEnrollStudent().indexOf(student))){
                    student.setCredits(student.getCredits() + student.getEnrollCourses().get(enrollCourseNum).getCredits().get(student.getEnrollCourses().get(enrollCourseNum).getEnrollStudent().indexOf(student)) - credits);
                    student.getEnrollCourses().get(enrollCourseNum).getCredits().set(student.getEnrollCourses().get(enrollCourseNum).getEnrollStudent().indexOf(student),credits);
                    return true;
                }else return false;
            }
            else return false;
        }
        else return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (ifOpen){
            if (checkCourseExist(courseId)  && !checkEnrollCourse(student,courseId)){
                int enrollCourseNum = 0;
                for (int i = 0;i < student.getEnrollCourses().size();i++){
                    if (Objects.equals(student.getEnrollCourses().get(i).getCourseID(),courseId)){
                        enrollCourseNum = i;
                        break;
                    }
                }
                student.setCredits(student.getCredits() + student.getEnrollCourses().get(enrollCourseNum).getCredits().get(student.getEnrollCourses().get(enrollCourseNum).getEnrollStudent().indexOf(student)));
                student.getEnrollCourses().get(enrollCourseNum).getCredits().remove(student.getEnrollCourses().get(enrollCourseNum).getEnrollStudent().indexOf(student));
                student.getEnrollCourses().get(enrollCourseNum).getEnrollStudent().remove(student);
                student.getEnrollCourses().remove(enrollCourseNum);
                return true;
            }
            else return false;
        }
        else return false;
    }

    public void finalizeEnrollments(){
        setIfOpen(false);

        for (Course cours : courses) {
            if (cours.getEnrollStudent().size() > 1){
                for (int j = 0; j < cours.getEnrollStudent().size() -1; j++) {
                    for (int k = 0; k < cours.getEnrollStudent().size() -1; k++) {
                        if (cours.getCredits().get(k) < cours.getCredits().get(k + 1)) {
                            int max = Math.max(cours.getCredits().get(k),cours.getCredits().get(k + 1));
                            int min = Math.min(cours.getCredits().get(k),cours.getCredits().get(k + 1));
                            cours.getCredits().set(k,max);
                            cours.getCredits().set(k+1,min);
                            ArrayList<Student> intermediateStudent = new ArrayList<>();
                            intermediateStudent.add(null);
                            intermediateStudent.add(null);
                            intermediateStudent.set(0,cours.getEnrollStudent().get(k + 1));
                            intermediateStudent.set(1,cours.getEnrollStudent().get(k ));
                            cours.getEnrollStudent().set(k, intermediateStudent.get(0));
                            cours.getEnrollStudent().set(k + 1, intermediateStudent.get(1));
                        }
                    }
                }
            }
        }
        for (Course cours : courses) {
            ArrayList<Integer> times = new ArrayList<>();
            if (!cours.getCredits().isEmpty()){
                int bids = cours.getCredits().get(0);
                int num = 0;
                for (int i = 0; i < cours.getCredits().size();i++){
                    if (bids != cours.getCredits().get(i)){
                        times.add(num);
                        bids = cours.getCredits().get(i);
                        num = 1;
                    }
                    else num++;
                }
                times.add(num);
                int sum = 0;
                for (int i = 0;i < times.size();i++){
                    sum += times.get(i);
                    if (sum > cours.getMaxCapacity()){
                        sum -= times.get(i);
                        break;
                    }
                }
                for (int i = 0;i < sum;i++){
                    if (!cours.getEnrollStudent().isEmpty()){
                        cours.getSuccessStudents().add(cours.getEnrollStudent().get(i));
                    }
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (ifOpen){
            ArrayList<String> getEnrolledCoursesWithCredits = new ArrayList<>();
            for (int i = 0;i < student.getEnrollCourses().size();i++){
                getEnrolledCoursesWithCredits.add(student.getEnrollCourses().get(i).getCourseID()+": "+student.getEnrollCourses().get(i).getCredits().get(student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student)));
            }
            return getEnrolledCoursesWithCredits;
        }
        else return null;
    }

}