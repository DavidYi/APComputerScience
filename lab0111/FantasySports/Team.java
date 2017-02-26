package lab0111.FantasySports;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by David on 2/5/2016.
 */
public class Team {
    private ArrayList<Player> playerList;
    private Coach coach;
    public final String teamName;

    public Team(ArrayList<Player> playerList, Coach coach, String teamName) {
        this.playerList = playerList;
        this.teamName = teamName;
        this.coach = coach;
    }

    public ArrayList<Player> getPlayers(){
        return playerList;
    }

    public double getstrengthNumber() {
        double strengthNumber, trivia = 0, lens = 0, comicKnowledge = 0, videoGame = 0, socialAwkwardness = 0;

        for (int i = 0; i < playerList.size(); i++) {
            trivia += playerList.get(i).getTrivia();
            lens += playerList.get(i).getLens();
            comicKnowledge += playerList.get(i).getComicKnowledge();
            videoGame += playerList.get(i).getVideoGame();
            socialAwkwardness += playerList.get(i).getSocialAwkwardness();
        }

        trivia += coach.getTrivia();
        lens += coach.getLens();
        comicKnowledge += coach.getComicKnowledge();
        videoGame += coach.getVideoGame();
        socialAwkwardness += coach.getSocialAwkwardness();

        trivia /= (playerList.size() + 1);
        lens /= (playerList.size() + 1);
        comicKnowledge /= (playerList.size() + 1);
        videoGame /= (playerList.size() + 1);
        socialAwkwardness /= (playerList.size() + 1);


        strengthNumber = (coach.getMultiplier()/5 + 1)
                * (trivia + lens + comicKnowledge + videoGame + socialAwkwardness);
        return strengthNumber;
    }

    public Coach getCoach(){
        return coach;
    }
    public void addPlayer(Player player){
        playerList.add(player);
    }

    public void removePlayer(Player player){
        playerList.remove(player);
    }

    public void changeCoach(Coach coach){
        this.coach = coach;
    }

    public Team playGame(Team teamA) {
        Random rn = new Random();
        double winNumber = getstrengthNumber() + rn.nextInt(1000);//winning number for this team
        double winNumberA = teamA.getstrengthNumber() + rn.nextInt(1000); //winning number for team a
        if (winNumberA > winNumber) {
            return teamA;
        } else if (winNumber > winNumberA) {
            return this;
        } else {
            int tiebreaker = rn.nextInt(2);
            if (tiebreaker == 0)
                return teamA;
            else
                return this;
        }
    }
}