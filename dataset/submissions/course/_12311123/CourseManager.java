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
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }
// Constructor, initializes the course and student lists, and set the system default status open(true).


    public void setIfOpen(boolean b) {
        this.ifOpen = b;
    }

    public void addStudent(Student student1) {
        this.students.add(student1);
        student1.setCourseManager(this);

    }

    public void addCourse(Course course2) {
        this.courses.add(course2);
        course2.setCourseManager(this);
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (int i = 0; i < this.courses.size(); i++) {
            ArrayList<Student> successstudent = new ArrayList<>();
            Course c = this.courses.get(i);
            ArrayList<Integer> point = new ArrayList();
            if (c.getCredits() != null) {
                point.addAll(c.getCredits());
                for (int k = 0; k < point.size() - 1; k++) {
                    for (int j = 0; j < point.size() - 1; j++) {
                        if (point.get(j) <= point.get(j + 1)) {
                            int temp = point.get(j);
                            point.set(j, point.get(j + 1));
                            point.set(j + 1, temp);
                        }
                    }
                }
            }
            if (c.getMaxCapacity() <= c.getEnrollStudent().size()) {
                int rank = c.getMaxCapacity();
                int num = point.get(rank - 1);
                point.add(0);
                int result = 0;
                if (num == point.get(rank)) {
                    result = num + 1;
                } else {
                    result = num;
                }
                for (int k = 0; k < this.students.size(); k++) {
                    Student student = this.students.get(k);
                    if (c.getEnrollStudent().contains(student) && c.getCredits().get(c.getEnrollStudent().indexOf(student)) >= result) {
                        successstudent.add(student);
                    }
                }
                c.setSuccessStudents(successstudent);
            } else if (c.getEnrollStudent().size() == 0) {
                c.setSuccessStudents(successstudent);
            } else {
                for (int k = 0; k < c.getEnrollStudent().size(); k++) {
                    successstudent.add(this.students.get(k));
                }
                c.setSuccessStudents(successstudent);
            }
        }
        for (int i = 0; i < this.students.size(); i++) {
            Student student = this.students.get(i);
            ArrayList<Course> successcourse = new ArrayList<>();
            ArrayList<Integer> point = new ArrayList();
            int count = 0;
            for (int k = 0; k < student.getEnrollCourses().size(); k++) {
                Course c = student.getEnrollCourses().get(k);
                for (int j = 0; j < c.getCredits().size(); j++) {
                    point.add(j, c.getCredits().get(j));
                }
                for (int h = 0; h < point.size() - 1; h++) {
                    for (int j = 0; j < point.size() - 1; j++) {
                        if (point.get(j) <= point.get(j + 1)) {
                            int temp = point.get(j);
                            point.set(j, point.get(j + 1));
                            point.set(j + 1, temp);
                        }
                    }

                }
                if (c.getMaxCapacity() <= c.getEnrollStudent().size()) {
                    int rank = c.getMaxCapacity();
                    int num = point.get(rank - 1);
                    point.add(0);
                    int result = 0;
                    if (num == point.get(rank)) {
                        result = num + 1;
                    } else {
                        result = num;
                    }
                    if (c.getCredits().get(c.getEnrollStudent().indexOf(student)) >= result) {
                        successcourse.add(c);
                    }
                } else {
                    successcourse.add(c);
                }
            }
            student.setSuccessCourses(successcourse);
        }
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                course = null;
                break;
            }
        }


        if (!this.ifOpen == true) {
            return false;
        } else if (student.getCredits() < credits || credits <= 0) {
            return false;
        } else if (course == null) {
            return false;
        } else if (ifOpen){
            int credit = student.getCredits() - credits;
            student.setCredits(credit);
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            student.getEnrollCourses().add(course);
            return true;
        }
        else
            return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course course = null;
        int credit = 0;
        int credit1 = 0;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                course = student.getEnrollCourses().get(i);
                for (int k = 0; k < course.getEnrollStudent().size(); k++) {
                    if (course.getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())) {
                        credit1 = course.getCredits().get(k);
                        break;
                    }
                }
                break;
            } else {
                course = null;
            }
            credit = student.getCredits() + credit1 - credits;
        }
        if (!this.ifOpen) {
            return false;
        } else if (student.getCredits() + credit1 < credits || credits <= 0) {
            return false;
        } else if (course == null) {
            return false;
        } else if (ifOpen) {
            for (int k = 0; k < course.getEnrollStudent().size(); k++) {
                if (course.getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())) {
                    credit1 = course.getCredits().get(k);
                    course.getCredits().set(k, credits);
                    break;
                }
            }
            credit = student.getCredits() + credit1 - credits;
            student.setCredits(credit);
            return true;
        } else {
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course course = null;
        int credit;
        int credit1 = 0;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (student.getEnrollCourses().size() == 0) {
            return false;
        } else {
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                    course = student.getEnrollCourses().get(i);
                    for (int k = 0; k < course.getEnrollStudent().size(); k++) {
                        if (course.getEnrollStudent().get(k) == student) {
                            credit1 = course.getCredits().get(k);
                            break;
                        }
                    }
                    break;
                } else {
                    course = null;
                }
            }
            if (!this.ifOpen == true) {
                return false;
            } else if (course == null) {
                return false;
//            }else if(student.getEnrollCourses()==null){
//                return  false;
            } else if (ifOpen){
//                course.getEnrollStudent().remove(course.getEnrollStudent().indexOf(student));
                for (int k = 0; k < course.getEnrollStudent().size(); k++) {
                    if (course.getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())) {
                        credit1 = course.getCredits().get(k);
                        course.getCredits().remove(k);
                        course.getEnrollStudent().remove(k);
                        break;
                    }
                }
                for (int k = 0; k < student.getEnrollCourses().size(); k++) {
                    if (student.getEnrollCourses().get(k) == course) {
                        student.getEnrollCourses().remove(k);
                        break;
                    }
                }
                credit = student.getCredits() + credit1;
                student.setCredits(credit);
                return true;
            }
            else
                return false;
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> enrolled = new ArrayList<>();
        if (!this.ifOpen) {
            return null;
        } else {
            Course c = null;
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                c = student.getEnrollCourses().get(i);
                for (int k = 0; k < c.getEnrollStudent().size(); k++) {
                    if (c.getEnrollStudent().get(k) == student) {
                        enrolled.add(String.format(c.getCourseID() + ": " + c.getCredits().get(k)));
                        break;
                    }
                }
            }
            return enrolled;
        }
    }
}
