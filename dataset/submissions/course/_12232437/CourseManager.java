


import java.util.ArrayList;
import java.util.Objects;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifopen;

    public CourseManager() {
        ifopen = true;
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(Boolean ifopen) {
        this.ifopen = ifopen;
    }

    public boolean getIfOpen() {
        return ifopen;
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
        Course newcourse = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                newcourse = courses.get(i);
            }
        }
        if (newcourse == null) {return  false;}
        if (!ifopen || credits <= 0 || student.getEnrollCourses().contains(newcourse) || student.getCredits() <credits || !this.courses.contains(newcourse)) {
            return false;}
        else {
            student.setCredits(student.getCredits() - credits);
            ArrayList<Course> courses = student.getEnrollCourses();
            courses.add(newcourse);
            student.setEnrollCourses(courses);
            ArrayList<Student> students =newcourse.getEnrollStudent();
            students.add(student);
            newcourse.setEnrollStudent(students);
            ArrayList<Integer> credit = newcourse.getCredits();
            credit.add(credits);
            newcourse.setCredits(credit);

            return true;
       }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        Course newcourse = null;
        int number = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                newcourse = courses.get(i);
            }


        }
        for (int j = 0; j < newcourse.getEnrollStudent().size(); j++) {
            if (newcourse.getEnrollStudent().get(j).equals(student)) {
                number = j;
            }
        }
        if (newcourse == null) {return  false;}
        if (credits <= 0 || !ifopen || !courses.contains(newcourse) || !student.getEnrollCourses().contains(newcourse) || student.getCredits() < credits -newcourse.getCredits().get(number)){
            return false;
        } else {
            student.setCredits(student.getCredits() - credits +newcourse.getCredits().get(number) );
            newcourse.getCredits().set(number,credits);
            return true;
        }


    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course newcourse = null;
        int studentcourse = 0;
        int number = 0;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                newcourse = courses.get(i);
            }

        }
        for (int j = 0; j < newcourse.getEnrollStudent().size(); j++) {
            if (newcourse.getEnrollStudent().get(j).equals(student)) {
                number = j;
            }
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                if (student.getEnrollCourses().get(i).equals(newcourse)) {
                    studentcourse = i;
                }

            }
        }
        if (newcourse == null) {return  false;}
        if (!ifopen || !this.getCourses().contains(newcourse) || !student.getEnrollCourses().contains(newcourse)) {
            return false;
        } else {
            newcourse.getEnrollStudent().remove(number);
            student.getEnrollCourses().remove(studentcourse);
            student.setCredits(student.getCredits() + newcourse.getCredits().get(number));
            newcourse.getCredits().remove(number);
            return true;
        }
    }

    public void finalizeEnrollments() {
        setIfOpen(false);
        for (int i = 0; i < courses.size(); i++) {
            Course newcourse = courses.get(i);
            int sucesspeople = 0;
            int standard = 1000;

            while (sucesspeople <= newcourse.getMaxCapacity() &&sucesspeople != newcourse.getEnrollStudent().size()) {
                for (int j = 0; j < newcourse.getEnrollStudent().size(); j++) {
                    if (newcourse.getCredits().get(j) >= standard&&newcourse.getCredits().get(j)<standard+1) {
                        sucesspeople++;
                    }
                }
                if (sucesspeople >newcourse.getMaxCapacity()||sucesspeople>newcourse.getEnrollStudent().size()) {
                    return;
                }
                if (sucesspeople <= newcourse.getMaxCapacity()&&sucesspeople<=newcourse.getEnrollStudent().size()) {
                    for (int j = 0; j < newcourse.getEnrollStudent().size(); j++) {
                        if (newcourse.getCredits().get(j) >= standard&&newcourse.getCredits().get(j)<standard+1) {
                            ArrayList<Course> courses = newcourse.getEnrollStudent().get(j).getSuccessCourses();
                            courses.add(newcourse);
                            newcourse.getEnrollStudent().get(j).setSuccessCourses(courses);
                            ArrayList<Student> students = newcourse.getSuccessStudents();
                            students.add(newcourse.getEnrollStudent().get(j));
                            newcourse.setSuccessStudents(students);
                        }
                    }
                }
                standard--;
            }
        }


    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String>table=new ArrayList<String>();
        if (!ifopen) {return null;}
        else {
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                String courseid = String.valueOf(student.getEnrollCourses().get(i).getCourseID());
                String credits = null;
                Course newcourse = student.getEnrollCourses().get(i);
                for (int j = 0; j < newcourse.getEnrollStudent().size(); j++) {
                    if (newcourse.getEnrollStudent().get(j).equals(student)) {
                        credits = String.valueOf(newcourse.getCredits().get(j));
                    }
                }
                table.add(courseid + ": " + credits);

            }
            return table;
        }


    }


}




