import java.util.ArrayList;


public class CourseManager {
    private ArrayList<Course> courses ;
    private ArrayList<Student> students ;
    private boolean ifOpen ;
    public CourseManager(){
        ifOpen = true;
        courses = new ArrayList<Course>();
        students  = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setIfOpen(boolean key){
        this.ifOpen = key;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }

    public void addCourse(Course newCourse){
        newCourse.setCourseManager(this);
        courses.add(newCourse);
    }
    public void addStudent(Student newStudent){
        newStudent.setCourseManager(this);
        students.add(newStudent);
    }
    public boolean enrollStudentInCourse(Student studentIn, String courseID, int creditsIn){
        boolean key01 = false;
        
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseID)){
                key01 = true;
            }
        }
        
        //studentIn.getEnrollCourses();
        boolean key02 = true;
        for (int i = 0; i < studentIn.getEnrollCourses().size(); i++) {
            if(studentIn.getEnrollCourses().get(i).getCourseID().equals(courseID)){
                key02 = false;
            }
        }
        
        boolean key03 = true;
        if(creditsIn<=0){
            key03 = false;
        } else {
            if(creditsIn>studentIn.getCredits()){
                key03 = false;
            }
        }
        boolean keyReturn = key01 & key02 & key03 &ifOpen;
        if(keyReturn){
            studentIn.setCredits(studentIn.getCredits()-creditsIn);
            Course newCourseIn = courses.get(0);
            for (int i = 0; i < courses.size(); i++) {
                if(courses.get(i).getCourseID().equals(courseID)){
                    newCourseIn = courses.get(i);
                }
            }
            
            studentIn.getEnrollCourses().add(newCourseIn);
            
            newCourseIn.getEnrollStudent().add(studentIn);
            newCourseIn.getCredits().add(creditsIn);

        }
        return keyReturn;
    }
    public boolean modifyStudentEnrollmentCredits(Student studentIn, String courseID, int credits){
        boolean key01 = false;
        
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseID)){
                key01 = true;
            }
        }
        
        boolean key02 = false;
        for (int i = 0; i < studentIn.getEnrollCourses().size(); i++) {
            if(studentIn.getEnrollCourses().get(i).getCourseID().equals(courseID)){
                key02 = true;
            }
        }
        Course newCourseIn = courses.get(0);
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseID)){
                newCourseIn = courses.get(i);
            }
        }
        
        int additionalCredits = 0;
        for (int i = 0; i < newCourseIn.getEnrollStudent().size(); i++) {
            if(newCourseIn.getEnrollStudent().get(i).equals(studentIn)){
                additionalCredits = newCourseIn.getCredits().get(i);
            }
        }
        int totalCredits = studentIn.getCredits() + additionalCredits;
        boolean key03 = credits>0&&credits<=totalCredits;
        boolean keyReturn = key01&key02&key03&ifOpen;
        if(!keyReturn){
            return false;
        } else {
            
            for (int i = 0; i < newCourseIn.getEnrollStudent().size(); i++) {
                if(newCourseIn.getEnrollStudent().get(i).equals(studentIn)){
                    newCourseIn.getCredits().set(i,credits);
                }
            }
            
            studentIn.setCredits(totalCredits - credits);
            return true;
        }
    }
    public boolean dropStudentEnrollmentCourse(Student studentIn, String courseID){
        boolean key01 = false;
        
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseID)){
                key01 = true;
            }
        }
        
        boolean key02 = false;
        for (int i = 0; i < studentIn.getEnrollCourses().size(); i++) {
            if(studentIn.getEnrollCourses().get(i).getCourseID().equals(courseID)){
                key02 = true;
            }
        }
        Course newCourseIn = courses.get(0);
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseID)){
                newCourseIn = courses.get(i);
            }
        }
        boolean keyReturn = key01&key02&ifOpen;
        if(!keyReturn){
            return false;
        } else {
            for (int i = 0; i < newCourseIn.getEnrollStudent().size(); i++) {
                if(newCourseIn.getEnrollStudent().get(i).equals(studentIn)){
                    studentIn.setCredits(studentIn.getCredits()+newCourseIn.getCredits().get(i));
                    newCourseIn.getEnrollStudent().remove(studentIn);
                    newCourseIn.getCredits().remove(i);
                    break;
                }
            }
            studentIn.getEnrollCourses().remove(newCourseIn);
            return true;
        }
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            Course courseNow = courses.get(i);
            boolean key = false;
            do{
                key = false;
                for (int j = 0; j < courseNow.getCredits().size()-1; j++) {
                    if(courseNow.getCredits().get(j)<courseNow.getCredits().get(j+1)){
                        key = true;
                        int temp = courseNow.getCredits().get(j);
                        courseNow.getCredits().set(j,courseNow.getCredits().get(j+1));
                        courseNow.getCredits().set(j+1,temp);
                        Student tempStudent = courseNow.getEnrollStudent().get(j);
                        courseNow.getEnrollStudent().set(j,courseNow.getEnrollStudent().get(j+1));
                        courseNow.getEnrollStudent().set(j+1,tempStudent);
                    }
                }
            } while(key);
            if(courseNow.getEnrollStudent().size()>courseNow.getMaxCapacity()){
                int minimumCredit = courseNow.getCredits().get(courseNow.getMaxCapacity());
                for (int j = 0; j < courseNow.getCredits().size(); j++) {
                    if(courseNow.getCredits().get(j)>minimumCredit){
                        courseNow.getSuccessStudents().add(courseNow.getEnrollStudent().get(j));
                        courseNow.getSuccessStudents().get(j).getSuccessCourses().add(courseNow);
                    }
                }
            } else {
                courseNow.setSuccessStudents(courseNow.getEnrollStudent())  ;
                for (int j = 0; j < courseNow.getCredits().size(); j++) {
                    courseNow.getSuccessStudents().get(j).getSuccessCourses().add(courseNow);
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student studentIn){
        if(!ifOpen){
            return null;
        }
        ArrayList<String> GECWC= new ArrayList<String>();
        for (int i = 0; i < studentIn.getEnrollCourses().size(); i++) {
            int cerCredit = 0;
            for (int j = 0; j < studentIn.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                if(studentIn.getStudentID().equals(studentIn.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID())){
                    cerCredit = studentIn.getEnrollCourses().get(i).getCredits().get(j);
                }
            }
            String str = studentIn.getEnrollCourses().get(i).getCourseID()+": "+cerCredit;
            GECWC.add(str);
        }
        return GECWC;
    }
}

