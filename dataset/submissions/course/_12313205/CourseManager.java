import java.util.ArrayList;

public class CourseManager {

        private ArrayList<Course> courses;


        private ArrayList<Student> students;

        private boolean ifOpen;

        public CourseManager() {
                this.courses=new ArrayList<>();
                this.students=new ArrayList<>();
                this.ifOpen=true;

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
                courses.add(course);
                course.setCourseManager(this);

        }

        public void addStudent(Student student) {
                students.add(student);
                student.setCourseManager(this);

        }
        public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
                if (ifOpen) {
                        if (credits > 0) {
                                Course courseSelected = null;

                                for (int i = 0; i < courses.size(); i++) {
                                        if (courseId.equals(courses.get(i).getCourseID()))
                                                courseSelected = courses.get(i);
                                }

                                if (courseSelected != null && !ifStudentEnrolled(student, courseSelected) && credits <= student.getCredits()) {

                                        ArrayList<Course> courseList = student.getEnrollCourses();

                                        courseList.add(courseSelected);

                                        student.setEnrollCourses(courseList);

                                        int formerCredits = student.getCredits();
                                        int presentCredits = formerCredits - credits;
                                        student.setCredits(presentCredits);

                                        ArrayList<Student> studentList = courseSelected.getEnrollStudent();

                                        studentList.add(student);

                                        courseSelected.setEnrollStudent(studentList);


                                        ArrayList<Integer> creditsList = courseSelected.getCredits();

                                        creditsList.add(credits);

                                        courseSelected.setCredits(creditsList);

                                        return true;

                                }
                        }
                }
                return false;
        }

        public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {

                if (ifOpen) {
                        if (credits > 0) {
                                Course courseSelected = null;
                                for (int i = 0; i < courses.size(); i++) {
                                        if (courseId.equals(courses.get(i).getCourseID()))
                                                courseSelected = courses.get(i);
                                }

                                if (courseSelected != null && ifStudentEnrolled(student, courseSelected)) {

                                        int studentIndex = 0;
                                        for (int j = 0; j < courseSelected.getEnrollStudent().size(); j++) {
                                                if (courseSelected.getEnrollStudent().get(j) == student) {
                                                        studentIndex = j;
                                                }
                                        }

                                        ArrayList<Integer> FormerCreditsList = courseSelected.getCredits();
                                        int formerCredits = courseSelected.getCredits().get(studentIndex);

                                        int presentCredits1 = student.getCredits() + formerCredits;


                                        if (credits <= presentCredits1) {

                                                student.setCredits(presentCredits1);
                                                int presentCredits2 = student.getCredits() - credits;
                                                student.setCredits(presentCredits2);

                                                FormerCreditsList.set(studentIndex, credits);
                                                courseSelected.setCredits(FormerCreditsList);

                                                return true;

                                        }


                                }
                        }
                }
                return false;
        }


        public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
                if(ifOpen){
                        Course chosenCourse = null;

                        for (int i = 0; i < courses.size(); i++) {
                                if(courses.get(i).getCourseID().equals(courseId)){
                                        chosenCourse = courses.get(i);
                                }
                        }

                        if(chosenCourse != null){

                        int studentIndex = 0;

                        for (int i = 0; i < chosenCourse.getEnrollStudent().size(); i++) {
                                if(student.getStudentID().equals(chosenCourse.getEnrollStudent().get(i).getStudentID())){
                                        studentIndex = i;
                                }
                        }

                        if(ifStudentEnrolled(student,chosenCourse)){

                                ArrayList<Course> FormerCoursesList = student.getEnrollCourses();
                                FormerCoursesList.remove(chosenCourse);
                                student.setEnrollCourses(FormerCoursesList);


                                int FormerCredits = student.getCredits();
                                FormerCredits += chosenCourse.getCredits().get(studentIndex);
                                student.setCredits(FormerCredits);

                                ArrayList<Student> formerStudentList = chosenCourse.getEnrollStudent();
                                formerStudentList.remove(studentIndex);
                                chosenCourse.setEnrollStudent(formerStudentList);

                                ArrayList<Integer> formerCreditsList = chosenCourse.getCredits();
                                formerCreditsList.remove(studentIndex);
                                chosenCourse.setCredits(formerCreditsList);

                                return true;
                        }
                        }

                }
                return false;
        }

        public void finalizeEnrollments() {
                ifOpen=false;

                if(!ifOpen){

                        for (int i = 0; i < courses.size(); i++) {
                                Course courseSelected = courses.get(i);

                                int[] creditsArr = new int[courseSelected.getCredits().size()];

                                Student[] studentsArr = new Student[courseSelected.getCredits().size()];

                                for (int j = 0; j < courseSelected.getCredits().size(); j++) {
                                        creditsArr[j] = courseSelected.getCredits().get(j);
                                        studentsArr[j] = courseSelected.getEnrollStudent().get(j);
                                }

                                for (int j1 = 0; j1 < courseSelected.getCredits().size(); j1++) {
                                        for (int j2 = 0; j2 < courseSelected.getCredits().size()-1; j2++){
                                                if(creditsArr[j2] < creditsArr[j2+1]){
                                                        int midCredits = creditsArr[j2];
                                                        creditsArr[j2] = creditsArr[j2+1];
                                                        creditsArr[j2+1] = midCredits;

                                                        Student midStudent = studentsArr[j2];
                                                        studentsArr[j2] = studentsArr[j2+1];
                                                        studentsArr[j2+1] = midStudent;
                                                }
                                        }
                                }


                                if(courseSelected.getMaxCapacity() >= courseSelected.getEnrollStudent().size()){

                                        //
                                        ArrayList<Student> midList = courseSelected.getEnrollStudent();
                                        for (int i1 = 0; i1 < studentsArr.length; i1++) {
                                                midList.set(i1,studentsArr[i1]);
                                        }
                                        courseSelected.setSuccessStudents(midList);

                                }else if(courseSelected.getMaxCapacity() < courseSelected.getEnrollStudent().size()){

                                        int maxCapacity = courseSelected.getMaxCapacity();

                                        if(creditsArr[maxCapacity - 1] == creditsArr[maxCapacity]){
                                                ArrayList<Integer> finalCreditsList = new ArrayList<>();
                                                ArrayList<Student> finalStudentsList = new ArrayList<>();

                                                for (int j = 0; j < creditsArr.length; j++) {
                                                        if(creditsArr[j] > creditsArr[maxCapacity]){
                                                                finalCreditsList.add(creditsArr[j]);
                                                                finalStudentsList.add(studentsArr[j]);
                                                                //System.out.printf("%s\n",studentsArr[j].getStudentID());
                                                        }
                                                }
                                                courseSelected.setSuccessStudents(finalStudentsList);
                                        }

                                        if(creditsArr[maxCapacity - 1] > creditsArr[maxCapacity]){
                                                ArrayList<Student> finalStudentsList = new ArrayList<>();
                                                for (int i2 = 0; i2 < maxCapacity; i2++) {
                                                        finalStudentsList.add(studentsArr[i2]);
                                                }
                                                courseSelected.setSuccessStudents(finalStudentsList);
                                        }

                                }
                        }


                        for (int i = 0; i < students.size(); i++) {
                                Student studentSelected = students.get(i);
                                ArrayList<Course> finalCourseList = new ArrayList<>();

                                for (int j = 0; j < studentSelected.getEnrollCourses().size(); j++) {

                                        Course chosenCourse = studentSelected.getEnrollCourses().get(j);
                                        for (int i2 = 0; i2 < chosenCourse.getSuccessStudents().size(); i2++) {
                                                if(chosenCourse.getSuccessStudents().get(i2) == studentSelected){
                                                        finalCourseList.add(chosenCourse);
                                                }
                                        }

                                }
                                studentSelected.setSuccessCourses(finalCourseList);
                        }
                }

        }

        public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
                if(ifOpen){
                        ArrayList List = new ArrayList<>();
                        ArrayList<String> IdList = new ArrayList<>();

                        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                                String selectedId = student.getEnrollCourses().get(i).getCourseID();
                                IdList.add(selectedId);
                        }

                        ArrayList<Integer> creditsList = new ArrayList<>();

                        for (int i = 0; i < student.getEnrollCourses().size(); i++) {

                                Course selectedCourse = student.getEnrollCourses().get(i);
                                for (int j = 0; j < selectedCourse.getEnrollStudent().size(); j++) {
                                        if(selectedCourse.getEnrollStudent().get(j) == student){
                                                int CREDIT = selectedCourse.getCredits().get(j);
                                                creditsList.add(CREDIT);
                                        }
                                }
                        }

                        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                                String ID = IdList.get(i);
                                int CREDITS = creditsList.get(i);
                                List.add(ID + ": " + CREDITS);
                        }

                        return List;
                }
                return null;
        }

        public boolean ifStudentEnrolled(Student student, Course course) {

                for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                        if (course.getEnrollStudent().get(j) == student) {       //?????????
                                return true;
                        }
                }
                return false;
        }
}
