import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;

    private ArrayList<Student> students;

    private boolean ifOpen;


    public CourseManager(ArrayList<Course> courses, ArrayList<Student> students) {
        this.courses = courses;
        this.students = students;
        this.ifOpen = true;
    }

    public CourseManager() {
        this.ifOpen = true;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean getIfOpen() {
        return this.ifOpen;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }

        boolean isCourseExist = false;
        Course courseIn = null;
        for (Course courseEach : courses) {
            String courseIdEach = courseEach.getCourseID();
            if (courseIdEach.equals(courseId)) {
                isCourseExist = true;
                courseIn = courseEach;
                break;
            }
        }
        if (!isCourseExist) {
            return false;
        }

        for (Course courseEach : student.getEnrollCourses()) {
            String courseIdEach = courseEach.getCourseID();
            if (courseIdEach.equals(courseId)) {
                return false;
            }
        }

        int creditsCurrent = student.getCredits();
        if (credits > creditsCurrent || credits <= 0) {
            return false;
        }

        int creditsUpdated = creditsCurrent - credits;
        student.setCredits(creditsUpdated);
        ArrayList<Course> coursesEnrolled = new ArrayList<>(student.getEnrollCourses());
        coursesEnrolled.add(courseIn);
        student.setEnrollCourses(coursesEnrolled);
        ArrayList<Integer> creditsEnrolled = new ArrayList<>(courseIn.getCredits());
        creditsEnrolled.add(credits);
        courseIn.setCredits(creditsEnrolled);
        ArrayList<Student> studentsEnrolled = new ArrayList<>(courseIn.getEnrollStudent());
        studentsEnrolled.add(student);
        courseIn.setEnrollStudent(studentsEnrolled);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }

        boolean isCourseExist = false;
        Course courseIn = null;
        for (Course courseEach : courses) {
            String courseIdEach = courseEach.getCourseID();
            if (courseIdEach.equals(courseId)) {
                isCourseExist = true;
                courseIn = courseEach;
                break;
            }
        }
        if (!isCourseExist) {
            return false;
        }

        boolean isEnrolled = false;
        for (Course courseEach : student.getEnrollCourses()) {
            String courseIdEach = courseEach.getCourseID();
            if (courseIdEach.equals(courseId)) {
                isEnrolled = true;
                break;
            }
        }
        if (!isEnrolled) {
            return false;
        }

        int creditsCurrent = student.getCredits();
        int idxPreviousCredits = courseIn.getEnrollStudent().indexOf(student);
        int creditsPrevious = (courseIn.getCredits()).get(idxPreviousCredits);
        if (credits <= 0 || credits > creditsCurrent + creditsPrevious) {
            return false;
        }

        courseIn.getCredits().set(idxPreviousCredits, credits);
        int creditsUpdated = creditsCurrent + creditsPrevious - credits;
        student.setCredits(creditsUpdated);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }

        boolean isCourseExist = false;
        Course courseIn = null;
        for (Course courseEach : courses) {
            String courseIdEach = courseEach.getCourseID();
            if (courseIdEach.equals(courseId)) {
                isCourseExist = true;
                courseIn = courseEach;
                break;
            }
        }
        if (!isCourseExist) {
            return false;
        }

        boolean isEnrolled = false;
        for (Course courseEach : student.getEnrollCourses()) {
            String courseIdEach = courseEach.getCourseID();
            if (courseIdEach.equals(courseId)) {
                isEnrolled = true;
                break;
            }
        }
        if (!isEnrolled) {
            return false;
        }

        int idxPrevious = courseIn.getEnrollStudent().indexOf(student);
        int creditsPrevious = courseIn.getCredits().get(idxPrevious);
        courseIn.getEnrollStudent().remove(idxPrevious);
        courseIn.getCredits().remove(idxPrevious);
        int creditsCurrent = student.getCredits();
        int creditsUpdated = creditsCurrent + creditsPrevious;
        student.setCredits(creditsUpdated);
        student.getEnrollCourses().remove(courseIn);

        return true;
    }

    public void finalizeEnrollments() {

        this.ifOpen = false;

        boolean isExceed;
        for (Course courseEach : courses) {
            int capacityMax = courseEach.getMaxCapacity();
            int numOfStudentsEnrolled = courseEach.getEnrollStudent().size();
            isExceed = (numOfStudentsEnrolled > capacityMax);

            ArrayList<Student> studentsEnrolled = new ArrayList<>(courseEach.getEnrollStudent());
            if (!isExceed) {
                courseEach.setSuccessStudents(studentsEnrolled);
                for (Student studentEach : studentsEnrolled) {
                    ArrayList<Course> coursesSuccess = new ArrayList<>(studentEach.getSuccessCourses());
                    studentEach.setSuccessCourses(coursesSuccess);
                }
            } else {
                int[][] arrIdxAndCredits = new int[numOfStudentsEnrolled][2];
                ArrayList<Integer> creditsList = new ArrayList<>(courseEach.getCredits());
                for (int i = 0; i < numOfStudentsEnrolled; i++) {
                    arrIdxAndCredits[i][0] = i;
                    arrIdxAndCredits[i][1] = creditsList.get(i);
                }
                for (int i = numOfStudentsEnrolled - 2; i >= 0; i--) {
                    for (int j = 0; j <= i; j++) {
                        if (arrIdxAndCredits[j][1] < arrIdxAndCredits[j + 1][1]) {
                            int idxTemp = arrIdxAndCredits[j][0];
                            int creditsTemp = arrIdxAndCredits[j][1];
                            arrIdxAndCredits[j][0] = arrIdxAndCredits[j + 1][0];
                            arrIdxAndCredits[j][1] = arrIdxAndCredits[j + 1][1];
                            arrIdxAndCredits[j + 1][0] = idxTemp;
                            arrIdxAndCredits[j + 1][1] = creditsTemp;
                        }
                    }
                }

                for (int i = 0; i < capacityMax; i++) {
                    int[] idxAndCredits = arrIdxAndCredits[i];
                    ArrayList<Student> studentsSuccess = new ArrayList<>(courseEach.getSuccessStudents());
                    studentsSuccess.add(studentsEnrolled.get(idxAndCredits[0]));
                    courseEach.setSuccessStudents(studentsSuccess);
                }

                int creditsOfLastOneSuccess = arrIdxAndCredits[capacityMax - 1][1];
                int creditsOfFirstOneFailed = arrIdxAndCredits[capacityMax][1];
                if (creditsOfLastOneSuccess == creditsOfFirstOneFailed) {
                    int idxRemove = capacityMax - 1;
                    while (true) {
                        if (arrIdxAndCredits[idxRemove][1] != creditsOfFirstOneFailed) {
                            break;
                        } else {
                            Student studentRemove = studentsEnrolled.get(arrIdxAndCredits[idxRemove][0]);
                            ArrayList<Student> studentsSuccess = new ArrayList<>(courseEach.getSuccessStudents());
                            studentsSuccess.remove(studentRemove);
                            courseEach.setSuccessStudents(studentsSuccess);
                            idxRemove--;
                            if (idxRemove < 0) {
                                break;
                            }
                        }
                    }
                }

                for (Student studentEach : courseEach.getSuccessStudents()) {
                    ArrayList<Course> coursesSuccess = new ArrayList<>(studentEach.getSuccessCourses());
                    coursesSuccess.add(courseEach);
                    studentEach.setSuccessCourses(coursesSuccess);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        String studentID = student.getStudentID();
        ArrayList<Course> coursesEnrolled = new ArrayList<>(student.getEnrollCourses());
        ArrayList<String> coursesWithCredits = new ArrayList<>(coursesEnrolled.size());
        for (Course courseEach : coursesEnrolled) {
            String strEach = getString(courseEach, studentID);
            coursesWithCredits.add(strEach);
        }
        return coursesWithCredits;
    }

    private static String getString(Course courseEach, String studentID) {
        ArrayList<Student> studentsEnrolled = new ArrayList<>(courseEach.getEnrollStudent());
        int idxOfStudent = 0;
        for (int idx = 0; idx < studentsEnrolled.size(); idx++) {
            Student studentEach = studentsEnrolled.get(idx);
            String studentIdEach = studentEach.getStudentID();
            if (studentIdEach.equals(studentID)) {
                idxOfStudent = idx;
                break;
            }
        }
        ArrayList<Integer> creditsList = new ArrayList<>(courseEach.getCredits());
        int creditsUsedEach = creditsList.get(idxOfStudent);
        String courseIdEach = courseEach.getCourseID();
        return String.format("%s: %d", courseIdEach, creditsUsedEach);
    }
}
