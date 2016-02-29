package lab0001;

import java.util.Scanner;

/**
 * Created by David on 10/18/2015.
 */
public class RepeatRepeatParrot {

    public static void main(String[] args) {
        // scanner gets its input from the console.
        Scanner scanner = new Scanner(System.in);
        // create a memory location for a String called “name” but don’t give it
        // a value!
        String say;

        // Get the user's name.
        System.out.print("What should I say?");
        say = scanner.nextLine();

        // Get the user's number.
        System.out.print("How many times should I say it?");
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println(say);
        }

    }
}
