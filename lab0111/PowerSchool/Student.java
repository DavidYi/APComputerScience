package lab0111.PowerSchool;

/**
 * Created by Sowmya on 2/10/2016.
 */
public class Student {
    /* When you declare the Student class, declare it as:
     *     public class Student implements Comparable<Student>{
     *  This is your promise to include the compareTo() method.
     */
    private String Name;
    public final int gradYear;
    private School Academy;
    private Course[] schedule; // Contains no more than ten courses.
    private int courseCounter;

    public Student(String name, int gradYear, School Academy) {
        Name = name;
        this.gradYear = gradYear;
        this.Academy = Academy;
        schedule = new Course[10];
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

    public Course[] getSchedule(){
        return schedule;
    }

    // Calculates GPA as average of classes
    public double getGPA() {
        double total = 0;
        for (int i = 0; i < courseCounter; i++) {
            total += schedule[i].getGrade(this).getGrade();
        }
        return total / courseCounter;
    }

    // Returns compareTo value for the GPAs of the two students
    public int compareTo(Student someOtherKid) {
        Double mine = this.getGPA();
        Double other = someOtherKid.getGPA();
        return mine.compareTo(other);
    }

    public boolean addCourse(Course someCourse) {
        if (courseCounter >= 10)
            return false;
        schedule[courseCounter - 1] = someCourse;
        courseCounter++;
        return true;
    }

    /* Removes course and returns true if successful.
    *  Returns false if: course was not on student’s schedule.
    */
    public boolean dropCourse(Course someCourse) {
        for (int i = 0; i < 10; i++) {
            if (schedule[i] == someCourse) {
                for (int j = i; j < 10; j++)
                    schedule[i] = schedule[i - 1];
                courseCounter--;
                return true;
            }
        }
        return false;
    }
}
