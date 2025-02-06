import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        ifOpen=true;
        courses=new ArrayList<>();
        students=new ArrayList<>();
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
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student,String courseId, int credit){
        if(ifOpen==false){
            return false;
        }else{
            for (int i = 0; i < courses.size(); i++) {
                Course course=courses.get(i);
                if(course.getCourseID().equals(courseId)&&!course.getEnrollStudent().contains(student)&&credit>0&&credit<=student.getCredits()){
                    ArrayList<Student> liststudent=new ArrayList<>();
                    liststudent=course.getEnrollStudent();
                    liststudent.add(student);
                    course.setEnrollStudent(liststudent);
                    ArrayList<Integer> listcredits=new ArrayList<>();
                    listcredits=course.getCredits();
                    listcredits.add(credit);
                    course.setCredits(listcredits);
                    ArrayList<Course> listcourse=new ArrayList<>();
                    listcourse=student.getEnrollCourses();
                    listcourse.add(course);
                    student.setEnrollCourses(listcourse);
                    int a=student.getCredits()-credit;
                    student.setCredits(a);
                    return true;
                }
            }
            return false;
        }
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        for (int i = 0; i < courses.size(); i++) {
            Course course=courses.get(i);
            if(ifOpen==true&&course.getCourseID().equals(courseId)&&course.getEnrollStudent().contains(student)){
                ArrayList<Integer> listcredit=new ArrayList<>();
                listcredit=course.getCredits();
                ArrayList<Student> liststudent=new ArrayList<>();
                liststudent=course.getEnrollStudent();
                int a=liststudent.indexOf(student);
                if(listcredit.get(a)+student.getCredits()>=credits){
                    student.setCredits(student.getCredits()-credits+listcredit.get(a));
                    listcredit.set(a,credits);
                    course.setCredits(listcredit);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        for (int i = 0; i < courses.size(); i++) {
            Course course=courses.get(i);
            if(ifOpen==true&&course.getCourseID().equals(courseId)&&course.getEnrollStudent().contains(student)){
                ArrayList<Student> liststudent=new ArrayList<>();
                ArrayList<Integer> listcredit=new ArrayList<>();
                liststudent=course.getEnrollStudent();
                listcredit=course.getCredits();
                int a=liststudent.indexOf(student);
                student.setCredits(student.getCredits()+listcredit.get(a));
                listcredit.remove(a);
                liststudent.remove(student);
                course.setEnrollStudent(liststudent);
                ArrayList<Course> listcourse=new ArrayList<>();
                listcourse=student.getEnrollCourses();
                listcourse.remove(course);
                student.setEnrollCourses(listcourse);
                return true;
            }
        }
        return false;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        for (int i = 0; i < courses.size(); i++) {
            Course course=courses.get(i);
            ArrayList<Integer> listcredits=new ArrayList<>();
            listcredits=course.getCredits();
            ArrayList<Student> liststudent=new ArrayList<>();
            liststudent=course.getEnrollStudent();
            for (int j = listcredits.size(); j >=1 ; j--) {
                for (int k = 0; k < j-1; k++) {
                    if(listcredits.get(k+1)>listcredits.get(k)){
                        int a=listcredits.get(k+1);
                        listcredits.set(k+1,listcredits.get(k));
                        listcredits.set(k,a);
                        Student student=liststudent.get(k+1);
                        liststudent.set(k+1,liststudent.get(k));
                        liststudent.set(k,student);
                    }
                }
            }
            ArrayList<Integer> listcredits1=new ArrayList<>();
            ArrayList<Student> list=new ArrayList<>();
            if (listcredits.size()>=course.getMaxCapacity()+1&&listcredits.get(course.getMaxCapacity()-1)>listcredits.get(course.getMaxCapacity())){
                for (int j = 0; j < course.getMaxCapacity(); j++) {
                    listcredits1.add(listcredits.get(j));
                    list.add(liststudent.get(j));
                }
            }else if(listcredits.size()<course.getMaxCapacity()+1) {
                for (int j = 0; j < listcredits.size(); j++) {
                    listcredits1.add(listcredits.get(j));
                    list.add(liststudent.get(j));
                }
            }else{
                for (int j = 0; listcredits.get(j)>listcredits.get(course.getMaxCapacity()-1); j++) {
                    listcredits1.add(listcredits.get(j));
                    list.add(liststudent.get(j));
                }
            }
            course.setSuccessStudents(list);
            for (int j = 0; j < students.size(); j++) {
                if (list.contains(students.get(j))){
                    ArrayList<Course> lists=new ArrayList<>();
                    lists=students.get(j).getSuccessCourses();
                    lists.add(course);
                    students.get(j).setSuccessCourses(lists);
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(ifOpen==true){
            ArrayList<String> list=new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                ArrayList<Course> enrollcourse=new ArrayList<>();
                enrollcourse=student.getEnrollCourses();
                Course course=student.getEnrollCourses().get(i);
                int a=0;
                for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                    if(course.getEnrollStudent().get(j)==student){
                        a=j;
                        break;
                    }
                }
                String abc=course.getCredits().get(a).toString();
                String string=enrollcourse.get(i).getCourseID()+": "+abc;
                list.add(string);
            }
            return list;
        }
        return null;
    }
}
