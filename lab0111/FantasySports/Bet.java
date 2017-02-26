package lab0111.FantasySports;

/**
 * Created by David on 2/5/2016.
 */
public class Bet {
    private double moneyBet;
    private Team betFor;
    private Team betAgainst;

    public Bet(double moneyBet, Team betFor, Team betAgainst) {
        this.betFor = betFor;
        this.betAgainst = betAgainst;
        this.moneyBet = moneyBet;
    }

    public double getMoneyBet(){
        return moneyBet;
    }

    public Team getBetFor(){
        return betFor;
    }

    public Team getBetAgainst(){
        return betAgainst;
    }
}