import java.util.ArrayList;

public class GameSystem {
    ArrayList<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
    }
    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows,columns,treasures);
        return map;
    }
    public Player getWinner() {
        Player p=players.get(0);
        for (Player i:players) {
            if (p.compareTo(i)<0) p=i;
        }
        return p;
    }
}
