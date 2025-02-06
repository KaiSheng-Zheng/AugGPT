import java.util.ArrayList;
import java.util.Iterator;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
        ifOpen = true;
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

    public boolean enrollStudentInCourse(Student student, String courseId, int
            credits) {
        if (!ifOpen || credits <= 0 || student.getCredits() < credits) {
            return false;
        }
        int flag = 0;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                flag = 1;
            }
        }
        if(flag == 0) {
            return false;
        }
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                return false;
            }
        }
        int curCredits = student.getCredits();
        student.setCredits(curCredits - credits);
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                ArrayList<Student> enrollStudent = course.getEnrollStudent();
                enrollStudent.add(student);
                course.setEnrollStudent(enrollStudent);
                ArrayList<Integer> new_credits = course.getCredits();
                new_credits.add(credits);
                course.setCredits(new_credits);
                ArrayList<Course> enrollCourses = student.getEnrollCourses();
                enrollCourses.add(course);
                student.setEnrollCourses(enrollCourses);
            }
        }
        return true;

    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int
            credits) {
        if (!ifOpen) {
            return false;
        }
        int flag = 0;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                flag = 1;
            }
        }
        if(flag == 0) {
            return false;
        }
        int old_credits = 0;
        int index = 0;
        flag = 0;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                for(Student curStudent : course.getEnrollStudent()) {
                    if(curStudent.getStudentID().equals(student.getStudentID())) {
                        index = course.getEnrollStudent().indexOf(curStudent);
                        old_credits = course.getCredits().get(index);
                    }
                }
                flag = 1;
            }
        }
        if(flag == 0) {
            return false;
        }
        int curCredits = student.getCredits();
        if(curCredits + old_credits - credits < 0) {
            return false;
        }
        student.setCredits(curCredits + old_credits - credits);
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                for(Student curStudent : course.getEnrollStudent()) {
                    if(curStudent.getStudentID().equals(student.getStudentID())) {
                        index = course.getEnrollStudent().indexOf(curStudent);
                        old_credits = course.getCredits().get(index);
                        ArrayList<Integer> new_credits = course.getCredits();
                        new_credits.set(index, credits);
                        course.setCredits(new_credits);
                    }
                }
            }
        }
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
        int flag = 0;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                flag = 1;
            }
        }
        if(flag == 0) {
            return false;
        }
        int old_credits = 0;
        int index = 0;
        flag = 0;
        for (Course course : student.getEnrollCourses()) {
            if (course.getCourseID().equals(courseId)) {
                flag = 1;
                break;
            }
        }
        if(flag == 0) {
            return false;
        }
        Iterator<Course> courseIterator = student.getEnrollCourses().iterator();
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            if (course.getCourseID().equals(courseId)) {
                Iterator<Student> studentIterator = course.getEnrollStudent().iterator();
                while (studentIterator.hasNext()) {
                    Student curStudent = studentIterator.next();
                    if (curStudent.getStudentID().equals(student.getStudentID())) {
                        index = course.getEnrollStudent().indexOf(curStudent);
                        old_credits = course.getCredits().get(index);
                        ArrayList<Integer> new_credits = course.getCredits();
                        new_credits.remove(index);
                        course.setCredits(new_credits);
                        studentIterator.remove();
                        courseIterator.remove();
                        break;
                    }
                }
            }
        }
        int curCredits = student.getCredits();
        student.setCredits(curCredits + old_credits);

        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrolledCourses = new ArrayList<>();
        int index;
        for(Course course : student.getEnrollCourses()) {
            for(Student curStudent : course.getEnrollStudent()) {
                if(curStudent.getStudentID().equals(student.getStudentID())) {
                    index = course.getEnrollStudent().indexOf(curStudent);
                    int curCredits = course.getCredits().get(index);
                    String tmp = String.format("%s: %d", course.getCourseID(), curCredits);
                    enrolledCourses.add(tmp);
                }
            }
        }
    return enrolledCourses;
    }
    private static int countGreaterOrEqual(ArrayList<Integer> list, int value) {
        int count = 0;
        for (int num : list) {
            if (num >= value) {
                count++;
            }
        }
        return count;
    }
    public void finalizeEnrollments() {
        ifOpen = false;
        int needCredits = Integer.MAX_VALUE;
        for(Course course : courses) {
            ArrayList<Integer> tmpCredits = course.getCredits();
            for(Integer i : tmpCredits) {
                int num = countGreaterOrEqual(tmpCredits,i);
                if(num <= course.getMaxCapacity() && i < needCredits) {
                    needCredits = i;
                }
            }
            for(Integer curCredit : course.getCredits()) {
                if(curCredit >= needCredits) {
                    int index = course.getCredits().indexOf(curCredit);
                    ArrayList<Student> successStudents = course.getSuccessStudents();
                    successStudents.add(course.getEnrollStudent().get(index));
                    course.setSuccessStudents(successStudents);
                    ArrayList<Course> successCourses = course.getEnrollStudent().get(index).getSuccessCourses();
                    successCourses.add(course);
                    course.getEnrollStudent().get(index).setSuccessCourses(successCourses);

                }
            }
        }

    }






}
