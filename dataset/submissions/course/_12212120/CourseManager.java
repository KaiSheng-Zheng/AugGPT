import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course>courses;
    private ArrayList<Student>students;
    private boolean ifOpen;
    public CourseManager()
    {
        this.courses=new ArrayList<Course>();
        this.students=new ArrayList<Student>();
        this.ifOpen=true;
    }
    public ArrayList<Student> getStudents()
    {
        return students;

    }
    public ArrayList<Course> getCourses()
    {
        return courses;
    }
    public void setIfOpen(Boolean ifOpen)
    {
        this.ifOpen=ifOpen;


    }
    public boolean getIfOpen()
    {
        return ifOpen;
    }
    public void addCourse(Course course)
    {
        courses.add(course);
        course.setCourseManager(this);
    }
    public void addStudent(Student student)
    {
        students.add(student);
        student.setCourseManager(this);

    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) return false;

        Course course = findCourseById(courseId);
        if (course == null || student.getEnrollCourses().contains(course) || credits <= 0) return false;

        int totalCredits = student.getCredits();
        if (totalCredits < credits) return false;

        ArrayList<Student> enrolledStudents = course.getEnrollStudent();
        ArrayList<Integer> bidCredits = course.getCredits();


        enrolledStudents.add(student);
        bidCredits.add(credits);

        student.getEnrollCourses().add(course);
        student.setCredits(totalCredits - credits);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;

        Course course = findCourseById(courseId);
        if (course == null || !student.getEnrollCourses().contains(course)) return false;

        ArrayList<Student> enrolledStudents = course.getEnrollStudent();
        ArrayList<Integer> bidCredits = course.getCredits();

        int index = enrolledStudents.indexOf(student);
        if (index == -1) return false;

        int oldCredits = bidCredits.get(index);
        int totalCredits = student.getCredits() + oldCredits;

        if (totalCredits < credits||totalCredits<=0||credits<0) return false;

        bidCredits.set(index, credits);
        student.setCredits(student.getCredits() - credits + oldCredits);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;

        Course course = findCourseById(courseId);
        if (course == null || !student.getEnrollCourses().contains(course)) return false;

        ArrayList<Student> enrolledStudents = course.getEnrollStudent();
        ArrayList<Integer> bidCredits = course.getCredits();

        int index = enrolledStudents.indexOf(student);
        if (index == -1) return false;

        int creditsRefunded = bidCredits.get(index);
        student.setCredits(student.getCredits() + creditsRefunded);

        enrolledStudents.remove(index);
        bidCredits.remove(index);
        student.getEnrollCourses().remove(course);

        return true;
    }

    public void finalizeEnrollments() {
        ifOpen=false;
        for (Course course : courses) {
            if (!ifOpen) {
                int MaxIndex = Math.min(course.getMaxCapacity(),course.getEnrollStudent().size());
                for (int i = 0; i < course.getEnrollStudent().size()-1; i++) {
                    for (int j = 0; j < course.getEnrollStudent().size() - i - 1; j++) {
                        if (course.getCredits().get(j) < course.getCredits().get(j + 1)) {
                            int Index1 = course.getCredits().get(j);
                            Student Index2=course.getEnrollStudent().get(j);
                            course.getEnrollStudent().set(j,course.getEnrollStudent().get(j+1));
                            course.getEnrollStudent().set(j+1,Index2);
                            course.getCredits().set(j,course.getCredits().get(j + 1));
                            course.getCredits().set(j + 1,  Index1);
                        }
                    }
                }
                if (course.getEnrollStudent().size()<=course.getMaxCapacity()){
                    for (int i = 0; i < MaxIndex; i++) {
                        course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                        course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                    }
                }
                else{
                    int lastSuccessfulCredit = course.getCredits().get(course.getMaxCapacity());
                    System.out.println(lastSuccessfulCredit);
                    int lastSameCreditIndex = MaxIndex-1 ;
                    while (course.getCredits().get(lastSameCreditIndex) == lastSuccessfulCredit ) {
                        MaxIndex--;
                        lastSameCreditIndex--;
                    }
                    for (int i = 0; i <MaxIndex; i++) {
                        course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                        course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                    }
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;

        ArrayList<String> enrolledCourses = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();
            ArrayList<Integer> bidCredits = course.getCredits();
            int index = enrolledStudents.indexOf(student);
            if (index != -1) {
                enrolledCourses.add(course.getCourseID() + ": " + bidCredits.get(index));
            }
        }
        return enrolledCourses;
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }


}