import java.util.ArrayList;

class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public CourseManager(){
        setIfOpen(true);
        courses= new ArrayList<>();
        students= new ArrayList<>();
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
        if (!isIfOpen()){return false;}
        if (student.getCredits()<credits){return false;}
        if (credits<=0){return false;}
        Course c = findCourse(courseId);
        if (!getCourses().contains(c)){return false;}
        if (student.getEnrollCourses().contains(c)){return false;}
        else {
            int currentCredits = student.getCredits();
            student.setCredits(currentCredits-credits);
        c.getCredits().add(credits);
        c.setCredits(c.getCredits());
        student.getEnrollCourses().add(c);
        student.setEnrollCourses(student.getEnrollCourses());
        c.getEnrollStudent().add(student);
        c.setEnrollStudent(c.getEnrollStudent());
        return true;}
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){
        if (!isIfOpen()){return false;}
        Course c = findCourse(courseId);
        if (!getCourses().contains(c)){return false;}
        if (!student.getEnrollCourses().contains(c)){return false;}
        int index = c.getEnrollStudent().indexOf(student);
        int initialCredit = c.getCredits().get(index);
        if (student.getCredits()+initialCredit<credits){return false;}
        else {
            int currentCredits = student.getCredits();
            student.setCredits(currentCredits + initialCredit - credits);
            setCourse(c.getCredits(),c,student,credits);
            return true;
        }
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){

        if (!isIfOpen()){return false;}
        Course c = findCourse(courseId);
        if (c == null){return false;}
        if (!getCourses().contains(c)){return false;}
        int studentIndex = c.getEnrollStudent().indexOf(student);
        if (studentIndex == -1){return false;}
        int bidCredit = c.getCredits().get(studentIndex);
        int studentCredit = student.getCredits();
        student.setCredits(studentCredit + bidCredit);
        dropCourse(c, student);
        return true;

    }
    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course c : courses) {
            String[][] arrange = new String[c.getEnrollStudent().size()][2];
            while(!c.getEnrollStudent().isEmpty()) {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    String string = c.getEnrollStudent().get(i).getStudentID();
                    arrange[i][0] = string;
                    arrange[i][1] = String.valueOf(c.getCredits().get(i));
                }
                for (int j = 0; j < arrange.length; j++) {
                    for (int k = j+1; k < arrange.length  ; k++) {
                        String a = arrange[j][1];
                        String b = arrange[j][0];
                        int p = Integer.parseInt(arrange[j][1]);
                        int q = Integer.parseInt(arrange[k][1]);
                        if (p < q) {
                            arrange[j][1] = arrange[k][1];
                            arrange[j][0] = arrange[k][0];
                            arrange[k][1] = a;
                            arrange[k][0] = b;
                    }
                    }





                }
                if (arrange.length<c.getMaxCapacity()){
                    for (int i = 0; i < arrange.length; i++) {
                        c.getSuccessStudents().add(findStudent(arrange[i][0]));
                        c.setSuccessStudents(c.getSuccessStudents());
                        findStudent(arrange[i][0]).getSuccessCourses().add(c);
                        findStudent(arrange[i][0]).setSuccessCourses(findStudent(arrange[i][0]).getSuccessCourses());
                    }
                    break;
                }
                else {
                int minimumCredit = Integer.parseInt(arrange[c.getMaxCapacity() - 1][1]);
                for (String[] str : arrange) {
                    if (Integer.parseInt(str[1]) >= minimumCredit) {
                        c.getSuccessStudents().add(findStudent(str[0]));
                        c.setSuccessStudents(c.getSuccessStudents());
                        findStudent(str[0]).getSuccessCourses().add(c);
                        findStudent(str[0]).setSuccessCourses(findStudent(str[0]).getSuccessCourses());
                    } else {
                        continue;
                    }
                }
                break;}
            }
            if (c.getSuccessStudents().size() > c.getMaxCapacity()){
                String lastStudentCredit = arrange[c.getSuccessStudents().size()-1][1];
                int lastStudent=Integer.parseInt(lastStudentCredit);
                for (int i = c.getSuccessStudents().size()-1; i >= 0; i--) {
                    if (arrange[i][1].equals(lastStudentCredit)){
                        c.getSuccessStudents().remove(i);
                        c.setSuccessStudents(c.getSuccessStudents());
                        findStudent(arrange[i][0]).getSuccessCourses().remove(c);
                        findStudent(arrange[i][0]).setSuccessCourses(findStudent(arrange[i][0]).getSuccessCourses());
                    }
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        ArrayList<String> courseWithCredit = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course c = student.getEnrollCourses().get(i);
            int index = c.getEnrollStudent().indexOf(student);
            int credit = student.getEnrollCourses().get(i).getCredits().get(index);
            String add = c.getCourseID()+": "+credit;
            courseWithCredit.add(add);
        }
        return courseWithCredit;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean isIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {
        return ifOpen;
    }
    public Course findCourse(String courseID){
        Course a = null;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                a = course;
                break;
            }
        }
        return a;
    }
    public Student findStudent(String studentID) {
        Student a = null;
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                a = student;
                break;
            }
        }
        return a;
    }
    public void dropCourse(Course c , Student student){
        int index = c.getEnrollStudent().indexOf(student);
        c.getCredits().remove(index);
        c.setCredits(c.getCredits());
        c.getEnrollStudent().remove(index);
        c.setEnrollStudent(c.getEnrollStudent());
        student.getEnrollCourses().remove(c);
        student.setEnrollCourses(student.getEnrollCourses());
    }
    public void setCourse(ArrayList<Integer> credits,Course c, Student student,int credit){
        int index = c.getEnrollStudent().indexOf(student);
        credits.set(index,credit);
    }
}