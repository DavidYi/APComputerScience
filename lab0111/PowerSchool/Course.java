package lab0111.PowerSchool;

/**
 * Created by David on 2/5/2016.
 */
public class Course {
    private String courseTitle;
    private String teacher;
    private Student[] enrolledStudents;
    private Grade[] grades;        // Must correspond 1-1 with enrolledStudents.
    private boolean honors;
    private int enrolled = 0;

    public Course(String teacher, String title, boolean honors) {
        this.teacher = teacher;
        courseTitle = title;
        this.honors = honors;
    }

    public int getEnrolled(){
        return enrolled;
    }

    public String getTitle() {
        return courseTitle;
    }

    public String getTeacher() {
        return teacher;
    }

    public Grade getGrade(Student someStudent) {
        for (int i = 0; i < enrolled; i++)
            if (someStudent.equals(enrolledStudents[i]))
                return grades[i];

        return grades[enrolled];
    }

    public int numberEnrolled() {
        return enrolled;
    }

    public Student[] enrolledStudents() {
        return enrolledStudents;
    }

    // returns the top student in this course. (Can arbitrarily choose between a tie)
    public Student topStudent() {
        int top = 0;
        for (int i = 1; i < enrolled; i++){
            if (grades[top].getGrade() < grades[i].getGrade())
                top = i;
        }
        return enrolledStudents[top];
    }

    public void setGrade(Student someStudent, double grade) {
        for (int i = 0; i < enrolledStudents.length; i++)
            if (someStudent.equals(enrolledStudents[i])) {
                grades[i].setGrade(grade);
                break;
            }
    }

    /* Enrolls Student and returns true if successful.
    *  Returns false if: course would give Student more than 10 classes, student is already
    *  enrolled, or if enrollment would cause more than 20 students to be in the course.
    */
    public boolean enroll(Student someStudent) {
        boolean success = someStudent.addCourse(this) && enrolled <= 20;
        if (success) {
            enrolledStudents[enrolled] = someStudent;
            enrolled++;
        }
        return success;
    }

    public void unenroll(Student someStudent) {
        boolean drop = someStudent.dropCourse(this);
        if (drop) {
            boolean change = false;
            for (int i = 0; i < enrolled; i++) {
                if (enrolledStudents[i].equals(someStudent))
                    change = true;
                if (change) {
                    enrolledStudents[i] = enrolledStudents[i + 1];
                }
            }

            enrolled--;
        }
    }
}
