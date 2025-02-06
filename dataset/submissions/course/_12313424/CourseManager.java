import java.util.ArrayList;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;


    private ArrayList<Student> students;


    private boolean ifOpen;


    public CourseManager(){
        this.courses=new ArrayList<>();
        this.students=new ArrayList<>();
        setIfOpen(ifOpen);
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }

    public boolean getIfOpen(){
        return ifOpen;
    }

    public void addCourse(Course course){

        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student){

        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(ifOpen==false){
            return false;
        }
        if (credits <= 0){
            return false;
        }
        if (credits > student.getCredits()){
            return false;
        }

        for (int i=0;i<student.getEnrollCourses().size();i++){
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                return false;
            }
        }
        Course course1=null;
        for (int i=0;i<courses.size();i++){
            if (courses.get(i).getCourseID().equals(courseId)){
                course1=courses.get(i);
            }
        }
        if (course1 == null){
            return false;
        }

        student.getEnrollCourses().add(course1);
        student.setCredits(student.getCredits()-credits);

        course1.getEnrollStudent().add(student);
        course1.getCredits().add(credits);

        return true;



    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }
        if (credits <= 0){
            return false;
        }
        Course course=null;
        for (int i=0;i<courses.size();i++){
            if (courses.get(i).getCourseID().equals(courseId)){
                course=courses.get(i);
            }
        }
        if (course == null){
            return false;
        }


        int a=-1;
        for (int i=0;i<course.getEnrollStudent().size();i++){
            if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                a=i;
                break;
            }

        }
        if (a==-1){
            return false;
        }
        int m=course.getCredits().get(a);

        course.getCredits().set(a,credits);

        // no boundary check, will decrease to negative
        student.setCredits(student.getCredits()+m-credits);


        return true;



    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }

        for (int i=0;i<courses.size();i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                    if (courses.get(i).getEnrollStudent().get(j) == student) {
                        int a = student.getCredits() + courses.get(i).getCredits().get(j);
                        student.setCredits(a);
                        for (int k = 0; k < student.getEnrollCourses().size(); k++) {
                            if (student.getEnrollCourses().get(k).getCourseID().equals(courseId)) {
                                student.getEnrollCourses().remove(k);
                            }
                        }

                        courses.get(i).getEnrollStudent().remove(j);
                        courses.get(i).getCredits().remove(j);
                        return true;
                    }

                }
            }
        }
        return false;
    }


    public void finalizeEnrollments(){
        setIfOpen(false);
        for (int i=0;i<courses.size();i++) {
            ArrayList<Integer> a = new ArrayList<>();

            int[] b=new int[courses.get(i).getCredits().size()];


            for (int j=0;j<courses.get(i).getCredits().size();j++){
                b[j]=courses.get(i).getCredits().get(j);
                a.add(b[j]);
            }

            Collections.sort(a,Collections.reverseOrder());


            for (int k=0;k<courses.get(i).getCredits().size();k++){
                if (courses.get(i).getCredits().size() <= courses.get(i).getMaxCapacity()){

                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(k));

                    courses.get(i).getEnrollStudent().get(k).getSuccessCourses().add(courses.get(i));
                }
                else if (courses.get(i).getCredits().get(k) > a.get(courses.get(i).getMaxCapacity()) ){

                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(k));

                    courses.get(i).getEnrollStudent().get(k).getSuccessCourses().add(courses.get(i));

                }

            }



        }

    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (ifOpen==false){
            return null;
        }

        ArrayList<String> b=new ArrayList<>();


        for (int i=0;i<student.getEnrollCourses().size();i++){
            for (int j=0;j<student.getEnrollCourses().get(i).getCredits().size();j++){
                if (student.getEnrollCourses().get(i).getEnrollStudent().get(j)==student){
                    String m=String.valueOf(student.getEnrollCourses().get(i).getCredits().get(j));
                    String n=student.getEnrollCourses().get(i).getCourseID();
                    String l=n+":"+" "+m;
                    b.add(l);
                }
            }
        }




        return b;

    }



}
