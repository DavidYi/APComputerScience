package lab0111.FantasySports;

import java.util.Random;

/**
 * Created by David on 2/5/2016.
 */
public class Coach {

    private int trivia;
    private int lens;
    private int comicKnowledge;
    private int videoGame;
    private int socialAwkwardness;
    private int multiplier;
    String name;

    public Coach(String name, int trivia, int lens, int comicKnowledge, int videoGame, int socialAwkwardness, int multiplier) {
        this.name = name;
        this.trivia = trivia;
        this.lens = lens;
        this.comicKnowledge = comicKnowledge;
        this.videoGame = videoGame;
        this.socialAwkwardness = socialAwkwardness;
        this.multiplier = multiplier;
    }

    public Coach(String nameof) {
        name = nameof;
        trivia = 50;
        lens = 50;
        comicKnowledge = 50;
        socialAwkwardness = 50;
        videoGame = 50;
        multiplier = 3;
    }

    public String getName() {
        return name;
    }

    public int getTrivia() {
        return trivia;
    }

    public int getLens() {
        return lens;
    }

    public int getComicKnowledge() {
        return comicKnowledge;
    }

    public int getVideoGame() {
        return videoGame;
    }

    public int getSocialAwkwardness() {
        return socialAwkwardness;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setTrivia(int triv) {
        trivia = triv;
    }

    public void setLens(int len) {
        lens = len;
    }

    public void setComicBookKnowledge(int knowledge) {
        comicKnowledge = knowledge;
    }

    public void setVideoGame(int videoGame) {
        this.videoGame = videoGame;
    }

    public void setSocialAwkwardness(int socialAwkwardness){
        this.socialAwkwardness = socialAwkwardness;
    }

    public void setMultiplier(int multiplier){
        this.multiplier = multiplier;
    }

    public void setName(String nameof) {
        name = nameof;
    }
}
