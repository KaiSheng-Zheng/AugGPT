import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Student>students;
    private ArrayList<Course>courses;
    private boolean ifOpen;
    public CourseManager(){
        students = new ArrayList<>();
        courses = new ArrayList<>();
       ifOpen = true;
    }


    public ArrayList<Student> getStudents(){
        return students;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public void addCourse(Course course){
        course.setCourseManager(this);
        this.courses.add(course);

    }
    public void addStudent(Student student){
        student.setCourseManager(this);
        this.students.add(student);
    }
    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        boolean a = false;
        int b=0;
        for (int i = 0; i < this.courses.size(); i++) {
            if(this.courses.get(i).getCourseID().equals(courseId)){
                 a=true;
                 b=i;
                 break;
            }
        }
        boolean d = false;
        Course c = this.courses.get(b);
        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
            if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                d = true;
                break;
            }
        }
        if(!a ||credits<=0||credits>student.getCredits()|| !this.ifOpen||d){
           return false;
       }else {
            int e = student.getCredits();
            student.setCredits(e-credits);
           ArrayList<Student>nES=c.getEnrollStudent();
           ArrayList<Integer>nC=c.getCredits();
           ArrayList<Course>nEC=student.getEnrollCourses();
           nES.add(student);
           nC.add(credits);
           nEC.add(c);
           c.setEnrollStudent(nES);
           c.setCredits(nC);
           student.setEnrollCourses(nEC);
           this.courses.set(b,c);
           return true;
        }
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        boolean a = false;
        int b=0;
        for (int i = 0; i < this.courses.size(); i++) {
            if(this.courses.get(i).getCourseID().equals(courseId)){
                a=true;
                b=i;
                break;
            }
        }
        boolean d = false;
        Course c = this.courses.get(b);
        int e = 0;
        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
            if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                d = true;
                e=i;
                break;
            }
        }


        if(!a||!d||!this.ifOpen||credits<=0||credits>student.getCredits()+c.getCredits().get(e)){
            return false;
        }else{
            int f = student.getCredits();
            student.setCredits(f-credits+c.getCredits().get(e));
            ArrayList<Integer>nC=c.getCredits();
            nC.set(e,credits);
            c.setCredits(nC);
            this.courses.set(b,c);
            return true;
        }
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        boolean a = false;
        int b=0;
        for (int i = 0; i < this.courses.size(); i++) {
            if(this.courses.get(i).getCourseID().equals(courseId)){
                a=true;
                b=i;
                break;
            }
        }
        boolean d = false;
        Course c = this.courses.get(b);
        int e = 0;
        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
            if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                d = true;
                e=i;
                break;
            }
        }
        if(!a ||!this.ifOpen||!d){
            return false;
        }else{
            int f = student.getCredits();
            student.setCredits(f+c.getCredits().get(e));
            ArrayList<Student>nES=c.getEnrollStudent();
            ArrayList<Integer>nC=c.getCredits();
            ArrayList<Course>nEC=student.getEnrollCourses();
            nES.remove(e);
            nC.remove(e);
            int g = 0;
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                    g=i;
                    break;
                }
            }
            nEC.remove(g);
            c.setEnrollStudent(nES);
            c.setCredits(nC);
            student.setEnrollCourses(nEC);
            this.courses.set(b,c);
            return true;
        }
    }
    public void finalizeEnrollments() {
        setIfOpen(false);
        for (int i = 0; i < this.courses.size(); i++) {
            Course c = this.courses.get(i);
            ArrayList<Student> nES = c.getEnrollStudent();
            ArrayList<Integer> nC = c.getCredits();
            ArrayList<Integer> nnC = new ArrayList<>();
            ArrayList<Student> nnES = new ArrayList<>();
            for (int j = 0; j < (nC.size() - 1); j++) {
                for (int k = 0; k < (nC.size() - 1 - j); k++) {
                    if (nC.get(k + 1) > nC.get(k)) {
                        Integer t = nC.get(k);
                        Student s = nES.get(k);
                        nC.set(k, nC.get(k + 1));
                        nC.set(k + 1, t);
                        nES.set(k, nES.get(k + 1));
                        nES.set(k + 1, s);
                    }
                }
            }
            if (nC.size() <= c.getMaxCapacity()) {
                nnES = nES;
                nnC = nC;
            } else {
                for (int j = 0; j < c.getMaxCapacity(); j++) {
                    nnES.add(nES.get(j));
                    nnC.add(nC.get(j));
                }
                if (nC.get(c.getMaxCapacity()-1).equals(nC.get(c.getMaxCapacity()))) {

                    int j = (c.getMaxCapacity()-1 );
                    while (nnC.get(j).equals(nC.get(c.getMaxCapacity()-1))) {
                        nnES.remove(j);
                        nnC.remove(j);
                        j -= 1;
                        if(j<0){
                            break;
                        }
                    }
                }
            }
            c.setSuccessStudents(nnES);
            c.setCredits(nnC);
            this.courses.set(i,c);
            for (int j = 0; j < this.students.size(); j++) {
                Student h = this.students.get(j);
                ArrayList<Course>nec = new ArrayList<>();
                for (int k = 0; k < nnES.size(); k++) {
                    if (this.students.get(j).getStudentID().equals(nnES.get(k).getStudentID())){
                    nec.add(c);
                    }
                }
                h.setSuccessCourses(nec);
                this.students.set(j,h);
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (this.ifOpen) {
            ArrayList<String> ge = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                Course c = student.getEnrollCourses().get(i);
                for (int j = 0; j < c.getEnrollStudent().size(); j++) {
                    if (c.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                        Integer m = c.getCredits().get(j);
                        String st = c.getCourseID() +
                                ": " +
                                m;
                        ge.add(st);
                        break;
                    }
                }
            }
            return ge;
        }
        else {
            return null;
        }
    }
}
