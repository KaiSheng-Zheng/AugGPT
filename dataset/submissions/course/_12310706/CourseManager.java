import java.util.*;
public class CourseManager
{
    private ArrayList<Course> courses=new ArrayList<>();
    private ArrayList<Student> students=new ArrayList<>();
    private boolean ifOpen=true;
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public void setIfOpen(boolean ifOpen){
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
        students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen)
            return false;
        Course course=courseWithID(courseId);
        if(course==null)
            return false;
        if(student.getEnrollCourses().contains(course))
            return false;
        if(credits<=0)
            return false;
        if(credits>student.getCredits())
            return false;
        student.setCredits(student.getCredits()-credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen)
            return false;
        Course course=courseWithID(courseId);
        if(course==null)
            return false;
        if(!student.getEnrollCourses().contains(course))
            return false;
        if(credits<=0)
            return false;
        if(credits>student.getCredits()+getBidOf(student,course))
            return false;
        student.setCredits(student.getCredits()+getBidOf(student,course)-credits);
        course.getCredits().set(course.getEnrollStudent().indexOf(student),credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen)
            return false;
        Course course=courseWithID(courseId);
        if(course==null)
            return false;
        if(!student.getEnrollCourses().contains(course))
            return false;
        student.setCredits(student.getCredits()+getBidOf(student,course));
        student.getEnrollCourses().remove(course);
        course.getCredits().remove(course.getEnrollStudent().indexOf(student));
        course.getEnrollStudent().remove(student);
        return true;
    }
    public void finalizeEnrollments(){
        for(Course course:courses){
            IDontKnowHowToNameThisClassEither[] iDontKnowHowToNameTheseObjectsEither =new IDontKnowHowToNameThisClassEither[course.getEnrollStudent().size()];
            if(iDontKnowHowToNameTheseObjectsEither.length==0)
                continue;
            for(int i = 0; i< iDontKnowHowToNameTheseObjectsEither.length; i++)
                iDontKnowHowToNameTheseObjectsEither[i]=new IDontKnowHowToNameThisClassEither(course.getEnrollStudent().get(i),course.getCredits().get(i));
            Arrays.sort(iDontKnowHowToNameTheseObjectsEither);
            int i=0;
            int j=0;
            while(true){
                j++;
                while(j< iDontKnowHowToNameTheseObjectsEither.length&& iDontKnowHowToNameTheseObjectsEither[j-1].credit== iDontKnowHowToNameTheseObjectsEither[j].credit)
                    j++;
                if(j>course.getMaxCapacity())
                    break;
                for(;i<j;i++){
                    course.getSuccessStudents().add(iDontKnowHowToNameTheseObjectsEither[i].student);
                    iDontKnowHowToNameTheseObjectsEither[i].student.getSuccessCourses().add(course);
                }
                if(j== iDontKnowHowToNameTheseObjectsEither.length)
                    break;
            }
        }
        ifOpen=false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen)
            return null;
        ArrayList<String> strings=new ArrayList<>();
        for(Course course:student.getEnrollCourses())
            strings.add(String.format("%s: %d",course.getCourseID(),course.getCredits().get(course.getEnrollStudent().indexOf(student))));
        return strings;
    }
    public Course courseWithID(String courseID){
        for(Course course:courses)
            if(course.getCourseID().equals(courseID))
                return course;
        return null;
    }
    public int getBidOf(Student student, Course course){
        if(!course.getEnrollStudent().contains(student))
            return 0;
        return course.getCredits().get(course.getEnrollStudent().indexOf(student));
    }
}
class IDontKnowHowToNameThisClassEither
implements Comparable
{
    public Student student;
    public int credit;
    public IDontKnowHowToNameThisClassEither(Student student, int credit){
        this.student=student;
        this.credit=credit;
    }
    @Override public int compareTo(Object o){
        IDontKnowHowToNameThisClassEither iDontKnowHowToNameThisObjectEither=(IDontKnowHowToNameThisClassEither)o;
        return iDontKnowHowToNameThisObjectEither.credit-this.credit;
    }
}
