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
        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            if (winner.getScore() != player.getScore() ? winner.getScore() < player.getScore() : winner.getSteps() > player.getSteps())
                winner = player;
        }
        return winner;
    }
}
