import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class CourseManager {


    private boolean ifOpen;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;


    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if (!this.ifOpen||credits<=0||student.getCredits()<credits)
            return false;
        Course course = null;
        for (Course successCours : this.courses) {
            if (successCours.getCourseID().equals(courseId)){
                course=successCours;
                break;
            }
        }
        if (course==null)
            return false;

        student.setCredits(student.getCredits()-credits);
        course.getCredits().add(credits);
        course.getEnrollStudent().add(student);
        student.getEnrollCourses().add(course);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course enrollCourse : this.courses) {
            if (enrollCourse.getCourseID().equals(courseId)){
                course=enrollCourse;
                break;
            }
        }
        if (course==null)
            return false;
        int index=0;
        ArrayList<Student> enrollStudent = course.getEnrollStudent();
        if (enrollStudent.size()==0){
            return false;
        }
        for (int i = 0; i < enrollStudent.size(); i++) {
            if (student.getStudentID().equals(enrollStudent.get(i).getStudentID())){
                index=i;
                break;
            }
        }
        Integer originalCredit = course.getCredits().get(index);
        if (student.getCredits()+originalCredit<credits){
            return false;
        }
        student.setCredits(student.getCredits()+originalCredit-credits);
        course.getCredits().set(index,credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if (!this.ifOpen)
            return false;
        Course course = null;
        for (Course enrollCourse : this.courses) {
            if (enrollCourse.getCourseID().equals(courseId)){
                course=enrollCourse;
                break;
            }
        }
        if (course==null)
            return false;
        int index=0;
        ArrayList<Student> enrollStudent = course.getEnrollStudent();
        if (enrollStudent.size()==0){
            return false;
        }
        for (int i = 0; i < enrollStudent.size(); i++) {
            if (student.getStudentID().equals(enrollStudent.get(i).getStudentID())){
                index=i;
                break;
            }
        }

        Integer originalCredit = course.getCredits().get(index);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);
        student.setCredits(student.getCredits()+originalCredit);
        student.getEnrollCourses().remove(course);
        return true;
    }
    public void finalizeEnrollments(){
        this.ifOpen=false;

        this.courses.forEach(course -> {
            if (course.getEnrollStudent().size()<=course.getMaxCapacity()){
                this.students.forEach(student -> {
                    student.getSuccessCourses().add(course);
                });
                course.getSuccessStudents().addAll(course.getEnrollStudent());
            }else {
                ArrayList<Integer> credits = (ArrayList<Integer>) course.getCredits().clone();
                Collections.sort(credits);
                List<Integer> successList = credits.subList(credits.size()-course.getMaxCapacity(), credits.size());
                Integer extraNumber = credits.get(credits.size()-course.getMaxCapacity()-1);
                if (credits.get(credits.size()-course.getMaxCapacity())==extraNumber){
                    for (int i = 0; i < successList.size(); i++) {
                        if (successList.get(i)==extraNumber){
                            successList.remove(extraNumber);
                            i--;
                        }
                    }
                }
//                Integer cache = 0;
//                for (int i = 0; i < successList.size(); i++) {
//                    Integer integer = successList.get(i);
//                    int index = course.getCredits().indexOf(integer);
//                    if (Objects.equals(cache, integer)){
//                        course.getSuccessStudents().add(course.getEnrollStudent().get(index+i));
//                        course.getEnrollStudent().get(index+i).getSuccessCourses().add(course);
//                    }else {
//                        course.getSuccessStudents().add(course.getEnrollStudent().get(index));
//                        course.getEnrollStudent().get(index).getSuccessCourses().add(course);
//                    }
//                    cache=successList.get(i);
//                }
                ArrayList<Integer> creditscloned = (ArrayList<Integer>) course.getCredits().clone();
                for (int i = 0; i < successList.size(); i++) {
                    Integer integer = successList.get(i);
                    int index = creditscloned.indexOf(integer);
                    if (index!=-1){
                        course.getEnrollStudent().get(index).getSuccessCourses().add(course);
                        course.getSuccessStudents().add(course.getEnrollStudent().get(index));
                        course.getEnrollStudent().remove(index);
                        creditscloned.remove(index);
                    }
                }
//                for (int i = 0; i < successList.size(); i++) {
//                    Integer integer = successList.get(i);
//                    int index =0;
//                    if(course.getCredits().contains(integer)){
//                        index=course.getCredits().indexOf(integer);
//                        index=index+i;
//                        course.getCredits().remove(integer);
//                        course.getEnrollStudent().get(index).getSuccessCourses().add(course);
//                        course.getSuccessStudents().add(course.getEnrollStudent().get(index));
//                    }
//                }
            }
        });
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!this.ifOpen)
            return null;
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Course> enrollCourses = student.getEnrollCourses();
        for (Course enrollCours : enrollCourses) {
            int index = 0;
            for (int i = 0; i < enrollCours.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(enrollCours.getEnrollStudent().get(i).getStudentID())){
                    index=i;
                    break;
                }
            }
            strings.add(enrollCours.getCourseID()+": "+enrollCours.getCredits().get(index));
        }
        return strings;
    }
    public CourseManager() {
        this.ifOpen = true;
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }


    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }


}
