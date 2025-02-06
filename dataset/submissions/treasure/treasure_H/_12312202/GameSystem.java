import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> players = new ArrayList<Player>();
    private Map map;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        map = new Map(rows, columns, treasures);
        return map;
    }

    public Player getWinner() {
        Player tmp = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getScore() > tmp.getScore())
                tmp = players.get(i);
            else if (players.get(i).getScore() == tmp.getScore() && players.get(i).getSteps() < tmp.getSteps())
                tmp = players.get(i);
        }
        return tmp;
    }
}
