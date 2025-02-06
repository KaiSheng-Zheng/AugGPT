import java.util.ArrayList;
import java.util.Collections;
public class CourseManager {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private boolean ifOpen;
    public CourseManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        setIfOpen(true);
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
    public void addStudent(Student student) {
        students.add(student);
        student.setCourseManager(this);
    }
    public void addCourse(Course course) {
        courses.add(course);
        course.setCourseManager(this);
    }
    ArrayList<String> CCS = new ArrayList<>();
    public boolean enrollStudentInCourse(Student student, String courseId, int credits) {
        int i0 = -1;
        boolean canEnroll = true;
        if (ifOpen) {
            if (!courses.isEmpty()) {
                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).getCourseID().equals(courseId)) {
                        i0 = i;
                        break;
                    }
                    else {
                        i0 += 0;
                    }
                }
                if (i0 < 0) {
                    canEnroll = false;
                }
            }
            else {
                canEnroll = false;
            }
            if (canEnroll) {
                if (!courses.get(i0).getEnrollStudent().isEmpty()) {
                    for (int j = 0; j < courses.get(i0).getEnrollStudent().size(); j++) {
                        if (courses.get(i0).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                            canEnroll = false;
                            break;
                        }
                    }
                }
                if ((credits > 0) && (student.getCredits() >= credits)) {
                    student.getEnrollCourses().add(courses.get(i0));
                    courses.get(i0).getEnrollStudent().add(student);
                    courses.get(i0).getCredits().add(credits);
                    String cString = String.valueOf(credits);
                    CCS.add(courseId + ", " + cString + ", " + student.getStudentID());
                    int c = student.getCredits();
                    c -= credits;
                    student.setCredits(c);
                }
                else {
                    canEnroll = false;
                }
            }
        }
        else {
            canEnroll = false;
        }
        return canEnroll;
    }
    public boolean modifyStudentEnrollmentCredits(Student student, String courseId, int credits) {
        int i0 = -1;
        boolean canModify = true;
        boolean studentExist = false;
        if (ifOpen) {
            if (!courses.isEmpty()) {
                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).getCourseID().equals(courseId)) {
                        i0 = i;
                        break;
                    }
                    else {
                        i0 += 0;
                    }
                }
                if (i0 < 0) {
                    canModify = false;
                }
            }
            else {
                canModify = false;
            }
            if (canModify) {
                if (!courses.get(i0).getEnrollStudent().isEmpty()) {
                    for (int j = 0; j < courses.get(i0).getEnrollStudent().size(); j++) {
                        if (courses.get(i0).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                            studentExist = true;
                            break;
                        }
                    }
                    if (!studentExist) {
                        canModify = false;
                    }
                }
                else {
                    canModify = false;
                }
                if (canModify && credits > 0) {
                    int c1 = student.getCredits();
                    for (int j=0; j<CCS.size(); j++) {
                        if (CCS.get(j).split(", ")[0].equals(courses.get(i0).getCourseID()) &&
                                CCS.get(j).split(", ")[2].equals(student.getStudentID())) {
                            c1 += Integer.parseInt(CCS.get(j).split(", ")[1]);
                            student.setCredits(c1);
                            CCS.remove(j);
                            break;
                        }
                    }
                    student.getEnrollCourses().remove(courses.get(i0));
                    courses.get(i0).getCredits().remove(courses.get(i0).getCredits().get(courses.get(i0).getEnrollStudent().indexOf(student)));
                    courses.get(i0).getEnrollStudent().remove(student);
                    if (student.getCredits() >= credits) {
                        student.getEnrollCourses().add(courses.get(i0));
                        courses.get(i0).getEnrollStudent().add(student);
                        courses.get(i0).getCredits().add(credits);
                        String cString = String.valueOf(credits);
                        CCS.add(courseId + ", " + cString + ", " + student.getStudentID());
                        int c2 = student.getCredits();
                        c2 -= credits;
                        student.setCredits(c2);
                    }
                    else {
                        canModify = false;
                    }
                }
                else {
                    canModify = false;
                }
            }
        }
        else {
            canModify = false;
        }
        return canModify;
    }
    public boolean dropStudentEnrollmentCourse(Student student, String courseId) {
        int i0 = -1;
        boolean canDrop = true;
        boolean studentExist = false;
        if (ifOpen) {
            if (!courses.isEmpty()) {
                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).getCourseID().equals(courseId)) {
                        i0 = i;
                        break;
                    } else {
                        i0 += 0;
                    }
                }
                if (i0 < 0) {
                    canDrop = false;
                }
            } else {
                canDrop = false;
            }
            if (canDrop) {
                if (!courses.get(i0).getEnrollStudent().isEmpty()) {
                    for (int j = 0; j < courses.get(i0).getEnrollStudent().size(); j++) {
                        if (courses.get(i0).getEnrollStudent().get(j).getStudentID().equals(student.getStudentID())) {
                            studentExist = true;
                            break;
                        }
                    }
                    if (!studentExist) {
                        canDrop = false;
                    }
                }
                else {
                    canDrop = false;
                }
                if (canDrop) {
                    int c = student.getCredits();
                    for (int j = 0; j < CCS.size(); j++) {
                        if (CCS.get(j).split(", ")[0].equals(courses.get(i0).getCourseID()) &&
                                CCS.get(j).split(", ")[2].equals(student.getStudentID())) {
                            c += Integer.parseInt(CCS.get(j).split(", ")[1]);
                            student.setCredits(c);
                            CCS.remove(j);
                            break;
                        }
                    }
                    student.getEnrollCourses().remove(courses.get(i0));
                    courses.get(i0).getCredits().remove(courses.get(i0).getCredits().get(courses.get(i0).getEnrollStudent().indexOf(student)));
                    courses.get(i0).getEnrollStudent().remove(student);
                }
            }
        }
        else {
            canDrop = false;
        }
        return canDrop;
    }
    public ArrayList<String> getEnrolledCoursesWithCredits(Student student) {
        if (ifOpen) {
            ArrayList<String> CC = new ArrayList<>();
            for (int i=0; i<CCS.size(); i++) {
                if (CCS.get(i).split(", ")[2].equals(student.getStudentID())) {
                    CC.add(CCS.get(i).split(", ")[0] + ": " + CCS.get(i).split(", ")[1]);
                }
            }
            return CC;
        }
        else {
            return null;
        }
    }
    public void finalizeEnrollments() {
        // the implementation is not that clear in the first glance BTW.

        int i0;
        int n = 0;
        setIfOpen(false);
        for (int i=0; i<courses.size(); i++) {
            i0 = i;
            boolean canFinalize = true;
            ArrayList<String> aCCS = new ArrayList<>();
            for (int j=0; j<CCS.size(); j++) {
                if (CCS.get(j).startsWith(courses.get(i0).getCourseID())) {
                    aCCS.add(CCS.get(j));
                }
            }
            ArrayList<String> aCCSSort3 = new ArrayList<>();
            for (int a=0; a<aCCS.size(); a++) {
                if (Integer.parseInt(aCCS.get(a).split(", ")[1]) >= 100) {
                    aCCSSort3.add(aCCS.get(a));
                }
            }
            Collections.sort(aCCSSort3);
            ArrayList<String> aCCSSort2 = new ArrayList<>();
            for (int b=0; b<aCCS.size(); b++) {
                if (Integer.parseInt(aCCS.get(b).split(", ")[1]) >= 10 && Integer.parseInt(aCCS.get(b).split(", ")[1]) < 100) {
                    aCCSSort2.add(aCCS.get(b));
                }
            }
            Collections.sort(aCCSSort2);
            ArrayList<String> aCCSSort1 = new ArrayList<>();
            for (int c=0; c<aCCS.size(); c++) {
                if (Integer.parseInt(aCCS.get(c).split(", ")[1]) > 0 && Integer.parseInt(aCCS.get(c).split(", ")[1]) < 10) {
                    aCCSSort1.add(aCCS.get(c));
                }
            }
            Collections.sort(aCCSSort1);
            if (aCCS.size() <= courses.get(i0).getMaxCapacity()) {
                for (int m=0; m<courses.get(i0).getEnrollStudent().size(); m++) {
                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(m));
                    courses.get(i0).getEnrollStudent().get(m).getSuccessCourses().add(courses.get(i0));
                }
            }
            else {
                if (aCCSSort3.size() > courses.get(i0).getMaxCapacity()) {
                    if (Integer.parseInt(aCCSSort3.get(aCCSSort3.size() - courses.get(i0).getMaxCapacity()).split(", ")[1])
                            > Integer.parseInt(aCCSSort3.get(aCCSSort3.size() - courses.get(i0).getMaxCapacity() - 1).split(", ")[1])) {
                        for (int a1 = aCCSSort3.size() - 1; a1 >= (aCCSSort3.size() - courses.get(i0).getMaxCapacity()); a1--) {
                            for (int a2 = 0; a2 < aCCS.size(); a2++) {
                                if (aCCS.get(a2).split(", ")[2].equals(aCCSSort3.get(a1).split(", ")[2])) {
                                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(a2));
                                    courses.get(i0).getEnrollStudent().get(a2).getSuccessCourses().add(courses.get(i0));
                                    break;
                                }
                            }
                        }
                        canFinalize = false;
                    }
                    else if (Integer.parseInt(aCCSSort3.get(aCCSSort3.size() - courses.get(i0).getMaxCapacity()).split(", ")[1])
                            == Integer.parseInt(aCCSSort3.get(aCCSSort3.size() - courses.get(i0).getMaxCapacity() - 1).split(", ")[1])) {
                        int a0 = 0;
                        for (int k = 1; k <= courses.get(i0).getMaxCapacity() - 1; k++) {
                            if (Integer.parseInt(aCCSSort3.get(aCCSSort3.size() - courses.get(i0).getMaxCapacity() + k).split(", ")[1])
                                    != Integer.parseInt(aCCSSort3.get(aCCSSort3.size() - courses.get(i0).getMaxCapacity()).split(", ")[1])) {
                                a0 = courses.get(i0).getMaxCapacity() - k;
                                break;
                            }
                        }
                        for (int a1 = aCCSSort3.size() - 1; a1 >= aCCSSort3.size() - a0; a1--) {
                            for (int a2 = 0; a2 < aCCS.size(); a2++) {
                                if (aCCS.get(a2).split(", ")[2].equals(aCCSSort3.get(a1).split(", ")[2])) {
                                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(a2));
                                    courses.get(i0).getEnrollStudent().get(a2).getSuccessCourses().add(courses.get(i0));
                                    break;
                                }
                            }
                        }
                        canFinalize = false;
                    }
                }
                else {
                    if (!aCCSSort3.isEmpty()) {
                        for (int a1 = aCCSSort3.size() - 1; a1 >= 0; a1--) {
                            for (int a2 = 0; a2 < aCCS.size(); a2++) {
                                if (aCCS.get(a2).split(", ")[2].equals(aCCSSort3.get(a1).split(", ")[2])) {
                                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(a2));
                                    courses.get(i0).getEnrollStudent().get(a2).getSuccessCourses().add(courses.get(i0));
                                    break;
                                }
                            }
                        }
                    }
                    n += aCCSSort3.size();
                }
                if (canFinalize && aCCSSort2.size() > courses.get(i0).getMaxCapacity() - n) {
                    if (Integer.parseInt(aCCSSort2.get(aCCSSort2.size() - courses.get(i0).getMaxCapacity() + n).split(", ")[1])
                            > Integer.parseInt(aCCSSort2.get(aCCSSort2.size() - courses.get(i0).getMaxCapacity() + n - 1).split(", ")[1])) {
                        for (int b1 = aCCSSort2.size() - 1; b1 >= (aCCSSort2.size() - courses.get(i0).getMaxCapacity() + n); b1--) {
                            for (int b2 = 0; b2 < aCCS.size(); b2++) {
                                if (aCCS.get(b2).split(", ")[2].equals(aCCSSort2.get(b1).split(", ")[2])) {
                                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(b2));
                                    courses.get(i0).getEnrollStudent().get(b2).getSuccessCourses().add(courses.get(i0));
                                    break;
                                }
                            }
                        }
                        canFinalize = false;
                    }
                    else if (Integer.parseInt(aCCSSort2.get(aCCSSort2.size() - courses.get(i0).getMaxCapacity() + n).split(", ")[1])
                            == Integer.parseInt(aCCSSort2.get(aCCSSort2.size() - courses.get(i0).getMaxCapacity() + n - 1).split(", ")[1])) {
                        int b0 = 0;
                        for (int k = 1; k <= courses.get(i0).getMaxCapacity() - n - 1; k++) {
                            if (Integer.parseInt(aCCSSort2.get(aCCSSort2.size() - courses.get(i0).getMaxCapacity() + n + k).split(", ")[1])
                                    != Integer.parseInt(aCCSSort2.get(aCCSSort2.size() - courses.get(i0).getMaxCapacity() + n).split(", ")[1])) {
                                b0 = courses.get(i0).getMaxCapacity() - n - k;
                                break;
                            }
                        }
                        for (int b1 = aCCSSort2.size() - 1; b1 >= aCCSSort2.size() - b0; b1--) {
                            for (int b2 = 0; b2 < aCCS.size(); b2++) {
                                if (aCCS.get(b2).split(", ")[2].equals(aCCSSort2.get(b1).split(", ")[2])) {
                                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(b2));
                                    courses.get(i0).getEnrollStudent().get(b2).getSuccessCourses().add(courses.get(i0));
                                    break;
                                }
                            }
                        }
                        canFinalize = false;
                    }
                }
                else if (canFinalize && aCCSSort2.size() <= courses.get(i0).getMaxCapacity() - n){
                    if (!aCCSSort2.isEmpty()) {
                        for (int b1 = aCCSSort2.size() - 1; b1 >= 0; b1--) {
                            for (int b2 = 0; b2 < aCCS.size(); b2++) {
                                if (aCCS.get(b2).split(", ")[2].equals(aCCSSort2.get(b1).split(", ")[2])) {
                                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(b2));
                                    courses.get(i0).getEnrollStudent().get(b2).getSuccessCourses().add(courses.get(i0));
                                    break;
                                }
                            }
                        }
                    }
                    n += aCCSSort2.size();
                }
                // bug: potential IndexOutOfBound exception
                // For example, assume aCCSSort2.size(), aCCSSort1.size() and courses.get(i0).getMaxCapacity() equal 1,
                // n will be incremented to 1 through the above statement "n += aCCSSort2.size();",
                // because 1 <= 1 - 1.

                // Then here will raise IndexOutOfBound exception, since 1 > 1 - 1, while aCCSSort1.get(1-1+1) will cause an error.
                if (canFinalize && aCCSSort1.size() > courses.get(i0).getMaxCapacity() - n) {
                    if (Integer.parseInt(aCCSSort1.get(aCCSSort1.size() - courses.get(i0).getMaxCapacity() + n).split(", ")[1])
                            > Integer.parseInt(aCCSSort1.get(aCCSSort1.size() - courses.get(i0).getMaxCapacity() + n - 1).split(", ")[1])) {
                        for (int c1 = aCCSSort1.size() - 1; c1 >= (aCCSSort1.size() - courses.get(i0).getMaxCapacity() + n); c1--) {
                            for (int c2 = 0; c2 < aCCS.size(); c2++) {
                                if (aCCS.get(c2).split(", ")[2].equals(aCCSSort1.get(c1).split(", ")[2])) {
                                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(c2));
                                    courses.get(i0).getEnrollStudent().get(c2).getSuccessCourses().add(courses.get(i0));
                                    break;
                                }
                            }
                        }
                    }
                    else if (Integer.parseInt(aCCSSort1.get(aCCSSort1.size() - courses.get(i0).getMaxCapacity() + n).split(", ")[1])
                            == Integer.parseInt(aCCSSort1.get(aCCSSort1.size() - courses.get(i0).getMaxCapacity() + n - 1).split(", ")[1])) {
                        int c0 = 0;
                        for (int k = 1; k <= courses.get(i0).getMaxCapacity() - n - 1; k++) {
                            if (Integer.parseInt(aCCSSort1.get(aCCSSort1.size() - courses.get(i0).getMaxCapacity() + n + k).split(", ")[1])
                                    != Integer.parseInt(aCCSSort1.get(aCCSSort1.size() - courses.get(i0).getMaxCapacity() + n).split(", ")[1])) {
                                c0 = courses.get(i0).getMaxCapacity() - n - k;
                                break;
                            }
                        }
                        for (int c1 = aCCSSort1.size() - 1; c1 >= aCCSSort1.size() - c0; c1--) {
                            for (int c2 = 0; c2 < aCCS.size(); c2++) {
                                if (aCCS.get(c2).split(", ")[2].equals(aCCSSort1.get(c1).split(", ")[2])) {
                                    courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(c2));
                                    courses.get(i0).getEnrollStudent().get(c2).getSuccessCourses().add(courses.get(i0));
                                    break;
                                }
                            }
                        }
                    }
                }
                else if (canFinalize && aCCSSort1.size() <= courses.get(i0).getMaxCapacity() - n) {
                    for (int c1 = aCCSSort1.size() - 1; c1 >= 0; c1--) {
                        for (int c2 = 0; c2 < aCCS.size(); c2++) {
                            if (aCCS.get(c2).split(", ")[2].equals(aCCSSort1.get(c1).split(", ")[2])) {
                                courses.get(i0).getSuccessStudents().add(courses.get(i0).getEnrollStudent().get(c2));
                                courses.get(i0).getEnrollStudent().get(c2).getSuccessCourses().add(courses.get(i0));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}