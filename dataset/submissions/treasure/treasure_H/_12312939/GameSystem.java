import java.util.ArrayList;
public class GameSystem {
    ArrayList<Player> players;
    Map map;
    public void addplayer(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(player)) {
                break;
            }
            if (i == players.size() - 1) {
                players.add(player);
            }
        }
    }

    public Map newGame(int rows, int columns, Treasure treasures) {
        if (map == null) {
            map = new Map(rows, columns, treasures);
        }
        return map;
    }

    public Player getwinner() {
        Player winner = players.get(0);
        for (int i = 0; i < players.size(); i++) {
            if (winner.getScore() < players.get(i).getScore()) {
                winner = players.get(i);
            } else if (winner.getScore() == players.get(i).getScore() && winner.getSteps() < players.get(i).getSteps()) {
                winner = players.get(i);
            }
        }
        return winner;
    }
}
