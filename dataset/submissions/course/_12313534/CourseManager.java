import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

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

    public boolean getIfOpen() {
        return ifOpen;
    }

    public boolean isIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addCourse(Course course) {

        if (courses == null) {
            courses.add(course);
            course.setCourseManager(this);

        } else {
            int count = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (Objects.equals(course.getCourseID(), courses.get(i).getCourseID())) {
                    count++;
                }
            }
            if (count == 0) {
                courses.add(course);

                course.setCourseManager(this);
            }
        }


    }

    public void addStudent(Student student) {
        if (students == null) {
            students.add(student);

            student.setCourseManager(this);

        } else {
            int count = 0;
            for (int i = 0; i < students.size(); i++) {
                if (Objects.equals(student.getStudentID(), students.get(i).getStudentID())) {
                    count++;
                }
            }
            if (count == 0) {
                students.add(student);
                student.setCourseManager(this);
            }
        }


    }

//    private Course getcourse(String courseid) {
//        if (courses==null){
//            return null;
//        }
//        for (int i = 0; i < courses.size(); i++) {
//            if (courses.get(i).getCourseID().equals(courseid)) {
//                return courses.get(i);
//            }
//        }return null;
//
//    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
//        if (!ifOpen) {
//            return false;
//        }
//        Course course = getcourse(courseId);
//        if (course == null || student == null) {
//            return false;
//        }
//        if (student.getEnrollCourses().contains(course) || credits <= 0) {
//            return false;
//        }
//        student.setCredits(student.getCredits() - credits);
//        ArrayList<Course> temp = student.getEnrollCourses();
//        temp.add(course);
//        student.setEnrollCourses(temp);
//        return true;

        if (ifOpen == false || credits <= 0) {
            return false;
        } else {
            int temp = 0;
            int temp0 = 0;
            int flag = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (Objects.equals(courseId, courses.get(i).getCourseID())) {
                    flag = i;
                    temp0 = -1;

                }

            }
            if (temp0 != -1) {
                return false;
            } else {
                for (int i = 0; i < courses.get(flag).getEnrollStudent().size(); i++) {
                    if (Objects.equals(student.getStudentID(), courses.get(flag).getEnrollStudent().get(i).getStudentID())) {
                        temp++;
                    }

                }
                if (credits > student.getCredits()) {
                    temp++;
                }
                if (temp == 0) {

                    int tempcredit = student.getCredits();
                    student.setCredits(tempcredit - credits);
                    ArrayList<Student> tempstudent = courses.get(flag).getEnrollStudent();
                    tempstudent.add(student);
                    courses.get(flag).setEnrollStudent(tempstudent);
                    ArrayList<Integer> tempcredits = courses.get(flag).getCredits();
                    tempcredits.add(credits);
                    courses.get(flag).setCredits(tempcredits);

                    ArrayList<Course> tempcourse = student.getEnrollCourses();
                    tempcourse.add(courses.get(flag));
                    student.setEnrollCourses(tempcourse);


                    return true;
                }
            }


        }
        return false;


    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {

//        if (!ifOpen || credits <= 0) {
//            return false;
//        }
//        Course course = getcourse(courseId);
//        if (course == null || student == null) {
//            return false;
//        }
//        if (!student.getEnrollCourses().contains(course)) {
//            return false;
//        }
//        int tempcredit = student.getCredits();
//        int index = 0;
//        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
//            if (Objects.equals(course.getEnrollStudent().get(i), student)) {
//                index = i;
//            }
//        }
//        int finalcredit = tempcredit + course.getCredits().get(index) - credits;
//        if (finalcredit < 0) {
//            return false;
//        }
//        student.setCredits(finalcredit);
//        ArrayList<Integer> tempnum = course.getCredits();
//        tempnum.set(index, credits);
//        course.setCredits(tempnum);
//        return true;


        if (!ifOpen || credits <= 0) {
            return false;
        } else {
            int temp = 0;
            int temp0 = 0;
            int temp3 = 0;
            int flag = 0;
            int flagstudent = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {
                    flag = i;
                    temp0 = -1;

                }

            }
            if (temp0 != -1) {
                return false;
            } else {
                for (int i = 0; i < courses.get(flag).getEnrollStudent().size(); i++) {
                    if (Objects.equals(student.getStudentID(), courses.get(flag).getEnrollStudent().get(i).getStudentID())) {
                        temp++;
                        flagstudent = i;
                    }

                }
                if (credits > student.getCredits() + courses.get(flag).getEnrollStudent().get(flagstudent).getCredits()) {
                    temp3++;
                }
                if (temp == 1 && temp3 == 0) {
                    int temp1 = 0;
                    for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                        if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())) {
                            temp1 = i;
                        }
                    }
                    int tempcredit = student.getCredits() + courses.get(flag).getCredits().get(flagstudent);
                    student.setCredits(tempcredit - credits);
                    ArrayList<Student> tempstudent = courses.get(flag).getEnrollStudent();
                    tempstudent.set(flagstudent, student);
                    courses.get(flag).setEnrollStudent(tempstudent);
                    ArrayList<Integer> tempcredits = courses.get(flag).getCredits();
                    tempcredits.set(flagstudent, credits);
                    courses.get(flag).setCredits(tempcredits);

                    ArrayList<Course> tempcourse = student.getEnrollCourses();
                    tempcourse.set(temp1, courses.get(flag));
                    student.setEnrollCourses(tempcourse);


                    return true;
                }
            }


        }
        return false;

    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
//        if (!ifOpen) {
//            return false;
//        }
//        Course course = getcourse(courseId);
//        if (course == null || student == null || !student.getEnrollCourses().contains(course)) {
//            return false;
//        }
//        int tempcredit = student.getCredits();
//        int index = 0;
//        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
//            if (Objects.equals(course.getEnrollStudent().get(i), student)) {
//                index = i;
//            }
//        }
//        int finalcredit = tempcredit + course.getCredits().get(index);
//        student.setCredits(finalcredit);
//        ArrayList<Course> tempcourse = student.getEnrollCourses();
//        tempcourse.remove(course);
//        student.setEnrollCourses(tempcourse);
//        ArrayList<Student> tempstudent = course.getEnrollStudent();
//        tempstudent.remove(student);
//        course.setEnrollStudent(tempstudent);
//        ArrayList<Integer> tempnum = course.getCredits();
//        tempnum.remove(index);
//        course.setCredits(tempnum);
//        return true;

        if (ifOpen == false) {
            return false;
        } else {
            int temp = 0;
            int temp0 = 0;
            int flag = 0;
            int flagstudent = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (courseId.equals(courses.get(i).getCourseID())) {
                    flag = i;
                    temp0 = -1;

                }

            }
            if (temp0 != -1) {
                return false;
            } else {
                for (int i = 0; i < courses.get(flag).getEnrollStudent().size(); i++) {
                    if (student.getStudentID().equals(courses.get(flag).getEnrollStudent().get(i).getStudentID())) {
                        temp++;
                        flagstudent = i;
                    }

                }

                if (temp == 1) {
                    int temp1 = 0;
                    for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                        if (courseId.equals(student.getEnrollCourses().get(i).getCourseID())) {
                            temp1 = i;
                        }
                    }
                    int tempcredit = student.getCredits() + courses.get(flag).getCredits().get(flagstudent);
                    student.setCredits(tempcredit);
                    ArrayList<Student> tempstudent = courses.get(flag).getEnrollStudent();
                    tempstudent.remove(flagstudent);
                    courses.get(flag).setEnrollStudent(tempstudent);
                    ArrayList<Integer> tempcredits = courses.get(flag).getCredits();
                    tempcredits.remove(flagstudent);
                    courses.get(flag).setCredits(tempcredits);

                    ArrayList<Course> tempcourse = student.getEnrollCourses();
                    tempcourse.remove(temp1);
                    student.setEnrollCourses(tempcourse);


                    return true;
                }
            }


        }
        return false;


    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Student> rearrangestudent = courses.get(i).getEnrollStudent();
            rearrangestudent.sort(Comparator.comparingInt(Student::getCredits).reversed());
            if (rearrangestudent.size() <= courses.get(i).getMaxCapacity()) {
                courses.get(i).setSuccessStudents(rearrangestudent);
            } else {
                int bound = rearrangestudent.get(courses.get(i).getMaxCapacity()-1).getCredits();
                int count = 0;
                for (int i1 = 0; i1 < rearrangestudent.size(); i1++) {
                    if (rearrangestudent.get(i1).getCredits() >= bound) {
                        count++;
                    }
                }
                ArrayList<Student> finalstudent = new ArrayList<>();
                if (count <= courses.get(i).getMaxCapacity()) {
                    for (int i2 = 0; i2 < rearrangestudent.size(); i2++) {
                        if (rearrangestudent.get(i2).getCredits() >= bound) {
                            finalstudent.add(rearrangestudent.get(i2));

                        }
                    }

                } else {
                    for (int i2 = 0; i2 < rearrangestudent.size(); i2++) {
                        if (rearrangestudent.get(i2).getCredits() > bound) {
                            finalstudent.add(rearrangestudent.get(i2));

                        }
                    }
                }
                courses.get(i).setSuccessStudents(finalstudent);
                for (int i1 = 0; i1 < courses.get(i).getSuccessStudents().size(); i1++) {
                    ArrayList<Course>tempcourse=courses.get(i).getSuccessStudents().get(i1).getSuccessCourses();
                    tempcourse.add(courses.get(i));
                    courses.get(i).getSuccessStudents().get(i1).setSuccessCourses(tempcourse);
                }


            }
        }
//        for (int i = 0; i < courses.size(); i++) {
//            if (courses.get(i).getMaxCapacity() >= courses.get(i).getEnrollStudent().size()) {
//                courses.get(i).setSuccessStudents(courses.get(i).getEnrollStudent());
//                for (int i0 = 0; i0 < courses.get(i).getEnrollStudent().size(); i0++) {
//                    ArrayList<Course> tempcourses = courses.get(i).getEnrollStudent().get(i0).getEnrollCourses();
//                    tempcourses.add(courses.get(i));
//                    courses.get(i).getEnrollStudent().get(i0).setSuccessCourses(tempcourses);
//                }
//            } else {
//                ArrayList<Student> tempstudent = courses.get(i).getEnrollStudent();
//                tempstudent.sort(Comparator.comparingInt(Student::getCredits).reversed());
//                int bound = tempstudent.get(courses.get(i).getMaxCapacity() - 1).getCredits();
//                ArrayList<Student> tempsuccessstudent = new ArrayList<>();
//                int count = 0;
//                for (int i1 = 0; i1 < tempstudent.size(); i1++) {
//                    if (tempstudent.get(i1).getCredits() >= bound) {
//                        count++;
//                    }
//                }
//                if (count <= courses.get(i).getMaxCapacity()) {
//                    for (int i1 = 0; i1 < tempstudent.size(); i1++) {
//                        if (tempstudent.get(i1).getCredits() >= bound) {
//                            tempsuccessstudent.add(tempstudent.get(i1));
//                        }
//                    }
//                } else {
//                    for (int i1 = 0; i1 < tempstudent.size(); i1++) {
//                        if (tempstudent.get(i1).getCredits() > bound) {
//                            tempsuccessstudent.add(tempstudent.get(i1));
//                        }
//                    }
//
//
//                    courses.get(i).setSuccessStudents(tempsuccessstudent);
//
//
//                    for (int i1 = 0; i1 < courses.get(i).getSuccessStudents().size(); i1++) {
//                        ArrayList<Course> tempcourses = courses.get(i).getEnrollStudent().get(i1).getSuccessCourses();
//                        tempcourses.add(courses.get(i));
//                        courses.get(i).getEnrollStudent().get(i1).setSuccessCourses(tempcourses);
//                    }
//
//                }
//
//            }
//
//        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrolledcourses = new ArrayList<>();
        for (int i = 0; i < student.getSuccessCourses().size(); i++) {
            int temp0 = 0;
            for (int i1 = 0; i1 < student.getSuccessCourses().get(i).getSuccessStudents().size(); i1++) {
                if (Objects.equals(student.getStudentID(), student.getSuccessCourses().get(i).getSuccessStudents().get(i1).getStudentID())) {
                    temp0 = student.getSuccessCourses().get(i).getSuccessStudents().get(i1).getCredits();
                }
            }

            String temp = student.getSuccessCourses().get(i).getCourseID() + ": " + temp0;
            enrolledcourses.add(temp);
        }
        return enrolledcourses;
    }
}











