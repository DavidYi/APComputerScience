package lab0111.FantasySports;

import java.util.ArrayList;

/**
 * Created by David on 1/29/2016.
 */
public class FantasyNerd {
    public static void main(String[] args) {
        Player superNerd2 = new Player("SuperNerd2");

        ArrayList<Player> teamWeak = new ArrayList();
        teamWeak.add(new Player("notNerd1"));
        teamWeak.add(new Player("notNerd2"));

        ArrayList<Player> teamMed = new ArrayList();
        teamWeak.add(new Player("nerd1"));
        teamWeak.add(new Player("nerd2"));

        ArrayList<Player> teamStrong = new ArrayList();
        teamStrong.add(new Player("SuperNerd1"));
        teamStrong.add(new Player("SuperNerd1"));

        ArrayList record = new ArrayList();

        Team weak = new Team(teamWeak, new Coach("Cweak"), "Tweak");

        Team strong = new Team(teamStrong, new Coach("Cstrong"), "Tstrong");

        Team mediocre = new Team(teamMed, new Coach("Cmediocre"), "Tmediocre");

        SmartGambler smart = new SmartGambler(1000, record);
        DumbGambler dumb = new DumbGambler(1000, record);


    }
}
