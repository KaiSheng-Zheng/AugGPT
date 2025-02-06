import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private int maxCapacity;
    public int findstudentsINDEX(ArrayList<Student> S,Student student) {
        int index=-1;
        for (int j = 0; j < S.size(); j++) {
            if (S.get(j).equals(student)) {
                index=j;
            }
        }
        return index;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    private boolean ifOpen;


    public CourseManager() {
// Constructor, initializes the course and student lists,
// and set the system default status open(true).
        students = new ArrayList<Student>();
        courses = new ArrayList<Course>();
        setIfOpen(true);
    }

    public void addStudent(Student a) {
        boolean b=true;
        for(Student S: students) {
            if(S.getStudentID().equals(a.getStudentID())){
                b=false;
            }}
        if(b){if(a.getCredits()>0){
        students.add(a);
        a.setCourseManager(this);}}
    }

    public void addCourse(Course a) {
        // Register a course. Add a course object to courses and set the courseManager of the course object to this manager.
        // It is guaranteed that all courseIDs are unique.
        boolean b=true;
        for(Course C: courses) {
            if(C.getCourseID().equals(a.getCourseID())){
                b=false;
            }}
        if(b){
        courses.add(a);
        a.setCourseManager(this);}
    }

    public void finalizeEnrollments() {
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Integer> A=new ArrayList<Integer>();
            ArrayList<Student> SA=new ArrayList<Student>();
            Course thiscourse = courses.get(i);
            ArrayList<Student> studentbia = courses.get(i).getEnrollStudent();
            ArrayList<Integer> criditbia = thiscourse.getCredits();
            ArrayList<Integer> criditbia2 = new ArrayList<>();
            for (int j = 0; j < criditbia.size(); j++) {
                criditbia2.add(criditbia.get(j));
            }
            Collections.sort(criditbia2);
            Collections.reverse(criditbia2);
            int keyint = 0;
            //boolean whetheroutof=
            int maxcapacity = thiscourse.getMaxCapacity();
            if (studentbia.size() > maxcapacity) {
                keyint = criditbia2.get(maxcapacity - 1);
                if (criditbia2.get(maxcapacity) == keyint) {
                    keyint += 1;
                }
            }
            criditbia = thiscourse.getCredits();
            for (int j = 0; j < studentbia.size(); j++) {
                if (criditbia.get(j) < keyint) {
                    A.add(j);
                    SA.add(studentbia.get(j));
                } else {//success
                    ArrayList<Student> S1 = thiscourse.getSuccessStudents();
                    S1.add(studentbia.get(j));
                    ArrayList<Course> C1 = courses.get(i).getEnrollStudent().get(j).getSuccessCourses();
                    C1.add(courses.get(i));
                }

            }
            for (int j = 0; j < SA.size(); j++) {
                dropStudentEnrollmentCourse(SA.get(j), thiscourse.getCourseID());
            }
        }
        ifOpen = false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen == false|| credits <= 0){
            return false;
        } else {
            boolean q = false;
            for (int i = 0; i < courses.size(); i++) {
                Course a = courses.get(i);
                ArrayList<Student> S = a.getEnrollStudent();
                if (a.getCourseID().equals(courseId)) {
                    for(int j = 0; j < S.size(); j++) {
                        if (S.get(j).equals(student)) {
                            ArrayList<Integer> C = courses.get(i).getCredits();
                            int evercredits = C.get(j);
                            if (evercredits + student.getCredits() >= credits) {
                                student.setCredits(student.getCredits() + evercredits - credits);
                                C.set(j, credits);
                                q = true;
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            return q;
        }
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen) {
            int j = 0;
            boolean condition0=false;
            for(int i = 0; i < students.size(); i++) {
                if(students.get(i).equals(student)){
                    condition0=true;
                    break;
                }
            }
            boolean condition1 = false;
            for (int i = 0; i < courses.size(); i++) {
                String Courseexistid = courses.get(i).getCourseID();
                if (Courseexistid.equals(courseId)) {
                    condition1 = true;
                    j = i;
                    break;
                }
            }
            boolean condition2 = true;
            for (Course a : student.getEnrollCourses()) {
                String Courseexistid = a.getCourseID();
                if (Courseexistid.equals(courseId)) {
                    condition2 = false;
                    break;
                }
            }
            boolean condition3;
            if (credits > 0 && credits <= student.getCredits()) {
                condition3 = true;
            } else {
                condition3 = false;
            }
            if (condition1 && condition2 && condition3&& condition0) {
                Course a = courses.get(j);
                ArrayList<Student> S = a.getEnrollStudent();
                S.add(student);
                ArrayList<Integer> G = a.getCredits();
                G.add(credits);
                student.setCredits(student.getCredits() - credits);
                ArrayList<Course> A = student.getEnrollCourses();
                A.add(a);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if(ifOpen==true){
            ArrayList<Course> coursebia = student.getEnrollCourses();
        Course thiscourse = null;
        boolean b = false;
        for(int i = 0; i <courses.size(); i++){
            Course a=courses.get(i);
            if (courseId.equals(a.getCourseID())) {
                thiscourse = a;
                ArrayList<Student> S = courses.get(i).getEnrollStudent();
                int index=findstudentsINDEX(S,student);
                if(index!=-1) {
                    int credit = 0;
                    credit = thiscourse.getCredits().get(index);
                    ArrayList<Student> SUCCESSSTUDENTS = thiscourse.getSuccessStudents();
                    S.remove(student);
                    SUCCESSSTUDENTS.remove(student);
                    ArrayList<Course> C = student.getEnrollCourses();
                    C.remove(thiscourse);
                    student.setEnrollCourses(C);
                    student.setCredits(student.getCredits() + credit);
                    b = true;
                    ArrayList<Integer> CR=thiscourse.getCredits();
                    CR.remove(index);
                    break;

                }
            }
        }
        return b;}
        else{return false;}
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        int crdit = 0;
        ArrayList<String> courseswithcredits = new ArrayList<String>();
        if (ifOpen == false) {
            return null;
        } else {
            for (Course c : student.getEnrollCourses()) {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    if (c.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        crdit = c.getCredits().get(i);
                        String A = c.getCourseID() + ": " + Integer.toString(crdit);
                        courseswithcredits.add(A);
                        break;
                    }
                }

            }
            return courseswithcredits;
        }
    }
}