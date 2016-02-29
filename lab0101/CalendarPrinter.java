package lab0101;

/**
 * Created by David on 12/14/2015.
 */
public class CalendarPrinter {//use separate file to run like CalendarPrinterRunner.java

    public final String[] nmonth = { "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };
    public final String[] day = { "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };
    public final int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public void printMonth(int year, int month, int janFirst, boolean leapYear) {
        String[][] pMonth = new String[7][7];
        int count = 0, sumDay = 0, dayNum = 1;

        for (int i = 0; i < pMonth.length; i++)
            for (int j = 0; j < pMonth[i].length; j++)
                pMonth[i][j] = " ";

        if (leapYear)
            numDays[1] = 29;
        else
            numDays[1] = 28;

        for (int i = 1; i < month; i++)
            sumDay += numDays[i - 1];

        pMonth[0][1] = nmonth[month - 1] + " " + year;
        int firstDay = (sumDay + janFirst) % 7;

        while (count < pMonth.length) {
            for (int i = 0; i < 7; i++) {
                if (dayNum > numDays[month - 1]) {
                    break;
                }
                if (count == 1)
                    pMonth[count][i] = day[i];
                else if (count >= 2) {
                    if (dayNum > 1) {
                        pMonth[count][i] = dayNum + "";
                        dayNum++;
                    }
                    if ((i == firstDay) && (count == 2)) {
                        pMonth[count][i] = dayNum + "";
                        dayNum++;
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < pMonth.length; i++)
            for (int j = 0; j < pMonth[i].length; j++) {
                System.out.printf("%-3s", pMonth[i][j]);
                if (j == pMonth[i].length - 1)
                    System.out.println();
            }
    }

    public void printYear(int year, int janFirst, boolean leapYear) {
        int sumDay = 0, dayNum = 1, firstDay, firstMon = 0, firstThurs = 0;

        String stringYear = "", stringMonthLine = "";
        String[][][] month = new String[12][6][7];
        if (leapYear)
            numDays[1] = 29;
        else
            numDays[1] = 28;

        stringYear += String.format("%36s\n\n", year + "");

        for (int i = 0; i < month.length; i++)
            for (int j = 0; j < month[i].length; j++)
                for (int k = 0; k < month[i][j].length; k++)
                    month[i][j][k] = "";

        for (int i = 0; i < 12; i++) {
            dayNum = 1;
            firstDay = (sumDay + janFirst) % 7;
            firstMon = 0;
            firstThurs = 0;
            for (int j = 0; j < 6; j++)
                for (int k = 0; k < 7; k++) {// day
                    if (dayNum > numDays[i]) {
                        break;
                    }
                    if (j == 0)
                        month[i][j][k] = day[k];
                    if (j >= 1) {
                        if (dayNum > 1) {
                            if (k == 1)
                                firstMon++;
                            if (k == 4)
                                firstThurs++;

                            month[i][j][k] = dayNum + "";

                            if ((i == 10) && (dayNum == 11))
                                month[i][j][k] = "*v";

                            if ((i == 6) && (dayNum == 4))
                                month[i][j][k] = "*4";

                            if ((i == 11) && (dayNum == 25))
                                month[i][j][k] = "*c";

                            if ((i == 4) && (k == 1) && (j == 5))
                                month[i][j][k] = "*m";

                            if ((i == 10) && (firstThurs == 4) && (k == 4))
                                month[i][j][k] = "*t";

                            if ((i == 3) && (dayNum == 15)) {
                                if (k == 0)
                                    month[i][j][k + 1] = "*x";
                                else if (k == 6)
                                    month[i][j][k + 2] = "*x";
                                else
                                    month[i][j][k] = "*x";
                            }
                            dayNum++;
                        }
                        if ((k == firstDay) && (j == 1)) {
                            if (k == 1)
                                firstMon++;
                            month[i][j][k] = dayNum + "";
                            dayNum++;

                            if (i == 0)
                                month[i][j][k] = "*y";
                        }
                        if ((firstMon == 3) && (i == 1) && (k == 1))
                            month[i][j][k] = "*p";
                        if ((firstMon == 1) && (i == 8) && (k == 1))
                            month[i][j][k] = "*L";
                    }
                }
            sumDay += numDays[i];
        }

        for (int i = 0; i < 12; i += 3) {

            stringMonthLine += formatMonth(i);
            for (int k = 0; k < 6; k++) {// line
                for (int j = i; j < i + 3; j++) {
                    for (int l = 0; l < 7; l++) {
                        stringMonthLine += String.format("%3s", month[j][k][l]);
                    }
                    stringYear += String.format("%s\t", stringMonthLine);
                    stringMonthLine = "";
                }
                stringYear += "\n";
            }
            stringYear += "\n";
        }
        System.out.println(stringYear);
    }

    public String formatMonth(int startMonth) {
        String var = "";

        for (int i = startMonth; i < startMonth + 3; i++) {
            var += center(21, nmonth[i]);
            var += "\t";
        }
        var += "\n";
        return var;
    }
    public String center(int width, String s){
        int pad = (int) Math.ceil((width - s.length())/2);
        int fpad = width - (pad + s.length());
        String mods = "";
        for (int i=0; i<pad; i++)
            mods += " ";
        mods += s;
        for (int i=0; i<fpad; i++)
            mods += " ";

        return mods;
    }

}
