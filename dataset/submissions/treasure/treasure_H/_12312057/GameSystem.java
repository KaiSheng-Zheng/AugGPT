import java.util.ArrayList;

public class GameSystem {
    private final ArrayList<Player> players;

    public GameSystem() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures) {//Treasure... treasures){
        players.clear();
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        int sco = -1;
        ArrayList<Player> winner = new ArrayList<>();
        for (Player p : players) {
            if (p.getScore() > sco) {
                sco = p.getScore();
                winner.clear();
                winner.add(p);
            } else if (p.getScore() == sco) {
                winner.add(p);
            }
        }
        Player winnerFinal = null;
        if (winner.size() >= 1) {
            int stepnum = Integer.MAX_VALUE;
            for (Player w : winner) {
                if (w.getSteps() < stepnum) {
                    stepnum = w.getSteps();
                    winnerFinal = w;
                }
            }
        }
        return winnerFinal;
    }
}
