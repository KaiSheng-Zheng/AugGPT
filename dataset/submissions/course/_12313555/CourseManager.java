import java.util.ArrayList;
import java.util.Collections;

class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        ifOpen = true;
    }

    public ArrayList<Student> getStudents() {
        return students;
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

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen && credits > 0 && credits <= student.getCredits()) {
            boolean flag = false;
            int temp = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    temp = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                    if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                student.setCredits(student.getCredits() - credits);
                student.getEnrollCourses().add(courses.get(temp));
                courses.get(temp).getEnrollStudent().add(student);
                courses.get(temp).getCredits().add(credits);
            }
            return flag;
        } else {
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (ifOpen && credits > 0) {
            boolean flag = false;
            boolean flag2 = false;
            int temp = 0;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    flag = true;
                    temp = i;
                    break;
                }
            }
            if (flag) {
                flag = false;
                for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                    if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                if (courses.get(temp).getCredits().get(courses.get(temp).getEnrollStudent().indexOf(student)) + student.getCredits() >= credits) {
                    flag2=true;
                }
            }
            if (flag2) {
                student.setCredits(student.getCredits() + courses.get(temp).getCredits().get(courses.get(temp).getEnrollStudent().indexOf(student)) - credits);
                courses.get(temp).getCredits().set(courses.get(temp).getEnrollStudent().indexOf(student), credits);
            }
            return flag2;
        } else {
            return false;
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (ifOpen) {
            int temp = 0;
            boolean flag = false;
            boolean flag2 = false;
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseID().equals(courseId)) {
                    temp = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                    if (student.getEnrollCourses().get(i).getCourseID().equals(courseId)) {
                        flag2 = true;
                        break;
                    }
                }
            }
            if (flag2) {
                student.setCredits(student.getCredits() + courses.get(temp).getCredits().get(courses.get(temp).getEnrollStudent().indexOf(student)));
                student.getEnrollCourses().remove(courses.get(temp));
                courses.get(temp).getCredits().remove(courses.get(temp).getEnrollStudent().indexOf(student));
                courses.get(temp).getEnrollStudent().remove(student);
            }
            return flag2;
        } else {
            return false;
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> list = new ArrayList<>();
        if (ifOpen) {
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int temp = 0;
                for (int i1 = 0; i1 < student.getEnrollCourses().get(i).getEnrollStudent().size(); i1++) {
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(i1).equals(student)) {
                        temp = i1;
                    }
                }
                list.add(String.format("%s: %d", student.getEnrollCourses().get(i).getCourseID(), student.getEnrollCourses().get(i).getCredits().get(temp)));
            }
            return list;
        } else {
            return null;
        }
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Integer> creditList = new ArrayList<>();
            if (courses.get(i).getEnrollStudent().size() > courses.get(i).getMaxCapacity()) {
                creditList.addAll(courses.get(i).getCredits());
                courses.get(i).getCredits().sort(Collections.reverseOrder());
                int temp1 = courses.get(i).getCredits().get(courses.get(i).getMaxCapacity());
                int temp2 = courses.get(i).getCredits().get(courses.get(i).getMaxCapacity() - 1);
                if (temp1 == temp2) {
                    for (int i1 = 0; i1 < creditList.size(); i1++) {
                        if (creditList.get(i1) > temp2) {
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(i1));
                        } else {
                            //courses.get(i).getEnrollStudent().get(i1).setCredits(creditList.get(i1)+courses.get(i).getEnrollStudent().get(i1).getCredits());
                        }
                    }
                } else if (temp1 < temp2) {
                    for (int i1 = 0; i1 < creditList.size(); i1++) {
                        if (creditList.get(i1) >= temp2) {
                            courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(i1));
                        } else {
                            //courses.get(i).getEnrollStudent().get(i1).setCredits(creditList.get(i1)+courses.get(i).getEnrollStudent().get(i1).getCredits());
                        }
                    }
                }
            } else {
                for (int i1 = 0; i1 < courses.get(i).getEnrollStudent().size(); i1++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(i1));
                }
            }
            for (int i1 = 0; i1 < students.size(); i1++) {
                if (courses.get(i).getSuccessStudents().contains(students.get(i1))) {
                    students.get(i1).getEnrollCourses().add(courses.get(i));
                }
            }
        }
    }
}
