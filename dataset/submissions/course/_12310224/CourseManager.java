import javax.lang.model.util.Elements;
import java.util.ArrayList;

public class CourseManager {


    private ArrayList<Course> courses ;

    private ArrayList<Student> students ;

    private boolean ifOpen ;

    public CourseManager()
    {
        this.courses = new ArrayList<>();

        this.students =new ArrayList<>();

        this.ifOpen = true;

    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public void addStudent(Student student){
        this.students.add(student);

        student.setCourseManager(this);
    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }




    public boolean enrollStudentInCourse(Student student, String courseID, int credits){
        if (!this.ifOpen) {
            return false;
        }

        if (credits <= 0) {
            return false;
        }

        Course course=null;
        for (Course e:courses){
            if (e.getCourseID().equals(courseID)){
                course = e;
                break;
            }
        }
        if (course==null){return false;}

        Course s=null;
        for (int i = 0; i < student.getEnrollCourses().size(); i++)
        {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseID)){
                s=courses.get(i);
                break;
            }
        }
        if (s!=null){return false;}

        if (student.getCredits()<credits){
            return false;
        }

        student.setCredits(student.getCredits()-credits);
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseID))
            {
                courses.get(i).getEnrollStudent().add(student);
                courses.get(i).getCredits().add(credits);
                student.getEnrollCourses().add(courses.get(i));
                return true;
            }
        }
        return false;
    }






    public boolean modifyStudentEnrollmentCredits(Student student, String courseID, int credits){

        if (!ifOpen)return false;


        Course course=null;
        for (Course e:courses){
            if (e.getCourseID().equals(courseID)){
                course = e;
                break;
            }
        }
        if (course==null){return false;}

        int OriginalCredit = 0;
        int index=-1;
        boolean x=false;
        for (Course c:student.getEnrollCourses())
            if (c.getCourseID().equals(courseID))
            {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID()))
                    {
                        index = i;
                        x=true;
                    }
                }
                OriginalCredit = c.getCredits().get(index);
                if (credits>student.getCredits()+ OriginalCredit){return false;}
                
                c.getCredits().set(index,credits);
            }

        if (!x){return false;}


        student.setCredits(student.getCredits()-credits+OriginalCredit);

        return true;
    }





    public boolean dropStudentEnrollmentCourse(Student student, String courseID){

        if (!ifOpen){
            return false;
        }


        boolean y=false;
        for (Course e:courses){
            if (e.getCourseID().equals(courseID)){
                y=true;
                break;
            }
        }
        if (!y){return false;}


        boolean x=false;
        int index1 = -1;
        int index2 = -1;
        Course c;
        for (int j=0; j < student.getEnrollCourses().size();j++)
            if(student.getEnrollCourses().get(j).getCourseID().equals(courseID)){
                c=student.getEnrollCourses().get(j);
                for (int i = 0; i < c.getEnrollStudent().size(); i++)
                {
                    if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID()))
                    {
                        index1=i;
                        x=true;
                        break;
                    }
                }
                int OriginalCredit=c.getCredits().get(index1);
                c.getEnrollStudent().remove(index1);
                c.getCredits().remove(index1);


                index2=j;
                student.getEnrollCourses().remove(index2);
                student.setCredits(OriginalCredit+student.getCredits());
                return true;
            }
        if (!x){return false;}
        return false;
    }






    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen){return null;}
        ArrayList<String> myCourse = new ArrayList<>();
        ArrayList<Integer> indexOfStudent=new ArrayList<>();

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {

            for (int j = 0; j <student.getEnrollCourses().get(i).getEnrollStudent().size(); j++)
            {
                if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).equals(student))
                {
                    indexOfStudent.add(j);
                }
            }
            myCourse.add(student.getEnrollCourses().get(i).getCourseID()+": "+student.getEnrollCourses().get(i).getCredits().get(indexOfStudent.get(i)));
        }

        return myCourse;
    }





    public void finalizeEnrollments() {
        ifOpen = false;
        int max=0;
        int min=100;
        int capacity;
        for (int i = 0; i < courses.size(); i++) {
            Course c=courses.get(i);
            for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++)
            {
                if (max<courses.get(i).getCredits().get(j))
                {
                    max=courses.get(i).getCredits().get(j);
                }
                if (min>courses.get(i).getCredits().get(j))
                {
                    min=courses.get(i).getCredits().get(j);
                }
            }

            max++;
            while(max>=min){
                capacity=0;
                for (int k = 0; k < courses.get(i).getCredits().size(); k++)
                {
                    if (courses.get(i).getCredits().get(k)>=max)
                    {
                        capacity++;
                    }
                }
                if (capacity<courses.get(i).getMaxCapacity())
                {
                    max--;
                }
                else if(capacity==courses.get(i).getMaxCapacity())break;
                else {
                    max++;
                    break;
                }
            }
            int ans=max;
            for (int j = 0; j < c.getCredits().size(); j++) {
                if (c.getCredits().get(j) >= ans) {
                    c.getSuccessStudents().add(c.getEnrollStudent().get(j));
                    for (Student s : students) {
                        if (s.getStudentID().equals(c.getEnrollStudent().get(j).getStudentID())) {
                            s.getSuccessCourses().add(c);
                            break;
                        }
                    }
                }
            }
        }
    }

}



















