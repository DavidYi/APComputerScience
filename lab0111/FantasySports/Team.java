package lab0111.FantasySports;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by David on 2/5/2016.
 */
public class Team {
    private ArrayList<Player> playerList;
    private Coach c;
    public final String name;
    double strengthNumber;

    public Team(ArrayList<Player> playerList, Coach c, String name) {
        this.playerList = playerList;
        this.name = name;
        this.c = c;
        strengthNumber = strengthNumber(this);
    }

    public ArrayList<Player> getPlayers(){
        return playerList;
    }

    double strengthNumber(Team t) {
        double strengthNumber;
        double trivia = 0;
        double lens = 0;
        double comicKnowledge = 0;
        double videoGame = 0;
        double socialAwkwardness = 0;

        for (int i = 0; i < t.playerList.size(); i++) {
            trivia += t.playerList.get(i).getTrivia();
            lens += t.playerList.get(i).getLens();
            comicKnowledge += t.playerList.get(i).getComicKnowledge();
            videoGame += t.playerList.get(i).getVideoGame();
            socialAwkwardness += t.playerList.get(i).getSocialAwkwardness();
        }

        trivia += t.c.getTrivia();
        lens += t.c.getLens();
        comicKnowledge += t.c.getComicKnowledge();
        videoGame += t.c.getVideoGame();
        socialAwkwardness += t.c.getSocialAwkwardness();

        trivia /= t.playerList.size() + 1;
        lens /= t.playerList.size() + 1;
        comicKnowledge /= t.playerList.size() + 1;
        videoGame /= t.playerList.size() + 1;
        socialAwkwardness /= t.playerList.size() + 1;

        strengthNumber = t.c.getMultiplier()
                * (trivia + lens + comicKnowledge + videoGame + socialAwkwardness);
        return strengthNumber;
    }

    public String playGame(Team a) {
        Random rn = new Random();
        double strengthNumberA = strengthNumber(a) * (rn.nextDouble());
        if (strengthNumberA > strengthNumber) {
            return a.name + " has won!";
        } else if (strengthNumber > strengthNumberA) {
            return "Team B has won!";
        } else {
            return "Tie! Both teams are equally nerdy.";

        }
    }
}