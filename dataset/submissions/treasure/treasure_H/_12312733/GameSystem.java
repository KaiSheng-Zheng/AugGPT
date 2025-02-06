import java.util.ArrayList;
import java.util.Collections;

public class GameSystem {
    public GameSystem() {
        this.players = new ArrayList<>();
        this.scores = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    private ArrayList<Player> players;

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public GameSystem(ArrayList<Player> players, ArrayList<Integer> scores) {
        this.players = players;
        this.scores = scores;
    }

    private ArrayList<Integer> scores;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        for (Player player : players) {
            scores.add(player.getScore());
        }
        Collections.sort(scores);
        ArrayList<Integer> steps = new ArrayList<>();
        for (Player player : players) {
            if (player.getScore() == scores.get(scores.size() - 1)) {
                steps.add(player.getSteps());
            }
        }
        Collections.sort(steps);
        Player p = null;
        for (Player player : players) {
            if (player.getScore() == scores.get(scores.size() - 1) && player.getSteps() == steps.get(0)) {
                p = player;
            }
        }
        return p;
    }
}
