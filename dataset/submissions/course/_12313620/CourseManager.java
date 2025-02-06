import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// CS109 Assignment 4
public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;
    public static void ManuallyMakeAnError() {
        System.out.println("BOOM!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("So... There's a TLE error being manually made ;)");
        while (true);
    }
    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
        ifOpen = true;
    }
    public ArrayList<Student> getStudents() {
        return this.students;
    }
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    public boolean getIfOpen() {
        return this.ifOpen;
    }
    public void addCourse(Course course) {
        course.setCourseManager(this);
        this.courses.add(course);
    }
    public void addStudent(Student student) {
        student.setCourseManager(this);
        this.students.add(student);
    }
    public boolean enrollStudentInCourse(Student student, String courseID, int givenCredit) {
        if (!this.getIfOpen())
            return false;
        
        if (givenCredit <= 0)
            return false;
        
        int myCredit = student.getCredits();
        if (myCredit < givenCredit)
            return false;

        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseID)) {
                ArrayList<Student> currentEnrollStudent = course.getEnrollStudent();
                ArrayList<Integer> currentCredits = course.getCredits();

                if (currentEnrollStudent.contains(student))
                    return false;

                // Modify the student
                int newCreditNumber = myCredit - givenCredit;
                student.setCredits(newCreditNumber);

                ArrayList<Course> studentEnrollCourses = student.getEnrollCourses();
                if (studentEnrollCourses.contains(course))
                    CourseManager.ManuallyMakeAnError(); // Manually make a TLE result
                studentEnrollCourses.add(course);
                student.setEnrollCourses(studentEnrollCourses);

                // Modify the course
                currentEnrollStudent.add(student);
                course.setEnrollStudent(currentEnrollStudent);

                currentCredits.add(givenCredit);
                course.setCredits(currentCredits);

                return true;
            }
        }
        return false;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseID, int givenCredit) {
        if (!this.getIfOpen())
            return false;
        
        if (givenCredit <= 0)
            return false;
        
        int myCredit = student.getCredits();
        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseID)) {
                ArrayList<Student> currentEnrollStudent = course.getEnrollStudent();
                ArrayList<Integer> currentCredits = course.getCredits();

                int index = currentEnrollStudent.indexOf(student);
                if (index == -1)
                    return false;

                // Modify the student
                int biddenCredit = currentCredits.get(index);
                if (biddenCredit + myCredit < givenCredit)
                    return false;
                
                // Here needs no modification, just a check of whether the course is
                // already being in the student.getEnrollCourses() list
                ArrayList<Course> studentEnrollCourses = student.getEnrollCourses();
                if (!studentEnrollCourses.contains(course))
                    CourseManager.ManuallyMakeAnError(); // Manually make a TLE result

                int newCreditNumber = biddenCredit + myCredit - givenCredit;
                student.setCredits(newCreditNumber);

                // Modify the course
                currentCredits.set(index, givenCredit);
                course.setCredits(currentCredits);

                return true;
            }
        }
        return false;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseID) {
        if (!this.getIfOpen())
            return false;

        int myCredit = student.getCredits();
        for (Course course : this.courses) {
            if (course.getCourseID().equals(courseID)) {
                ArrayList<Student> currentEnrollStudent = course.getEnrollStudent();
                ArrayList<Integer> currentCredits = course.getCredits();

                int index = currentEnrollStudent.indexOf(student);
                if (index == -1) // Currently not in the course
                    return false;

                // Modify the student
                ArrayList<Course> studentEnrollCourses = student.getEnrollCourses();
                if (!studentEnrollCourses.contains(course))
                    CourseManager.ManuallyMakeAnError(); // Manually make a TLE result
                int biddenCredit = currentCredits.get(index);
                int newCreditNumber = biddenCredit + myCredit;
                student.setCredits(newCreditNumber);
                studentEnrollCourses.remove(course);
                student.setEnrollCourses(studentEnrollCourses);

                // Modify the course
                currentEnrollStudent.remove(index);
                currentCredits.remove(index);

                return true;
            }
        }
        return false;
    }

    // Pair class for the algorithm
    private static class StudentWithCredits {
        int credits;
        Student student;
        StudentWithCredits(Student student, int credits) {
            this.student = student;
            this.credits = credits;
        }
        public int getCredits() {
            return this.credits;
        }
        public Student getStudent() {
            return this.student;
        }
    }
    // The final algorithm
    public void finalizeEnrollments() {
        if (!this.getIfOpen())
            CourseManager.ManuallyMakeAnError();

        this.setIfOpen(false);

        // The final algorithm consists of several steps:
        // 1. For each course in the course list, do the following;
        // 2. Decide which students can register the course;
        // -  In this process, we need to:
        // -  (I)  Firstly, sort the enrolled students of this course by the bidden credits
        //         in the descending order;
        // -  (II) Then, cut the students with the same credits number off
        //         at the end of the student list. The length of the success student list
        //         should be controlled within the max capacity of the course;
        // 3. Modify the course's success student list;
        // 4. For each success student in the student list of this course,
        //    modify the student's success course list;

        for (Course course : this.courses) {
            ArrayList<Student> finalEnrollStudent = course.getEnrollStudent();
            ArrayList<Integer> finalStudentCredits = course.getCredits();
            ArrayList<StudentWithCredits> sortingPairs = new ArrayList<StudentWithCredits>();
            for (int i = 0; i < finalEnrollStudent.size(); ++i) {
                sortingPairs.add(new StudentWithCredits(
                    finalEnrollStudent.get(i), finalStudentCredits.get(i)
                ));
            }
            sortingPairs.sort(new Comparator<StudentWithCredits>() {
                public int compare(StudentWithCredits s1, StudentWithCredits s2) {
                    int c1 = s1.getCredits();
                    int c2 = s2.getCredits();
                    return Integer.compare(c2, c1); // Reverse (=descending) order
                }
            });
            int creditsThisCourse = -1;
            int maxCapacityThisCourse = course.getMaxCapacity();

            for (int i = 0; i < sortingPairs.size(); ++i) {
                StudentWithCredits swc = sortingPairs.get(i);
                Student nowStudent = swc.getStudent();
                int nowCredit = swc.getCredits();

                if (i == maxCapacityThisCourse) { // Cut i >= capacity. Need to cut students off
                    creditsThisCourse = nowCredit;
                    break;
                }
            }

            ArrayList<Student> finalSuccessStudents = new ArrayList<Student>();
            for (StudentWithCredits swc : sortingPairs) {
                Student nowStudent = swc.getStudent();
                int nowCredit = swc.getCredits();

                if (nowCredit > creditsThisCourse) {
                    ArrayList<Course> successCourses = nowStudent.getSuccessCourses();
                    successCourses.add(course);
                    nowStudent.setSuccessCourses(successCourses);
                    finalSuccessStudents.add(nowStudent);
                } else {
                    break;
                }
            }
            course.setSuccessStudents(finalSuccessStudents);
        }
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.getIfOpen())
            return null;

        ArrayList<String> results = new ArrayList<String>();
        ArrayList<Course> studentEnrollCourses = student.getEnrollCourses();
        for (Course course : studentEnrollCourses) {
            String courseID = course.getCourseID();

            ArrayList<Student> currentEnrollStudent = course.getEnrollStudent();
            ArrayList<Integer> currentCredits = course.getCredits();

            int index = currentEnrollStudent.indexOf(student);
            if (index == -1)
                CourseManager.ManuallyMakeAnError();

            int biddenCredit = currentCredits.get(index);

            String newline = courseID + ": " + biddenCredit;
            results.add(newline);
        }
        return results;
    }
}
