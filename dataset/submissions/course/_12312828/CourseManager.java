import java.util.ArrayList;
import java.util.Collections;
class CourseManager {
    private  ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        courses=new ArrayList<>();
        students=new ArrayList<>();
        setIfOpen(true);
    }
    public ArrayList<Student>getStudents(){
        return students;
    }
    public ArrayList<Course>getCourses() {
        return courses;
    }
    public void setIfOpen(boolean ifOpen){
        this.ifOpen=ifOpen;
    }
    public  boolean getIfOpen(){
        return this.ifOpen;
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    private boolean verifystudent(Student student){
        for(Student student1:students){
            if (student1.equals(student)){
                return  true;
            }
        }return false;
    }
    public boolean enrollStudentInCourse(Student student, String courseId,int credits){

        if(!ifOpen){
            return false;
        }
        if(!verifystudent(student)){
            return false;
        }
        if (!veriID(courseId)){
            return false;
        }
        if(findStudent(student, findcourse(courseId).getEnrollStudent())){
            return false;
        }
        if(credits<=0||student.getCredits()<credits){
            return false;
        }
        student.setCredits(student.getCredits()-credits);
        ArrayList<Integer>c=findcourse(courseId).getCredits();
        c.add(credits);
        findcourse(courseId).setCredits(c);
        ArrayList<Course>cg=student.getEnrollCourses();
        cg.add(findcourse(courseId));
        student.setEnrollCourses(cg);
        ArrayList<Student>b= findcourse(courseId).getEnrollStudent();
        b.add(student);
        findcourse(courseId).setEnrollStudent(b);
        return true;
    }

    public  boolean modifyStudentEnrollmentCredits(Student student, String courseId,int credits){
        if (!veriID(courseId)){
            return false;
        }
        Course kecheng=findcourse(courseId);
        if(!verifystudent(student)){
            return false;
        }
        if(!ifOpen){
            return false;
        }
        if (kecheng==null){
            return false;
        }
        if (!findStudent(student, kecheng.getEnrollStudent())){
            return false;
        }
        int index=kecheng.getEnrollStudent().indexOf(student);
        int yuanlai=kecheng.getCredits().get(index);
        int houlai=yuanlai+student.getCredits()-credits;
        if (houlai<0||credits<=0){
            return false;
        }
        ArrayList<Integer>now=kecheng.getCredits();
        now.remove(index);
        now.add(index,credits);
        kecheng.setCredits(now);
        student.setCredits(houlai);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!verifystudent(student)){
            return false;
        }

        Course kecheng=findcourse(courseId);
        if(!ifOpen){
            return false;
        }
        if (kecheng==null){
            return false;
        }
        int index=findIndex(kecheng.getEnrollStudent(),student);
        if (index==-1){
            return false;
        }
        ArrayList<Student>gengxinxuesheng=kecheng.getEnrollStudent();
        ArrayList<Integer>gengxinqian=kecheng.getCredits();
        student.setCredits(student.getCredits()+gengxinqian.get(index));
        gengxinxuesheng.remove(index);
        kecheng.setEnrollStudent(gengxinxuesheng);
        gengxinqian.remove(index);
        kecheng.setCredits(gengxinqian);
        student.getEnrollCourses().remove(kecheng);
        System.out.println(student.getEnrollCourses());
        return true;
    }
    public void finalizeEnrollments(){
        setIfOpen(false);
        for (Course course:courses){
            final ArrayList<Integer>initialcredit=new ArrayList<>();
            for(int i=0;i<=course.getCredits().size()-1;i++){
                initialcredit.add(course.getCredits().get(i));
            }
            if(initialcredit.size()<=course.getMaxCapacity()){
                course.setSuccessStudents(course.getEnrollStudent());
            }else {
                int num=0;
                ArrayList<Integer>finalcredit=new ArrayList<>();
                for(int i=0;i<=course.getCredits().size()-1;i++){
                    finalcredit.add(course.getCredits().get(i));
                }
                int capacity=course.getMaxCapacity()-1;
                finalcredit.sort(Collections.reverseOrder());
                for(int i=capacity;i>=0;i--){
                    if((finalcredit.get(i).equals(finalcredit.get(capacity + 1)))){
                        num++;
                    }else {
                        break;
                    }
                }
                if(num!=capacity+1){
                    ArrayList<Student>successstudents=new ArrayList<>();
                    int minindex=capacity-num;
                    Integer min=finalcredit.get(minindex);
                    for (int i=0;i<=initialcredit.size()-1;i++){
                        if (initialcredit.get(i).compareTo(min)>=0){
                            successstudents.add(course.getEnrollStudent().get(i));
                        }
                    }
                    course.setSuccessStudents(successstudents);

                }

            }
            for(Student student:course.getSuccessStudents()){
                ArrayList<Course>cs=student.getSuccessCourses();
                cs.add(course);
                student.setSuccessCourses(cs);
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> stuCoursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = findIndex(course.getEnrollStudent(), student);
            if (index != -1) {
                int credit = course.getCredits().get(index);
                String s=String.format("%s: %d", course.getCourseID(), credit);
                stuCoursesWithCredits.add(s);
            }
        }
        return stuCoursesWithCredits;
    }

    public int findIndex(ArrayList<Student> enrollStudents, Student student) {
        for (int i = 0; i < enrollStudents.size(); i++) {
            if (enrollStudents.get(i).equals(student)) {
                return i;
            }
        }
        return -1;
    }
    public Course findcourse(String ID){
        for(Course id:courses){
            if (id.getCourseID().equals(ID)){
                return id;
            }
        }return null;
    }
    public boolean findStudent(Student student,ArrayList<Student> enrollStudent){
        for (Student s : enrollStudent) {
            if (student .equals(s)) {
                return true;
            }
        }
        return false;
    }
    public boolean veriID(String ID){
        for (Course course:this.courses){
            if (course.getCourseID().equals(ID)){
                return true;
            }
        }
        return false;
    }
}


