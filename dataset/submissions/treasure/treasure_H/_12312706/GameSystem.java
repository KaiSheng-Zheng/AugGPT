import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players = new ArrayList<Player>();
    public void addPlayer(Player player) {
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures) {
        return new Map(rows, columns, treasures);
    }
    public Player getWinner() {
        Player winner = players.get(0);
        for (Player p : players) {
            if (p.getScore() > winner.getScore()) {
                winner = p;
            } else if (p.getScore() == winner.getScore()
                     && p.getSteps() < winner.getSteps()) {
                winner = p;
            }
        }
        return winner;
    }
}
