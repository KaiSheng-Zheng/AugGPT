import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CourseManager {
      private ArrayList<Course>courses;
      private ArrayList<Student>students;
      private boolean ifOpen;
      public CourseManager() {
            courses = new ArrayList<>();
            students = new ArrayList<>();
            ifOpen = true;
      }
    public ArrayList<Student>getStudents(){
            return students;
    }
      public ArrayList<Course>getCourses(){
            return courses;
      }

      public void setIfOpen(boolean ifOpen) {
            this.ifOpen = ifOpen;
      }
      public boolean getIfOpen(){
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
      public boolean enrollStudentInCourse(Student student,String courseId,int points){
       if (!this.ifOpen){
           return false;
       }
       if (points<=0) {
           return false;
       }
       if (student.getCredits()<points) {
           return false;
       }

          Course course=null;
          for (int i = 0; i <courses.size() ; i++) {
              if (courses.get(i).getCourseID().equals(courseId)){
                 course=courses.get(i);
              }
          }
          if (course==null){
              return false;
          }
         Course course1=null;
          for (int i = 0; i <student.getEnrollCourses().size() ; i++) {
              if (student.getEnrollCourses().get(i).equals(course)) {
                  course1 = course;
              }
          }
         if (course1!=null){
             return false;
         }
        course.getEnrollStudent().add(student);
        course.getCredits().add(points);
        student.setCredits(student.getCredits()-points);
        student.getEnrollCourses().add(course);
         return true;
       }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
       if (!ifOpen){
           return false;
       }
        Course course = null;
        for (int i = 0; i < courses.size() ; i++) {
            if (courses.get(i).getCourseID().equals(courseId)) {
                course = courses.get(i);
            }
        }
        if (course==null){
            return false;
        }
        Student student1=null;
        int number = 0;
        int n =0;
        for (int i = 0; i < course.getEnrollStudent().size(); i++) {
           if (course.getEnrollStudent().get(i).equals(student)){
              student1=student;
              n=i;
              number=course.getCredits().get(i);
           }
        }
        if (student1==null){
            return false;
        }
        if (student.getCredits()+number<credits){
            return false;
        }
        student.setCredits(student.getCredits()+number - credits);
        course.getCredits().set(n,credits);
        return true;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId){
          if (!ifOpen){
              return false;
          }
        Course course1 = null;
        for (int i = 0; i <courses.size() ; i++) {
            if (courses.get(i).getCourseID().equals(courseId)){
                course1=courses.get(i);
            }
        }
        if (course1==null) {
            return false;
        }
       Course course2=null;
        int number=0;
        for (int i = 0; i <student.getEnrollCourses().size() ; i++) {
            if (student.getEnrollCourses().get(i).equals(course1)){
                course2=course1;
                number=i;
            }
        }
        if (course2==null){
            return  false;
        }
        int num =0;
        for (int i = 0; i <course1.getEnrollStudent().size() ; i++) {
            if (course1.getEnrollStudent().get(i).equals(student)){
                num=i;
            }
        }
        student.setCredits(student.getCredits()+course1.getCredits().get(num));
        student.getEnrollCourses().remove(number);
        course1.getEnrollStudent().remove(num);
        course1.getCredits().remove(num);
        return true;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student){
    if (!ifOpen){
        return null;
    }
          ArrayList<String>List1= new ArrayList<>();
        for (int i = 0; i < student.getEnrollCourses().size(); i++) {
               Course course=student.getEnrollCourses().get(i);
            for (int j = 0; j < course.getEnrollStudent().size(); j++) {
                if (course.getEnrollStudent().get(j).equals(student)){
                    List1.add(course.getCourseID()+": "+course.getCredits().get(j));
                }
            }
        }
        return List1;
      }

    public void finalizeEnrollments() {

        for (int i = 0; i < courses.size(); i++) {
            ArrayList<Integer> List2=new ArrayList<>();
            int number = courses.get(i).getMaxCapacity();
            int num = 0;
            for (int j = 0; j <courses.get(i).getCredits().size() ; j++) {
                List2.add(courses.get(i).getCredits().get(j));
            }
            Collections.sort(courses.get(i).getCredits(), Collections.reverseOrder());
            if (courses.get(i).getCredits().isEmpty()) {
                continue;
            }

            if (number >= courses.get(i).getCredits().size()) {
                num = courses.get(i).getCredits().get(courses.get(i).getCredits().size() - 1);
            } else if (number < courses.get(i).getCredits().size()&& !Objects.equals(courses.get(i).getCredits().get(number), courses.get(i).getCredits().get(number-1))) {
                num = courses.get(i).getCredits().get(number - 1);
            } else if (number < courses.get(i).getCredits().size()&& Objects.equals(courses.get(i).getCredits().get(number), courses.get(i).getCredits().get(number-1))) {
                num=courses.get(i).getCredits().get(number - 1)+1;
            }
            for (int j = 0; j < List2.size(); j++) {
                if (List2.get(j)>=num){
                    courses.get(i).getSuccessStudents().add(courses.get(i).getEnrollStudent().get(j));
                    courses.get(i).getEnrollStudent().get(j).getSuccessCourses().add(courses.get(i));
                }
            }
        }
        ifOpen=false;
    }
}