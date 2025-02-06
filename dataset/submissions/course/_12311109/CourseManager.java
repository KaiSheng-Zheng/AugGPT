import java.util.ArrayList;
import java.util.List;

class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
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

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }

    public int stuCont (ArrayList<Student> list, Student student) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentID().equals(student.getStudentID())) {
                return i;
            }
        }
        return -1;
    }

    public Course courseCont (ArrayList<Course> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCourseID().equals(id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public int removeCourse(ArrayList<Course> list, String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCourseID().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public boolean findCourseById(String courseId){
        for (int i = 0; i < courses.size() ; i++){
            if (courses.get(i).getCourseID().equals(courseId)){
                return true;
            }
        }
        return false;
    }

    public boolean whether_stu_enrolled(Student student, String courseId){
        if (student.getEnrollCourses() == null) {
            return false;
        }
        for(int i = 0 ; i < student.getEnrollCourses().size() ; i++){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                return true;
            }
        }
        return false;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){

        for(int i = 0 ; i < student.getEnrollCourses().size() ; i++){
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                return false;
            }
        }

        if(!findCourseById(courseId)){
            return false;
        }

        if (ifOpen && credits > 0 && credits <= student.getCredits()){

            Course real_course = courseCont(courses , courseId);

            ArrayList<Student> setEnrollStu = real_course.getEnrollStudent();
            setEnrollStu.add(student);
            real_course.setEnrollStudent(setEnrollStu);

            ArrayList<Course> setEnrollCourse = student.getEnrollCourses();
            setEnrollCourse.add(real_course);
            student.setEnrollCourses(setEnrollCourse);

            student.setCredits(student.getCredits()-credits);

            ArrayList<Integer> setCredits = real_course.getCredits();
            real_course.getCredits().add(credits);
            real_course.setCredits(setCredits);

            return true;
        }else {
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){

        if (!whether_stu_enrolled(student,courseId)){
            return false;
        }

        if(!findCourseById(courseId)){
            return false;
        }

        if (!ifOpen || credits < 0) {
            return false;
        }

        Course real_course = courseCont(courses , courseId);
        int stu_index = stuCont(real_course.getEnrollStudent(), student);
        boolean enoughCredits = student.getCredits() + real_course.getCredits().get(stu_index) >= credits;
        int cre_now = student.getCredits() + real_course.getCredits().get(stu_index) - credits;

        if (enoughCredits){
            student.setCredits(cre_now);
            real_course.getCredits().set(stu_index , credits);
            return true;
        }else {
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){

        if (!ifOpen){
            return false;
        }

        if(!findCourseById(courseId)){
            return false;
        }

        if (!whether_stu_enrolled(student,courseId)){
            return false;
        }

        Course real_course = courseCont(courses , courseId);

        int stu_index = stuCont(real_course.getEnrollStudent(), student);

        ArrayList<Student> course_after_remove = new ArrayList<>(real_course.getEnrollStudent());
        course_after_remove.remove(stu_index);
        real_course.setEnrollStudent(course_after_remove);

        ArrayList<Course> stu_after_remove = new ArrayList<>(student.getEnrollCourses());
        stu_after_remove.remove(removeCourse(student.getEnrollCourses(),courseId));
        student.setEnrollCourses(stu_after_remove);

        int cre_now = student.getCredits() + real_course.getCredits().get(stu_index);
        student.setCredits(cre_now);

        real_course.getCredits().remove(stu_index);
        return true;
    }

    public void finalizeEnrollments(){

        setIfOpen(false);

        for (int i = 0 ; i < courses.size() ; i++){

            Course operating_course = courses.get(i);
            int capacity = operating_course.getMaxCapacity();

            if(operating_course.getEnrollStudent().size() <= capacity){
                operating_course.setSuccessStudents(operating_course.getEnrollStudent());
            }else {

                ArrayList<Student> enrolled = new ArrayList<>(operating_course.getEnrollStudent());
                ArrayList<Integer> credits = new ArrayList<>(operating_course.getCredits());
                int tem_cre;
                Student tem_stu;

                for (int j = 0 ; j < enrolled.size() ; j++){
                    for (int k = 0 ; k < enrolled.size() - 1 ; k++){
                        if ( credits.get(k) < credits.get(k+1) ){
                            tem_cre = credits.get(k);
                            tem_stu = enrolled.get(k);
                            credits.set(k,credits.get(k+1));
                            credits.set(k+1,tem_cre);
                            enrolled.set(k,enrolled.get(k+1));
                            enrolled.set(k+1,tem_stu);
                        }
                    }
                }

                int last_stu = 0;

                if (credits.get(capacity - 1).equals(credits.get(capacity))){
                    for (int check = 0; check < capacity ; check++){
                        if (credits.get(check).equals(credits.get(capacity - 1))){
                            last_stu = check;
                            break;
                        }
                    }
                    List <Student> sublist_1 = enrolled.subList(0, last_stu );
                    operating_course.setSuccessStudents(new ArrayList<Student>(sublist_1));

                }else {
                    List<Student> sublist_2 = enrolled.subList(0,capacity );
                    operating_course.setSuccessStudents(new ArrayList<Student>(sublist_2));
                }

            }
        }

        for (int stu_check = 0 ; stu_check < students.size() ; stu_check++){
            ArrayList<Course> stu_i = new ArrayList<>();
            for (int course_check = 0 ; course_check < courses.size() ; course_check++){
                int check = stuCont(courses.get(course_check).getSuccessStudents() , students.get(stu_check));
                if (check >= 0 ){
                    stu_i.add(courses.get(course_check));
                }
            }
            students.get(stu_check).setSuccessCourses(stu_i);
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){

        if(!ifOpen){
            return null;
        }

        ArrayList<String> course_with_credits = new ArrayList<>();

        for (int i = 0 ; i < student.getEnrollCourses().size() ; i++){
            Course course = student.getEnrollCourses().get(i);
            String credits = course.getCredits().get(stuCont(course.getEnrollStudent(),student)).toString();
            String Final = course.getCourseID() + ": " + credits;
            course_with_credits.add(Final);
        }

        return course_with_credits;
    }
}
