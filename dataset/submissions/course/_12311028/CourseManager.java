import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class CourseManager {
    private ArrayList<Course> courses =new ArrayList<>();
    private ArrayList<Student> students=new ArrayList<>();
    private boolean ifOpen;
    public ArrayList<Student> getStudents(){return students;}
// getter for students
    public ArrayList<Course> getCourses(){return courses;}
// getter for courses
    public void setIfOpen(Boolean ifOpen){this.ifOpen = ifOpen;}
// setter for ifOpen
    public boolean getIfOpen(){
        return ifOpen;
    }
// getter for ifOpen
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
        //addCourseHash(course);
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    public CourseManager(){

    }
    private HashMap<String,Course> courseHashMap = new HashMap<>();
    /*public void addCourseHash(Course course){
        courseHashMap.put(course.getCourseID(), course);
    }
    public Course getCourseFromId(String courseId){
        return courseHashMap.get(courseId);
    }*/
    public Course getCourseFromId(String courseId){
        for(int i = 0;i < courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                return courses.get(i);
            }
        }
        return null;
    }
    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        if(!ifOpen){return false;}
        if(courses.contains(getCourseFromId(courseId)) && !student.getEnrollCourses().contains(getCourseFromId(courseId)) && credits > 0 && student.getCredits() >= credits){
            getCourseFromId(courseId).getEnrollStudent().add(student);
            getCourseFromId(courseId).getCredits().add(credits);
            student.setCredits(student.getCredits()-credits);
            student.getEnrollCourses().add(getCourseFromId(courseId));
            return true;
        }else{
            return false;
        }
    }
    public void modifyCredit(Course course, int index, int credit){
        course.getCredits().set(index,credit);
    }
    public int getCredit(Course course,int index){
        return course.getCredits().get(index);
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){return false;}
        if(!courses.contains(getCourseFromId(courseId))){return false;}
        if(!student.getEnrollCourses().contains(getCourseFromId(courseId))){return false;}
        int index = getCourseFromId(courseId).getEnrollStudent().indexOf(student);
        int initialCredit = getCredit(getCourseFromId(courseId),index);
        if(student.getCredits() + initialCredit >= credits){
            student.setCredits(student.getCredits() + initialCredit - credits);
            modifyCredit(getCourseFromId(courseId),index,credits);
            return true;
        }else{
            return false;
        }
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){return false;}
        if(courses.contains(getCourseFromId(courseId)) && getCourseFromId(courseId).getEnrollStudent().contains(student)){
            int index = getCourseFromId(courseId).getEnrollStudent().indexOf(student);
            int initialCredit = getCredit(getCourseFromId(courseId),index);
            student.setCredits(student.getCredits() + initialCredit);
            getCourseFromId(courseId).getCredits().remove(index);
            dropEnrollStudent(student,getCourseFromId(courseId));
            student.getEnrollCourses().remove(getCourseFromId(courseId));
            return true;
        }else{
            return false;
        }
    }
    public int leastCredit(Course course){
        if(course.getCredits().size() == 0){return 0;}
        ArrayList<Integer> copyOfCredits = (ArrayList<Integer>) course.getCredits().clone();
        //copyOfCredits.sort(Comparator.reverseOrder());
        Collections.sort(copyOfCredits,Comparator.reverseOrder());
        int credit = 1;
        if(course.getMaxCapacity() == 0){return copyOfCredits.get(0)+1;}
        if(course.getMaxCapacity() >= course.getEnrollStudent().size()){return 0;}
        if(copyOfCredits.get(course.getMaxCapacity()-1) > copyOfCredits.get(course.getMaxCapacity())) {
            credit = copyOfCredits.get(course.getMaxCapacity() - 1);
        } else if (copyOfCredits.get(course.getMaxCapacity()) == copyOfCredits.get(0)) {
            return copyOfCredits.get(0)+1;
        } else {
            for(int i = 0;i < course.getMaxCapacity()-1;i++){
                credit = copyOfCredits.get(i);
                if(copyOfCredits.get(i) == copyOfCredits.get(i+1)){
                    break;
                }
            }
        }
        return credit;
    }
    public void dropEnrollStudent(Student student,Course course){
        course.getEnrollStudent().remove(student);
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        int leastCredit;
        if(courses.size() == 0){
            return;
        }
        for(int i = 0;i < courses.size();i++){
            leastCredit = leastCredit(courses.get(i));
            if(courses.get(i).getEnrollStudent().size() == 0){
                continue;
            }
            for(int j = 0;j < courses.get(i).getEnrollStudent().size();j++){
                if(courses.get(i).getCredits().get(j) < leastCredit){
                    dropStudentEnrollmentCourse(courses.get(i).getEnrollStudent().get(j),courses.get(i).getCourseID());
                }else{
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){return null;}
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i < student.getEnrollCourses().size();i++){
            list.add(i,student.getEnrollCourses().get(i).getCourseID() + ": " + String.valueOf(getCredit(student.getEnrollCourses().get(i),student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student))));
        }
        return list;
    }
}
