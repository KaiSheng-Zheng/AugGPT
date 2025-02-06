import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collections;


public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;

    }


    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int points) {
        if (!this.ifOpen) {
            return false;
        }

        if (points <= 0) {
            return false;
        }

        Course course = null;

        for (Course c : this.courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }

        if (course == null) {
            return false;
        }

        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                return false;
            }
        }

        if (student.getCredits() < points) {
            return false;
        }

        student.setCredits(student.getCredits() - points);

        course.getEnrollStudent().add(student);
        course.getCredits().add(points);

        student.getEnrollCourses().add(course);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
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

        boolean isEnrolled = false;
        int index = -1;
        ArrayList<Course> enrolledCourses = student.getEnrollCourses();
        ArrayList<Integer> creditsForCourses = course.getCredits();

        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getCourseID().equals(courseId)) {
                isEnrolled = true;
                index = i;
                break;
            }
        }

        if (!isEnrolled) {
            return false;
        }

        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (i != index && creditsForCourses.get(i) >= credits) {
                return false;
            }
        }

        int previousCredits = creditsForCourses.get(index);
        student.setCredits(student.getCredits() + (previousCredits - credits));
        creditsForCourses.set(index, credits);

        return true;
    }





    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
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

        boolean isEnrolled = false;
        int index = 0;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course enrolledCourse = student.getEnrollCourses().get(i);
            if (enrolledCourse.getCourseID().equals(courseId)) {
                isEnrolled = true;
                index = i;
                break;
            }
        }
        if (!isEnrolled) {
            return false;
        }
        student.getEnrollCourses().remove(index);

        // Remove corresponding credits from student's total credits
        student.setCredits(student.getCredits() + course.getCredits().get(index));

        // Remove the course and credits from the course's lists
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);


        return true;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        }

        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();

        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);

            if (index != -1) {
                int credits = course.getCredits().get(index);
                enrolledCoursesWithCredits.add(course.getCourseID() + ": " + credits);
            }
        }

        return enrolledCoursesWithCredits;
    }


    public void finalizeEnrollments() {

        this.setIfOpen(false);

    
        for (Course course : this.courses) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();

            int maxCapacity = course.getMaxCapacity();
            if (enrolledStudents.isEmpty()) {
                continue;
            }

            int minCreditsForSuccess =100000;
            ArrayList<Integer> creditsCopy = new ArrayList<>(credits);
            Collections.sort(creditsCopy);
            if(enrolledStudents.size()<=maxCapacity){
                minCreditsForSuccess = creditsCopy.get(enrolledStudents.size()-1);
            }
            else{
                int credits_cannot_enter = Math.min(minCreditsForSuccess,creditsCopy.get(enrolledStudents.size()-maxCapacity)-1);
                for(int i= enrolledStudents.size()-maxCapacity;i<enrolledStudents.size();i++){
                    if(credits.get(i)>credits_cannot_enter){
                        minCreditsForSuccess= Math.min(minCreditsForSuccess,credits.get(i));
                        break;
                    }
                }
            }




            ArrayList<Student> successfulStudents = new ArrayList<>();

            for (int i = 0; i < credits.size(); i++) {
                if (credits.get(i) >= minCreditsForSuccess) {
                    Student student = enrolledStudents.get(i);
                    successfulStudents.add(student);
                }
            }

            enrolledStudents.clear();
            credits.clear();

            for (Student student : successfulStudents) {
                enrolledStudents.add(student);
                credits.add(student.getCredits());
                student.getSuccessCourses().add(course);
                course.getSuccessStudents().add(student);

            }

            course.getSuccessStudents().addAll(successfulStudents);
        }
    }



    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
}