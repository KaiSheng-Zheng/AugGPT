import java.util.ArrayList;

public class CourseManager {
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
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student , String courseId , int credits){
        if(!ifOpen){
            return false;
        }
        boolean notInList = true;
        int courseNum = 0, studentNum = 0;
        for(int i = 0 ; i < courses.size() ; i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                courseNum = i;
                notInList = false;
            }
        }
        if(notInList){
            return false;
        }
        notInList = true;
        for(int i = 0 ; i < students.size() ; i++){
            if(students.get(i).equals(student)){
                studentNum = i;
                notInList = false;
            }
        }
        if(notInList){
            return false;
        }
        if(courses.get(courseNum).getEnrollStudent().contains(student)){
            return false;
        }
        if(credits <= 0){
            return false;
        }
        if(credits > student.getCredits()){
            return false;
        }
        ArrayList<Student> a = courses.get(courseNum).getEnrollStudent();
        a.add(student);
        courses.get(courseNum).setEnrollStudent(a);
        ArrayList<Integer> c =courses.get(courseNum).getCredits();
        c.add(credits);
        courses.get(courseNum).setCredits(c);
        student.setCredits(student.getCredits() - credits);
        ArrayList<Course> b = students.get(studentNum).getEnrollCourses();
        b.add(courses.get(courseNum));
        students.get(studentNum).setEnrollCourses(b);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student , String courseId , int credits){
        if(!ifOpen){
            return false;
        }
        boolean notInList = true;
        int courseNum = 0, studentInCourse = 0;
        for(int i = 0 ; i < student.getEnrollCourses().size() ; i++){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                notInList = false;
            }
        }
        if(notInList){
            return false;
        }
        for(int i = 0 ; i < courses.size() ; i++){
            if(courses.get(i).getCourseID().equals(courseId)){
                courseNum = i;
            }
        }
        for(int i = 0 ; i < courses.get(courseNum).getEnrollStudent().size() ; i++){
            if(courses.get(courseNum).getEnrollStudent().get(i).equals(student)){
                studentInCourse = i;
            }
        }
        if(!courses.get(courseNum).getEnrollStudent().contains(student)){
            return false;
        }
        if(credits <= 0){
            return false;
        }
        if(credits > student.getCredits() + courses.get(courseNum).getCredits().get(studentInCourse)){
            return false;
        }
        ArrayList<Integer> a = courses.get(courseNum).getCredits();
        student.setCredits(student.getCredits() + courses.get(courseNum).getCredits().get(studentInCourse) - credits);
        a.set(studentInCourse , credits);
        courses.get(courseNum).setCredits(a);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student , String courseId){
        if(!ifOpen){
            return false;
        }
        boolean notInList = true;
        int courseNum = 0, studentNum = 0 , studentInCourse = 0;
        for(int i = 0 ; i < student.getEnrollCourses().size() ; i++){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                courseNum = i;
                notInList = false;
            }
        }
        if(notInList){
            return false;
        }
        for(int i = 0 ; i < students.size() ; i++){
            if(students.get(i).equals(student)){
                studentNum = i;
            }
        }
        for(int i = 0 ; i < student.getEnrollCourses().get(courseNum).getEnrollStudent().size() ; i++){
            if(student.getEnrollCourses().get(courseNum).getEnrollStudent().get(i).equals(student)){
                studentInCourse = i;
            }
        }
        student.setCredits(student.getCredits() + student.getEnrollCourses().get(courseNum).getCredits().get(studentInCourse));
        ArrayList<Integer> a = student.getEnrollCourses().get(courseNum).getCredits();
        a.remove(studentInCourse);
        student.getEnrollCourses().get(courseNum).setCredits(a);
        ArrayList<Student> b = student.getEnrollCourses().get(courseNum).getEnrollStudent();
        b.remove(studentInCourse);
        student.getEnrollCourses().get(courseNum).setEnrollStudent(b);
        ArrayList<Course> c = students.get(studentNum).getEnrollCourses();
        c.remove(student.getEnrollCourses().get(courseNum));
        students.get(studentNum).setEnrollCourses(c);
        return true;
    }
    public void finalizeEnrollments(){
        for(int i = 0 ; i < courses.size() ; i++){
            ArrayList <Integer> a = new ArrayList<>();
            if(courses.get(i).getMaxCapacity() == 0){
                continue;
            }
            if(courses.get(i).getEnrollStudent().isEmpty()){
                continue;
            }
            for(int j = 0 ; j < courses.get(i).getEnrollStudent().size() ; j++){
                int location = 0;
                for(int k = 0 ; k < a.size() ; k++){
                    if (courses.get(i).getCredits().get(j) < a.get(k)){
                        location = k + 1;
                    }
                }
                a.add(location , courses.get(i).getCredits().get(j));
            }
            int maxNum = courses.get(i).getMaxCapacity() - 1;
            if (a.size() - 1 < maxNum){
                maxNum = a.size() - 1;
            }else{
                while(maxNum > 0 && maxNum + 1 < a.size() && a.get(maxNum).equals(a.get(maxNum + 1))){
                    maxNum--;
                }
            }
            if(a.isEmpty()){
                continue;
            }
            if(maxNum == 0){
                if (a.size() != 1){
                    if(a.get(maxNum).equals(a.get(maxNum + 1))){
                        continue;
                    }
                }
            }
            int determineNum = a.get(maxNum);
            ArrayList<Student> b = new ArrayList<>();
            for(int j = 0 ; j < courses.get(i).getEnrollStudent().size() ; j++){
                if(courses.get(i).getCredits().get(j).compareTo(determineNum) >= 0){
                    b.add(courses.get(i).getEnrollStudent().get(j));
                    ArrayList<Course> c = courses.get(i).getEnrollStudent().get(j).getSuccessCourses();
                    c.add(courses.get(i));
                    courses.get(i).getEnrollStudent().get(j).setSuccessCourses(c);
                }
            }
            courses.get(i).setSuccessStudents(b);
        }
        ifOpen = false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> listt = new ArrayList<>();
        if(!ifOpen){
            return null;
        }
        int numInCourse = 0;
        for (Course i : student.getEnrollCourses()){
            for (int j = 0 ; j < i.getEnrollStudent().size() ; j++){
                if(i.getEnrollStudent().get(j).equals(student)){
                    numInCourse = j;
                }
            }
            listt.add(i.getCourseID() + ": " + i.getCredits().get(numInCourse));
        }
        return listt;
    }
}
