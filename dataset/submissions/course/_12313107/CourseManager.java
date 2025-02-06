import java.util.ArrayList;

public class CourseManager {
    //fields
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    //Constructor
    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
        this.ifOpen = true;
    }


    //Methods
    public ArrayList<Student> getStudents() {
        //getter for students
        return students;
    }

    public ArrayList<Course> getCourses() {
        //getter for courses
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        //setter for the status
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        //get for the status
        return ifOpen;
    }

    public void addCourse(Course course) {
        //add course to the ArrayList
        course.setCourseManager(this);
        this.courses.add(course);
    }

    public void addStudent(Student student) {
        //add student to the ArrayList
        student.setCourseManager(this);
        this.students.add(student);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen && credits > 0) {
            //determine whether this student has already enrolled this course
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                    //this student has already enrolled this course, return false
                    return false;
                }
            }
            //the loop is over, which means the student is not included in this course preciously,
            //this student doesn't enroll this course, next step.
            for (int j = 0; j < courses.size(); j++) {
                if (courseId.equals(courses.get(j).getCourseID())) {
                    //determine whether this student can enroll this course
                    if (student.getCredits() >= credits) {
                        student.setCredits(student.getCredits() - credits);
                    } else {
                        return false;
                    }
                    //get the course under enrolling
                    Course c = courses.get(j);

                    //update the student's enrolled course
                    student.getEnrollCourses().add(c);
                    student.setEnrollCourses(student.getEnrollCourses());

                    //update the credit in the course's credit arraylist
                    c.getCredits().add(credits);
                    c.setCredits(c.getCredits());

                    //add the student in the course's arraylist then update the list
                    c.getEnrollStudent().add(student);
                    c.setEnrollStudent(c.getEnrollStudent());

                    //successful added, return true
                    return true;
                }
            }
            //the course is not existed, return false
            return false;
        } else {
            //the system has closed, enroll failed.
            //return false
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        //if the status is false, return false to stop this method
        if (!ifOpen || credits <= 0) {
            return false;
        }
        //first determine the course does exist.
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                //then determine this student has already enrolled this course
                for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                    Course courseInStudentList = student.getEnrollCourses().get(j);
                    if (courseInStudentList.getCourseID().equals(courseId)) {
                        /*this course does exist and the student has already enrolled this course, next step.
                        next step is to determine the student has enough available credits
                        first find the index of the student in the arraylist of the course
                        find the student in the course */
                        for (int k = 0; k < courses.get(i).getEnrollStudent().size(); k++) {
                            if (courses.get(i).getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())) {
                                if (credits <= (student.getCredits() + courseInStudentList.getCredits().get(k))) {
                                    int newCredits = student.getCredits() + courseInStudentList.getCredits().get(k) - credits;
                                    //update student's credit
                                    student.setCredits(newCredits);
                                    //change the credit in the course's list
                                    int studentNum = courses.get(i).getEnrollStudent().indexOf(student);
                                    courses.get(i).getCredits().set(studentNum, credits);
                                    //changed, return true
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }

                    }
                }
                //the student hasn't enrolled this course, return false
                return false;
            }
        }
        //this course doesn't exist, return false.
        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        //judge the status
        if (!ifOpen) {
            return false;
        }
        //first judge whether the course exists or not
        boolean flag = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return false;
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                Course toDelete = student.getEnrollCourses().get(i);
                //We need to delete the student's information in the course's list
                //first find the studentNum
                int studentNum = -1;
                for (int j = 0; j < toDelete.getEnrollStudent().size(); j++) {
                    if (toDelete.getEnrollStudent().get(j) == student) {
                        studentNum = j;
                    }
                }
                //delete this student from this course
                for (int l = 0; l < courses.size(); l++) {
                    if (courses.get(l).getCourseID().equals(courseId)) {
                        Course deleted = courses.get(l);
                        //refund the student's credit
                        student.setCredits(student.getCredits() + deleted.getCredits().get(studentNum));
                        //operating
                        deleted.getEnrollStudent().remove(studentNum);
                        deleted.getCredits().remove(studentNum);
                        //updating
                        deleted.setEnrollStudent(deleted.getEnrollStudent());
                        deleted.setCredits(deleted.getCredits());
                    }
                }
                //delete this course
                student.getEnrollCourses().remove(toDelete);
                return true;
            }
        }
        return false;
    }

    public void finalizeEnrollments() {
        //close the system
        ifOpen = false;
        //in arraylist "courses", determine the students that successfully enrolled
        for (int i = 0; i < courses.size(); i++) {
            //get the operating course
            Course thisCourse = courses.get(i);
            //based upon bid credits and course capacity, determine the minimum credit
            ArrayList<Integer> creditBid = courses.get(i).getCredits();
            int[] ranking = new int[creditBid.size()];
            for (int j = 0; j < ranking.length; j++) {
                ranking[j] = creditBid.get(j);
            }
            //from the sequence of small to large, ranking the array "ranking"
            int[] ranked = rank(ranking);
            int maxCapacity = thisCourse.getMaxCapacity();
            if (ranked.length <= maxCapacity) {
                //not exceed the max capacity, all students enrolled successfully
                //update the course's success arraylist
                thisCourse.setSuccessStudents(thisCourse.getEnrollStudent());
                //set the students' successfully class
                for (int j = 0; j < thisCourse.getEnrollStudent().size(); j++) {
                    Student thisStudent = thisCourse.getEnrollStudent().get(j);
                    //add course to success arraylist
                    thisStudent.getSuccessCourses().add(thisCourse);
                    //update the arraylist for the student
                    thisStudent.setSuccessCourses(thisStudent.getSuccessCourses());
                }
            } else {

                //exceeded the max capacity, do the principle of enrolling
                //get the minimum bid to enroll this course successfully
                int cutoff = 1000000;
                if (ranked[maxCapacity - 1] == ranked[maxCapacity]) {
                    //follow the "same credit, same drop" principle
                    //find the student whose bid is on the cutoff
                    int temp = 0;
                    for (int j = maxCapacity; j > 0; j--) {
                        if (ranked[j] < ranked[j - 1]) {
                            cutoff = ranked[j - 1];
                            break;
                        }
                        cutoff = ranked[0] + 1;
                    }
                } else {
                    //don't need to follow "same credit, same drop"
                    //the cutoff is the bid of the student on the max capacity
                    cutoff = ranked[maxCapacity - 1];
                }
                for (int j = 0; j < thisCourse.getEnrollStudent().size(); j++) {
                    //choose all the student whose bid is greater than the cutoff
                    if (thisCourse.getCredits().get(j) >= cutoff) {
                        Student thisStudent = thisCourse.getEnrollStudent().get(j);
                        //add student to the course's successful list
                        thisCourse.getSuccessStudents().add(thisCourse.getEnrollStudent().get(j));
                        //update the successful list
                        thisCourse.setSuccessStudents(thisCourse.getSuccessStudents());
                        //add course to the student's successful course list
                        thisStudent.getSuccessCourses().add(thisCourse);
                        //update the student's successful course list
                        thisStudent.setSuccessCourses(thisStudent.getSuccessCourses());
                    }
                }
            }
        }
    }


    //write a method to arise the ranking function
    public int[] rank(int[] toRank) {
        for (int i = 0; i < toRank.length; i++) {
            for (int j = i; j < toRank.length; j++) {
                if (toRank[i] < toRank[j]) {
                    int temp = toRank[i];
                    toRank[i] = toRank[j];
                    toRank[j] = temp;
                }
            }
        }
        return toRank;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        int studentNum;
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            String courseID = student.getEnrollCourses().get(i).getCourseID();
            for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                    studentNum = j;
                    int creditEnrolled = student.getEnrollCourses().get(i).getCredits().get(studentNum);
                    String resultString = courseID + ": " + creditEnrolled;
                    result.add(resultString);
                    break;
                }
            }
        }
        return result;
    }


}
