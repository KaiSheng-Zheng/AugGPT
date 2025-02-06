import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CourseManager {
    private final ArrayList<Course> courses;
    private final ArrayList<Student> students;
    // no getter.

    private boolean ifOpen ; public CourseManager(){
        courses= new ArrayList<>();
        students= new ArrayList<>();
        ifOpen=true;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {
        return ifOpen;
    }
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(ifOpen){
            if (containCourses(courses,courseId)&&(!studentEnrollCourses(courseId,student))&&(credits>0)&&(student.getCredits()-credits>=0)){
                student.setCredits(student.getCredits()-credits);
                Course newCourse = courseIdInferCourse(courses,courseId);
                student.getEnrollCourses().add(newCourse);
                newCourse.getEnrollStudent().add(student);
                newCourse.getCredits().add(credits);
                return true;
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,int credits){
        if(ifOpen){
            if (containCourses(courses,courseId)&&studentEnrollCourses(courseId,student)&&(credits>=0)){
                Course thisCourse = courseIdInferCourse(courses,courseId);
                int index = thisCourse.getEnrollStudent().indexOf(student);
                int preCredit = thisCourse.getCredits().get(index);
                if((student.getCredits()+preCredit-credits>=0)&&(credits>0)){
                    student.setCredits(student.getCredits()+preCredit-credits);
                    thisCourse.getCredits().set(index,credits);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(ifOpen){
            if (containCourses(courses,courseId)){
                if(studentEnrollCourses(courseId,student)){
                    Course thisCourse = courseIdInferCourse(courses,courseId);
                    int index = thisCourse.getEnrollStudent().indexOf(student);
                    int preCredit = thisCourse.getCredits().get(index);
                    student.setCredits(student.getCredits()+preCredit);
                    student.getEnrollCourses().remove(thisCourse);
                    thisCourse.getEnrollStudent().remove(student);
                    thisCourse.getCredits().remove(index);
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    public void finalizeEnrollments(){
        ifOpen= false;
        for (Course thiscourse: courses) {
            if(thiscourse.getEnrollStudent().size()<=thiscourse.getMaxCapacity()){
                for (int j = 0; j < thiscourse.getEnrollStudent().size(); j++) {
                    Student stu = thiscourse.getEnrollStudent().get(j);
                    thiscourse.getSuccessStudents().add(stu);
                }
            }
            else{
                Integer[] indices = new Integer[thiscourse.getCredits().size()];
                for (int j = 0; j < indices.length; j++) {
                    indices[j] = j;
                }
                Arrays.sort(indices, Comparator.comparing(thiscourse.getCredits()::get).reversed());
                List<Integer> sortedCredits = new ArrayList<>();
                List<Student> sortedStudents = new ArrayList<>();
                for (int index : indices) {
                    sortedCredits.add(thiscourse.getCredits().get(index));
                    sortedStudents.add(thiscourse.getEnrollStudent().get(index));
                }
                int tepo = thiscourse.getMaxCapacity();
                while(true){
                    if(sortedCredits.get(tepo-1)>sortedCredits.get(tepo)){
                        for (int j = 0; j < tepo; j++) {
                            Student stu = sortedStudents.get(j);
                            thiscourse.getSuccessStudents().add(stu);
                        }
                        break;
                    }
                    if(tepo==1)  {
                        break;
                    }
                    tepo-=1;
                }
            }
        }
        for (Student thisStu : students) {
            for (Course thisCourse : courses) {
                for (Student stu : thisCourse.getSuccessStudents()) {
                    if (thisStu.equals(stu)) {
                        thisStu.getSuccessCourses().add(thisCourse);
                        break;
                    }
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(ifOpen){
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                Course thisCourse = student.getEnrollCourses().get(i);
                String thisCourseID = thisCourse.getCourseID();
                int index = thisCourse.getEnrollStudent().indexOf(student);
                int preCredit = thisCourse.getCredits().get(index);
                String strCredit = String.valueOf(preCredit);
                String str = thisCourseID+": "+strCredit;
                list.add(str);
            }
            return list;
        }
        else{
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < student.getSuccessCourses().size(); i++) {
                Course thisCourse = student.getSuccessCourses().get(i);
                String thisCourseID = thisCourse.getCourseID();
                list.add(thisCourseID);
            }
            return list;
        }
    }
    public boolean containCourses(ArrayList<Course> courses,String courseId){
        for (Course cr: courses) {
            String  crID = cr.getCourseID();
            if(courseId.equals(crID)){
                return true;
            }
        }
        return false;
    }
    public boolean studentEnrollCourses(String courseId,Student student){
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course scr = student.getEnrollCourses().get(i);
            String scrID = scr.getCourseID();
            if(courseId.equals(scrID)){
                return true;
            }
        }
        return false;
    }
    public Course courseIdInferCourse(ArrayList<Course> courses,String courseId){
        for (Course cr: courses) {
            String  crID = cr.getCourseID();
            if(crID.equals(courseId)) {
                return cr;
            }
        }
        return null;
    }

    public boolean studentSuccessfullyEnrollCourses(ArrayList<Course> courses,Student student){
        for(Course cr :courses){
            String crID = cr.getCourseID();
            for (int i = 0; i < student.getSuccessCourses().size(); i++) {
                Course scr = student.getSuccessCourses().get(i);
                String scrID = scr.getCourseID();
                if(crID.equals(scrID)){
                    return true;
                }
            }
        }
        return false;
    }
}
