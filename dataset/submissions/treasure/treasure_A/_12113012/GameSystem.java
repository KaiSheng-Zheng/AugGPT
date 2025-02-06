import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class GameSystem {
    ArrayList<Player> playersSet = new ArrayList<>();

    public void addPlayer(Player player) {
        playersSet.add(player);
    }

    public Map newGame(int rows, int columns, Treasure... treasures) {
        Map gameMap = new Map(rows, columns, treasures);
        return gameMap;
    }

    public Player getWinner() {
        Comparator<Player> myComparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.getScore() != o2.getScore()) {
                    return o2.getScore() - o1.getScore();
                }
                else {
                    return o1.getTotalStep() - o2.getTotalStep();
                }
            }


        };
        playersSet.sort(myComparator);




        return playersSet.get(0);
    }

}
