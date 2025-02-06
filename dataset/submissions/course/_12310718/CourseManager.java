import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager() {
        this.courses=new ArrayList<>();this.students=new ArrayList<>();
        ifOpen=true;
    }
    public ArrayList<Student> getStudents(){return this.students;}
    public ArrayList<Course> getCourses(){return this.courses;}
    public void setIfOpen(Boolean ifOpen){this.ifOpen=ifOpen;}
    public boolean getIfOpen(){return this.ifOpen;}
    public void addCourse(Course course){course.setCourseManager(this);courses.add(course);}
    public void addStudent(Student student){student.setCourseManager(this);students.add(student);}
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if(!ifOpen)return false;
        if(credits<=0)return false;
        if(!students.contains(student))return false;
        if(student.getCredits()<credits)return false;
        for(Course course:courses) {
            if(course.getCourseID().equals(courseId)) {
                ArrayList<Student> st=course.getEnrollStudent();
                if(st.contains(student))return false;
                student.setCredits(student.getCredits()-credits);
                ArrayList<Course> c=student.getEnrollCourses();
                c.add(course);student.setEnrollCourses(c);
                st.add(student);course.setEnrollStudent(st);
                ArrayList<Integer> cr=course.getCredits();
                cr.add(credits);course.setCredits(cr);
                return true;
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if(!ifOpen)return false;
        if(credits<=0)return false;
        if(!students.contains(student))return false;
        for(Course course:courses) {
            if(course.getCourseID().equals(courseId)) {
                ArrayList<Course> co=student.getEnrollCourses();
                if(co.contains(course)) {
                    ArrayList<Student> st=course.getEnrollStudent();
                    ArrayList<Integer> cr=course.getCredits();
                    if(!st.contains(student))return false;
                    if(cr.get(st.indexOf(student))+student.getCredits()>=credits) {
                        dropStudentEnrollmentCourse(student,courseId);
                        enrollStudentInCourse(student,courseId,credits);
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if(!ifOpen)return false;
        if(!students.contains(student))return false;
        for(Course course:courses) {
            if(course.getCourseID().equals(courseId)) {
                ArrayList<Course> co=student.getEnrollCourses();
                if(co.contains(course)) {
                    ArrayList<Student> st=course.getEnrollStudent();
                    if(!st.contains(student))return false;
                    ArrayList<Integer> cr=course.getCredits();
                    student.setCredits(cr.get(st.indexOf(student))+student.getCredits());
                    cr.remove(st.indexOf(student));st.remove(student);co.remove(course);
                    course.setEnrollStudent(st);course.setCredits(cr);student.setEnrollCourses(co);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    public void finalizeEnrollments() {
        setIfOpen(false);
        for(Course course:courses) {
            ArrayList<Integer> cr=course.getCredits();
            ArrayList<Student> successStudents=course.getEnrollStudent();
            for(int i=0;i< cr.size()-1;i++)
                for(int j=0;j< cr.size()-i-1;j++)
                    if(cr.get(j)<cr.get(j+1)) {
                        int a=cr.get(j);Student st=successStudents.get(j);
                        cr.set(j,cr.get(j+1));successStudents.set(j,successStudents.get(j+1));
                        cr.set(j+1,a);successStudents.set(j+1,st);
                    }
            while(cr.size()>course.getMaxCapacity()+1){successStudents.remove(cr.size()-1);cr.remove(cr.size()-1);}
            if(cr.size()==course.getMaxCapacity()+1) {
                int cri = cr.get(course.getMaxCapacity());
                while (cr.get(cr.size() - 1) == cri) {
                    successStudents.remove(cr.size() - 1);
                    cr.remove(cr.size() - 1);
                    if(cr.isEmpty())break;
                }
            }
            course.setSuccessStudents(successStudents);
            for(Student st:successStudents) {
                ArrayList<Course> successCourses=st.getSuccessCourses();
                successCourses.add(course);
                st.setSuccessCourses(successCourses);
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> course=new ArrayList<>();
        if(ifOpen) {
            ArrayList<Course> co=student.getEnrollCourses();
            for(Course course1:co){
                String num=Integer.toString(course1.getCredits().get(course1.getEnrollStudent().indexOf(student)));
                course.add(course1.getCourseID()+": "+num);
            }
        }
        return course;
    }
}
