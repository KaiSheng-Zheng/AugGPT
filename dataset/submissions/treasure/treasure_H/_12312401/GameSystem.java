

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
        Map map = new Map(rows, columns, treasures);


        for (Player player : players) {
            player.resetScore();
            player.resetSteps();
        }

        return map;
    }


    public Player getWinner() {
        Player winner = null;
        int highestScore = Integer.MIN_VALUE;
        int leastSteps = Integer.MAX_VALUE;

        for (Player player : players) {
            int score = player.getScore();
            int steps = player.getSteps();

            if (score > highestScore || (score == highestScore && steps < leastSteps)) {
                highestScore = score;
                leastSteps = steps;
                winner = player;
            }
        }

        return winner;
    }
}