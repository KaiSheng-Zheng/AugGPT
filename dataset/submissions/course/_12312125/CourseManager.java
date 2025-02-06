import java.util.ArrayList;
import java.util.Objects;

public class CourseManager {
    final private ArrayList<Course> courses;
    final private ArrayList<Student> students;
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
    public void setIfOpen(boolean ifOpen){
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
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen)
            return false;
        int b = -1;
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                b = i;
                break;
            }
        }
        if (b==-1)
            return false;
        for (int i = 0; i < courses.get(b).getEnrollStudent().size(); i++) {
                if (courses.get(b).getEnrollStudent().get(i) == student) {
                    return false;
                }
        }
        if (student.getCredits() < credits || credits <= 0)
            return false;
        student.setCredits(student.getCredits() - credits);
        courses.get(b).getEnrollStudent().add(student);
        courses.get(b).getCredits().add(credits);
        student.getEnrollCourses().add(courses.get(b));
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (credits <= 0)
            return false;
        if (!ifOpen)
            return false;
        int b = -1;
        int c = -1;
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                b = i;
                break;
            }
        }
        if (b==-1)
            return false;
        for (int j = 0; j < courses.get(b).getEnrollStudent().size(); j++) {
            if (Objects.equals(courses.get(b).getEnrollStudent().get(j).getStudentID(), student.getStudentID())) {
                c = j;
            }
        }
        if (c==-1)
            return false;
        int differ = courses.get(b).getCredits().get(c) - credits;
        if (courses.get(b).getCredits().get(c) + student.getCredits() >= credits){
            courses.get(b).getCredits().set(c,credits);
            student.setCredits(student.getCredits() + differ);
            return true;
        }
        else return false;

    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        int b = -1;
        int c = -1;
        if (!ifOpen)
            return false;
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){
                b = i;
                break;
            }
        }
        if (b==-1)
            return false;
        for (int j = 0; j < courses.get(b).getEnrollStudent().size(); j++) {
            if (courses.get(b).getEnrollStudent().get(j) == student) {
                c = j;
            }
        }
        if (c==-1)
            return false;
        student.setCredits(student.getCredits() + courses.get(b).getCredits().get(c));
        courses.get(b).getEnrollStudent().remove(c);
        courses.get(b).getCredits().remove(c);
        int d = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)){
                d = i;
            }
        }
        student.getEnrollCourses().remove(d);
        return true;
    }
    public void finalizeEnrollments(){
        ifOpen = false;
        int[] differ = new int[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
            differ[i] = courses.get(i).getEnrollStudent().size() - courses.get(i).getMaxCapacity();
        }
        for (int i = 0; i < courses.size(); i++) {
            int times = courses.get(i).getCredits().size();
            if (differ[i] <= 0){
                for (int j = 0; j < times; j++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                }
            }
            else {
                int min = sort(courses.get(i).getEnrollStudent(), courses.get(i).getCredits(), differ[i]);
                for (int j = 0; j < times; j++) {
                    if (courses.get(i).getCredits().get(j) > min) {
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                        courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                    }
                }
            }
        }
    }

    public int sort(ArrayList<Student> enrollStudent, ArrayList<Integer> credits,int differ){
        for (int i = 0; i < differ; i++) {
            for (int j = 0; j < credits.size()-i-1; j++) {
                if (credits.get(j) < credits.get(j+1)){
                    int middle = credits.get(j);
                    credits.set(j,credits.get(j+1));
                    credits.set(j+1,middle);
                    Student a = enrollStudent.get(j);
                    enrollStudent.set(j,enrollStudent.get(j+1));
                    enrollStudent.set(j+1,a);
                }
            }
        }
        return credits.get(credits.size()-differ);
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (!ifOpen)
            return null;
        ArrayList<String> r = new ArrayList<>();
        int place = 0;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                if (student.getEnrollCourses().get(i).getEnrollStudent().get(j) == student)
                    place = j;
            }
            String ri = student.getEnrollCourses().get(i).getCourseID() + ": " + String.valueOf(student.getEnrollCourses().get(i).getCredits().get(place));
            r.add(ri);
        }
        return r;
    }
}
