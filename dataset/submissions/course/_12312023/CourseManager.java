import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class CourseManager {
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public boolean isIfOpen() {
        return ifOpen;
    }

    private ArrayList<Course> courses=new ArrayList<>();
    private ArrayList<Student> students=new ArrayList<>();
    private boolean ifOpen;
    ArrayList<ArrayList<String>>tong=new ArrayList<>();
    public CourseManager(){}
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }


    public boolean getIfOpen(){
        return this.ifOpen;
    }


    public void addCourse(Course course){
        course.setCourseManager(this);
        courses.add(course);
        tong.add(new ArrayList<String>());
    }


    public void addStudent(Student student){
        student.setCourseManager(this);
        students.add(student);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        boolean flag1=false;
        boolean flag2=false;
        boolean flag3=false;
        int id=-1;
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
            id=i;
            flag1=true;
            break;
            }
        }
        if(credits>0&&credits<=student.getCredits()){
            flag3=true;
        }
        if(flag1&&!student.getEnrollCourses().contains(courses.get(id))){
            flag2=true;
        }
        if(flag1&&flag2&&flag3&&!(student.getCredits()<0)){
            courses.get(id).getCredits().add(credits);
            student.setCredits(student.getCredits()-credits);
            student.getEnrollCourses().add(courses.get(id));
            courses.get(id).getEnrollStudent().add(student);
            tong.get(id).add(student.getStudentID());
            return true;
        }
      return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        boolean flag1=false;
        boolean flag2=false;
        int id=-1;
        if(credits<0){
            return false;
        }
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                id=i;
                flag1=true;
                break;
            }
        }
        if(flag1&&student.getEnrollCourses().contains(courses.get(id))){
            flag2=true;
        }
        if(flag1&&flag2){
            for (int i = 0; i < tong.get(id).size(); i++) {
                if(student.getStudentID().equals(tong.get(id).get(i))){
                    int temp=courses.get(id).getCredits().get(i);
                    if(credits-temp>student.getCredits()){
                        return false;
                    }
                    courses.get(id).getCredits().remove(i);
                    tong.get(id).remove(i);
                    student.setCredits(student.getCredits()+temp);
                    courses.get(id).getCredits().add(credits);
                    tong.get(id).add(student.getStudentID());
                    student.setCredits(student.getCredits()-credits);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        int id=-1;
        boolean flag1=false;
        boolean flag2=false;
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                id=i;
                flag1=true;
                break;
            }
        }
        if(!flag1){
            return false;
        }
        if(!ifOpen||!student.getEnrollCourses().contains(courses.get(id))){
            return false;
            }
        for (int i = 0; i < tong.get(id).size(); i++) {
            if(student.getStudentID().equals(tong.get(id).get(i))){
                int temp=courses.get(id).getCredits().get(i);
                courses.get(id).getCredits().remove(i);
                tong.get(id).remove(i);
                student.setCredits(student.getCredits()+temp);
                student.getEnrollCourses().remove(courses.get(id));
                courses.get(id).getEnrollStudent().remove(student);
                return true;
            }
        }
        return false;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        for (int i = 0; i < courses.size(); i++) {
            int length=courses.get(i).getMaxCapacity();
            if(courses.get(i).getCredits().size()==0||length==0){
                continue;
            }
            ArrayList<Integer>mirror=new ArrayList<>();
            ArrayList<Integer>box=new ArrayList<>();
            mirror.addAll(courses.get(i).getCredits());
            mirror.sort((x,y) -> Integer.compare(y,x));
            if((mirror.size()>length)&&mirror.get(length-1)==mirror.get(length)){
                for (int j = 0; j < length; j++) {
                    if(mirror.get(j)!=mirror.get(length-1)){
                        box.add(mirror.get(j));
                    }
                }
            }else {
                for (int j = 0; j < length; j++) {
                    if(j==mirror.size()){
                        break;
                    }
                    box.add(mirror.get(j));
                }
            }
            for (int i1 = 0; i1 < box.size(); i1++) {
                for (int i2 = 0; i2 < courses.get(i).getCredits().size(); i2++) {
                    if(courses.get(i).getCredits().get(i2)== box.get(i1)&&!courses.get(i).getSuccessStudents().contains(search(tong.get(i).get(i2),students))){
                        courses.get(i).getSuccessStudents().add(search(tong.get(i).get(i2),students));
                        search(tong.get(i).get(i2),students).getSuccessCourses().add(courses.get(i));
                        break;
                    }
                }
            }
        }
    }
    public static Student search(String studentId,ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getStudentID().equals(studentId)){
                return students.get(i);
            }
        }
        return null;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> output=new ArrayList<>();
        if(ifOpen){
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int id=-1;
                boolean flag1=false;
                for (int i1 = 0; i1 < courses.size(); i1++) {
                    if(student.getEnrollCourses().get(i).getCourseID().equals(courses.get(i1).getCourseID())){
                        id=i1;
                        flag1=true;
                        break;
                    }
                }
                if(!flag1){
                    continue;
                }
                for (int i1 = 0; i1 < tong.get(id).size(); i1++) {
                    if (tong.get(id).get(i1).equals(student.getStudentID())){
                        output.add(courses.get(id).getCourseID()+": "+courses.get(id).getCredits().get(i1));
                    }
                }
            }
            return output;
        }
        return null;
    }
}