import java.util.*;


public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean getIfOpen() {
        return this.ifOpen;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseID, int credits) {
        if (!ifOpen) {
            return false;
        }
        Course course = null;
        for (Course c : courses) {
            if (c.getCourseID().equals(courseID)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            return false;
        }
        if (student.getEnrollCourses().contains(course)) {
            return false;
        }
        if (credits <= 0 || student.getCredits() < credits) {
            return false;
        }
        student.getEnrollCourses().add(course);
        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.setCredits(student.getCredits() - credits);
        return true;
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) {
            return false;
        }
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


        int studentIndex = course.getEnrollStudent().indexOf(student);
        if (studentIndex == -1) {
            return false;
        }
        int usedCredits = course.getCredits().get(studentIndex);

        student.setCredits(student.getCredits() + usedCredits);
        if (credits <= 0 || student.getCredits() < credits) {
            return false;
        }
        student.setCredits(student.getCredits() - credits);
        course.getCredits().set(studentIndex, credits);
        return true;
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        }
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
        int studentIndex = course.getEnrollStudent().indexOf(student);
        if (studentIndex == -1) {
            return false;
        }

        int usedCredits = course.getCredits().get(studentIndex);
        student.setCredits(student.getCredits() + usedCredits);
        course.getEnrollStudent().remove(student);

        course.getCredits().remove(studentIndex);
        student.getEnrollCourses().remove(course);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course course : courses) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();
            int maxCapacity = course.getMaxCapacity();
            ArrayList<Student> successStudents = new ArrayList<>();
            if (enrolledStudents.size() <= maxCapacity) {
                successStudents.addAll(enrolledStudents);
                for (Student student : students) {
                    if (successStudents.contains(student)) {
                        student.getSuccessCourses().add(course);
                    }
                }
            } else {

                List<Student> tmpStudentList = enrolledStudents.stream().sorted((s1,s2)->{
                    int s1Index = course.getEnrollStudent().indexOf(s1);
                    int s1credits = course.getCredits().get(s1Index);
                    int s2Index = course.getEnrollStudent().indexOf(s2);
                    int s2credits = course.getCredits().get(s2Index);
                    return s2credits - s1credits;
                }).toList();

                List<Integer> tmpCreditsList = course.getCredits().stream().sorted((c1,c2)->{
                    return c2-c1;
                }).toList();

                tmpCreditsList.stream().forEach(System.out::println);


                int count = calculate(tmpCreditsList, maxCapacity);
                int endIndex = maxCapacity - count ;
                if (endIndex < 0) {
                    endIndex = 0;
                }
                successStudents.addAll(tmpStudentList.subList(0, endIndex));
            }
            course.setSuccessStudents(successStudents);
        }
    }




    public int calculate(List<Integer> tmpCreditsList, int maxCapacity) {
        int count = 0;
        int creditOut = tmpCreditsList.get(maxCapacity);

        for (int i = maxCapacity-1; i >= 0; i--){
            if (tmpCreditsList.get(i) == creditOut){
                count++;
            }else break;
        }

        return count;
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> enrolledCourseWithCredits = new ArrayList<>();
        ArrayList<Course> enrollCourses = student.getEnrollCourses();
        for (Course course : enrollCourses) {
            int studentIndex=course.getEnrollStudent().indexOf(student);
            int credits = course.getCredits().get(studentIndex);
            String courseWithCredits = course.getCourseID()+": " + credits;
            enrolledCourseWithCredits.add(courseWithCredits);
        }
        return enrolledCourseWithCredits;
    }


}