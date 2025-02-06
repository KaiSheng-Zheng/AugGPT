import java.util.ArrayList;
import java.util.Comparator;

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

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false; 
        }

       
        Course courseToEnroll = null;
        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseId)) {
                courseToEnroll = course;
                break;
            }
        }

        if (courseToEnroll == null) {
            return false;
        }

       
        if (student.getEnrollCourses().contains(courseToEnroll) || credits <= 0) {
            return false; 
        }

       
        if (student.getCredits() < credits) {
            return false; 
        }

        student.setCredits(student.getCredits() - credits);

        courseToEnroll.getEnrollStudent().add(student);
        courseToEnroll.getCredits().add(credits);

        student.getEnrollCourses().add(courseToEnroll);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false; 
        }

        Course courseToModify = null;
        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseId)) {
                courseToModify = course;
                break;
            }
        }

        if (courseToModify == null) {
            return false; 
        }

 
        if (!student.getEnrollCourses().contains(courseToModify)) {
            return false;
        }

        int index = 0;
        for (int i = 0; i < courseToModify.getEnrollStudent().size(); i++) {
            Student student1 = courseToModify.getEnrollStudent().get(i);
            if (student1.getStudentID().equals(student.getStudentID())) {
                index = i;
                break;
            }
        }

        if (credits - courseToModify.getCredits().get(index) > student.getCredits()) {
            return false;
        }

        student.setCredits(student.getCredits() - credits + courseToModify.getCredits().get(index));

        courseToModify.getCredits().set(index, credits);

        return true;
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false; 
        }

  
        Course courseToDrop = null;
        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseId)) {
                courseToDrop = course;
                break;
            }
        }

        if (courseToDrop == null) {
            return false; 
        }
 
        if (!student.getEnrollCourses().contains(courseToDrop)) {
            return false; 
        }
        int index = 0;
        for (int i = 0; i < courseToDrop.getEnrollStudent().size(); i++) {
            Student student1 = courseToDrop.getEnrollStudent().get(i);
            if (student1.getStudentID().equals(student.getStudentID())) {
                index = i;
                break;
            }
        }
        student.setCredits(student.getCredits() + courseToDrop.getCredits().get(index));
        courseToDrop.getCredits().remove(index);
        courseToDrop.getEnrollStudent().remove(index);
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                student.getEnrollCourses().remove(i);
                break;
            }
        }


        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            ArrayList<Student> enrollStudent = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            ArrayList<Student> successStudents = new ArrayList<>();
            int maxCapacity = course.getMaxCapacity();

           
            ArrayList<Student> sortedStudents = new ArrayList<>(enrollStudent);
            ArrayList<Integer> list = new ArrayList<>(credits);
            int n = list.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (list.get(j) < list.get(j + 1)) {
                        Integer temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);

                        Student temp1 = sortedStudents.get(j);
                        sortedStudents.set(j, sortedStudents.get(j + 1));
                        sortedStudents.set(j + 1, temp1);

                    }
                }
            }
            
            for (int i = 0; i < Math.min(sortedStudents.size(), maxCapacity); i++) {
                successStudents.add(sortedStudents.get(i));
            }
            if (sortedStudents.size() > maxCapacity) {
                int j = sortedStudents.size() - 1;
                for (int i = successStudents.size() - 1; i >= 0; i--) {
                    if (list.get(j) == list.get(i)) {
                        successStudents.remove(i);
                        j--;
                    } else {
                        break;
                    }
                }
            }


           
            course.setSuccessStudents(successStudents);

            for (Student student : successStudents) {
                student.getSuccessCourses().add(course);
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        // Check if enrollment is open
        if (!ifOpen) {
            return null;
        }

        
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();

        ArrayList<Course> enrolledCourses = student.getEnrollCourses();

        
        for (Course course : enrolledCourses) {
           
            int index = 0;
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                Student student1 = course.getEnrollStudent().get(i);
                if (student1.getStudentID().equals(student.getStudentID())) {
                    index = i;
                    break;
                }
            }
            
            int creditsBid = course.getCredits().get(index);
          
            String courseInfo = course.getCourseID() + ": " + creditsBid;
           
            enrolledCoursesWithCredits.add(courseInfo);
        }

   
        return enrolledCoursesWithCredits;
    }
}
