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

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }
    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!this.ifOpen) return false;
        if(credits<=0){
            return false;
        }
        Course course = null;
        for (Course e :courses){
            if (e.getCourseID().equals(courseId)){
                course = e;
                break;
            }
        }
        if (course == null){
            return false;
        }

        for (Course e: student.getEnrollCourses()){
            if(e.getCourseID().equals(courseId)){
                return false;
            }
        }

        if (student.getCredits()<credits){
            return false;
        }
        else{
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            student.getEnrollCourses().add(course);
            student.setCredits(student.getCredits()-credits);
            return true;
        }
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!ifOpen){
            return false;
        }
        Course course = null;
        for (Course e :courses){
            if (e.getCourseID().equals(courseId)){
                course = e;
                break;
            }
        }
        if (course == null){
            return false;
        }
        Student student1 = null;
        for (Student e: course.getEnrollStudent()){
            if(e.getStudentID().equals(student.getStudentID())){
                student1 = e;
                break;
            }
        }
        if (student1 == null){
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        if (credits > course.getCredits().get(index)+ student.getCredits()){
            return false;
        }
        else{
            student.setCredits(course.getCredits().get(index)+ student.getCredits()-credits);
            course.getCredits().set(index, credits);
            return true;
        }

    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!ifOpen){return false;}
        Course course = null;
        for (Course e :courses){
            if (e.getCourseID().equals(courseId)){
                course = e;
                break;
            }
        }
        if (course == null){
            return false;
        }
        int index = -2;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        int index1 = -3;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())){
                index1 = i;
                break;
            }
        }
        if (index == -2){
            return false;
        }
        else{
            student.setCredits(student.getCredits()+course.getCredits().get(index));
            course.getEnrollStudent().remove(index);
            course.getCredits().remove(index);
            student.getEnrollCourses().remove(index1);
        return true;
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen){
            return null;
        }
        else{
            ArrayList<String> list = new ArrayList<>();
            for (Course cours : courses) {
                for (int j = 0; j < cours.getEnrollStudent().size(); j++) {
                    if (cours.getEnrollStudent().get(j).getStudentID() == student.getStudentID()) {
                        list.add(toString(cours.getCourseID(), cours.getCredits().get(j)));
                    }
                }
            }
            return list;
        }
    }
    public void finalizeEnrollments(){
        setIfOpen(false);
        for (int i = 0; i < courses.size(); i++) {
            int[] copyOfEachCourseCredits = new int[ courses.get(i).getCredits().size()];
            Student[] copyOfEachCourseEnrollStudent = new Student[courses.get(i).getEnrollStudent().size()];
            for (int j = 0; j < courses.get(i).getCredits().size(); j++) {
                copyOfEachCourseCredits[j]=courses.get(i).getCredits().get(j);
            }
            for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                copyOfEachCourseEnrollStudent[j]=courses.get(i).getEnrollStudent().get(j);
            }
            for (int j = 0; j < copyOfEachCourseCredits.length; j++) {
                for (int e = 0; e < copyOfEachCourseCredits.length-1; e++) {
                    if (copyOfEachCourseCredits[e]<copyOfEachCourseCredits[e+1]) {
                        int temp = copyOfEachCourseCredits[e];
                        copyOfEachCourseCredits[e] = copyOfEachCourseCredits[e + 1];
                        copyOfEachCourseCredits[e + 1] = temp;
                        Student temp1 = copyOfEachCourseEnrollStudent[e];
                        copyOfEachCourseEnrollStudent[e] = copyOfEachCourseEnrollStudent[e + 1];
                        copyOfEachCourseEnrollStudent[e + 1] = temp1;
                    }
                }
            }

            ArrayList<Student> successStudents = new ArrayList<>();

            if (courses.get(i).getMaxCapacity()>=courses.get(i).getEnrollStudent().size()){
                successStudents.addAll(courses.get(i).getEnrollStudent());
                courses.get(i).setSuccessStudents(successStudents);
            }
            else{
                int testInteger = copyOfEachCourseCredits[courses.get(i).getMaxCapacity()-1];
                if (courses.get(i).getMaxCapacity()>=2){
                    if (copyOfEachCourseCredits[courses.get(i).getMaxCapacity()]==testInteger&&testInteger!=copyOfEachCourseCredits[courses.get(i).getMaxCapacity()-2]){
                        for (int j = 0; j < courses.get(i).getMaxCapacity()-1; j++) {
                            successStudents.add(copyOfEachCourseEnrollStudent[j]);
                        }
                        courses.get(i).setSuccessStudents(successStudents);
                    }
                    if (copyOfEachCourseCredits[courses.get(i).getMaxCapacity()]!=testInteger){
                        for (int j = 0; j < courses.get(i).getMaxCapacity(); j++) {
                            successStudents.add(copyOfEachCourseEnrollStudent[j]);
                        }
                        courses.get(i).setSuccessStudents(successStudents);
                    }
                    if (copyOfEachCourseCredits[courses.get(i).getMaxCapacity()-2]==testInteger&&copyOfEachCourseCredits[courses.get(i).getMaxCapacity()]==testInteger){
                        for (int j = 0; j < copyOfEachCourseCredits.length; j++) {
                            if (copyOfEachCourseCredits[j]>copyOfEachCourseCredits[courses.get(i).getMaxCapacity()-2]){
                                successStudents.add(copyOfEachCourseEnrollStudent[j]);
                            }
                            courses.get(i).setSuccessStudents(successStudents);
                        }
                    }
                }
                else{
                        if (copyOfEachCourseCredits[courses.get(i).getMaxCapacity()]==testInteger){
                            courses.get(i).setSuccessStudents(successStudents);
                        }
                        if (copyOfEachCourseCredits[courses.get(i).getMaxCapacity()]!=testInteger){
                            successStudents.add(copyOfEachCourseEnrollStudent[0]);
                            courses.get(i).setSuccessStudents(successStudents);
                        }


                }
            }

        }
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getSuccessStudents().size(); j++) {
                Student studentt = courses.get(i).getSuccessStudents().get(j);
                ArrayList<Course> successCourses = studentt.getSuccessCourses();
                successCourses.add(courses.get(i));
                studentt.setSuccessCourses(successCourses);
            }

        }

    }


    public String toString(String str,int i){
        return str+": "+ i;
    }
}
