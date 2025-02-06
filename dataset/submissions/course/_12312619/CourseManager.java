import java.util.*;

class CourseManager{
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;


    public CourseManager() {
        this.courses = new ArrayList<>(0);
        this.students = new ArrayList<>(0);
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
        if (!courses.contains(course)) {
            courses.add(course);
            course.setCourseManager(this);
        }
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.setCourseManager(this);
        }
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if(!ifOpen || credits<=0) return false;

        Course targetCourse = courses.stream()
                .filter(c -> c.getCourseID().equals(courseId))
                .findFirst()
                .orElse(null);
        if(targetCourse==null) return false;

        if(targetCourse.getEnrollStudent().contains(student)) return false;
        if(credits > student.getCredits()) return false;

        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(targetCourse);
        targetCourse.getEnrollStudent().add(student);
        targetCourse.getCredits().add(credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int newCredits) {
        if(!ifOpen) return false;

        Course targetCourse = courses.stream()
                .filter(c -> c.getCourseID().equals(courseId))
                .findFirst()
                .orElse(null);
        if(targetCourse==null) return false;

        int oldIndex = targetCourse.getEnrollStudent().indexOf(student);
        if(oldIndex == -1) return false;

        int oldCredits = targetCourse.getCredits().get(oldIndex);
        if(newCredits>student.getCredits()+oldCredits) return false;

        student.setCredits(student.getCredits() + oldCredits - newCredits);
        targetCourse.getCredits().set(oldIndex, newCredits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;

        Course targetCourse = courses.stream()
                .filter(c -> c.getCourseID().equals(courseId))
                .findFirst()
                .orElse(null);
        if(targetCourse==null) return false;

        int oldIndex = targetCourse.getEnrollStudent().indexOf(student);
        if(oldIndex == -1) return false;

        int oldCredits = targetCourse.getCredits().get(oldIndex);
        student.setCredits(student.getCredits() + oldCredits);
        student.getEnrollCourses().remove(targetCourse);
        targetCourse.getEnrollStudent().remove(student);
        targetCourse.getCredits().remove(oldIndex);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        for (Course c : courses) {

            ArrayList<Student> CourseAttender = c.getEnrollStudent();
            ArrayList<Integer> CourseCredits = c.getCredits();

            ArrayList<Integer> sortedCourseCredits = new ArrayList<>(CourseCredits); 
            Collections.sort(sortedCourseCredits, Collections.reverseOrder());

            int cut = 0;
            if (sortedCourseCredits.isEmpty()) continue;
            else if (c.getMaxCapacity() < CourseAttender.size()) cut = sortedCourseCredits.get(c.getMaxCapacity());
            else cut = 0;

            for (int i=0;i<CourseAttender.size();i++) {
                Student student = CourseAttender.get(i);
                Integer studentCredits = CourseCredits.get(i);
                if (studentCredits != null && studentCredits > cut) {
                    c.getSuccessStudents().add(student);
                    student.getSuccessCourses().add(c);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;

        ArrayList<String> result = new ArrayList<>(0);
        for (Course c : student.getEnrollCourses()) {
            int index = c.getEnrollStudent().indexOf(student);
            int credits = c.getCredits().get(index);
            result.add(c.getCourseID() + ": " + credits);
        }
        return result;
    }

}