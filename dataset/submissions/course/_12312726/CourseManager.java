import java.util.ArrayList;

public class CourseManager {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        ifOpen=true;
        students=new ArrayList<>();
        courses=new ArrayList<>();
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen(){
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
        if (!ifOpen){
            return false;
        }
        if(credits<=0){
            return false;
        }
        if((student.getCredits()-credits)<0) {
            return false;
        }
        Course course2 =null;
        int i=0;
        for (Course c: student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                    return false;
            }

        }
        for (Course c: courses){
                if (c.getCourseID().equals(courseId)){
                    course2=c;
                    break;
                }
                i++;
        }
        if (course2==null){
                return false;
        }
        if(course2.getEnrollStudent().contains(student)){
            return  false;
        }
        student.setCredits(student.getCredits()-credits);
        student.getEnrollCourses().add(course2);
        courses.get(i).getEnrollStudent().add(student);
        courses.get(i).getCredits().add(credits);
        return true;
    }
        


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
            if(!ifOpen){
                return false;
            }
            Course course =null;
            int i=0;
            if(credits<=0){
                return false;
            }
            for(Course c:courses){
                if(c.getCourseID().equals(courseId)){
                    course=c;
                    break;
                }
                i++;
            }
            if (course==null){
                return false;
            }

            if(!course.getEnrollStudent().contains(student)){
                return false;
            }
            int n=course.getEnrollStudent().indexOf(student);
            int cre=course.getCredits().get(n);
            int origin= student.getCredits();
            if(origin+cre-credits<0){
                return false;
            }
            if(origin+cre-credits>=0){
                courses.get(i).getCredits().set(n,credits);
            }
            student.setCredits(origin+cre-credits);
            return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }
        Course course=null;
        int i=0;
        for (Course c:courses){
            if(c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
            i++;
        }
        if(course==null){
            return false;
        }
        Course enrolled=null;

        for(Course c:student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                enrolled=c;
                break;
            }
        }
        if(enrolled==null){
            return false;
        }
        Student studentEnrolled=null;
        int n=0;
        for (Student s: course.getEnrollStudent()){
            if (s.getStudentID().equals(student.getStudentID())){
                studentEnrolled=student;
                break;
            }
            n++;
        }
        if (studentEnrolled==null){
            return false;
        }
        int giveup=course.getCredits().get(n);
        courses.get(i).getEnrollStudent().remove(n);
        courses.get(i).getCredits().remove(n);
        for (int m=0;;m++){
            if (student.getEnrollCourses().get(m).getCourseID().equals(courseId)){
                student.getEnrollCourses().remove(m);
                student.setCredits(student.getCredits()+giveup);
                break;
            }
        }
        return true;
    }
    public void finalizeEnrollments(){
        setIfOpen(false);

        int b=-1;
        for(Course c:courses){
            b++;
            ArrayList<Student> temp=new ArrayList<>();
            if(c.getEnrollStudent().size()==0){
                continue;
            }
            for (int m=0;m<c.getEnrollStudent().size();m++){
                for(int n=0;n<c.getEnrollStudent().size()-1;n++){
                    if(c.getCredits().get(n)<c.getCredits().get(n+1)){
                        int temp1=c.getCredits().get(n);
                        int temp2=c.getCredits().get(n+1);
                        Student s1=c.getEnrollStudent().get(n);
                        Student s2=c.getEnrollStudent().get(n+1);
                        c.getCredits().set(n,temp2);
                        c.getCredits().set(n+1,temp1);
                        c.getEnrollStudent().set(n,s2);
                        c.getEnrollStudent().set(n+1,s1);
                    }
                }
            }
            int Capacity=c.getMaxCapacity();
            int range=c.getCredits().size();
            int leastCredits=0;
            if(range<=Capacity){
                leastCredits=c.getCredits().get(range-1);
            }else{
                leastCredits=c.getCredits().get(Capacity-1);
                if (c.getCredits().get(Capacity)==leastCredits){
                    leastCredits++;
                }
            }
            for(int a=0;a<range;a++){
                if(c.getCredits().get(a)>=leastCredits){
                    temp.add(c.getEnrollStudent().get(a));
                }
            }
            courses.get(b).setSuccessStudents(temp);
            for (int i=0;i<temp.size();i++){
                ArrayList<Course> successCourse =temp.get(i).getSuccessCourses();
                successCourse.add(c);
                temp.get(i).setSuccessCourses(successCourse);
            }

            
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){
            return null;
        }
        ArrayList<String> temp=new ArrayList<>();
        for(Course c:student.getEnrollCourses()){
            for (int a=0;a<c.getEnrollStudent().size();a++){
                if(student.getStudentID().equals(c.getEnrollStudent().get(a).getStudentID())){
                    String s=c.getCourseID()+": "+c.getCredits().get(a);
                    temp.add(s);
                }
            }
        }
        return temp;
    }

}