import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public boolean getIfOpen() {
        return ifOpen;
    }

    public CourseManager(){
        setIfOpen(true);
        this.students=new ArrayList<>(0);
        this.courses=new ArrayList<>(0);
    }


    public void setIfOpen(boolean ifOpen) {this.ifOpen = ifOpen;}

    public ArrayList<Course> getCourses() {return courses;}

    public ArrayList<Student> getStudents() {return students;}

    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        boolean b=true;
        for(int j=0;j<student.getEnrollCourses().size();j++){
            if(student.getEnrollCourses().get(j).getCourseID().equals(courseId)){
                b=false;
            }
        }
        int a=0;
        int I=0;
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                a=1;
                I=i;
            }
        }
        if(credits>0 && ifOpen && student.getCredits()>=credits && a==1 && b){

            student.setCredits(student.getCredits()-credits);
            student.getEnrollCourses().add(courses.get(I));
            courses.get(I).getEnrollStudent().add(student);
            courses.get(I).getCredits().add(credits);

            return true;

        }else{
            return false;
        }


    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        boolean b=true;
        for(int j=0;j<student.getEnrollCourses().size();j++){
            if(student.getEnrollCourses().get(j).getCourseID().equals(courseId)){
                b=false;
            }
        }
        int a=0;
        int I=0;
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                a=1;
                I=i;
            }
        }
        int j=0;
        for(int i=0;i<courses.get(I).getEnrollStudent().size();i++){
            if(courses.get(I).getEnrollStudent().get(i).equals(student)){
                j=i;
                break;
            }
        }
        if(ifOpen && !b && a==1 && student.getCredits()>=credits-courses.get(I).getCredits().get(j)){


            student.setCredits(student.getCredits()-credits+courses.get(I).getCredits().get(j));
            courses.get(I).getCredits().set(j,credits);

            return  true;

        }else{
            return  false;
        }

    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        boolean b=true;
        int J=0;
        for(int j=0;j<student.getEnrollCourses().size();j++){
            if(student.getEnrollCourses().get(j).getCourseID().equals(courseId)){
                J=j;
                b=false;
                break;
            }
        }
        int a=0;
        int I=0;
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                a=1;
                I=i;
            }
        }
        if(ifOpen && !b ){
            int j=0;
            for(int i=0;i<courses.get(I).getEnrollStudent().size();i++){
                if(courses.get(I).getEnrollStudent().get(i).equals(student)){
                    j=i;
                    break;
                }
            }
            student.getEnrollCourses().remove(J);
            student.setCredits(student.getCredits()+courses.get(I).getCredits().get(j));
            courses.get(I).getEnrollStudent().remove(j);
            courses.get(I).getCredits().remove(j);
            return  true;
        }else{
            return false;
        }

    }
    public void finalizeEnrollments(){
        setIfOpen(false);
        for(Course c:courses){
            if(c.getMaxCapacity()>=c.getEnrollStudent().size()){
                for(Student s:c.getEnrollStudent()){
                    c.getSuccessStudents().add(s);
                }

            }else{
                for(int i=0;i<c.getEnrollStudent().size()-1;i++){
                    for(int j=i+1;j<c.getEnrollStudent().size();j++){
                        if(c.getCredits().get(i)<c.getCredits().get(j)){
                            int a=c.getCredits().get(i);
                            Student s=c.getEnrollStudent().get(i);
                            c.getEnrollStudent().set(i,c.getEnrollStudent().get(j));
                            c.getEnrollStudent().set(j,s);
                            c.getCredits().set(i,c.getCredits().get(j));
                            c.getCredits().set(j,a);
                        }
                    }
                }
                for(int i=c.getMaxCapacity()-1;i>=0;i--){
                    if(c.getCredits().get(i).equals(c.getCredits().get(c.getMaxCapacity()))){
                        continue;
                    }else{
                        c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                        c.getEnrollStudent().get(i).getSuccessCourses().add(c);
                    }

                }
            }



        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if(ifOpen){
            ArrayList<String> List = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int J = 0;
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).equals(student)) {
                        J = j;
                        String l = student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(J);
                        List.add(l);
                        break;
                    }
                }
            }
            return List;
        }else{
            return null;
        }

    }
}
