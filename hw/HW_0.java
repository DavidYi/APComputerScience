package hw;

import java.util.Scanner;

/**
 * This program demonstrates why Java ain't algebra
 *
 * @author TK Rogers
 * @edited by Ben Isecke
 */

/**
 * Created by David on 1/5/2016.
 */
public class HW_0 {

    public static void main(String[] Args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter some text");
        String word = scan.nextLine();
        System.out.println("Enter an integer");
        int num = scan.nextInt();
        int result;
        // Note: the = sign does not mean equals and Java ain't algebra.
        num = num + 1;
        result = num + 1;
        // Try uncommenting the code below and see if the program compiles.
        //num + 1 = result ;
        System.out.println("num = " + num + ", result = " + result); // A
        // Note: in the above line the + operator does arithmatic
        // In the line below, the + operator concatinates.
        System.out.println(word + "  " + num + num); // B
        System.out.println(num + num + "  " + word); // C
        System.out.println(word + "  " + num + num); // D
        System.out.println(word + "  " + num); // E
    }

}
