import java.util.*;
public class GameSystem {
    ArrayList<Player> jilu = new ArrayList<>();

    public void addPlayer(Player player) {
        jilu.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map map = new Map(rows, columns, treasures);
        jilu.clear();
        return map;
    }

    public Player getWinner() {
        int max = 0;
        int bushu = 1999999999;
        int pos = 0;
        for (int i = 0; i < jilu.size(); i++) {
            if (jilu.get(i).getScore() > max) {
                max = jilu.get(i).getScore();
                bushu = jilu.get(i).getSteps();
                pos = i;
            } else {
                if (max == jilu.get(i).getScore()) {
                    if ((bushu > jilu.get(i).getSteps())) {
                        bushu = jilu.get(i).getSteps();
                        pos = i;
                    }
                }
            }
        }
        return jilu.get(pos);
    }
}