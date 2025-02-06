import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        courses=new ArrayList<Course>();
        students=new ArrayList<Student>();
        ifOpen=true;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }


    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        boolean judge=false;
       if (ifOpen&&credits>0){
           for (Student i:students){
               if (i==student){
                   if (credits<=i.getCredits()){
                   for (Course j:courses){
                       if (j.getCourseID().equals(courseId)){
                           judge=true;
                           i.setCredits(i.getCredits()-credits);
                           ArrayList<Course> sc=i.getEnrollCourses();
                           sc.add(j);
                           i.setEnrollCourses(sc);
                           ArrayList<Student> cs=j.getEnrollStudent();
                           cs.add(i);
                           j.setEnrollStudent(cs);
                           ArrayList<Integer> csc=j.getCredits();
                           csc.add(credits);
                           j.setCredits(csc);
                           break;
                       }
                   }}break;
               }
           }
       }
        return judge;
    }


    public boolean modifyStudentEnrollmentCredits(Student student,String courseId,int credits){
        boolean judge=false;
        if (credits>0&&ifOpen){
            for (Student i:students){
                if (i==student){
                    for (Course j:courses){
                        if (j.getCourseID().equals(courseId)){
                            for (int h=0;h<j.getEnrollStudent().size();h++){
                                if (j.getEnrollStudent().get(h)==student){
                                 if (i.getCredits()>=credits-j.getCredits().get(h)){
                                     judge=true;
                                     i.setCredits(i.getCredits()+j.getCredits().get(h)-credits);
                                     j.getCredits().set(h,credits);
                                 }break;
                                }
                            }
                        }
                    }break;
                }
            }
        }
        return judge;
    }



    public boolean dropStudentEnrollmentCourse(Student student,String courseId){
        boolean judge=false;
        if (ifOpen){
            for (Course i:courses){
                if (i.getCourseID().equals(courseId)){
                    for (int j=0;j<i.getEnrollStudent().size();j++){
                        if (i.getEnrollStudent().get(j)==student){
                            student.setCredits(student.getCredits()+i.getCredits().get(j));
                            i.getEnrollStudent().get(j).getEnrollCourses().remove(i);
                            ArrayList<Integer> sc=i.getCredits();
                            sc.remove(j);
                            i.setCredits(sc);
                            ArrayList<Student> s=i.getEnrollStudent();
                            s.remove(j);
                            i.setEnrollStudent(s);
                            judge=true;
                            break;
                        }
                    }break;
                }
            }
        }return judge;
    }


    public void finalizeEnrollments(){
        setIfOpen(false);
        for (Course i:courses){
            ArrayList<Integer> studentcredits=new ArrayList<Integer>();
            for (int j=0;j<i.getCredits().size();j++){
                studentcredits.add(i.getCredits().get(j));
            }
            if (i.getMaxCapacity()<i.getEnrollStudent().size()){
            for (int j=0;j<studentcredits.size();j++){
                studentcredits.set(j,-studentcredits.get(j));
            }Collections.sort(studentcredits);
            for (int j=0;j<studentcredits.size();j++) {
                studentcredits.set(j, -studentcredits.get(j));
            }    int n=studentcredits.get(i.getMaxCapacity());
            for (int j=studentcredits.size()-1;j>=i.getMaxCapacity();j--){
                studentcredits.remove(j);
                }if (studentcredits.get(i.getMaxCapacity()-1)==n){
                for (int j=studentcredits.size()-1;j>=0;j--){
                    if (studentcredits.get(j)==n){
                        studentcredits.remove(j);
                    }
                }}
                }for (int j=0;j<i.getEnrollStudent().size();j++){
                for (int f:studentcredits){
                    if (i.getCredits().get(j)>=f){
                        ArrayList<Student> successStudent=i.getSuccessStudents();
                        successStudent.add(i.getEnrollStudent().get(j));
                        i.setSuccessStudents(successStudent);
                        ArrayList<Course> successCourse=i.getEnrollStudent().get(j).getSuccessCourses();
                        successCourse.add(i);
                        i.getEnrollStudent().get(j).setSuccessCourses(successCourse);
                        break;
                    }
                }
                }
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> finalString=new ArrayList<String>();
        for (Course i:student.getEnrollCourses()){
            for (int j=0;j<i.getEnrollStudent().size();j++){
                if (i.getEnrollStudent().get(j)==student){
                    String s1=i.getCourseID();
                    String s3=String.valueOf(i.getCredits().get(j));
                    finalString.add(s1.concat(": ").concat(s3));
                    break;
                }
            }
        }
        return finalString;
    }
}