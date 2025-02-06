import java.util.ArrayList;
import java.util.Comparator;

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
        // Constructor, initializes the course and student lists, and set the system default status open(true).
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() { return students; }
    // getter for students

    public ArrayList<Course> getCourses() { return courses; }
    // getter for courses

    public void setIfOpen(Boolean ifOpen) { this.ifOpen = ifOpen; }
    // setter for ifOpen

    public boolean getIfOpen() { return ifOpen; }
    // getter for ifOpen

    public void addCourse(Course course) { 
        courses.add(course); 
        course.setCourseManager(this);
    }
    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student) { 
        students.add(student); 
        student.setCourseManager(this);
    }
    // Register a course. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs are unique.


    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (credits > 0 && isCourseExist(courseId) && !isEnrolledCourse(student, courseId) && isCreditsEnough(student, credits)) {
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(getCourse(courseId));
            getCourse(courseId).getEnrollStudent().add(student);
            getCourse(courseId).getCredits().add(credits);
            return true;
        } else {
            return false;
        }
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        if (credits > 0 && isCourseExist(courseId) && isEnrolledCourse(student, courseId) && _isCreditsEnough(student, getCourse(courseId), credits)) {
            int preCredits = getCourse(courseId).getCredits().get(getCourse(courseId).getEnrollStudent().indexOf(student)); 

            student.setCredits(student.getCredits() - (credits - preCredits));

            replace(getCourse(courseId).getCredits(), getCourse(courseId).getEnrollStudent().indexOf(student), credits);
            return true;
        } else {
            return false;
        }
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {

        if (!ifOpen) {
            return false;
        }

        if (isCourseExist(courseId) && isEnrolledCourse(student, courseId)) {
            int credits = getCourse(courseId).getCredits().get(getCourse(courseId).getEnrollStudent().indexOf(student));

            student.setCredits(student.getCredits() + credits);

            student.getEnrollCourses().remove(getCourse(courseId));
 
            getCourse(courseId).getCredits().remove(getCourse(courseId).getEnrollStudent().indexOf(student));
            getCourse(courseId).getEnrollStudent().remove(student);
            return true;
        } else {
            return false;
        }
    }

        // TODO
        public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course: courses) {
            int capacity = course.getMaxCapacity();
            ArrayList<Student> enrollStudent = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            ArrayList<Student> successStudents = new ArrayList<>();
            ArrayList<Integer> successCredits = new ArrayList<>();

            ArrayList<Integer> creditsForSort = deepCopy(credits);
     
            creditsForSort.sort(Comparator.reverseOrder());
            int minIndex = Math.min(capacity, creditsForSort.size());
            if (minIndex == 0) {
                course.setSuccessStudents(successStudents);
                course.setCredits(successCredits);
                continue;
            }
            minIndex--;
   
            if (minIndex == creditsForSort.size() - 1 || creditsForSort.get(minIndex) > creditsForSort.get(minIndex + 1) || minIndex == 0) {
                
            } else { 
                minIndex--;
                while (minIndex >= 0 && creditsForSort.get(minIndex) == creditsForSort.get(minIndex + 1)) {
                    minIndex--;
                }
            }

            if (minIndex == -1) {
                course.setSuccessStudents(successStudents);
                course.setCredits(successCredits);
                continue;
            }

            int minCredits = creditsForSort.get(minIndex);
            for (Student student : enrollStudent) {
                if (credits.get(enrollStudent.indexOf(student)) >= minCredits) {
                    successStudents.add(student);
                    successCredits.add(credits.get(enrollStudent.indexOf(student)));
                }
            }
         
            course.setSuccessStudents(successStudents);
            course.setCredits(successCredits);
        
            for (Student student: successStudents) {
                student.getSuccessCourses().add(course);
            }
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }

        ArrayList<String> res = new ArrayList<>();
        
        for (Course course : student.getEnrollCourses()) {
            res.add(course.getCourseID() + ": " + course.getCredits().get(course.getEnrollStudent().indexOf(student)));
        }

        return res;
    }


    private boolean isCourseExist(String courseId) {
        if (getCourse(courseId) != null) {
            return true;
        }
        else return false;
    }

    private boolean isCreditsEnough(Student student, int credits) {
        return student.getCredits() >= credits;
    }

    private boolean _isCreditsEnough(Student student, Course course, int credits) {
        int preCredits = course.getCredits().get(course.getEnrollStudent().indexOf(student));
        return student.getCredits() >= (credits - preCredits);
    }

    private Course getCourse(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private boolean isEnrolledCourse(Student student, String courseId) {
        Course tarCourse = getCourse(courseId);
        if (tarCourse.getEnrollStudent().contains(student)) {
            return true;
        }
        else return false;
    }

    private void replace(ArrayList<Integer> list, int index, int credits) {
        list.remove(index);
        list.add(index, credits);
    }

    private ArrayList<Integer> deepCopy(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : list) {
            res.add(i);
        }
        return res;
    }

}