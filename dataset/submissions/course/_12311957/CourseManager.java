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


    public ArrayList<Course> getCourses() {
        return courses;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {
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
        if(!this.ifOpen)
            return false;

        if(credits <= 0){
            return false;
        }

        Course course = null;
        for(Course c: courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if(course == null){
            return false;
        }

        Course courseS = null;
        for(Course c: student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                courseS = c;
                break;
            }
        }
        if(courseS != null){
            return false;
        }

        if(student.getCredits()<credits){
            return false;
        }

        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);

        return true;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(!this.ifOpen)
            return false;

        Course course = null;
        for(Course c : courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if(course == null)
            return false;

        Course courseS = null;
        for(Course c : student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                courseS = c;
                break;
            }
        }
        if(courseS == null)
            return false;

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        if((student.getCredits() + originalCredits) < credits){
            return false;
        }
        student.setCredits((student.getCredits() + originalCredits) - credits);
        course.getCredits().set(index, credits);

        return true;
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(!this.ifOpen)
            return false;

        Course course = null;
        for(Course c : courses){
            if(c.getCourseID().equals(courseId)){
                course = c;
                break;
            }
        }
        if(course == null)
            return false;

        Course courseS = null;
        for(Course c : student.getEnrollCourses()){
            if(c.getCourseID().equals(courseId)){
                courseS = c;
                break;
            }
        }
        if(courseS == null)
            return false;

        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if(student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())){
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        student.setCredits(student.getCredits() + originalCredits);
        student.getEnrollCourses().remove(courseS);
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(index);

        return true;
    }


    public void finalizeEnrollments(){
        setIfOpen(false);
        for(Course c : courses){
            int minCredit = 100;
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if(c.getCredits().get(i)<minCredit){
                    minCredit = c.getCredits().get(i);
                }
            }
            minCredit -= 1;
            int succeedNumber = c.getEnrollStudent().size();
            ArrayList<Student> enrolledStudent = new ArrayList<Student>(c.getMaxCapacity());
            ArrayList<Integer> correspondingCredits = new ArrayList<>(c.getMaxCapacity());
            while(succeedNumber > c.getMaxCapacity()){
                minCredit += 1;
                int n = 0;
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if(c.getCredits().get(i) >= minCredit){
                        n += 1;
                    }
                }
                succeedNumber = n;
            }
            for (int i = 0; i < c.getCredits().size(); i++) {
                if(c.getCredits().get(i) >= minCredit){
                    enrolledStudent.add(c.getEnrollStudent().get(i));
                    correspondingCredits.add(c.getCredits().get(i));
                }
            }
            c.setSuccessStudents(enrolledStudent);
            for(Student s : enrolledStudent){
                s.getSuccessCourses().add(c);
            }
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!this.ifOpen)
            return null;

        ArrayList<String> list = new ArrayList<String>(student.getEnrollCourses().size());
        for(Course c : student.getEnrollCourses()){
            int index = -1;
            for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }
            list.add(student.getEnrollCourses().indexOf(c),c.getCourseID()+": "+c.getCredits().get(index));
        }
        return list;
    }

}