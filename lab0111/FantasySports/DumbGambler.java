package lab0111.FantasySports;

/**
 * Created by David on 2/5/2016.
 */

import java.util.ArrayList;

public class DumbGambler implements Gambler {
    double money;
    ArrayList record;
    Bet b;

    public DumbGambler(double money, ArrayList record) {
        this.money = money;
        this.record = record;
    }

    @Override
    public void Gamble(Team team1, Team team2) {
        Team toBet;
        double randNumber = Math.random();
        double moneyBet = money * randNumber;
        randNumber = randNumber * 100;
        double d = randNumber * 100;
        int randomInt = (int) d + 1;
        if (d > 50) toBet = team1;
        else toBet = team2;
        b = new Bet(moneyBet, toBet, team1, team2);
    }

    @Override
    public double money() {
        return money;
    }

    @Override
    public ArrayList record() {
        return record;
    }
}