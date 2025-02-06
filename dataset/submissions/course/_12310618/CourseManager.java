import java.util.ArrayList;

class CourseManager{
    private boolean ifOpen=false;
    private ArrayList<Course> courses= new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    public CourseManager(){
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);

    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        int coursenum= courseNum(courseId);
        int studentnum=courseinstudentNum(student,courseId);
        if(coursenum!=-1&&studentnum==-1&&credits<=student.getCredits()&&ifOpen&&credits>0){
            student.setCredits(student.getCredits()-credits);
            courses.get(coursenum).getEnrollStudent().add(student);
            courses.get(coursenum).getCredits().add(credits);
            student.getEnrollCourses().add(courses.get(coursenum));
            return true;
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        int coursenum= courseNum(courseId);
        int studentnum=courseinstudentNum(student,courseId);
        if(coursenum!=-1&&studentnum!=-1&&credits<=courses.get(coursenum).getCredits().get(studentincourseNum(student,courseId))+student.getCredits()&&ifOpen){
            student.setCredits(courses.get(coursenum).getCredits().get(studentincourseNum(student,courseId))+student.getCredits()-credits);
            courses.get(coursenum).getCredits().set(studentincourseNum(student,courseId),credits);
            return true;
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(courseNum(courseId)!=-1&&courseinstudentNum(student,courseId)!=-1&&ifOpen){
            student.setCredits(student.getCredits()+
                    courses.get(courseNum(courseId)).getCredits().get(studentincourseNum(student,courseId)));

            courses.get(courseNum(courseId)).getCredits().remove(studentincourseNum(student,courseId));
            courses.get(courseNum(courseId)).getEnrollStudent().remove(studentincourseNum(student,courseId));
            student.getEnrollCourses().remove(courseinstudentNum(student,courseId));
            return true;
        }
        return false;
    }
    public void finalizeEnrollments(){
        for (int i = 0; i <courses.size() ; i++) {
           for (int u=0;u<courses.get(i).getCredits().size();u++) {
               for (int j = 0; j < courses.get(i).getCredits().size() - 1; j++) {
                   if (courses.get(i).getCredits().get(j) <= courses.get(i).getCredits().get(j + 1)) {
                       courses.get(i).getCredits().add(j + 2, courses.get(i).getCredits().get(j));
                       courses.get(i).getCredits().remove(j);
                       courses.get(i).getEnrollStudent().add(j + 2, courses.get(i).getEnrollStudent().get(j));
                       courses.get(i).getEnrollStudent().remove(j);
                   }
               }
           }
        }
        for (int i = 0; i <courses.size() ; i++) {
            int successnum=0;
            for (int j = 0; j <courses.get(i).getCredits().size() ; j++) {
                int samecreditsnum=0;
                for (int k = successnum; k <courses.get(i).getCredits().size() ; k++){
                    int max=courses.get(i).getCredits().get(successnum);
                    if(max!=courses.get(i).getCredits().get(k)){
                        break;
                    }
                    samecreditsnum++;
                }
                if(samecreditsnum+successnum>courses.get(i).getMaxCapacity()){
                    break;
                }
                successnum=successnum+samecreditsnum;
            }
            for (int j = 0; j <successnum ; j++) {
                courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
            }
        }
        ifOpen=false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){
            return null;
        }
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i <student.getEnrollCourses().size() ; i++) {
            list.add(student.getEnrollCourses().get(i).getCourseID()+": "+
                    courses.get(courseNum(student.getEnrollCourses().get(i).getCourseID())).getCredits().get(studentincourseNum(student,student.getEnrollCourses().get(i).getCourseID())));
        }
        return list;
    }
    public int courseNum(String courseId){
        for (int i = 0; i <courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                return i;
            }
        }
        return -1;
    }
    public int courseinstudentNum(Student student, String courseId){
        for (int i = 0; i <student.getEnrollCourses().size() ; i++) {
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                return i;
            }
        }
        return -1;
    }
    public int studentincourseNum(Student student, String courseId){
        if(courseNum(courseId)==-1){
            return -1;
        }
        for (int i = 0; i <courses.get(courseNum(courseId)).getEnrollStudent().size(); i++) {
            if(courses.get(courseNum(courseId)).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())){
                return i;
            }
        }
        return -1;
    }
}