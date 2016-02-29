package lab0001;

import java.util.Scanner;

/**
 * Created by David on 10/18/2015.
 */
public class Initials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a, b, c;

        System.out.print("What is the 1st letter you want?");
        a = scanner.nextLine();

        System.out.print("What is the 2nd letter you want?");
        b = scanner.nextLine();

        System.out.print("What is the 3rd letter you want?");
        c = scanner.nextLine();

        System.out.println(a + a + a + a + "\t " + b + b + b + "\t" + c + "   " + c);
        System.out.println(a + "   " + a + "\t" + b + "   " + b + "\t " + c +" " + c);
        System.out.println(a + "   " + a + "   " + b + "         " + c);
        System.out.println(a + "   " + a + "   " + b + "   " + b + "\t  " + c);
        System.out.println(a + a + a + a + "\t " + b + b + b +  "\t  " + c);

    }
}
