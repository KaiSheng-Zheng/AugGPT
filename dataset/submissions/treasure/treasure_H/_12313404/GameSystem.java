import java.util.ArrayList;

public class GameSystem {

    private final ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        players.sort((a, b) ->
        {
            var t = -Integer.compare(a.getScore(), b.getScore());
            return t == 0 ? Integer.compare(a.getSteps(), b.getSteps()) : t;
        });
        return players.get(0);
    }

}
