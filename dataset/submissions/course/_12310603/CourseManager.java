import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    private ArrayList<String> list;

    public ArrayList<String> ID;
    private boolean ifOpen;
    public int middle;


    public CourseManager() {
    
        this.ifOpen = true;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ID = new ArrayList<>();
        this.middle = 0;
        this.list=new ArrayList<>();
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public ArrayList <String> getID(){return ID;}

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public void addCourse(Course course) {
        course.setCourseManager(this);

        courses.add(course);

        ID.add(course.getCourseID());

    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        students.add(student);

    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        int temp;

        if (getIfOpen()) {
            if (ID.contains(courseId)) {
                middle = ID.indexOf(courseId);
                if (student.getEnrollCourses().contains(courses.get(middle)))
                    return false;
                else {
                    if (student.getCredits() >= credits & credits > 0) {
                        student.getEnrollCourses().add((courses.get(middle)));
                        courses.get(middle).getEnrollStudent().add(student);
                        courses.get(middle).getCredits().add(credits);
                        temp = student.getCredits() - credits;
                        student.setCredits(temp);
                        return true;
                    } else
                        return false;
                }
            } else
                return false;

        } else
            return false;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        int temp;

        if (getIfOpen()) {
            if (ID.contains(courseId)) {
                middle = ID.indexOf(courseId);
                if (student.getEnrollCourses().contains(courses.get(middle))) {
                    if (student.getCredits()+courses.get(middle).getCredits().get(courses.get(middle).getEnrollStudent().indexOf(student)) >= credits ) {
                        if (credits>0){

                        temp = student.getCredits() - credits + courses.get(middle).getCredits().get(courses.get(middle).getEnrollStudent().indexOf(student));
                        student.setCredits(temp);
                        courses.get(middle).getCredits().set(courses.get(middle).getEnrollStudent().indexOf(student), credits);
                        return true;}
                        else
                            return false;
                    } else
                        return false;

                }
                else
                    return false;

            }
            else
                return false;

        }
        else
            return false;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        int temp;


        if (getIfOpen()) {
            if (ID.contains(courseId)) {
                middle = ID.indexOf(courseId);
                if (student.getEnrollCourses().contains(courses.get(middle))) {
                    student.getEnrollCourses().remove(courses.get(middle));
                    temp = student.getCredits() + courses.get(middle).getCredits().get(courses.get(middle).getEnrollStudent().indexOf(student));
                    student.setCredits(temp);
                    courses.get(middle).getCredits().remove(courses.get(middle).getEnrollStudent().indexOf(student));
                    courses.get(middle).getEnrollStudent().remove(courses.get(middle).getEnrollStudent().indexOf(student));


                    return true;
                } else

                    return false;
            } else
                return false;

        } else
            return false;
    }

    public void finalizeEnrollments() {
        setIfOpen(false);

        int i, j, k, tmp, l, m = 0;

        for (int d = 0; d < courses.size(); d++) {

            for (i = 0; i < courses.get(d).getCredits().size(); i++) {
                k = i;
                for (j = i + 1; j < courses.get(d).getCredits().size(); j++)
                    if (courses.get(d).getCredits().get(j) > courses.get(d).getCredits().get(k)) {
                        tmp = courses.get(d).getCredits().set(k, courses.get(d).getCredits().get(j));
                        courses.get(d).getCredits().set(j, tmp);

                        Student str = courses.get(d).getEnrollStudent().set(k, courses.get(d).getEnrollStudent().get(j));
                        courses.get(d).getEnrollStudent().set(j, str);
                    }

                if (k != i) {

                    tmp = courses.get(d).getCredits().set(i, courses.get(d).getCredits().get(k));
                    courses.get(d).getCredits().set(k, tmp);
                    Student str = courses.get(d).getEnrollStudent().set(i, courses.get(d).getEnrollStudent().get(k));
                    courses.get(d).getEnrollStudent().set(k, str);
                }
            }
            if (courses.get(d).getEnrollStudent().size() > courses.get(d).getMaxCapacity()) {
                m = 0;
                for (l = 0; l < courses.get(d).getMaxCapacity(); l++) {
                    if (courses.get(d).getCredits().get(l) == courses.get(d).getCredits().get(l + 1)) {
                        break;
                    } else
                        m++;

                }
                for (int n = 0; n < m; n++) {
                    courses.get(d).getSuccessStudents().add(courses.get(d).getEnrollStudent().get(n));
                    courses.get(d).getEnrollStudent().get(n).getSuccessCourses().add(courses.get(d));

                }
            }
            else {
                for (int n = 0; n < courses.get(d).getEnrollStudent().size(); n++) {
                    courses.get(d).getSuccessStudents().add(courses.get(d).getEnrollStudent().get(n));
                    courses.get(d).getEnrollStudent().get(n).getSuccessCourses().add(courses.get(d));

                }

            }


        }


    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if (getIfOpen()) {
            list.clear();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                list.add(student.getEnrollCourses().get(i).getCourseID()+": "+student.getEnrollCourses().get(i).getCredits().get(student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student)));
            }

            return list;


        }
        else
            return  null;

    }
}




