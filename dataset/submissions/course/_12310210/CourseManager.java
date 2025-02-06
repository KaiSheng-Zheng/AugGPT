import java.util.ArrayList;

public class CourseManager {

    private ArrayList<Course> courses; 
    private ArrayList<Student> students;
    private boolean ifOpen;
    

    public CourseManager(){
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
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
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
         if(!ifOpen) return false;
        int a1=0;int a2=0;boolean a=false;
        for(int i=0;i<courses.size();i++)
        {if(courses.get(i).getCourseID().equals(courseId)){a1=i;a2++;}}
        if(a2!=0){a=true;}
        boolean b=true;
       for (int j = 0; j < student.getEnrollCourses().size(); j++)
        {
            if (student.getEnrollCourses().get(j).getCourseID().equals(courseId)) {
                b = false;
                break;
            }
        }
        if(a||b||student.getCredits()>=credits){
            int g=student.getCredits();
            student.setCredits(g-credits);
            ArrayList<Student> tt1=courses.get(a1).getEnrollStudent();
            ArrayList<Integer> tt2=courses.get(a1).getCredits();
            ArrayList<Course> tt3=student.getEnrollCourses();
            tt1.add(student);
            tt2.add(credits);
            tt3.add(courses.get(a1));
            courses.get(a1).setEnrollStudent(tt1);
            courses.get(a1).setCredits(tt2);
            student.setEnrollCourses(tt3);
            return true;
        }else {return false;}
    }

   public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
       if(!ifOpen) return false;
        Course ff=null;
        for(Course a:courses){
            if(a.getCourseID().equals(courseId)){
                ff=a;
                break;
            }
        }
        Course pp=null;
        for(Course a:student.getEnrollCourses()){
            if(a.getCourseID().equals(courseId)){
                pp=a;
                break;
            }
        }

        if(ff!=null||credits>0||pp!=null){
            for (int i = 0; i < ff.getCredits().size(); i++) {
                if (student.getStudentID().equals(ff.getEnrollStudent().get(i).getStudentID())){
                    int sec=ff.getCredits().get(i)+student.getCredits();
                    if(sec<credits){
                        return false;}
                    ff.getCredits().set(i,credits);
                    student.setCredits(sec-credits);
                    break;
                }
            }
            return true;
        } else {return false;}
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen) return false;
        int a1=0;int a2=0;boolean a=false;
        for(int i=0;i<courses.size();i++){if(courses.get(i).getCourseID().equals(courseId)){a1=i;a2++;}}
        if(a2!=0){a=true;}
        int b1=0;int b2=0;boolean b=false;
        for (int j = 0; j < courses.get(a1).getEnrollStudent().size(); j++)
        {if (courses.get(a1).getEnrollStudent().get(j).equals(student)){b1=j;b2++;}}
        if(b2!=0){b=true;}
        int l=student.getCredits();
        int g=courses.get(a1).getCredits().get(b1);
        if(a||b){
            ArrayList<Student> tt1=courses.get(a1).getEnrollStudent();
            ArrayList<Integer> tt2=courses.get(a1).getCredits();
            tt1.remove(b1);
            tt2.remove(b1);
            courses.get(a1).setEnrollStudent(tt1);
            courses.get(a1).setCredits(tt2);
            student.setCredits(l+g);
            return true;
        }else {return false;}
    }

   
   public void finalizeEnrollments() {
       ifOpen = false;
       for (Course c : courses) {
           int Max = -100, ans = 1000099;
           for (int q : c.getCredits()) {
               if(q>Max)Max=q;
           }
           Max+=2;
           while (Max > 0) {
               int p = 0;
               for (int q : c.getCredits()) {
                   if (q >= Max) p++;
               }
               p++;p--;
               if (p > c.getMaxCapacity()) {
                   for (int i=Max+1;i<Max+5;i++) {
                       p=0;
                       for(int q:c.getCredits())
                       {
                           if (q >= i) p++;
                       }
                       if(p<=c.getMaxCapacity()){ans=i;break;}
                   }
                   break;
               }
               else {
                   ans = Max;
                   Max -= 5;
                   if(Max<=0){
                       for (int i=1;i<Max+5;i++) {
                           p=0;
                           for(int q:c.getCredits())
                           {
                               if (q >= i) p++;
                           }
                           if(p<=c.getMaxCapacity()){ans=i;break;}
                       }
                       break;
                   }
               }
           }
           for (int i = 0; i < c.getCredits().size(); i++) {
               if (c.getCredits().get(i) >= ans) {
                   c.getSuccessStudents().add(c.getEnrollStudent().get(i));
                   for (Student s : students) {
                       if (s.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                           s.getSuccessCourses().add(c);
                           break;
                       }
                   }
               }
           }
       }
   }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> slo=new ArrayList<>();
        if(ifOpen){
            int sl=0;
            for(int i=0;i<student.getEnrollCourses().size();i++){
              for(int j=0;j<student.getEnrollCourses().get(i).getEnrollStudent().size();j++){
                if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).equals(student)) {sl=j;}  
                slo.add(student.getEnrollCourses().get(i).getCourseID().toString()+": "+student.getEnrollCourses().get(i).getCredits().get(j).toString()) ;
              }
            }
        }else{return null;}
        return slo;
    }

    }
