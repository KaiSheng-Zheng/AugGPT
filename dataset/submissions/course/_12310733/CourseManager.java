import java.util.ArrayList;
import java.util.Comparator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    //missing getter
    private boolean ifOpen;

    public CourseManager(){
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public void addCourse(Course course){
        for(Course iter:courses){
            if(iter.getCourseID().equals(course.getCourseID()))return;
        }
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student){
        for(Student iter:students){
            if(iter.getStudentID().equals(student.getStudentID()))return;
        }
        students.add(student);
        student.setCourseManager(this);
    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        if(!ifOpen || credits<=0 || student.getCredits()-credits<0)return false;
        Course enrollCourse = null;
        for(Course iter:courses){
            if(iter.getCourseID().equals(courseId)){enrollCourse=iter;break;}
        }
        if(enrollCourse==null)return false;
        ArrayList<Course>studentEnrollCourses = student.getEnrollCourses();
        for(Course iter:studentEnrollCourses) {
            if (iter.getCourseID().equals(courseId)) return false;
        }
        student.setCredits(student.getCredits()-credits);
        studentEnrollCourses.add(enrollCourse);
        student.setEnrollCourses(studentEnrollCourses);

        ArrayList<Student>courseEnrollStudent =enrollCourse.getEnrollStudent();
        courseEnrollStudent.add(student);
        enrollCourse.getCredits().add(credits);
        enrollCourse.setEnrollStudent(courseEnrollStudent);
        return true;
    }
    public boolean modifyStudentEnrollmentCredits(Student student,String courseId,int credits){
        if(credits<=0 || !ifOpen)return false;
        Course course=null;
        for(Course iter:courses){
            if(iter.getCourseID().equals(courseId)){course=iter;break;}
        }
        if(course==null)return false;
        ArrayList<Student>studentList = course.getEnrollStudent();
        int pos=studentList.indexOf(student);
        if(pos==-1)return false;
        int balance = course.getCredits().get(pos)+student.getCredits();
        if(balance<credits)return false;

        student.setCredits(balance-credits);
        course.getCredits().set(pos,credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!ifOpen)return false;
        Course course = null;
        for(Course iter:courses){
            if(iter.getCourseID().equals(courseId)){course=iter;break;}
        }
        if(course==null)return false;
        ArrayList<Student>studentList = course.getEnrollStudent();
        int pos=studentList.indexOf(student);
        if(pos==-1)return false;

        student.setCredits(student.getCredits()+course.getCredits().get(pos));
        ArrayList<Course>courseList = student.getEnrollCourses();
        courseList.remove(course);
        student.setEnrollCourses(courseList);

        course.getCredits().remove(pos);
        course.getEnrollStudent().remove(pos);
        return true;
    }
    public void finalizeEnrollments(){
        ifOpen=false;
        for(Course iter:courses){
            if(iter.getEnrollStudent().isEmpty())continue;
            ArrayList<Student> enrollStudents=iter.getEnrollStudent();
            ArrayList<Integer> creditsList = iter.getCredits();
            ArrayList<Integer> creditsSort;
            creditsSort = (ArrayList<Integer>) creditsList.clone();
            creditsSort.sort(Comparator.reverseOrder());
            int limit;
            if(creditsSort.size()<=iter.getMaxCapacity()){
                limit=creditsSort.get(creditsSort.size()-1);
            }else {
                limit = creditsSort.get(iter.getMaxCapacity());
                int l=creditsSort.indexOf(limit);
                int r=creditsSort.lastIndexOf(limit);
                if(r+1>iter.getMaxCapacity()){
                    if(l-1>=0)limit=creditsSort.get(l-1);
                    else limit=10000;
                }
            }
            ArrayList<Student> successStudents = new ArrayList<>();
            for(int i = 0; i<enrollStudents.size(); i++) {
                if (creditsList.get(i) >= limit) {
                    successStudents.add(enrollStudents.get(i));
                }
            }
            iter.setSuccessStudents(successStudents);
        }
        for(Student student:students){
            ArrayList<Course>successCourses = new ArrayList<>();
            ArrayList<Course>enrollCourses= student.getEnrollCourses();
            for(Course course:enrollCourses){
                ArrayList<Student>successStudents=course.getSuccessStudents();
                for (Student successStudent : successStudents) {
                    if (student.equals(successStudent)) {
                        successCourses.add(course);
                        break;
                    }
                }
            }
            student.setSuccessCourses(successCourses);
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen)return null;
        ArrayList<String>List = new ArrayList<>();
        ArrayList<Course>enrollCourses= student.getEnrollCourses();
        for(Course course:enrollCourses){
            int pos=course.getEnrollStudent().indexOf(student);
            List.add(course.getCourseID()+": "+course.getCredits().get(pos).toString());
        }
        return List;
    }
}
