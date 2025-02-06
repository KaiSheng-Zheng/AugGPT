
import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        players.sort((o1, o2) -> {
            if (o1.getScore() > o2.getScore()) return 1;
            else if (o1.getScore() < o2.getScore()) return -1;
            else return -o1.getSteps() + o2.getSteps();
        });
        return players.get(players.size() - 1);
    }

}
