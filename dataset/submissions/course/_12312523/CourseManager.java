import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course) {
        if(!this.ifCourseExist(course.getCourseID())) {
            courses.add(course);
            course.setCourseManager(this);
        }
    }

    public void addStudent(Student student) {
        if(!this.ifStudentExist(student)) {
            students.add(student);
            student.setCourseManager(this);
        }
    }

    public boolean ifCourseExist(String courseId) {
        boolean ifExist = false;
        for (int i = 0; i < courses.size(); i++) {
            if(this.courses.get(i).getCourseID().equals(courseId)) {
                ifExist = true;
                break;
            }
        }
        return ifExist;
    }

    public int getCourseIndex(String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if(this.courses.get(i).getCourseID().equals(courseId)) {
                return i;
            }
        }
        return -100;
    }

    public boolean ifStudentChosen(Student student, String courseId) {
        boolean ifChosen = false;
        ArrayList<Course> chosen = student.getEnrollCourses();
        for (int i = 0; i < chosen.size(); i++) {
            if(chosen.get(i).getCourseID().equals(courseId)) {
                ifChosen = true;
                break;
            }
        }
        return ifChosen;
    }

    public int getStudentIndex(Student student, Course target) {
        ArrayList<Student> enrollStudent = target.getEnrollStudent();
        for (int i = 0; i < enrollStudent.size(); i++) {
            if(enrollStudent.get(i).equals(student)) {
                return i;
            }
        }
        return -100;
    }

    public boolean ifStudentExist(Student student) {
        boolean ifExist = false;
        for (int i = 0; i < this.students.size(); i++) {
            Student target = this.students.get(i);
            if(target.equals(student)) {
                ifExist = true;
                break;
            }
        }
        return ifExist;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if(ifOpen && credits > 0 && this.ifCourseExist(courseId) && credits <= student.getCredits() && !this.ifStudentChosen(student, courseId)) {
            Course target = courses.get(this.getCourseIndex(courseId));
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(target);
            target.getEnrollStudent().add(student);
            target.getCredits().add(credits);
            return true;
        } else {
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if(ifOpen && this.ifCourseExist(courseId) && this.ifStudentChosen(student, courseId)) {
            Course target = courses.get(this.getCourseIndex(courseId));
            int studentIndex = this.getStudentIndex(student, target);
            int bid = target.getCredits().get(studentIndex);
            if(bid + student.getCredits() >= credits) {
                student.setCredits(bid + student.getCredits() - credits);
                target.getCredits().set(studentIndex, credits);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if(ifOpen && this.ifCourseExist(courseId) && this.ifStudentChosen(student, courseId)) {
            Course target = courses.get(this.getCourseIndex(courseId));
            int studentIndex = this.getStudentIndex(student, target);
            int bid = target.getCredits().get(studentIndex);
            target.getEnrollStudent().remove(studentIndex);
            target.getCredits().remove(studentIndex);
            student.setCredits(student.getCredits() + bid);
            student.getEnrollCourses().remove(target);
            return true;
        } else {
            return false;
        }
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            Course target = courses.get(i);
            ArrayList<Student> enrollStudent = target.getEnrollStudent();
            ArrayList<Integer> creditList = target.getCredits();
            int capacity = target.getMaxCapacity();
            if(capacity >= enrollStudent.size()) {
                target.setSuccessStudents(enrollStudent);
                for (int j = 0; j < enrollStudent.size(); j++) {
                    enrollStudent.get(j).getSuccessCourses().add(target);
                }
            } else {
                int[] enrollCre = new int[creditList.size()];
                for (int j = 0; j < creditList.size(); j++) {
                    enrollCre[j] = creditList.get(j);
                }
                Arrays.sort(enrollCre);
                ArrayList<Integer> success = new ArrayList<>();
                for (int j = 0; j <= capacity; j++) {
                    int pick = enrollCre.length - 1 - j;
                    success.add(enrollCre[pick]);
                }
                while((success.size() >= 2) && (success.get(success.size() - 1).equals(success.get(success.size() - 2)))) {
                    success.remove(success.size() - 2);
                }
                if(success.size() >= 1) {
                    success.remove(success.size() - 1);
                }

                ArrayList<Student> successStudent = new ArrayList<>();
                for (int j = 0; j < success.size(); j++) {
                    int index = creditList.indexOf(success.get(j));
                    successStudent.add(enrollStudent.get(index));
                    creditList.remove(index);
                    enrollStudent.remove(index);
                }
                target.setSuccessStudents(successStudent);
                for (int j = 0; j < successStudent.size(); j++) {
                    successStudent.get(j).getSuccessCourses().add(target);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if(ifOpen) {
            String id = student.getStudentID();
            ArrayList<String> enroll = new ArrayList<>();
            for (int i = 0; i < courses.size(); i++) {
                Course target = courses.get(i);
                ArrayList<Student> enrollStudent = target.getEnrollStudent();
                ArrayList<Integer> creditList = target.getCredits();
                for (int j = 0; j < enrollStudent.size(); j++) {
                    if(enrollStudent.get(j).getStudentID().equals(id)) {
                        StringBuilder buffer = new StringBuilder();
                        buffer.append(target.getCourseID());
                        buffer.append(": ");
                        buffer.append(creditList.get(j));
                        enroll.add(buffer.toString());
                    }
                }
            }
            return enroll;
        } else {
            return null;
        }
    }
}