package lab0111.FantasySports;

/**
 * Created by David on 2/3/2016.
 */
public class Player {
    private String name;
    private int trivia;
    private int lens;
    private int comicKnowledge;
    private int videoGame;
    private int socialAwkwardness;

    public Player(String name, int trivia, int lens, int comicKnowledge, int videoGame, int socialAwkwardness) {
        this.name = name;
        this.trivia = trivia;
        this.lens = lens;
        this.comicKnowledge = comicKnowledge;
        this.videoGame = videoGame;
        this.socialAwkwardness = socialAwkwardness;
    }

    public Player(String name) {
        this.name = name;
        trivia = 50;
        lens = 50;
        comicKnowledge = 50;
        videoGame = 50;
        socialAwkwardness = 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrivia() {
        return trivia;
    }

    public void setTrivia(int trivia) {
        this.trivia = trivia;
    }

    public int getLens() {
        return lens;
    }

    public void setLens(int lens) {
        this.lens = lens;
    }

    public int getComicKnowledge() {
        return comicKnowledge;
    }

    public void setComicKnowledge(int comicKnowledge) {
        this.comicKnowledge = comicKnowledge;
    }

    public int getVideoGame() {
        return videoGame;
    }

    public void setVideoGame(int videoGame) {
        this.videoGame = videoGame;
    }

    public int getSocialAwkwardness() {
        return socialAwkwardness;
    }

    public void setSocialAwkwardness(int socialAwkwardness) {
        this.socialAwkwardness = socialAwkwardness;
    }
}

