import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player) {
        players.add(player);

    }

    public Map newGame(int rows, int columns, Treasure[] treasures) {
        this.players.clear();
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        Player a = players.get(0);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).compareTo(a) > 0) a = players.get(i);
        }
        return a;
    }

}
