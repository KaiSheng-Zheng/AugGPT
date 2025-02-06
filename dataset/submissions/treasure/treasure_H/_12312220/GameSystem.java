import java.util.ArrayList;

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
        int score = 0;
        int steps = Integer.MAX_VALUE;
        Player P = null;
        for (Player p : players) {
            score = Math.max(score, p.getScore());
        }
        for (Player p : players) {
            if (p.getScore() == score) {
                steps = Math.min(steps, p.getSteps());
            }
        }
        for (Player p : players) {
            if (p.getSteps() == steps) {
                P = p;
            }
        }
        return P;
    }
}
