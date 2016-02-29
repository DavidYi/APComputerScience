package lab0111.PowerSchool;

/**
 * Created by Sowmya on 2/10/2016.
 */
public class Grade {
    /* Grades must be between 0.0 and 100.0 (inclusive) */
    private double grade;

    /*
    * Audited classes are not counted in a Student’s GPA or class rank. A
    * Student may audit a class even if other Students in the same class are
    * not auditing.
    */
    private boolean audit;
    /* Honors classes have a 5% boost to the grade. */
    private boolean honors;

    public Grade(boolean honors, boolean audited) {
        this.honors = honors;
        this.audit = audited;
    }

    /*
    * If the grade provided is out of range, the closest in-range grade is entered
    */
    public Grade(boolean honors, boolean audited, double grade) {
        this.honors = honors;
        this.audit = audited;
        if (grade < 0.0) this.grade = 0.0;
        else if (grade > 100.0) this.grade = 100.0;
        else this.grade = grade;
    }

    /*
    * Returns the grade. If this is an honors grade, the reported grade is
    * raised by 5% (max * 105.0)
    */
    public double getGrade() {
        if (honors) {
            return (grade + (grade * 0.05));
        }
        return grade;
    }

    public boolean honors() {
        return honors;
    }

    public boolean audited() {
        return audit;
    }

    /*
    * Sets the Grade to a number between 0.0 and 100.0, inclusive. If the grade
    * provided is out of range, the closest in-range grade is entered.
    */

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setAudit(boolean audit) {
        this.audit = audit;
    }

}
