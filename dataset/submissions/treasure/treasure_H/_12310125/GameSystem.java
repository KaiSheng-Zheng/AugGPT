import java.util.ArrayList;

public class GameSystem {
    Map map;
    private ArrayList<Player> players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);

    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        Player winner = players.get(0);
        for (Player p : players) {
            if (p.getScore() > winner.getScore()||(p.getScore() == winner.getScore() && p.getSteps() < winner.getSteps())) {
                winner = p;
            }
        }
        return winner;
    }
}


