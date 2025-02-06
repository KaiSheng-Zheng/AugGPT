import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager()
    {
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    public ArrayList<Student> getStudents()
    {
        return students;
    }
// getter for students

    public ArrayList<Course> getCourses()
    {
        return courses;
    }
// getter for courses

    public void setIfOpen(Boolean ifOpen)
    {
        this.ifOpen=ifOpen;
    }
// setter for ifOpen

    public boolean getIfOpen()
    {
        return ifOpen;
    }
// getter for ifOpen

    public void addCourse(Course course)
    {
        this.courses.add(course);
        course.setCourseManager(this);
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student)
    {
        this.students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits)
    {
        if(!ifOpen)
        {
            return false;
        }
        boolean flag=false;
        int i=0;
        for(;i<courses.size();i++)
        {
            if(courses.get(i).getCourseID().equals(courseId))
            {
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            return false;
        }
        int j=0;
        ArrayList<Course> erc=student.getEnrollCourses();
        for(;j<erc.size();j++)
        {
            if(erc.get(j).getCourseID().equals(courseId))
            {
                return false;
            }
        }
        if(credits<=0)
        {
            return false;
        }
        if(credits>student.getCredits())
        {
            return false;
        }
        student.setCredits(student.getCredits()-credits);
        erc.add(courses.get(i));
        student.setEnrollCourses(erc);
        Course cse=courses.get(i);
        ArrayList<Student> es=cse.getEnrollStudent();
        es.add(student);
        cse.setEnrollStudent(es);
        ArrayList<Integer> C=cse.getCredits();
        C.add(credits);
        cse.setCredits(C);
        courses.set(i,cse);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits)
    {
        if(!ifOpen)
        {
            return false;
        }
        if(credits<=0) return false;
        boolean flag=false;
        int i=0;
        for(;i<courses.size();i++)
        {
            if(courses.get(i).getCourseID().equals(courseId))
            {
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            return false;
        }
        int j=0;flag=false;
        ArrayList<Course> erc=student.getEnrollCourses();
        for(;j<erc.size();j++)
        {
            if(erc.get(j).getCourseID().equals(courseId))
            {
                flag=true;
                break;
            }
        }
        if(!flag) {
            return false;
        }
        Course currentcourse=courses.get(i);
        int k=0;
        for(;k<currentcourse.getEnrollStudent().size();k++)
        {
            if(currentcourse.getEnrollStudent().get(k)==student)
            {
                break;
            }
        }
        if(credits>student.getCredits()+currentcourse.getCredits().get(k))
        {
            return false;
        }
        student.setCredits(student.getCredits()+currentcourse.getCredits().get(k)-credits);
        ArrayList<Integer> currentcredits=currentcourse.getCredits();
        currentcredits.set(k,credits);
        currentcourse.setCredits(currentcredits);
        courses.set(i,currentcourse);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId)
    {
        if(!ifOpen)
        {
            return false;
        }
        boolean flag=false;
        int i=0;
        for(;i<courses.size();i++)
        {
            if(courses.get(i).getCourseID().equals(courseId))
            {
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            return false;
        }
        int j=0;
        flag=false;
        ArrayList<Course> erc=student.getEnrollCourses();
        for(;j<erc.size();j++)
        {
            if(erc.get(j).getCourseID().equals(courseId))
            {
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            return false;
        }
        Course currentcourse=courses.get(i);
        int k=0;
        for(;k<currentcourse.getEnrollStudent().size();k++)
        {
            if(currentcourse.getEnrollStudent().get(k)==student)
            {
                break;
            }
        }
        student.setCredits(student.getCredits()+currentcourse.getCredits().get(k));
        ArrayList<Integer> currentcredits=currentcourse.getCredits();
        currentcredits.remove(k);
        currentcourse.setCredits(currentcredits);
        ArrayList<Student> ces=currentcourse.getEnrollStudent();
        ces.remove(k);
        currentcourse.setEnrollStudent(ces);
        courses.set(i,currentcourse);
        erc.remove(j);
        student.setEnrollCourses(erc);
        return true;
    }
    public void finalizeEnrollments()
    {
        ifOpen=false;
        int mx=0;
        for(int i=0;i<courses.size();i++) {
            Course ccourse = courses.get(i);
            ArrayList<Integer> cc = ccourse.getCredits();
            //Collections.sort(cc);
            mx = -1;int cnt=ccourse.getMaxCapacity()+1;
            while(cnt>ccourse.getMaxCapacity())
            {
                mx++;cnt=0;
                for(int tt=0;tt<cc.size();tt++)
                {
                    if(cc.get(tt)>mx) cnt++;
                }
            }
            for (int j = 0; j < ccourse.getEnrollStudent().size(); j++) {
                if (ccourse.getCredits().get(j) > mx) {
                    ArrayList<Student> sss = ccourse.getSuccessStudents();
                    sss.add(ccourse.getEnrollStudent().get(j));
                    ccourse.setSuccessStudents(sss);
                    for(int k=0;k<students.size();k++)
                    {
                        if(students.get(k)==ccourse.getEnrollStudent().get(j))
                        {
                            Student stu=students.get(k);
                            ArrayList<Course> ccs= stu.getSuccessCourses();
                            ccs.add(ccourse);
                            stu.setSuccessCourses(ccs);
                            students.set(k,stu);
                        }
                    }
                }
            }
            courses.set(i,ccourse);
        }
        //return mx;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student)
    {
        ArrayList<String> s=new ArrayList<>();
        if(!ifOpen)
        {
            return s;
        }
        for(int i=0;i<student.getEnrollCourses().size();i++)
        {
            Course cs=student.getEnrollCourses().get(i);
            int cdd=0;
            for(int j=0;j<cs.getEnrollStudent().size();j++)
            {
                if(cs.getEnrollStudent().get(j)==student)
                {
                    cdd=cs.getCredits().get(j);
                    break;
                }
            }
            s.add(cs.getCourseID()+": "+cdd);
        }
        return s;
    }
}
