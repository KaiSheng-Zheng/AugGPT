import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        Player winner = null;

        for (Player player : players) {
            if (winner == null) {
                winner = player;
            } else {
                if (player.getScore() > winner.getScore()) {
                    winner = player;
                } else if (player.getScore() == winner.getScore() && player.getSteps() < winner.getSteps()) {
                    winner = player;
                }
            }
        }

        return winner;
    }

}
