import java.util.ArrayList;
public class CourseManager {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        this.courses=new ArrayList<>();
        this.students=new ArrayList<>();
        this.ifOpen=true;
    }

    public ArrayList<Student>getStudents(){
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
        this.courses.add(course);
        course.setCourseManager(this);
        course.setEnrollStudent(new ArrayList<>());
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
        student.setEnrollCourses(new ArrayList<>());
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {

        int a=-1;
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                a=i;
                break;
            }
        }
        if (credits > 0 && credits <= student.getCredits() && a>=0 && a<courses.size() && this.getIfOpen()==true){
            student.setCredits(student.getCredits()-credits);
            courses.get(a).getEnrollStudent().add(student);
            courses.get(a).getCredits().add(credits);
            student.getEnrollCourses().add(courses.get(a));


            return true;
        }else{
            return false;
        }

    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        int a=-1;
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                a=i;
                break;
            }
        }

        int b=-1;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getStudentID().equals(student.getStudentID())){
                b=0;
                break;
            }
        }
        if(a==-1){
            return false;
        }
        if(b==-1){
            return false;
        }

        int y=-1;
        int z=-1;
        if(this.getIfOpen()==true) {
            for (int x = 0; x < courses.get(a).getCredits().size(); x++) {
                if (courses.get(a).getEnrollStudent().get(x).getStudentID().equals(student.getStudentID())) {
                    y = courses.get(a).getCredits().get(x);
                    z = x;
                }
            }
        }else {
            return false;
        }

        if (credits > 0 && credits <= student.getCredits()+y && y!=-1) {

            courses.get(a).getCredits().set(z,credits);
            student.setCredits(courses.get(a).getEnrollStudent().get(z).getCredits()+y-credits);

            return true;
        }else{
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        int a=-1;
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                a=i;
                break;
            }
        }
        if (a == -1) {
            return false;
        }
        int b=-1;
        for(int i=0;i<courses.get(a).getEnrollStudent().size();i++) {
            if (courses.get(a).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                b = i;
                student.setCredits(student.getCredits()+courses.get(a).getCredits().get(b));
                Student element =courses.get(a).getEnrollStudent().remove(b);
                Integer str =courses.get(a).getCredits().remove(b);

            }

        }
        if (b == -1) {
            return false;
        }else{
            for(int i=0;i<student.getEnrollCourses().size();i++){
                if(student.getEnrollCourses().get(i).getCourseID().equals(courses.get(a).getCourseID())){
                    Course element =student.getEnrollCourses().remove(i);
                }
            }
        }
        if(a!=-1 && b!=-1 && this.getIfOpen()==true){
            return true;
        }else{
            return false;
        }
    }

    public void finalizeEnrollments(){
        for(int i=0;i<courses.size();i++){
            int c = courses.get(i).getMaxCapacity();
            ArrayList<Student> A = new ArrayList<>();
            for(int j=0;j<courses.get(i).getCredits().size();j++) {
                int d = 0;
                for (int k = 0; k < courses.get(i).getEnrollStudent().size(); k++) {
                    if (courses.get(i).getCredits().get(j) <= courses.get(i).getCredits().get(k)) {
                        d++;
                    }
                }
                if (d <= c) {
                    A.add(courses.get(i).getEnrollStudent().get(j));
                }
            }
            courses.get(i).getSuccessStudents().clear();
            courses.get(i).setSuccessStudents(A);
        }
        for(int l=0;l<students.size();l++){
            ArrayList<Course> C = new ArrayList<>();
            for(int t=0;t<courses.size();t++){
                if(courses.get(t).getSuccessStudents().contains(students.get(l))){
                    C.add(courses.get(t));
                }
            }
            students.get(l).getSuccessCourses().clear();
            students.get(l).setSuccessCourses(C);
        }
        this.setIfOpen(false);
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        int q=-1;
        for(int p=0;p<students.size();p++){
            if(students.get(p).getStudentID().equals(student.getStudentID())){
                q=0;
            }
        }
        for(int i=0;i<courses.size();i++){
            int c = courses.get(i).getMaxCapacity();
            ArrayList<Student> A = new ArrayList<>();
            for(int j=0;j<courses.get(i).getCredits().size();j++) {
                int d = 0;
                for (int k = 0; k < courses.get(i).getEnrollStudent().size(); k++) {
                    if (courses.get(i).getCredits().get(j) <= courses.get(i).getCredits().get(k)) {
                        d++;
                    }
                }
                if (d <= c) {
                    A.add(courses.get(i).getEnrollStudent().get(j));
                }
            }
            courses.get(i).getSuccessStudents().clear();
            courses.get(i).setSuccessStudents(A);
        }
        for(int l=0;l<students.size();l++){
            ArrayList<Course> C = new ArrayList<>();
            for(int t=0;t<courses.size();t++){
                if(courses.get(t).getSuccessStudents().contains(students.get(l))){
                    C.add(courses.get(t));
                }
            }
            students.get(l).getSuccessCourses().clear();
            students.get(l).setSuccessCourses(C);
        }
        if(q!=-1 && this.getIfOpen()==true){
            ArrayList<String> K = new ArrayList<>();
            for(int i=0;i<student.getEnrollCourses().size();i++){
                for(int j=0;j<student.getEnrollCourses().get(i).getEnrollStudent().size();j++){
                    if(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())){
                        int k = student.getEnrollCourses().get(i).getCredits().get(j);
                        K.add(student.getEnrollCourses().get(i).getCourseID() + ": " + k);
                    }
                }
            }
            return K;
        }else{
            return null;
        }
    }
}