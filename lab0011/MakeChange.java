package lab0011;

/**
 * Created by David on 11/12/2015.
 */
public class MakeChange {//use separate file to run like MakeChangeRunner.java

    String makeChange(double money){
        String change;
        int d100, d50, d20, d10, d5, d1, c25, c10, c5, c1;

        d100 = (int) (money / 100);
        money -= (d100 * 100);

        d50 = (int) (money/50);
        money %= 50;

        d20 = (int) (money/20);
        money %= 20;

        d10 = (int) (money/10);
        money %= 10;

        d5 = (int) (money/5);
        money %= 5;

        d1 = (int) (money/1);
        money %= 1;

        money *= 100;

        c25 = (int) (money/25);
        money %= 25;

        c10 = (int) (money/10);
        money %= 10;

        c5 = (int) (money/5);
        money %= 5;

        c1 = (int) money;

        return d100 + " " + d50 + " " + d20 + " " + d10 + " " + d5 + " " + d1 + " " +  c25 + " " + c10 + " " + c5 + " " + c1;
    }

}
