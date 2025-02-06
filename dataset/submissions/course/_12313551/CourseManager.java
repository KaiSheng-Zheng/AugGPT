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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
       this.students.add(student);
       student.setCourseManager(this);
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        if (!this.ifOpen) {
            return false;
        }
        if (credits<=0){
            return false;
        }
        Course cou=null;
        for (Course a:courses){
            if (a.getCourseID().equals(courseId)){
                cou=a;
                break;
            }
        }
        if (cou==null){
            return false;
        }
        Course cou0=null;
        for (Course b:student.getEnrollCourses()){
            if (b.getCourseID().equals(courseId)){
                cou0=b;
                break;
            }
        }
        if (cou0!=null){
            return false;
        }
        if (student.getCredits()-credits<0){
            return false;
        }
        student.setCredits(student.getCredits()-credits);
        cou.getEnrollStudent().add(student);
        cou.getCredits().add(credits);
        student.getEnrollCourses().add(cou);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student,String courseId,int credits){
        if (!this.ifOpen) {
            return false;
        }
        if (credits<=0){
            return false;
        }
        Course cou1=null;
        for (Course c:courses){
            if (c.getCourseID().equals(courseId)){
                cou1=c;
                break;
            }
        }
        if (cou1==null){
            return false;
        }
        Course cou2=null;
        for (Course d:student.getEnrollCourses()){
            if (d.getCourseID().equals(courseId)){
                cou2=d;
                break;
            }
        }
        if (cou2==null){
            return false;
        }
        int n=-1;
        for (int i = 0; i < cou2.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(cou2.getEnrollStudent().get(i).getStudentID())){
                n=i;
                break;
            }
        }
        int beforeCredit=cou2.getCredits().get(n);
        if (credits>beforeCredit+student.getCredits()){
            return false;
        }
        student.setCredits(student.getCredits()-credits+beforeCredit);
        cou2.getCredits().set(n,credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student,String courseId){
        if (!this.ifOpen) {
            return false;
        }
        Course cou3=null;
        for (Course e:courses){
            if (e.getCourseID().equals(courseId)){
                cou3=e;
                break;
            }
        }
        if (cou3==null){
            return false;
        }
        Course cou4=null;
        for (Course f:student.getEnrollCourses()){
            if (f.getCourseID().equals(courseId)){
                cou4=f;
                break;
            }
        }
        if (cou4==null){
            return false;
        }
        int n=-1;
        for (int i = 0; i < cou4.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(cou4.getEnrollStudent().get(i).getStudentID())){
                n=i;
                break;
            }
        }
        student.setCredits(student.getCredits()+cou4.getCredits().get(n));
        cou4.getCredits().remove(n);
        cou4.getEnrollStudent().remove(n);
        student.getEnrollCourses().remove(cou4);
        return true;
    }

    public ArrayList<String>getEnrolledCoursesWithCredits(Student student){
        if (!this.ifOpen) {
            return null;
        }
        ArrayList<String>arrayList=new ArrayList<>();
        int index=-1;
        for (Course g:student.getEnrollCourses()) {
            String courseID=g.getCourseID();
                for (int i = 0; i < g.getEnrollStudent().size(); i++) {
                    if (g.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        index = i;
                        break;
                    }
                }
            String enrollmentCredits=String.valueOf(g.getCredits().get(index));
                arrayList.add(courseID+": "+enrollmentCredits);
        }
        return arrayList;
    }

    public void finalizeEnrollments(){
        this.ifOpen=false;
        for (Course h:courses) {
            if (h.getMaxCapacity() >= h.getEnrollStudent().size()) {
                for (int i = 0; i < h.getEnrollStudent().size(); i++) {
                    h.getSuccessStudents().add(h.getEnrollStudent().get(i));
                    h.getEnrollStudent().get(i).getSuccessCourses().add(h);
                }
            } else if (h.getMaxCapacity() < h.getEnrollStudent().size()) {
                int[] CourseBid = new int[h.getCredits().size()];
                for (int i = 0; i < h.getCredits().size(); i++) {
                    CourseBid[i] = h.getCredits().get(i);
                }
                int sum;
                for (int i = 0; i < CourseBid.length; i++) {
                    for (int j = i + 1; j < CourseBid.length; j++) {
                        if (CourseBid[i] < CourseBid[j]) {
                            sum = CourseBid[i];
                            CourseBid[i] = CourseBid[j];
                            CourseBid[j] = sum;
                        }
                    }
                }
                int d = CourseBid[h.getMaxCapacity() - 1];
                ArrayList<Integer> CreditIndex = new ArrayList<>();
                for (int i = 0; i < h.getCredits().size(); i++) {
                    if (CourseBid[h.getMaxCapacity()] < d) {
                        if (h.getCredits().get(i) >= d) {
                            CreditIndex.add(i);
                        }
                    } else if (CourseBid[h.getMaxCapacity()] == d) {
                        if (h.getCredits().get(i) > d) {
                            CreditIndex.add(i);
                        }
                    }
                }
                for (int i = 0; i < CreditIndex.size(); i++) {
                    h.getSuccessStudents().add(h.getEnrollStudent().get(CreditIndex.get(i)));
                    h.getEnrollStudent().get(CreditIndex.get(i)).getSuccessCourses().add(h);
                }

            }
        }
    }



    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
}
