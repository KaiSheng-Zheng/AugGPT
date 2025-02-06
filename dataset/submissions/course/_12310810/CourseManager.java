import java.util.ArrayList;


public class CourseManager {
    private ArrayList<Course> courses=new ArrayList<>();
    private ArrayList<Student> students=new ArrayList<>();
    private boolean ifOpen;
    public Student s=new Student(" "," "," ",0);
    public Course c=new Course("","",0);
    public CourseManager() {
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
        course.setCourseManager(this);
        this.courses.add(course);

    }
    public void addStudent(Student student){
        student.setCourseManager(this);
        students.add(student);

    }
    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        int CourseNum=checkCourse(courseId);
        if(!getIfOpen()){
            return false;
        }else if(CourseNum>=0&&checkStudent(student.getStudentID())){
            if(credits>0&&credits<=student.getCredits()){
                courses.get(CourseNum).getCredits().add(credits);
                courses.get(CourseNum).getEnrollStudent().add(student);
                student.getEnrollCourses().add(courses.get(CourseNum));
                student.setCredits(student.getCredits()-credits);
                return true;
            }
        }return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student,String courseId,int credit){
        if(credit<0){
            return false;
        }
        int CourseNum=checkCourse(courseId);
        int StudentNum=checkEnrollStudent(student,CourseNum);
        if(!getIfOpen()||StudentNum==-1){
            return false;
        }else if(CourseNum>=0&&checkStudent(student.getStudentID())){
            if((courses.get(CourseNum).getCredits().get(StudentNum)+student.getCredits()-credit)>=0){
                student.getCoursesWithScores().add(courseId);
                student.setCredits(student.getCredits()+courses.get(CourseNum).getCredits().get(StudentNum)-credit);
                courses.get(CourseNum).getCredits().set(StudentNum,credit);
                return true;
            }
        }return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student,String courseId){
        int studentCourseNum=checkStudentCourse(student,courseId);
        int CourseNum=checkCourse(courseId);int StudentNum=checkEnrollStudent(student,CourseNum);
        if(!getIfOpen()||StudentNum==-1){
            return false;
        }else if(CourseNum>=0&&StudentNum>=0){
            student.setCredits(student.getCredits()+courses.get(CourseNum).getCredits().get(StudentNum));
            courses.get(CourseNum).getCredits().set(StudentNum,0);
            courses.get(CourseNum).getEnrollStudent().set(StudentNum,s);
            student.getEnrollCourses().set(studentCourseNum,c);
            return true;
        }
        return false;
    }
    public void finalizeEnrollments(){
        setIfOpen(false);

        for (int i = 0; i < courses.size(); i++) {
            for (int k=0;k<courses.get(i).getEnrollStudent().size();k++) {
                for (int i1 = 0; i1 < courses.get(i).getEnrollStudent().size()-1; i1++) {
                    if(courses.get(i).getCredits().get(i1)<courses.get(i).getCredits().get(i1+1)){
                        int tempCredit =courses.get(i).getCredits().get(i1);
                        Student tempStudent =courses.get(i).getEnrollStudent().get(i1);
                        courses.get(i).getCredits().set(i1,courses.get(i).getCredits().get(i1+1));
                        courses.get(i).getCredits().set(i1+1,tempCredit);
                        courses.get(i).getEnrollStudent().set(i1,courses.get(i).getEnrollStudent().get(i1+1));
                        courses.get(i).getEnrollStudent().set(i1+1,tempStudent);
                    }
                }
            }
        }

        for (int i = 0; i < courses.size(); i++) {
            int x=courses.get(i).getMaxCapacity();
            if(courses.get(i).getEnrollStudent().size()>x){
                if(courses.get(i).getCredits().get(x)==courses.get(i).getCredits().get(x-1)){
                    for (int i1 = 0; i1 < x; i1++) {
                        if(courses.get(i).getCredits().get(i1)>courses.get(i).getCredits().get(x-1)){
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(i1));
                            courses.get(i).getEnrollStudent().get(i1).getSuccessCourses().add(courses.get(i));
                        }
                    }
                }else{
                    for (int i1 = 0; i1 < x; i1++) {
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(i1));
                        courses.get(i).getEnrollStudent().get(i1).getSuccessCourses().add(courses.get(i));
                    }
                }
            }else{
                for (int i1 = 0; i1 < courses.get(i).getEnrollStudent().size(); i1++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(i1));
                    courses.get(i).getEnrollStudent().get(i1).getSuccessCourses().add(courses.get(i));
                }
            }
        }
    }
    public ArrayList<String>getEnrolledCoursesWithCredits(Student student){
        if(getIfOpen()){
            ArrayList<String> arrayList=new ArrayList<>();
            int x=student.getEnrollCourses().size();
            for (int i = 0; i < x; i++) {
                if(student.getEnrollCourses().get(i).equals(c)){
                    continue;
                }
                String courseName=student.getEnrollCourses().get(i).getCourseID();
                int credit=student.getEnrollCourses().get(i).getCredits().get(findStudent(student,student.getEnrollCourses().get(i)));
                String result=courseName+": "+credit;
                arrayList.add(result);
            }
            return arrayList;
        }else {
            return null;
        }
    }
    public int checkCourse(String courseId){
        for (int i = 0; i < courses.size(); i++) {
            if(courseId.equals(courses.get(i).getCourseID())){
                return i;
            }
        }return -1;
    }
    public boolean checkStudent(String studentId){
        for (int i = 0; i < getStudents().size(); i++) {
            if(studentId.equals(getStudents().get(i).getStudentID())){
                return true;
            }
        }
        return false;
    }
    public int checkEnrollStudent(Student student,int x){
        for (int i = 0; i < courses.get(x).getCredits().size(); i++) {
            if(student.equals(courses.get(x).getEnrollStudent().get(i))){
                return i;
            }
        }
        return -1;
    }
    public int checkStudentCourse(Student student,String courseId){
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if(courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                return i;
            }
        }
        return -1;
    }
    public int findStudent(Student student,Course course){
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if(course.getEnrollStudent().get(i).equals(student)){
                return i;
            }
        }
        return -1;
    }
}
