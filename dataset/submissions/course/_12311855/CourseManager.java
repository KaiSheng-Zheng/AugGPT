
import java.util.ArrayList;

public class CourseManager {

    private boolean ifOpen = false;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    CourseManager() {
        ifOpen = false;
        students = new ArrayList<Student>();
        courses = new ArrayList<Course>();
    }


    public void setIfOpen(boolean b) {
        ifOpen = b;
    }

    public void addStudent(Student student1) {
        student1.setCourseManager(this);
        //guaranteed that all studentIDs are unique
        for (Student student : students) {
            if(student.getStudentID()==student1.getStudentID()){
                return;
            }
        }

        students.add(student1);
    }

    public void addCourse(Course course1) {
        course1.setCourseManager(this);
        //guaranteed that all courseIDs are unique
        for (Course course : courses) {
            if(course.getCourseID() == course1.getCourseID()){
                return;
            }
        }

        courses.add(course1);
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        for (Course course : courses) {
            if(course.getCredits().size()<=course.getMaxCapacity()) {
                course.setSuccessStudents(course.getEnrollStudent());
            }
            else {
                ArrayList<Student> sortedEnrollStudents = new ArrayList<Student>();
                ArrayList<Integer> sortedCredits = new ArrayList<Integer>();


                int index=0;
                int tmpCredit =0;

                //sort EnrolledStudents and Credits with the credit give by the student in a course
                for (Student student : course.getEnrollStudent()) {

                        if(course.getCredits().get(index)>tmpCredit) {
                            sortedEnrollStudents.add(0, student);
                            sortedCredits.add(0, course.getCredits().get(index));
                            tmpCredit = course.getCredits().get(index);
                        }
                        else {
                            int sortedIndex =0;
                            for (Integer sortedCredit : sortedCredits) {
                                if(sortedCredit < course.getCredits().get(index)) {
                                    sortedCredits.add(sortedIndex, course.getCredits().get(index));
                                    sortedEnrollStudents.add(sortedIndex, student);

                                    break;
                                    //sortedIndex++;
                                }
                                else {
                                    sortedIndex++;
                                }
                            }
                            if(sortedIndex == sortedCredits.size()) {
                                sortedCredits.add(course.getCredits().get(index));
                                sortedEnrollStudents.add(student);
                            }
                        }

                        index++;
                }


                if(course.getMaxCapacity()>=index) { //if the enrolled students is not more than the max capacity

                    course.setSuccessStudents(sortedEnrollStudents);
                }
                else {// if the enrolled students is more than the max capacity
                    ArrayList<Student> successStudents = new ArrayList<Student>();

                    int sucIndex = 0;
                    int sameIndex =0;

                    for (Student sortedEnrollStudent : sortedEnrollStudents) {
                        if(sortedCredits.size()>sucIndex+1) {//there are more than 1 students left
                            if(sortedCredits.get(sucIndex)>sortedCredits.get(sucIndex+1)) { //the credit is not equal to the credit give by the next student
                                if(course.getMaxCapacity()>=(sucIndex+1)) {
                                    successStudents.add(sortedEnrollStudent);
                                    sucIndex++;
                                    sameIndex = sucIndex;
                                }
                            }else { // the credits is equal to next student's credit
                                if(course.getMaxCapacity()>=(sucIndex+1)) {
                                    successStudents.add(sortedEnrollStudent);
                                    sucIndex++;
                                }
                                else { // there are same credits beyond capacity, need remove those all
                                    for(int i=sameIndex;i<sucIndex;i++) {
                                        successStudents.remove(i);
                                    }
                                }
                            }
                        }
                        else {//last one in sortedEnrollStudent
                            if(course.getMaxCapacity()>=(sucIndex+1)) {
                                successStudents.add(sortedEnrollStudent);
                                sucIndex++;
                            }else {
                                for(int i=sameIndex;i<sucIndex;i++) {
                                    successStudents.remove(i);
                                }
                            }

                        }

                    }
                    course.setSuccessStudents(successStudents);
                }

            }
        }


    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if(!ifOpen) {
            return false;
        }

        for (Course course : courses) {
            if(course.getCourseID()==courseId) {
                if(student.getCredits()>=credits) {
                    course.getEnrollStudent().add(student);
                    course.getCredits().add(credits);

                    student.getEnrollCourses().add(course);
                    student.setCredits(student.getCredits()-credits);
                    return true;
                }

            }
        }
        return false;

    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if(ifOpen) {
            ArrayList<Course> enCourses = student.getEnrollCourses();
            for (Course enCourse : enCourses) {

                if(enCourse.getCourseID() == courseId) {
                    int studentIndex =enCourse.getEnrollStudent().indexOf(student);
                    if((student.getCredits() + enCourse.getCredits().get(studentIndex) -credits) >=0) {
                        student.setCredits(student.getCredits() + enCourse.getCredits().get(studentIndex) -credits);
                        enCourse.getCredits().set(studentIndex, credits);

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if(ifOpen) {
            ArrayList<Course> enCourses = student.getEnrollCourses();
            int courseIndex = 0;
            int studentIndex =0;
            int credit =0;
            for (Course enCourse : enCourses) {

                if (enCourse.getCourseID() == courseId) {
                    studentIndex = enCourse.getEnrollStudent().indexOf(student);
                    credit = enCourse.getCredits().get(studentIndex);

                    enCourse.getEnrollStudent().remove(studentIndex);
                    enCourse.getCredits().remove(studentIndex);


                    enCourses.remove(courseIndex);
                    student.setEnrollCourses(enCourses);
                    student.setCredits(student.getCredits()+credit);
                    return true;
                }
                courseIndex++;
            }
        }

        return false;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {


        if(ifOpen) {
            ArrayList<String> enrolledCoursesWithCredits = new ArrayList<String>();
            ArrayList<Course> enCourses = student.getEnrollCourses();

            for (Course enCourse : enCourses) {
                enrolledCoursesWithCredits.add(enCourse.getCourseID()+": "+ enCourse.getCredits().get(enCourse.getEnrollStudent().indexOf(student)));
            }

            return enrolledCoursesWithCredits;
        }
        else {
            return null;
        }

    }
}
