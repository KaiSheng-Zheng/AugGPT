

import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players;

    public GameSystem() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        Player winner = null;
        int highestScore = Integer.MIN_VALUE;
        int leastSteps = Integer.MAX_VALUE;

        for (Player player : players) {
            if (player.getScore() > highestScore || (player.getScore() == highestScore && player.getSteps() < leastSteps)) {
                highestScore = player.getScore();
                leastSteps = player.getSteps();
                winner = player;
            }
        }
        return winner;
    }
}