import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

class CourseManager {
    private boolean ifOpen;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Integer> credits = new ArrayList<>();


    public CourseManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        ifOpen=true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }


    public void addStudent(Student student1) {
        student1.setCourseManager(this);
        students.add(student1);
        credits.add(student1.getCredits());

    }

    public void addCourse(Course course1) {
        courses.add(course1);
    }

    public void setIfOpen(boolean b) {
        ifOpen = b;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (Objects.equals(courses.get(i).getCourseID(), courseId)) {
                count++;
                temp = i;
            }
        }
        if (count >= 1 && credits > 0 && student.getCredits() >= credits && ifOpen) {
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(courses.get(temp));
            courses.get(temp).getEnrollStudent().add(student);
            courses.get(temp).getCredits().add(credits);
            return true;
        } else {
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        int count = 0;
        int temp = 0;
        int count1 = 0;
        int temp1 = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (Objects.equals(courses.get(i).getCourseID(), courseId)) {
                count++;
                temp = i;
            }
        }
        for (int i = 0; i < courses.get(temp).getEnrollStudent().size(); i++) {
            if (courses.get(temp).getEnrollStudent().get(i) == student) {
                count1++;
                temp1 = i;
            }
        }
        if (count >= 1 && count1 >= 1 && (courses.get(temp).getCredits().get(temp1) + student.getCredits()) >= credits && ifOpen) {
            student.setCredits(courses.get(temp).getCredits().get(temp1) + student.getCredits() - credits);
            courses.get(temp).getCredits().set(temp1, credits);
            return true;
        } else {
            return false;
        }
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        int count = 0;
        int temp = 0;
        int count1 = 0;
        int temp1 = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (Objects.equals(courses.get(i).getCourseID(), courseId)) {
                count++;
                temp = i;
            }
        }
        for (int i = 0; i < courses.get(temp).getEnrollStudent().size(); i++) {
            if (courses.get(temp).getEnrollStudent().get(i) == student) {
                count1++;
                temp1 = i;
            }
        }
        if (count >= 1 && ifOpen && count1 >= 1) {
            student.setCredits(student.getCredits() + courses.get(temp).getCredits().get(temp1));
            courses.get(temp).getEnrollStudent().remove(temp1);
            courses.get(temp).getCredits().remove(temp1);
            student.getEnrollCourses().remove(courses.get(temp));
            return true;
        } else {
            return false;
        }
    }

    public void finalizeEnrollments() {
        for (int i = 0; i < courses.size(); i++) {
            ArrayList <Integer> sort;
            if(courses.get(i).getCredits()!=null){
                 sort=ArraySort(courses.get(i).getCredits(),courses.get(i).getMaxCapacity());
                 for (int j = 0; j < sort.size(); j++) {
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(sort.get(j)));
                    courses.get(i).getEnrollStudent().get(sort.get(j)).getSuccessCourses().add(courses.get(i));
                }
            }
        }
        ifOpen=false;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen) {
            int temp = 0;
            ArrayList<String> arrayBack = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(j) == student) {
                        temp = j;
                    }
                }
                String str = student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(temp);
                arrayBack.add(str);
            }
            return arrayBack;
        } else {
            return null;
        }
    }

    public ArrayList<Integer> ArraySort(ArrayList<Integer> arrays, int n) {
        int[] arrayCopy = new int[arrays.size()];
        for (int i = 0; i < arrayCopy.length; i++) {
            arrayCopy[i] = arrays.get(i);
        }
        Arrays.sort(arrayCopy);
        for (int i = 0; i < arrayCopy.length / 2; i++) {
            int temp = arrayCopy[i];
            arrayCopy[i] = arrayCopy[arrayCopy.length - 1 - i];
            arrayCopy[arrayCopy.length - 1 - i] = temp;
        }

        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (arrayCopy.length > n) {
            if(arrayCopy[n]==arrayCopy[n-1]){
                for (int i = 0; i <n; i++) {
                    if(arrayCopy[i]!=arrayCopy[n-1]){
                        for (int j = 0; j < arrays.size(); j++) {
                            if(arrayCopy[i]==arrays.get(j)){index.add(j);arrays.set(j,0);}
                        }
                    }
                }
                }else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < arrays.size(); j++) {
                        if(arrayCopy[i]==arrays.get(j)){index.add(j);arrays.set(j,0);}
                    }
                }
            }
        } else {
            for (int i = 0; i < arrays.size(); i++) {
                index.add(i);
            }
        }return index;
    }
}