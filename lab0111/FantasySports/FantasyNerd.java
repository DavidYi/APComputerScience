package lab0111.FantasySports;

import java.util.ArrayList;

/**
 * Created by David on 1/29/2016.
 */
public class FantasyNerd {
    public static SmartGambler smartGambler = new SmartGambler(1000);
    public static DumbGambler dumbGambler = new DumbGambler(1000);

    public static void simulateGame(Team teamOne, Team teamTwo){
        System.out.println(teamOne.teamName + " vs. " + teamTwo.teamName + "!!!!\n");
        Bet smartBet = smartGambler.gamble(teamOne, teamTwo);
        Bet dumbBet = dumbGambler.gamble(teamOne, teamTwo);
        System.out.println("SmartGambler bet on " + smartBet.getBetFor().teamName + " for $" + smartBet.getMoneyBet());
        System.out.println("DumbGambler bet on " + dumbBet.getBetFor().teamName + " for $" + dumbBet.getMoneyBet());
        Team winner = teamOne.playGame(teamTwo);

        System.out.println();

        System.out.println("The winner is " + winner.teamName);

        System.out.println();

        if (smartBet.getBetFor().equals(winner)) {
            System.out.println("SmartGambler won his bet.");
            smartGambler.win(smartBet);
        } else {
            System.out.println("Smart Gambler lost his bet.");
            smartGambler.lose(smartBet);
        }

        System.out.println();

        if (dumbBet.getBetFor().equals(winner)){
            System.out.println("Dumb Gambler won his bet.");
            dumbGambler.win(dumbBet);
        } else {
            System.out.println("Dumb Gambler lost his bet.");
            dumbGambler.lose(dumbBet);
        }

        System.out.println();

        System.out.println("Smart Gambler has $" + smartGambler.getMoneyHave() + " left");
        System.out.println("Dumb Gambler has $" + dumbGambler.getMoneyHave() + " left");

    }
    public static void main(String[] args) {
        Player superNerd1 = new Player("SuperNerd1", 80, 80, 80, 80, 80);
        Player superNerd2 = new Player("SuperNerd2");

        superNerd2.setComicKnowledge(80);

        System.out.println("Test 1");//testing to see if the get and set of Player class works
        if (superNerd1.getComicKnowledge() == 80 && superNerd1.getLens() == 80 &&  superNerd1.getName().equals("SuperNerd1")
                && superNerd1.getSocialAwkwardness() == 80 && superNerd1.getTrivia() == 80 &&
                superNerd1.getVideoGame() == 80)
            System.out.println("Passed");
        else
            System.out.println("Failed");

        System.out.println();

        superNerd2.setLens(80);
        superNerd2.setSocialAwkwardness(80);
        superNerd2.setTrivia(80);
        superNerd2.setVideoGame(80);

        Player notNerd1 = new Player("notNerd1");
        Player notNerd2 = new Player("notNerd1");

        notNerd1.setComicKnowledge(30);
        notNerd2.setComicKnowledge(30);
        notNerd1.setLens(30);
        notNerd2.setLens(30);
        notNerd1.setSocialAwkwardness(30);
        notNerd2.setSocialAwkwardness(30);
        notNerd1.setTrivia(30);
        notNerd2.setTrivia(30);
        notNerd1.setVideoGame(30);
        notNerd2.setVideoGame(30);


        Player nerd2 = new Player("nerd2");//has default stats
        Player nerd1 = new Player("nerd1");//has default stats
        Player nerd3 = new Player("nerd3");//to test the addPlayer functionality

        Coach badC = new Coach("bad");
        badC.setTrivia(30);
        badC.setLens(30);
        badC.setComicBookKnowledge(30);
        badC.setVideoGame(30);
        badC.setSocialAwkwardness(30);
        badC.setMultiplier(2);

        Coach goodC = new Coach("good");
        goodC.setTrivia(70);
        goodC.setLens(70);
        goodC.setComicBookKnowledge(70);
        goodC.setVideoGame(70);
        goodC.setSocialAwkwardness(70);
        goodC.setMultiplier(4);

        Coach okC = new Coach("ok");//has default stats
        Coach okC2 = new Coach("ok2");//to test the change coach functionality

        ArrayList<Player> teamBadRoster = new ArrayList();
        teamBadRoster.add(notNerd1);
        teamBadRoster.add(notNerd2);

        ArrayList<Player> teamOkRoster = new ArrayList();
        teamOkRoster.add(nerd1);
        teamOkRoster.add(nerd2);

        ArrayList<Player> teamGoodRoster = new ArrayList();
        teamGoodRoster.add(superNerd1);
        teamGoodRoster.add(superNerd2);

        Team weak = new Team(teamBadRoster, badC, "Tbad");

        System.out.println("Test 2");//testing the getPlayer functionality
        if (weak.getPlayers().equals(teamBadRoster))
            System.out.println("Passed");
        else
            System.out.println("Failed");

        System.out.println();

        Team strong = new Team(teamGoodRoster, goodC, "Tgood");

        Team ok = new Team(teamOkRoster, okC, "Tok");


        System.out.println("Test 3");//testing the changeCoach and getCoach functionality
        ok.changeCoach(okC2);
        if (ok.getCoach().equals(okC2))
            System.out.println("Passed");
        else
            System.out.println("Failed");

        System.out.println();

        System.out.println("Test 4");//testing the removePlayer functionality
        ok.removePlayer(nerd2);
        teamOkRoster.remove(nerd2);
        if (ok.getPlayers().equals(teamOkRoster))
            System.out.println("Passed");
        else
            System.out.println("Failed");

        System.out.println();

        System.out.println("Test 5");//testing the addPlayer functionality
        ok.addPlayer(nerd3);
        teamOkRoster.add(nerd3);
        if (ok.getPlayers().equals(teamOkRoster))
            System.out.println("Passed");
        else
            System.out.println("Failed");

        System.out.println();

        System.out.println("Test 6");//testing the general functionality of getstrengthNumber
        double oldSN = ok.getstrengthNumber();
        ok.changeCoach(goodC);
        if (ok.getstrengthNumber() > oldSN)
            System.out.println("Passed");
        else
            System.out.println("Failed");

        System.out.println();

        System.out.println("Test 7");//testing get gamble method for smartGambler gambler
        Bet betSmart = smartGambler.gamble(weak, strong);
        if (betSmart.getBetFor().teamName.equals(strong.teamName)
                && betSmart.getBetAgainst().teamName.equals(weak.teamName))
            System.out.println("Passed");
        else
            System.out.println("Failed");

        System.out.println();

        Team winner = weak.playGame(strong);
        System.out.println("Test 8");//testing to see general functionality of playGame
        if (winner.equals(strong) || winner.equals(weak))
            System.out.println("Passed");
        else
            System.out.println("Failed");


        System.out.println();

        System.out.println("Simulating games ...");
        System.out.println("Game 1");
        simulateGame(weak, strong);

        System.out.println();

        System.out.println("Game 2");
        simulateGame(weak, strong);

        System.out.println();

        System.out.println("Game 3");
        simulateGame(weak, strong);

        System.out.println();

        System.out.println("Game 4");
        simulateGame(weak, strong);

        System.out.println();
        System.out.println();

        System.out.println("Game 1");
        simulateGame(weak, ok);

        System.out.println();

        System.out.println("Game 2");
        simulateGame(weak, ok);

        System.out.println();

        System.out.println("Game 3");
        simulateGame(weak, ok);

        System.out.println();

        System.out.println("Game 4");
        simulateGame(weak, ok);

        System.out.println();
        System.out.println();

        System.out.println("Game 1");
        simulateGame(ok, strong);

        System.out.println();

        System.out.println("Game 2");
        simulateGame(ok, strong);

        System.out.println();

        System.out.println("Game 3");
        simulateGame(ok, strong);

        System.out.println();

        System.out.println("Game 4");
        simulateGame(ok, strong);

    }
}
