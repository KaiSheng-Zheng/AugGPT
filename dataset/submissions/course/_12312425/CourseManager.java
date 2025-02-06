import java.util.ArrayList;

class CourseManager {
    private boolean ifOpen;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public CourseManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        ifOpen = true;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        int courseOrder = 0;
        boolean ifIdExist = false;
        boolean ifStudentExist = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)){
                ifIdExist = true;
                courseOrder = i;
                for (int j = 0; j < courses.get(courseOrder).getEnrollStudent().size(); j++) {
                    if (courses.get(courseOrder).getEnrollStudent().get(j) == student){
                        ifStudentExist = true;
                        break;
                    }
                }
            }
        }
        if(ifOpen && ifIdExist && credits <= student.getCredits() && credits > 0 && !ifStudentExist){
            courses.get(courseOrder).getEnrollStudent().add(student);
            student.getEnrollCourses().add(courses.get(courseOrder));
            courses.get(courseOrder).getCredits().add(credits);
            student.setCredits(student.getCredits() - credits);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        int courseOrder = 0;
        int studentOrder = 0;
        int courseOrder1 = 0;
        boolean ifIdExist = false;
        boolean ifStudentExist = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)){
                courseOrder = i;
                ifIdExist = true;
                for (int j = 0; j < courses.get(courseOrder).getEnrollStudent().size(); j++) {
                    if (courses.get(courseOrder).getEnrollStudent().get(j) == student){
                        studentOrder = j;
                        ifStudentExist = true;
                    }
                }
            }
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i) == courses.get(courseOrder)){
                courseOrder1 = i;
            }
        }
        if(!this.getCourses().get(courseOrder).getCredits().isEmpty()){
            if (student.getCredits() + courses.get(courseOrder).getCredits().get(studentOrder) >= credits && ifOpen && ifIdExist && ifStudentExist && credits >= 0){
                courses.get(courseOrder).getEnrollStudent().remove(studentOrder);
                student.setCredits(student.getCredits() + courses.get(courseOrder).getCredits().get(studentOrder) - credits);
                courses.get(courseOrder).getCredits().remove(studentOrder);
                courses.get(courseOrder).getEnrollStudent().add(student);
                courses.get(courseOrder).getCredits().add(credits);
                student.getEnrollCourses().remove(courseOrder1);
                student.getEnrollCourses().add(courses.get(courseOrder));
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        int courseOrder = 0;
        int courseOrder1 = 0;
        int studentOrder = 0;
        boolean ifIdExist = false;
        boolean ifStudentExist = false;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(courseId)){
                courseOrder = i;
                ifIdExist = true;
                for (int j = 0; j < courses.get(courseOrder).getEnrollStudent().size(); j++) {
                    if (courses.get(courseOrder).getEnrollStudent().get(j) == student) {
                        studentOrder = j;
                        ifStudentExist = true;
                    }
                }
            }
        }
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
            if (student.getEnrollCourses().get(i) == courses.get(courseOrder)){
                courseOrder1 = i;
            }
        }
        if (ifOpen && ifIdExist && ifStudentExist){
            courses.get(courseOrder).getEnrollStudent().remove(studentOrder);
            student.setCredits(student.getCredits() + courses.get(courseOrder).getCredits().get(studentOrder));
            courses.get(courseOrder).getCredits().remove(studentOrder);
            student.getEnrollCourses().remove(courseOrder1);
            return true;
        }
        else {
            return false;
        }
    }

    public void finalizeEnrollments() {
        this.setIfOpen(false);
        for (int i = 0; i < this.getCourses().size(); i++) {
            int big;
            Student student;
            for (int k = 0; k < this.getCourses().get(i).getCredits().size() * this.getCourses().get(i).getCredits().size(); k++) {
                for (int j = 0; j < this.getCourses().get(i).getCredits().size() - 1; j++) {
                    if (this.getCourses().get(i).getCredits().get(j) < this.getCourses().get(i).getCredits().get(j + 1)){
                        big = this.getCourses().get(i).getCredits().get(j + 1);
                        this.getCourses().get(i).getCredits().set(j + 1, this.getCourses().get(i).getCredits().get(j));
                        this.getCourses().get(i).getCredits().set(j, big);
                        student = this.getCourses().get(i).getEnrollStudent().get(j);
                        this.getCourses().get(i).getEnrollStudent().set(j, this.getCourses().get(i).getEnrollStudent().get(j + 1));
                        this.getCourses().get(i).getEnrollStudent().set(j + 1, student);
                    }
                }
            }
            int enrollment = 0;
            if (this.getCourses().get(i).getCredits().size() <= this.getCourses().get(i).getMaxCapacity()) {
                for (int j = 0; j < this.getCourses().get(i).getCredits().size(); j++) {
                    this.getCourses().get(i).getSuccessStudents().add(this.getCourses().get(i).getEnrollStudent().get(j));
                    this.getCourses().get(i).getSuccessStudents().get(j).getSuccessCourses().add(this.getCourses().get(i));
                }
            }
            else{
                for (int j = 0; j < this.getCourses().get(i).getCredits().size(); j++) {
                    enrollment++;
                    if (enrollment == this.getCourses().get(i).getMaxCapacity() + 1){
                        int num = j;
                        for (int k = j - 1; k >= 0; k--) {
                            if(this.getCourses().get(i).getCredits().get(k).equals(this.getCourses().get(i).getCredits().get(j))){
                                num = k;
                            }
                        }
                        for (int k = 0; k < num; k++) {
                            this.getCourses().get(i).getSuccessStudents().add(this.getCourses().get(i).getEnrollStudent().get(k));
                            this.getCourses().get(i).getSuccessStudents().get(k).getSuccessCourses().add(this.getCourses().get(i));
                        }
                    }
                }
            }
        }
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        ArrayList<String> list = new ArrayList<>();
        if (ifOpen){
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                int studentOrder = 0;
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if(student.getEnrollCourses().get(i).getEnrollStudent().get(j) == student){
                        studentOrder = j;
                    }
                }
                String report = (student.getEnrollCourses().get(i).getCourseID() + ": " + student.getEnrollCourses().get(i).getCredits().get(studentOrder));
                list.add(report);
            }
            return list;
        }
        else{
            return null;
        }
    }
}