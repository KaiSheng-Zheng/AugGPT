import java.util.ArrayList;
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        this.students=  new ArrayList<Student>();
        this.courses=new ArrayList<Course>();
        this.ifOpen=true;
    }
    public ArrayList<Course> getCourses() {return courses;}
    public void addCourse(Course course) {
        this.courses.add(course) ;
        course.setCourseManager(this);
    }
    public ArrayList<Student> getStudents() {return students;}
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
        student.setEnrollCourses(new ArrayList<>());
    }
    public boolean getIfOpen() {return ifOpen;}
    public void setIfOpen(boolean ifOpen) {this.ifOpen = ifOpen;}
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        boolean ifOpen=getIfOpen();
        if(ifOpen==true){
            if(credits>0) {
                if (student.getCredits() >= credits){
                    for (int j = 0; j < courses.size(); j++) {
                        String courseid = courses.get(j).getCourseID();
                        if (courseid.equals(courseId)) {
                            int x = 0;
                            ArrayList<Student> enrollstudent= new ArrayList<>();
                            enrollstudent=courses.get(j).getEnrollStudent();
                            for (int i = 0; i < enrollstudent.size(); i++) {
                                String sutdentid1 = enrollstudent.get(i).getStudentID();
                                String sutdentid2 = student.getStudentID();
                                if (sutdentid1.equals(sutdentid2)) {x++;}
                            }
                            if (x == 0) {
                                courses.get(j).getCredits().add(credits);
                                courses.get(j).getEnrollStudent().add(student);
                                student.getEnrollCourses().add(courses.get(j));
                                int zong=student.getCredits();
                                int sheng=zong-credits;
                                student.setCredits(sheng);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        boolean ifOpen=getIfOpen();
        if(ifOpen==true){
            for(int j=0;j<courses.size();j++){
                String coursesid=courses.get(j).getCourseID();
                if(coursesid.equals(courseId)){
                    ArrayList<Student>enrollstudent=courses.get(j).getEnrollStudent();
                    for(int i=0;i<enrollstudent.size();i++){
                        String sutdentid1=enrollstudent.get(i).getStudentID();
                        String sutdentid2=student.getStudentID();
                        if(sutdentid1.equals(sutdentid2)){
                        int s=student.getCredits();
                        ArrayList<Integer>coursecredits=courses.get(j).getCredits();
                        int c=coursecredits.get(i);
                        int zong=s+c;
                        if(zong>=credits){
                            coursecredits.set(i,credits);
                            courses.get(j).setCredits(coursecredits);
                            student.setCredits(zong-credits);
                            return true;
                        }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        boolean ifOpen=getIfOpen();
        if(ifOpen==true){
            for(int j=0;j<courses.size();j++){
                String coursesid=courses.get(j).getCourseID();
                if(coursesid.equals(courseId)){
                    ArrayList<Student> enrollstudent= new ArrayList<>();
                    enrollstudent=courses.get(j).getEnrollStudent();
                    for(int i=0;i<enrollstudent.size();i++){
                        String sutdentid1=enrollstudent.get(i).getStudentID();
                        String sutdentid2=student.getStudentID();
                        if(sutdentid1.equals(sutdentid2)){
                            int sheng=student.getCredits();
                            ArrayList<Integer>coursecredits=courses.get(j).getCredits();
                            int tou=coursecredits.get(i);
                            int zong=sheng+tou;
                            student.setCredits(zong);
                            ArrayList<Student>enrollstudent1=courses.get(j).getEnrollStudent();
                            enrollstudent1.remove(i);
                            courses.get(j).setEnrollStudent(enrollstudent1);
                            ArrayList<Integer>credits=courses.get(j).getCredits();
                            credits.remove(i);
                            courses.get(j).setCredits(credits);
                            ArrayList<Course>enrollcourse=student.getEnrollCourses();
                            for(int x=0;x<enrollcourse.size();x++){
                            String id=enrollcourse.get(x).getCourseID();
                            if(id.equals(courseId)){
                                enrollcourse.remove(x);
                                student.setEnrollCourses(enrollcourse);
                            }
                            }
                            return true;
                            }
                        }
                    }
                }
            }
        return false;
    }
    public void finalizeEnrollments(){
        setIfOpen(false);
        for(int j=0;j<courses.size();j++){
            int max=courses.get(j).getMaxCapacity();
            ArrayList<Integer>credits=courses.get(j).getCredits();
            ArrayList<Student>enrollstudent=courses.get(j).getEnrollStudent();
            for(int i=0;i<credits.size();i++){
                int a=0;
                for(int x=0;x<credits.size();x++){
                    if(credits.get(i)<=credits.get(x)){a++;}
                }
                if(a<=max){
                    courses.get(j).getSuccessStudents().add(enrollstudent.get(i));
                    enrollstudent.get(i).getSuccessCourses().add(courses.get(j));
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(ifOpen==true){
            ArrayList<String>info=new ArrayList<>();
            for(int j=0;j<courses.size();j++){
                ArrayList<Student>enrollstudent=courses.get(j).getEnrollStudent();
                ArrayList<Integer>credit=courses.get(j).getCredits();
                for(int i=0;i<enrollstudent.size();i++){
                    String studentid1=student.getStudentID();
                    String studentid2=enrollstudent.get(i).getStudentID();
                    if(studentid1.equals(studentid2)){
                        String courseid=courses.get(j).getCourseID();
                        int enrollmentcredits=credit.get(i);
                        info.add(courseid+": "+enrollmentcredits);
                    }
                }
            }
            return info;
        }
        return null;
    }
}
