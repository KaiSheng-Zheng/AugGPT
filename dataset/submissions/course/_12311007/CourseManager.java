import java.util.ArrayList;


public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (credits <= 0) {
            return false;
        }
        if (!getIfOpen() || student.getCredits() <= 0 || student.getCredits() - credits < 0) {
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
        Student s = null;
        for (Student c : students) {
            if (c == student) {
                s = c;
                break;
            }
        }
        if (s == null) {
            return false;
        } else {
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(course);
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            return true;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!getIfOpen()) {
            return false;
        }
        if (credits <= 0 || student.getCredits() <= 0) {
            return false;
        }
        Course course = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        Student s = null;
        int index = -1;
        for (Student c : course.getEnrollStudent()) {
            if (c == student) {
                s = c;
                index = course.getEnrollStudent().indexOf(student);
                break;
            }
        }
        if (s == null) {
            return false;
        }
        int newCredits = student.getCredits() + course.getCredits().get(index) - credits;
        if (newCredits < 0) {
            return false;
        } else {
            student.setCredits(newCredits);
            course.getCredits().set(index, credits);
            return true;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!getIfOpen()) {
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
        int instance = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i) == course) {
                instance = i;
                break;
            }
        }
        if (instance == -1) {
            return false;
        }
        Student s = null;
        int index = -1;
        for (Student c : course.getEnrollStudent()) {
            if (c == student) {
                s = c;
                index = course.getEnrollStudent().indexOf(student);
                break;
            }
        }
        if (s == null) {
            return false;
        } else {
            student.setCredits(student.getCredits() + course.getCredits().get(index));
            student.getEnrollCourses().remove(course);
            course.getEnrollStudent().remove(student);
            course.getCredits().remove(index);
            return true;
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!getIfOpen()) {
            return null;
        } else {
            ArrayList<String> studentCourseWithCredits = new ArrayList<>();
            for (int i = 0; i < courses.size(); i++) {
                for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                    if (student == courses.get(i).getEnrollStudent().get(j)) {
                        studentCourseWithCredits.add(courses.get(i).getCourseID() + ": " + courses.get(i).getCredits().get(j));
                        break;
                    }
                }
            }
            return studentCourseWithCredits;
        }
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course.getEnrollStudent().isEmpty()) {
                continue;
            }
            if (course.getEnrollStudent().size() <= course.getMaxCapacity()) {
                course.setSuccessStudents(course.getEnrollStudent());
                for (int j = 0; j < students.size(); j++) {
                    Student student = students.get(j);
                    if (student.getEnrollCourses().isEmpty()) {
                        continue;
                    }
                    student.setSuccessCourses(student.getEnrollCourses());
                    for (int k = 0; k < student.getEnrollCourses().size(); k++) {
                        if (!course.getSuccessStudents().contains(student)) {
                            student.getSuccessCourses().remove(course);
                        }
                    }
                }
            } else {
                for (int j = 0; j < course.getCredits().size() - 1; j++) {
                    for (int k = 0; k < course.getCredits().size() - 1; k++) {
                        if (course.getCredits().get(k) < course.getCredits().get(k + 1)) {
                            int instance11 = course.getCredits().get(k);
                            Student instance12 = course.getEnrollStudent().get(k);
                            int instance21 = course.getCredits().get(k + 1);
                            Student instance22 = course.getEnrollStudent().get(k + 1);
                            course.getCredits().set(k, instance21);
                            course.getEnrollStudent().set(k, instance22);
                            course.getCredits().set(k + 1, instance11);
                            course.getEnrollStudent().set(k + 1, instance12);
                        }
                    }
                }
                int index = -1;
                // will fail when course.getMaxCapacity() = 1.
                int maxCapacity = course.getMaxCapacity() - 1;
                int creditsLine = course.getCredits().get(maxCapacity);
                if (course.getCredits().get(maxCapacity - 1) == creditsLine) {
                    if (course.getCredits().get(maxCapacity + 1) == creditsLine) {
                        for (int j = 0; j < course.getCredits().size(); j++) {
                            if (course.getCredits().get(j) == creditsLine) {
                                index = j;
                                break;
                            }
                        }
                        for (int j = index; j < course.getCredits().size(); j++) {
                            course.getCredits().remove(j);
                            course.getEnrollStudent().remove(j);
                            j--;
                        }
                    }
                    else if (course.getCredits().get(maxCapacity+1)!=creditsLine){
                        for (int j = maxCapacity+1; j <course.getCredits().size() ; j++) {
                            course.getCredits().remove(j);
                            course.getEnrollStudent().remove(j);
                            j--;
                        }
                    }
                } else if (course.getCredits().get(maxCapacity - 1) !=creditsLine) {
                    if (course.getCredits().get(maxCapacity+1)==creditsLine){
                        for (int j = maxCapacity; j <course.getCredits().size() ; j++) {
                            course.getCredits().remove(j);
                            course.getEnrollStudent().remove(j);
                            j--;
                        }
                    }
                    else if (course.getCredits().get(maxCapacity+1)!=creditsLine){
                        for (int j = maxCapacity+1; j <course.getCredits().size() ; j++) {
                            course.getCredits().remove(j);
                            course.getEnrollStudent().remove(j);
                            j--;
                        }
                    }
                }
                course.setSuccessStudents(course.getEnrollStudent());
                for (int j = 0; j < students.size(); j++) {
                    Student student = students.get(j);
                    if (student.getEnrollCourses().isEmpty()) {
                        continue;
                    }
                    student.setSuccessCourses(student.getEnrollCourses());
                    for (int k = 0; k < student.getEnrollCourses().size(); k++) {
                        if (!course.getSuccessStudents().contains(student)) {
                            student.getSuccessCourses().remove(course);
                        }
                    }
                }
            }
        }
    }
}