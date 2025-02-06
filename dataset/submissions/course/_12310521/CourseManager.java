import java.util.ArrayList;
public class CourseManager {
        private ArrayList<Course> courses;
        private ArrayList<Student> students;
        private boolean ifOpen;

        public CourseManager(){
            this.courses = new ArrayList<>();
            this.students = new ArrayList<>();
            this.ifOpen = true;
        }
        public ArrayList<Student> getStudents(){
            return students;
        }
// getter for students

        public ArrayList<Course> getCourses(){
            return  courses;
        }
// getter for courses

        public void setIfOpen(Boolean ifOpen){
            this.ifOpen = ifOpen;
        }
// setter for ifOpen

        public boolean getIfOpen(){
            return ifOpen;
        }
// getter for ifOpen

        public void addCourse(Course course){
            Course thiscourse = course;
            courses.add(thiscourse);
            course.setCourseManager(this);
        }
// Register a course. Add a course object to courses and set the courseManager of the course object to this manager. It is guaranteed that all courseIDs are unique.

        public void addStudent(Student student){
            students.add(student);
            student.setCourseManager(this);

        }
        public boolean enrollStudentInCourse(Student student, String courseId, int credits){
            if(ifOpen==false){
                return false;
            }
            if (!courseExist(courseId)){
                return false;
            }
            if(studentExist(student,courseId)){
                return false;
            }
            if(!(credits>0)){
                return false;
            }
            if (student.getCredits()<credits){
                return false;
            }
 //            reduce credit of student
            student.setCredits(student.getCredits()-credits);

//            with id , find the aim course
            Course aimcourse=courses.get(findcourse(courseId));

//            put this student into this course's enrollStudent list
            ArrayList<Student> renew = aimcourse.getEnrollStudent();
            renew.add(student);
            aimcourse.setEnrollStudent(renew);

//            put the student's bid credit into this course's credit list
            ArrayList<Integer> renewcredits = aimcourse.getCredits();
            renewcredits.add(credits);
            aimcourse.setCredits(renewcredits);

//            put this course into this student's enrollCourses list
            ArrayList<Course>renewcourses = student.getEnrollCourses();
            renewcourses.add(aimcourse);
            student.setEnrollCourses(renewcourses);

            return true;
        }
        public boolean courseExist(String courseId){
            boolean exist = false;
            for(int i = 0; i< courses.size();i++){
                if (courses.get(i).getCourseID().equals(courseId)){
                    exist = true;
                    break;
                }
            }
            return exist;
        }

        public boolean modifyStudentEnrollmentCredits(Student student, String courseId,int credits){
            if(ifOpen==false){
                return false;
            }
            if (!courseExist(courseId)){
                return false;
            }
            Course aimcourse = courses.get(findcourse(courseId));

            if(!studentExist(student,courseId)){
                return false;
            }
            int oldcredits = aimcourse.getCredits().get(findStudent(student,aimcourse));
            if(credits>student.getCredits()+oldcredits){
                return false;
            }
//            update the student's left credits
            student.setCredits(student.getCredits()+oldcredits-credits);

//            update the student's bid on this aimcourse
            ArrayList<Integer> renewCredits =aimcourse.getCredits();
            renewCredits.set(findStudent(student,aimcourse),credits);
            aimcourse.setCredits(renewCredits);

            return true;
        }

        public boolean dropStudentEnrollmentCourse(Student student, String courseId){
            if(ifOpen==false){
                return false;
            }
            if (!courseExist(courseId)){
                return false;
            }
            Course aimcourse = courses.get(findcourse(courseId));

            if(!studentExist(student,courseId)){
                return false;
            }

//            obtain the credit the student bid on this course now
            int oldcredits = aimcourse.getCredits().get(findStudent(student,aimcourse));
            student.setCredits(student.getCredits()+oldcredits);

//            remove the student's bid from the credits list of the course
            ArrayList<Integer> renewCredits = aimcourse.getCredits();
            renewCredits.remove(findStudent(student,aimcourse));
            aimcourse.setCredits(renewCredits);

//            remove the student from the enrrollstudent list of the course
            ArrayList renewStudent = aimcourse.getEnrollStudent();
            renewStudent.remove(student);
            aimcourse.setEnrollStudent(renewStudent);


//            remove the course from the student's enrrollcourse list
            ArrayList renewCourse = student.getEnrollCourses();
            renewCourse.remove(aimcourse);
            student.setEnrollCourses(renewCourse);
            return true;
        }

        public void finalizeEnrollments(){
            ifOpen = false;
            for(int i = 0; i < courses.size(); i++){
                ArrayList<Student> finalStudents = successfullstudent(courses.get(i),courses.get(i).getMaxCapacity());
                courses.get(i).setSuccessStudents(finalStudents);
            }
        }

//        find the student who bid most on th course
        public static int[] biggest(ArrayList<Integer> x){
            int size = x.size();
            int num = x.get(0);
            int index = 0;
            if(size>1) {
                for (int i = 1; i < size; i++) {
                    if (num < x.get(i)) {
                        num = x.get(i);
                        index = i;
                    }
                }
            }
            x.set(index,-index);
            int[] result = {index,num};
            return result;
        }

        public ArrayList<Student> successfullstudent(Course course, int courseCapacity){
            ArrayList<Student> enrrollStudent = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            //            if the course can hold all students, then hold all
            if(enrrollStudent.size()<=courseCapacity){
                return enrrollStudent;
            }
//            cannot hold all
            ArrayList<Student> successfullstudent = new ArrayList<Student>(0);
            ArrayList<Integer> successcredits = new ArrayList<>(0);

//            first fill the course until number of members equals the capacity
            while(successfullstudent.size()<courseCapacity){
                int[] select = biggest(credits);
                successfullstudent.add(enrrollStudent.get(select[0]));
                successcredits.add(select[1]);
            }
//            same credits, same drop
            if(successcredits.get(successcredits.size()-1)==biggest(credits)[1]){
                successfullstudent.remove(successcredits.size()-1);
                int i = 1;
                while(successcredits.size()>=i+1){
                    if(successcredits.get(successcredits.size()-i-1)==successcredits.get(successcredits.size()-i)){
                        successfullstudent.remove(successcredits.size()-i-1);
                    }else{
                        break;
                    }
                    i++;
                }
            }
            for(int j = 0; j < successfullstudent.size();j++){
                Student member =successfullstudent.get(j);
                ArrayList<Course> successfullcourse = member.getSuccessCourses();
                successfullcourse.add(course);
                member.setSuccessCourses(successfullcourse);
            }
            return successfullstudent;
        }

        public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
            if(ifOpen==false){
                return null;
            }
            int coursenumber = student.getEnrollCourses().size();
            ArrayList<String> courseList = new ArrayList<String>(0);
            for(int i = 0; i<coursenumber;i++){
                String Id = student.getEnrollCourses().get(i).getCourseID();
                int studentIndex = student.getEnrollCourses().get(i).getEnrollStudent().indexOf(student);
                int bidcredits = student.getEnrollCourses().get(i).getCredits().get(studentIndex);
                courseList.add(String.format("%s: %d",Id,bidcredits));
            }
            return courseList;
        }

//        find if the student is in a certain course's enrrollstudent's list
        public boolean studentExist(Student student,String courseId){
            boolean exist = false;
            Course aimcourse =  courses.get(findcourse(courseId));
            ArrayList <Student> studentlist = aimcourse.getEnrollStudent();
            for(int i=0; i<studentlist.size(); i++){
                if(studentlist.get(i).equals(student)){
                    exist = true;
                    break;
                }
            }
            return exist;
        }
//            give id find the corresponding course's index
        public int findcourse(String courseId){

            int courseindex=0 ;
            for(int i = 0; i< courses.size();i++){
                if (courses.get(i).getCourseID().equals(courseId)){
                    courseindex = i;
                    break;
                }
            }
            return courseindex;
        }

//        give a student find its index in the course's enrrollstudent list
        public int findStudent(Student student, Course course){
            int result=0;
            for(int i =0; i<course.getEnrollStudent().size(); i++){
                if(course.getEnrollStudent().get(i).equals(student)){
                    result = i;
                    break;
                }
            }
            return result;
        }
    }
