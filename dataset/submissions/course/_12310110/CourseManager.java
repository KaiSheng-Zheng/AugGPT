import java.util.ArrayList;
import java.util.Objects;

public class CourseManager {
    private boolean ifOpen;
    public CourseManager(){
        ifOpen = true;
    }
    ArrayList<Student> students = new ArrayList<>();
    // missing getter
    ArrayList<Course> courses = new ArrayList<>();
    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
    }
    public void addCourse(Course course){
        courses.add(course);
        course.setCourseManager(this);
    }
    ArrayList <Integer> first = new ArrayList<>();
    public void addStudent(Student student){
        students.add(student);
        student.setCourseManager(this);
        first.add(student.getCredits());
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(check(student,credits)&&ifOpen){
            if(student.getEnrollCourses().contains(getcoursefromID(courseId))||!courses.contains(getcoursefromID(courseId)))
            {return false;}
            for (int i = 0; i < courses.size(); i++) {
                if(courses.get(i).getCourseID().equals(courseId)) {
                    student.setCredits(student.getCredits() - credits);
                    student.getEnrollCourses().add(courses.get(i));
                    courses.get(i).getEnrollStudent().add(student);
                    courses.get(i).getCredits().add(credits);
                    if (courses.get(i).getEnrollStudent().size()<=courses.get(i).getMaxCapacity()){
                        courses.get(i).getSuccessStudents().add(student);
                        student.getSuccessCourses().add(courses.get(i));
                    }else {
                        int z =getcoursefromID(courseId).getSuccessStudents().size();
                        for (int k = 0; k< z; k++) {
                            getcoursefromID(courseId).getSuccessStudents().remove(0);
                        }
                        for (int j = 0; j < students.size(); j++) {
                            for (int l = 0; l < students.get(j).getSuccessCourses().size(); l++) {
                                if (students.get(j).getSuccessCourses().get(l).equals(getcoursefromID(courseId))){
                                    students.get(j).getSuccessCourses().remove(getcoursefromID(courseId));
                                }
                            }
                        }
                        for (int j = 0; j < courses.get(i).getEnrollStudent().size() - 1; j++) {
                            for (int k = j + 1; k < courses.get(i).getEnrollStudent().size(); k++) {
                                if (courses.get(i).getCredits().get(j) < courses.get(i).getCredits().get(k)) {
                                    int temp = courses.get(i).getCredits().get(j);
                                    Student stu = courses.get(i).getEnrollStudent().get(j);
                                    courses.get(i).getCredits().set(j, courses.get(i).getCredits().get(k));
                                    courses.get(i).getCredits().set(k, temp);
                                    courses.get(i).getEnrollStudent().set(j, courses.get(i).getEnrollStudent().get(k));
                                    courses.get(i).getEnrollStudent().set(k, stu);
                                }
                            }
                        }
                        for (int j = 0; j < courses.get(i).getMaxCapacity(); j++) {
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                            courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(getcoursefromID(courseId));
                        }int m = 0;
                        for (int k = 0; k < getcoursefromID(courseId).getMaxCapacity(); k++) {
                            if (getcoursefromID(courseId).getCredits().get(getcoursefromID(courseId).getMaxCapacity() - k - 1) == getcoursefromID(courseId).getCredits().get(getcoursefromID(courseId).getMaxCapacity()-m)) {
                                getcoursefromID(courseId).getSuccessStudents().get(getcoursefromID(courseId).getMaxCapacity() - k - 1).getSuccessCourses().remove(getcoursefromID(courseId));
                                getcoursefromID(courseId).getSuccessStudents().remove(getcoursefromID(courseId).getMaxCapacity() - k - 1);
                                m++;
                            }
                        }
                    }}
            }return true;
        }
        return false;
    }
    public Course getcoursefromID(String courseId){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                return courses.get(i);
            }
        }
        return null;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!student.getEnrollCourses().contains(getcoursefromID(courseId))){
            return false;}
            if (ifOpen&&check1(student,credits,courseId)) {
                student.setCredits(student.getCredits()+getcoursefromID(courseId).getCredits().get(getcoursefromID(courseId).getEnrollStudent().indexOf(student)) - credits);
            getcoursefromID(courseId).getCredits().set(getcoursefromID(courseId).getEnrollStudent().indexOf(student), credits);
            for (int j = 0; j < getcoursefromID(courseId).getEnrollStudent().size() - 1; j++) {
                for (int k = j + 1; k < getcoursefromID(courseId).getEnrollStudent().size(); k++) {
                    if (getcoursefromID(courseId).getCredits().get(j) < getcoursefromID(courseId).getCredits().get(k)) {
                        int temp = getcoursefromID(courseId).getCredits().get(j);
                        Student stu = getcoursefromID(courseId).getEnrollStudent().get(j);
                        getcoursefromID(courseId).getCredits().set(j, getcoursefromID(courseId).getCredits().get(k));
                        getcoursefromID(courseId).getCredits().set(k, temp);
                        getcoursefromID(courseId).getEnrollStudent().set(j, getcoursefromID(courseId).getEnrollStudent().get(k));
                        getcoursefromID(courseId).getEnrollStudent().set(k, stu);
                    }
                }
            }
            int a = getcoursefromID(courseId).getSuccessStudents().size();
            for (int i = 0; i < a; i++) {
                getcoursefromID(courseId).getSuccessStudents().remove(0);
            }
            for (int j = 0; j < students.size(); j++) {
                for (int l = 0; l < students.get(j).getSuccessCourses().size(); l++) {
                    if (students.get(j).getSuccessCourses().get(l).equals(getcoursefromID(courseId))){
                        students.get(j).getSuccessCourses().remove(getcoursefromID(courseId));
                    }
                }
            }
            if(getcoursefromID(courseId).getEnrollStudent().size()<=getcoursefromID(courseId).getMaxCapacity()){
                for (int i = 0; i < getcoursefromID(courseId).getEnrollStudent().size(); i++) {
                    getcoursefromID(courseId).getSuccessStudents().add(getcoursefromID(courseId).getEnrollStudent().get(i));
                    getcoursefromID(courseId).getEnrollStudent().get(i).getSuccessCourses().add(getcoursefromID(courseId));
                }
            }else {
                for (int j = 0; j < getcoursefromID(courseId).getMaxCapacity(); j++) {
                    getcoursefromID(courseId).getSuccessStudents().add(getcoursefromID(courseId).getEnrollStudent().get(j));
                    getcoursefromID(courseId).getEnrollStudent().get(j).getSuccessCourses().add(getcoursefromID(courseId));
                }
                int m = 0;
                for (int k = 0; k < getcoursefromID(courseId).getMaxCapacity(); k++) {
                    if (getcoursefromID(courseId).getCredits().get(getcoursefromID(courseId).getMaxCapacity() - k - 1) == getcoursefromID(courseId).getCredits().get(getcoursefromID(courseId).getMaxCapacity()-m)) {
                        getcoursefromID(courseId).getSuccessStudents().remove(getcoursefromID(courseId).getMaxCapacity() - k - 1);
                        student.getSuccessCourses().remove(getcoursefromID(courseId));
                        m++;
                    }
                }
            }
            return true;
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(ifOpen){
            if(!student.getEnrollCourses().contains(getcoursefromID(courseId))){
                return false;
            }
            student.setCredits(student.getCredits()+getcoursefromID(courseId).getCredits().get(getcoursefromID(courseId).getEnrollStudent().indexOf(student)));
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if(student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                    student.getEnrollCourses().get(i).getCredits().remove(getcoursefromID(courseId).getEnrollStudent().indexOf(student));
                    student.getEnrollCourses().get(i).getEnrollStudent().remove(student);
                    student.getEnrollCourses().remove(getcoursefromID(courseId));
                    break;
                }
            }
            for (int i = 0; i < student.getSuccessCourses().size(); i++) {
                for (int j = 0; j < getcoursefromID(courseId).getSuccessStudents().size(); j++) {
                    if(student.getSuccessCourses().get(i).equals(getcoursefromID(courseId).getSuccessStudents().get(j))){
                        student.getSuccessCourses().get(i).getCredits().remove(getcoursefromID(courseId).getSuccessStudents().indexOf(student));
                        student.getSuccessCourses().get(i).getSuccessStudents().remove(student);
                        student.getSuccessCourses().remove(getcoursefromID(courseId));
                    }
                }
            }
            int a = getcoursefromID(courseId).getSuccessStudents().size();
            for (int i = 0; i < a; i++) {
                getcoursefromID(courseId).getSuccessStudents().remove(0);
            }
            for (int j = 0; j < students.size(); j++) {
                for (int l = 0; l < students.get(j).getSuccessCourses().size(); l++) {
                    if (students.get(j).getSuccessCourses().get(l).equals(getcoursefromID(courseId))){
                        students.get(j).getSuccessCourses().remove(getcoursefromID(courseId));
                    }
                }
            }
            if(getcoursefromID(courseId).getEnrollStudent().size()<=getcoursefromID(courseId).getMaxCapacity()){
                for (int i = 0; i < getcoursefromID(courseId).getEnrollStudent().size(); i++) {
                    getcoursefromID(courseId).getSuccessStudents().add(getcoursefromID(courseId).getEnrollStudent().get(i));
                    getcoursefromID(courseId).getEnrollStudent().get(i).getSuccessCourses().add(getcoursefromID(courseId));
                }
            }else {
                for (int j = 0; j < getcoursefromID(courseId).getMaxCapacity(); j++) {
                    getcoursefromID(courseId).getSuccessStudents().add(getcoursefromID(courseId).getEnrollStudent().get(j));
                    getcoursefromID(courseId).getEnrollStudent().get(j).getSuccessCourses().add(getcoursefromID(courseId));
                }
                int m = 0;
                for (int k = 0; k < getcoursefromID(courseId).getMaxCapacity(); k++) {
                    if (getcoursefromID(courseId).getCredits().get(getcoursefromID(courseId).getMaxCapacity() - k - 1) == getcoursefromID(courseId).getCredits().get(getcoursefromID(courseId).getMaxCapacity()-m)) {
                        getcoursefromID(courseId).getSuccessStudents().remove(getcoursefromID(courseId).getMaxCapacity() - k - 1);
                        student.getSuccessCourses().remove(getcoursefromID(courseId));
                        m++;
                    }
                }
            }
            return true;
        }
        return false;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> COURSE = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            COURSE.add(student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student)));
        } if (ifOpen){
            return COURSE;}
        return null;
    }
    public boolean check(Student student,int credits){
        if(credits<0){
            return false;
        }
        if (credits>student.getCredits()){
            return false;
        }
        else {return true;
        }
    }
    public boolean check1(Student student,int credits,String courseID){
        if(credits<0){
            return false;
        }
        if (credits>first.get(getcoursefromID(courseID).getEnrollStudent().indexOf(student))){
            return false;
        }
        else {return true;
        }
    }
}
