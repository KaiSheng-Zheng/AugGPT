import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private boolean ifOpen;

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean isIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addCourse(Course course) {
        boolean a = true;
        for (int i = 0; i < courses.size(); i++) {
            if (course.getCourseID().equals(courses.get(i).getCourseID())) {
                a = false;
            }
        }
        if (a == true) {
            courses.add(course);
            course.setCourseManager(this);
        }
    }

    public void addStudent(Student student) {
        boolean a = true;
        for (int i = 0; i < students.size(); i++) {
            if (student.getStudentID().equals(students.get(i).getStudentID())) {
                a = false;
            }
        }
        if (a == true) {
            students.add(student);
            student.setCourseManager(this);
        }
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen == false) {
            return false;
        } else {
            boolean result = false;
            int num1 = -1;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    result = true;
                    num1 = i;
                }
            }
            if (num1 == -1) {
                return false;
            }
            for (int i = 0; i < courses.get(num1).getEnrollStudent().size(); i++) {
                if (courses.get(num1).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    return false;
                }
            }
            if (student.getCredits() < credits || credits <= 0) {
                return false;
            }
            if (result == true) {
                student.setCredits(student.getCredits() - credits);
                student.getEnrollCourses().add(courses.get(num1));
                courses.get(num1).getEnrollStudent().add(student);
                courses.get(num1).getCredits().add(credits);
            } else {
                return false;
            }
            return true;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen == false) {
            return false;
        } else {
            boolean result = false;
            int num1 = -1;
            int num2 = -1;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    result = true;
                    num1 = i;
                }
            }
            if (num1 == -1) {
                return false;
            }
            for (int i = 0; i < courses.get(num1).getEnrollStudent().size(); i++) {
                if (courses.get(num1).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    result = true;
                    num2 = i;
                    break;
                } else {
                    result = false;
                }
            }
            if (num2 == -1) {
                return false;
            }
            if (student.getCredits() + courses.get(num1).getCredits().get(num2) < credits || credits <= 0) {
                return false;
            }
            if (result == true) {
                student.setCredits(student.getCredits() + courses.get(num1).getCredits().get(num2) - credits);
                courses.get(num1).getCredits().set(num2, credits);
            } else {
                return false;
            }
            return true;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen == false) {
            return false;
        } else {
            boolean result = false;
            int num1 = -1;
            int num2 = -1;
            int num3 = -1;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    result = true;
                    num1 = i;
                }
            }
            if (num1 == -1) {
                return false;
            }
            for (int i = 0; i < courses.get(num1).getEnrollStudent().size(); i++) {
                if (courses.get(num1).getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                    result = true;
                    num2 = i;
                    break;
                } else {
                    result = false;
                }
            }
            if (num2 == -1) {
                return false;
            }
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                    num3 = i;
                }
            }
            if (num3 == -1) {
                return false;
            }
            if (result == true) {
                student.setCredits(student.getCredits() + courses.get(num1).getCredits().get(num2));
                student.getEnrollCourses().remove(num3);
                courses.get(num1).getEnrollStudent().remove(num2);
                courses.get(num1).getCredits().remove(num2);
            } else {
                return false;
            }
            return true;
        }
    }

    public void finalizeEnrollments() {
        this.ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getCredits().size() - 1; j++) {
                for (int k = 0; k < courses.get(i).getCredits().size() - 1; k++) {
                    if (courses.get(i).getCredits().get(k) < courses.get(i).getCredits().get(k + 1)) {
                        int temp1 = courses.get(i).getCredits().get(k);
                        courses.get(i).getCredits().set(k, courses.get(i).getCredits().get(k + 1));
                        courses.get(i).getCredits().set(k + 1, temp1);
                        Student temp2 = courses.get(i).getEnrollStudent().get(k);
                        courses.get(i).getEnrollStudent().set(k, courses.get(i).getEnrollStudent().get(k + 1));
                        courses.get(i).getEnrollStudent().set(k + 1, temp2);
                    }
                }
            }
        }
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCredits().size() <= courses.get(i).getMaxCapacity()) {
                for (int j = 0; j < courses.get(i).getCredits().size(); j++) {
                    courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                }
            } else {
                int num1 = courses.get(i).getCredits().get(courses.get(i).getMaxCapacity());
                for (int j = 0; j < courses.get(i).getCredits().size(); j++) {
                    if (courses.get(i).getCredits().get(j) > num1) {
                        courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    }
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen == true) {
            int num1 = 0;
            ArrayList<String> arrayList = new ArrayList<>(student.getEnrollCourses().size());
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                        num1 = j;
                    }
                }
                arrayList.add(student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(num1));
            }
            return arrayList;
        } else {
            return null;
        }
    }
}
