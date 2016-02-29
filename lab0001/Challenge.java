package lab0001;

import java.io.*;
import java.util.Scanner;

/**
 * Created by David on 10/18/2015.
 */
public class Challenge {

    public static void main(String[] args) {
        // Create a "BufferedReader" (named "br"), which will let us read a
        // file.
        BufferedReader br = null;
        Scanner scanner = new Scanner(System.in);
        String l1, l2, l3, l4, l5;
        String a1 = "", a2 = "", a3 = "", a4 = "", a5 = "";
        String b1 = "", b2 = "", b3 = "", b4 = "", b5 = "";
        String c1 = "", c2 = "", c3 = "", c4 = "", c5 = "";


        System.out.println("Where is your file?");
        String file = scanner.nextLine();

        System.out.println("Give a letter: ");
        String f1 = scanner.nextLine();
        System.out.println("Give a letter: ");
        String s = scanner.nextLine();
        System.out.println("Give a letter: ");
        String t = scanner.nextLine();
        System.out.println("Give a letter: ");
        String f4 = scanner.nextLine();

        try {
            br = new BufferedReader(
                    new FileReader(file));
            a1 = br.readLine();
            a2 = br.readLine();
            a3 = br.readLine();
            a4 = br.readLine();
            a5 = br.readLine();
            b1 = br.readLine();
            b2 = br.readLine();
            b3 = br.readLine();
            b4 = br.readLine();
            b5 = br.readLine();
            c1 = br.readLine();
            c2 = br.readLine();
            c3 = br.readLine();
            c4 = br.readLine();
            c5 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (f1.toLowerCase().equals("a")){
            l1 = a1;
            l2 = a2;
            l3 = a3;
            l4 = a4;
            l5 = a5;
        }else if (f1.toLowerCase().equals("b")){
            l1 = b1;
            l2 = b2;
            l3 = b3;
            l4 = b4;
            l5 = b5;
        }else{
            l1 = c1;
            l2 = c2;
            l3 = c3;
            l4 = c4;
            l5 = c5;
        }

        if (s.toLowerCase().equals("a")){
            l1 += "  " + a1;
            l2 += "  " + a2;
            l3 += "  " + a3;
            l4 += "  " + a4;
            l5 += "  " + a5;
        }else if (s.toLowerCase().equals("b")){
            l1 += "  " + b1;
            l2 += "  " + b2;
            l3 += "  " + b3;
            l4 += "  " + b4;
            l5 += "  " + b5;
        }else{
            l1 += "  " + c1;
            l2 += "  " + c2;
            l3 += "  " + c3;
            l4 += "  " + c4;
            l5 += "  " + c5;
        }

        if (t.toLowerCase().equals("a")){
            l1 += "  " + a1;
            l2 += "  " + a2;
            l3 += "  " + a3;
            l4 += "  " + a4;
            l5 += "  " + a5;
        }else if (t.toLowerCase().equals("b")){
            l1 += "  " + b1;
            l2 += "  " + b2;
            l3 += "  " + b3;
            l4 += "  " + b4;
            l5 += "  " + b5;
        }else{
            l1 += "  " + c1;
            l2 += "  " + c2;
            l3 += "  " + c3;
            l4 += "  " + c4;
            l5 += "  " + c5;
        }

        if (f4.toLowerCase().equals("a")){
            l1 += "  " + a1;
            l2 += "  " + a2;
            l3 += "  " + a3;
            l4 += "  " + a4;
            l5 += "  " + a5;
        }else if (f4.toLowerCase().equals("b")){
            l1 += "  " + b1;
            l2 += "  " + b2;
            l3 += "  " + b3;
            l4 += "  " + b4;
            l5 += "  " + b5;
        }else{
            l1 += "  " + c1;
            l2 += "  " + c2;
            l3 += "  " + c3;
            l4 += "  " + c4;
            l5 += "  " + c5;
        }

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);
        System.out.println(l5);
    }

}
