


import java.util.ArrayList;

import java.util.List;

public class CourseManager {
    private List<Course> courses;
    private List<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        ifOpen = true;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(Boolean open) {
        ifOpen = open;
    }


    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }


    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }


    public boolean enrollStudentInCourse(Student student, String courseId, int points) {
        if (!ifOpen)
            return false;

        if(points<0)
            return false;
        // check course exists
        Course course = isCourseExists(courseId);
        if (course == null)
            return false;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                return false;
            }
        }
        if (student.getCredits() <= 0 || student.getCredits() - points < 0) {
            return false;
        }
        student.setCredits(student.getCredits() - points);
        course.getEnrollStudent().add(student);
        course.getCredits().add(points);
        student.getEnrollCourses().add(course);

        return true;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,
                                                  int credits) {
        if (!ifOpen)
            return false;
        Course course = isCourseExists(courseId);
        if (course == null)
            return false;
        Course enrolledCourse = getEnrolledCourse(student, courseId);
        if (enrolledCourse == null)
            return false;
        int index = getEnrolledCourseIndex(enrolledCourse, student);
        int credit = enrolledCourse.getCredits().get(index);
        if ((student.getCredits() + credit - credits) < 0)
            return false;
        student.setCredits(student.getCredits() + credit - credits);
        course.getCredits().set(index, credits);
        return true;
    }



    public boolean dropStudentEnrollmentCourse(Student s, String courseId) {
        if (!ifOpen)
            return false;
        Course course = isCourseExists(courseId);
        if (course == null)
            return false;
        Course enrolledCourse = getEnrolledCourse(s, courseId);
        if (enrolledCourse == null)
            return false;
        int index = getEnrolledCourseIndex(enrolledCourse, s);
        int courseCredits = enrolledCourse.getCredits().remove(index);
        enrolledCourse.getEnrollStudent().remove(index);
        s.getEnrollCourses().remove(enrolledCourse);
        s.setCredits(s.getCredits() + courseCredits);
        return true;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course course = student.getEnrollCourses().get(i);
            int credits = getStudentCourseCredits(student, course);
            results.add(String.format("%s: %d",
                    student.getEnrollCourses().get(i).getCourseID(), credits));
        }
        return results;
    }

    private int getStudentCourseCredits(Student s, Course c) {
        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
            if (s.getStudentID().equals(c.getEnrollStudent().get(i).getStudentID())) {
                return c.getCredits().get(i);
            }
        }
        return -1;
    }


    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (Course c : courses) {
            int minCredit = getSuccessCredits(c);
            if (minCredit == 0) {
                c.getSuccessStudents().addAll(c.getEnrollStudent());
                for(Student s:c.getEnrollStudent())
                    s.getSuccessCourses().add(c);
            } else {
                for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                    int credit = c.getCredits().get(i);
                    Student student = c.getEnrollStudent().get(i);
                    if (credit >= minCredit) {
                        c.getSuccessStudents().add(student);
                        student.getSuccessCourses().add(c);
                    }
                }
            }
        }
    }

    private int getSuccessCredits(Course course) {
        int size = course.getMaxCapacity();
        if (course.getEnrollStudent().size() <= size)
            return 0;
        ArrayList<Integer> credits = new ArrayList<>(course.getCredits());
        credits.sort((o1, o2) -> o2 - o1);
        int minCredits = credits.get(size - 1);
        if (minCredits == credits.get(size)) {
            return minCredits + 1;
        } else {
            return minCredits;
        }
    }



    private Course isCourseExists(String courseId) {
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        return course;
    }

    private Course getEnrolledCourse(Student student, String courseId) {
        Course enrolledCourse = null;
        for (Course c : student.getEnrollCourses()) {
            if (c.getCourseID().equals(courseId)) {
                enrolledCourse = c;
                break;
            }
        }
        return enrolledCourse;
    }

    private static int getEnrolledCourseIndex(Course c, Student s) {
        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
            if (c.getEnrollStudent().get(i).getStudentID().equals(s.getStudentID())) {
                return i;
            }
        }
        return 0;
    }

}


