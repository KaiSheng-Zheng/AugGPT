import java.util.*;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        this.courses=new ArrayList<Course>();
        this.students=new ArrayList<Student>();
        this.ifOpen=true;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public Boolean getIfOpen(){
        return this.ifOpen;
    }

    public void addCourse(Course course){
        course.setCourseManager(this);
        this.courses.add(course);
    }

    public void addStudent(Student student){
        student.setCourseManager(this);
        this.students.add(student);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!this.ifOpen)return false;
        if(credits<=0)return false;
        if(credits>student.getCredits())return false;

        boolean check=false;
        int position=0;
        for(int i=0;i<this.courses.size();i++){
            if(this.courses.get(i).getCourseID().equals(courseId)){
                check=true;
                position=i;
                break;
            }
        }
        if(!check)return false;

        check=false;
        Course course=this.courses.get(position);
        for(int i=0;i<course.getEnrollStudent().size();i++){
            if(course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                check=true;
                break;
            }
        }
        if(check)return false;

        student.setCredits(student.getCredits()-credits);
        ArrayList<Student> newEnrollStudents=course.getEnrollStudent();
        newEnrollStudents.add(student);
        course.setEnrollStudent(newEnrollStudents);
        ArrayList<Integer> newCredits=course.getCredits();
        newCredits.add(credits);
        course.setCredits(newCredits);
        student.getEnrollCourses().add(course);
        this.courses.set(position,course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!this.ifOpen)return false;
        boolean check=false;
        int position1=0;
        for(int i=0;i<this.courses.size();i++){
            if(this.courses.get(i).getCourseID().equals(courseId)){
                check=true;
                position1=i;
                break;
            }
        }
        if(!check)return false;

        check=false;
        Course course=this.courses.get(position1);
        int position=0;
        for(int i=0;i<course.getEnrollStudent().size();i++){
            if(course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                check=true;
                position=i;
                break;
            }
        }
        if(!check)return false;

        if(student.getCredits()<credits-course.getCredits().get(position))return false;
        student.setCredits(student.getCredits()-credits+course.getCredits().get(position));
        ArrayList<Integer> newCredits=course.getCredits();
        newCredits.set(position,credits);
        course.setCredits(newCredits);
        this.courses.set(position1,course);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!this.ifOpen)return false;
        boolean check=false;
        int position=0;
        for(int i=0;i<this.courses.size();i++){
            if(this.courses.get(i).getCourseID().equals(courseId)){
                check=true;
                position=i;
                break;
            }
        }
        if(!check)return false;

        check=false;
        Course course=this.courses.get(position);
        int positionS=0;
        for(int i=0;i<course.getEnrollStudent().size();i++){
            if(course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                check=true;
                positionS=i;
                break;
            }
        }
        if(!check)return false;

        student.setCredits(student.getCredits()+course.getCredits().get(positionS));
        ArrayList<Course> newCourse=student.getEnrollCourses();
        newCourse.remove(course);
        student.setEnrollCourses(newCourse);

        ArrayList<Integer> newCredit=course.getCredits();
        ArrayList<Student> newStudent=course.getEnrollStudent();
        newCredit.remove(positionS);
        newStudent.remove(positionS);
        course.setCredits(newCredit);
        course.setEnrollStudent(newStudent);

        return true;
    }

    public void finalizeEnrollments(){
        this.ifOpen=false;
        for(int i=0;i<courses.size();i++){
            Course course=courses.get(i);
            sort(course);
            ArrayList<Student> nowStudent=course.getEnrollStudent();
            ArrayList<Integer> nowCredit=course.getCredits();
            int j=nowStudent.size()-1;
            System.out.printf("j:%d\n",j);
            System.out.printf("cap:%d\n",course.getMaxCapacity());
            while((j>=0)&&(j+1>course.getMaxCapacity())){
                int stepCredit=nowCredit.get(j);
                while(stepCredit==nowCredit.get(j)){
                    j--;
                    if(j<0)break;
                }
            }
            ArrayList<Student> newSuccessStudent=new ArrayList<Student>();
            System.out.printf("j:%d\n",j);
            for(int k=0;k<=j;k++){
                Student kStudent=nowStudent.get(k);
                ArrayList<Course> newSuccessCourse=kStudent.getSuccessCourses();
                newSuccessCourse.add(course);
                kStudent.setSuccessCourses(newSuccessCourse);
                nowStudent.set(k,kStudent);

                newSuccessStudent.add(kStudent);
            }
            course.setSuccessStudents(newSuccessStudent);
            courses.set(i,course);
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!this.ifOpen)return null;
        ArrayList<String> output=new ArrayList<String>();
        for(int i=0;i<student.getEnrollCourses().size();i++){
            Course iCourse=student.getEnrollCourses().get(i);
            String EnrollCourseInfo="";
            EnrollCourseInfo+=iCourse.getCourseID();
            EnrollCourseInfo+=": ";
            for(int j=0;j<iCourse.getEnrollStudent().size();j++){
                if(iCourse.getEnrollStudent().get(j).equals(student)){
                    EnrollCourseInfo+=iCourse.getCredits().get(j);
                    break;
                }
            }
            output.add(EnrollCourseInfo);
        }
        return output;
    }
    private void sort(Course course){
        ArrayList<Student> newStudent=course.getEnrollStudent();
        ArrayList<Integer> newCredit=course.getCredits();
        for(int i=0;i<newCredit.size();i++)
            for(int j=i+1;j<newCredit.size();j++){
                if(newCredit.get(i)<newCredit.get(j))swap(newStudent,newCredit,i,j);
            }
        course.setEnrollStudent(newStudent);
        course.setCredits(newCredit);
    }

    private void swap(ArrayList<Student> newStudent,ArrayList<Integer> newCredit,int i,int j){
        Student SwapStudent=newStudent.get(i);
        newStudent.set(i,newStudent.get(j));
        newStudent.set(j,SwapStudent);
        int SwapCredit=newCredit.get(i);
        newCredit.set(i,newCredit.get(j));
        newCredit.set(j,SwapCredit);
    }

    public static void main(String[] args) {

    }
}