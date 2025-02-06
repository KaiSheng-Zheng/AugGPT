import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    private boolean ifOpen;

    public CourseManager() {
        courses =new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
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


    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if(credits<=0){
            return false;
        }
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
        Course Ctest = null;
        for(Course Cin:student.getEnrollCourses()){
            if (Cin.getCourseID().equals(courseId)) {
                Ctest = Cin;
                break;
            }
        }
        if (Ctest != null){
            return false;
        }


        if(student.getCredits()<credits){
            return false;
        }
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        int orl = student.getCredits();
        student.setCredits(orl-credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }

        Course Ctest = null;
        for(Course Cin:student.getEnrollCourses()){
            if (Cin.getCourseID().equals(courseId)) {
                Ctest = Cin;
                break;
            }
        }
        if (Ctest == null){
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index=i;
                break;
            }
        }

        int OriginalCredits = course.getCredits().get(index);
        //missing boudnary check, may not have enough credit to bid and drop to negative!
        student.setCredits((student.getCredits()+OriginalCredits-credits));
        course.getCredits().set(index,credits);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student s, String courseId){
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }

        Course Ctest = null;
        for(Course Cin:s.getEnrollCourses()){
            if (Cin.getCourseID().equals(courseId)) {
                Ctest = Cin;
                break;
            }
        }
        if (Ctest == null){
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (s.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index=i;
                break;
            }
        }
        int indexS = -1;
        for (int i = 0; i < s.getEnrollCourses().size(); i++) {
            if (course.getCourseID().equals(s.getEnrollCourses().get(i).getCourseID())) {
                indexS = i;
                break;
            }
        }

        int OriginalCredits = course.getCredits().get(index);
        s.setCredits((s.getCredits()+OriginalCredits));
        s.getEnrollCourses().remove(indexS);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);

        return true;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> list=new ArrayList<>();

        int index=-1;
        for(Course Cin:student.getEnrollCourses()){
            for (int i = 0; i < Cin.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(Cin.getEnrollStudent().get(i).getStudentID())){
                    index=i;
                    break;
                }
            }
            list.add(new String((Cin.getCourseID()+": "+(Cin.getCredits().get(index)))));
        }
        return list;
    }

    public void finalizeEnrollments(){
        ifOpen = false;

        for(Course Test:this.courses){
            ArrayList<Integer> creditTest=new ArrayList<>();
            for (int i = 0; i < Test.getCredits().size(); i++) {
                creditTest.add(Test.getCredits().get(i));
            }
            creditTest.sort(Comparator.reverseOrder());

            int Cap =Test.getMaxCapacity();
            int i=0;
            while (true){
                int count=0;
                for (int c:creditTest) {
                    if(c>=i){
                        count++;
                    }
                }
                if(count<=Cap){
                    break;
                }
                i++;
            }

            ArrayList<Student> successStudents=new ArrayList<>();

            for (Student s:Test.getEnrollStudent()){
                ArrayList<Course> successCourses=new ArrayList<>();
                int index = 0;
                for (int j = 0; j < Test.getEnrollStudent().size(); j++) {
                    if(Test.getEnrollStudent().get(j).equals(s)){
                        index = j;
                    }
                }
                if(Test.getCredits().get(index)>=i){
                    successStudents.add(s);
                    successCourses.add(Test);
                }
                s.setSuccessCourses(successCourses);
            }
            Test.setSuccessStudents(successStudents);
        }
    }


}


