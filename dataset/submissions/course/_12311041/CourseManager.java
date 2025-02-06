import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class CourseManager{
    private ArrayList<Student>students;
   private ArrayList<Course>courses;
   private boolean ifOpen;
   public CourseManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.ifOpen=true;
   }
   public CourseManager(ArrayList<Student> students, ArrayList<Course> courses, boolean ifOpen) {
        this.students = students != null ? new ArrayList<>(students) : new ArrayList<>();
        this.courses = courses != null ? new ArrayList<>(courses) : new ArrayList<>();
        this.ifOpen = ifOpen;
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);

    }
    public ArrayList<Course> getCourses() {
        return new ArrayList<>(courses);
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }

    public boolean getIfOpen()
    {return ifOpen;}
    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }public void addStudent(Student student){
        students.add(student);
            student.setCourseManager(this);}
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen)
        {
            return false;
        }
        Course qucourse=null;
        for (int i=0;i<courses.size();i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                qucourse = courses.get(i);
                break;
            }
        }
        if(qucourse==null){
            return false;}


        if(credits<=0)
        {return false;}

        if(credits>student.getCredits())
        {return false;}

        if(student.getEnrollCourses().contains(qucourse))
        {return false;}

        qucourse.getEnrollStudent().add(student);
        student.getEnrollCourses().add(qucourse);
        student.setCredits(student.getCredits()-credits);
        qucourse.getCredits().add(credits);

        return true;}

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits)
 {
     if(!ifOpen)
       {return false;}

        Course qucourse=null;
        for (int i=0;i<courses.size();i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                qucourse = courses.get(i);
                break;
            }
        }
        if(qucourse==null){
          return false;}
        if(credits<=0)
        {return false;}
     int studentIndex = qucourse.getEnrollStudent().indexOf(student);
        if(studentIndex!=-1)
        {int ccredits = qucourse.getCredits().get(studentIndex);
        if(!student.getEnrollCourses().contains(qucourse))
        {return false;}


       if(student.getCredits()+ccredits<credits)
     {return false;}


       qucourse.getCredits().set(studentIndex,credits);
        student.setCredits(student.getCredits()-credits+ccredits);
        return true;}
 return false;}






    public boolean dropStudentEnrollmentCourse(Student student, String courseId)
    {
        if(!ifOpen)
        {return false;}
        Course qucourse=null;
        for (int i=0;i<courses.size();i++) {
            if (courses.get(i).getCourseID().equals(courseId))
            {qucourse=courses.get(i);}}

            if(!qucourse.getEnrollStudent().contains(student)){return false;}
        int studentIndex = qucourse.getEnrollStudent().indexOf(student);
        int ccredits=0;
        if(studentIndex!=-1)
        {ccredits = qucourse.getCredits().get(studentIndex);}
        student.setCredits(student.getCredits()+ccredits);
        qucourse.getCredits().remove(studentIndex);
            qucourse.getEnrollStudent().remove(student);
            student.getEnrollCourses().remove(qucourse);

            return true;
           }






                public void finalizeEnrollments(){
                ifOpen=false;
                Student qustudent=null;
                Course qucourse=null;
                for (int u = 0; u < courses.size(); u++) {
                    qucourse = courses.get(u);

                    if(qucourse.getMaxCapacity()>=qucourse.getEnrollStudent().size()) {
                        for (int i = 0; i < qucourse.getEnrollStudent().size(); i++) {
                            qucourse.getSuccessStudents().add(qucourse.getEnrollStudent().get(i));
                            qucourse.getEnrollStudent().get(i).getSuccessCourses().add(qucourse);
                        }}


                    else {
                        if (qucourse.getEnrollStudent().size() == 1) {
                            qustudent = qucourse.getEnrollStudent().get(0);
                            qucourse.getSuccessStudents().add(qustudent);
                            qustudent.getSuccessCourses().add(qucourse);
                        }

                        if (qucourse.getEnrollStudent().size() >= 2) {

                            List<Student> enrolledStudents = qucourse.getEnrollStudent();
                            List<Integer> credits = qucourse.getCredits();
                            Integer[] in = new Integer[enrolledStudents.size()];
                            for (int i = 0; i < in.length; i++) {
                                in[i] = i;
                            }
                            Arrays.sort(in, (i1, i2) -> Integer.compare(credits.get(i2), credits.get(i1)));
                            for (int i = 0; i < qucourse.getMaxCapacity(); i++) {
                                int v = in[i];

                                    qucourse.getSuccessStudents().add(qucourse.getEnrollStudent().get(v));
                                    qucourse.getEnrollStudent().get(v).getSuccessCourses().add(qucourse);

                            }
                            int b=qucourse.getMaxCapacity();
                           if(qucourse.getCredits().get(in[b])==qucourse.getCredits().get(in[b-1])){
                         for(int i=b;i>0;i--){
                               if(qucourse.getCredits().get(in[i-1])==qucourse.getCredits().get(in[i]))
                           {if(qucourse.getCredits().get(in[i-1])!=-1){
                             qucourse.getSuccessStudents().remove(qucourse.getEnrollStudent().get(in[i-1]));
                              qucourse.getEnrollStudent().get(in[i-1]).getSuccessCourses().remove(qucourse);
                            }}else break;;
                         }
                            if(qucourse.getCredits().get(in[0])==qucourse.getCredits().get(in[1]))
                           {
                                qucourse.getSuccessStudents().remove(qucourse.getEnrollStudent().get(in[0]));
                            }
                        }
                    }}}}

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {

                    ArrayList<String>sbb=new ArrayList<>();
                    for (Course course : student.getEnrollCourses()) {
                            int studentIndex = course.getEnrollStudent().indexOf(student);
                            if (studentIndex != -1) {
                                int credits = course.getCredits().get(studentIndex);
                                sbb.add(course.getCourseID() + ": " + credits);
                            }
                        }
                    return sbb;

            }}

