

import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
// Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.

    private ArrayList<Student> students;
// Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.

    private boolean ifOpen;

    // Represent system open(true) or not(false).

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }

// Constructor, initializes the course and student lists, and set the system default status open(true).


    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    // getter for ifOpen

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student) {
        students.add(student); //(1)
        student.setCourseManager(this); //(2)
    }
// Register a student. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.

    
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen)
            return false;
        if (credits <= 0) {
            return false;
        }
        int t = student.getCredits();
        if (t < credits) {
            return false;
        }
      
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course course = student.getEnrollCourses().get(i);
        
            if (course.getCourseID().equals(courseId)) {
                return false;
            }
        }
        Course goalCourse = null;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                goalCourse = course;
                break;
            }
        }
        if (goalCourse == null)
            return false;
        student.setCredits(t - credits);
        ArrayList<Course> courses = student.getEnrollCourses();
        courses.add(goalCourse);

        ArrayList<Student> goalCourseStudents = goalCourse.getEnrollStudent();
        ArrayList<Integer> goalCourseCredits = goalCourse.getCredits();
        goalCourseStudents.add(student);
        goalCourseCredits.add(credits);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen || credits <= 0)
            return false;
        Course goalCourse = null;
        for (int i = 0; i < student.getEnrollCourses().size(); i ++) {
            Course course = student.getEnrollCourses().get(i);
            if (course.getCourseID().equals(courseId)) {
                goalCourse = course;
                break ;
            }
        }
        if (goalCourse == null)
            return false;

       
        for (int i = 0; i < goalCourse.getEnrollStudent().size(); i ++) {
            if (goalCourse.getEnrollStudent().get(i) == student) {
                int t = credits - goalCourse.getCredits().get(i);
                if (student.getCredits() < t)
                    return false;
                goalCourse.getCredits().set(i, credits);
                student.setCredits(student.getCredits() - t);
                break;
            }
        }
        return true;
    }

  
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }

        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course course = student.getEnrollCourses().get(i);
            int t = student.getCredits();
            if (course.getCourseID().equals(courseId)) {
                for (int k = 0; k < course.getEnrollStudent().size(); k ++) {
                    if (course.getEnrollStudent().get(k) == student) {
                        t += course.getCredits().get(k);
                        course.getEnrollStudent().remove(k);
                        course.getCredits().remove(k);
                        break;
                    }
                }
                student.setCredits(t) ;
                student.getEnrollCourses().remove(i);
                return true;
            }
        }
        return false;
    }
  
    public void finalizeEnrollments(){


        ifOpen = false;
      
        for (Course course : courses) {
            ArrayList<Student> successStudent = new ArrayList<>();
            ArrayList<Integer> successCredit = new ArrayList<>();
            for (int i = 0; i < course.getEnrollStudent().size(); i ++) {
                successStudent.add(course.getEnrollStudent().get(i));
                successCredit.add(course.getCredits().get(i));
            }
            int lastDrop = -1;
            while (!successStudent.isEmpty()) {
                int id = 0;
                for (int k = 1; k < successStudent.size(); k++) {
                    if (successCredit.get(k) < successCredit.get(id)) {
                        id = k;
                    }
                }
                int nowDrop = successCredit.get(id);
                if (successStudent.size() <= course.getMaxCapacity() && nowDrop != lastDrop) {
                    break;
                }
                lastDrop = nowDrop;
                successStudent.remove(id);
                successCredit.remove(id);
            }
            course.setSuccessStudents(successStudent);
            for (Student student: course.getSuccessStudents()) {
                student.getSuccessCourses().add(course);
            }
        }
    }

   
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(!ifOpen){
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
       
        for (Course course: student.getEnrollCourses()) {
            int score = 0;
            for (int i = 0; i < course.getEnrollStudent().size(); i ++) {
                if (course.getEnrollStudent().get(i) == student) {
                    score = course.getCredits().get(i);
                }
            }
            result.add(course.getCourseID() + ": " + score);
        }
        return result;
    }
}