import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


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

        public void addStudent(Student student) {
            this.students.add(student);
            student.setCourseManager(this);
        }

        public void addCourse(Course course) {
            this.courses.add(course);
            course.setCourseManager(this);
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

        public boolean enrollStudentInCourse(Student student, String courseID, int credits) {
            if (!this.ifOpen) return false;
            if (credits <= 0) {
                return false;
            }
            for (int i=0;i<courses.size();i++) {
                if (courses.get(i).getCourseID().equals(courseID)) {
                    int x=student.getCredits();
                    courses.get(i).getEnrollStudent().add(student);
                    courses.get(i).getCredits().add(credits);
                    student.getEnrollCourses().add(courses.get(i));
                    student.setCredits(x-credits);
                }
            }
            return true;
        }

        public boolean modifyStudentEnrollmentCredits(Student student, String courseID, int credits) {
            if (!this.ifOpen) {
                return false;
            }
            Course course = null;
            for (Course c : courses) {
                if (c.getCourseID().equals(courseID)) {
                    course = c;
                    break;
                }
                if (course == null) {
                    return false;
                }
            }
            for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                if (student.equals(course.getEnrollStudent().get(i))) {
                    int y=course.getCredits().get(i);
                    course.getCredits().set(i, credits);
                    int x=student.getCredits();
                    student.setCredits(x+y-credits);
                    break;
                }
            }
            return true;
        }

        public boolean dropStudentEnrollmentCourse(Student student, String courseID) {
            if (!this.ifOpen) {
                return false;
            }
                for (int j = 0; j < courses.size(); j++) {
                    if (courses.get(j).getCourseID().equals(courseID)) {
                        for (int i = 0; i < courses.get(j).getEnrollStudent().size(); i++) {
                            if (student.equals(courses.get(j).getEnrollStudent().get(i))) {
                                int a = student.getCredits();
                                int b = courses.get(j).getCredits().get(i);
                                courses.get(j).getEnrollStudent().remove(i);
                                courses.get(j).getCredits().remove(i);
                                student.getEnrollCourses().remove(courses.get(j));
                                student.setCredits(a + b);
                            }
                        }
                    }
                }return true;
            }

        public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
            if (this.ifOpen == true) {
                ArrayList<String> mylist = new ArrayList<>();
                int k=0;
                for (int i = 0; i < courses.size(); i++) {
                    for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                        if (courses.get(i).getEnrollStudent().get(j).equals(student)) {
                            mylist.add(k, (courses.get(i).getCourseID().toString()) + ": " + (courses.get(i).getCredits().get(j).toString()));
                            k++;
                        }
                    }
                }
                System.out.println(mylist);
                return mylist;
            } else {
                return new ArrayList<>();
            }
        }

        public void finalizeEnrollments() {
            setIfOpen(false);
            int [][]c=new int[courses.size()][10];
            for (int i = 0; i < courses.size(); i++) {
                for (int j = 0; j < courses.get(i).getCredits().size(); j++) {

                    c[i][j]=(courses.get(i).getCredits().get(j));
                }

                int m = courses.get(i).getMaxCapacity();
                if(courses.get(i).getEnrollStudent().size()>courses.get(i).getMaxCapacity()) {
                    if (c[i][m-1]>c[i][m]) {
                        for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                            if (courses.get(i).getCredits().get(j)>= c[i][m-1]) {
                                courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                                courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                            }
                        }
                    } else {
                        for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                            if (courses.get(i).getCredits().get(j) > c[i][m-1]) {
                                courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                                courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                            }
                        }
                    }
                }else{
                    for (int j = 0; j < courses.get(i).getEnrollStudent().size(); j++) {
                        courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                        courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                    }
                }
            }
        }
    }