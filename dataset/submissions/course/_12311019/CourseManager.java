import java.util.ArrayList;

public class CourseManager {
    private boolean ifOpen;
    private ArrayList<Course> courses;
    // Maintains a record of all courses successfully registered.
    // It is guaranteed that students enrolled in a course must exist in students.
    private ArrayList<Student> students;
    // no getter

    // Maintains a record of all students successfully registered.
    // It is guaranteed that courses student enrolled in must exist in courses.
    public boolean getIfOpen() {
        return ifOpen;
    }

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        setIfOpen(true);
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean isIfOpen() {
        return ifOpen;
    }

    public void addStudent(Student student1) {
        students.add(student1);
        student1.setCourseManager(this);
    }

    public void addCourse(Course course1) {
        courses.add(course1);
        course1.setCourseManager(this);
    }

    // Maintains a record of all students successfully registered.
    // It is guaranteed that courses student enrolled in must exist in courses.
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean ifEn = false;
        if (!isIfOpen()) {
            return false;
        } else if (credits > 0 && credits <= student.getCredits()) {
            for (int j = 0; j < courses.size(); j++) {
                if (courses.get(j).getCourseID().equals(courseId)) {
                    ifEn = true;
                    break;
                }
                for (int i = 0; i < student.getEnrollCourses().size() && ifEn; i++) {
                    if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                        ifEn = false;
                    }
                }
            }

            if (ifEn) {
                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).getCourseID().equals(courseId)) {
                        courses.get(i).getEnrollStudent().add(student);
                        courses.get(i).getCredits().add(credits);
                        student.getEnrollCourses().add(courses.get(i));
                        student.setCredits(student.getCredits() - credits);
                        break;
                    }
                }
            }
        }
        return ifEn;
    }

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Student markStudent;
        Course markCourse = new Course(null, null, 0);
        boolean ifModify = false;
        if (!ifOpen) {
            return false;
        } else {
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                    markCourse = student.getEnrollCourses().get(i);
                    for (int j = 0; j < markCourse.getEnrollStudent().size(); j++) {
                        if (markCourse.getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                            int temp = markCourse.getCredits().get(j);
                            student.setCredits(student.getCredits() + temp);
                            if (credits <= student.getCredits()) {
                                ifModify = true;
                            }
                        }
                    }
                }
            }
        }
        if (ifModify) {
            for (int i = 0; i < markCourse.getEnrollStudent().size(); i++) {
                if (markCourse.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    markStudent = markCourse.getEnrollStudent().get(i);
                    markCourse.getCredits().set(i, credits);
                    markStudent.setCredits(markStudent.getCredits() - credits);
                    break;
                }
            }
        }
        return ifModify;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean ifDrop = false;
        Course markCourse = new Course(null, null, 0);
        int OriginalCredit = 0;
        if (ifOpen) {
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                    ifDrop = true;
                    markCourse = student.getEnrollCourses().get(i);
                }
            }
            if (ifDrop) {
                for (int i = 0; i < markCourse.getEnrollStudent().size(); i++) {
                    if (markCourse.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                        OriginalCredit = markCourse.getCredits().get(i);
                        markCourse.getEnrollStudent().remove(i);
                        markCourse.getCredits().remove(i);
                    }
                }
                for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                    if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                        student.getEnrollCourses().remove(i);
                        student.setCredits(student.getCredits() + OriginalCredit);
                    }
                }
            }
        }
        return ifDrop;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently
     * enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid
     * for this course will be refunded in full. The corresponding list in Student and
     * Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean Returns true if the student successfully drops the course;
     * otherwise, it returns false.
     */
    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Integer> lowdownCredits=new ArrayList<>();
            lowdownCredits.addAll(courses.get(i).getCredits());
            LowDown(lowdownCredits);
            int max = courses.get(i).getMaxCapacity();
            int line;
            if (courses.get(i).getEnrollStudent().size() <= max) {
                line = 1;
            } else {
                lowdownCredits.add(0);
                line = lowdownCredits.get(max - 1);
                if (line == lowdownCredits.get(max)) {
                    line++;
                }
            }
            for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                if (courses.get(i).getCredits().get(j) >= line) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).getEnrollCourses().size(); j++) {
                if (students.get(i).getEnrollCourses().get(j).getSuccessStudents().contains(students.get(i))) {
                    students.get(i).getSuccessCourses().add(students.get(i).getEnrollCourses().get(j));
                }
            }
        }
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                if (courses.get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID()))
                {
                    list.add(String.format(courses.get(i).getCourseID()+": "+courses.get(i).getCredits().get(j)));
                }
            }
        }
        return list;
    }

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the
     * student in enrollCourses, follow the format: "courseID: enrollmentCredits"
     * (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     *
     * @return A list of Strings, each representing the courses and the respective
     * credits the student enrolled.
     */

    public static void LowDown(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size()-1; i++) {
            for (int j = i+1; j < arrayList.size(); j++) {
                if (arrayList.get(j)> arrayList.get(i))
                {
                    int temp=arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j,temp);
                }
            }
        }
    }
}

