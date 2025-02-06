import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        this.ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        int index = -1;
        for (int i = 0; i < courses.size(); i++) {
            if ((courses.get(i).getCourseID().equals(courseId))) {
                index=i;
                course = courses.get(i);
                break;
            }
        }
        if (index==-1) {
            return false;
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                return false;
            }
        }
        if (credits <= 0) {
            return false;
        }
        if (student.getCredits() - credits < 0) {
            return false;
        }
        ArrayList<Student> temp1=new ArrayList<>(course.getEnrollStudent());
        temp1.add(student);
        course.setEnrollStudent(temp1);
        ArrayList<Integer> temp2=new ArrayList<>(course.getCredits());
        temp2.add(credits);
        course.setCredits(temp2);
        ArrayList<Course> temp3=new ArrayList<>(student.getEnrollCourses());
        temp3.add(course);
        student.setEnrollCourses(temp3);
        student.setCredits(student.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                course = courses.get(i);
                break;
            }
        }
        if(course.equals(null)){
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        if (credits > student.getCredits()+course.getCredits().get(index)) {
            return false;
        }
        ArrayList<Integer> temp = new ArrayList<>(course.getCredits());
        int originalCredits = temp.set(index, credits);
        student.setCredits(student.getCredits() + originalCredits - credits);
        course.setCredits(temp);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student s, String courseId) {
        if (!this.ifOpen) {
            return false;
        }
        Course course = null;
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getCourseID().equals(courseId)) {
                course = this.courses.get(i);
                break;
            }
        }

        // bug: potential NullPointerException
        // Assume the courseId is not exist in the this.courses, course will remain null.
        if(course.equals(null)){
            return false;
        }
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (s.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index1 = i;
                break;
            }
        }
        if(index1==-1){
            return false;
        }
        int temp4 = s.getCredits() + course.getCredits().get(index1);
        s.setCredits(temp4);
        ArrayList<Integer> temp1 = new ArrayList<>(course.getCredits());
        temp1.remove(index1);
        course.setCredits(temp1);
        ArrayList<Student> temp2 = new ArrayList<>(course.getEnrollStudent());
        temp2.remove(index1);
        course.setEnrollStudent(temp2);
        for (int i = 0; i < s.getEnrollCourses().size(); i++) {
            if (s.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                index2 = i;
                break;
            }
        }
//        if (index2 == -1) {
//            return false;
//        }
        ArrayList<Course> temp3 = new ArrayList<>(s.getEnrollCourses());
        temp3.remove(index2);
        s.setEnrollCourses(temp3);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        }
        int index = -1;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                if (student.getStudentID().equals(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID())) {
                    index = j;
                    break;
                }
            }
            String id =student.getEnrollCourses().get(i).getCourseID();
            int c=student.getEnrollCourses().get(i).getCredits().get(index);
            String s=String.format("%s: %d",id,c);
            result.add(s);
        }
        return result;
    }
    public void finalizeEnrollments(){
        this.ifOpen=false;
        for (int i = 0; i < courses.size(); i++) {
            Course course=courses.get(i);
            ArrayList<Student> students=new ArrayList<>(course.getEnrollStudent());
            ArrayList<Integer> credits=new ArrayList<>(course.getCredits());
            ArrayList<Integer> tempCredits=new ArrayList<>(course.getCredits());
            ArrayList<Student> successStudents=new ArrayList<>();
            int judge=-1;
            Integer temp=0;
            for(int m=0;m<tempCredits.size()-1;m++){
                for(int n=0;n<credits.size()-1-i;n++){
                    if(tempCredits.get(n)<tempCredits.get(n+1)){
                        temp=tempCredits.get(n);
                        tempCredits.set(n,tempCredits.get(n+1));
                        tempCredits.set(n+1,temp);
                    }
                }
            }
            for (int k = 0; k < tempCredits.size(); k++) {
                int count = 0;
                int sign1 = tempCredits.get(k);
                for (int l = 0; l < tempCredits.size(); l++) {
                    int sign2 = tempCredits.get(l);
                    if (sign2 >= sign1) {
                        count++;
                    }
                }
                if(count<course.getMaxCapacity()){
                    continue;
                }
                if (count == course.getMaxCapacity()) {
                    judge = sign1;
                    break;
                }
                if (count > course.getMaxCapacity()) {
                    judge = sign1 + 1;
                    break;
                }
            }
//            int index=course.getMaxCapacity()-1;
//            while(true){
//                if(index+1>=tempCredits.size()){
//                    break;
//                }
//                if(tempCredits.get(index)>tempCredits.get(index+1)){
//                    judge=tempCredits.get(index);
//                    break;
//                }
//                if(tempCredits.get(index)==tempCredits.get(index + 1)){
//                    judge=tempCredits.get(index)+1;
//                    break;
//                }
//                break;
//            }
            for(int x=0;x<credits.size();x++){
                if(judge<=credits.get(x)){
                    Student student=students.get(x);
                    ArrayList<Course> successCourses=new ArrayList<>(student.getSuccessCourses());
                    successCourses.add(course);
                    student.setSuccessCourses(successCourses);
                    successStudents.add(student);
                }
            }
            course.setSuccessStudents(successStudents);
        }
    }
}
