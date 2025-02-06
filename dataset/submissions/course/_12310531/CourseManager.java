import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    
    public CourseManager() {  
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }


    
    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public Course findCourse(String courseId) {  
        for (Course course : courses) {  
            if (course.getCourseID().equals(courseId)) {
                return course;  
            }
        }
        return null;  
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }

        Course course = findCourse(courseId);
        if (course == null
                || course.getEnrollStudent().contains(student)
                || credits <= 0
                || credits > student.getCredits()
        ) {  
            return false;
        }
        student.setCredits(student.getCredits() - credits);

        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }

        Course course = findCourse(courseId);
        if (course == null) {
            return false;
        }
        int index = course.getEnrollStudent().indexOf(student);
        
        if (!student.getEnrollCourses().contains(course) || credits <= 0 || credits > student.getCredits() + course.getCredits().get(index)) {
            return false;
        }
        student.setCredits(student.getCredits() + course.getCredits().get(index) - credits);

        course.getCredits().set(index, credits);  
        
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }

        Course course = findCourse(courseId);
        if (course == null || !student.getEnrollCourses().contains(course)) {
            return false;
        }


        int index = course.getEnrollStudent().indexOf(student);
        student.setCredits(student.getCredits() + course.getCredits().get(index));
        
        course.getCredits().remove(index);
        course.getEnrollStudent().remove(student);
        student.getEnrollCourses().remove(course);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        
        for (Course course : courses) {
            int n = course.getCredits().size();

           
            for (int i = 0; i < n - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (course.getCredits().get(j) > course.getCredits().get(maxIndex)) {
                        maxIndex = j;
                    }
                }

                
                int tempCredit = course.getCredits().get(maxIndex);
                course.getCredits().set(maxIndex, course.getCredits().get(i));
                course.getCredits().set(i, tempCredit);

                
                Student tempStudent = course.getEnrollStudent().get(maxIndex);
                course.getEnrollStudent().set(maxIndex, course.getEnrollStudent().get(i));
                course.getEnrollStudent().set(i, tempStudent);
            }

            int index = course.getMaxCapacity();
            course.setSuccessStudents(course.getEnrollStudent());

            for (Student student : course.getEnrollStudent()) {
                student.setSuccessCourses(student.getEnrollCourses());
            }

            
            if (index < course.getCredits().size()) {
                if (course.getCredits().get(index - 1).equals(course.getCredits().get(index))) {  
                    for (int i = index; i >= 0; i--) {
                        if (!course.getCredits().get(i - 1).equals(course.getCredits().get(i - 2))) {
                            
                            for (Student student : course.getEnrollStudent().subList(i - 1, course.getEnrollStudent().size())) {
                                student.getSuccessCourses().remove(course);
                            }
                            course.getSuccessStudents().subList(i - 1, course.getEnrollStudent().size()).clear();
                            break;
                        }
                    }
                } else {  
                    
                    for (Student student : course.getEnrollStudent().subList(index, course.getEnrollStudent().size())) {
                        student.getSuccessCourses().remove(course);
                    }
                    course.getSuccessStudents().subList(index, course.getEnrollStudent().size()).clear();
                }
            }
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }

        ArrayList<String> enrolledCourses = new ArrayList<>();

        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            int credits = course.getCredits().get(index);
            enrolledCourses.add(course.getCourseID() + ": " + credits);
        }

        return enrolledCourses;
    }
}