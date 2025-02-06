import java.util.ArrayList;

class CourseManager {
    private ArrayList<Course> courses; 
    private ArrayList<Student> students; 
    private boolean ifOpen; 

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

//getter
    public ArrayList<Student> getStudents() {
        return students;
    }

//getter
    public ArrayList<Course> getCourses() {
        return courses;
    }

//setter
    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

//getter
    public boolean getIfOpen() {
        return ifOpen;
    }

    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager.
    // It is guaranteed that all courseIDs are unique.
    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    // Register a student. Add a student object to students and set the courseManager of the student object to this manager.
    // It is guaranteed that all studentIDs are unique.
    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

   
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen)
            return false;

        Course targetCourse = null;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                targetCourse = course;
                break;
            }
        }

        if (targetCourse == null || student.getEnrollCourses().contains(targetCourse) || credits <= 0 || student.getCredits() < credits)
            return false;

        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(targetCourse);
        targetCourse.getEnrollStudent().add(student);
        targetCourse.getCredits().add(credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen)
            return false;

        Course targetCourse = null;
        int index = -1;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                targetCourse = course;
                index = targetCourse.getEnrollStudent().indexOf(student);
                break;
            }
        }

        if (targetCourse == null || index == -1 || credits <= 0 || student.getCredits()+targetCourse.getCredits().get(index) < credits)
            return false;

        student.setCredits(student.getCredits() + targetCourse.getCredits().get(index) - credits);
        targetCourse.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen)
            return false;

        Course targetCourse = null;
        int index = -1;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                targetCourse = course;
                index = targetCourse.getEnrollStudent().indexOf(student);
                break;
            }
        }

        if (targetCourse == null || index == -1)
            return false;

        //int credits = targetCourse.getCredits().get(index);
        student.setCredits(student.getCredits() + targetCourse.getCredits().get(index));
        targetCourse.getEnrollStudent().remove(index);
        targetCourse.getCredits().remove(index);
        student.getEnrollCourses().remove(targetCourse);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        for (Course course : courses) {
            ArrayList<Student> studentsEnrolled = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();

            ArrayList<Integer> sortedIndices = new ArrayList<>();
            for (int i = 0; i < credits.size(); i++) {
                sortedIndices.add(i);
            }

            sortedIndices.sort((i, j) -> credits.get(j) - credits.get(i));
            ArrayList<Integer> sortedCredits = new ArrayList<>();
            for (int i = 0; i < sortedIndices.size(); i++) {
                sortedCredits.add(credits.get(sortedIndices.get(i)));
            }

            int enrollmentCount = 0;
            for (int i = 0; i < sortedCredits.size(); i++) {
                int currentBid = sortedCredits.get(i);
                int sameBidCount = 1;
                for (int j = i + 1; j < sortedCredits.size(); j++) {
                    int nextBid = sortedCredits.get(j);
                    if (nextBid == currentBid) {
                        sameBidCount++;
                    } else {
                        i = j-1;
                        break;
                    }
                }
                if (enrollmentCount + sameBidCount <= course.getMaxCapacity()) {
                    enrollmentCount += sameBidCount;
                } else {
                    break;
                }
            }

            for (int i = 0; i < enrollmentCount; i++) {
                Student enrolledStudent = studentsEnrolled.get(sortedIndices.get(i));
                course.getSuccessStudents().add(enrolledStudent);
                enrolledStudent.getSuccessCourses().add(course);
                enrolledStudent.getEnrollCourses().clear();
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }

        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        ArrayList<Course> enrollCourses = student.getEnrollCourses();

        for (Course course : enrollCourses) {
            String courseID = course.getCourseID();
            int enrollmentCredits = 0;
            ArrayList<Student> studentsEnrolled = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();

            int studentIndex = studentsEnrolled.indexOf(student);

            if (studentIndex != -1 && studentIndex < credits.size()) {
                enrollmentCredits = credits.get(studentIndex);
            }

            enrolledCoursesWithCredits.add(courseID + ": " + enrollmentCredits);
        }

        return enrolledCoursesWithCredits;
    }
}
