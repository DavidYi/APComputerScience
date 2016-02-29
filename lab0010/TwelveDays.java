package lab0010;

/**
 * Created by David on 10/29/2015.
 */
public class TwelveDays { //use separate file to run like TwelveDaysRunner.java

    public String singThatSong() {
        String lyrics = "", a = "a";
        for (int day = 1; day <= 12; day++) {
            boolean first = false;
            if (day == 1) {
                lyrics = "On the first day of high school";
                first = true;
            } else if (day == 2) {
                lyrics = "On the second day of high school";
            } else if (day == 3) {
                lyrics = "On the third day of high school";
            } else if (day == 4) {
                lyrics = "On the fourth day of high school";
            } else if (day == 5) {
                lyrics = "On the fifth day of high school";
            } else if (day == 6) {
                lyrics = "On the sixth day of high school";
            } else if (day == 7) {
                lyrics = "On the seventh day of high school";
            } else if (day == 8) {
                lyrics = "On the eighth day of high school";
            } else if (day == 9) {
                lyrics = "On the ninth day of high school";
            } else if (day == 10) {
                lyrics = "On the tenth day of high school";
            } else if (day == 11) {
                lyrics = "On the eleventh day of high school";
            } else if (day == 12) {
                lyrics = "On the twelveth day of high school";
            }
            lyrics += ", my teacher gave to me\n";

            switch (day) {
                case 12:
                    lyrics += "Twelve lunch detentions\n";
                case 11:
                    lyrics += "Eleven vocab lists\n";
                case 10:
                    lyrics += "Ten Practice Problems\n";
                case 9:
                    lyrics += "Nine performance skits\n";
                case 8:
                    lyrics += "Eight examinations\n";
                case 7:
                    lyrics += "Seven lab reports\n";
                case 6:
                    lyrics += "Six chapters' reading\n";
                case 5:
                    lyrics += "Five Shakespeare plays!\n";
                case 4:
                    lyrics += "Four hundred emails\n";
                case 3:
                    lyrics += "Three rough drafts\n";
                case 2:
                    lyrics += "Two problem sets\nAnd ";
                case 1:
                    if (first) {
                        a = "A";
                    }
                    lyrics += (a + " lecture about my workload");
            }
            System.out.println(lyrics);
        }
        return lyrics;
    }

}
