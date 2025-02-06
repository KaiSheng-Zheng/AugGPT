import java.util.ArrayList;

public class CourseManager {
    public CourseManager(){
        this.courses= new ArrayList<>();
        this.students= new ArrayList<>();
        this.ifOpen= true;
    }
    private ArrayList<Course> courses;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    private ArrayList<Student> students;
    private boolean ifOpen;
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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

        if(!ifOpen){
            return false;
        }
        if(credits<=0){
            return false;
        }
        Course course = null;
        for(Course c:this.courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
       Course c2 = null;
        for(Course s : student.getEnrollCourses()){
            if (s.getCourseID().equals(courseId)){
                c2 = s;
                break;
            }
        }
        if (c2 != null){
            return false;
        }
        if(student.getCredits()-credits<0){
            return false;
        }
        student.setCredits(student.getCredits()-credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!ifOpen){
            return false;
        }

        Course course = null;
        for(Course c:this.courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
        Course c2 = null;
        for(Course s : student.getEnrollCourses()){
            if (s.getCourseID().equals(courseId)){
                c2 = s;
                break;
            }
        }
        if (c2 == null){
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        if(student.getCredits()+course.getCredits().get(index)-credits<0){
            return false;
        }

        student.setCredits(student.getCredits()+course.getCredits().get(index)-credits);
        course.getCredits().set(index,credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen){
            return false;
        }

        Course course = null;
        for(Course c:this.courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if (course == null){
            return false;
        }
        Course c2 = null;
        for(Course s : student.getEnrollCourses()){
            if (s.getCourseID().equals(courseId)){
                c2 = s;
                break;
            }
        }
        if (c2 == null){
            return false;
        }

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        int index2 = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                index2 = i;
                break;
            }
        }
        student.setCredits(student.getCredits()+course.getCredits().get(index));
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);
        student.getEnrollCourses().remove(index2);

        return true;
    }

    public void finalizeEnrollments(){
        setIfOpen(false);

        for (int i = 0; i < this.courses.size(); i++) {
            ArrayList<Integer> copy = new ArrayList<Integer>();
            Course course = this.courses.get(i);
            for (int j = 0; j < course.getCredits().size(); j++) {
                copy.add(course.getCredits().get(j));
            }
            int max = course.getMaxCapacity();
            int cup;
            for (int j = 0; j < copy.size() - 1; j++) {
                for (int k = j + 1; k < copy.size(); k++) {
                    if (copy.get(j) < copy.get(k)) {
                        cup = copy.get(j);
                        copy.set(j, copy.get(k));
                        copy.set(k, cup);
                    }
                }
            }
            if (copy.size() <= max) {
                course.setSuccessStudents(course.getEnrollStudent());
                for (int j = 0; j < this.students.size(); j++) {
                    for (int k = 0; k < course.getSuccessStudents().size(); k++) {
                        if (course.getSuccessStudents().get(k).equals(this.students.get(j))) {
                            this.students.get(j).getSuccessCourses().add(course);
                        }
                    }
                }
            } else {
                int successfulCredit = copy.get(max - 1);

                int size = course.getCredits().size();
                int cmd = 0;
                while (cmd < size) {

                    if (course.getCredits().get(cmd) < successfulCredit) {
                        course.getEnrollStudent().remove(cmd);
                        course.getCredits().remove(cmd);
                        cmd--;
                        size--;
                    }
                    cmd++;
                }


                if (course.getEnrollStudent().size() > max) {
                    int size2 = course.getCredits().size();
                    int cmd2 = 0;
                    while (cmd2 < size2) {
                        if (course.getCredits().get(cmd2) == successfulCredit) {
                            course.getEnrollStudent().remove(cmd2);
                            course.getCredits().remove(cmd2);
                            cmd2--;
                            size2--;
                        }
                        cmd2++;
                    }

                }

                course.setSuccessStudents(course.getEnrollStudent());
                for (int j = 0; j < this.students.size(); j++) {
                    for (int k = 0; k < course.getSuccessStudents().size(); k++) {
                        if (course.getSuccessStudents().get(k).equals(this.students.get(j))) {
                            this.students.get(j).getSuccessCourses().add(course);
                        }
                    }
                }
            }
        }

    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){
            return null;
        }

        int credit1 = -1;
        ArrayList<String> CourseAndCredits= new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course course = student.getEnrollCourses().get(i);
            String id = course.getCourseID();
            for(int j = 0;j < course.getEnrollStudent().size();j++){
                if(course.getEnrollStudent().get(j).equals(student)){

                    credit1 = course.getCredits().get(j);
                    break;
                }
            }
            CourseAndCredits.add(id + ": " + credit1);

        }
        return CourseAndCredits;
    }
}
