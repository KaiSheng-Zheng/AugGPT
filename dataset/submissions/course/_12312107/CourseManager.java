import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;


    public ArrayList<Student> getStudents() {
        return students;
    }

    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
        ifOpen = true;

    }

    public CourseManager(ArrayList<Course> courses, ArrayList<Student> students) {
        this.courses = courses;
        this.students = students;
        this.ifOpen = true;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifOpen) {
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

    /**
     * Attempts to enroll a Student in a Course.
     * Enrollment will only be successful if the course exists, the student has not already enrolled, the credits to bid is greater than 0, and they have enough credits to bid.
     * If successful, the student's credits will be reduced by the amount bid on the course. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if student enroll this course successfully; otherwise, it returns false.
     */
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
        int j = -1;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return false;
        }

        for (int i = 0; i < courses.get(j).getEnrollStudent().size(); i++) {
            if (courses.get(j).getEnrollStudent().get(i).equals(student)) {
                return false;
            }
        }

        if (student.getCredits() < credits || credits <= 0) {
            return false;
        }
        courses.get(j).getEnrollStudent().add(student);
        courses.get(j).getCredits().add(credits);/////11111111
        student.enrollCourse(courseId,credits);
        student.getEnrollCourses().add(courses.get(j));
        student.setCredits(student.getCredits() - credits);

        return true;
    }

    /**
     * Modifies the number of credits a student has bid on an already enrolled course.
     * The modification will only be successful if the course exists, the student is currently enrolled in the course,and the new bid is within the student's available credits. This can be used to increase or decrease the bid.
     * On a successful bid modification, the student's credits will be updated to reflect the new bid amount. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the bid modification was successful; otherwise, it returns false.
     */
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;
        int j = -1;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                j = i;
                break;
            }
        }
        if (j == -1) return false;
        int k = -1;
        for (int i = 0; i < courses.get(j).getEnrollStudent().size(); i++) {
            if (courses.get(j).getEnrollStudent().get(i).equals(student)) {
                k = i;
                break;
            }
        }
        if (k == -1) return false;
        if (student.getCredits() + courses.get(j).getCredits().get(k) < credits) {return false;}
        student.setCredits(student.getCredits() + courses.get(j).getCredits().get(k) - credits);
        courses.get(j).getCredits().set(k, credits);
        return true;
    }

    /**
     * Drops a student's enrollment from a specific course.
     * The drop will succeed only if the course exists, and the student is currently enrolled in it.
     * If ifOpen is true, upon a successful drop, any credits the student had bid for this course will be refunded in full. The corresponding list in Student and Course should be updated.
     * Only available when ifOpen is true. Return false if ifOpen is false.
     *
     * @return boolean  Returns true if the student successfully drops the course; otherwise, it returns false.
     */
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if(!ifOpen) return false;
        int j = -1;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                j = i;
                break;
            }
        }
        if (j == -1) return false;
        int k = -1;
        for (int i = 0; i < courses.get(j).getEnrollStudent().size(); i++) {
            if (courses.get(j).getEnrollStudent().get(i).equals(student)) {
                k = i;
                break;
            }
        }
        if (k == -1) return false;
        student.setCredits(student.getCredits() + courses.get(j).getCredits().get(k));
        courses.get(j).getCredits().remove(k);
        courses.get(j).getEnrollStudent().remove(k);
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).equals(courses.get(j))) {
                student.getEnrollCourses().remove(i);
                break;
            }
        }
        return true;
    }

    /**
     * Completes the course registration process. Change ifOpen to false.
     * This method resolves which students get into each course based on their bids and the course capacities. Students with higher bids are prioritized. The corresponding list in Student and Course should be updated.
     * Only successStudents in class Course and successCourses in class Student need to be updated.
     */
    public void finalizeEnrollments() {
        for (int i = 0; i < courses.size(); i++) {
            sort(courses.get(i).getCredits(), courses.get(i).getEnrollStudent());
            ArrayList<Student> list = new ArrayList<>();
            int capacity = courses.get(i).getMaxCapacity();
            for (int j = 0; j < Math.min(capacity, courses.get(i).getEnrollStudent().size()); j++) {
                list.add(courses.get(i).getEnrollStudent().get(j));
            }
            if (capacity >= courses.get(i).getEnrollStudent().size()) {
                courses.get(i).setSuccessStudents(list);
                for (int j = 0; j <list.size() ; j++) {
                    list.get(j).getSuccessCourses().add(courses.get(i));
                    list.get(j).setCourseManager(this);////11
                    if(!students.contains(list.get(j)))students.add(list.get(j));
                }
            }else {
                int sub = courses.get(i).getCredits().get(capacity);
                int num = -1;
                for (int j = 0; j < capacity; j++) {
                    if (courses.get(i).getCredits().get(capacity - 1 - j) > sub) {
                        num = capacity - 1 - j;
                        break;
                    }
                }
                ArrayList<Student> list1 = new ArrayList<>();
                for (int j = 0; j < num+1 ; j++) {
                    list1.add(list.get(j));
                }//expected: <true> but was: <false>
                for (int j = 0; j <list1.size() ; j++) {
                    for (int k = j+1; k <list1.size() ; k++) {
                        if(list1.get(k).equals(list1.get(j))){list1.remove(j);j--;break;}
                    }
                }
                courses.get(i).setSuccessStudents(list1);//expect false but true
                for (int k = 0; k < list1.size(); k++) {
                    list1.get(k).getSuccessCourses().add(courses.get(i));
                    list1.get(k).setCourseManager(this);
                    if(!students.contains(list1.get(k))){students.add(list1.get(k));}
                }
            }
        }
        ifOpen = false;
    }

    public void sort(ArrayList<Integer> list, ArrayList<Student> studentArrayList) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    int sub = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, sub);
                    Student stu = studentArrayList.get(i);
                    studentArrayList.set(i, studentArrayList.get(j));
                    studentArrayList.set(j, stu);
                }
            }

        }
    }
//org.opentest4j.AssertionFailedError: expected: <false> but was: <true>
    //org.opentest4j.AssertionFailedError: expected: <false> but was: <true>

    /**
     * Retrieves a list of courses with associated credits for a given student.
     * Each String in the list includes the course ID and the points bid by the student in enrollCourses, follow the format: "courseID: enrollmentCredits" (without quotes).
     * Only available when ifOpen is true. Return null if ifOpen is false.
     *
     * @return A list of Strings, each representing the courses and the respective credits the student enrolled.
     */
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            int k = -1;
            for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                if (student.equals(student.getEnrollCourses().get(i).getEnrollStudent().get(j))) {
                    k = j;
                    break;
                }
            }
            if (k == -1) continue;
            String str = student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(k);
            list.add(str);
        }
        return list;
    }

}
