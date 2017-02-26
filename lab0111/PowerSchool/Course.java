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
        enrolledStudents = new Student[10];
        grades = new Grade[10];
    }

    public boolean isHonors() {
        return honors;
    }

    public int getEnrolled() {
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
            if (enrolledStudents[i].equals(null))
                return grades[i];

        return grades[0];
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
        for (int i = 1; i < enrolled; i++) {
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
        if (someStudent.getCourseNumber() < 10 && enrolled < 20) {
            for (int i = 0; i < someStudent.getCourseNumber(); i++)
                if (someStudent.getSchedule()[i].equals(this))
                    return false;
        }
        grades[enrolled] = new Grade(honors, false);
        enrolledStudents[enrolled++] = someStudent;
        return true;
    }

    public void unenroll(Student someStudent) {
        if (someStudent.dropCourse(this)) {
            boolean change = false;
            for (int i = 0; i < enrolled; i++) {
                Student tempS = enrolledStudents[i];
                if (someStudent == tempS)
                    change = true;
                if (change) {
                    grades[i] = grades[i + 1];
                    enrolledStudents[i] = enrolledStudents[i + 1];
                }
            }
            enrolled--;
            grades[enrolled] = null;
            enrolledStudents[enrolled] = null;
        }
    }

    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }
}