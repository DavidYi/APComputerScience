package lab0100;

/**
 * Created by David on 11/28/2015.
 */
public class Scrambler {

    String scramble(int addBy, int numTimes, String scrambleThis){
        String[] s = scrambleThis.split(" ");
        String news = "";
        int pos = 0;
        for (int i = 0; i < numTimes; i++){
            news += s[((pos % s.length) + s.length) % s.length] + " ";
            pos += addBy;
        }
        return news;
    }

}
