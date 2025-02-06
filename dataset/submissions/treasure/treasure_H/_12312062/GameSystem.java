import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameSystem {
    private ArrayList<Player> players1=new ArrayList<>();
    private List<Player> players;
    public void addPlayer(Player player) {
        players1.add(player);
    }

    public GameSystem() {
        this.players1 = players1;
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
       /* Player p1=players.get(0);
        for (Player p : players) {

        }*/
        if (players1.isEmpty()) {
            return null;
        }

        // Sort players by score and steps (in case of a tie)
        Collections.sort(players1, Comparator
                .comparing(Player::getScore)
                .reversed()
                .thenComparing(Player::getSteps));

        return players1.get(0); // The first player in the sorted list has the highest score and least steps
    }



}
