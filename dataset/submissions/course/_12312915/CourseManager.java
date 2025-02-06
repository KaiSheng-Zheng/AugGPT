import java.util.ArrayList;

public class CourseManager{
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Integer> EnrollCredits = new ArrayList<>();
    private ArrayList<Student> EnrollStudent = new ArrayList<>();

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

    public void setIfOpen(Boolean ifOpen){
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

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){
        int a=-1 , b=-1 , c=-1 , d=-1 , e=0;

        if(ifOpen) {
            ArrayList<Course> m;
            m = student.getEnrollCourses();
            for (int i = 0; i < m.size(); i++) {
                if(courseId.equals(m.get(i).getCourseID())){
                    e = 1;
                    break;
                }
            }
            if(e == 0) {
                for (int i = 0; i < students.size(); i++) {
                    if (student.getStudentID().equals(students.get(i).getStudentID())) {
                        a = i;
                        break;
                    }
                }

                for (int i = 0; i < courses.size(); i++) {
                    if (courseId.equals(courses.get(i).getCourseID())) {
                        b = i;
                        break;
                    }
                }

                //System.out.println(student.getCredits());

                if (student.getCredits() >= credits && credits > 0) {
                    //c = credits;
                    d = student.getCredits() - credits;
                }

                if (a != -1 && b != -1 && d != -1) {
                    m.add(courses.get(b));
                    EnrollStudent = courses.get(b).getEnrollStudent();
                    EnrollStudent.add(student);
                    EnrollCredits = courses.get(b).getCredits();
                    EnrollCredits.add(credits);
                    student.setEnrollCourses(m);
                    courses.get(b).setEnrollStudent(EnrollStudent);
                    courses.get(b).setCredits(EnrollCredits);
                    student.setCredits(d);
                    return true;
                } else {
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if(ifOpen) {

            int a=-1 , b=-1 , c=-1 , d=-1;

            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {
                    b = i;
                    break;
                }
            }

            if(b != -1 && credits > 0) {
                EnrollCredits = courses.get(b).getCredits();

                //System.out.println(EnrollCredits.get(1));

                //System.out.println(courses.get(b).getCredits().get(1));
                for (int i = 0; i < courses.get(b).getEnrollStudent().size(); i++) {
                    if (student.getStudentID().equals(courses.get(b).getEnrollStudent().get(i).getStudentID())) {
                        a = i;
                        //System.out.println(a);
                        d = courses.get(b).getEnrollStudent().get(a).getCredits() + EnrollCredits.get(a);
                        //System.out.println(d);
                        //System.out.println(courses.get(b).getEnrollStudent().get(i).getStudentID());
                        //System.out.println(EnrollCredits.get(a));
                        //System.out.println(courses.get(b).getCredits().get(a));
                        //System.out.println(students.get(a).getCredits());
                        break;
                    }
                }

                if (a != -1 && b != -1 && d >= credits) {
                    courses.get(b).getEnrollStudent().get(a).setCredits(d);
                    c = courses.get(b).getEnrollStudent().get(a).getCredits();
                    //System.out.println(c);
                    EnrollCredits.remove(a);
                    EnrollCredits.add(a, credits);
                    courses.get(b).setCredits(EnrollCredits);
                    courses.get(b).getEnrollStudent().get(a).setCredits(c - credits);
                    //System.out.println(courses.get(b).getEnrollStudent().get(a).getStudentID() + " " + courses.get(b).getEnrollStudent().get(a).getCredits());
                    return true;
                } else {
                    return false;
                }
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
        if(ifOpen){
            int a=0 , b=0 , c=0;
            ArrayList<Course> m = null;
            m = student.getEnrollCourses();
            Course n = null;
            for (int i = 0; i < students.size(); i++) {
                if (student.getStudentID().equals(students.get(i).getStudentID())) {
                    a = i;
                    break;
                }
            }
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {
                    b = i;
                    n = courses.get(i);
                    break;
                }
            }
            if(student.getEnrollCourses().contains(n)){
                for (int i = 0; i < m.size(); i++) {
                    if(m.get(i).getCourseID().equals(courseId)){
                        m.remove(i);
                        break;
                    }
                }
                student.setEnrollCourses(m);
                for (int i = courses.get(b).getEnrollStudent().size()-1; i >= 0; i--) {
                    if(student.equals(courses.get(b).getEnrollStudent().get(i))){
                        //System.out.println(courses.get(b).getEnrollStudent().get(i).getStudentID());
                        //System.out.println(courses.get(b).getCredits().get(i));
                        EnrollCredits = courses.get(b).getCredits();
                        c = EnrollCredits.get(i);
                        //System.out.println(c);
                        EnrollCredits.remove(i);
                        EnrollStudent = courses.get(b).getEnrollStudent();
                        EnrollStudent.remove(i);
                        courses.get(b).setCredits(EnrollCredits);
                        courses.get(b).setEnrollStudent(EnrollStudent);
                    }
                }
                students.get(a).setCredits(this.students.get(a).getCredits() + c);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void finalizeEnrollments(){
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            EnrollCredits = courses.get(i).getCredits();
            EnrollStudent = courses.get(i).getEnrollStudent();
            if(EnrollCredits != null && EnrollCredits.size() > 1) {
                int cre;
                Student stu;
                for (int j = EnrollCredits.size() - 1; j >= 0; j--) {
                    for (int k = EnrollCredits.size() - 1; k > 0; k--) {
                        if (EnrollCredits.get(k - 1) < EnrollCredits.get(k)) {
                            cre = EnrollCredits.get(k - 1);
                            EnrollCredits.remove(k - 1);
                            EnrollCredits.add(k, cre);
                            stu = EnrollStudent.get(k - 1);
                            EnrollStudent.remove(k - 1);
                            EnrollStudent.add(k, stu);
                        }
                    }
                }
                //sort

                courses.get(i).setCredits(EnrollCredits);
                courses.get(i).setEnrollStudent(EnrollStudent);
                int[] a = new int[EnrollCredits.size() + 1];
                int s = 0;
                //System.out.println(s);
                for (int j = 0; j < EnrollCredits.size(); j++) {
                    a[s]++;
                    //System.out.println(s + " " + a[s]);
                    if (j + 1 < EnrollCredits.size() && EnrollCredits.get(j) > EnrollCredits.get(j + 1)) {
                        s++;
                    }
                }
                s++;
                int n = 0;
                if (s >= 1 && a[0] != 0) {
                    for (int j = 0; j < s; j++) {
                        if (n <= courses.get(i).getMaxCapacity() && n + a[j] > courses.get(i).getMaxCapacity()) {
                            break;
                        } else {
                            n += a[j];
                        }
                    }
                    //System.out.println(n);
                    for (int j = 0; j < n; j++) {
                        ArrayList<Course> m = EnrollStudent.get(j).getSuccessCourses();
                        m.add(courses.get(i));
                        EnrollStudent.get(j).setSuccessCourses(m);
                    }
                    //students = EnrollStudent;
                    for (int j = n; j < EnrollStudent.size(); j++) {
                        int g;
                        g = EnrollStudent.get(j).getCredits();
                        g = g + EnrollCredits.get(j);
                        //EnrollStudent.get(j).setCredits(g);
                        //students.get(j).dropEnrollCourse(courses.get(i).getCourseID());
                        for (int k = 0; k < EnrollStudent.get(j).getEnrollCourses().size(); k++) {
                            //System.out.println(EnrollStudent.get(j).getStudentID());
                            if(EnrollStudent.get(j).getEnrollCourses().get(k).getCourseID().equals(courses.get(i).getCourseID())){
                                ArrayList<Course> q = EnrollStudent.get(j).getEnrollCourses();
                                q.remove(k);
                                EnrollStudent.get(j).setEnrollCourses(q);
                                break;
                            }
                        }
                        EnrollStudent.remove(j);
                        EnrollCredits.remove(j);
                        j--;
                    }
                    courses.get(i).setSuccessStudents(EnrollStudent);
                    courses.get(i).setCredits(EnrollCredits);
                    courses.get(i).setEnrollStudent(EnrollStudent);
                }
            } else if (EnrollCredits != null && EnrollCredits.size() == 1) {
                ArrayList<Course> m = EnrollStudent.get(0).getSuccessCourses();
                m.add(courses.get(i));
                EnrollStudent.get(0).setSuccessCourses(m);
                courses.get(i).setSuccessStudents(EnrollStudent);
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(ifOpen) {
            ArrayList<String> m = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int b = 0;
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if (student.getStudentID().equals(student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID())) {
                        b = student.getEnrollCourses().get(i).getCredits().get(j);
                    }
                }
                m.add(student.getEnrollCourses().get(i).getCourseID() + ": " + b);
            }
            return m;
        }else{
            return null;
        }
    }
}