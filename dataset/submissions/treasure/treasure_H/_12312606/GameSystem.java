import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private Map map;
    private List<Player> players;

    public GameSystem() {
        this.players = new ArrayList<>();
    }

    public Map newGame(int mapRows, int mapColumns, Treasure[] treasures) {
        this.map = new Map(mapRows, mapColumns, treasures);
        return map;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    




    public Player getWinner() {
        Player winner = null;
        int maxScore = Integer.MIN_VALUE;
        int minSteps = Integer.MAX_VALUE;

        for (Player player : players) {
            int score = player.getScore();
            int steps = player.getSteps();

            if (score > maxScore || (score == maxScore && steps < minSteps)) {
                maxScore = score;
                minSteps = steps;
                winner = player;
            }
        }

        return winner;
    }

}

