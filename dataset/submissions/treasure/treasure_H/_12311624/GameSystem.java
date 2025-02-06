import java.util.AbstractList;
import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> a = new ArrayList<>();
    private Map map;
    public void addPlayer(Player player) {
        a.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        int max = a.get(0).getScore();
        Player winner=a.get(0);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getScore() > max) {
                max = a.get(i).getScore();
                winner = a.get(i);
            } else if (a.get(i).getScore() == max) {
                if (a.get(i).getSteps() < winner.getSteps()) {
                    max = a.get(i).getScore();
                    winner = a.get(i);
                }
            }
        }return winner;
    }
}
