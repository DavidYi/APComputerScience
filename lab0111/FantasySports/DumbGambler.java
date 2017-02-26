package lab0111.FantasySports;

/**
 * Created by David on 2/5/2016.
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class DumbGambler implements Gambler {
    double moneyHave;
    ArrayList<String> betRecord;
    Bet currentBet;
    DecimalFormat formatDecimal = new DecimalFormat("#.00");

    public DumbGambler(double moneyHave) {
        this.moneyHave = moneyHave;
        betRecord = new ArrayList();
    }

    @Override
    public Bet gamble(Team team1, Team team2) {
        Team betFor;
        Team betAgainst;
        Random rand = new Random();
        int chooseBet = rand.nextInt(100) + 1;//choose who to bet on
        double moneyBet = Double.parseDouble(formatDecimal.format(moneyHave * rand.nextDouble()));
        if (chooseBet > 50) {
            betFor = team1;
            betAgainst = team2;
        } else{
            betFor = team2;
            betAgainst = team1;
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
    public void win(Bet currentBet){
        String result = "Bet: " + currentBet.getBetFor() + " over " + currentBet.getBetAgainst() +
                "\nResult: Win\t +$" + currentBet.getMoneyBet();
        betRecord.add(result);
        moneyHave += currentBet.getMoneyBet();
        moneyHave = Double.parseDouble(formatDecimal.format(moneyHave));
    }

    @Override
    public void lose(Bet currentBet){
        String result = "Bet: " + currentBet.getBetFor() + " over " + currentBet.getBetAgainst() +
                "\nResult: Lose\t -$" + currentBet.getMoneyBet();
        betRecord.add(result);
        moneyHave -= currentBet.getMoneyBet();
        moneyHave = Double.parseDouble(formatDecimal.format(moneyHave));
    }
}
