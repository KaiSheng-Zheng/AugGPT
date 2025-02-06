import java.util.ArrayList;
public class CourseManager {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private boolean ifOpen;

    public CourseManager() {
        ifOpen = false;
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean isEnrolled(Student student, String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course.getEnrollStudent().contains(student);
            }
        }
        return false;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }
        if (credits <= 0) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                return false;
            }
        }

        if (course == null) {
            return false;
        }

        if (student.getCredits() < credits) {
            return false;
        } else {
            student.setCredits(student.getCredits() - credits);
        }
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (course == null) {
            return false;
        }

        Course course1 = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                course1 = c;
            }
        }

        if (course1 == null) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                index = i;
                break;
            }
        }
        if (student.getCredits() + course.getCredits().get(index) - credits < 0) {
            return false;
        }
        int originalCredits = course.getCredits().get(index);
        course.getCredits().set(index, credits);
        student.setCredits(student.getCredits() + originalCredits - credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen)
            return false;

        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null)
            return false;

        int studentIndex = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                studentIndex = i;
                break;
            }
        }
        if (studentIndex == -1)
            return false;

        int Credits = course.getCredits().get(studentIndex);
        student.setCredits(student.getCredits() + Credits);
        course.getEnrollStudent().remove(studentIndex);
        course.getCredits().remove(studentIndex);
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                student.getEnrollCourses().remove(i);
                break;
            }
       }


        return true;
    }
    public void finalizeEnrollments() {
        setIfOpen(false);

        for (Course course : courses) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();
            ArrayList<Integer> enrolledCredits = course.getCredits();
            ArrayList<Student> successStudents = new ArrayList<>();

            int m = course.getMaxCapacity();
            int[] credits = new int[enrolledStudents.size()];
            for (int i = 0; i < enrolledStudents.size(); i++) {
                credits[i] = enrolledCredits.get(i);
            }


            for (int i = 0; i < credits.length -1; i++) {
                for (int j = 0; j < credits.length - i-1 ; j++) {
                    if (credits[j] < credits[j + 1]) {
                        int n = credits[j];
                        credits[j] = credits[j + 1];
                        credits[j + 1] = n;
                        Student S = enrolledStudents.get(j);
                        enrolledStudents.set(j, enrolledStudents.get(j + 1));
                        enrolledStudents.set(j + 1, S);
                    }
                }
            }


            for (int i = 0; i < m && i < enrolledStudents.size(); i++) {
                int min = Math.min(m, enrolledStudents.size());
                if (i ==m-1&& i < enrolledStudents.size()-1 && (credits[i] == credits[i + 1])) {
                  
                    break;

               }
              successStudents.add(enrolledStudents.get(i));

            }


            course.setSuccessStudents(successStudents);

            for (Student s : students) {
                if (successStudents.contains(s)) {

                    s.getSuccessCourses().add(course);
                } else {

                    int index = enrolledStudents.indexOf(s);
                    if (index != -1) {
                        s.setCredits(s.getCredits() + enrolledCredits.get(index));

                        s.getEnrollCourses().remove(course);
                    }
                }
            }
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }

        ArrayList<String> coursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            if (index != -1) {

                int bidCredits = course.getCredits().get(index);

                coursesWithCredits.add(course.getCourseID() + ": " + bidCredits);
            }
        }

        return coursesWithCredits;
    }
}