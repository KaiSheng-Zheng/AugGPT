import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    //constructor
    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    //getter and setter
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

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
    //end of getter and setter

    public void addStudent(Student student) {
        students.add(student);//add a student object to students
        student.setCourseManager(this);//set the courseManager of the student object to this manager
    }

    public void addCourse(Course course) {
        courses.add(course);//add a course object to courses
        course.setCourseManager(this);//set the courseManager of the course object to this manager
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }//1.determine if the system is open
        if (credits <= 0) {
            return false;
        }//2.determine if the parameter credits<=0
        Course course = determineCourseThroughId(courseId);
        if (course == null) {
            return false;
        }//3.determine if the courseID exists in the courses list
        boolean hasEnrolledBefore = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                hasEnrolledBefore = true;
                break;
            }
        }
        if (hasEnrolledBefore) {
            return false;
        }//4.determine if the student has enrolled in course before
        if (student.getCredits() < credits) {
            return false;
        }//5.determine if the student has provided enough credits

        //if the enrollment is successful, do the followings:
        student.setCredits(student.getCredits() - credits);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!this.ifOpen) {
            return false;
        }//1.determine if the system is open
        Course course = determineCourseThroughId(courseId);
        if (course == null) {
            return false;
        }//2.determine if the courseID exists in the courses list
        boolean hasEnrolledBefore = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                hasEnrolledBefore = true;
                break;
            }
        }
        if (!hasEnrolledBefore) {
            return false;
        }//3.determine if the student has enrolled in course before
        int index = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.equals(course.getEnrollStudent().get(i))) {
                index = i;
                break;
            }
        }
        int originalCredits = course.getCredits().get(index);
        if (student.getCredits() + originalCredits - credits < 0 || credits < 0) {
            return false;
        }//4.determine if the new bid is within the student's available credits
        //if the modification is successful, do the followings:
        student.setCredits(student.getCredits() + originalCredits - credits);
        course.getCredits().set(index, credits);//*What list in Student should be updated in this modification, as the doc indicates?
        return true;
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!this.ifOpen) {
            return false;
        }//1.determine if the system is open
        Course course = determineCourseThroughId(courseId);
        if (course == null) {
            return false;
        }//2.determine if the courseID exists in the courses list
        boolean hasEnrolledBefore = false;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                hasEnrolledBefore = true;
                break;
            }
        }
        if (!hasEnrolledBefore) {
            return false;
        }//3.determine if the student has enrolled in course before

        //if the drop is successful, do the followings:
        int indexOfStudentInCourseEnrollStudentList = -1;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
            if (student.equals(course.getEnrollStudent().get(i))) {
                indexOfStudentInCourseEnrollStudentList = i;
                break;
            }
        }//find the index of the student in the course enrollStudent list
        int indexOfCourseInStudentEnrollCoursesList = -1;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (course.equals(student.getEnrollCourses().get(i))) {
                indexOfCourseInStudentEnrollCoursesList = i;
                break;
            }
        }//find the index of the course in the student enrollStudent list
        student.getEnrollCourses().remove(indexOfCourseInStudentEnrollCoursesList);
        student.setCredits(student.getCredits() + course.getCredits().get(indexOfStudentInCourseEnrollStudentList));//*
        course.getEnrollStudent().remove(indexOfStudentInCourseEnrollStudentList);
        course.getCredits().remove(indexOfStudentInCourseEnrollStudentList);
        return true;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!this.ifOpen) {
            return null;
        }//1.determine if the system is open

        //if the modification is successful, do the followings:
        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            Course course = student.getEnrollCourses().get(i);
            int indexOfStudentInCourseEnrollStudentList = -1;
            for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                if (student.equals(course.getEnrollStudent().get(j))) {
                    indexOfStudentInCourseEnrollStudentList = j;
                    break;
                }
            }//find the index of the student in the course enrollStudent list
            enrolledCoursesWithCredits.add(String.format("%s: %d", course.getCourseID(), course.getCredits().get(indexOfStudentInCourseEnrollStudentList)));
        }
        return enrolledCoursesWithCredits;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (int i = 0; i < this.courses.size(); i++) {
            Course course = courses.get(i);
            ArrayList<Integer> creditsAfterSorted = sortList(course.getCredits());
            if (course.getEnrollStudent().size() <= course.getMaxCapacity()) {//the number of students enrolled in this course didn't exceed the capacity
                enrollSuccessfulStudents(course, course.getEnrollStudent().size());
            } else {
                ArrayList<Student> studentsAfterSorted = new ArrayList<>();
                for (int j = 0; j < creditsAfterSorted.size(); j++) {
                    int num = creditsAfterSorted.get(j);
                    for (int k = 0; k < course.getCredits().size(); k++) {
                        if (num == course.getCredits().get(k)) {
                            if (studentsAfterSorted.contains(course.getEnrollStudent().get(k))) {
                                continue;
                            }
                            studentsAfterSorted.add(course.getEnrollStudent().get(k));
                            break;
                        }
                    }
                }//create a list studentsAfterSorted, where the students are placed in the order of their credits(descend)
                course.setEnrollStudent(studentsAfterSorted);//WARNING! Here I change enrollStudent in course for convenience, but I don't know if it suits this problem.
                if (creditsAfterSorted.get(course.getMaxCapacity() - 1) > creditsAfterSorted.get(course.getMaxCapacity())) {
                    enrollSuccessfulStudents(course, course.getMaxCapacity());
                } else {
                    int rightBoundaryIndex = -1;
                    int rightBoundary = creditsAfterSorted.get(course.getMaxCapacity() - 1);
                    for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                        if (creditsAfterSorted.get(j) == rightBoundary) {
                            rightBoundaryIndex = j;
                            break;
                        }
                    }
                    enrollSuccessfulStudents(course, rightBoundaryIndex);
                }
            }
        }
    }

    public static ArrayList<Integer> sortList(ArrayList<Integer> list) {//this method is used to sort an arraylist in ascending order
        ArrayList<Integer> listCopy = new ArrayList<>(list);
        int length = listCopy.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (listCopy.get(j) < listCopy.get(j + 1)) {
                    int tmp = listCopy.get(j);
                    listCopy.set(j, listCopy.get(j + 1));
                    listCopy.set(j + 1, tmp);
                }
            }
        }
        return listCopy;
    }

    /*this method is used to finalize the system, putting those successfully enrolled students into the course successStudents list
    and put the course into each successfully enrolled student successCourses list.
    The rightBoundary is determined by the numbers of enrolled students, their credits into this course, and the capacity.
     */
    public static void enrollSuccessfulStudents(Course course, int rightBoundaryIndex) {
        for (int i = 0; i < rightBoundaryIndex; i++) {
            Student student = course.getEnrollStudent().get(i);
            course.getSuccessStudents().add(student);
            student.getSuccessCourses().add(course);
        }
    }

    public Course determineCourseThroughId(String courseId) {
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseId)) {
                course = c;
                break;
            }
        }
        return course;
    }
}