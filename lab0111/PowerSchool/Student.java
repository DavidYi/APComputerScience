package lab0111.PowerSchool;

/**
 * Created by Sowmya on 2/10/2016.
 */
public class Student implements Comparable<Student>{
    /* When you declare the Student class, declare it as:
     *     public class Student implements Comparable<Student>{
     *  This is your promise to include the compareTo() method.
     */
    private String Name;
    public final int gradYear;
    private School Academy;
    private Course[] schedule; // Contains no more than ten courses.
    private int courseCounter;

    public Student(String name, int gradYear) {
        Name = name;
        this.gradYear = gradYear;
        Academy = null;
        schedule = new Course[10];
        courseCounter = 0;
    }

    public String getName() {
        return Name;
    }

    public int getGradYear() {
        return gradYear;
    }

    public int getCourseNumber(){
        return courseCounter;
    }

    public School getAcademy() {
        return Academy;
    }

    public void setAcademy(School academy) {
        Academy = academy;
    }

    public Course[] getSchedule(){
        return schedule;
    }

    // Calculates GPA as average of classes
    public double getGPA() {
        double total = 0;
        int audit = 0;
        Grade temp;
        for (int i = 0; i < courseCounter; i++) {
            temp = schedule[i].getGrade(this);
            if (temp.audited())
                audit++;
            else
                total += temp.getGrade();
        }
        return total / (courseCounter - audit);
    }

    // Returns compareTo value for the GPAs of the two students
    public int compareTo(Student someOtherKid) {
        Double mine = this.getGPA();
        Double other = someOtherKid.getGPA();
        return Double.compare(mine, other);
    }

    public boolean addCourse(Course someCourse) {
        if (courseCounter >= 10)
            return false;
        boolean work = someCourse.enroll(this);
        if (work == false)
            return false;

        schedule[courseCounter] = someCourse;
        courseCounter++;
        return true;
    }

    /* Removes course and returns true if successful.
    *  Returns false if: course was not on student’s schedule.
    */
    public boolean dropCourse(Course someCourse) {
        for (int i = 0; i < courseCounter; i++) {
            Course tempC = schedule[i];
            if (tempC == someCourse) {
                schedule[i] = null;
                courseCounter--;
                return true;
            }
        }
        return false;
    }
}