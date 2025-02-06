import java.util.ArrayList;
public class CourseManager{
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
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
    public void addStudent(Student student)
    {
        students.add(student);
        student.setCourseManager(this);

    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits)
    {
        boolean whetherCourseExist = false;
        boolean whetherStudentenroll = false;
        int coursenumber = 0 ;
        if(courses==null){
            return false;
        }
        for(int a = 0 ;a < courses.size();a++)
        {
            if(courses.get(a).getCourseID().equals(courseId)){
                whetherCourseExist=true;
                coursenumber=a;
            }
        }
        for(int a = 0 ; a < courses.get(coursenumber).getEnrollStudent().size();a++) {
            if(courses.get(coursenumber).getEnrollStudent().get(a)==student){
                whetherStudentenroll=true;
            }
        }
            if(credits>0 & student.getCredits()>=credits & whetherCourseExist==true & whetherStudentenroll==false & ifOpen==true){
                courses.get(coursenumber).getEnrollStudent().add(student);
                courses.get(coursenumber).getCredits().add(credits);

                student.getEnrollCourses().add(courses.get(coursenumber));
                int replaceCredit= student.getCredits()-credits;
                student.setCredits(replaceCredit);
                return true;
            }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits)
    {
        boolean whetherCourseExist = false;
        boolean whetherStudentenroll = false;
        int coursenumber = 0 ;
        int studentNumber = 0 ;
        if(courses==null){
            return false;
        }
        for(int a = 0 ;a < courses.size();a++)
        {
            if(courses.get(a).getCourseID().equals(courseId)){
                whetherCourseExist=true;
                coursenumber=a;
            }
        }
        for(int a = 0 ; a < courses.get(coursenumber).getEnrollStudent().size();a++) {
            if(courses.get(coursenumber).getEnrollStudent().get(a)==student){
                whetherStudentenroll=true;
                studentNumber=a;
            }
        }
        if(whetherCourseExist==true && whetherStudentenroll==true && ifOpen == true && courses.get(coursenumber).getCredits().get(studentNumber)+student.getCredits()-credits>=0)
        {
            int newCredit = courses.get(coursenumber).getCredits().get(studentNumber) - credits + student.getCredits();
            student.setCredits(newCredit);
            courses.get(coursenumber).getCredits().set(studentNumber,credits);
            return true;
        }
        return  false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        boolean whetherCourseExist = false;
        boolean whetherStudentenroll = false;
        int coursenumber = 0 ;
        int studentNumber = 0 ;
        for(int a = 0 ;a < courses.size();a++)
        {
            if(courses.get(a).getCourseID().equals(courseId)){
                whetherCourseExist=true;
                coursenumber=a;
            }
        }
        for(int a = 0 ; a < courses.get(coursenumber).getEnrollStudent().size();a++) {
            if(courses.get(coursenumber).getEnrollStudent().get(a)==student){
                whetherStudentenroll=true;
                studentNumber=a;
            }
        }
        if(whetherCourseExist==true & whetherStudentenroll == true &ifOpen == true){
            int newCredit = courses.get(coursenumber).getCredits().get(studentNumber)+ student.getCredits();
            student.setCredits(newCredit);

            courses.get(coursenumber).getEnrollStudent().remove(studentNumber);
            courses.get(coursenumber).getCredits().remove(studentNumber);

            for(int a = 0 ; a < student.getEnrollCourses().size();a++){
                if(student.getEnrollCourses().get(a).getCourseID().equals(courseId)){
                    student.getEnrollCourses().remove(a);
                }
            }
            return true;
        }
        return false;
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        for(int courseNumber = 0 ; courseNumber < courses.size();courseNumber++){
            int credit = 1;
            ArrayList<Student> removedStudent = new ArrayList<>();
            while(courses.get(courseNumber).getEnrollStudent().size()-removedStudent.size()>courses.get(courseNumber).getMaxCapacity()){
                for(int studentNumber =0 ; studentNumber<courses.get(courseNumber).getEnrollStudent().size();studentNumber++){
                    if(courses.get(courseNumber).getCredits().get(studentNumber)==credit){
                        removedStudent.add(courses.get(courseNumber).getEnrollStudent().get(studentNumber));
                    }
                }
                credit++;
            }
            for(int studentNumber = 0 ; studentNumber<courses.get(courseNumber).getEnrollStudent().size();studentNumber++){
                boolean whetherstudentremoved = false;
                for(int removedStudents = 0 ;removedStudents<removedStudent.size();removedStudents++){
                    if(removedStudent.get(removedStudents)==courses.get(courseNumber).getEnrollStudent().get(studentNumber)){
                        whetherstudentremoved = true;
                    }
                }
                if(whetherstudentremoved == false){
                    courses.get(courseNumber).getSuccessStudents().add(courses.get(courseNumber).getEnrollStudent().get(studentNumber));
                }
            }
            for(int successStudent = 0 ;successStudent<courses.get(courseNumber).getSuccessStudents().size();successStudent++){
                courses.get(courseNumber).getSuccessStudents().get(successStudent).getSuccessCourses().add(courses.get(courseNumber));
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> enrolledCourseWithCredits = new ArrayList<>();
        if(ifOpen==true){
            for(int coureseNumber = 0 ; coureseNumber < student.getEnrollCourses().size();coureseNumber++ ){
                for(int studentNumber = 0 ; studentNumber<student.getEnrollCourses().get(coureseNumber).getEnrollStudent().size();studentNumber++){
                    if (student.getEnrollCourses().get(coureseNumber).getEnrollStudent().get(studentNumber)==student){
                        enrolledCourseWithCredits.add(coureseNumber,student.getEnrollCourses().get(coureseNumber).getCourseID() +": "+ student.getEnrollCourses().get(coureseNumber).getCredits().get(studentNumber));
                    }
                }
            }
            return enrolledCourseWithCredits;
        }
        return null;
    }
}