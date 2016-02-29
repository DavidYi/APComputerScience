package lab0111.FantasySports;

import java.util.ArrayList;

/**
 * Created by David on 2/5/2016.
 */

public class SmartGambler implements Gambler {
    double money;
    ArrayList record;
    Bet b;

    public SmartGambler(double money, ArrayList record) {
        this.money = money;
        this.record = record;
    }

    @Override
    public void Gamble(Team team1, Team team2) {
        double difference;
        double moneyBet;
        Team toBet;
        if (team1.strengthNumber >= team2.strengthNumber) {
            toBet = team1;
            difference = team1.strengthNumber - team2.strengthNumber;
        } else {
            toBet = team2;
            difference = team2.strengthNumber - team1.strengthNumber;
        }
        if (difference > 75) {
            moneyBet = money * 0.9;
        } else if (difference < 25) {
            moneyBet = money * 0.3;
        } else {
            moneyBet = money * 0.5;
        }
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
