import java.util.*;

public class CourseManager {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private boolean ifOpen;

    public CourseManager() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.ifOpen = true;
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

    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }

    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        if (!ifOpen) return false;

        Course course = findCourseById(courseId);
        if (course == null || studentAlreadyEnrolled(student, course) || credits <= 0) return false;

        if (!hasEnoughCredits(student, credits)) return false;

        course.getEnrollStudent().add(student);
        course.getCredits().add(credits);
        student.getEnrollCourses().add(course);
        student.setCredits(student.getCredits() - credits);
        return true;
    }

    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        if (!ifOpen) return false;

        Course course = findCourseById(courseId);
        if (course == null || !studentAlreadyEnrolled(student, course) || credits < 0) return false;

        int index = course.getEnrollStudent().indexOf(student);
        int previousCredits = course.getCredits().get(index);
        int availableCredits = student.getCredits() + previousCredits;

        if (credits > availableCredits) return false;

        student.setCredits(availableCredits - credits);
        course.getCredits().set(index, credits);
        return true;
    }

    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        if (!ifOpen) return false;

        Course course = findCourseById(courseId);
        if (course == null || !studentAlreadyEnrolled(student, course)) return false;

        int index = course.getEnrollStudent().indexOf(student);
        int creditsToRefund = course.getCredits().get(index);

        student.setCredits(student.getCredits() + creditsToRefund);
        course.getEnrollStudent().remove(index);
        course.getCredits().remove(index);
        student.getEnrollCourses().remove(course);
        return true;
    }

    public void finalizeEnrollments() {
        ifOpen = false;
        //tong sort
        for (Course course : courses) {
            Map<Integer, List<Integer>> score_student = new HashMap<>();
            ArrayList<Student> enrollStudent = course.getEnrollStudent();
            ArrayList<Integer> credits = course.getCredits();
            for (int i = 0; i < credits.size(); ++i) {
                if (score_student.get(credits.get(i)) == null) {
                    LinkedList<Integer> student = new LinkedList<>();
                    student.add(i);
                    score_student.put(credits.get(i), student);
                } else {
                    List<Integer> student = score_student.get(credits.get(i));
                    student.add(i);
                    score_student.put(credits.get(i), student);
                }
            }

            // Convert the key-value pair of Map to a list
            List<Map.Entry<Integer, List<Integer>>> entryList = new ArrayList<>(score_student.entrySet());

            // Sort by the value of key from largest to smallest
            Collections.sort(entryList, new Comparator<Map.Entry<Integer, List<Integer>>>() {
                @Override
                public int compare(Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
                    return o2.getKey().compareTo(o1.getKey());
                }
            });

            // Build sorted Map
            Map<Integer, List<Integer>> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : entryList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            //Deal with the scores and records of the course.

            int capacity = course.getMaxCapacity();

            for (Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
//                System.out.println(entry.getKey() + ": " + entry.getValue());
                if (capacity >= entry.getValue().size()) {
                    capacity -= entry.getValue().size();
                    for (Integer i : entry.getValue()) {
                        enrollStudent.get(i).getSuccessCourses().add(course);
                        course.getSuccessStudents().add(enrollStudent.get(i));
                    }
                } else {
                    break;
                }

            }


        }
    }


    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (!ifOpen) return null;

        ArrayList<String> enrolledCourses = new ArrayList<>();
        for (Course course : student.getEnrollCourses()) {
            int index = course.getEnrollStudent().indexOf(student);
            int credits = course.getCredits().get(index);
            enrolledCourses.add(course.getCourseID() + ": " + credits);
        }
        return enrolledCourses;
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private boolean studentAlreadyEnrolled(Student student, Course course) {
        return course.getEnrollStudent().contains(student);
    }

    private boolean hasEnoughCredits(Student student, int credits) {
        return student.getCredits() >= credits;
    }
}