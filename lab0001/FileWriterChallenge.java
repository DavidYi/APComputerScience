package lab0001;

import java.io.*;
import java.util.Scanner;

/**
 * Created by David on 10/18/2015.
 */
public class FileWriterChallenge {

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
        String ifile = scanner.nextLine();

        System.out.println("Where is the file I should output?");
        String ofile = scanner.nextLine();

        System.out.println("Give a letter: ");
        String f1 = scanner.nextLine();
        System.out.println("Give a letter: ");
        String s = scanner.nextLine();
        System.out.println("Give a letter: ");
        String t = scanner.nextLine();
        System.out.println("Give a letter: ");
        String f4 = scanner.nextLine();
        try {
            // Point our new friend br to the text file we want to read.
            // Notice that we always use 2 backslashes instead of 1 in the
            // filename!
            br = new BufferedReader(new FileReader(ifile));
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

            // THE REST IS GOBBLEDY-GOOK THAT YOU SHOULD JUST COPY!
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
        // Gobbledy-gook ends here. Proceed with the rest of your code here.
        if (f1.toLowerCase().equals("a")) {
            l1 = a1;
            l2 = a2;
            l3 = a3;
            l4 = a4;
            l5 = a5;
        } else if (f1.toLowerCase().equals("b")) {
            l1 = b1;
            l2 = b2;
            l3 = b3;
            l4 = b4;
            l5 = b5;
        } else {
            l1 = c1;
            l2 = c2;
            l3 = c3;
            l4 = c4;
            l5 = c5;
        }

        if (s.toLowerCase().equals("a")) {
            l1 += "  " + a1;
            l2 += "  " + a2;
            l3 += "  " + a3;
            l4 += "  " + a4;
            l5 += "  " + a5;
        } else if (s.toLowerCase().equals("b")) {
            l1 += "  " + b1;
            l2 += "  " + b2;
            l3 += "  " + b3;
            l4 += "  " + b4;
            l5 += "  " + b5;
        } else {
            l1 += "  " + c1;
            l2 += "  " + c2;
            l3 += "  " + c3;
            l4 += "  " + c4;
            l5 += "  " + c5;
        }

        if (t.toLowerCase().equals("a")) {
            l1 += "  " + a1;
            l2 += "  " + a2;
            l3 += "  " + a3;
            l4 += "  " + a4;
            l5 += "  " + a5;
        } else if (t.toLowerCase().equals("b")) {
            l1 += "  " + b1;
            l2 += "  " + b2;
            l3 += "  " + b3;
            l4 += "  " + b4;
            l5 += "  " + b5;
        } else {
            l1 += "  " + c1;
            l2 += "  " + c2;
            l3 += "  " + c3;
            l4 += "  " + c4;
            l5 += "  " + c5;
        }

        if (f4.toLowerCase().equals("a")) {
            l1 += "  " + a1;
            l2 += "  " + a2;
            l3 += "  " + a3;
            l4 += "  " + a4;
            l5 += "  " + a5;
        } else if (f4.toLowerCase().equals("b")) {
            l1 += "  " + b1;
            l2 += "  " + b2;
            l3 += "  " + b3;
            l4 += "  " + b4;
            l5 += "  " + b5;
        } else {
            l1 += "  " + c1;
            l2 += "  " + c2;
            l3 += "  " + c3;
            l4 += "  " + c4;
            l5 += "  " + c5;
        }
        try {
            // Create a String that we can add later
            // Create a File that we can write to
            File file = new File(ofile);

            // if file doesn't exist, create it!
            if (!file.exists()) {
                file.createNewFile();
            }

            // these 2 lines look crazy, but they create "bw", which we can
            // write to.
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            // Now we can write to bw.
            bw.write(l1);
            bw.newLine();
            bw.write(l2);
            bw.newLine();
            bw.write(l3);
            bw.newLine();
            bw.write(l4);
            bw.newLine();
            bw.write(l5);
            System.out.println("done");
            // Finally, we close the file!
            bw.close();

            // Back to the gobbledy-gook!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
