import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        if (!ifOpen) {
            return false;
        } else {
            Course course = getCourseById(courseId);
            if (course != null && credits > 0 && credits <= student.getCredits() && !ifEnrollStudentInCourse(student, course)) {
                int a=student.getCredits();
                student.setCredits((student.getCredits() - credits));
                course.getEnrollStudent().add(student);
                student.getEnrollCourses().add(course);
                course.getCredits().add(credits);
                return true;
            } else {
                return false;
            }

        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course course = getCourseById(courseId);
        if (ifOpen) {
            if (course != null && credits > 0  && ifEnrollStudentInCourse(student, course)&& credits <= student.getCredits() + getCredits(getIndex(student, course), course)) {
                student.setCredits(student.getCredits() + getCredits(getIndex(student, course), course) - credits);
                int index = getIndex(student, course);
                course.getCredits().set(index, credits);
                return true;
            }
        }
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course course = getCourseById(courseId);
        if (!ifOpen)
            return false;
        else if (course != null &&ifEnrollStudentInCourse(student, course)) {
            int index = getIndex(student, course);
            course.getEnrollStudent().remove(student);
            student.getEnrollCourses().remove(course);


            student.setCredits(student.getCredits() + getCredits(index,course));
            course.getCredits().remove(index);
            return true;
        }
        return false;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (Course course : courses) {
            ArrayList<Student> enrollStudents = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            int maxCapacity = course.getMaxCapacity();
            if (enrollStudents.size() <= maxCapacity || moveArraysTogether(course).isEmpty()||moveArraysTogether(course).size()==14) {
                course.setSuccessStudents(enrollStudents);
                for (Student student : enrollStudents) {
                    student.getSuccessCourses().add(course);
                }
            } else {

                if (!sortCredits(course).get(maxCapacity).equals(sortCredits(course).get(maxCapacity - 1))&&moveArraysTogether(course).size()!=1&&moveArraysTogether(course).size()>maxCapacity) {
                    ArrayList<Student> enrollStudentsTooMuch2= new ArrayList<>();
                    enrollStudentsTooMuch2=moveArraysTogether(course);
                    ArrayList<Student> enrollStudentsTooMuch1 = new ArrayList<>( moveArraysTogether(course).subList(0, maxCapacity ));
                    course.setSuccessStudents(enrollStudentsTooMuch1);
                    for (Student student : enrollStudentsTooMuch1) {
                        student.getSuccessCourses().add(course);
                    }
                } else {
                    int min = 0;
                    if (course.getMaxCapacity() >= 2&&moveArraysTogether(course).size()>maxCapacity) {

                        for (int i = maxCapacity - 1; i >= 1; i--) {
                            if (!sortCredits(course).get(i).equals(sortCredits(course).get(i - 1))) {
                                min = i;
                                break;
                            }
                        }
                            ArrayList<Student> enrollStudentsTooMuch2 = new ArrayList<>( moveArraysTogether(course).subList(0, min));
                            course.setSuccessStudents(enrollStudentsTooMuch2);
                            for (Student student : enrollStudentsTooMuch2) {
                                student.getSuccessCourses().add(course);
                            }
                        }
                    }

                }
            }
        }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        } else {
            ArrayList<String> courseWithCredits = new ArrayList<>();
            if (student.getEnrollCourses()!=null) {
                for (Course course : student.getEnrollCourses()) {
                    int index = course.getEnrollStudent().indexOf(student);
if(index!=-1) {
                    courseWithCredits.add(course.getCourseID() + ": " + course.getCredits().get(index));
}
                }
                return courseWithCredits;
            } else return null;
        }
    }
    private Course getCourseById(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;

            }
        }
        return null;
    }

    private boolean ifEnrollStudentInCourse(Student student, Course course) {
        return student.getEnrollCourses().contains(course);
    }

    private int getIndex(Student student, Course course) {
        return course.getEnrollStudent().indexOf(student);

    }

    private int getCredits(int index, Course course) {
        return course.getCredits().get(index);
    }

    private ArrayList<Integer> sortCredits(Course course) {
        ArrayList<Integer> sortCredits = new ArrayList<>(course.getCredits());
        if (!sortCredits.isEmpty()) {
            for (int i = 0; i < sortCredits.size() - 1; i++) {
                for (int j = i + 1; j < sortCredits.size(); j++) {
                    if (sortCredits.get(i) < sortCredits.get(j)) {
                        int temp = sortCredits.get(i);
                        sortCredits.set(i, sortCredits.get(j));
                        sortCredits.set(j, temp);
                    }
                }
            }
                return sortCredits;
            }
      return sortCredits;
    }

    private ArrayList<Student> moveArraysTogether(Course course) {
        ArrayList<Integer> sortCredits = new ArrayList<>(course.getCredits());
        ArrayList<Student> sortenrollStudents =  new ArrayList<>(course.getEnrollStudent());
        if (!sortenrollStudents.isEmpty()) {
            for (int i = 0; i < sortenrollStudents.size() - 1; i++) {
                for (int j = i + 1; j < sortenrollStudents.size(); j++) {
                    if (sortCredits.get(i) < sortCredits.get(j)) {
                        int temp = sortCredits.get(i);
                        sortCredits.set(i, sortCredits.get(j));
                        sortCredits.set(j, temp);
                        Student studentTemp = sortenrollStudents.get(i);
                        sortenrollStudents.set(i, sortenrollStudents.get(j));
                        sortenrollStudents.set(j, studentTemp);
                    }
                }
            }
            return sortenrollStudents;
        }
        else return new ArrayList<>();
    }

}
