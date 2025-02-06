import java.util.ArrayList;
import java.util.List;

public class GameSystem {

    private List<Player> players;

    public GameSystem() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows, columns,treasures);
        return map;
    }

    public Player getWinner() {
        Player winner = null;
        int maxScore = 0;
        int minSteps = Integer.MAX_VALUE;

        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
                minSteps = player.getSteps();
                winner = player;
            } else if (player.getScore() == maxScore && player.getSteps() < minSteps) {
                minSteps = player.getSteps();
                winner = player;
            }
        }

        return winner;
    }
}
