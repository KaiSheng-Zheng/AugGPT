import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.ifOpen = true;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
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
        if (course.getMaxCapacity() > 0) {
            courses.add(course);
            course.setCourseManager(this);
        }
    }

    public void addStudent(Student student) {
        if (student.getCredits() > 0) {
            students.add(student);
            student.setCourseManager(this);
        }
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean flag1 = false;
        boolean flag2 = true;
        boolean flag3 = false;
        boolean flag4 = this.getIfOpen();
        boolean flag5 = false;
        if (!flag4) {
            return false;
        }
        int count = 0;
        int location1 = 0;
        int location2 = 0;
        if (courses.isEmpty()) {
            return false;
        } else {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    flag1 = true;
                    location1 = count;
                    ArrayList<Student> student1 = course.getEnrollStudent();
                    for (int i = 0; i < student1.size(); i++) {
                        if (student1.get(i).getStudentID().equals(student.getStudentID())) {        
                            location2 = i;
                            flag2 = false;
                        }
                    }
                }
                count += 1;
            }
        }
        if (student.getCredits() >= (credits) && credits > 0 && flag1 && flag2) {
            flag3 = true;
        }
        if (flag1 && flag2 && flag3 && flag4) {
            int initial = student.getCredits();
            student.setCredits(student.getCredits() - credits);       
            int creditttt = student.getCredits();
            student.getEnrollCourses().add(courses.get(location1));
            student.setEnrollCourses(student.getEnrollCourses());                       
            courses.get(location1).getEnrollStudent().add(student);
            courses.get(location1).setEnrollStudent(courses.get(location1).getEnrollStudent());       
            courses.get(location1).getCredits().add(credits);
            courses.get(location1).setCredits(courses.get(location1).getCredits());                 
            flag5 = true;
        }
        return (flag5);
    }


    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = this.getIfOpen();
        boolean flag5 = false;
        if (!flag4) {
            return false;
        }
        int count = 0;
        int location1 = 0;
        int location2 = 0;
        if (courses.isEmpty()) {
            return false;
        } else {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    flag1 = true;
                    location1 = count;
                    ArrayList<Student> student1 = course.getEnrollStudent();
                    for (int i = 0; i < student1.size(); i++) {
                        if (student1.get(i).getStudentID().equals(student.getStudentID())) {         
                            location2 = i;
                            flag2 = true;
                        }
                    }
                }
                count += 1;
            }
        }
        int credit1 = 0;
        if (!courses.isEmpty() && flag1 && flag2 && flag4) {
            credit1 = courses.get(location1).getCredits().get(location2);
            int credittt = student.getCredits();
            if (student.getCredits() + credit1 - credits >= 0 && flag1 && flag2) {
                flag3 = true;
            }
        } else {
            return false;
        }
        if (flag1 && flag2 && flag3 && flag4) {
            int initial = student.getCredits();
            student.setCredits(student.getCredits() + credit1 - credits);        
            int final_credit = student.getCredits();

            courses.get(location1).getCredits().remove(location2);              
            courses.get(location1).getCredits().add(location2, credits);
            courses.get(location1).setCredits(courses.get(location1).getCredits());  
            flag5 = true;
        }
        return (flag5);
    }


    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = this.getIfOpen();
        boolean flag4 = false;
        if (!flag3) {
            return false;
        }
        int count = 0;
        int location1 = 0;
        int location2 = 0;
        int location3 = 0;
        if (courses.isEmpty()) {
            return false;
        } else {
            for (Course course : courses) {
                if (course.getCourseID().equals(courseId)) {
                    flag1 = true;
                    location1 = count;
                    ArrayList<Student> student1 = course.getEnrollStudent();
                    ArrayList<Course> course1 = student.getEnrollCourses();
                    for (int i = 0; i < student1.size(); i++) {
                        if (student1.get(i).getStudentID().equals(student.getStudentID())) {         
                            location2 = i;
                            flag2 = true;
                        }
                    }
                    for (int i = 0; i < course1.size(); i++) {
                        if (course1.get(i).getCourseID().equals(courseId)) {
                            location3 = i;                           
                        }
                    }
                }
                count += 1;
            }
        }
        int credit1 = 0;

        if (flag1 && flag2 && flag3) {
            credit1 = courses.get(location1).getCredits().get(location2);
            int initial = student.getCredits();
            student.setCredits(student.getCredits() + credit1);             
            int final_credit = student.getCredits();
            student.getEnrollCourses().remove(location3);
            student.setEnrollCourses(student.getEnrollCourses());         
            courses.get(location1).getEnrollStudent().remove(location2);    
            courses.get(location1).getCredits().remove(location2); 
            int size = courses.get(location1).getCredits().size();
            flag4 = true;
        }
        return (flag4);
    }



    public void finalizeEnrollments() {
        this.setIfOpen(false);
        for (int i = 0; i < courses.size(); i++) {
            int maxCapacity = courses.get(i).getMaxCapacity();
            ArrayList<Integer> credit_list = courses.get(i).getCredits();
            ArrayList<Student> student_list = courses.get(i).getEnrollStudent();
            if (credit_list.isEmpty() || student_list.isEmpty()) {
                continue;
            }
            int enroll_number = credit_list.size();

            for (int j = 0; j < enroll_number; j++) {
                for (int k = 0; k < enroll_number - j - 1; k++) {
                    if (credit_list.get(k) < credit_list.get(k + 1)) {
                        int temp = credit_list.get(k);
                        credit_list.set(k, credit_list.get(k + 1));
                        credit_list.set(k + 1, temp);
                        Student temp1 = student_list.get(k);
                        student_list.set(k, student_list.get(k + 1));
                        student_list.set(k + 1, temp1);
                    }
                }
            }
            int count = 0;
            int result = 0;
            int j = 0;
            while (j < enroll_number) {
                int number1 = credit_list.get(j);
                int same_number = 0;
                for (int k = j + 1; k < enroll_number; k++) {
                    if (number1 == credit_list.get(k)) {
                        same_number += 1;
                    }
                }
                j+=same_number;
                if (count + 1 + same_number > maxCapacity) {
                    result = count;
                    break;
                } else if (count + 1 + same_number == maxCapacity) {
                    result = count + 1 + same_number;
                    break;
                } else {
                    count = count + 1 + same_number;
                    j+=1;
                }
            }
            if (result == 0 && count < maxCapacity) {
                result = count;
            }
            ArrayList<Student> successstudent_list = new ArrayList<>();
            int q = 0;
            while (result > 0 && q < student_list.size()) {
                successstudent_list.add(student_list.get(q));
                ArrayList<Course> SUCCESS_COURSES = student_list.get(q).getSuccessCourses();
                SUCCESS_COURSES.add(courses.get(i));
                student_list.get(q).setSuccessCourses(SUCCESS_COURSES);         
                result -= 1;
                q += 1;
            }
            courses.get(i).setSuccessStudents(successstudent_list);
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> information = new ArrayList<>();
        if (!this.ifOpen) {
            return null;
        }
        for (Course course : courses) {
            ArrayList<Student> enrolledStudents = course.getEnrollStudent();

            if (enrolledStudents.contains(student)) {
                String courseId = course.getCourseID();
                ArrayList<Integer> credits = course.getCredits();

                int studentIndex = enrolledStudents.indexOf(student);
                int studentCredits = credits.get(studentIndex);

                String context = courseId + ": " + studentCredits;
                information.add(context);
            }
        }
        return information;
    }
}
