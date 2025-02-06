import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CourseManager {

    public CourseManager() {
        students = new ArrayList<>();
        courses=new ArrayList<>();
    }

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(ArrayList students, ArrayList courses){
        ifOpen=true;
        this.students=students;
        this.courses=courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean isIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {
        return this.ifOpen;
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        int times=0;
        int num=0;
        for (int i =0; i<students.size();i++){
            if (student.equals(students.get(i))){
                times++;
                break;
            }
        }
        for (int i =0; i<courses.size();i++){
            if (courseId.equals(courses.get(i).getCourseID())){
                times++;
                num=i;
                break;
            }
        }
        //
        if (student.getCredits()-credits>=0){
            times++;
        }
        if (credits>0){
            times++;
        }
        if (ifOpen){
            times++;
        }
        if(times==5){
            student.setCredits(student.getCredits()-credits);
            courses.get(num).getEnrollStudent().add(student);
            student.getEnrollCourses().add(courses.get(num));
            courses.get(num).getCredits().add(credits);

            return true;
        }
        else {
            return false;
        }

    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        int times=0;
       
        int studentIndex=0;
     
        int CourceIndex=0;

        int courseIndex=0;
      

        boolean Inside= false;
   
        for(int i=0;i<courses.size();i++){
            if (courseId.equals(courses.get(i).getCourseID())){
                CourceIndex=i;
                Inside=true;
            }
        }
     
        if(!Inside){
            return false;
        }

        //
        for (int i=0;i<student.getEnrollCourses().size();i++) {
            if (courseId.equals(student.getEnrollCourses().get(i).getCourseID()))  {
                times++;
                studentIndex=i;
            }
        }
    
        for (int i=0;i<courses.get(CourceIndex).getEnrollStudent().size();i++){
            if (student.equals(courses.get(CourceIndex).getEnrollStudent().get(i))) {
                courseIndex=i;
            }
        }
        if (courses.get(CourceIndex).getCredits().size()==0){
            return false;
        }

        if (student.getCredits()+courses.get(CourceIndex).getCredits().get(courseIndex)-credits>=0){
            times++;
        }
        if (ifOpen){
            times++;
        }
        if (credits>0){
            times++;
        }
        if (times==4){
            student.setCredits(student.getCredits()+courses.get(CourceIndex).getCredits().get(courseIndex)-credits);
            courses.get(CourceIndex).getCredits().set(courseIndex,credits);
            return true;
        }
        else {
            return false;
        }

    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        int times=0;
      
        int studentIndex=0;
      
        int CourceIndex=0;
      
        int courseIndex=0;
       
        boolean Inside=false;

        for(int i=0;i<courses.size();i++){
            if (courseId.equals(courses.get(i).getCourseID())){
                CourceIndex=i;
                Inside=true;
            }
        }

        if (!Inside){
            return false;
        }
        for (int i=0;i<student.getEnrollCourses().size();i++) {
            if (courseId.equals(student.getEnrollCourses().get(i).getCourseID()))  {
                times++;
                studentIndex=i;
            }
        }
        for (int i=0;i<courses.get(CourceIndex).getEnrollStudent().size();i++){
            if (student.equals(courses.get(CourceIndex).getEnrollStudent().get(i))) {
                courseIndex=i;
            }
        }

        if (ifOpen){
            times++;
        }
        if (times==2){
            student.getEnrollCourses().remove(studentIndex);
            student.setCredits(student.getCredits()+courses.get(CourceIndex).getCredits().get(courseIndex));
            courses.get(CourceIndex).getCredits().remove(courseIndex);
            courses.get(CourceIndex).getEnrollStudent().remove(courseIndex);
            return true;
        }
        else {
            return false;
        }
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        int finaledge=0;
    
        int edge=0;
     
        for(int i =0;i< courses.size();i++){
           
            ArrayList <Integer>clone= new ArrayList<>(courses.get(i).getCredits());
            edge=courses.get(i).getMaxCapacity();
            Collections.sort(clone, Comparator.reverseOrder());
            if (clone.size()<=edge) {
                finaledge = 0;
            }
            else if (courses.get(i).getEnrollStudent().size()>edge &&clone.get(edge-1).equals(clone.get(edge))){
                finaledge=clone.get(edge);
            }
            else {
                finaledge=clone.get(edge-1)-1;
             
            }
            for (int j=0;j<courses.get(i).getEnrollStudent().size();j++){
              
                if (courses.get(i).getCredits() .get(j)>finaledge){
                 
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
             
                    courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
               
                }
            }
        }

    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList <String>arraylist=new ArrayList<>();
        if (ifOpen) {
            for (int i=0;i<student.getEnrollCourses().size();i++){
               
                int CourceIndex=0;
                for (int j=0;j<student.getEnrollCourses().get(i).getEnrollStudent().size();j++){
                
                 if (student.equals(student.getEnrollCourses().get(i).getEnrollStudent().get(j))) {
                        CourceIndex = j;
                     arraylist.add(String.format("%s: %s", student.getEnrollCourses().get(i).getCourseID(), student.getEnrollCourses().get(i).getCredits().get(CourceIndex)));
                    }

            }
        } return arraylist;
        }
        else {
            return null;
    }
}
}