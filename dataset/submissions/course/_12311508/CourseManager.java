import java.util.*;
class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
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
        course.setCourseManager(this);
        courses.add(course);
    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        students.add(student);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen || credits<0) {
            return false;
        } else {
            int coursenum = -1;
            for (int i = 0; i < courses.size(); i++) {
                if (Objects.equals(courses.get(i).getCourseID(), courseId)) {
                    coursenum = i;
                    break;
                }
            }
            if (coursenum == -1) {
                return false;
            }
            for (int i = 0; i < courses.get(coursenum).getEnrollStudent().size(); i++) {
                if (student == courses.get(coursenum).getEnrollStudent().get(i)) {
                    return false;
                }
            }
            if (credits > 0 && credits <= student.getCredits()) {
                student.setCredits(student.getCredits() - credits);
                ArrayList<Course> newEnrollCourses = student.getEnrollCourses();
                newEnrollCourses.add(courses.get(coursenum));
                student.setEnrollCourses(newEnrollCourses);
                ArrayList<Student> newEnrollStudents = courses.get(coursenum).getEnrollStudent();
                newEnrollStudents.add(student);
                courses.get(coursenum).setEnrollStudent(newEnrollStudents);
                ArrayList<Integer> newCredits = courses.get(coursenum).getCredits();
                newCredits.add(credits);
                courses.get(coursenum).setCredits(newCredits);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen || credits<0) {
            return false;
        } else {
            int coursenum = -1;
            for (int i = 0; i < courses.size(); i++) {
                if (Objects.equals(courses.get(i).getCourseID(), courseId)) {
                    coursenum = i;
                    break;
                }
            }
            if (coursenum == -1) {
                return false;
            }
            int studentnum = -1;
            for (int i = 0; i < courses.get(coursenum).getEnrollStudent().size(); i++) {
                if (student == courses.get(coursenum).getEnrollStudent().get(i)) {
                    studentnum = i;
                    break;
                }
            }
            if (studentnum == -1) {
                return false;
            }
            if (credits > 0 && credits <= student.getCredits() + courses.get(coursenum).getCredits().get(studentnum)) {
                student.setCredits(student.getCredits() - credits + courses.get(coursenum).getCredits().get(studentnum));
                ArrayList<Integer> newCredits = courses.get(coursenum).getCredits();
                newCredits.set(studentnum, credits);
                courses.get(coursenum).setCredits(newCredits);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) {
            return false;
        } else {
            int coursenum = -1;
            for (int i = 0; i < courses.size(); i++) {
                if (Objects.equals(courses.get(i).getCourseID(), courseId)) {
                    coursenum = i;
                    break;
                }
            }
            if (coursenum == -1) {
                return false;
            }
            int studentnum = -1;
            for (int i = 0; i < courses.get(coursenum).getEnrollStudent().size(); i++) {
                if (student == courses.get(coursenum).getEnrollStudent().get(i)) {
                    studentnum = i;
                    break;
                }
            }
            if (studentnum == -1) {
                return false;
            }
            student.setCredits(student.getCredits() + courses.get(coursenum).getCredits().get(studentnum));
            ArrayList<Integer> newCredits = courses.get(coursenum).getCredits();
            newCredits.remove(studentnum);
            courses.get(coursenum).setCredits(newCredits);
            ArrayList<Course> newEnrollCourses = student.getEnrollCourses();
            newEnrollCourses.remove(courses.get(coursenum));
            student.setEnrollCourses(newEnrollCourses);
            ArrayList<Student> newEnrollStudents = courses.get(coursenum).getEnrollStudent();
            newEnrollStudents.remove(studentnum);
            courses.get(coursenum).setEnrollStudent(newEnrollStudents);
            return true;
        }
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        for (Course cours : courses) {
            if (cours.getEnrollStudent().size() <= cours.getMaxCapacity()) {
                ArrayList<Student> FinalStudents = new ArrayList<>();
                ArrayList<Course> FinalCourses;
                for (int j = 0; j < cours.getEnrollStudent().size(); j++) {
                    FinalStudents.add(cours.getEnrollStudent().get(j));
                    FinalCourses = cours.getEnrollStudent().get(j).getSuccessCourses();
                    FinalCourses.add(cours);
                    cours.getEnrollStudent().get(j).setSuccessCourses(FinalCourses);
                }
                cours.setSuccessStudents(FinalStudents);
            } else {
                int[][] Credits = new int[cours.getCredits().size()][2];
                for (int j = 0; j < cours.getCredits().size(); j++) {
                    Credits[j][1] = j;
                    Credits[j][0] = cours.getCredits().get(j);
                }
                Arrays.sort(Credits, Comparator.comparingInt(a -> a[0]));
                ArrayList<Integer> GoodIndexs = new ArrayList<>();
                int bottom = cours.getCredits().size() - cours.getMaxCapacity();//bottom>=1,cours.getCredits().size()>=2
                for (int j = cours.getCredits().size() - 1; j >= bottom; j--) {
                    GoodIndexs.add(Credits[j][1]);
                }
                if (Credits[bottom][0] == Credits[bottom - 1][0]) {
                    int k = 0;
                    while (Credits[bottom][0] == Credits[bottom + k][0]) {
                        k++;
                        if (bottom+k==cours.getCredits().size()){//May appear IndexOutOfBoundaryException
                            break;
                        }
                    }
                    for (int j = 0; j < k; j++) {
                        GoodIndexs.remove(GoodIndexs.size() - 1);
                    }
                }
                ArrayList<Student> FinalStudents = new ArrayList<>();
                ArrayList<Course> FinalCourses;
                for (Integer goodIndex : GoodIndexs) {
                    FinalStudents.add(cours.getEnrollStudent().get(goodIndex));
                    FinalCourses = cours.getEnrollStudent().get(goodIndex).getSuccessCourses();
                    FinalCourses.add(cours);
                    cours.getEnrollStudent().get(goodIndex).setSuccessCourses(FinalCourses);
                }
                cours.setSuccessStudents(FinalStudents);
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        } else {
            ArrayList<String> Returns = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int num = -1;
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if (student == student.getEnrollCourses().get(i).getEnrollStudent().get(j)) {
                        num = j;
                        break;
                    }
                }
                if (num == -1) {
                    return null;
                }
                Returns.add(student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(num));
            }
            return Returns;
        }
    }
}