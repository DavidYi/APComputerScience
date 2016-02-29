package lab0111.FantasySports;

/**
 * Created by David on 2/5/2016.
 */
public class Bet {
    private double money;
    private Team betted;
    private Team team1;
    private Team team2;

    public Bet(double money, Team betted, Team team1, Team team2) {
        this.betted = betted;
        this.team1 = team1;
        this.team2 = team2;
        this.money = money;
    }
}