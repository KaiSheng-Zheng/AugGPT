import java.util.ArrayList;

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

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);//Add a student object to students
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);//Add a student object to students
        course.setCourseManager(this);
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int
            credits) {
        if (!this.ifOpen)
            return false;
        if (credits <= 0 || credits > student.getCredits())
            return false;


        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;/*traverse the list of courses, if there's still
            none, it means that the course doesn't exist, which is one
            condition that returns false*/
        }
        Student student1 = null;
        for (Student eachStudent : course.getEnrollStudent()) {
            if (eachStudent.getStudentID().equals(student.getStudentID())) {
                student1 = eachStudent;
            }
        }
        if (!(student1 == null)) {
            return false;
        }
        /*If successful, you'll need to:*/
        /*reducing the points from the student after he's enrolled*/
        int creditsAfterBeingEnrolled = student.getCredits() - credits;
        student.setCredits(creditsAfterBeingEnrolled);

        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);


        return true;

    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId,
                                                  int credits) {
        //1
        if (!this.ifOpen)
            return false;
        //2

        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }


        //3
        Student student1 = null;
        for (Student eachStudent : course.getEnrollStudent()) {
            if (eachStudent.getStudentID().equals(student.getStudentID())) {
                student1 = eachStudent;
            }
        }
        if (student1 == null) {
            return false;
        }

        for (int wholeCourseNumber = 0; wholeCourseNumber < courses.size(); wholeCourseNumber++) {
            if (courses.get(wholeCourseNumber).getCourseID().equals(courseId)) {
                course = courses.get(wholeCourseNumber);
            }
            int index = -1;
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
                    index = i;
                    break;
                }
            }

            //If successful
            int originalCreditsBid = course.getCredits().get(index);

            int creditsAfterModification = student.getCredits() + originalCreditsBid - credits;
            // fail 4
            if (creditsAfterModification < 0)//bug check
                return false;
            //student
            student.setCredits(creditsAfterModification);

            //course

            course.getCredits().set(index, credits);//replacing method in Arraylist
        }
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        //1
        if (!this.ifOpen)
            return false;
        //2
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        //3 student must be enrolled
        Student student1 = null;
        for (Student eachStudent : course.getEnrollStudent()) {
            if (eachStudent.getStudentID().equals(student.getStudentID())) {
                student1 = eachStudent;
            }
        }
        if (student1 == null) {
            return false;
        }

        //If unsuccessful:
        //course:
        for (int wholeCourseNumber = 0; wholeCourseNumber < courses.size(); wholeCourseNumber++) {
            if (courses.get(wholeCourseNumber).getCourseID().equals(courseId)) {
                course = courses.get(wholeCourseNumber);
                //break;
            }
        }
        int index1 = -1;
        for (int studentNumber = 0; studentNumber < course.getEnrollStudent().size(); studentNumber++) {
            if (student.getStudentID().equals(course.getEnrollStudent().get(studentNumber).getStudentID())) {
                index1 = studentNumber;
                break;
            }
        }
        int removedCredit = course.getCredits().get(index1);

        ArrayList<Student> list1 = course.getEnrollStudent();
        list1.remove(index1);
        course.setEnrollStudent(list1);

        ArrayList<Integer> list2 = course.getCredits();
        list2.remove(index1);
        course.setCredits(list2);

        int index2 = -1;
        for (int j = 0; j < student.getEnrollCourses().size(); j++) {
            if (student.getEnrollCourses().get(j).getCourseID().equals(courseId)) {
                index2 = j;
                break;
            }
        }
        ArrayList<Course> list3 = student.getEnrollCourses();
        list3.remove(index2);//where wrong?
        student.setEnrollCourses(list3);

        int creditsAfterDroppingOutOfTheCourse = student.getCredits() + removedCredit;
        student.setCredits(creditsAfterDroppingOutOfTheCourse);


        return true;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {

        if (!this.ifOpen)
            return null;

        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        //finding the credit:
        Course course = null;

        int theCreditWeGet = 0;
        for (int courseNumber = 0; courseNumber < student.getEnrollCourses().size(); courseNumber++) {
            for (Course bigCourseNumber : courses) {
                if (student.getEnrollCourses().get(courseNumber).getCourseID().equals(bigCourseNumber.getCourseID())) {
                    course = bigCourseNumber;
                    break;
                }
            }
            int indexOfCreditPosition = -1;
            for (int studentNumber = 0; studentNumber < course.getEnrollStudent().size(); studentNumber++) {
                if (student.getStudentID().equals(course.getEnrollStudent().get(studentNumber).getStudentID())) {
                    indexOfCreditPosition = studentNumber;
                }
            }
            theCreditWeGet = course.getCredits().get(indexOfCreditPosition);
            String newCredit = String.valueOf(theCreditWeGet);
            enrolledCoursesWithCredits.add(course.getCourseID() + ": " + newCredit);

        }

//        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
//            if (student.getEnrollCourses().get(i).equals(course.getCourseID())) {
//                course = student.getEnrollCourses().get(i);
//
//                for (int j = 0; j < course.getEnrollStudent().size(); j++) {
//
//                    if (student.getStudentID().equals(course.getEnrollStudent().get(i).getStudentID())) {
//                        enrolledCoursesWithCredits.add(course.getCourseID() + ": " + "course.getCredits().get(i)");
//                    }
//                }
//            }


        return enrolledCoursesWithCredits;

    }

    public void finalizeEnrollments() {
        ifOpen = false;
        int a = 1;
        Course course = null;
        for (int wholeCoursesNumber = 0; wholeCoursesNumber < courses.size(); wholeCoursesNumber++) {
            course = courses.get(wholeCoursesNumber);
            ArrayList<Student> kickStudent = new ArrayList<>();
            ArrayList<Student> successStudent = course.getSuccessStudents();
            for (int i = 0; ; i++) {
                if (course.getEnrollStudent().size() - kickStudent.size() > course.getMaxCapacity()) {
                    for (int creditNumber = 0; creditNumber < course.getCredits().size(); creditNumber++) {
                        if (course.getCredits().get(creditNumber) == i) {
                            kickStudent.add(course.getEnrollStudent().get(creditNumber));
                        }
                    }
                } else
                    break;
            }

            for (Student eachStudent : course.getEnrollStudent()) {
                Student fail = null;
                ArrayList<Course> successCourses = eachStudent.getSuccessCourses();
                for (Student eachKickedStudent : kickStudent) {
                    if (eachStudent.equals(eachKickedStudent)) {
                        fail = eachStudent;
                        break;
                    }
                }

                if (fail == null) {
                    successStudent.equals(course.getSuccessStudents().add(eachStudent));

                    course.setSuccessStudents(successStudent);
                    successCourses.equals(eachStudent.getSuccessCourses().add(course));

                    eachStudent.setSuccessCourses(successCourses);


                }

            }
        }
    }
}

