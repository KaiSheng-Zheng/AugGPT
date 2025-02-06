import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen = true;

    public CourseManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        ifOpen = true;
    }
    public ArrayList<Course> getCourse() {
        return courses;
    }

    public ArrayList<Student> getStudent() {
        return students;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
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

    public boolean enrollStudentInCourse(Student student, String courseId, int bidCredits) {
        if (!ifOpen) {
            return false;
        }

        Course targetCourse = findCourseById(courseId);

        if (targetCourse == null || student.getEnrollCourses().contains(targetCourse)) {
            return false;
        }

        if (bidCredits <= 0 || student.getCredits() < bidCredits) {
            return false;
        }

        student.getEnrollCourses().add(targetCourse);
        targetCourse.getEnrollStudent().add(student);

        // rest credits
        student.setCredits(student.getCredits() - bidCredits);

        targetCourse.getCredits().add(bidCredits);

        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int newCredits) {
        if (!ifOpen) {
            return false;
        }

        Course targetCourse = findCourseById(courseId);

        if (targetCourse == null || !student.getEnrollCourses().contains(targetCourse)) {
            return false;
        }

        // Check if the new bid is within the student's available credits
        int currentCredits = student.getCredits();
        int previousBidCredits = targetCourse.getCredits().get(targetCourse.getEnrollStudent().indexOf(student));
        int creditsDifference = newCredits - previousBidCredits;

        if (currentCredits < creditsDifference) {
            return false;
        }

        // update enroll credits
        targetCourse.getCredits().set(targetCourse.getEnrollStudent().indexOf(student), newCredits);
        // update rest credits
        student.setCredits(currentCredits - creditsDifference);

        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }

        Course targetCourse = findCourseById(courseId);

        if (targetCourse == null || !student.getEnrollCourses().contains(targetCourse)) {
            return false;
        }

            int droppedStudentIndex=targetCourse.getEnrollStudent().indexOf(student);
            int creditsRefunded = targetCourse.getCredits().get(droppedStudentIndex);
            student.setCredits(student.getCredits() + creditsRefunded);

        //delete
        student.getEnrollCourses().remove(targetCourse);
        targetCourse.getEnrollStudent().remove(student);
        targetCourse.getCredits().remove(droppedStudentIndex);




        return true;
    }


    public void finalizeEnrollments() {
        ifOpen = false;

        for (Course course : courses) {
            ArrayList<Student> students = course.getEnrollStudent();
            ArrayList<Integer> courseCredits = course.getCredits();

            if (students == null || students.size() <= course.getMaxCapacity()) {
                course.setSuccessStudents(students);
            } else {
                for (int i = 0; i < courseCredits.size() - 1; i++) {
                    for (int j = 0; j < courseCredits.size() - i - 1; j++) {
                        if (courseCredits.get(j) < courseCredits.get(j + 1)) {
                            // exchange course
                            int tempCredits = courseCredits.get(j);
                            courseCredits.set(j, courseCredits.get(j + 1));
                            courseCredits.set(j + 1, tempCredits);
                            // exchange student
                            Student tempStudent = students.get(j);
                            students.set(j, students.get(j + 1));
                            students.set(j + 1, tempStudent);
                        }
                    }
                }



                int capacity = course.getMaxCapacity();

                //the last student's index
                int lastAccepted = capacity - 1;

                int before = 0;
                for (int i = lastAccepted; i > 0; i--) {
                    if (Objects.equals(courseCredits.get(i), courseCredits.get(i - 1))) {
                        before++;
                    } else {
                        break;
                    }
                }
                int after = 0;
                for (int i = lastAccepted; i < courseCredits.size() - 1; i++) {
                    if (Objects.equals(courseCredits.get(i), courseCredits.get(i + 1))) {
                        after++;
                    } else {
                        break;
                    }
                }
                //real number of students
                int finalNum = 0;
                if (after > 0) {
                    finalNum = capacity - before - 1;
                } else if (after == 0) {
                    finalNum = capacity;
                }

                if (finalNum > 0) {
                    course.setSuccessStudents(new ArrayList<>(students.subList(0, finalNum)));
                }
                else {
                    course.setSuccessStudents(new ArrayList<>());
                }


            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }

        ArrayList<String> enrolledCoursesWithCredits = new ArrayList<>();

        //already enrolled courses
        List<Course> enrolledCourses = student.getEnrollCourses();

        for (Course course : enrolledCourses) {
            String courseID = course.getCourseID();
            int  credits = course.getCredits().get(course.getEnrollStudent().indexOf(student));
            String courseInfo = courseID + ": " + credits;

            enrolledCoursesWithCredits.add(courseInfo);
        }

        return enrolledCoursesWithCredits;
    }
    public Course findCourseById(String courseId){
        Course targetCourse = null;
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                targetCourse = course;
                break;
            }
        }
        return targetCourse;
    }
}