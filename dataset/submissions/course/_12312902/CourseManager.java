import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;


    }

    public ArrayList<Student> getStudents() {
        return students;
    }
// getter for students

    public ArrayList<Course> getCourses() {
        return courses;
    }
// getter for courses

    public void setIfOpen(Boolean ifOpen) {
        this.ifOpen = ifOpen;
    }
// setter for ifOpen

    public boolean getIfOpen() {
        return ifOpen;
    }
// getter for ifOpen

    public void addCourse(Course course) {
        this.courses.add(course);

    }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

    public void addStudent(Student student) {
        this.students.add(student);
        student.setCourseManager(this);

    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (ifOpen) {
            for (Course cou : this.getCourses()) {
                if (Objects.equals(cou.getCourseID(), courseId)) {
                    for (Course cour : student.getEnrollCourses()) {
                        if (cour.getCourseID().equals(courseId)) {
                            return false;
                        }
                    }

                    if (credits > 0 && student.getCredits() >= credits) {
                        ArrayList<Integer> arr = new ArrayList<>(cou.getCredits());
                        arr.add(credits);
                        cou.setCredits(arr);

                        ArrayList<Student> arr_1 = new ArrayList<>(cou.getEnrollStudent());
                        arr_1.add(student);
                        cou.setEnrollStudent(arr_1);

                        ArrayList<Course> arr_2 = new ArrayList<>(student.getEnrollCourses());
                        arr_2.add(cou);
                        student.setEnrollCourses(arr_2);

                        int credit = student.getCredits();
                        student.setCredits(credit - credits);
                        return true;

                    }


                }
            }
        }


        return false;

    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (this.ifOpen) {
            for (Course cou : this.getCourses()) {
                if (Objects.equals(cou.getCourseID(), courseId) && credits > 0) {
                    for (int i = 0; i < cou.getEnrollStudent().size(); i++) {
                        if (cou.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                            if (student.getCredits() + cou.getCredits().get(i) >= credits) {
                                ArrayList<Integer> cr = new ArrayList<>(cou.getCredits());
                                int cre = student.getCredits();
                                student.setCredits(cre + cou.getCredits().get(i) - credits);
                                cr.set(i, credits);
                                cou.setCredits(cr);
                                return true;


                            }


                        }


                    }

                }

            }

        }


        return false;


    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (this.ifOpen) {
            for (Course cou : this.getCourses()) {
                if (Objects.equals(cou.getCourseID(), courseId)) {
                    for (int i = 0; i < cou.getEnrollStudent().size(); i++) {
                        if (cou.getEnrollStudent().get(i).getStudentID().equals(student.getStudentID())) {
                            ArrayList<Student> arrayList = new ArrayList<>(cou.getEnrollStudent());
                            arrayList.remove(student);
                            cou.setEnrollStudent(arrayList);

                            int credit = student.getCredits();
                            int back = cou.getCredits().get(i);
                            int sum = credit + back;
                            student.setCredits(sum);

                            ArrayList<Integer> arrayList1 = new ArrayList<>(cou.getCredits());
                            arrayList1.remove(cou.getCredits().get(i));
                            cou.setCredits(arrayList1);

                            ArrayList<Course> arrayList2 = new ArrayList<>(student.getEnrollCourses());
                            arrayList2.remove(cou);
                            student.setEnrollCourses(arrayList2);

                            return true;


                        }
                    }


                }
            }
        }
        return false;

    }

    public void finalizeEnrollments() {
        this.ifOpen = false;

        for (Course c : this.courses) {
            if (c.getEnrollStudent().isEmpty() || c.getMaxCapacity() == 0) {
                c.setSuccessStudents(c.getEnrollStudent());
            } else {
                int max = c.getMaxCapacity();
                ArrayList<Integer> arr = new ArrayList<>(c.getCredits());
                ArrayList<Student> st = new ArrayList<>(c.getEnrollStudent());
                arr.sort((o1, o2) -> o2 - o1);

                if (max >= c.getEnrollStudent().size()) {
                    c.setSuccessStudents(c.getEnrollStudent());
                } else {
                    int k = (max -1);
                    int num = arr.get(k);
                    if (num > arr.get(max)) {
                        for (int i = 0; i < c.getEnrollStudent().size(); i++) {
                            if (c.getCredits().get(i) < num) {
                                arr.remove(c.getCredits().get(i));
                                st.remove(c.getEnrollStudent().get(i));
                                c.setSuccessStudents(st);
                            }
                        }

                    } else {
                        int p = max - 1;
                        while (arr.get(p) == arr.get(p - 1) && p > 1) {
                            p--;
                        }
                        if( p != 0){
                        int value = arr.get(p-1);
                        for (int j = 0; j < c.getEnrollStudent().size(); j++) {
                            if (c.getCredits().get(j) < value) {
                                arr.remove(c.getCredits().get(j));
                                st.remove(c.getEnrollStudent().get(j));
                                c.setSuccessStudents(st);
                            }
                        }
                        }else{
                            c.setSuccessStudents(new ArrayList<>());
                        }


                    }





                }

            }

        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (this.ifOpen) {
            ArrayList<String> suc = new ArrayList<>();
            for (Course c : student.getEnrollCourses()) {
                for (int k = 0; k < c.getEnrollStudent().size(); k++) {
                    if (c.getEnrollStudent().get(k).getStudentID().equals(student.getStudentID())) {
                        int CREDIT = c.getCredits().get(k);
                        suc.add(String.format("%s: %d", c.getCourseID(), CREDIT));

                    }
                }


            }
            return suc;
        }
        return null;

    }

}


