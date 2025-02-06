import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    };

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setIfOpen(Boolean ifOpen){
        this.ifOpen=ifOpen;
    }
    public boolean getIfOpen(){
        return ifOpen;
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
        int a=0;
        if (!ifOpen) a++;
         if(credits<0) a++;
        Course course=null;
        for (Course c:courses){
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        }
        if (course==null) a++;
        for (Course c:student.getEnrollCourses())
            if (c.getCourseID().equals(courseId)){
                a++;
                break;
            }
        if (student.getCredits()<=0||student.getCredits()-credits<0) a++;
        if (a==0){
            student.setCredits(student.getCredits()-credits);
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            student.getEnrollCourses().add(course);
            return true;
        }
            return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        int a=0;
        if (!ifOpen) a++;
        if(credits<0) a++;
        Course course=null;
        for (Course c:courses)
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        if (course==null) a++;
        Course course1=null;
        for (Course c:student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                course1=c;
                break;
            }
        }
        if (course1==null) a++;
        if (a==0){
            if ((student.getCredits() <= 0) || ((course.getCredits().get(course.getEnrollStudent().indexOf(student)) + student.getCredits()) < credits)) a++;
        }
        if (a==0){
            student.setCredits(student.getCredits()+course.getCredits().get(course.getEnrollStudent().indexOf(student))-credits);
            course.getCredits().set(course.getEnrollStudent().indexOf(student),credits);
            return true;
        }
        return  false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        int a=0;
        if (!ifOpen) a++;
        Course course=null;
        for (Course c:courses)
            if (c.getCourseID().equals(courseId)){
                course=c;
                break;
            }
        if (course==null) a++;
        Course course1=null;
        for (Course c:student.getEnrollCourses()){
            if (c.getCourseID().equals(courseId)){
                course1=c;
                break;
            }
        }
        if (course1==null) {
            a++;
            return false;
        }
        if (a==0){
            student.setCredits(student.getCredits()+course1.getCredits().get(course1.getEnrollStudent().indexOf(student)));
            course.getCredits().remove(course.getEnrollStudent().indexOf(student));
            course.getEnrollStudent().remove(student);
            student.getEnrollCourses().remove(course);
            return true;
        }
        return false;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 1; j < courses.get(i).getCredits().size(); j++) {
                for (int k = 0; k < courses.get(i).getCredits().size() - j; k++) {
                    if (courses.get(i).getCredits().get(k) < courses.get(i).getCredits().get(k + 1)) {
                        int temp = courses.get(i).getCredits().get(k + 1);
                        courses.get(i).getCredits().set(k + 1, courses.get(i).getCredits().get(k));
                        courses.get(i).getCredits().set(k, temp);
                        Student student = courses.get(i).getEnrollStudent().get(k + 1);
                        courses.get(i).getEnrollStudent().set(k + 1, courses.get(i).getEnrollStudent().get(k));
                        courses.get(i).getEnrollStudent().set(k, student);
                    }
                }
            }
        }
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getMaxCapacity() < courses.get(i).getCredits().size()) {
                if (courses.get(i).getCredits().get(courses.get(i).getMaxCapacity() - 1).equals(courses.get(i).getCredits().get(courses.get(i).getMaxCapacity()))) {
                    courses.get(i).getSuccessStudents().clear();
                    courses.get(i).getSuccessStudents().addAll(courses.get(i).getEnrollStudent().subList(0, courses.get(i).getCredits().indexOf(courses.get(i).getCredits().get(courses.get(i).getMaxCapacity() - 1))));
                }
                if (!courses.get(i).getCredits().get(courses.get(i).getMaxCapacity() - 1).equals(courses.get(i).getCredits().get(courses.get(i).getMaxCapacity()))) {
                    courses.get(i).getSuccessStudents().clear();
                    courses.get(i).getSuccessStudents().addAll(courses.get(i).getEnrollStudent().subList(0, courses.get(i).getMaxCapacity()));
                }
                for (int j = 0; j < courses.get(i).getSuccessStudents().size(); j++) {
                    courses.get(i).getSuccessStudents().get(j).getSuccessCourses().add(courses.get(i));
                }
            }
            if (courses.get(i).getMaxCapacity()>=courses.get(i).getCredits().size()){
                courses.get(i).getSuccessStudents().addAll(courses.get(i).getEnrollStudent());
                for (int j = 0; j < courses.get(i).getSuccessStudents().size(); j++) {
                    courses.get(i).getSuccessStudents().get(j).getSuccessCourses().add(courses.get(i));
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
    if (!ifOpen) return null;
    ArrayList<String> strings=new ArrayList<>();
    for (int i=0;i<student.getEnrollCourses().size();i++) {
        String s = String.format("%s: %d", student.getEnrollCourses().get(i).getCourseID(),student.getEnrollCourses().get(i).getCredits().get(student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student)) );
       strings.add(s);
    }
    return  strings;
    }
}
