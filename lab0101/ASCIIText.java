package lab0101;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by David on 12/14/2015.
 */
public class ASCIIText {

    public static void main(String[] args) {
        BufferedReader br = null;
        Scanner input = new Scanner(System.in);

        String line, key = "", text[], temp = "", finalt = "", letters[][] = {};
        int size = 0, index;

        System.out.print("What font would you like: ");
        String font = input.nextLine();

        System.out.print("Text to print: ");
        String temptext = input.nextLine();
        text = temptext.split("");
        int[] letlocs = new int[text.length];

        try {
            br = new BufferedReader(new FileReader(font));

            br.readLine();
            br.readLine();
            key = br.readLine();
            size = Integer.parseInt(key.substring(0, 1));
            key = key.substring(2);

            letters = new String[key.length()][size];

            for (int i = 0; i < key.length(); i++) {
                br.readLine();
                for (int j = 0; j < size; j++) {
                    letters[i][j] = br.readLine();
                }
            }
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

        for (int i = 0; i < text.length; i++) {
            letlocs[i] = key.indexOf(text[i]);
        }

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < text.length; i++) {
                finalt += letters[letlocs[i]][j];
            }
            finalt += "\n";
        }

        System.out.println(finalt);
    }

}
