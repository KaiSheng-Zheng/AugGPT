import java.util.ArrayList;

class CourseManager {
     private ArrayList<Course> courses =new ArrayList<>();
     private ArrayList<Student> students = new ArrayList<>();
     private boolean ifOpen;

    public CourseManager(ArrayList<Course> courses, ArrayList<Student> students) {
        this.courses = courses;
        this.students = students;
        this.ifOpen = true;
    }

    public CourseManager() {
        new CourseManager(null, null);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }



    public boolean getIfOpen() {
        return ifOpen;
    }

    public void addCourse(Course course){
        this.courses.add(course);
        course.setCourseManager(this);

    }

    public void addStudent(Student student){
        this.students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits){

        boolean courseExist = false;
        Course course = null;
        for(Course b : courses){
            if (courseId.equals(b.getCourseID())){
                courseExist = true;
                course = b;
                break;
            }
        }

        boolean courseEnroll = false;
        for(Course b : student.getEnrollCourses()){
            if (courseId.equals(b.getCourseID())){
                courseEnroll = true;
                break;
            }
        }

        if(!courseExist || courseEnroll || credits <= 0 || credits > student.getCredits() || !ifOpen){
            return false;
        }else{
            student.setCredits(student.getCredits() - credits);
            student.getEnrollCourses().add(course);
            course.getEnrollStudent().add(student);
            course.getCredits().add(credits);
            return true;
        }
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits){

        boolean courseExist = false;
        Course course = null;
        for(Course b : courses){
            if (courseId.equals(b.getCourseID())){
                courseExist = true;
                course = b;
                break;
            }
        }

        boolean courseEnroll = course.getEnrollStudent().contains(student);


        if(!courseExist || !courseEnroll || credits < 0 || credits > student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)) || !ifOpen){
            return false;
        }else{
            student.setCredits(student.getCredits() + course.getCredits().get(course.getEnrollStudent().indexOf(student)) - credits);
            course.getCredits().set(course.getEnrollStudent().indexOf(student), credits);
            return true;
        }


    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId){

        boolean courseExist = false;
        Course course = null;
        for(Course b : courses){
            if (courseId.equals(b.getCourseID())){
                courseExist = true;
                course = b;
                break;
            }
        }

        boolean courseEnroll = false;
        int i = 0;
        for(Student b : course.getEnrollStudent()){
            if (student == b){
                courseEnroll = true;
                break;
            }
            i++;
        }

        if(!courseExist || !courseEnroll || !ifOpen){
            return false;
        }else{
            student.getEnrollCourses().remove(course);
            course.getEnrollStudent().remove(student);
            student.setCredits(student.getCredits() + course.getCredits().get(i));
            course.getCredits().remove(i);
            return true;
        }

    }

    public void finalizeEnrollments(){
        for(Course course : courses){
            for(int a = 0; a < course.getEnrollStudent().size(); a++){
                int max = course.getCredits().get(a);
                int c = a;
                for(int b = a; b < course.getEnrollStudent().size(); b++){
                    if(max < course.getCredits().get(b)){
                        max = course.getCredits().get(b);
                        c = b;


                    course.getCredits().set(c, course.getCredits().get(a));
                    course.getCredits().set(a, max);

                    Student c1 = course.getEnrollStudent().get(c);
                    course.getEnrollStudent().set(c, course.getEnrollStudent().get(a));
                    course.getEnrollStudent().set(a, c1);}
                }
            }
        }

        for(Course course : courses){
            if(course.getMaxCapacity() < course.getEnrollStudent().size()){
            for(int i = 0; i < course.getMaxCapacity(); i++){
                if(course.getCredits().get(i) > course.getCredits().get(course.getMaxCapacity())){
                course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                course.getEnrollStudent().get(i).getSuccessCourses().add(course);
                }
                }
            }else if (!course.getEnrollStudent().isEmpty()){for(int i = 0; i < course.getEnrollStudent().size(); i++){

                    course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                    course.getEnrollStudent().get(i).getSuccessCourses().add(course);

                }
            }

            this.setIfOpen(false);
        }


    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
        if(ifOpen){
            ArrayList<String> get = new ArrayList<>();
            for(Course course : student.getEnrollCourses()){
                int i = 0;
                int credit = 0 ;
                for(Student b : course.getEnrollStudent()){

                if (student == b){
                    credit = course.getCredits().get(i);
                    break;
                    }
                    i++;
                }
                String with = String.format("%s: %d", course.getCourseID(), credit);
                get.add(with);
            }
            return get;
        }else {return null;}
    }



}