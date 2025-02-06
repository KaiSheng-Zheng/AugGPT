import java.util.ArrayList;

public class CourseManager {
    private boolean ifOpen;
    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course){
        course.setCourseManager(this);
        courses.add(course);
    }
    public void addStudent(Student student){
        student.setCourseManager(this);
        students.add(student);
    }

    public CourseManager(){
        ifOpen=true;
        students=new ArrayList<>(0);
        courses=new ArrayList<>(0);
    }
    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        if(ifOpen==false)return false;
        Course course=FindCourse(courseId);
        if(course==null)return false;
        if(
                credits>0
                && !course.getEnrollStudent().contains(student)
                && student.getCredits()>=credits)
        {
            addBidding(student,course,credits);
            return true;
        }
        return false;
    }
    private void addBidding(Student student,Course course,int credits){
        ArrayList<Integer> CList=course.getCredits();
        int index=0;
        for (int i = 0; i < CList.size(); i++) {
            if(CList.get(i)>credits)index=i+1;
        }

        CList.add(index,credits);
        course.getEnrollStudent().add(index,student);
        student.setCredits(student.getCredits()-credits);
        student.getEnrollCourses().add(course);
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(ifOpen==false)return false;
        Course course=FindCourse(courseId);
        if(course==null)return false;
        if(credits<0)return false;
        if(!course.getEnrollStudent().contains(student))return false;

        int curcredit=removeBidding(student,course);
        if(credits <= student.getCredits()){
            addBidding(student,course,credits);
            return true;
        }
        else {
            addBidding(student,course,curcredit);
            return false;
        }

    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(ifOpen==false)return false;
        Course course=FindCourse(courseId);
        if(course==null)return false;
        if(!course.getEnrollStudent().contains(student))return false;

        removeBidding(student,course);
        return true;

    }

    private int removeBidding(Student student,Course course){
        int index=course.getEnrollStudent().indexOf(student);

        int credit=course.getCredits().get(index);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);
        student.setCredits(student.getCredits()+credit);
        student.getEnrollCourses().remove(course);
        return credit;
    }
    private Course FindCourse(String couesID){
        Course course=null;
        for (int i = 0; i < courses.size() ; i++) {
            if(courses.get(i).getCourseID().equals(couesID))course=courses.get(i);
        }
        return course;
    }
    public void finalizeEnrollments(){
        if(ifOpen==false)return;
        ifOpen=false;
        for (int i = 0; i < courses.size(); i++) {

            Course course=courses.get(i);
            ArrayList<Integer> c=course.getCredits();

            int index=0;
            if(course.getMaxCapacity() < c.size()){
                int credit = c.get(course.getMaxCapacity());
                index = c.indexOf(credit);
            }
            else index=c.size();

            ArrayList<Student> s0=course.getEnrollStudent();
            ArrayList<Student> s1=course.getSuccessStudents();
            for (int j = 0; j < index; j++) {
                s1.add( j , s0.get(j) );
            }

        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){

        ArrayList<Course> c=student.getEnrollCourses();
        ArrayList<String> strings=new ArrayList<>(0);

        for (int i = 0; i < c.size(); i++) {
            Course course=c.get(i);

            int index=course.getEnrollStudent().indexOf(student);

            strings.add(
                    course.getCourseID()
                    + ": "
                    + course.getCredits().get(index)
            );

        }
        return strings;
    }



}

