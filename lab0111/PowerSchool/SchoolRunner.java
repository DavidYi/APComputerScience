package lab0111.PowerSchool;

/**
 * Created by David on 3/3/2016.
 */
public class SchoolRunner {
    public static void main(String[] args) {
        //for Grade
        Grade regGrade = new Grade(false, false, 90);
        Grade honor = new Grade(true, false, 100);
        Grade errorGrade = new Grade(false, false, 110);
        Grade errorHonor = new Grade(true, false, 110);

        if (regGrade.getGrade() == 90 && honor.getGrade() == 100 * 1.05)
            System.out.println("Get grade for Grade is correct");
        else
            System.out.println("GET GRADE FOR GRADE IS INCORRECT");
        if (!regGrade.honors())
            System.out.println("Honors for Grade is correct");
        else
            System.out.println("HONORS FOR GRADE IS INCORRECT");
        if (!regGrade.audited())
            System.out.println("Audited for Grade is correct");
        else
            System.out.println("AUDITED FOR GRADE IS INCORRECT");
        if (errorGrade.getGrade() == 100) {
            System.out.println("Get grade for Grade is correct even out of 100.");
        } else {
            System.out.println("GET GRADE FOR GRADE IS INCORRECT WHEN INPUT OVER 100");
        }
        if (errorHonor.getGrade() == 105) {
            System.out.println("Get grade for Grade is correct even out of 105-honors");
        } else {
            System.out.println("GET GRADE FOR GRADE IS INCORRECT WHEN INPUT OVER 105");
        }
        regGrade.setGrade(80);

        if (regGrade.getGrade() == 80)
            System.out.println("Set grade for Grade is correct");
        else
            System.out.println("SET GRADE FOR GRADE IS INCORRECT");

        regGrade.setAudit(true);

        if (regGrade.audited())
            System.out.println("Set audited for Grade is correct");
        else
            System.out.println("SET AUDITED FOR GRADE IS INCORRECT");

        //for school
        School bca = new School("BCA");
        if (bca.getName().equals("BCA"))
            System.out.println("Get name for School is correct");
        else
            System.out.println("GET NAME FOR SCHOOL IS INCORRECT");
        bca.setName("Bergen County Academies");
        if (bca.getName().equals("Bergen County Academies"))
            System.out.println("Set name for School is correct");
        else
            System.out.println("SET NAME FOR SCHOOL IS INCORRECT");
        if (bca.createClass("Respass", "DataStructs", false) && !bca.createClass("Respass", "DataStructs", false))
            System.out.println("Create class for School is correct");
        else
            System.out.println("CREATE CLASS FOR SCHOOL IS INCORRECT");

        //for course
        Course comsci = new Course("Isecke", "AP Com Sci", false);
        if (comsci.getTitle().equals("AP Com Sci"))
            System.out.println("Get title for Course is correct");
        else
            System.out.println("GET TITLE FOR COURSE IS INCORRECT");
        if (!comsci.isHonors())
            System.out.println("Is honors for Course is correct");
        else
            System.out.println("IS HONORS FOR COURSE IS INCORRECT");
        if (comsci.getTeacher().equals("Isecke"))
            System.out.println("Get teacher for Course is correct");
        else
            System.out.println("GET TEACHER FOR COURSE IS INCORRECT");

        // Test Student.java
        Student chris = new Student("Chris", 2018);
        chris.setAcademy(bca);
        Student bob = new Student("Bob", 2018);
        Student joe = new Student("Joe", 2019);
        Student nonBCA = new Student("notInBCA", 2019);

        if (chris.getAcademy().equals(bca))
            System.out.println("Get academy for Student is correct");
        else
            System.out.println("GET ACADEMY FOR SCHOOL IS INCORRECT");
        if (chris.getName().equals("Chris"))
            System.out.println("Get name for Student is correct");
        else
            System.out.println("GET NAME FOR STUDENT IS INCORRECT");
        if (chris.getGradYear() == 2018)
            System.out.println("Get gradyear for Student is correct");
        else
            System.out.println("GET GRADYEAR FOR STUDENT IS INCORRECT");
        if (chris.addCourse(comsci))
            System.out.println("Add course for Student is correct");//tests enroll for course
        else
            System.out.println("ADD COURSE FOR STUDENT IS INCORRECT");

        //more test for school
        bca.addStudent(joe);
        if (bca.addStudent(bob) && !bca.addStudent(bob))
            System.out.println("Add student for School is correct");
        else
            System.out.println("ADD STUDENT FOR SCHOOL IS INCORRECT");

        if (bca.enrolledStudents() == 2) {
            System.out.println("Enrolled Students for school is correct");
        } else {
            System.out.println("ENROLLED STUDENTS FOR SCHOOL IS INCORRECT");
        }

        bca.createClass("Hathaway", "AmerLit2", true);
        Course[] courses = bca.getCourses();
        if (courses[0].getTitle().equals("DataStructs") &&
                courses[1].getTitle().equals("AmerLit2"))
            System.out.println("Get courses for School is correct");
        else
            System.out.println("GET COURSES FOR SCHOOL IS INCORRECT");

        if (bca.enroll(bob, bca.getCourses()[0])) {
            System.out.println("Class Enroll for School is correct");
        } else {
            System.out.println("CLASS ENROLL FOR SCHOOL IS INCORRECT");
        }
        bca.enroll(joe, bca.getCourses()[0]);

        if (bca.getCourses()[0].numberEnrolled() == 2) {
            System.out.println("Number Enrolled for course is correct");
        } else {
            System.out.println("NUMBER ENROLLED FOR COURSE IS INCORRECT");
        }
        if (bca.schoolCourses.length < 300) {
            System.out.println("TOO MANY STUDENTS IN SCHOOL");
        } else {
            System.out.println("Amount of students in school is normal. School courses is correct");
        }
    }
}
