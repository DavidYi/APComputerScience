package lab0111.PowerSchool;

import java.util.Arrays;

/**
 * Created by David on 2/5/2016.
 */
public class School {
    String name;
    Student[] enrolledStudents;    // Maximum of 300 Students per school
    Course[] schoolCourses;        // Maximum of 300 Courses per school
    private int enrolledS = 0, enrolledC = 0;

    public School(String name) {
        this.name = name;
        enrolledStudents = new Student[300];
        Course[] schoolCourses = new Course[300];
    }

    // Returns name of school
    public String getName() {
        return name;
    }

    // Returns number of enrolled students
    public int enrolledStudents() {
        return enrolledS;
    }

    /* Returns the array of courses.  (* I am allowing a shallow copy here, though a deep
    * would be better.  Why is this?
    */
    public Course[] getCourses() {
        return schoolCourses;
    }

    /* returns Student with specified class rank. Since you have implemented compareTo,
    *  you can use Arrays.sort to sort enrolledStudents.
     */
    public Student kidWithClassRank(int rank) {
        Arrays.sort(enrolledStudents);

        return enrolledStudents[0];
    }

    /* Adds a student to the school.  Returns false if the school is already full or if
    *  Student is already enrolled at that school.
     */
    public boolean addStudent(Student someKid) {
        boolean success = (!someKid.getAcademy().equals(this)) && (enrolledS < enrolledStudents.length);
        if (success)
            enrolledS++;
        return success;
    }

    /* Removes a student to the school.  Also removes them from all of their courses.
     */
    public void unenrollStudent(Student someKid) {
        Course[] schedule = someKid.getSchedule();
        for (int i = 0; i < someKid.getCourseNumber(); i++)
            someKid.dropCourse(schedule[i]);

        for (int i = 0; i < enrolledS; i++)
            if (someKid.equals(enrolledStudents[i]))
                enrolledStudents[i] = enrolledStudents[i + 1];
    }

    /* Creates a class.  Returns false if a class with exactly the same specifications
    *  have already been made.
     */
    public boolean createClass(String teacher, String title, boolean honors) {
        Course c = new Course(teacher, title, honors);

        for (int i = 0; i < enrolledC; i++)
            if (c.equals(schoolCourses[i]) || enrolledC < schoolCourses.length)
                return false;

        schoolCourses[enrolledC] = c;
        enrolledC++;
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* Enrolls Student in Course and returns true if successful.
    *  Returns false if: Course not in school, Course would have more than 20 students, or
    *  Student would have more than 10 Courses.
     */
    public boolean enroll(Student kid, Course someCourse) {
        return someCourse.enroll(kid);
    }

    /* Unenrolls Student in Course and returns true if successful.
    *  Returns false if: Course not in school, or Student not in Course.
     */
    public boolean unenroll(Student kid, Course someCourse) {
        boolean success = false;
        for (int i = 0; i < enrolledC; i++)
            if (someCourse.equals(schoolCourses[i])) {
                success = true;
                break;
            }

        if (success) {
            for (int i = 0; i < someCourse.getEnrolled(); i++)
                if (!kid.equals(someCourse.enrolledStudents()[i]))
                    success = false;

            someCourse.unenroll(kid);
        }

        return success;
    }
}
