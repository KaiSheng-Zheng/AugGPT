import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
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

    public void addCourse(Course course) {
        if(course.getMaxCapacity()>0){
            courses.add(course);
            course.setCourseManager(this);}
    }

    public void addStudent(Student student) {
        if(student.getCredits()>=0){
            students.add(student);
            student.setCourseManager(this);}
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean whetherValid = true;
        int numberOfTheTotalCourse = courses.size();
        int positionInTheCourseList = 0;
        if (ifOpen == false) {
            whetherValid = false;
        }
        if (whetherValid == true) {
            boolean whetherTrueHere = false;
            for (positionInTheCourseList = 0; positionInTheCourseList < numberOfTheTotalCourse; positionInTheCourseList++) {
                if (courseId.equals(courses.get(positionInTheCourseList).getCourseID())) {
                    whetherTrueHere = true;
                    break;
                }
            }
            whetherValid = whetherTrueHere;
        }
        if (whetherValid == true) {
            int numberOfTheStudentsEnrolledInThisCourse = courses.get(positionInTheCourseList).getEnrollStudent().size();
            for (int positionInTheEnrolledStudentList = 0; positionInTheEnrolledStudentList < numberOfTheStudentsEnrolledInThisCourse; positionInTheEnrolledStudentList++) {
                if (student.getStudentID().equals(courses.get(positionInTheCourseList).getEnrollStudent().get(positionInTheEnrolledStudentList).getStudentID())) {
                    whetherValid = false;
                    break;
                }
            }
        }
        if (whetherValid == true) {
            if (credits <= 0 || credits > student.getCredits()) {
                whetherValid = false;
            }
        }
        if (whetherValid == true) {
            int originalCredit = student.getCredits();
            student.setCredits(originalCredit - credits);
            ArrayList<Course> orinalCourseList = new ArrayList<>(student.getEnrollCourses());
            orinalCourseList.add(courses.get(positionInTheCourseList));
            student.setEnrollCourses(orinalCourseList);
            ArrayList<Student> originalEnrollStudent = new ArrayList<>(courses.get(positionInTheCourseList).getEnrollStudent());
            originalEnrollStudent.add(student);
            courses.get(positionInTheCourseList).setEnrollStudent(originalEnrollStudent);
            ArrayList<Integer> originalCredits = new ArrayList<>(courses.get(positionInTheCourseList).getCredits());
            originalCredits.add(credits);
            courses.get(positionInTheCourseList).setCredits(originalCredits);
        }
        return whetherValid;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean whetherValid = true;
        int numberOfTheTotalCourse = courses.size();
        int positionInTheCourseList = 0;
        int sequenceInTheEnrollingCourse = 0;
        int sequenceInTheEnrollingStudent = 0;
        if (ifOpen == false) {
            whetherValid = false;
        }
        if (whetherValid == true) {
            boolean whetherTrueHere = false;
            for (positionInTheCourseList = 0; positionInTheCourseList < numberOfTheTotalCourse; positionInTheCourseList++) {
                if (courseId.equals(courses.get(positionInTheCourseList).getCourseID())) {
                    whetherTrueHere = true;
                    break;
                }
            }
            whetherValid = whetherTrueHere;
        }
        if (whetherValid == true) {
            boolean whetherTrueHere = false;
            int numberOfTheStudentsEnrolledInThisCourse = courses.get(positionInTheCourseList).getEnrollStudent().size();
            for (int positionInTheEnrolledStudentList = 0; positionInTheEnrolledStudentList < numberOfTheStudentsEnrolledInThisCourse; positionInTheEnrolledStudentList++) {
                if (student.getStudentID().equals(courses.get(positionInTheCourseList).getEnrollStudent().get(positionInTheEnrolledStudentList).getStudentID())) {
                    whetherTrueHere = true;
                    sequenceInTheEnrollingStudent = positionInTheEnrolledStudentList;
                    break;
                }
            }
            whetherValid = whetherTrueHere;
        }
        if (whetherValid == true) {
            String specificCourseID = courses.get(positionInTheCourseList).getCourseID();
            int lengthOfTheEnrollingCourse = student.getEnrollCourses().size();
            for (sequenceInTheEnrollingCourse = 0; sequenceInTheEnrollingCourse < lengthOfTheEnrollingCourse; sequenceInTheEnrollingCourse++) {
                if (student.getEnrollCourses().get(sequenceInTheEnrollingCourse).equals(specificCourseID)) {
                    break;
                }
            }
            int oldCreditInput = courses.get(positionInTheCourseList).getCredits().get(sequenceInTheEnrollingStudent);
            int upperLimit = oldCreditInput + student.getCredits();
            if (credits > upperLimit) {
                whetherValid = false;
            }
            //bug: whetherValid = true does not euqal to whetherValid == true.
            if (whetherValid = true) {
                int newCreditsLeft = upperLimit - credits;
                student.setCredits(newCreditsLeft);
                ArrayList<Integer> oldCreditsList = new ArrayList<>(courses.get(positionInTheCourseList).getCredits());
                oldCreditsList.set(sequenceInTheEnrollingStudent, credits);
                courses.get(positionInTheCourseList).setCredits(oldCreditsList);
                ArrayList<Student> oldStudentList = new ArrayList<>(courses.get(positionInTheCourseList).getEnrollStudent());
                oldStudentList.set(sequenceInTheEnrollingStudent, student);
                courses.get(positionInTheCourseList).setEnrollStudent(oldStudentList);
            }
        }
        return whetherValid;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean whetherValid = true;
        int numberOfTheTotalCourse = courses.size();
        int positionInTheCourseList = 0;
        int sequenceInTheEnrollingStudent = 0;
        int sequenceInTheEnrollingCourse = 0;
        if (ifOpen == false) {
            whetherValid = false;
        }
        if (whetherValid == true) {
            boolean whetherTrueHere = false;
            for (positionInTheCourseList = 0; positionInTheCourseList < numberOfTheTotalCourse; positionInTheCourseList++) {
                if (courseId.equals(courses.get(positionInTheCourseList).getCourseID())) {
                    whetherTrueHere = true;
                    break;
                }
            }
            whetherValid = whetherTrueHere;
        }
        if (whetherValid == true) {
            boolean whetherTrueHere = false;
            int numberOfTheStudentsEnrolledInThisCourse = courses.get(positionInTheCourseList).getEnrollStudent().size();
            for (int positionInTheEnrolledStudentList = 0; positionInTheEnrolledStudentList < numberOfTheStudentsEnrolledInThisCourse; positionInTheEnrolledStudentList++) {
                if (student.getStudentID().equals(courses.get(positionInTheCourseList).getEnrollStudent().get(positionInTheEnrolledStudentList).getStudentID())) {
                    whetherTrueHere = true;
                    sequenceInTheEnrollingStudent = positionInTheEnrolledStudentList;
                    break;
                }
            }
            whetherValid = whetherTrueHere;
        }
        if (whetherValid == true) {
            String specificCourseID = courses.get(positionInTheCourseList).getCourseID();
            int lengthOfTheEnrollingCourse = student.getEnrollCourses().size();
            for (sequenceInTheEnrollingCourse = 0; sequenceInTheEnrollingCourse < lengthOfTheEnrollingCourse; sequenceInTheEnrollingCourse++) {
                if (student.getEnrollCourses().get(sequenceInTheEnrollingCourse).getCourseID().equals(specificCourseID)) {
                    break;
                }
            }
            int olderCreditOnThisCourse = courses.get(positionInTheCourseList).getCredits().get(sequenceInTheEnrollingStudent);
            int currentUpperLimit = student.getCredits();
            currentUpperLimit += olderCreditOnThisCourse;
            student.setCredits(currentUpperLimit);
            ArrayList<Course> currentEnrollingCourseList = new ArrayList<>(student.getEnrollCourses());
            currentEnrollingCourseList.remove(sequenceInTheEnrollingCourse);
            student.setEnrollCourses(currentEnrollingCourseList);
            ArrayList<Student> currentEnrollingStudentsList = new ArrayList<>(courses.get(positionInTheCourseList).getEnrollStudent());
            currentEnrollingStudentsList.remove(sequenceInTheEnrollingStudent);
            courses.get(positionInTheCourseList).setEnrollStudent(currentEnrollingStudentsList);
            ArrayList<Integer> currentCreditsList = new ArrayList<>(courses.get(positionInTheCourseList).getCredits());
            currentCreditsList.remove(sequenceInTheEnrollingStudent);
            courses.get(positionInTheCourseList).setCredits(currentCreditsList);
        }
        return whetherValid;
    }

    public void finalizeEnrollments() {
        ifOpen = false;//close the selecting period
        int realLowerBound = 7000;//set a fake upperbound
        int numberOfTheTotalCourse = courses.size();
        for (int courseSequence = 0; courseSequence < numberOfTheTotalCourse; courseSequence++) {//set successful list for every course
            if(courses.get(courseSequence).getEnrollStudent().isEmpty()){
                continue;
            }
            ArrayList<Integer> creditSequenceAfterSorting = new ArrayList<>(courses.get(courseSequence).getCredits());//get the original credits list for the course
            Collections.sort(creditSequenceAfterSorting, Collections.reverseOrder());//sort the credits from bigger to smaller
            if (courses.get(courseSequence).getEnrollStudent().size()<= courses.get(courseSequence).getMaxCapacity()){
                Collections.sort(creditSequenceAfterSorting);
                realLowerBound = creditSequenceAfterSorting.get(0);
            } else{
                int potentialLowerBound = creditSequenceAfterSorting.get(courses.get(courseSequence).getMaxCapacity() - 1);
                if (creditSequenceAfterSorting.get(courses.get(courseSequence).getMaxCapacity()) < potentialLowerBound) {
                    realLowerBound = potentialLowerBound;
                } else {
                    for (int locationAtTheSortedSequence = courses.get(courseSequence).getMaxCapacity() - 2; locationAtTheSortedSequence > -1; locationAtTheSortedSequence--) {
                        if (creditSequenceAfterSorting.get(locationAtTheSortedSequence) != potentialLowerBound) {
                            realLowerBound = creditSequenceAfterSorting.get(locationAtTheSortedSequence);
                            break;
                        }
                    }
                }}
            for (int theLocationInTheEnrollingList = 0; theLocationInTheEnrollingList < courses.get(courseSequence).getCredits().size(); theLocationInTheEnrollingList++) {
                ArrayList<Student> currentSuccessfulStudents = new ArrayList<>(courses.get(courseSequence).getSuccessStudents());
                if (courses.get(courseSequence).getCredits().get(theLocationInTheEnrollingList) >= realLowerBound) {

                    currentSuccessfulStudents.add(courses.get(courseSequence).getEnrollStudent().get(theLocationInTheEnrollingList));
                    courses.get(courseSequence).setSuccessStudents(currentSuccessfulStudents);
                    String IDNumberForSuccessfulStudent = courses.get(courseSequence).getEnrollStudent().get(theLocationInTheEnrollingList).getStudentID();
                    int theSequenceOfStudent = 0;
                    for (int currentSequenceOfStudent = 0; currentSequenceOfStudent < students.size(); currentSequenceOfStudent++) {
                        if (IDNumberForSuccessfulStudent.equals(students.get(currentSequenceOfStudent).getStudentID())) {
                            theSequenceOfStudent = currentSequenceOfStudent;
                            break;
                        }
                    }
                    ArrayList<Course> currentSuccessfulCourse = new ArrayList<>(students.get(theSequenceOfStudent).getSuccessCourses());
                    currentSuccessfulCourse.add(courses.get(courseSequence));
                    students.get(theSequenceOfStudent).setSuccessCourses(currentSuccessfulCourse);
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen == false) {
            return null;
        } else {
            ArrayList<String> courseAndCredit = new ArrayList<>();
            for (int locationAtEnrollingCourse = 0; locationAtEnrollingCourse < student.getEnrollCourses().size(); locationAtEnrollingCourse++) {
                Course theTargetCourse = student.getEnrollCourses().get(locationAtEnrollingCourse);
                String studentID = student.getStudentID();
                String courseID = theTargetCourse.getCourseID();
                int locationAtCoursesList = 0;
                int theCreditStudentPutInForThatCourse = 0;
                for (int currentLocationAtCoursesList = 0; currentLocationAtCoursesList < courses.size(); currentLocationAtCoursesList++) {
                    if (courseID.equals(courses.get(currentLocationAtCoursesList).getCourseID())) {
                        locationAtCoursesList = currentLocationAtCoursesList;
                        break;
                    }
                }
                for (int locationAtEnrollingStudents = 0; locationAtEnrollingStudents < courses.get(locationAtCoursesList).getEnrollStudent().size(); locationAtEnrollingStudents++) {
                    if (studentID.equals(courses.get(locationAtCoursesList).getEnrollStudent().get(locationAtEnrollingStudents).getStudentID())) {
                        theCreditStudentPutInForThatCourse = courses.get(locationAtCoursesList).getCredits().get(locationAtEnrollingStudents);
                    }
                }
                courseAndCredit.add(String.format("%s: %d", courseID, theCreditStudentPutInForThatCourse));
            }
            return courseAndCredit;
        }

    }

}


