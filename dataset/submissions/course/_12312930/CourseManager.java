import java.util.ArrayList;
   public class CourseManager {
        private ArrayList<Student> students;
        private ArrayList<Course> courses;
        private boolean ifOpen;



       public void setCourses(ArrayList<Course> courses) {
           this.courses = courses;
       }

       public void setStudents(ArrayList<Student> students) {
           this.students = students;
       }

       public CourseManager() {
            setIfOpen(true);
           students=new ArrayList<>();
           courses=new ArrayList<>();
        }

        public boolean getIfOpen() {
            return ifOpen;
        }

        public void setIfOpen(boolean ifOpen) {
            this.ifOpen = ifOpen;
        }

        public ArrayList<Course> getCourses() {
            return courses;
        }


        public ArrayList<Student> getStudents() {
            return students;
        }

        public void addCourse(Course course) {
            if(this.courses!=null){
           getCourses().add(course);
           setCourses(getCourses());
            course.setCourseManager(this);}
        }

        public void addStudent(Student student) {
            if(this.students!=null){
            this.students.add(student);
            setStudents(getStudents());
            student.setCourseManager(this);}
        }

        public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
            if (credits > 0 && getIfOpen()) {
                for (Course cours : courses) {
                    if (cours.getCourseID().equals(courseId)
                            && student.getCredits() >= credits) {
                        if (!cours.getEnrollStudent().contains(student)) {
                            student.setCredits(student.getCredits() - credits);
                            cours.getCredits().add(credits);
                            cours.setCredits(cours.getCredits());
                            cours.getEnrollStudent().add(student);
                            cours.setEnrollStudent(cours.getEnrollStudent());
                            student.getEnrollCourses().add(cours);
                            student.setEnrollCourses(student.getEnrollCourses());
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
            if (getIfOpen()&&credits>0) {
                for (Course cours : courses) {
                    if (cours.getCourseID().equals(courseId)) {
                        for (int j = 0; j < cours.getCredits().size(); j++) {
                            if (cours.getEnrollStudent().get(j) == student&& (student.getCredits()+ cours.getCredits().get(j)) >= credits) {
                                student.setCredits(student.getCredits() + cours.getCredits().get(j) - credits);
                                cours.getCredits().set(j,credits);
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }




        public boolean dropStudentEnrollmentCourse(Student s, String courseId) {
            if (getIfOpen()) {
                for (Course cours : courses) {
                    if (cours.getCourseID().equals(courseId)
                            && cours.getEnrollStudent().contains(s)) {
                        for (int j = 0; j < cours.getCredits().size(); j++) {
                            if (cours.getEnrollStudent().get(j) == s) {
                                for (int t = 0; t < s.getEnrollCourses().size(); t++) {
                                    if (s.getEnrollCourses().get(t) == cours) {
                                        s.setCredits(s.getCredits() + cours.getCredits().get(j));
                                        s.getEnrollCourses().remove(t);
                                        t--;
                                        cours.getCredits().remove(j);
                                        cours.getEnrollStudent().remove(cours.getEnrollStudent().get(j));

                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
                }
            return false;
            }



        public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
            if (!getIfOpen()) {
                return null;
            }
            ArrayList<String> c = new ArrayList<>();
            for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                for (int j = 0; j < student.getEnrollCourses().get(i).getEnrollStudent().size(); j++) {
                    if (student.getEnrollCourses().get(i).getEnrollStudent().get(j) == student) {
                        c.add(student.getEnrollCourses().get(i).getCourseID()+ ": " +student.getEnrollCourses().get(i).getCredits().get(j));
                    }
                }
            }

            return c;
        }

       public int min1(ArrayList<Integer> arr) {
           int minValue = 999999999;
           for (Integer integer : arr) {
               if (minValue > integer) {
                   minValue = integer;
               }
           }
           return minValue;
       }

        public void finalizeEnrollments() {
            setIfOpen(false);
            for (Course cours : courses) {
                while (cours.getEnrollStudent().size() > cours.getMaxCapacity()) {
                    int b=min1(cours.getCredits());
                    for (int j = 0; j < cours.getEnrollStudent().size(); j++) {
                        if (b == cours.getCredits().get(j)) {
                            for (int t = 0; t < cours.getEnrollStudent().get(j).getEnrollCourses().size(); t++) {
                                if (cours.getEnrollStudent().get(j).getEnrollCourses().get(t) == cours) {
                                    cours.getEnrollStudent().get(j).getEnrollCourses().remove(t);
                                    cours.getEnrollStudent().get(j).setCredits(cours.getEnrollStudent().get(j).getCredits() + cours.getCredits().get(j));
                                    cours.getEnrollStudent().remove(j);
                                    cours.getCredits().remove(j);
                                    j--;
                                    break;
                                }
                            }



                        }
                    }
                }
            }




            for (Course course : courses) {
                for (int i = 0; i < course.getEnrollStudent().size(); i++) {
                    course.getSuccessStudents().add(course.getEnrollStudent().get(i));
                }
            }
            for (Student student : students) {
                for (int i = 0; i < student.getEnrollCourses().size(); i++) {
                    student.getSuccessCourses().add(student.getEnrollCourses().get(i));
                    student.setSuccessCourses(student.getSuccessCourses());
                }
            }

        }

    }

