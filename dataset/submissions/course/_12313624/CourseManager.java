import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course>courses;
    private ArrayList<Student>students;
    private boolean ifOpen;
    public CourseManager(){
        courses=new ArrayList<>();
        students=new ArrayList<>();
        ifOpen=true;
    }
    public ArrayList<Student>getStudents(){
        return students;
    }
    public ArrayList<Course>getCourses(){
        return courses;
    }
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public void addCourse(Course course){
        course.setCourseManager(this);
        courses.add(course);

    }
    public void addStudent(Student student){
        student.setCourseManager(this);
        students.add(student);
    }
    public boolean enrollStudentInCourse(Student student,String courseId,int credits){
        if (ifOpen){
            int number=-1;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId))number=i;
            }
            if (number!=-1) {
                if (!student.getEnrollCourses().contains(courses.get(number))){
                    if (credits>0){
                        if (student.getCredits()>=credits){
                            student.setCredits(student.getCredits()-credits);

                            ArrayList<Student>newstudent=new ArrayList<>();
                            newstudent=courses.get(number).getEnrollStudent();
                            newstudent.add(student);
                            courses.get(number).setEnrollStudent(newstudent);

                            ArrayList<Integer>newcredits=new ArrayList<>();
                            newcredits=courses.get(number).getCredits();
                            newcredits.add(credits);
                            courses.get(number).setCredits(newcredits);

                            ArrayList<Course>newcourse=new ArrayList<>();
                            newcourse=student.getEnrollCourses();
                            newcourse.add(courses.get(number));
                            student.setEnrollCourses(newcourse);
                            return true;
                        }else return false;
                    }else return false;
                }else return false;
            }else return false;
        }else return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student,String courseId,int credits){
        if (ifOpen){
            int number=-1;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId))number=i;
            }
            if (number!=-1){
                if (student.getEnrollCourses().contains(courses.get(number))){
                    int number2=-1;
                    for (int i = 0; i < courses.get(number).getEnrollStudent().size(); i++) {
                        if (courses.get(number).getEnrollStudent().get(i) == student) number2 = i;
                    }
                    if (credits>0&credits<=(student.getCredits()+courses.get(number).getCredits().get(number2))){
                        student.setCredits(student.getCredits()+courses.get(number).getCredits().get(number2)-credits);

                        ArrayList<Integer>newcredit=new ArrayList<>();
                        newcredit=courses.get(number).getCredits();
                        newcredit.remove(number2);
                        newcredit.add(number2,credits);
                        courses.get(number).setCredits(newcredit);

                        return true;
                    }else return false;
                }else return false;
            }else return false;
        }else return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student,String courseId){
        if (ifOpen){
            int number=-1;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId))number=i;
            }
            if (number!=-1){
                if (student.getEnrollCourses().contains(courses.get(number))){
                    int number2=-1;
                    for (int i = 0; i < courses.get(number).getEnrollStudent().size(); i++) {
                        if (courses.get(number).getEnrollStudent().get(i) == student) number2 = i;
                    }
                    student.setCredits(student.getCredits()+courses.get(number).getCredits().get(number2));

                    ArrayList<Student>newstudent=new ArrayList<>();
                    ArrayList<Integer>newcredits=new ArrayList<>();
                    newstudent=courses.get(number).getEnrollStudent();
                    newcredits=courses.get(number).getCredits();
                    newcredits.remove(number2);
                    newstudent.remove(number2);
                    courses.get(number).setEnrollStudent(newstudent);
                    courses.get(number).setCredits(newcredits);

                    int number3=-1;
                    for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                        if (student.getEnrollCourses().get(i)==courses.get(number))number3=i;
                    }
                    ArrayList<Course>newcourse=new ArrayList<>();
                    newcourse=student.getEnrollCourses();
                    newcourse.remove(number3);
                    student.setEnrollCourses(newcourse);
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }
    public void finalizeEnrollments(){
        ifOpen=false;

        for (int i = 0; i < courses.size(); i++) {

            ArrayList<Student> newstudent = new ArrayList<>();
            ArrayList<Integer> newcredits = new ArrayList<>();
            newstudent = courses.get(i).getEnrollStudent();
            newcredits = courses.get(i).getCredits();

            for (int i1 = 0; i1 < newcredits.size(); i1++) {
                int stpcredit=0;
                Student stpstudent;
                for (int i2 = 0; i2 < newcredits.size()-1; i2++) {
                    if (newcredits.get(i2)<newcredits.get(i2+1)){
                        stpcredit=newcredits.get(i2);
                        stpstudent=newstudent.get(i2);
                        newcredits.remove(i2);
                        newstudent.remove(i2);
                        newcredits.add(i2+1,stpcredit);
                        newstudent.add(i2+1,stpstudent);
                    }
                }
            }
            courses.get(i).setEnrollStudent(newstudent);
            courses.get(i).setCredits(newcredits);

            int all=courses.get(i).getMaxCapacity();
            if (courses.get(i).getMaxCapacity()>=newstudent.size()){
                all=newstudent.size();
            }else {
                if (newcredits.get(courses.get(i).getMaxCapacity())<newcredits.get(courses.get(i).getMaxCapacity()-1)){

                }else{
                    for (int i1 =courses.get(i).getMaxCapacity()-1; i1>=0 ; i1--) {
                        if (newcredits.get(i1).equals(newcredits.get(courses.get(i).getMaxCapacity()))){
                            all--;
                        }else break;
                    }
                }
            }

            ArrayList<Student> sussstudent = new ArrayList<>();
            ArrayList<Course> newsusscourse= new ArrayList<>();
            for (int i1 = 0; i1 < all; i1++) {
                sussstudent.add(newstudent.get(i1));
            }
            courses.get(i).setSuccessStudents(sussstudent);

            for (int i1 = 0; i1 < all; i1++) {
                newsusscourse=sussstudent.get(i1).getSuccessCourses();
                newsusscourse.add(courses.get(i));
                sussstudent.get(i1).setSuccessCourses(newsusscourse);
            }

        }

    }
    public ArrayList<String>getEnrolledCoursesWithCredits(Student student){
        if (ifOpen){
            ArrayList<String>ALL=new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {

                int number=-1;
                for (int i1 = 0; i1 < courses.size(); i1++) {
                    if (courses.get(i1).getCourseID().equals(student.getEnrollCourses().get(i).getCourseID()))number=i1;
                }

                int number2=-1;
                for (int i1 = 0; i1 < courses.get(number).getEnrollStudent().size(); i1++) {
                    if (courses.get(number).getEnrollStudent().get(i1).getStudentID() .equals( student.getStudentID())) number2 = i1;
                }

                if (number!=-1&number2!=-1)ALL.add(courses.get(number).getCourseID()+": "+courses.get(number).getCredits().get(number2));

            }
            return ALL;
        }else return null;
    }
}
