package lab0111.FantasySports;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * Created by David on 2/5/2016.
 */

public class SmartGambler implements Gambler {
    double moneyHave;
    ArrayList betRecord;
    Bet currentBet;
    DecimalFormat formatDecimal = new DecimalFormat("#.00");

    public SmartGambler(double moneyHave) {
        this.moneyHave = moneyHave;
        betRecord = new ArrayList();
    }

    @Override
    public Bet gamble(Team team1, Team team2) {
        double teamDifference;//difference of the strength number between the two teams
        double moneyBet;
        Team betFor;
        Team betAgainst;
        double strengthNumber1 = team1.getstrengthNumber();//strength number of team 1
        double strengthNumber2 = team2.getstrengthNumber();//strength number of team 2
        if (strengthNumber1 >= strengthNumber2) {
            betFor = team1;
            teamDifference = strengthNumber1 - strengthNumber2;
            betAgainst = team2;
        } else {
            betFor = team2;
            betAgainst = team1;
            teamDifference = strengthNumber2 - strengthNumber1;
        }
        if (teamDifference > 75) {
            moneyBet = Double.parseDouble(formatDecimal.format(moneyHave * 0.75));
        } else if (teamDifference < 25) {
            moneyBet = moneyHave * 0.25;
        } else {
            moneyBet = moneyHave * 0.5;
        }
        currentBet = new Bet(moneyBet, betFor, betAgainst);
        return currentBet;
    }

    @Override
    public double getMoneyHave() {
        return moneyHave;
    }

    @Override
    public ArrayList getBetRecord() {
        return betRecord;
    }

    @Override
    public void win(Bet b){
        String result = "Bet: " + b.getBetFor() + " over " + b.getBetAgainst() + "\nResult: Win\t +$" + b.getMoneyBet();
        betRecord.add(result);
        moneyHave += b.getMoneyBet();
        moneyHave = Double.parseDouble(formatDecimal.format(moneyHave));
    }

    @Override
    public void lose(Bet b){
        String result = "Bet: " + b.getBetFor() + " over " + b.getBetAgainst() + "\nResult: Lose\t -$" + b.getMoneyBet();
        betRecord.add(result);
        moneyHave -= b.getMoneyBet();
        moneyHave = Double.parseDouble(formatDecimal.format(moneyHave));
    }
}
