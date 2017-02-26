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
        schoolCourses = new Course[300];
    }

    private void sort() {
        Student[] temp = new Student[enrolledS];
        for (int i = 0; i < enrolledS; i++)
            temp[i] = enrolledStudents[i];
        Arrays.sort(temp);//we do this since sort only works when the array doesn't have any null
        for (int i = 0; i < enrolledS; i++)
            enrolledStudents[i] = temp[i];
    }

    // Returns teamName of school
    public String getName() {
        return name;
    }

    // Returns number of enrolled students
    public int enrolledStudents() {
        return enrolledS;
    }

    public int enrolledCourses() {
        return enrolledC;
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
        return enrolledStudents[rank - 1];
    }

    /* Adds a student to the school.  Returns false if the school is already full or if
    *  Student is already enrolled at that school.
     */
    public boolean addStudent(Student someKid) {
        if (!this.equals(someKid.getAcademy()) && (enrolledS < enrolledStudents.length)) {
            enrolledStudents[enrolledS++] = someKid;
            someKid.setAcademy(this);
            sort();
            return true;
        }
        return false;
    }

    /* Removes a student to the school.  Also removes them from all of their courses.
     */
    public void unenrollStudent(Student someKid) {
        Course[] schedule = someKid.getSchedule();
        for (int i = 0; i < someKid.getCourseNumber(); i++)
            someKid.dropCourse(schedule[i]);

        int place = 0;
        for (int i = 0; i < enrolledS; i++)
            if (someKid.equals(enrolledStudents[i])) {
                place = i;
                break;
            }
        for (int j = place; j < enrolledS; j++)
            enrolledStudents[j] = enrolledStudents[j + 1];
        enrolledS--;
        enrolledStudents[enrolledS] = null;
        sort();
    }

    /* Creates a class.  Returns false if a class with exactly the same specifications
    *  have already been made.
     */
    public boolean createClass(String teacher, String title, boolean honors) {
        for (int i = 0; i < enrolledC; i++) {
            if (schoolCourses[i].getTeacher().equals(teacher))
                if (schoolCourses[i].getTitle().equals(title) && schoolCourses[i].isHonors() == (honors))
                    return false;//checks if there is already a class with the same specification
            if (enrolledC >= schoolCourses.length)
                return false;
        }

        schoolCourses[enrolledC++] = new Course(teacher, title, honors);
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
        if (kid.getCourseNumber() >= 10 || someCourse.getEnrolled() >= 20)
            return false;
        Course tempC;
        int place = 0;
        boolean succeed = false;
        for (int i = 0; i < enrolledC; i++) {
            tempC = schoolCourses[i];
            if (tempC == someCourse) {
                succeed = true;
                place = i;
            }
        }
        if (!succeed)
            return false; //if there is no corresponding course in the array
        if (!schoolCourses[place].enroll(kid))
            return false;//if the course is unable to enroll then it is unsuccessful
        //if it succeeds then sort the list
        sort();
        return true;
    }

    /* Unenrolls Student in Course and returns true if successful.
    *  Returns false if: Course not in school, or Student not in Course.
     */
    public boolean unenroll(Student kid, Course someCourse) {
        boolean success = false;
        Course tempC;
        int place = 0;
        for (int i = 0; i < enrolledC; i++) {
            tempC = schoolCourses[i];
            if (tempC == someCourse) {
                success = true;
                place = i;
                break;
            }
        }

        if (!success)
            return false;//if there is no course in the array that is equal to the course

        Student[] classStudents = schoolCourses[place].enrolledStudents();
        for (int i = 0; i < schoolCourses[place].getEnrolled(); i++) {
            Student tempS = classStudents[i];
            if (kid == tempS) {
                schoolCourses[place].unenroll(kid);
                sort();
                return true;
            }
        }
        return false;

    }
}
