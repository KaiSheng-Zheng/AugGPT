import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CourseManager {
    
    private ArrayList<Course> courses;

   
    private ArrayList<Student> students;


    private boolean ifOpen;

   
    public CourseManager() {
      
        ifOpen = true;

       
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    
    public ArrayList<Student> getStudents() {
        return students;
    }


 
    public ArrayList<Course> getCourses() {
        return courses;
    }


   
    public void setIfOpen(Boolean ifopen) {
        ifOpen = ifopen;
    }


  
    public boolean getIfOpen() {
        return ifOpen;
    }


   
    public void addCourse(Course course) {
        
        if (courses.size() > 0) {
            for (int j = 0; j < courses.size(); j++) {
                if (courses.get(j).getCourseID() == course.getCourseID()) {
                    return;
                }
            }
        }

       
        course.setCourseManager(this);

        
        courses.add(course);
    }


  
    public void addStudent(Student student) {
       
        if (students.size() > 0) {
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).getStudentID() == student.getStudentID()) {
                    return;
                }
            }
        }

      
        student.setCourseManager(this);

       
        students.add(student);
    }

 
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if ((!ifOpen) || (0 == students.size()) || (0 == courses.size())) {
            return false;
        }

        
        Boolean ifCourseIdExist = false;
        int courseIdIndex = 0;
        for (int j = 0; j < courses.size(); j++) {
            if (courses.get(j).getCourseID() == courseId) {
                ifCourseIdExist = true;
                courseIdIndex = j;
                break;
            }
        }
        if (!ifCourseIdExist) {
            return false;
        }

       
        Boolean ifStudentExist = false;
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).getStudentID() == student.getStudentID()) {
                ifStudentExist = true;
                break;
            }
        }
        if (!ifStudentExist) {
            return false;
        }

        
        if (student.getEnrollCourses().size() > 0) {
            for (int j = 0; j < student.getEnrollCourses().size(); j++) {
                if (student.getEnrollCourses().get(j).getCourseID() == courseId) {
                    return false;
                }
            }
        }

       
        int creditsOfStudent = student.getCredits();
        if (creditsOfStudent < credits) {
            return false;
        }

        
        student.setCredits(creditsOfStudent - credits);

        
        courses.get(courseIdIndex).getEnrollStudent().add(student);

       
        courses.get(courseIdIndex).getCredits().add(credits);

        
        student.getEnrollCourses().add(courses.get(courseIdIndex));

        return true;
    }

  
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if ((!ifOpen) || (0 == students.size()) || (0 == courses.size()) || (0 == student.getEnrollCourses().size())) {
            return false;
        }

       
        Boolean ifCourseIdExist = false;
        int courseIdIndex = 0;
        for (int j = 0; j < courses.size(); j++) {
            if (courses.get(j).getCourseID() == courseId) {
                ifCourseIdExist = true;
                courseIdIndex = j;
                break;
            }
        }
        if (!ifCourseIdExist) {
            return false;
        }

        
        Boolean ifStudentExist = false;
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).getStudentID() == student.getStudentID()) {
                ifStudentExist = true;
                break;
            }
        }
        if (!ifStudentExist) {
            return false;
        }

       
        int courseIdIndexOfStudent = -1;
        for (int j = 0; j < student.getEnrollCourses().size(); j++) {
            if (student.getEnrollCourses().get(j).getCourseID() == courseId) {
                courseIdIndexOfStudent = j;
                break;
            }
        }
        if (courseIdIndexOfStudent < 0) {
            return false;
        }

       
        int studentIndex = -1;
        for (int j = 0; j < student.getEnrollCourses().get(courseIdIndexOfStudent).getEnrollStudent().size(); j++) {
            if (student.getEnrollCourses().get(courseIdIndexOfStudent).getEnrollStudent().get(j).getStudentID() == student.getStudentID()) {
                studentIndex = j;
                break;
            }
        }
        if (studentIndex < 0) {
            return false;
        }

       
        int creditsOfStudent = student.getCredits();
        if ((creditsOfStudent + student.getEnrollCourses().get(courseIdIndexOfStudent).getCredits().get(studentIndex)) < credits) {
            return false;
        }

       
        student.setCredits(creditsOfStudent + student.getEnrollCourses().get(courseIdIndexOfStudent).getCredits().get(studentIndex) - credits);
        student.getEnrollCourses().get(courseIdIndexOfStudent).getCredits().set(studentIndex, credits);

        return true;
    }

    
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if ((!ifOpen) || (0 == students.size()) || (0 == courses.size()) || (0 == student.getEnrollCourses().size())) {
            return false;
        }

       
        Boolean ifCourseIdExist = false;
        int courseIdIndex = 0;
        for (int j = 0; j < courses.size(); j++) {
            if (courses.get(j).getCourseID() == courseId) {
                ifCourseIdExist = true;
                courseIdIndex = j;
                break;
            }
        }
        if (!ifCourseIdExist) {
            return false;
        }

       
        Boolean ifStudentExist = false;
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).getStudentID() == student.getStudentID()) {
                ifStudentExist = true;
                break;
            }
        }
        if (!ifStudentExist) {
            return false;
        }

       
        int courseIdIndexOfStudent = -1;
        for (int j = 0; j < student.getEnrollCourses().size(); j++) {
            if (student.getEnrollCourses().get(j).getCourseID() == courseId) {
                courseIdIndexOfStudent = j;
                break;
            }
        }
        if (courseIdIndexOfStudent < 0) {
            return false;
        }

       
        int studentIndex = -1;
        for (int j = 0; j < student.getEnrollCourses().get(courseIdIndexOfStudent).getEnrollStudent().size(); j++) {
            if (student.getEnrollCourses().get(courseIdIndexOfStudent).getEnrollStudent().get(j).getStudentID() == student.getStudentID()) {
                studentIndex = j;
                break;
            }
        }
        if (studentIndex < 0) {
            return false;
        }

        
        int creditsOfStudent = student.getCredits();
        student.setCredits(creditsOfStudent + student.getEnrollCourses().get(courseIdIndexOfStudent).getCredits().get(studentIndex));

        
        student.getEnrollCourses().get(courseIdIndexOfStudent).getEnrollStudent().remove(studentIndex);
        student.getEnrollCourses().get(courseIdIndexOfStudent).getCredits().remove(studentIndex);

        
        student.getEnrollCourses().remove(courseIdIndexOfStudent);

        return true;
    }


    
    public void finalizeEnrollments() {
        
        if (ifOpen) {
            ifOpen = false;
        } else {
            return;
        }

        if ((0 == students.size()) || (0 == courses.size())) {
            return;
        }

       
        ArrayList<StudentWithBidCreditsForSomeCourse> tempList = new ArrayList<>();
        for (int j = 0; j < courses.size(); j++) {
           
            for (int i = 0; i < courses.get(j).getEnrollStudent().size(); i++) {
                tempList.add(new StudentWithBidCreditsForSomeCourse(courses.get(j).getEnrollStudent().get(i), courses.get(j).getCredits().get(i)));
            }

            
            Collections.sort(tempList, new Comparator<StudentWithBidCreditsForSomeCourse>() {
                @Override
                public int compare(StudentWithBidCreditsForSomeCourse s1, StudentWithBidCreditsForSomeCourse s2) {
                    return Integer.compare(s2.theCredits, s1.theCredits); 
                }
            });

           
            if (courses.get(j).getEnrollStudent().size() > courses.get(j).getMaxCapacity()) {

               
                while (tempList.size() > (courses.get(j).getMaxCapacity() + 1)) {
                    tempList.remove(tempList.size() - 1);
                }

              
                int criticalCredit = tempList.get(tempList.size() - 1).theCredits;
               
                while (criticalCredit == tempList.get(tempList.size() - 1).theCredits) {
                    tempList.remove(tempList.size() - 1);
                }
                if (0 == tempList.size()) {
                    return;
                }
                if(tempList.size() > (courses.get(j).getMaxCapacity())){
                    tempList.remove(tempList.size() - 1);
                }
            }

           
            for (int k = 0; k < tempList.size(); k++) {
                
                courses.get(j).getSuccessStudents().add(tempList.get(k).theStudent);
                
                tempList.get(k).theStudent.getSuccessCourses().add(courses.get(j));
            }

           
            tempList.clear();
        }
    }


   
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        
        ArrayList<String> EnrolledCoursesWithCredits = new ArrayList<>();
        if (!ifOpen) {
            return null;
        }
        
        if ((0 == students.size()) || (0 == courses.size()) || (0 == student.getEnrollCourses().size())) {
            return EnrolledCoursesWithCredits;
        }

        int studentIndex = -1;
        for (int j = 0; j < student.getEnrollCourses().size(); j++) {

            for (int i = 0; i < student.getEnrollCourses().get(j).getEnrollStudent().size(); i++) {
                if (student.getEnrollCourses().get(j).getEnrollStudent().get(i).getStudentID() == student.getStudentID()) {
                    studentIndex = i;
                    break;
                }
            }
            if (studentIndex < 0) {
                return null;
            }

           
            EnrolledCoursesWithCredits.add(student.getEnrollCourses().get(j).getCourseID() + ": " + String.valueOf(student.getEnrollCourses().get(j).getCredits().get(studentIndex)));
        }

        return EnrolledCoursesWithCredits;
    }

}


class StudentWithBidCreditsForSomeCourse {
    Student theStudent;
    int theCredits;

    StudentWithBidCreditsForSomeCourse(Student aStudent, int aCredits) {
        this.theStudent = aStudent;
        this.theCredits = aCredits;
    }
}