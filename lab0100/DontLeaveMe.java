package lab0100;

import java.util.Scanner;

/**
 * Created by David on 11/20/2016.
 */
public class DontLeaveMe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = " ";

        while (!s.equals("exit")){
            System.out.print("What should I say?");
            s = input.nextLine();
            if (s.equals("exit")){
                System.out.println("Exiting...");
            }else{
                System.out.println(s);
            }
        }

    }
}
