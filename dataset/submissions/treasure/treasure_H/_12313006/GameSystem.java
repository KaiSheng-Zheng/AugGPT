import java.util.ArrayList;

public class GameSystem {
    Map map;
    ArrayList<Player> players;

    public Map newGame(int rows, int columns, Treasure... treasures) {
        map = new Map(rows, columns, treasures);
        players = new ArrayList<>();
        return map;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getWinner() {
        Player winner = null;
        for (Player player : players) {
            if (winner == null || player.getScore() > winner.getScore() || (winner.getScore() == player.getScore() && player.getSteps() < winner.getSteps())) {
                winner = player;
            }
        }
        return winner;
    }
}
