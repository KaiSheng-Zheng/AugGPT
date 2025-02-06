import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameSystem {
    private ArrayList<Player> players;

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
        Player winner = players.get(0);
        int maxScore = Integer.MIN_VALUE;
        int minSteps = Integer.MAX_VALUE;

        for (Player player : players) {
            if (player.getScore() > maxScore || (player.getScore() == maxScore && player.getSteps() < minSteps)) {
                maxScore = player.getScore();
                minSteps = player.getSteps();
                winner = player;
            }
        }
        return winner;
    }
}
