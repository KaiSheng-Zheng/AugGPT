import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Map newGame(int rows, int columns, Treasure[] treasures) {
        return new Map(rows, columns, treasures);
    }

    public Player getWinner() {
        int point = players.get(0).getScore();
        int count = 0;
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getScore() > point) {
                point = players.get(i).getScore();
            }
        }
        for (Player player : players) {
            if (player.getScore() == point) {
                count++;
            }
        }
        int[] ct = new int[count];
        int k = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() == point) {
                ct[k] = i;
                k++;
            }
        }
        if (count == 1){
            return players.get(ct[0]);
        }else {
            int gus = players.get(ct[0]).getSteps();
            int num = 0;
            for (int i = 1; i < count; i++) {
                if(players.get(ct[i]).getSteps() < gus){
                    gus = players.get(ct[i]).getSteps();
                    num = i;
                }
            }
            return players.get(ct[num]);
        }



    }
}