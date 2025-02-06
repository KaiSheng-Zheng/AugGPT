import java.util.ArrayList;
import java.util.List;

public class GameSystem {

    private List<Player> players;
    private Map map;

    public GameSystem() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures) {
        map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        Player winner = null;
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