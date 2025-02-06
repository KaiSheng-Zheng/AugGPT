import java.util.ArrayList;
public class CourseManager {
    private final ArrayList<Course> courses;
    private final ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {
        return ifOpen;
    }
    public void addCourse(Course course) {
        this.courses.add(course) ;
        course.setCourseManager(this);
    }
    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
        student.setEnrollCourses(new ArrayList<>());
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean ifOpen = getIfOpen();
        if (ifOpen) {
            int a = -1;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    a = i;
                    break;
                }
            }
            if (credits > 0 && credits <= student.getCredits() || a >= 0 || a < courses.size() || this.getIfOpen()) {
                student.setCredits(student.getCredits() - credits);
                courses.get(a).getEnrollStudent().add(student);
                courses.get(a).getCredits().add(credits);
                student.getEnrollCourses().add(courses.get(a));
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
        public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
            boolean ifOpen=getIfOpen();
            if(ifOpen){
                for (Course course : courses) {
                    String coursesId = course.getCourseID();
                    if (coursesId.equals(courseId)) {
                        ArrayList<Student> enrollstudent = course.getEnrollStudent();
                        for (int k = 0; k < enrollstudent.size(); k++) {
                            String sutdentId1 = enrollstudent.get(k).getStudentID();
                            String sutdentId2 = student.getStudentID();
                            if (sutdentId1.equals(sutdentId2)) {
                                int s = student.getCredits();
                                ArrayList<Integer> coursecredits = course.getCredits();
                                int c = coursecredits.get(k);
                                int total = s + c;
                                if (total >= credits) {
                                    coursecredits.set(k, credits);
                                    course.setCredits(coursecredits);
                                    student.setCredits(total - credits);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    public boolean dropStudentFromCourse(Student student, String courseId) {
        int b=-1;
        for(int h=0;h<courses.size();h++){
            if(courses.get(h).getCourseID().equals(courseId)){
                b=h;
                break;
            }
        }
        if (b == -1) {
            return false;
        }
        int c=-1;
        for(int t=0;t<courses.get(b).getEnrollStudent().size();t++) {
            if (courses.get(b).getEnrollStudent().get(t).getStudentID().equals(student.getStudentID())) {
                c = t;
                student.setCredits(student.getCredits()+courses.get(b).getCredits().get(c));
                Student element =courses.get(b).getEnrollStudent().remove(c);
                Integer str =courses.get(b).getCredits().remove(c);
            }
        }
        if (c == -1) {
            return false;
        }else{
            for(int p=0;p<student.getEnrollCourses().size();p++){
                if(student.getEnrollCourses().get(p).getCourseID().equals(courses.get(b).getCourseID())){
                    Course element =student.getEnrollCourses().remove(p);
                }
            }
        }
        return this.getIfOpen();
    }
    public void finalizeEnrollments(){
        setIfOpen(false);
        for (Course course : courses) {
            int max = course.getMaxCapacity();
            ArrayList<Integer> credits = course.getCredits();
            ArrayList<Student> enrollstudent = course.getEnrollStudent();
            for (int v = 0; v < credits.size(); v++) {
                int d = 0;
                for (Integer credit : credits) {
                    if (credits.get(v) <= credit) {
                        d++;
                    }
                }
                if (d <= max) {
                    course.getSuccessStudents().add(enrollstudent.get(v));
                    enrollstudent.get(v).getSuccessCourses().add(course);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen) {
            int q=-1;
            for (Student value : students) {
                if (value.getStudentID().equals(student.getStudentID())) {
                    q = 0;
                    break;
                }
            }
            for (Course course : courses) {
                int c = course.getMaxCapacity();
                ArrayList<Student> A = new ArrayList<>();
                for (int j = 0; j < course.getCredits().size(); j++) {
                    int d = 0;
                    for (int k = 0; k < course.getEnrollStudent().size(); k++) {
                        if (course.getCredits().get(j) <= course.getCredits().get(k)) {
                            d++;
                        }
                    }
                    if (d <= c) {
                        A.add(course.getEnrollStudent().get(j));
                    }
                }
                course.getSuccessStudents().clear();
                course.setSuccessStudents(A);
            }
            for (Student value : students) {
                ArrayList<Course> C = new ArrayList<>();
                for (Course course : courses) {
                    if (course.getSuccessStudents().contains(value)) {
                        C.add(course);
                    }
                }
                value.getSuccessCourses().clear();
                value.setSuccessCourses(C);
            }
            return null;
        }

        return null;
    }

    }