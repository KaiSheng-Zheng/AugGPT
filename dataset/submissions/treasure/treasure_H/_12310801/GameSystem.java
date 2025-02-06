import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> a;

    public void addPlayer(Player player) {
        a.add(player);
    }
    public Map newGame(int rows, int columns, Treasure[] treasures) {
        return new Map(rows, columns, treasures);
    }
    public GameSystem() {
        a = new ArrayList<>();
    }
    public Player getWinner() {
        Player best = a.get(0);
        for(int i = 1; i < a.size(); i ++) {
            Player tmp = a.get(i);
            if(tmp.getScore() > best.getScore()) {
                best = tmp;
            }
            else if(tmp.getScore() == best.getScore() && tmp.getSteps() < best.getSteps())
                    best = tmp;
        }
        return best;
    }
}
