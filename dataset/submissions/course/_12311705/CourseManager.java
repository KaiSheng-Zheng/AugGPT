import java.util.*;

import static java.lang.Integer.*;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager () {
        ifOpen=true;
        this.courses= new ArrayList<Course>();
        this.students= new ArrayList<Student>();
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
        course.setCourseManager(this);
        courses.add(course);
    }
    public void addStudent(Student student){
        student.setCourseManager(this);
        students.add(student);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(ifOpen==false||student.getCredits()<credits||credits<=0)return false;
        for(int i=0;i< courses.size();++i)
            if(courses.get(i).getCourseID().equals(courseId)){
                Course t=courses.get(i);
                for(int j=0;j<t.getEnrollStudent().size();++j)
                    if(t.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        return false;
                    }
                student.setCredits(student.getCredits()-credits);
                ArrayList<Student> stu=t.getEnrollStudent();
                ArrayList<Integer> credit=t.getCredits();
                ArrayList <Course> enroll=student.getEnrollCourses();
                enroll.add(t);
                stu.add(student);
                credit.add(credits);
                student.setEnrollCourses(enroll);
                t.setEnrollStudent(stu);
                t.setCredits(credit);
                courses.set(i,t);
                for(int j=0;j<students.size();++j)
                    if(student.getStudentID().equals(students.get(j).getStudentID())){
                        students.set(j,student);
                        return true;
                    }
                return true;
            }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(ifOpen==false||credits<0)return false;
        for(int i=0;i<courses.size();++i)
            if(courses.get(i).getCourseID().equals(courseId)){
                Course t=courses.get(i);
                for(int j=0;j<t.getEnrollStudent().size();++j)
                    if(t.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID()) ) {
                        Student stu=t.getEnrollStudent().get(j);
                        if((stu.getCredits()+t.getCredits().get(j)-credits)<0)return false;
                        stu.setCredits(stu.getCredits()+t.getCredits().get(j)-credits);
                        ArrayList<Student> enroll = t.getEnrollStudent();
                        ArrayList<Integer> credit = t.getCredits();
                        credit.set(j,credits);
                        enroll.set(j,stu);
                        t.setEnrollStudent(enroll);
                        t.setCredits(credit);
                        courses.set(i,t);
                        return true;
                    }
            }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(ifOpen==false)return false;
        for (int i=0;i<courses.size();++i){
            if (courses.get(i).getCourseID().equals(courseId)){
                Course t=courses.get(i);
                for(int j=0;j<t.getEnrollStudent().size();++j)
                    if(t.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        student.setCredits(student.getCredits()+t.getCredits().get(j));
                        for(int k=0;k<student.getEnrollCourses().size();++k){
                            if(student.getEnrollCourses().get(k).getCourseID().equals(courseId)){
                                ArrayList<Course> enrollCourses=  student.getEnrollCourses();
                                enrollCourses.remove(k);
                                student.setEnrollCourses(enrollCourses);
                            }
                        }
                        ArrayList<Student> enrollStudent=t.getEnrollStudent();
                        ArrayList<Integer> credits=t.getCredits();
                        enrollStudent.remove(j);
                        credits.remove(j);
                        t.setEnrollStudent(enrollStudent);
                        t.setCredits(credits);
                        courses.set(i,t);
                        return true;
                    }
            }
        }
        return false;
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        for(int i=0;i<courses.size();++i){
            Course t=courses.get(i);
            ArrayList<Student> enrollStudent=t.getEnrollStudent();
            ArrayList<Integer> credits=t.getCredits();
            for(int j=0;j<t.getEnrollStudent().size();++j)
                for (int k=0;k<t.getEnrollStudent().size();++k)
                    if(credits.get(j)>credits.get(k)) {
                        int tmp1=credits.get(j);
                        credits.set(j,credits.get(k));
                        credits.set(k,tmp1);
                        Student tmp2=enrollStudent.get(j);
                        enrollStudent.set(j,enrollStudent.get(k));
                        enrollStudent.set(k,tmp2);
                    }
            ArrayList<Student> successStudents=t.getSuccessStudents();
            for(int j=0;j<min(t.getMaxCapacity(),t.getEnrollStudent().size());++j){
                successStudents.add(t.getEnrollStudent().get(j));
                for(int k=0;k<students.size();++k)
                    if(students.get(k).getStudentID().equals(successStudents.get(j).getStudentID())){
                        ArrayList<Course> tmp=t.getEnrollStudent().get(j).getSuccessCourses();
                        tmp.add(t);
                        Student stu=students.get(k);
                        stu.setSuccessCourses(tmp);
                        students.set(k,stu);
                    }
            }
            if(t.getMaxCapacity()<t.getEnrollStudent().size()){
                int c=t.getCredits().get(t.getMaxCapacity());
                if(c==t.getCredits().get(t.getMaxCapacity()-1)){
                    for(int j=t.getMaxCapacity()-1;j>=0;--j)
                        if(t.getCredits().get(j)!=c)break;
                        else{
                            for(int k=0;k<students.size();++k)
                                if(students.get(k).getStudentID().equals(successStudents.get(j).getStudentID())){
                                    ArrayList<Course> tmp=t.getEnrollStudent().get(j).getSuccessCourses();
                                    tmp.remove(tmp.size()-1);
                                    Student stu=students.get(k);
                                    stu.setSuccessCourses(tmp);
                                    students.set(k,stu);
                                    break;
                                }
                            successStudents.remove(j);
                        }
                }
            }
            t.setSuccessStudents(successStudents);
            courses.set(i,t);
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList <String> ans = new ArrayList<String>();
        for(int i=0;i<courses.size();++i){
            Course t=courses.get(i);
            for(int j=0;j<t.getEnrollStudent().size();++j){
                if(t.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                    ans.add(t.getCourseID()+": "+t.getCredits().get(j));
                }
            }
        }
        return ans;
    }
}