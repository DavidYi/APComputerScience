package lab0111.FantasySports;

import java.util.ArrayList;

/**
 * Created by David on 2/5/2016.
 */

public interface Gambler {
    public void Gamble(Team team1, Team team2);

    public double money();

    public ArrayList record();

}
