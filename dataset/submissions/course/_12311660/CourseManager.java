import java.util.ArrayList;


public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private boolean ifOpen = true; // System starts open by default

    public CourseManager() {
        this.ifOpen = getIfOpen();
        this.courses = getCourses();
        this.students = getStudents();
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return this.ifOpen;
    }

    public void addCourse(Course course) {
        course.setCourseManager(this);
        this.courses.add(course);
    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        this.students.add(student);
    }

    //    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
//        if (!ifOpen) return false;
//        Course course = findCourseById(courseId);
//        if (course == null || student.getCredits() < credits || credits <= 0 || student.getEnrollCourses().contains(course)) {
//            return false;
//        }
//        student.setCredits(student.getCredits() - credits);
//        student.getEnrollCourses().add(course);
//        course.getEnrollStudent().add(student);
//        course.getCredits().add(credits);
//        return true;
//    }
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen || credits <= 0) {
            return false;
        }
        Course course = findCourseById(courseId);
        if (course == null  || student.getCredits() < credits) {
            return false;
        }
        for (Course enrolledCourse : student.getEnrollCourses()) {
            if (enrolledCourse.getCourseID().equals(courseId)) {
                return false; // Student already enrolled in the course
            }
        }
        int remainingCredits = student.getCredits()  - credits;

        if (remainingCredits < 0) {
            // Don't allow modification if it results in negative credits
            return false;
        }

        student.setCredits(student.getCredits() - credits);
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        return true;

    }



    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int newCredits) {
        if (!ifOpen) {
            return false;
        }

        Course course = findCourseById(courseId);

        if (course == null) {
            return false;
        }
        for (Course enrolledCourse : student.getEnrollCourses()) {
            if (enrolledCourse.getCourseID().equals(courseId)) {
                int index = course.getEnrollStudent().indexOf(student);
                int currentCredits = course.getCredits().get(index);
                int remainingCredits = student.getCredits() + currentCredits - newCredits;

                if (remainingCredits < 0) {
                    // Don't allow modification if it results in negative credits
                    return false;
                }

                student.setCredits(remainingCredits);
                course.getCredits().set(index, newCredits);
                return true;
            }
        }
        return false;
    }




    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen ) {
            return false;
        }
        Course course = findCourseById(courseId);
        if (course == null ) {
            return false;
        }
        for (Course enrolledCourse : student.getEnrollCourses()) {
            if (enrolledCourse.getCourseID().equals(courseId)) {
                int index = course.getEnrollStudent().indexOf(student);
                int creditsToRefund = course.getCredits().get(index);

                student.setCredits(student.getCredits() + creditsToRefund);
                student.getEnrollCourses().remove(course);
                course.getEnrollStudent().remove(index);
                course.getCredits().remove(index);

                return true;
            }
        }
        return false;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;
        ArrayList<String> result = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            if (index != -1) {
                result.add(course.getCourseID() + ": " + course.getCredits().get(index));
            }
        }
        return result;
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public void finalizeEnrollments() {
        ifOpen = false;  // Close enrollments

        for (Course course : courses) {
            ArrayList<Student> enrollStudents = course.getEnrollStudent();
            ArrayList<Integer> bids = new ArrayList<>(course.getCredits());
            ArrayList<Student> successStudents = new ArrayList<>();

            // Sorting indices based on the bids in descending order
            ArrayList<Integer> indices = new ArrayList<>();
            for (int i = 0; i < bids.size(); i++) {
                indices.add(i);
            }
            indices.sort((i, j) -> bids.get(j).compareTo(bids.get(i)));

            int numberOfEnrollees = Math.min(course.getMaxCapacity(), bids.size());
            for (int i = 0; i < numberOfEnrollees; i++) {
                int index = indices.get(i);
                successStudents.add(enrollStudents.get(index));
            }

            // Check for ties at the cut-off point
            if (numberOfEnrollees < bids.size() && bids.get(indices.get(numberOfEnrollees - 1)).equals(bids.get(indices.get(numberOfEnrollees)))) {
                // We have a tie at the maximum capacity index, exclude all tied students at the end
                int tieBid = bids.get(indices.get(numberOfEnrollees - 1));
                successStudents.removeIf(student -> bids.get(enrollStudents.indexOf(student)) == tieBid);
            }

            course.setSuccessStudents(successStudents);  // Update the course with the list of successfully enrolled students

            // Update each successful student to add this course to their list of successful courses
            for (Student student : successStudents) {
                student.getSuccessCourses().add(course);
            }
        }
    }



}
