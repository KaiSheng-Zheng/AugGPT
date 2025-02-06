import java.util.ArrayList;

import java.util.Comparator;


public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
// Maintains a record of all courses successfully registered.
// It is guaranteed that students enrolled in a course must exist in students.

    private ArrayList<Student> students = new ArrayList<>();
// Maintains a record of all students successfully registered.
// It is guaranteed that courses student enrolled in must exist in courses.

    private boolean ifOpen = true;
// Represent system open(true) or not(false)

    public CourseManager() {

    }
    // Constructor, initializes the course and student lists, and set the system default status open(true).

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    // getter for students
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    // getter for courses
    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    // setter for ifOpen
    public boolean getIfOpen() {
        return this.ifOpen;
    }

    // getter for ifOpen
    public void addCourse(Course course) {
        course.setCourseManager(this);
        courses.add(course);
    }

    // Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.
    public void addStudent(Student student) {
        student.setCourseManager(this);
        this.students.add(student);
    }

    // Register a course. Add a student object to students and set the courseManager of the student object to this manager. It is guaranteed that all studentIDs areunique.

    public Course ifCourseExist(String courseId) {
        Course course = null;
        boolean ifCourseExist = false;
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getCourseID().equals(courseId)) {
                ifCourseExist = true;
                course = this.courses.get(i);
            }
        }
        return course;
    }

    public int ifEnrolled(Student student, Course course) {
        int credits = -1;
        boolean ifEnrolled = false;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                ifEnrolled = true;
                credits = course.getCredits().get(i);
            }
        }
        return credits;
    }


    public boolean enrollStudentInCourse(Student student, String courseId, int
            credits) {
        Course course = null;
        boolean ifCourseExist = false;
        boolean ifEnrolled = false;
        boolean creditEnough = false;
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getCourseID().equals(courseId)) {
                ifCourseExist = true;
                course = this.courses.get(i);
            }
        }
        if (ifCourseExist) {
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (course.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    ifEnrolled = true;
                }
            }
            if (student.getCredits() >= credits) {
                creditEnough = true;
            }
            if (!ifEnrolled && creditEnough && ifOpen) {
                course.getEnrollStudent().add(student);
                course.getCredits().add(credits);
                student.getEnrollCourses().add(course);
                student.setCredits(student.getCredits() - credits);
                return true;
            }
        }
        return false;
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course course = this.ifCourseExist(courseId);
        boolean ifCourseExist = (course != null);
        if (ifCourseExist) {
            int credit = this.ifEnrolled(student, course);
            boolean ifEnrolled = (credit != -1);
            if (ifEnrolled && ifOpen) {
                student.setCredits(student.getCredits() + credit);
                student.getEnrollCourses().remove(course);
                int index = course.getEnrollStudent().indexOf(student);
                course.getEnrollStudent().remove(index);
                course.getCredits().remove(index);
                return true;
            }
        }
        return false;
    }


    class StudentWithCredits {
        Student student;
        int credits;

        String courseID;

        public StudentWithCredits(Student student, int credits) {
            this.student = student;
            this.credits = credits;
        }

        public StudentWithCredits(Student student, int credits, String courseID) {
            this.student = student;
            this.credits = credits;
            this.courseID = courseID;
        }

        public int getCredits() {
            return credits;
        }

        public Student getStudent() {
            return student;
        }

        public String getCourseID() {
            return courseID;
        }
    }

    public ArrayList<StudentWithCredits> getList() {
        ArrayList<StudentWithCredits> list = new ArrayList<>();
        for (int i = 0; i < this.courses.size(); i++) {
            Course course = this.courses.get(i);
            for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                list.add(new StudentWithCredits(course.getEnrollStudent().get(j), course.getCredits().get(j), course.getCourseID()));
            }
        }
        return list;
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (int i = 0; i < this.courses.size(); i++) {
            Course course = this.courses.get(i);
            ArrayList<StudentWithCredits> list = new ArrayList<>();
            for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                list.add(new StudentWithCredits(course.getEnrollStudent().get(j), course.getCredits().get(j)));
            }
            list.sort(new Comparator<StudentWithCredits>() {
                @Override
                public int compare(StudentWithCredits s1, StudentWithCredits s2) {
             
                    return Integer.compare(s2.getCredits(), s1.getCredits());
                }
            });
            int capacity = course.getMaxCapacity();
            int minValue = Math.min(capacity, list.size());
            if (list.size() > capacity && (list.get(capacity - 1).credits == list.get(capacity).credits)) {
                if(capacity != 1) {
                    int sameCredit = list.get(capacity - 1).credits;
                    minValue = capacity - 2;
                    while (list.get(minValue).credits == sameCredit) {
                        minValue--;
                        if(minValue < 0)
                            break;
                    }
                    minValue++;
                }
            }
            for (int j = 0; j < minValue; j++) {
                Student student = list.get(j).getStudent();
                course.getSuccessStudents().add(student);
                student.getSuccessCourses().add(course);
            }
        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> courseList = new ArrayList<>();
        if (!this.ifOpen) {
            return null;
        }
        ArrayList<StudentWithCredits> list = getList();
        for (int i = 0; i < list.size(); i++) {
            Student studentInList = list.get(i).getStudent();
            String courseID = list.get(i).getCourseID();
            int credit = list.get(i).getCredits();
            if (studentInList.getStudentID().equals(student.getStudentID())) {
                courseList.add(String.format("%s: %d", courseID, credit));
            }
        }
        return courseList;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,
                                                  int credits) {
        Course course = this.ifCourseExist(courseId);
        boolean ifCourseExist = (course != null);
        if (ifCourseExist) {
            int credit = this.ifEnrolled(student, course);
            boolean ifEnrolled = (credit != -1);
            boolean ifCreditEnough = (student.getCredits() + credit - credits >= 0);
            if (ifEnrolled && ifOpen && ifCreditEnough) {
                int index = course.getEnrollStudent().indexOf(student);
                course.getCredits().set(index, credits);
                student.setCredits(student.getCredits() + credit - credits);
                return true;
            }
        }
        return false;
    }
}
