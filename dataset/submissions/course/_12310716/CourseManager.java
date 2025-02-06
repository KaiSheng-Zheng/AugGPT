
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CourseManager {

    private Map<String, Student> studentMap = new HashMap<>();


    private Map<String, Course> courseMap = new HashMap<>();


    private boolean ifOpen;

    private Map<String, Map<String, Integer>> studentCreditIndex = new HashMap<>();
    private Map<Integer, String> creditStudentIndex = new HashMap<>();
    private Map<String, Integer> courseBaseCredit = new HashMap<>();

    private Map<String, String> successStudentCourse = new HashMap<>();

    //private AtomicInteger creditIndex = new AtomicInteger(0);

    public void setIfOpen(boolean b) {
        this.ifOpen = b;
    }

    public void addStudent(Student student) {
        student.setCourseManager(this);
        studentMap.put(student.getStudentID(), student);
    }

    public void addCourse(Course course) {
        course.setCourseManager(this);
        courseMap.put(course.getCourseID(), course);
    }

    public void finalizeEnrollments() {
        ifOpen = false;

        for (String key : studentCreditIndex.keySet()) {
            ArrayList<Student> successStudentList = new ArrayList<>();

            Map<String, Integer> studentCreditMap = studentCreditIndex.get(key);

            if (courseBaseCredit.get(key) == null) {
                continue;
            }
            int min = courseBaseCredit.get(key);

//            if(studentCreditMap.size() <= courseMap.get(key).getMaxCapacity()){
//                for(String k: studentCreditMap.keySet()){
//                    successStudentList.add(studentMap.get(studentCreditMap.get(k)));
//                }
//            }else{
//                Iterator<Map.Entry<String, Integer>> it = studentCreditMap.entrySet().iterator();
//                while (it.hasNext()){
//                    Map.Entry<String, Integer> s = it.next();
//                    if(s.getValue() < min){
//                        it.remove();
//                    }
//                }
//            }


            if (studentCreditMap.size() <= courseMap.get(key).getMaxCapacity()) {
                for (String k : studentCreditMap.keySet()) {
                    successStudentList.add(studentMap.get(k));
                }
            } else {

                List<Integer> creditlist = new ArrayList<>(studentCreditMap.values().stream().toList());
                creditlist.sort((c1, c2) -> {
                    return c1 - c2;
                });
                Iterator<Map.Entry<String, Integer>> it2 = studentCreditMap.entrySet().iterator();
                for (int c : creditlist) {
                    //it = studentCreditMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry<String, Integer> s = it2.next();
                        if (s.getValue() == c) {
                            it2.remove();
                        }
                    }

                    if (studentCreditMap.size() <= courseMap.get(key).getMaxCapacity()) {
                        for (String k : studentCreditMap.keySet()) {
                            successStudentList.add(studentMap.get(k));

                            studentMap.get(k).getSuccessCourses().add(courseMap.get(key));
                        }

                        break;
                    }

                }

            }

            courseMap.get(key).setSuccessStudents(successStudentList);

        }


    }

    public boolean getIfOpen() {
        return ifOpen;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        boolean result = false;


        Course cc1 = courseMap.get(courseId);


        Course cc2 = studentMap.get(student.getStudentID()).getEnrollCourses().stream().filter(c -> {
            return c.getCourseID().equals(courseId);
        }).findAny().orElse(null);


        if (ifOpen && credits > 0 && cc1 != null && cc2 != null) {


            int scrCredit = studentCreditIndex.get(courseId).get(student.getStudentID());
            //int srcCredits = cc1.getCredits().get(index);

            student.setCredits(student.getCredits() + scrCredit);


            if (student.getCredits() >= credits) {

                student.setCredits(student.getCredits() - credits);
                studentCreditIndex.get(courseId).put(student.getStudentID(), credits);
                //studentCreditIndex.put(courseId,)

                cc1.getCredits().set(cc1.getEnrollStudent().indexOf(student), credits);


                Map<String, Integer> studentCredisMap = studentCreditIndex.get(courseId);
                List<Integer> minList = new ArrayList<>(studentCredisMap.values().stream().toList());
                minList.sort((c1, c2) -> {
                    return c1 - c2;
                });
                courseBaseCredit.put(courseId, minList.get(0));

                result = true;
            }

        }

        return result;
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        boolean result = false;


        Course cc1 = courseMap.get(courseId);


        Course cc2 = null;
        if (studentMap.get(student.getStudentID()) != null) {
            cc2 = studentMap.get(student.getStudentID()).getEnrollCourses().stream().filter(c -> {
                return c.getCourseID().equals(courseId);
            }).findAny().orElse(null);
        }


        if (ifOpen && credits > 0 && cc1 != null && cc2 == null && student.getCredits() >= credits) {
            cc1.getEnrollStudent().add(student);
            int index = cc1.getCredits().size();

            if (studentCreditIndex.get(courseId) == null) {
                Map<String, Integer> map = new HashMap<>();
                map.put(student.getStudentID(), credits);
                studentCreditIndex.put(courseId, map);
            } else {
                studentCreditIndex.get(courseId).put(student.getStudentID(), credits);
            }

            //creditStudentIndex.put( index, student.getStudentID());
            cc1.getCredits().add(credits);


            int min = credits;
            for (int i = 0; i < cc1.getCredits().size() - 1; i++) {
                if (cc1.getCredits().get(i) > cc1.getCredits().get(i + 1)) {
                    min = cc1.getCredits().get(i + 1);
                    courseBaseCredit.put(cc1.getCourseID(), min);
                }
            }
            if (courseBaseCredit.size() == 0) {
                courseBaseCredit.put(cc1.getCourseID(), min);
            }


            //Collections.sort(cc1.getCredits());

            //student.getSuccessCourses().add(cc1);
            student.getEnrollCourses().add(cc1);
            student.setCredits(student.getCredits() - credits);

            result = true;

        }

        return result;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        Course c1 = courseMap.get(courseId);
        boolean ifEnroll = c1.getEnrollStudent().contains(student);

        if (ifOpen && c1 != null && ifEnroll) {

            c1.getEnrollStudent().remove(student);

            Map<String, Integer> map = studentCreditIndex.get(courseId);
            c1.getCredits().remove(map.get(student.getStudentID()));
            c1.getEnrollStudent().remove(student);

            //studentCreditIndex.remove(student.getStudentID());
            // creditStudentIndex.remove(index);

            student.getEnrollCourses().remove(c1);
            student.setCredits(student.getCredits() + (int) map.get(student.getStudentID()));
            map.remove(student.getStudentID());

            return true;
        }
        return false;
    }

    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();

        //student.getSuccessCourses();


        for (String key : courseMap.keySet()) {
//            courseMap.get(key).getSuccessStudents().contains(student)
//            String v = successStudentCourse.get(student.getStudentID().concat(courseMap.get(key).getCourseID()));
            if (courseMap.get(key).getEnrollStudent().contains(student)) {
                int credit = studentCreditIndex.get(key).get(student.getStudentID());
                result.add(courseMap.get(key).getCourseID().concat(": ").concat(String.valueOf(credit)));
            }
        }

        return result;
    }
}
