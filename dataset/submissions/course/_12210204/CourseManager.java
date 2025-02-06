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
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

//    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
//        if (!ifOpen) return false;
//        Course course = null;
//        for (Course c : courses) {
//            if (c.getCourseID().equals(courseId)) {
//                course = c;
//                break;
//            }
//        }
//        if (course == null) return false;
//        if (student.getEnrollCourses().contains(course)) return false;
//        if (student.getCredits() < credits) return false;
//        // If course is full, check if student's bid is higher than the lowest bid
//        if (course.getEnrollStudent().size() >= course.getMaxCapacity()) {
//            int lowestBidIndex = -1;
//            int lowestBid= Integer.MAX_VALUE;
//            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
//                if (course.getCredits().get(i) < lowestBid) {
//                    lowestBid = course.getCredits().get(i);
//                    lowestBidIndex = i;
//                }
//            }
//            if (credits <= lowestBid) return false; // Bid is not higher than the lowest bid
//            // Refund credits to student with lowest bid
//            Student lowestBidStudent = course.getEnrollStudent().get(lowestBidIndex);
//            lowestBidStudent.setCredits(lowestBidStudent.getCredits() + lowestBid);
//            // Remove student with lowest bid from enrollment
//            course.getEnrollStudent().remove(lowestBidIndex);
//            course.getCredits().remove(lowestBidIndex);
//            lowestBidStudent.getEnrollCourses().remove(course);
//        }
//
//        // Enroll student in course
//        course.getEnrollStudent().add(student);
//        course.getCredits().add(credits);
//        student.getEnrollCourses().add(course);
//        student.setCredits(student.getCredits() - credits);
//
//        return true;
//    }
public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
    if (!ifOpen) return false;
    Course course = null;
    for (Course c : courses) {
        if (c.getCourseID().equals(courseId)) {
            course = c;
            break;
        }
    }
    if (course == null) return false;
    if (student.getEnrollCourses().contains(course)) return false;
    if (student.getCredits() < credits) return false;


    if (course.getEnrollStudent().size() >= course.getMaxCapacity()) {

        int lowestBid = Integer.MAX_VALUE;
        Student lowestBidStudent = null;
        for (int i = 0; i < course.getCredits().size(); i++) {
            if (course.getCredits().get(i) < lowestBid) {
                lowestBid = course.getCredits().get(i);
                lowestBidStudent = course.getEnrollStudent().get(i);
            }
        }

        if (credits <= lowestBid) return false;

        lowestBidStudent.setCredits(lowestBidStudent.getCredits() + lowestBid);
        course.getEnrollStudent().remove(lowestBidStudent);
        course.getCredits().remove((Integer) lowestBid);
        lowestBidStudent.getEnrollCourses().remove(course);
    }


    course.getEnrollStudent().add(student);
    course.getCredits().add(credits);
    student.getEnrollCourses().add(course);
    student.setCredits(student.getCredits() - credits);
    return true;
}

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false; 
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1) return false;


        student.setCredits(student.getCredits() + course.getCredits().get(index));

        course.getCredits().set(index, credits);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false; 
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) return false;
        if (!student.getEnrollCourses().contains(course)) return false;
        int index = course.getEnrollStudent().indexOf(student);
        if (index == -1) return false;
        int creditsRefunded = course.getCredits().get(index);
        student.setCredits(student.getCredits() + creditsRefunded);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);
        student.getEnrollCourses().remove(course);

        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;


    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null; 

        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            if (index != -1) {
                enrolledCoursesWithCredits.add(course.getCourseID() + ": " + course.getCredits().get(index));
            }
        }
        return enrolledCoursesWithCredits;
    }
}

//end