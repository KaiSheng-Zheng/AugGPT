import java.util.ArrayList;
import java.util.List;

public class GameSystem {

    List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        if (players.isEmpty()) {
            return null;
        }

        Player winner = players.get(0);

        for (int i = 1; i < players.size(); i++) {
            Player currentPlayer = players.get(i);

            if (currentPlayer.getScore() > winner.getScore() ||
                    (currentPlayer.getScore() == winner.getScore() && currentPlayer.getSteps() < winner.getSteps())) {
                winner = currentPlayer;
            }
        }

        return winner;
    }
}
